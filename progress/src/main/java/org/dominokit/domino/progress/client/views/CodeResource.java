package org.dominokit.domino.progress.client.views;

public class CodeResource {

    public static String basicSample() {
        return "movingBar = ProgressBar.create(1000);\n" +
                "//we are doing this since we want to move the progress for the demo,\n" +
                "// in real use cases progress bar value increases by some data feedback.\n" +
                "movingBar.asElement().style.setProperty(\"transition\", \"width 500ms linear\", \"important\");\n" +
                "\n" +
                "element.appendChild(Card.create(\"BASIC EXAMPLES\")\n" +
                "        .appendContent(Progress.create()\n" +
                "                .addBar(ProgressBar.create(100)\n" +
                "                        .setValue(90))\n" +
                "                .asElement())\n" +
                "        .appendContent(Progress.create()\n" +
                "                .addBar(ProgressBar.create(100)\n" +
                "                        .showText()\n" +
                "                        .setValue(60))\n" +
                "                .asElement())\n" +
                "        .appendContent(Progress.create()\n" +
                "                .addBar(ProgressBar.create(100)\n" +
                "                        .showText()\n" +
                "                        .textExpression(\"{value} out of {maxValue} completed\")\n" +
                "                        .setValue(75))\n" +
                "                .asElement())\n" +
                "        .appendContent(Progress.create()\n" +
                "                .addBar(ProgressBar.create(100)\n" +
                "                        .showText()\n" +
                "                        .textExpression(\"{value} out of {maxValue} completed\")\n" +
                "                        .setValue(40))\n" +
                "                .asElement())\n" +
                "        .appendContent(Progress.create()\n" +
                "                .addBar(movingBar)\n" +
                "                .asElement())\n" +
                "        .asElement());\n" +
                "\n" +
                "animationFrameCallback = p0 -> {\n" +
                "    if (movingBar.getValue() >= movingBar.getMaxValue()) {\n" +
                "        movingBar.textExpression(\"Done\");\n" +
                "    } else\n" +
                "        movingBar.setValue(movingBar.getValue() + 1);\n" +
                "\n" +
                "    animationFrame = DomGlobal.requestAnimationFrame(animationFrameCallback);\n" +
                "};";
    }

    public static String contextualAlternatives() {
        return "element.appendChild(Card.create(\"CONTEXTUAL ALTERNATIVES\", \"Progress bars use some of the same button and alert classes for consistent styles.\")\n" +
                "        .appendContent(Progress.create()\n" +
                "                .addBar(ProgressBar.create(100)\n" +
                "                        .showText()\n" +
                "                        .success()\n" +
                "                        .setValue(80))\n" +
                "                .asElement())\n" +
                "        .appendContent(Progress.create()\n" +
                "                .addBar(ProgressBar.create(100)\n" +
                "                        .showText()\n" +
                "                        .warning()\n" +
                "                        .setValue(60))\n" +
                "                .asElement())\n" +
                "        .appendContent(Progress.create()\n" +
                "                .addBar(ProgressBar.create(100)\n" +
                "                        .showText()\n" +
                "                        .info()\n" +
                "                        .setValue(70))\n" +
                "                .asElement())\n" +
                "        .appendContent(Progress.create()\n" +
                "                .addBar(ProgressBar.create(100)\n" +
                "                        .showText()\n" +
                "                        .danger()\n" +
                "                        .setValue(30))\n" +
                "                .asElement())\n" +
                "        .asElement());";
    }

