package org.dominokit.domino.breadcrumb.client.views;

public class CodeResource{

    public static String basicBreadcrumb(){
        return "Card.create(\"BASIC EXAMPLES\", \"Separators are automatically added for breadcrumb elements\")\n" +
                "    .appendContent(Breadcrumb.create()\n" +
                "            .addItem(\" Home \", evt -> {\n" +
                "            }).asElement())\n" +
                "    .appendContent(Breadcrumb.create()\n" +
                "            .addItem(\" Home \", evt -> {\n" +
                "            })\n" +
                "            .addItem(\" Library \", evt -> {\n" +
                "            }).asElement())\n" +
                "    .appendContent(Breadcrumb.create()\n" +
                "            .addItem(\" Home \", evt -> {\n" +
                "            })\n" +
                "            .addItem(\" Library \", evt -> {\n" +
                "            })\n" +
                "            .addItem(\" Data \", evt -> {\n" +
                "            })\n" +
                "            .asElement())\n" +
                "    .asElement();\n" +
                "\n" +
                "\n" +
                "Card.create(\"WITH ICONS\")\n" +
                "    .appendContent(Breadcrumb.create()\n" +
                "            .addItem(Icons.ALL.home(), \" Home \", evt -> {\n" +
                "            }).asElement())\n" +
                "    .appendContent(Breadcrumb.create()\n" +
                "            .addItem(Icons.ALL.home(), \" Home \", evt -> {\n" +
                "            })\n" +
                "            .addItem(Icons.ALL.library_books(), \" Library \", evt -> {\n" +
                "            }).asElement())\n" +
                "    .appendContent(Breadcrumb.create()\n" +
                "            .addItem(Icons.ALL.home(), \" Home \", evt -> {\n" +
                "            })\n" +
                "            .addItem(Icons.ALL.library_books(), \" Library \", evt -> {\n" +
                "            })\n" +
                "            .addItem(Icons.ALL.archive(), \" Data \", evt -> {\n" +
                "            })\n" +
                "            .asElement())\n" +
                "    .asElement();";
    }

