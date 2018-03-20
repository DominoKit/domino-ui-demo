package org.dominokit.domino.componentcase.shared.extension;

import org.dominokit.domino.api.shared.extension.Content;

public interface ComponentCase {
    String getHistoryToken();
    String getMenuPath();
    default boolean hasContent(){return true;}
    default String getIconName(){return "";}
    default Content getContent(){return null;}
    default ComponentRevealedHandler onComponentRevealed(){return () -> {};}
    default ComponentRemoveHandler onComponentRemoved(){return ()->{};}

    @FunctionalInterface
    interface ComponentRevealedHandler{
        void onRevealed();
    }

    @FunctionalInterface
    interface ComponentRemoveHandler{
        void onBeforeRemove();
    }
}
