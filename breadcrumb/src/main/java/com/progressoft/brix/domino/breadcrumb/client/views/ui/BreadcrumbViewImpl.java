package com.progressoft.brix.domino.breadcrumb.client.views.ui;

import com.progressoft.brix.domino.api.client.annotations.UiView;
import com.progressoft.brix.domino.api.shared.extension.Content;
import com.progressoft.brix.domino.breadcrumb.client.presenters.BreadcrumbPresenter;
import com.progressoft.brix.domino.breadcrumb.client.views.BreadcrumbView;
import com.progressoft.brix.domino.ui.breadcrumbs.Breadcrumb;
import com.progressoft.brix.domino.ui.cards.Card;
import com.progressoft.brix.domino.ui.column.Column;
import com.progressoft.brix.domino.ui.header.BlockHeader;
import com.progressoft.brix.domino.ui.icons.Icons;
import com.progressoft.brix.domino.ui.row.Row;
import com.progressoft.brix.domino.ui.style.Background;
import com.progressoft.brix.domino.ui.style.Color;
import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import jsinterop.base.Js;
import org.jboss.gwt.elemento.core.Elements;

@UiView(presentable = BreadcrumbPresenter.class)
public class BreadcrumbViewImpl implements BreadcrumbView {

    private HTMLDivElement element = Elements.div().asElement();
    private final Column column = Column.create()
            .onLarge(Column.OnLarge.six)
            .onMedium(Column.OnMedium.six)
            .onSmall(Column.OnSmall.twelve)
            .onXSmall(Column.OnXSmall.twelve);

    public BreadcrumbViewImpl() {
        element.appendChild(BlockHeader.create("BREADCRUMBS").asElement());

        basicBreadcrumb();
        coloredBreadcrumb();
        breadcrumbWithBackground();
        alignment();
    }

    private void basicBreadcrumb() {
        Row row = Row.create();
        element.appendChild(row
                .addColumn(column.copy().addElement(Card.create("BASIC EXAMPLES", "Separators are automatically added for breadcrumb elements")
                        .appendContent(Breadcrumb.create()
                                .addItem(" Home ", evt -> {
                                }).asElement())
                        .appendContent(Breadcrumb.create()
                                .addItem(" Home ", evt -> {
                                })
                                .addItem(" Library ", evt -> {
                                }).asElement())
                        .appendContent(Breadcrumb.create()
                                .addItem(" Home ", evt -> {
                                })
                                .addItem(" Library ", evt -> {
                                })
                                .addItem(" Data ", evt -> {
                                })
                                .asElement())
                        .asElement()))
                .asElement());

        element.appendChild(row
                .addColumn(column.copy().addElement(Card.create("WITH ICONS")
                        .appendContent(Breadcrumb.create()
                                .addItem(Icons.ALL.home(), " Home ", evt -> {
                                }).asElement())
                        .appendContent(Breadcrumb.create()
                                .addItem(Icons.ALL.home(), " Home ", evt -> {
                                })
                                .addItem(Icons.ALL.library_books(), " Library ", evt -> {
                                }).asElement())
                        .appendContent(Breadcrumb.create()
                                .addItem(Icons.ALL.home(), " Home ", evt -> {
                                })
                                .addItem(Icons.ALL.library_books(), " Library ", evt -> {
                                })
                                .addItem(Icons.ALL.archive(), " Data ", evt -> {
                                })
                                .asElement())
                        .asElement()))
                .asElement());

        element.appendChild(Card.createCodeCard("Row row = Row.create();\n" +
                "element.appendChild(row\n" +
                "        .addColumn(column.copy().addElement(Card.create(\"BASIC EXAMPLES\", \"Separators are automatically added for breadcrumb elements\")\n" +
                "                .appendContent(Breadcrumb.create()\n" +
                "                        .addItem(\" Home \", evt -> {}).asElement())\n" +
                "                .appendContent(Breadcrumb.create()\n" +
                "                        .addItem(\" Home \", evt -> {})\n" +
                "                        .addItem(\" Library \", evt -> {}).asElement())\n" +
                "                .appendContent(Breadcrumb.create()\n" +
                "                        .addItem(\" Home \", evt -> {})\n" +
                "                        .addItem(\" Library \", evt -> {})\n" +
                "                        .addItem(\" Data \", evt -> {})\n" +
                "                        .asElement())\n" +
                "                .asElement()))\n" +
                "        .asElement());\n" +
                "\n" +
                "element.appendChild(row\n" +
                "        .addColumn(column.copy().addElement(Card.create(\"WITH ICONS\")\n" +
                "                .appendContent(Breadcrumb.create()\n" +
                "                        .addItem(Icons.ALL.home(), \" Home \", evt -> {}).asElement())\n" +
                "                .appendContent(Breadcrumb.create()\n" +
                "                        .addItem(Icons.ALL.home(), \" Home \", evt -> {})\n" +
                "                        .addItem(Icons.ALL.library_books(), \" Library \", evt -> {}).asElement())\n" +
                "                .appendContent(Breadcrumb.create()\n" +
                "                        .addItem(Icons.ALL.home(), \" Home \", evt -> {})\n" +
                "                        .addItem(Icons.ALL.library_books(), \" Library \", evt -> {})\n" +
                "                        .addItem(Icons.ALL.archive(), \" Data \", evt -> {})\n" +
                "                        .asElement())\n" +
                "                .asElement()))\n" +
                "        .asElement());")
                .asElement());
    }

