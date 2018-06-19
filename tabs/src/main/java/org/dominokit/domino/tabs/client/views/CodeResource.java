package org.dominokit.domino.tabs.client.views;

public class CodeResource {

    public static String basicSample() {
        return "element.appendChild(Card.create(\"EXAMPLE TAB\", \"Add quick, dynamic tab functionality to transition through panes of local content\")\n" +
                "                .appendContent(TabsPanel.create()\n" +
                "                        .addTab(Tab.create(\"HOME\")\n" +
                "                                .appendContent(b().textContent(\"Home Content\").asElement())\n" +
                "                                .appendContent(Paragraph.create(SAMPLE_TEXT).asElement()))\n" +
                "                        .addTab(Tab.create(\"PROFILE\")\n" +
                "                                .appendContent(b().textContent(\"Profile Content\").asElement())\n" +
                "                                .appendContent(Paragraph.create(SAMPLE_TEXT).asElement()))\n" +
                "                        .addTab(Tab.create(\"MESSAGES\")\n" +
                "                                .appendContent(b().textContent(\"Messages Content\").asElement())\n" +
                "                                .appendContent(Paragraph.create(SAMPLE_TEXT).asElement())\n" +
                "                                .activate())\n" +
                "                        .addTab(Tab.create(\"SETTINGS\")\n" +
                "                                .appendContent(b().textContent(\"Settings Content\").asElement())\n" +
                "                                .appendContent(Paragraph.create(SAMPLE_TEXT).asElement()))\n" +
                "                        .asElement())\n" +
                "                .asElement());";
    }

    public static String iconsOnly() {
        return "element.appendChild(Card.create(\"TABS WITH ONLY ICON TITLE\")\n" +
                "                .appendContent(TabsPanel.create()\n" +
                "                        .addTab(Tab.create(Icons.ALL.home())\n" +
                "                                .appendContent(b().textContent(\"Home Content\").asElement())\n" +
                "                                .appendContent(Paragraph.create(SAMPLE_TEXT).asElement()))\n" +
                "                        .addTab(Tab.create(Icons.ALL.face())\n" +
                "                                .appendContent(b().textContent(\"Profile Content\").asElement())\n" +
                "                                .appendContent(Paragraph.create(SAMPLE_TEXT).asElement()))\n" +
                "                        .addTab(Tab.create(Icons.ALL.email())\n" +
                "                                .appendContent(b().textContent(\"Messages Content\").asElement())\n" +
                "                                .appendContent(Paragraph.create(SAMPLE_TEXT).asElement())\n" +
                "                                .activate())\n" +
                "                        .addTab(Tab.create(Icons.ALL.settings())\n" +
                "                                .appendContent(b().textContent(\"Settings Content\").asElement())\n" +
                "                                .appendContent(Paragraph.create(SAMPLE_TEXT).asElement()))\n" +
                "                        .asElement())\n" +
                "                .asElement());";
    }

    public static String withIconsAndTextSamlple() {
        return "element.appendChild(Card.create(\"TABS WITH ICON TITLE\")\n" +
                "                .appendContent(TabsPanel.create()\n" +
                "                        .addTab(Tab.create(Icons.ALL.home(), \" HOME\")\n" +
                "                                .appendContent(b().textContent(\"Home Content\").asElement())\n" +
                "                                .appendContent(Paragraph.create(SAMPLE_TEXT).asElement()))\n" +
                "                        .addTab(Tab.create(Icons.ALL.face(), \" PROFILE\")\n" +
                "                                .appendContent(b().textContent(\"Profile Content\").asElement())\n" +
                "                                .appendContent(Paragraph.create(SAMPLE_TEXT).asElement()))\n" +
                "                        .addTab(Tab.create(Icons.ALL.email(), \" MESSAGES\")\n" +
                "                                .appendContent(b().textContent(\"Messages Content\").asElement())\n" +
                "                                .appendContent(Paragraph.create(SAMPLE_TEXT).asElement())\n" +
                "                                .activate())\n" +
                "                        .addTab(Tab.create(Icons.ALL.settings(), \" SETTINGS\")\n" +
                "                                .appendContent(b().textContent(\"Settings Content\").asElement())\n" +
                "                                .appendContent(Paragraph.create(SAMPLE_TEXT).asElement()))\n" +
                "                        .asElement())\n" +
                "                .asElement());";
    }

