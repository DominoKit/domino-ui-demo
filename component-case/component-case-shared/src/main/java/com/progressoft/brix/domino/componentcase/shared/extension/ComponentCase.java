package com.progressoft.brix.domino.componentcase.shared.extension;

import com.progressoft.brix.domino.api.shared.extension.Content;

public interface ComponentCase {
    String getHistoryToken();
    String getMenuPath();
    default boolean hasContent(){return true;}
    default String getIconName(){return "";}
    default void showIn(Content content){}
}
