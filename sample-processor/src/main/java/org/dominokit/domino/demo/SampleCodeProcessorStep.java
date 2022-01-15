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

import com.github.javaparser.JavaParser;
import com.github.javaparser.ParseResult;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;
import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ExternalTextResource;
import com.squareup.javapoet.AnnotationSpec;
import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.FieldSpec;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeSpec;
import org.apache.commons.io.IOUtils;
import org.dominokit.domino.SampleMethod;
import org.dominokit.domino.apt.commons.AbstractProcessingStep;
import org.dominokit.domino.apt.commons.DominoTypeBuilder;
import org.dominokit.domino.apt.commons.ExceptionUtil;
import org.dominokit.domino.apt.commons.StepBuilder;

import javax.annotation.processing.ProcessingEnvironment;
import javax.lang.model.element.Element;
import javax.lang.model.element.Modifier;
import javax.tools.Diagnostic;
import javax.tools.FileObject;
import javax.tools.StandardLocation;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class SampleCodeProcessorStep extends AbstractProcessingStep {

    public SampleCodeProcessorStep(ProcessingEnvironment processingEnv) {
        super(processingEnv);
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
                InputStream in = null;
                try {
                    final FileObject tempResource;
                    tempResource = filer.createResource(StandardLocation.SOURCE_OUTPUT, "", "ignore.tmp");
                    final URI uri = tempResource.toUri();
                    Path path = Paths.get(uri);
                    while (!path.endsWith("target") && !path.toAbsolutePath().toString().equals("/")) {
                        path = path.getParent();
                    }
                    if (path.endsWith("target")) {
                        List<String> paths = new ArrayList<>();
                        paths.addAll(Arrays.asList("src", "main", "java"));
                        paths.addAll(Arrays.asList(elements.getPackageOf(element).getQualifiedName().toString().split("\\.")));
                        paths.add(element.getSimpleName().toString() + ".java");
                        String[] pathsArray = new String[paths.size()];
                        paths.toArray(pathsArray);

                        TypeSpec.Builder codeResource = DominoTypeBuilder.interfaceBuilder("CodeResource", SampleCodeProcessor.class)
                                .addSuperinterface(ClientBundle.class)
                                .addModifiers(Modifier.PUBLIC);
                        ClassName elementType = ClassName.bestGuess(elements.getPackageOf(element).getQualifiedName().toString() + ".CodeResource");
                        codeResource.addField(FieldSpec.builder(elementType, "INSTANCE")
                                .addModifiers(Modifier.PUBLIC, Modifier.STATIC, Modifier.FINAL)
                                .initializer("$T.create($T.class)", GWT.class, elementType)
                                .build());

                        path = Paths.get(path.getParent().toAbsolutePath().toString(), pathsArray);
                        if (path.toFile().exists()) {
                            JavaParser parser = new JavaParser();
                            in = new FileInputStream(path.toFile());
                            ParseResult<CompilationUnit> parse = parser.parse(in);
                            parse.ifSuccessful(compilationUnit -> {
                                new VoidVisitorAdapter<Object>(){

                                    @Override
                                    public void visit(MethodDeclaration methodDeclaration, Object arg) {
                                        methodDeclaration.getAnnotationByClass(SampleMethod.class).ifPresent(annotationExpr -> {
                                            methodDeclaration.getBody().ifPresent(blockStmt -> {
                                                String methodName = methodDeclaration.getName().toString();
                                                codeResource.addMethod(MethodSpec.methodBuilder(methodName)
                                                        .addAnnotation(AnnotationSpec.builder(ClientBundle.Source.class)
                                                                .addMember("value", "$S", methodName + ".txt")
                                                                .build())
                                                        .addModifiers(Modifier.PUBLIC, Modifier.ABSTRACT)
                                                        .returns(ExternalTextResource.class)
                                                        .build());

                                                try {
                                                    FileObject resource = filer.createResource(StandardLocation.SOURCE_OUTPUT, elements.getPackageOf(element).getQualifiedName().toString(), methodName + ".txt");
                                                    OutputStream outputStream = resource.openOutputStream();

                                                    IOUtils.write(MethodBodyFormmatter.format(blockStmt.toString()), outputStream);
                                                    outputStream.close();
                                                } catch (IOException e) {
                                                    ExceptionUtil.messageStackTrace(messager, e, element);
                                                }
                                            });
                                        });

                                    }
                                }.visit(compilationUnit, null);
                            });
                        }



                        writeSource(Collections.singletonList(codeResource), elements.getPackageOf(element).getQualifiedName().toString());



                    }

                } catch (Exception ex) {
                    ExceptionUtil.messageStackTrace(messager, ex, element);
                } finally {
                    in.close();
                }


            } catch (Exception e) {
                ExceptionUtil.messageStackTrace(messager, e, element);
            }
        }
    }
}
