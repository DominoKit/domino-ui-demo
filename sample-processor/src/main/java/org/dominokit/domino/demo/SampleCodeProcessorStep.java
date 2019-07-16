/*
 * Copyright © 2018 The GWT Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.dominokit.domino.demo;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ExternalTextResource;
import com.squareup.javapoet.*;
import com.sun.source.tree.MethodTree;
import com.sun.source.util.Trees;
import org.apache.commons.io.IOUtils;
import org.dominokit.domino.SampleMethod;
import org.dominokit.domino.apt.commons.AbstractProcessingStep;
import org.dominokit.domino.apt.commons.DominoTypeBuilder;
import org.dominokit.domino.apt.commons.ExceptionUtil;
import org.dominokit.domino.apt.commons.StepBuilder;

import javax.annotation.processing.ProcessingEnvironment;
import javax.lang.model.element.*;
import javax.tools.Diagnostic;
import javax.tools.FileObject;
import javax.tools.StandardLocation;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Collections;
import java.util.Set;

import static java.util.Objects.nonNull;

public class SampleCodeProcessorStep extends AbstractProcessingStep {

    private final Trees trees;

    public SampleCodeProcessorStep(ProcessingEnvironment processingEnv) {
        super(processingEnv);
        this.trees = Trees.instance(processingEnv);
    }

    public static class Builder extends StepBuilder<SampleCodeProcessorStep> {
        public SampleCodeProcessorStep build() {
            return new SampleCodeProcessorStep(processingEnv);
        }
    }

    @Override
    public void process(Set<? extends Element> elementsByAnnotation) {

        for (Element element : elementsByAnnotation) {
            try {
                TypeElement clazz = (TypeElement) element;

                TypeSpec.Builder codeResource = DominoTypeBuilder.interfaceBuilder("CodeResource", SampleCodeProcessor.class)
                        .addSuperinterface(ClientBundle.class)
                        .addModifiers(Modifier.PUBLIC);
                ClassName elementType = ClassName.bestGuess(elements.getPackageOf(element).getQualifiedName().toString() + ".CodeResource");
                codeResource.addField(FieldSpec.builder(elementType, "INSTANCE")
                        .addModifiers(Modifier.PUBLIC, Modifier.STATIC, Modifier.FINAL)
                        .initializer("$T.create($T.class)", GWT.class, elementType)
                        .build());

                clazz.getEnclosedElements()
                        .stream()
                        .filter(e -> e.getKind().equals(ElementKind.METHOD))
                        .filter(e -> nonNull(e.getAnnotation(SampleMethod.class)))
                        .map(e -> (ExecutableElement) e)
                        .forEach(method -> {
                            codeResource.addMethod(MethodSpec.methodBuilder(method.getSimpleName().toString())
                                    .addAnnotation(AnnotationSpec.builder(ClientBundle.Source.class)
                                            .addMember("value", "$S", method.getSimpleName().toString() + ".txt")
                                            .build())
                                    .addModifiers(Modifier.PUBLIC, Modifier.ABSTRACT)
                                    .returns(ExternalTextResource.class)
                                    .build());

                            MethodTree methodTree = new MethodScanner().scan(method, trees);
                            try {
                                messager.printMessage(Diagnostic.Kind.NOTE, "WRITING SMAPLE CODE FOR  : "+method.getSimpleName());
                                FileObject resource = filer.createResource(StandardLocation.SOURCE_OUTPUT, elements.getPackageOf(element).getQualifiedName().toString(), method.getSimpleName().toString() + ".txt");
                                OutputStream outputStream = resource.openOutputStream();

                                IOUtils.write(MethodBodyFormmatter.format(methodTree.getBody().toString()), outputStream);
                                outputStream.close();
                            } catch (IOException e) {
                                ExceptionUtil.messageStackTrace(messager, e, method);
                            }
                        });

                writeSource(Collections.singletonList(codeResource), elements.getPackageOf(element).getQualifiedName().toString());


            } catch (Exception e) {
                ExceptionUtil.messageStackTrace(messager, e, element);
            }
        }
    }
}