    public static String breadcrumbWithBackground(){
        return "Card.create(\"WITH MATERIAL DESIGN COLORS\", \"You can use material design colors\")\n" +
                "    .appendContent(Breadcrumb.create()\n" +
                "            .setBackground(Color.PINK)\n" +
                "            .addItem(\" Home \", evt -> {\n" +
                "            })\n" +
                "            .addItem(\" Library \", evt -> {\n" +
                "            })\n" +
                "            .asElement())\n" +
                "    .appendContent(Breadcrumb.create()\n" +
                "            .setBackground(Color.CYAN)\n" +
                "            .addItem(\" Home \", evt -> {\n" +
                "            })\n" +
                "            .addItem(\" Library \", evt -> {\n" +
                "            })\n" +
                "            .addItem(\" Data \", evt -> {\n" +
                "            })\n" +
                "            .asElement())\n" +
                "    .appendContent(Breadcrumb.create()\n" +
                "            .setBackground(Color.TEAL)\n" +
                "            .addItem(\" Home \", evt -> {\n" +
                "            })\n" +
                "            .addItem(\" Library \", evt -> {\n" +
                "            })\n" +
                "            .addItem(\" Data \", evt -> {\n" +
                "            })\n" +
                "            .addItem(\" File \", evt -> {\n" +
                "            })\n" +
                "            .asElement())\n" +
                "    .appendContent(Breadcrumb.create()\n" +
                "            .setBackground(Color.ORANGE)\n" +
                "            .addItem(\" Home \", evt -> {\n" +
                "            })\n" +
                "            .addItem(\" Library \", evt -> {\n" +
                "            })\n" +
                "            .addItem(\" Data \", evt -> {\n" +
                "            })\n" +
                "            .addItem(\" File \", evt -> {\n" +
                "            })\n" +
                "            .addItem(\" Extensions \", evt -> {\n" +
                "            })\n" +
                "            .asElement())\n" +
                "    .asElement();\n" +
                "\n" +
                "\n" +
                "Card.create(\"WITH ICONS & MATERIAL DESIGN COLORS\")\n" +
                "    .appendContent(Breadcrumb.create()\n" +
                "            .setBackground(Color.PINK)\n" +
                "            .addItem(Icons.ALL.home(), \" Home \", evt -> {\n" +
                "            })\n" +
                "            .addItem(Icons.ALL.library_books(), \" Library \", evt -> {\n" +
                "            })\n" +
                "            .asElement())\n" +
                "    .appendContent(Breadcrumb.create()\n" +
                "            .setBackground(Color.CYAN)\n" +
                "            .addItem(Icons.ALL.home(), \" Home \", evt -> {\n" +
                "            })\n" +
                "            .addItem(Icons.ALL.library_books(), \" Library \", evt -> {\n" +
                "            })\n" +
                "            .addItem(Icons.ALL.archive(), \" Data \", evt -> {\n" +
                "            })\n" +
                "            .asElement())\n" +
                "    .appendContent(Breadcrumb.create()\n" +
                "            .setBackground(Color.TEAL)\n" +
                "            .addItem(Icons.ALL.home(), \" Home \", evt -> {\n" +
                "            })\n" +
                "            .addItem(Icons.ALL.library_books(), \" Library \", evt -> {\n" +
                "            })\n" +
                "            .addItem(Icons.ALL.archive(), \" Data \", evt -> {\n" +
                "            })\n" +
                "            .addItem(Icons.ALL.attachment(), \" File \", evt -> {\n" +
                "            })\n" +
                "            .asElement())\n" +
                "    .appendContent(Breadcrumb.create()\n" +
                "            .setBackground(Color.ORANGE)\n" +
                "            .addItem(Icons.ALL.home(), \" Home \", evt -> {\n" +
                "            })\n" +
                "            .addItem(Icons.ALL.library_books(), \" Library \", evt -> {\n" +
                "            })\n" +
                "            .addItem(Icons.ALL.archive(), \" Data \", evt -> {\n" +
                "            })\n" +
                "            .addItem(Icons.ALL.attachment(), \" File \", evt -> {\n" +
                "            })\n" +
                "            .addItem(Icons.ALL.extension(), \" Extensions \", evt -> {\n" +
                "            })\n" +
                "            .asElement())\n" +
                "    .asElement()";
    }