    public static String stripedSample() {
        return "element.appendChild(Card.create(\"STRIPED\", \"Uses a gradient to create a striped effect.\")\n" +
                "        .appendContent(Progress.create()\n" +
                "                .addBar(ProgressBar.create(100)\n" +
                "                        .striped()\n" +
                "                        .success()\n" +
                "                        .setValue(80))\n" +
                "                .asElement())\n" +
                "        .appendContent(Progress.create()\n" +
                "                .addBar(ProgressBar.create(100)\n" +
                "                        .striped()\n" +
                "                        .warning()\n" +
                "                        .setValue(60))\n" +
                "                .asElement())\n" +
                "        .appendContent(Progress.create()\n" +
                "                .addBar(ProgressBar.create(100)\n" +
                "                        .striped()\n" +
                "                        .info()\n" +
                "                        .setValue(70))\n" +
                "                .asElement())\n" +
                "        .appendContent(Progress.create()\n" +
                "                .addBar(ProgressBar.create(100)\n" +
                "                        .striped()\n" +
                "                        .danger()\n" +
                "                        .setValue(30))\n" +
                "                .asElement())\n" +
                "        .asElement());";
    }

    public static String animatedSample() {
        return "element.appendChild(Card.create(\"ANIMATED\", \"Animating the bar will add stripes by default.\")\n" +
                "        .appendContent(Progress.create()\n" +
                "                .addBar(ProgressBar.create(100)\n" +
                "                        .animate()\n" +
                "                        .success()\n" +
                "                        .setValue(80))\n" +
                "                .asElement())\n" +
                "        .appendContent(Progress.create()\n" +
                "                .addBar(ProgressBar.create(100)\n" +
                "                        .animate()\n" +
                "                        .warning()\n" +
                "                        .setValue(60))\n" +
                "                .asElement())\n" +
                "        .appendContent(Progress.create()\n" +
                "                .addBar(ProgressBar.create(100)\n" +
                "                        .animate()\n" +
                "                        .info()\n" +
                "                        .setValue(70))\n" +
                "                .asElement())\n" +
                "        .appendContent(Progress.create()\n" +
                "                .addBar(ProgressBar.create(100)\n" +
                "                        .animate()\n" +
                "                        .danger()\n" +
                "                        .setValue(30))\n" +
                "                .asElement())\n" +
                "        .asElement());";
    }

    public static String stackedSample() {
        return "element.appendChild(Card.create(\"STACKED\", \"You can stack more than one progress bar in a progress element.\")\n" +
                "        .appendContent(Progress.create()\n" +
                "                .addBar(ProgressBar.create(100)\n" +
                "                        .animate()\n" +
                "                        .success()\n" +
                "                        .setValue(40))\n" +
                "                .addBar(ProgressBar.create(100)\n" +
                "                        .warning()\n" +
                "                        .setValue(30))\n" +
                "                .addBar(ProgressBar.create(100)\n" +
                "                        .striped()\n" +
                "                        .danger()\n" +
                "                        .setValue(20))\n" +
                "                .asElement())\n" +
                "        .asElement());";
    }

    public static String materialDesignColors() {
        return "element.appendChild(Card.create(\"WITH MATERIAL DESIGN COLORS\", \"You use material design colors to style the progress bar.\")\n" +
                "        .appendContent(Progress.create()\n" +
                "                .addBar(ProgressBar.create(100)\n" +
                "                        .setBackground(Background.PINK)\n" +
                "                        .striped()\n" +
                "                        .setValue(90))\n" +
                "                .asElement())\n" +
                "        .appendContent(Progress.create()\n" +
                "                .addBar(ProgressBar.create(100)\n" +
                "                        .showText()\n" +
                "                        .setBackground(Background.PURPLE)\n" +
                "                        .striped()\n" +
                "                        .setValue(60))\n" +
                "                .asElement())\n" +
                "        .appendContent(Progress.create()\n" +
                "                .addBar(ProgressBar.create(100)\n" +
                "                        .setBackground(Background.TEAL)\n" +
                "                        .striped()\n" +
                "                        .setValue(75))\n" +
                "                .asElement())\n" +
                "        .appendContent(Progress.create()\n" +
                "                .addBar(ProgressBar.create(100)\n" +
                "                        .setBackground(Background.BROWN)\n" +
                "                        .striped()\n" +
                "                        .setValue(40))\n" +
                "                .asElement())\n" +
                "        .asElement());";
    }

}
