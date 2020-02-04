package org.dominokit.domino.breadcrumb.client.views.ui;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.SampleClass;
import org.dominokit.domino.SampleMethod;
import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.domino.breadcrumb.client.presenters.BreadcrumbProxy;
import org.dominokit.domino.breadcrumb.client.views.BreadcrumbView;
import org.dominokit.domino.componentcase.client.ui.views.CodeCard;
import org.dominokit.domino.componentcase.client.ui.views.LinkToSourceCode;
import org.dominokit.domino.ui.breadcrumbs.Breadcrumb;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.grid.Column;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.header.BlockHeader;
import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.componentcase.client.ui.views.BaseDemoView;
import org.jboss.elemento.Elements;

@UiView(presentable = BreadcrumbProxy.class)
@SampleClass
public class BreadcrumbViewImpl extends BaseDemoView<HTMLDivElement> implements BreadcrumbView {

    private HTMLDivElement element;

    @Override
    protected HTMLDivElement init() {

        element = Elements.div().element();
        element.appendChild(BlockHeader.create("BREADCRUMBS").element());

        basicBreadcrumb();
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.basicBreadcrumb())
                .element());

        coloredBreadcrumb();
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.coloredBreadcrumb())
                .element());

        breadcrumbWithBackground();
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.breadcrumbWithBackground())
                .element());

        alignment();
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.alignment())
                .element());

        return element;
    }

    @SampleMethod
    private void basicBreadcrumb() {
        element.appendChild(LinkToSourceCode.create("breadcrumb", this.getClass()).element());
        element.appendChild(Row.create()
                .addColumn(Column.span6()
                        .appendChild(Card.create("BASIC EXAMPLES", "Separators are automatically added for breadcrumb elements")
                                .appendChild(Breadcrumb.create()
                                        .appendChild(" Home ", evt -> {
                                        }))
                                .appendChild(Breadcrumb.create()
                                        .appendChild(" Home ", evt -> {
                                        })
                                        .appendChild(" Library ", evt -> {
                                        }))
                                .appendChild(Breadcrumb.create()
                                        .setAllowNavigation(false)
                                        .appendChild(" Home ", evt -> {
                                        })
                                        .appendChild(" Library ", evt -> {
                                        })
                                        .appendChild(" Data ", evt -> {
                                        })
                                )
                        ))
                .addColumn(Column.span6()
                        .appendChild(Card.create("WITH ICONS")
                                .appendChild(Breadcrumb.create()
                                        .appendChild(Icons.ALL.home(), " Home ", evt -> {
                                        }))
                                .appendChild(Breadcrumb.create()
                                        .appendChild(Icons.ALL.home(), " Home ", evt -> {
                                        })
                                        .appendChild(Icons.ALL.library_books(), " Library ", evt -> {
                                        }))
                                .appendChild(Breadcrumb.create()
                                        .appendChild(Icons.ALL.home(), " Home ", evt -> {
                                        })
                                        .appendChild(Icons.ALL.library_books(), " Library ", evt -> {
                                        })
                                        .appendChild(Icons.ALL.archive(), " Data ", evt -> {
                                        })
                                )
                        ))
                .element());
    }

    @SampleMethod
    private void coloredBreadcrumb() {
        element.appendChild(Row.create()
                .addColumn(Column.span6()
                        .appendChild(Card.create("WITH MATERIAL DESIGN COLORS", "You can use material design colors")
                                .appendChild(Breadcrumb.create()
                                        .setColor(Color.PINK)
                                        .appendChild(" Home ", evt -> {
                                        })
                                        .appendChild(" Library ", evt -> {
                                        })
                                )
                                .appendChild(Breadcrumb.create()
                                        .setColor(Color.CYAN)
                                        .appendChild(" Home ", evt -> {
                                        })
                                        .appendChild(" Library ", evt -> {
                                        })
                                        .appendChild(" Data ", evt -> {
                                        })
                                )
                                .appendChild(Breadcrumb.create()
                                        .setColor(Color.TEAL)
                                        .appendChild(" Home ", evt -> {
                                        })
                                        .appendChild(" Library ", evt -> {
                                        })
                                        .appendChild(" Data ", evt -> {
                                        })
                                        .appendChild(" File ", evt -> {
                                        })
                                )
                                .appendChild(Breadcrumb.create()
                                        .setColor(Color.ORANGE)
                                        .appendChild(" Home ", evt -> {
                                        })
                                        .appendChild(" Library ", evt -> {
                                        })
                                        .appendChild(" Data ", evt -> {
                                        })
                                        .appendChild(" File ", evt -> {
                                        })
                                        .appendChild(" Extensions ", evt -> {
                                        })
                                )
                        ))
                .addColumn(Column.span6()
                        .appendChild(Card.create("WITH ICONS & MATERIAL DESIGN COLORS")
                                .appendChild(Breadcrumb.create()
                                        .setColor(Color.PINK)
                                        .appendChild(Icons.ALL.home(), " Home ", evt -> {
                                        })
                                        .appendChild(Icons.ALL.library_books(), " Library ", evt -> {
                                        })
                                )
                                .appendChild(Breadcrumb.create()
                                        .setColor(Color.CYAN)
                                        .appendChild(Icons.ALL.home(), " Home ", evt -> {
                                        })
                                        .appendChild(Icons.ALL.library_books(), " Library ", evt -> {
                                        })
                                        .appendChild(Icons.ALL.archive(), " Data ", evt -> {
                                        })
                                )
                                .appendChild(Breadcrumb.create()
                                        .setColor(Color.TEAL)
                                        .appendChild(Icons.ALL.home(), " Home ", evt -> {
                                        })
                                        .appendChild(Icons.ALL.library_books(), " Library ", evt -> {
                                        })
                                        .appendChild(Icons.ALL.archive(), " Data ", evt -> {
                                        })
                                        .appendChild(Icons.ALL.attachment(), " File ", evt -> {
                                        })
                                )
                                .appendChild(Breadcrumb.create()
                                        .setColor(Color.ORANGE)
                                        .appendChild(Icons.ALL.home(), " Home ", evt -> {
                                        })
                                        .appendChild(Icons.ALL.library_books(), " Library ", evt -> {
                                        })
                                        .appendChild(Icons.ALL.archive(), " Data ", evt -> {
                                        })
                                        .appendChild(Icons.ALL.attachment(), " File ", evt -> {
                                        })
                                        .appendChild(Icons.ALL.extension(), " Extensions ", evt -> {
                                        })
                                )
                        ))
                .element());
    }

    @SampleMethod
    private void breadcrumbWithBackground() {
        element.appendChild(Row.create()
                .addColumn(Column.span6()
                        .appendChild(Card.create("WITH MATERIAL DESIGN COLORS", "You can use material design colors")
                                .appendChild(Breadcrumb.create()
                                        .setBackground(Color.RED)
                                        .appendChild(" Home ", evt -> {
                                        })
                                        .appendChild(" Library ", evt -> {
                                        })
                                )
                                .appendChild(Breadcrumb.create()
                                        .setBackground(Color.CYAN)
                                        .appendChild(" Home ", evt -> {
                                        })
                                        .appendChild(" Library ", evt -> {
                                        })
                                        .appendChild(" Data ", evt -> {
                                        })
                                )
                                .appendChild(Breadcrumb.create()
                                        .setBackground(Color.TEAL)
                                        .appendChild(" Home ", evt -> {
                                        })
                                        .appendChild(" Library ", evt -> {
                                        })
                                        .appendChild(" Data ", evt -> {
                                        })
                                        .appendChild(" File ", evt -> {
                                        })
                                )
                                .appendChild(Breadcrumb.create()
                                        .setBackground(Color.ORANGE)
                                        .appendChild(" Home ", evt -> {
                                        })
                                        .appendChild(" Library ", evt -> {
                                        })
                                        .appendChild(" Data ", evt -> {
                                        })
                                        .appendChild(" File ", evt -> {
                                        })
                                        .appendChild(" Extensions ", evt -> {
                                        })
                                )
                        ))
                .addColumn(Column.span6()
                        .appendChild(Card.create("WITH ICONS & MATERIAL DESIGN COLORS")
                                .appendChild(Breadcrumb.create()
                                        .setBackground(Color.RED)
                                        .appendChild(Icons.ALL.home(), " Home ", evt -> {
                                        })
                                        .appendChild(Icons.ALL.library_books(), " Library ", evt -> {
                                        })
                                )
                                .appendChild(Breadcrumb.create()
                                        .setBackground(Color.CYAN)
                                        .appendChild(Icons.ALL.home(), " Home ", evt -> {
                                        })
                                        .appendChild(Icons.ALL.library_books(), " Library ", evt -> {
                                        })
                                        .appendChild(Icons.ALL.archive(), " Data ", evt -> {
                                        })
                                )
                                .appendChild(Breadcrumb.create()
                                        .setBackground(Color.TEAL)
                                        .appendChild(Icons.ALL.home(), " Home ", evt -> {
                                        })
                                        .appendChild(Icons.ALL.library_books(), " Library ", evt -> {
                                        })
                                        .appendChild(Icons.ALL.archive(), " Data ", evt -> {
                                        })
                                        .appendChild(Icons.ALL.attachment(), " File ", evt -> {
                                        })
                                )
                                .appendChild(Breadcrumb.create()
                                        .setBackground(Color.ORANGE)
                                        .appendChild(Icons.ALL.home(), " Home ", evt -> {
                                        })
                                        .appendChild(Icons.ALL.library_books(), " Library ", evt -> {
                                        })
                                        .appendChild(Icons.ALL.archive(), " Data ", evt -> {
                                        })
                                        .appendChild(Icons.ALL.attachment(), " File ", evt -> {
                                        })
                                        .appendChild(Icons.ALL.extension(), " Extensions ", evt -> {
                                        })
                                )
                        ))
                .element());

    }

    @SampleMethod
    private void alignment() {
        element.appendChild(Card.create("ALIGNMENTS")
                .appendChild(Breadcrumb.create()
                        .setBackground(Color.RED)
                        .appendChild(Icons.ALL.home(), " Home ", evt -> {
                        })
                        .appendChild(Icons.ALL.library_books(), " Library ", evt -> {
                        })
                )
                .appendChild(Breadcrumb.create()
                        .alignCenter()
                        .setBackground(Color.CYAN)
                        .appendChild(Icons.ALL.home(), " Home ", evt -> {
                        })
                        .appendChild(Icons.ALL.library_books(), " Library ", evt -> {
                        })
                        .appendChild(Icons.ALL.archive(), " Data ", evt -> {
                        })
                )
                .appendChild(Breadcrumb.create()
                        .alignRight()
                        .setBackground(Color.TEAL)
                        .appendChild(Icons.ALL.home(), " Home ", evt -> {
                        })
                        .appendChild(Icons.ALL.library_books(), " Library ", evt -> {
                        })
                        .appendChild(Icons.ALL.archive(), " Data ", evt -> {
                        })
                        .appendChild(Icons.ALL.attachment(), " File ", evt -> {
                        })
                )
                .element());

    }
}