    private void coloredBreadcrumb() {
        Row row = Row.create();
        element.appendChild(row
                .addColumn(column.copy().addElement(Card.create("WITH MATERIAL DESIGN COLORS", "You can use material design colors")
                        .appendContent(Breadcrumb.create()
                                .setColor(Color.PINK)
                                .addItem(" Home ", evt -> {
                                })
                                .addItem(" Library ", evt -> {
                                })
                                .asElement())
                        .appendContent(Breadcrumb.create()
                                .setColor(Color.CYAN)
                                .addItem(" Home ", evt -> {
                                })
                                .addItem(" Library ", evt -> {
                                })
                                .addItem(" Data ", evt -> {
                                })
                                .asElement())
                        .appendContent(Breadcrumb.create()
                                .setColor(Color.TEAL)
                                .addItem(" Home ", evt -> {
                                })
                                .addItem(" Library ", evt -> {
                                })
                                .addItem(" Data ", evt -> {
                                })
                                .addItem(" File ", evt -> {
                                })
                                .asElement())
                        .appendContent(Breadcrumb.create()
                                .setColor(Color.ORANGE)
                                .addItem(" Home ", evt -> {
                                })
                                .addItem(" Library ", evt -> {
                                })
                                .addItem(" Data ", evt -> {
                                })
                                .addItem(" File ", evt -> {
                                })
                                .addItem(" Extensions ", evt -> {
                                })
                                .asElement())
                        .asElement()))
                .asElement());

        element.appendChild(row
                .addColumn(column.copy().addElement(Card.create("WITH ICONS & MATERIAL DESIGN COLORS")
                        .appendContent(Breadcrumb.create()
                                .setColor(Color.PINK)
                                .addItem(Icons.ALL.home(), " Home ", evt -> {
                                })
                                .addItem(Icons.ALL.library_books(), " Library ", evt -> {
                                })
                                .asElement())
                        .appendContent(Breadcrumb.create()
                                .setColor(Color.CYAN)
                                .addItem(Icons.ALL.home(), " Home ", evt -> {
                                })
                                .addItem(Icons.ALL.library_books(), " Library ", evt -> {
                                })
                                .addItem(Icons.ALL.archive(), " Data ", evt -> {
                                })
                                .asElement())
                        .appendContent(Breadcrumb.create()
                                .setColor(Color.TEAL)
                                .addItem(Icons.ALL.home(), " Home ", evt -> {
                                })
                                .addItem(Icons.ALL.library_books(), " Library ", evt -> {
                                })
                                .addItem(Icons.ALL.archive(), " Data ", evt -> {
                                })
                                .addItem(Icons.ALL.attachment(), " File ", evt -> {
                                })
                                .asElement())
                        .appendContent(Breadcrumb.create()
                                .setColor(Color.ORANGE)
                                .addItem(Icons.ALL.home(), " Home ", evt -> {
                                })
                                .addItem(Icons.ALL.library_books(), " Library ", evt -> {
                                })
                                .addItem(Icons.ALL.archive(), " Data ", evt -> {
                                })
                                .addItem(Icons.ALL.attachment(), " File ", evt -> {
                                })
                                .addItem(Icons.ALL.extension(), " Extensions ", evt -> {
                                })
                                .asElement())
                        .asElement()))
                .asElement());

        element.appendChild(Card.createCodeCard("Row row = Row.create();\n" +
                "element.appendChild(row\n" +
                "        .addColumn(column.copy().addElement(Card.create(\"WITH MATERIAL DESIGN COLORS\", \"You can use material design colors\")\n" +
                "                .appendContent(Breadcrumb.create()\n" +
                "                        .setColor(Color.PINK)\n" +
                "                        .addItem(\" Home \", evt -> {})\n" +
                "                        .addItem(\" Library \", evt -> {})\n" +
                "                        .asElement())\n" +
                "                .appendContent(Breadcrumb.create()\n" +
                "                        .setColor(Color.CYAN)\n" +
                "                        .addItem(\" Home \", evt -> {})\n" +
                "                        .addItem(\" Library \", evt -> {})\n" +
                "                        .addItem(\" Data \", evt -> {})\n" +
                "                        .asElement())\n" +
                "                .appendContent(Breadcrumb.create()\n" +
                "                        .setColor(Color.TEAL)\n" +
                "                        .addItem(\" Home \", evt -> {})\n" +
                "                        .addItem(\" Library \", evt -> {})\n" +
                "                        .addItem(\" Data \", evt -> {})\n" +
                "                        .addItem(\" File \", evt -> {})\n" +
                "                        .asElement())\n" +
                "                .appendContent(Breadcrumb.create()\n" +
                "                        .setColor(Color.ORANGE)\n" +
                "                        .addItem(\" Home \", evt -> {})\n" +
                "                        .addItem(\" Library \", evt -> {})\n" +
                "                        .addItem(\" Data \", evt -> {})\n" +
                "                        .addItem(\" File \", evt -> {})\n" +
                "                        .addItem(\" Extensions \", evt -> {})\n" +
                "                        .asElement())\n" +
                "                .asElement()))\n" +
                "        .asElement());\n" +
                "\n" +
                "element.appendChild(row\n" +
                "        .addColumn(column.copy().addElement(Card.create(\"WITH ICONS & MATERIAL DESIGN COLORS\")\n" +
                "                .appendContent(Breadcrumb.create()\n" +
                "                        .setColor(Color.PINK)\n" +
                "                        .addItem(Icons.ALL.home(), \" Home \", evt -> {})\n" +
                "                        .addItem(Icons.ALL.library_books(), \" Library \", evt -> {})\n" +
                "                        .asElement())\n" +
                "                .appendContent(Breadcrumb.create()\n" +
                "                        .setColor(Color.CYAN)\n" +
                "                        .addItem(Icons.ALL.home(), \" Home \", evt -> {})\n" +
                "                        .addItem(Icons.ALL.library_books(), \" Library \", evt -> {})\n" +
                "                        .addItem(Icons.ALL.archive(), \" Data \", evt -> {})\n" +
                "                        .asElement())\n" +
                "                .appendContent(Breadcrumb.create()\n" +
                "                        .setColor(Color.TEAL)\n" +
                "                        .addItem(Icons.ALL.home(), \" Home \", evt -> {})\n" +
                "                        .addItem(Icons.ALL.library_books(), \" Library \", evt -> {})\n" +
                "                        .addItem(Icons.ALL.archive(), \" Data \", evt -> {})\n" +
                "                        .addItem(Icons.ALL.attachment(), \" File \", evt -> {})\n" +
                "                        .asElement())\n" +
                "                .appendContent(Breadcrumb.create()\n" +
                "                        .setColor(Color.ORANGE)\n" +
                "                        .addItem(Icons.ALL.home(), \" Home \", evt -> {})\n" +
                "                        .addItem(Icons.ALL.library_books(), \" Library \", evt -> {})\n" +
                "                        .addItem(Icons.ALL.archive(), \" Data \", evt -> {})\n" +
                "                        .addItem(Icons.ALL.attachment(), \" File \", evt -> {})\n" +
                "                        .addItem(Icons.ALL.extension(), \" Extensions \", evt -> {})\n" +
                "                        .asElement())\n" +
                "                .asElement()))\n" +
                "        .asElement());")
                .asElement());
    }

