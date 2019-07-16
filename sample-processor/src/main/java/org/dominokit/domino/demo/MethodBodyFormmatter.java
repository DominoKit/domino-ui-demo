package org.dominokit.domino.demo;


import com.google.googlejavaformat.java.Formatter;
import com.google.googlejavaformat.java.FormatterException;

public class MethodBodyFormmatter {

    private static final String BEGIN = "package org.dominokit.domino.preloaders.client.views.ui;\n" +
            "public class SampleWrapper {\n" +
            "\n" +
            "    public void sampleSizes() {\n" +
            "//start\n";

    private static final String END = "\n//end\n" +
            "    }\n" +
            "}\n";

    public static final String format(String methodBody) {
        String bodyAsClass = BEGIN +
                methodBody.substring(1, methodBody.length() - 1) +
                END;

        try {
            String formattedClass = new Formatter().formatSource(bodyAsClass);
            return formattedClass.substring(formattedClass.indexOf("// start")+"// start".length(), formattedClass.indexOf("// end"))
                    .trim();
        } catch (FormatterException e) {
            e.printStackTrace();
        }

        return methodBody;
    }
}
