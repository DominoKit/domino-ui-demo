package org.dominokit.domino.breadcrumb.client.views.ui;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.domino.breadcrumb.client.presenters.BreadcrumbPresenter;
import org.dominokit.domino.breadcrumb.client.views.BreadcrumbView;
import org.dominokit.domino.breadcrumb.client.views.CodeResource;
import org.dominokit.domino.componentcase.shared.extension.ComponentView;
import org.dominokit.domino.ui.breadcrumbs.Breadcrumb;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.grid.Column;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.header.BlockHeader;
import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.style.Color;
import org.jboss.gwt.elemento.core.Elements;

@UiView(presentable = BreadcrumbPresenter.class)
public class BreadcrumbViewImpl extends ComponentView<HTMLDivElement> implements BreadcrumbView {

    private HTMLDivElement element = Elements.div().asElement();

    @Override
    public void init() {
        element.appendChild(BlockHeader.create("BREADCRUMBS").asElement());

        basicBreadcrumb();
        coloredBreadcrumb();
        breadcrumbWithBackground();
        alignment();
    }

    @Override
    public HTMLDivElement getElement() {
        return element;
    }

    private void basicBreadcrumb() {
        element.appendChild(Row.create()
                .addColumn(Column.span6().appendChild(Card.create("BASIC EXAMPLES", "Separators are automatically added for breadcrumb elements")
                        .appendChild(Breadcrumb.create()
                                .addItem(" Home ", evt -> {
                                }))
                        .appendChild(Breadcrumb.create()
                                .addItem(" Home ", evt -> {
                                })
                                .addItem(" Library ", evt -> {
                                }))
                        .appendChild(Breadcrumb.create()
                                .addItem(" Home ", evt -> {
                                })
                                .addItem(" Library ", evt -> {
                                })
                                .addItem(" Data ", evt -> {
                                })
                        )
                ))
                .addColumn(Column.span6().appendChild(Card.create("WITH ICONS")
                        .appendChild(Breadcrumb.create()
                                .addItem(Icons.ALL.home(), " Home ", evt -> {
                                }))
                        .appendChild(Breadcrumb.create()
                                .addItem(Icons.ALL.home(), " Home ", evt -> {
                                })
                                .addItem(Icons.ALL.library_books(), " Library ", evt -> {
                                }))
                        .appendChild(Breadcrumb.create()
                                .addItem(Icons.ALL.home(), " Home ", evt -> {
                                })
                                .addItem(Icons.ALL.library_books(), " Library ", evt -> {
                                })
                                .addItem(Icons.ALL.archive(), " Data ", evt -> {
                                })
                        )
                ))
                .asElement());

        element.appendChild(Card.createCodeCard(CodeResource.INSTANCE.basicBreadcrumb())
                .asElement());
    }

    private void coloredBreadcrumb() {
        element.appendChild(Row.create()
                .addColumn(Column.span6().appendChild(Card.create("WITH MATERIAL DESIGN COLORS", "You can use material design colors")
                        .appendChild(Breadcrumb.create()
                                .setColor(Color.PINK)
                                .addItem(" Home ", evt -> {
                                })
                                .addItem(" Library ", evt -> {
                                })
                        )
                        .appendChild(Breadcrumb.create()
                                .setColor(Color.CYAN)
                                .addItem(" Home ", evt -> {
                                })
                                .addItem(" Library ", evt -> {
                                })
                                .addItem(" Data ", evt -> {
                                })
                        )
                        .appendChild(Breadcrumb.create()
                                .setColor(Color.TEAL)
                                .addItem(" Home ", evt -> {
                                })
                                .addItem(" Library ", evt -> {
                                })
                                .addItem(" Data ", evt -> {
                                })
                                .addItem(" File ", evt -> {
                                })
                        )
                        .appendChild(Breadcrumb.create()
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
                        )
                ))
                .addColumn(Column.span6().appendChild(Card.create("WITH ICONS & MATERIAL DESIGN COLORS")
                        .appendChild(Breadcrumb.create()
                                .setColor(Color.PINK)
                                .addItem(Icons.ALL.home(), " Home ", evt -> {
                                })
                                .addItem(Icons.ALL.library_books(), " Library ", evt -> {
                                })
                        )
                        .appendChild(Breadcrumb.create()
                                .setColor(Color.CYAN)
                                .addItem(Icons.ALL.home(), " Home ", evt -> {
                                })
                                .addItem(Icons.ALL.library_books(), " Library ", evt -> {
                                })
                                .addItem(Icons.ALL.archive(), " Data ", evt -> {
                                })
                        )
                        .appendChild(Breadcrumb.create()
                                .setColor(Color.TEAL)
                                .addItem(Icons.ALL.home(), " Home ", evt -> {
                                })
                                .addItem(Icons.ALL.library_books(), " Library ", evt -> {
                                })
                                .addItem(Icons.ALL.archive(), " Data ", evt -> {
                                })
                                .addItem(Icons.ALL.attachment(), " File ", evt -> {
                                })
                        )
                        .appendChild(Breadcrumb.create()
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
                        )
                ))
                .asElement());


        element.appendChild(Card.createCodeCard(CodeResource.INSTANCE.coloredBreadcrumb())
                .asElement());
    }

