package org.dominokit.domino.dropdown.client.views.ui;

import elemental2.dom.HTMLElement;
import org.dominokit.domino.ui.utils.DominoElement;

/** The strategy for appending the menu to the target element */
  @FunctionalInterface
  public interface AppendStrategy {
    /**
     * Will be called to append the menu to the target element
     *
     * @param target the target element
     * @param menu the menu element
     */
    void onAppend(HTMLElement target, HTMLElement menu);

    /**
     * {@code FIRST} strategy means that the menu will be added at the first index of the target
     * element
     */
    AppendStrategy FIRST = (target, menu) -> DominoElement.of(target).insertFirst(menu);
    /**
     * {@code LAST} strategy means that the menu will be added at the last index of the target
     * element
     */
    AppendStrategy LAST = (target, menu) -> DominoElement.of(target).appendChild(menu);
  }