    public static String materialDesignColorsSample() {
        return "element.appendChild(Card.create(\"TABS WITH MATERIAL DESIGN COLORS\", \"You can use Material Design Colors\")\n" +
                "                .appendContent(Row.create()\n" +
                "                        .addColumn(column.copy()\n" +
                "                                .addElement(TabsPanel.create()\n" +
                "                                        .addTab(Tab.create(\"HOME\"))\n" +
                "                                        .addTab(Tab.create(\"PROFILE\"))\n" +
                "                                        .addTab(Tab.create(\"MESSAGES\").activate())\n" +
                "                                        .addTab(Tab.create(\"SETTINGS\"))\n" +
                "                                        .setColor(Color.PINK)\n" +
                "                                        .asElement())\n" +
                "                                .addElement(TabsPanel.create()\n" +
                "                                        .addTab(Tab.create(\"HOME\"))\n" +
                "                                        .addTab(Tab.create(\"PROFILE\"))\n" +
                "                                        .addTab(Tab.create(\"MESSAGES\").activate())\n" +
                "                                        .addTab(Tab.create(\"SETTINGS\"))\n" +
                "                                        .setColor(Color.TEAL)\n" +
                "                                        .asElement())\n" +
                "                                .addElement(TabsPanel.create()\n" +
                "                                        .addTab(Tab.create(\"HOME\"))\n" +
                "                                        .addTab(Tab.create(\"PROFILE\"))\n" +
                "                                        .addTab(Tab.create(\"MESSAGES\").activate())\n" +
                "                                        .addTab(Tab.create(\"SETTINGS\"))\n" +
                "                                        .setColor(Color.PURPLE)\n" +
                "                                        .asElement())\n" +
                "                        )\n" +
                "                        .addColumn(column.copy()\n" +
                "                                .addElement(TabsPanel.create()\n" +
                "                                        .addTab(Tab.create(\"HOME\"))\n" +
                "                                        .addTab(Tab.create(\"PROFILE\"))\n" +
                "                                        .addTab(Tab.create(\"MESSAGES\").activate())\n" +
                "                                        .addTab(Tab.create(\"SETTINGS\"))\n" +
                "                                        .setColor(Color.RED)\n" +
                "                                        .asElement())\n" +
                "                                .addElement(TabsPanel.create()\n" +
                "                                        .addTab(Tab.create(\"HOME\"))\n" +
                "                                        .addTab(Tab.create(\"PROFILE\"))\n" +
                "                                        .addTab(Tab.create(\"MESSAGES\").activate())\n" +
                "                                        .addTab(Tab.create(\"SETTINGS\"))\n" +
                "                                        .setColor(Color.ORANGE)\n" +
                "                                        .asElement())\n" +
                "                                .addElement(TabsPanel.create()\n" +
                "                                        .addTab(Tab.create(\"HOME\"))\n" +
                "                                        .addTab(Tab.create(\"PROFILE\"))\n" +
                "                                        .addTab(Tab.create(\"MESSAGES\").activate())\n" +
                "                                        .addTab(Tab.create(\"SETTINGS\"))\n" +
                "                                        .setColor(Color.BLUE_GREY)\n" +
                "                                        .asElement())\n" +
                "                        )\n" +
                "                        .asElement())\n" +
                "                .asElement());";
    }

    public static String withAnimation() {
        return "element.appendChild(Card.create(\"TABS WITH CUSTOM ANIMATIONS\", \"Animate the tabs content when they show up.\")\n" +
                "                .appendContent(Row.create()\n" +
                "                        .addColumn(column.copy()\n" +
                "                                .addElement(TabsPanel.create()\n" +
                "                                        .addTab(Tab.create(Icons.ALL.home(), \" HOME\")\n" +
                "                                                .appendContent(b().textContent(\"Home Content\").asElement())\n" +
                "                                                .appendContent(Paragraph.create(SAMPLE_TEXT).asElement()))\n" +
                "                                        .addTab(Tab.create(Icons.ALL.face(), \" PROFILE\")\n" +
                "                                                .appendContent(b().textContent(\"Profile Content\").asElement())\n" +
                "                                                .appendContent(Paragraph.create(SAMPLE_TEXT).asElement()))\n" +
                "                                        .addTab(Tab.create(Icons.ALL.email(), \" MESSAGES\")\n" +
                "                                                .appendContent(b().textContent(\"Messages Content\").asElement())\n" +
                "                                                .appendContent(Paragraph.create(SAMPLE_TEXT).asElement())\n" +
                "                                                .activate())\n" +
                "                                        .addTab(Tab.create(Icons.ALL.settings(), \" SETTINGS\")\n" +
                "                                                .appendContent(b().textContent(\"Settings Content\").asElement())\n" +
                "                                                .appendContent(Paragraph.create(SAMPLE_TEXT).asElement()))\n" +
                "                                        .setTransition(Transition.ROTATE_IN_UP_LEFT)\n" +
                "                                        .asElement()))\n" +
                "                        .addColumn(column.copy()\n" +
                "                                .addElement(TabsPanel.create()\n" +
                "                                        .addTab(Tab.create(Icons.ALL.home(), \" HOME\")\n" +
                "                                                .appendContent(b().textContent(\"Home Content\").asElement())\n" +
                "                                                .appendContent(Paragraph.create(SAMPLE_TEXT).asElement()))\n" +
                "                                        .addTab(Tab.create(Icons.ALL.face(), \" PROFILE\")\n" +
                "                                                .appendContent(b().textContent(\"Profile Content\").asElement())\n" +
                "                                                .appendContent(Paragraph.create(SAMPLE_TEXT).asElement()))\n" +
                "                                        .addTab(Tab.create(Icons.ALL.email(), \" MESSAGES\")\n" +
                "                                                .appendContent(b().textContent(\"Messages Content\").asElement())\n" +
                "                                                .appendContent(Paragraph.create(SAMPLE_TEXT).asElement())\n" +
                "                                                .activate())\n" +
                "                                        .addTab(Tab.create(Icons.ALL.settings(), \" SETTINGS\")\n" +
                "                                                .appendContent(b().textContent(\"Settings Content\").asElement())\n" +
                "                                                .appendContent(Paragraph.create(SAMPLE_TEXT).asElement()))\n" +
                "                                        .setTransition(Transition.FADE_IN_RIGHT)\n" +
                "                                        .asElement()))\n" +
                "                        .asElement())\n" +
                "                .asElement());";
    }

}