    private void breadcrumbWithBackground() {
        element.appendChild(Row.create()
                .addColumn(Column.span6().appendChild(Card.create("WITH MATERIAL DESIGN COLORS", "You can use material design colors")
                        .appendChild(Breadcrumb.create()
                                .setBackground(Color.RED)
                                .addItem(" Home ", evt -> {
                                })
                                .addItem(" Library ", evt -> {
                                })
                        )
                        .appendChild(Breadcrumb.create()
                                .setBackground(Color.CYAN)
                                .addItem(" Home ", evt -> {
                                })
                                .addItem(" Library ", evt -> {
                                })
                                .addItem(" Data ", evt -> {
                                })
                        )
                        .appendChild(Breadcrumb.create()
                                .setBackground(Color.TEAL)
                                .addItem(" Home ", evt -> {
                                })
                                .addItem(" Library ", evt -> {
                                })
                                .addItem(" Data ", evt -> {
                                })
                                .addItem(" File ", evt -> {
                                })
                        )
                        .appendChild(Breadcrumb.create()
                                .setBackground(Color.ORANGE)
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
                        )
                ))
                .addColumn(Column.span6().appendChild(Card.create("WITH ICONS & MATERIAL DESIGN COLORS")
                        .appendChild(Breadcrumb.create()
                                .setBackground(Color.RED)
                                .addItem(Icons.ALL.home(), " Home ", evt -> {
                                })
                                .addItem(Icons.ALL.library_books(), " Library ", evt -> {
                                })
                        )
                        .appendChild(Breadcrumb.create()
                                .setBackground(Color.CYAN)
                                .addItem(Icons.ALL.home(), " Home ", evt -> {
                                })
                                .addItem(Icons.ALL.library_books(), " Library ", evt -> {
                                })
                                .addItem(Icons.ALL.archive(), " Data ", evt -> {
                                })
                        )
                        .appendChild(Breadcrumb.create()
                                .setBackground(Color.TEAL)
                                .addItem(Icons.ALL.home(), " Home ", evt -> {
                                })
                                .addItem(Icons.ALL.library_books(), " Library ", evt -> {
                                })
                                .addItem(Icons.ALL.archive(), " Data ", evt -> {
                                })
                                .addItem(Icons.ALL.attachment(), " File ", evt -> {
                                })
                        )
                        .appendChild(Breadcrumb.create()
                                .setBackground(Color.ORANGE)
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
                        )
                ))
                .asElement());


        element.appendChild(Card.createCodeCard(CodeResource.INSTANCE.breadcrumbWithBackground())
                .asElement());
    }

    private void alignment() {
        element.appendChild(Card.create("ALIGNMENTS")
                .appendChild(Breadcrumb.create()
                        .setBackground(Color.RED)
                        .addItem(Icons.ALL.home(), " Home ", evt -> {
                        })
                        .addItem(Icons.ALL.library_books(), " Library ", evt -> {
                        })
                )
                .appendChild(Breadcrumb.create()
                        .alignCenter()
                        .setBackground(Color.CYAN)
                        .addItem(Icons.ALL.home(), " Home ", evt -> {
                        })
                        .addItem(Icons.ALL.library_books(), " Library ", evt -> {
                        })
                        .addItem(Icons.ALL.archive(), " Data ", evt -> {
                        })
                )
                .appendChild(Breadcrumb.create()
                        .alignRight()
                        .setBackground(Color.TEAL)
                        .addItem(Icons.ALL.home(), " Home ", evt -> {
                        })
                        .addItem(Icons.ALL.library_books(), " Library ", evt -> {
                        })
                        .addItem(Icons.ALL.archive(), " Data ", evt -> {
                        })
                        .addItem(Icons.ALL.attachment(), " File ", evt -> {
                        })
                )
                .asElement());

        element.appendChild(Card.createCodeCard(CodeResource.INSTANCE.alignment())
                .asElement());

    }
}