    private void breadcrumbWithBackground() {
        Row row = Row.create();
        element.appendChild(row
                .addColumn(column.copy().addElement(Card.create("WITH MATERIAL DESIGN COLORS", "You can use material design colors")
                        .appendContent(Breadcrumb.create()
                                .setBackground(Background.PINK)
                                .addItem(" Home ", evt -> {
                                })
                                .addItem(" Library ", evt -> {
                                })
                                .asElement())
                        .appendContent(Breadcrumb.create()
                                .setBackground(Background.CYAN)
                                .addItem(" Home ", evt -> {
                                })
                                .addItem(" Library ", evt -> {
                                })
                                .addItem(" Data ", evt -> {
                                })
                                .asElement())
                        .appendContent(Breadcrumb.create()
                                .setBackground(Background.TEAL)
                                .addItem(" Home ", evt -> {
                                })
                                .addItem(" Library ", evt -> {
                                })
                                .addItem(" Data ", evt -> {
                                })
                                .addItem(" File ", evt -> {
                                })
                                .asElement())
                        .appendContent(Breadcrumb.create()
                                .setBackground(Background.ORANGE)
                                .addItem(" Home ", evt -> {
                                })
                                .addItem(" Library ", evt -> {
                                })
                                .addItem(" Data ", evt -> {
                                })
                                .addItem(" File ", evt -> {
                                })
                                .addItem(" Extensions ", evt -> {
                                })
                                .asElement())
                        .asElement()))
                .asElement());

        element.appendChild(row
                .addColumn(column.copy().addElement(Card.create("WITH ICONS & MATERIAL DESIGN COLORS")
                        .appendContent(Breadcrumb.create()
                                .setBackground(Background.PINK)
                                .addItem(Icons.ALL.home(), " Home ", evt -> {
                                })
                                .addItem(Icons.ALL.library_books(), " Library ", evt -> {
                                })
                                .asElement())
                        .appendContent(Breadcrumb.create()
                                .setBackground(Background.CYAN)
                                .addItem(Icons.ALL.home(), " Home ", evt -> {
                                })
                                .addItem(Icons.ALL.library_books(), " Library ", evt -> {
                                })
                                .addItem(Icons.ALL.archive(), " Data ", evt -> {
                                })
                                .asElement())
                        .appendContent(Breadcrumb.create()
                                .setBackground(Background.TEAL)
                                .addItem(Icons.ALL.home(), " Home ", evt -> {
                                })
                                .addItem(Icons.ALL.library_books(), " Library ", evt -> {
                                })
                                .addItem(Icons.ALL.archive(), " Data ", evt -> {
                                })
                                .addItem(Icons.ALL.attachment(), " File ", evt -> {
                                })
                                .asElement())
                        .appendContent(Breadcrumb.create()
                                .setBackground(Background.ORANGE)
                                .addItem(Icons.ALL.home(), " Home ", evt -> {
                                })
                                .addItem(Icons.ALL.library_books(), " Library ", evt -> {
                                })
                                .addItem(Icons.ALL.archive(), " Data ", evt -> {
                                })
                                .addItem(Icons.ALL.attachment(), " File ", evt -> {
                                })
                                .addItem(Icons.ALL.extension(), " Extensions ", evt -> {
                                })
                                .asElement())
                        .asElement()))
                .asElement());

        element.appendChild(Card.createCodeCard("Row row = Row.create();\n" +
                "element.appendChild(row\n" +
                "        .addColumn(column.copy().addElement(Card.create(\"WITH MATERIAL DESIGN COLORS\", \"You can use material design colors\")\n" +
                "                .appendContent(Breadcrumb.create()\n" +
                "                        .setBackground(Background.PINK)\n" +
                "                        .addItem(\" Home \", evt -> {})\n" +
                "                        .addItem(\" Library \", evt -> {})\n" +
                "                        .asElement())\n" +
                "                .appendContent(Breadcrumb.create()\n" +
                "                        .setBackground(Background.CYAN)\n" +
                "                        .addItem(\" Home \", evt -> {})\n" +
                "                        .addItem(\" Library \", evt -> {})\n" +
                "                        .addItem(\" Data \", evt -> {})\n" +
                "                        .asElement())\n" +
                "                .appendContent(Breadcrumb.create()\n" +
                "                        .setBackground(Background.TEAL)\n" +
                "                        .addItem(\" Home \", evt -> {})\n" +
                "                        .addItem(\" Library \", evt -> {})\n" +
                "                        .addItem(\" Data \", evt -> {})\n" +
                "                        .addItem(\" File \", evt -> {})\n" +
                "                        .asElement())\n" +
                "                .appendContent(Breadcrumb.create()\n" +
                "                        .setBackground(Background.ORANGE)\n" +
                "                        .addItem(\" Home \", evt -> {})\n" +
                "                        .addItem(\" Library \", evt -> {})\n" +
                "                        .addItem(\" Data \", evt -> {})\n" +
                "                        .addItem(\" File \", evt -> {})\n" +
                "                        .addItem(\" Extensions \", evt -> {})\n" +
                "                        .asElement())\n" +
                "                .asElement()))\n" +
                "        .asElement());\n" +
                "\n" +
                "element.appendChild(row\n" +
                "        .addColumn(column.copy().addElement(Card.create(\"WITH ICONS & MATERIAL DESIGN COLORS\")\n" +
                "                .appendContent(Breadcrumb.create()\n" +
                "                        .setBackground(Background.PINK)\n" +
                "                        .addItem(Icons.ALL.home(), \" Home \", evt -> {})\n" +
                "                        .addItem(Icons.ALL.library_books(), \" Library \", evt -> {})\n" +
                "                        .asElement())\n" +
                "                .appendContent(Breadcrumb.create()\n" +
                "                        .setBackground(Background.CYAN)\n" +
                "                        .addItem(Icons.ALL.home(), \" Home \", evt -> {})\n" +
                "                        .addItem(Icons.ALL.library_books(), \" Library \", evt -> {})\n" +
                "                        .addItem(Icons.ALL.archive(), \" Data \", evt -> {})\n" +
                "                        .asElement())\n" +
                "                .appendContent(Breadcrumb.create()\n" +
                "                        .setBackground(Background.TEAL)\n" +
                "                        .addItem(Icons.ALL.home(), \" Home \", evt -> {})\n" +
                "                        .addItem(Icons.ALL.library_books(), \" Library \", evt -> {})\n" +
                "                        .addItem(Icons.ALL.archive(), \" Data \", evt -> {})\n" +
                "                        .addItem(Icons.ALL.attachment(), \" File \", evt -> {})\n" +
                "                        .asElement())\n" +
                "                .appendContent(Breadcrumb.create()\n" +
                "                        .setBackground(Background.ORANGE)\n" +
                "                        .addItem(Icons.ALL.home(), \" Home \", evt -> {})\n" +
                "                        .addItem(Icons.ALL.library_books(), \" Library \", evt -> {})\n" +
                "                        .addItem(Icons.ALL.archive(), \" Data \", evt -> {})\n" +
                "                        .addItem(Icons.ALL.attachment(), \" File \", evt -> {})\n" +
                "                        .addItem(Icons.ALL.extension(), \" Extensions \", evt -> {})\n" +
                "                        .asElement())\n" +
                "                .asElement()))\n" +
                "        .asElement());")
                .asElement());
    }

