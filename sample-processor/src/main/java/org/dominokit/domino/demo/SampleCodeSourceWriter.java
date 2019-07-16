package org.dominokit.domino.demo;

import com.squareup.javapoet.TypeSpec;
import org.dominokit.domino.apt.commons.AbstractSourceBuilder;

import javax.annotation.processing.ProcessingEnvironment;
import java.util.ArrayList;
import java.util.List;

public class SampleCodeSourceWriter extends AbstractSourceBuilder {

    protected SampleCodeSourceWriter(ProcessingEnvironment processingEnv) {
        super(processingEnv);
    }

    @Override
    public List<TypeSpec.Builder> asTypeBuilder() {
        List<TypeSpec.Builder> types = new ArrayList<>();
        return types;
    }
}
