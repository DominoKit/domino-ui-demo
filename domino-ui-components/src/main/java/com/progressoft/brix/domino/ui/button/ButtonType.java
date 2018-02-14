package com.progressoft.brix.domino.ui.button;

public enum ButtonType {
    DEFAULT("default"),
    PRIMARY("primary"),
    SUCCESS("success"),
    INFO("info"),
    WARNING("warning"),
    DANGER("danger");

    private String style;

    ButtonType(String style) {
        this.style = style;
    }

    public String getStyle() {
        return style;
    }
}
