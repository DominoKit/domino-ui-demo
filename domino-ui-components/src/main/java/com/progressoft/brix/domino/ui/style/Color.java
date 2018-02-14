package com.progressoft.brix.domino.ui.style;

public enum Color {

    RED("col-red"),
    PINK("col-pink"),
    PURPLE("col-purple"),
    DEEP_PURPLE("col-deep-purple"),
    INDIGO("col-indigo"),
    BLUE("col-blue"),
    LIGHT_BLUE("col-light-blue"),
    CYAN("col-cyan"),
    TEAL("col-teal"),
    GREEN("col-green"),
    LIGHT_GREEN("col-light-green"),
    LIME("col-lime"),
    YELLOW("col-yellow"),
    AMBER("col-amber"),
    ORANGE("col-orange"),
    DEEP_ORANGE("col-deep-orange"),
    BROWN("col-brown"),
    GREY("col-grey"),
    BLUE_GREY("col-blue-grey"),
    BLACK("col-black"),
    WHITE("col-white");

    private final String style;

    Color(String style) {
        this.style=style;
    }

    public String getStyle() {
        return style;
    }
}