    private void alignment() {
        element.appendChild(Card.create("ALIGNMENTS")
                .appendContent(Breadcrumb.create()
                        .setBackground(Background.PINK)
                        .addItem(Icons.ALL.home(), " Home ", evt -> {
                        })
                        .addItem(Icons.ALL.library_books(), " Library ", evt -> {
                        })
                        .asElement())
                .appendContent(Breadcrumb.create()
                        .alignCenter()
                        .setBackground(Background.CYAN)
                        .addItem(Icons.ALL.home(), " Home ", evt -> {
                        })
                        .addItem(Icons.ALL.library_books(), " Library ", evt -> {
                        })
                        .addItem(Icons.ALL.archive(), " Data ", evt -> {
                        })
                        .asElement())
                .appendContent(Breadcrumb.create()
                        .alignRight()
                        .setBackground(Background.TEAL)
                        .addItem(Icons.ALL.home(), " Home ", evt -> {
                        })
                        .addItem(Icons.ALL.library_books(), " Library ", evt -> {
                        })
                        .addItem(Icons.ALL.archive(), " Data ", evt -> {
                        })
                        .addItem(Icons.ALL.attachment(), " File ", evt -> {
                        })
                        .asElement())
                .asElement());

        element.appendChild(Card.createCodeCard("element.appendChild(Card.create(\"ALIGNMENTS\")\n" +
                "        .appendContent(Breadcrumb.create()\n" +
                "                .setBackground(Background.PINK)\n" +
                "                .addItem(Icons.ALL.home(), \" Home \", evt -> {\n" +
                "                })\n" +
                "                .addItem(Icons.ALL.library_books(), \" Library \", evt -> {\n" +
                "                })\n" +
                "                .asElement())\n" +
                "        .appendContent(Breadcrumb.create()\n" +
                "                .alignCenter()\n" +
                "                .setBackground(Background.CYAN)\n" +
                "                .addItem(Icons.ALL.home(), \" Home \", evt -> {\n" +
                "                })\n" +
                "                .addItem(Icons.ALL.library_books(), \" Library \", evt -> {\n" +
                "                })\n" +
                "                .addItem(Icons.ALL.archive(), \" Data \", evt -> {\n" +
                "                })\n" +
                "                .asElement())\n" +
                "        .appendContent(Breadcrumb.create()\n" +
                "                .alignRight()\n" +
                "                .setBackground(Background.TEAL)\n" +
                "                .addItem(Icons.ALL.home(), \" Home \", evt -> {\n" +
                "                })\n" +
                "                .addItem(Icons.ALL.library_books(), \" Library \", evt -> {\n" +
                "                })\n" +
                "                .addItem(Icons.ALL.archive(), \" Data \", evt -> {\n" +
                "                })\n" +
                "                .addItem(Icons.ALL.attachment(), \" File \", evt -> {\n" +
                "                })\n" +
                "                .asElement())\n" +
                "        .asElement());")
                .asElement());

    }

    @Override
    public void showIn(Content content) {
        HTMLElement contentElement = Js.cast(content.get());
        contentElement.appendChild(element);
    }
}