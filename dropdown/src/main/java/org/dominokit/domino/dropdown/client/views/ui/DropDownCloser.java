package org.dominokit.domino.dropdown.client.views.ui;

import elemental2.dom.Element;
import elemental2.dom.HTMLElement;
import elemental2.dom.NodeList;
import jsinterop.base.Js;
import org.dominokit.domino.ui.dropdown.DropDownMenu;
import org.jboss.elemento.EventType;

import static elemental2.dom.DomGlobal.document;

public class DropDownCloser {

    public static final String DOMINO_UI_AUTO_CLOSABLE = "domino-ui-auto-closable";
    private static boolean touchMoved;

    static {
        document.addEventListener(EventType.click.getName(), evt -> DropDownMenu.closeAllMenus());
        document.addEventListener(EventType.touchmove.getName(), evt -> touchMoved = true);
        document.addEventListener(
                EventType.touchend.getName(),
                evt -> {
                    if (!touchMoved) {
                        closeDropdowns();
                    }
                    touchMoved = false;
                });
    }

    public static void closeDropdowns() {
        NodeList<Element> elementsByName = document.body.querySelectorAll("[" + DOMINO_UI_AUTO_CLOSABLE + "]");
        for (int i = 0; i < elementsByName.length; i++) {
            HTMLElement element = Js.uncheckedCast(elementsByName.item(i));
            element.remove();
        }
    }
}
