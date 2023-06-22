package org.dominokit.domino.breadcrumb.client.views.ui;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.SampleClass;
import org.dominokit.domino.SampleMethod;
import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.domino.breadcrumb.client.presenters.BreadcrumbProxy;
import org.dominokit.domino.breadcrumb.client.views.BreadcrumbView;
import org.dominokit.domino.componentcase.client.ui.views.BaseDemoView;
import org.dominokit.domino.componentcase.client.ui.views.CodeCard;
import org.dominokit.domino.componentcase.client.ui.views.LinkToSourceCode;
import org.dominokit.domino.ui.breadcrumbs.Breadcrumb;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.grid.Column;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.icons.lib.Icons;
import org.dominokit.domino.ui.typography.BlockHeader;

@UiView(presentable = BreadcrumbProxy.class)
@SampleClass
public class BreadcrumbViewImpl extends BaseDemoView<HTMLDivElement> implements BreadcrumbView {

    private DivElement element;

    @Override
    protected HTMLDivElement init() {
        element = div();
        element.appendChild(LinkToSourceCode.createLink("breadcrumb", this.getClass()).element());
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

        return element.element();
    }

    @SampleMethod
    private void basicBreadcrumb() {
        element.appendChild(Row.create()
                .appendChild(Column.span6()
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
                                        .disable()
                                        .appendChild(" Home ", evt -> {
                                        })
                                        .appendChild(" Library ", evt -> {
                                        })
                                        .appendChild(" Data ", evt -> {
                                        })
                                )
                        ))
                .appendChild(Column.span6()
                        .appendChild(Card.create("WITH ICONS")
                                .appendChild(Breadcrumb.create()
                                        .appendChild(Icons.home(), " Home ", evt -> {
                                        }))
                                .appendChild(Breadcrumb.create()
                                        .appendChild(Icons.home(), " Home ", evt -> {
                                        })
                                        .appendChild(Icons.filmstrip_box(), " Library ", evt -> {
                                        }))
                                .appendChild(Breadcrumb.create()
                                        .appendChild(Icons.home(), " Home ", evt -> {
                                        })
                                        .appendChild(Icons.filmstrip_box(), " Library ", evt -> {
                                        })
                                        .appendChild(Icons.archive(), " Data ", evt -> {
                                        })
                                )
                        ))
                .element());
    }

    @SampleMethod
    private void coloredBreadcrumb() {
        element.appendChild(Row.create()
                .appendChild(Column.span6()
                        .appendChild(Card.create("WITH MATERIAL DESIGN COLORS", "You can use material design colors")
                                .appendChild(Breadcrumb.create()
                                        .addCss(dui_accent_pink)
                                        .appendChild(" Home ", evt -> {
                                        })
                                        .appendChild(" Library ", evt -> {
                                        })
                                )
                                .appendChild(Breadcrumb.create()
                                        .addCss(dui_accent_cyan)
                                        .appendChild(" Home ", evt -> {
                                        })
                                        .appendChild(" Library ", evt -> {
                                        })
                                        .appendChild(" Data ", evt -> {
                                        })
                                )
                                .appendChild(Breadcrumb.create()
                                        .addCss(dui_accent_teal)
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
                                        .addCss(dui_accent_orange)
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
                .appendChild(Column.span6()
                        .appendChild(Card.create("WITH ICONS & MATERIAL DESIGN COLORS")
                                .appendChild(Breadcrumb.create()
                                        .addCss(dui_accent_pink)
                                        .appendChild(Icons.home(), " Home ", evt -> {
                                        })
                                        .appendChild(Icons.filmstrip_box(), " Library ", evt -> {
                                        })
                                )
                                .appendChild(Breadcrumb.create()
                                        .addCss(dui_accent_cyan)
                                        .appendChild(Icons.home(), " Home ", evt -> {
                                        })
                                        .appendChild(Icons.filmstrip_box(), " Library ", evt -> {
                                        })
                                        .appendChild(Icons.archive(), " Data ", evt -> {
                                        })
                                )
                                .appendChild(Breadcrumb.create()
                                        .addCss(dui_accent_teal)
                                        .appendChild(Icons.home(), " Home ", evt -> {
                                        })
                                        .appendChild(Icons.filmstrip_box(), " Library ", evt -> {
                                        })
                                        .appendChild(Icons.archive(), " Data ", evt -> {
                                        })
                                        .appendChild(Icons.attachment(), " File ", evt -> {
                                        })
                                )
                                .appendChild(Breadcrumb.create()
                                        .addCss(dui_accent_orange)
                                        .appendChild(Icons.home(), " Home ", evt -> {
                                        })
                                        .appendChild(Icons.filmstrip_box(), " Library ", evt -> {
                                        })
                                        .appendChild(Icons.archive(), " Data ", evt -> {
                                        })
                                        .appendChild(Icons.attachment(), " File ", evt -> {
                                        })
                                        .appendChild(Icons.widgets(), " Extensions ", evt -> {
                                        })
                                )
                        ))
                .element());
    }

    @SampleMethod
    private void breadcrumbWithBackground() {
        element.appendChild(Row.create()
                .appendChild(Column.span6()
                        .appendChild(Card.create("WITH MATERIAL DESIGN COLORS", "You can use material design colors")
                                .appendChild(Breadcrumb.create()
                                        .addCss(dui_bg_red, dui_fg_white)
                                        .appendChild(" Home ", evt -> {
                                        })
                                        .appendChild(" Library ", evt -> {
                                        })
                                )
                                .appendChild(Breadcrumb.create()
                                        .addCss(dui_bg_cyan, dui_fg_white)
                                        .appendChild(" Home ", evt -> {
                                        })
                                        .appendChild(" Library ", evt -> {
                                        })
                                        .appendChild(" Data ", evt -> {
                                        })
                                )
                                .appendChild(Breadcrumb.create()
                                        .addCss(dui_bg_teal, dui_fg_white)
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
                                        .addCss(dui_bg_orange, dui_fg_white)
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
                .appendChild(Column.span6()
                        .appendChild(Card.create("WITH ICONS & MATERIAL DESIGN COLORS")
                                .appendChild(Breadcrumb.create()
                                        .addCss(dui_bg_red, dui_fg_white)
                                        .appendChild(Icons.home(), " Home ", evt -> {
                                        })
                                        .appendChild(Icons.filmstrip_box(), " Library ", evt -> {
                                        })
                                )
                                .appendChild(Breadcrumb.create()
                                        .addCss(dui_bg_cyan, dui_fg_white)
                                        .appendChild(Icons.home(), " Home ", evt -> {
                                        })
                                        .appendChild(Icons.filmstrip_box(), " Library ", evt -> {
                                        })
                                        .appendChild(Icons.archive(), " Data ", evt -> {
                                        })
                                )
                                .appendChild(Breadcrumb.create()
                                        .addCss(dui_bg_teal, dui_fg_white)
                                        .appendChild(Icons.home(), " Home ", evt -> {
                                        })
                                        .appendChild(Icons.filmstrip_box(), " Library ", evt -> {
                                        })
                                        .appendChild(Icons.archive(), " Data ", evt -> {
                                        })
                                        .appendChild(Icons.attachment(), " File ", evt -> {
                                        })
                                )
                                .appendChild(Breadcrumb.create()
                                        .addCss(dui_bg_orange, dui_fg_white)
                                        .appendChild(Icons.home(), " Home ", evt -> {
                                        })
                                        .appendChild(Icons.filmstrip_box(), " Library ", evt -> {
                                        })
                                        .appendChild(Icons.archive(), " Data ", evt -> {
                                        })
                                        .appendChild(Icons.attachment(), " File ", evt -> {
                                        })
                                        .appendChild(Icons.widgets(), " Extensions ", evt -> {
                                        })
                                )
                        ))
                .element());

    }

    @SampleMethod
    private void alignment() {
        element.appendChild(Card.create("ALIGNMENTS")
                .appendChild(Breadcrumb.create()
                        .addCss(dui_bg_red, dui_fg_white)
                        .appendChild(Icons.home(), " Home ", evt -> {
                        })
                        .appendChild(Icons.filmstrip_box(), " Library ", evt -> {
                        })
                )
                .appendChild(Breadcrumb.create()
                        .alignCenter()
                        .addCss(dui_bg_cyan, dui_fg_white)
                        .appendChild(Icons.home(), " Home ", evt -> {
                        })
                        .appendChild(Icons.filmstrip_box(), " Library ", evt -> {
                        })
                        .appendChild(Icons.archive(), " Data ", evt -> {
                        })
                )
                .appendChild(Breadcrumb.create()
                        .alignRight()
                        .addCss(dui_bg_teal, dui_fg_white)
                        .appendChild(Icons.home(), " Home ", evt -> {
                        })
                        .appendChild(Icons.filmstrip_box(), " Library ", evt -> {
                        })
                        .appendChild(Icons.archive(), " Data ", evt -> {
                        })
                        .appendChild(Icons.attachment(), " File ", evt -> {
                        })
                )
                .element());

    }
}