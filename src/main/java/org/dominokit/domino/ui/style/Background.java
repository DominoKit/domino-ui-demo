package org.dominokit.domino.ui.style;

public enum Background {

    RED("bg-red"),
    PINK("bg-pink"),
    PURPLE("bg-purple"),
    DEEP_PURPLE("bg-deep-purple"),
    INDIGO("bg-indigo"),
    BLUE("bg-blue"),
    LIGHT_BLUE("bg-light-blue"),
    CYAN("bg-cyan"),
    TEAL("bg-teal"),
    GREEN("bg-green"),
    LIGHT_GREEN("bg-light-green"),
    LIME("bg-lime"),
    YELLOW("bg-yellow"),
    AMBER("bg-amber"),
    ORANGE("bg-orange"),
    DEEP_ORANGE("bg-deep-orange"),
    BROWN("bg-brown"),
    GREY("bg-grey"),
    BLUE_GREY("bg-blue-grey"),
    BLACK("bg-black"),
    WHITE("bg-white"),
    THEME("bg-theme");

    private final String style;

    Background(String style) {
        this.style = style;
    }

    public String getStyle() {
        return style;
    }

    public Background darker() {
        switch (this) {
            case RED:
                return PINK;
            case BLUE:
                return INDIGO;
            case CYAN:
                return LIGHT_BLUE;
            case GREY:
                return BLUE_GREY;
            case LIME:
                return LIGHT_GREEN;
            case PINK:
                return RED;
            case TEAL:
                return GREEN;
            case AMBER:
                return ORANGE;
            case BLACK:
                return BLACK;
            case BROWN:
                return BROWN;
            case GREEN:
                return TEAL;
            case WHITE:
                return WHITE;
            case INDIGO:
                return BLUE_GREY;
            case ORANGE:
                return DEEP_ORANGE;
            case PURPLE:
                return DEEP_PURPLE;
            case YELLOW:
                return LIME;
            case BLUE_GREY:
                return GREY;
            case LIGHT_BLUE:
                return BLUE;
            case DEEP_ORANGE:
                return ORANGE;
            case DEEP_PURPLE:
                return PURPLE;
            case LIGHT_GREEN:
                return GREEN;
            case THEME:
                return this;
            default:
                return this;

        }
    }
}