    public static String coloredBreadcrumb(){
        return "Card.create(\"WITH MATERIAL DESIGN COLORS\", \"You can use material design colors\")\n" +
                "    .appendContent(Breadcrumb.create()\n" +
                "            .setColor(Color.PINK)\n" +
                "            .addItem(\" Home \", evt -> {\n" +
                "            })\n" +
                "            .addItem(\" Library \", evt -> {\n" +
                "            })\n" +
                "            .asElement())\n" +
                "    .appendContent(Breadcrumb.create()\n" +
                "            .setColor(Color.CYAN)\n" +
                "            .addItem(\" Home \", evt -> {\n" +
                "            })\n" +
                "            .addItem(\" Library \", evt -> {\n" +
                "            })\n" +
                "            .addItem(\" Data \", evt -> {\n" +
                "            })\n" +
                "            .asElement())\n" +
                "    .appendContent(Breadcrumb.create()\n" +
                "            .setColor(Color.TEAL)\n" +
                "            .addItem(\" Home \", evt -> {\n" +
                "            })\n" +
                "            .addItem(\" Library \", evt -> {\n" +
                "            })\n" +
                "            .addItem(\" Data \", evt -> {\n" +
                "            })\n" +
                "            .addItem(\" File \", evt -> {\n" +
                "            })\n" +
                "            .asElement())\n" +
                "    .appendContent(Breadcrumb.create()\n" +
                "            .setColor(Color.ORANGE)\n" +
                "            .addItem(\" Home \", evt -> {\n" +
                "            })\n" +
                "            .addItem(\" Library \", evt -> {\n" +
                "            })\n" +
                "            .addItem(\" Data \", evt -> {\n" +
                "            })\n" +
                "            .addItem(\" File \", evt -> {\n" +
                "            })\n" +
                "            .addItem(\" Extensions \", evt -> {\n" +
                "            })\n" +
                "            .asElement())\n" +
                "    .asElement();\n" +
                "\n" +
                "\n" +
                "Card.create(\"WITH ICONS & MATERIAL DESIGN COLORS\")\n" +
                "    .appendContent(Breadcrumb.create()\n" +
                "            .setColor(Color.PINK)\n" +
                "            .addItem(Icons.ALL.home(), \" Home \", evt -> {\n" +
                "            })\n" +
                "            .addItem(Icons.ALL.library_books(), \" Library \", evt -> {\n" +
                "            })\n" +
                "            .asElement())\n" +
                "    .appendContent(Breadcrumb.create()\n" +
                "            .setColor(Color.CYAN)\n" +
                "            .addItem(Icons.ALL.home(), \" Home \", evt -> {\n" +
                "            })\n" +
                "            .addItem(Icons.ALL.library_books(), \" Library \", evt -> {\n" +
                "            })\n" +
                "            .addItem(Icons.ALL.archive(), \" Data \", evt -> {\n" +
                "            })\n" +
                "            .asElement())\n" +
                "    .appendContent(Breadcrumb.create()\n" +
                "            .setColor(Color.TEAL)\n" +
                "            .addItem(Icons.ALL.home(), \" Home \", evt -> {\n" +
                "            })\n" +
                "            .addItem(Icons.ALL.library_books(), \" Library \", evt -> {\n" +
                "            })\n" +
                "            .addItem(Icons.ALL.archive(), \" Data \", evt -> {\n" +
                "            })\n" +
                "            .addItem(Icons.ALL.attachment(), \" File \", evt -> {\n" +
                "            })\n" +
                "            .asElement())\n" +
                "    .appendContent(Breadcrumb.create()\n" +
                "            .setColor(Color.ORANGE)\n" +
                "            .addItem(Icons.ALL.home(), \" Home \", evt -> {\n" +
                "            })\n" +
                "            .addItem(Icons.ALL.library_books(), \" Library \", evt -> {\n" +
                "            })\n" +
                "            .addItem(Icons.ALL.archive(), \" Data \", evt -> {\n" +
                "            })\n" +
                "            .addItem(Icons.ALL.attachment(), \" File \", evt -> {\n" +
                "            })\n" +
                "            .addItem(Icons.ALL.extension(), \" Extensions \", evt -> {\n" +
                "            })\n" +
                "            .asElement())\n" +
                "    .asElement();";
    }

    public static String alignment(){
        return "Card.create(\"ALIGNMENTS\")\n" +
                "    .appendContent(Breadcrumb.create()\n" +
                "            .setBackground(Color.PINK)\n" +
                "            .addItem(Icons.ALL.home(), \" Home \", evt -> {\n" +
                "            })\n" +
                "            .addItem(Icons.ALL.library_books(), \" Library \", evt -> {\n" +
                "            })\n" +
                "            .asElement())\n" +
                "    .appendContent(Breadcrumb.create()\n" +
                "            .alignCenter()\n" +
                "            .setBackground(Color.CYAN)\n" +
                "            .addItem(Icons.ALL.home(), \" Home \", evt -> {\n" +
                "            })\n" +
                "            .addItem(Icons.ALL.library_books(), \" Library \", evt -> {\n" +
                "            })\n" +
                "            .addItem(Icons.ALL.archive(), \" Data \", evt -> {\n" +
                "            })\n" +
                "            .asElement())\n" +
                "    .appendContent(Breadcrumb.create()\n" +
                "            .alignRight()\n" +
                "            .setBackground(Color.TEAL)\n" +
                "            .addItem(Icons.ALL.home(), \" Home \", evt -> {\n" +
                "            })\n" +
                "            .addItem(Icons.ALL.library_books(), \" Library \", evt -> {\n" +
                "            })\n" +
                "            .addItem(Icons.ALL.archive(), \" Data \", evt -> {\n" +
                "            })\n" +
                "            .addItem(Icons.ALL.attachment(), \" File \", evt -> {\n" +
                "            })\n" +
                "            .asElement())\n" +
                "    .asElement()";
    }

}

