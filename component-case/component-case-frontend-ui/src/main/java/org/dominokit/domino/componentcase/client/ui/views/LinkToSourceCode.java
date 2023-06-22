package org.dominokit.domino.componentcase.client.ui.views;

import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.icons.lib.Icons;
import org.dominokit.domino.ui.style.Elevation;
import org.dominokit.domino.ui.utils.BaseDominoElement;

public class LinkToSourceCode extends BaseDominoElement<HTMLDivElement, LinkToSourceCode> {

    private DivElement element = div().css("open-source", "bg-theme", Elevation.LEVEL_1.getStyle())
            .appendChild(Icons.codepen())
            .appendChild(span().textContent("Source code"));

    public LinkToSourceCode(String moduleName, Class impl) {
        String fullClassName = impl.getCanonicalName().replace(".", "/") + ".java";
        element.addEventListener("click", evt -> {
            DomGlobal.window.open("https://github.com/DominoKit/domino-ui-demo/blob/master/" + moduleName +
                    "/src/main/java/" + fullClassName);
        });
    }

    public static LinkToSourceCode createLink(String moduleName, Class impl) {
        return new LinkToSourceCode(moduleName, impl);
    }

    @Override
    public HTMLDivElement element() {
        return element.element();
    }
}
