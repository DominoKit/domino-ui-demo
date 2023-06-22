package org.dominokit.domino.labels.client.views.ui;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.SampleClass;
import org.dominokit.domino.SampleMethod;
import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.domino.componentcase.client.ui.views.BaseDemoView;
import org.dominokit.domino.componentcase.client.ui.views.CodeCard;
import org.dominokit.domino.componentcase.client.ui.views.LinkToSourceCode;
import org.dominokit.domino.labels.client.presenters.LabelsProxy;
import org.dominokit.domino.labels.client.views.LabelsView;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.grid.Column;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.labels.Label;
import org.dominokit.domino.ui.typography.BlockHeader;

@UiView(presentable = LabelsProxy.class)
@SampleClass
public class LabelsViewImpl extends BaseDemoView<HTMLDivElement> implements LabelsView {

    private DivElement element = div();

    @Override
    protected HTMLDivElement init() {

        element.appendChild(LinkToSourceCode.createLink("labels", this.getClass()).element());
        element.appendChild(BlockHeader.create("LABELS").element());

        initLabels();
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.initLabels()).element());

        initMaterialLabels();
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.initMaterialLabels()).element());

        return element.element();
    }

    @SampleMethod
    private void initLabels() {
        element.appendChild(Card.create("LABELS")
                .appendChild(Row.create()
                        .appendChild(Column.span1()
                                .appendChild(Label.create("DEFAULT")
                                        .addCss(dui_m_4)
                                )
                        )
                        .appendChild(Column.span1()
                                .appendChild(Label.create("PRIMARY")
                                        .addCss(dui_m_4, dui_primary)
                                )
                        )
                        .appendChild(Column.span1()
                                .appendChild(Label.create("SUCCESS")
                                        .addCss(dui_m_4, dui_success)
                                )
                        )
                        .appendChild(Column.span1()
                                .appendChild(Label.create("INFO")
                                        .addCss(dui_m_4, dui_info)
                                )
                        )
                        .appendChild(Column.span1().appendChild(Label.create("WARNING")
                                        .addCss(dui_m_4, dui_warning)
                                )
                        )
                        .appendChild(Column.span1().appendChild(Label.create("DANGER")
                                        .addCss(dui_m_4, dui_error)
                                )
                        )
                        .appendChild(Column.span1().appendChild(Label.create("ROUNDED")
                                        .addCss(dui_m_4, dui_bg_accent, dui_fg_white, dui_rounded_full)
                                )
                        )
                )
                .appendChild(hr())
                .appendChild(h(1).addCss(dui_text_left)
                        .textContent("Example heading ")
                        .appendChild(Label.create("New")
                                .addCss(dui_error)
                        )
                )
                .appendChild(h(2)
                        .textContent("Example heading ")
                        .appendChild(Label.create("New")
                                .addCss(dui_warning)
                        )
                )
                .appendChild(h(3)
                        .textContent("Example heading ")
                        .appendChild(Label.create("New")
                                .addCss(dui_info)
                        )
                )
                .appendChild(h(4)
                        .textContent("Example heading ")
                        .appendChild(Label.create("New")
                                .addCss(dui_success)
                        )
                )
                .appendChild(h(5)
                        .textContent("Example heading ")
                        .appendChild(Label.create("New")
                                .addCss(dui_primary)
                        )
                )
                .appendChild(h(6)
                        .textContent("Example heading ")
                        .appendChild(Label.create("New")))
                .element());


    }

    @SampleMethod
    private void initMaterialLabels() {

        element.appendChild(Card.create("LABELS WITH MATERIAL DESIGN COLORS", "You can use material design color with labels")
                .appendChild(Row.create()
                        .appendChild(Column.span1().appendChild(Label.create("Red")
                                        .addCss(dui_m_4, dui_red)
                                )
                        )
                        .appendChild(Column.span1().appendChild(Label.create("Pink")
                                        .addCss(dui_m_4, dui_pink)
                                )
                        )
                        .appendChild(Column.span1().appendChild(Label.create("Purple")
                                        .addCss(dui_m_4, dui_purple)
                                )
                        )
                        .appendChild(Column.span1().appendChild(Label.create("Deep Purple")
                                        .addCss(dui_m_4, dui_deep_purple)
                                )
                        )
                        .appendChild(Column.span1().appendChild(Label.create("Indigo")
                                        .addCss(dui_m_4, dui_indigo)
                                )
                        )
                        .appendChild(Column.span1().appendChild(Label.create("Blue")
                                        .addCss(dui_m_4, dui_blue)
                                )
                        )
                        .appendChild(Column.span1().appendChild(Label.create("Light Blue")
                                        .addCss(dui_m_4, dui_light_blue)
                                )
                        )
                        .appendChild(Column.span1().appendChild(Label.create("Cyan")
                                        .addCss(dui_m_4, dui_cyan)
                                )
                        )
                        .appendChild(Column.span1().appendChild(Label.create("Teal")
                                        .addCss(dui_m_4, dui_teal)
                                )
                        )
                        .appendChild(Column.span1().appendChild(Label.create("Green")
                                        .addCss(dui_m_4, dui_green)
                                )
                        )
                        .appendChild(Column.span1().appendChild(Label.create("Orange")
                                        .addCss(dui_m_4, dui_orange)
                                )
                        )
                        .appendChild(Column.span1().appendChild(Label.create("Yellow")
                                        .addCss(dui_m_4, dui_yellow)
                                )
                        )
                )
        );


    }
}