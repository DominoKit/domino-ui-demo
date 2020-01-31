package org.dominokit.domino.labels.client.views.ui;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.SampleClass;
import org.dominokit.domino.SampleMethod;
import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.domino.componentcase.client.ui.views.CodeCard;
import org.dominokit.domino.componentcase.client.ui.views.LinkToSourceCode;
import org.dominokit.domino.labels.client.presenters.LabelsProxy;
import org.dominokit.domino.labels.client.views.LabelsView;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.grid.Column;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.header.BlockHeader;
import org.dominokit.domino.ui.labels.Label;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.componentcase.client.ui.views.BaseDemoView;
import org.jboss.elemento.Elements;

@UiView(presentable = LabelsProxy.class)
@SampleClass
public class LabelsViewImpl extends BaseDemoView<HTMLDivElement> implements LabelsView {

    private HTMLDivElement element = Elements.div().element();

    @Override
    protected HTMLDivElement init() {

        element.appendChild(LinkToSourceCode.create("labels", this.getClass()).element());
        element.appendChild(BlockHeader.create("LABELS").element());

        initLabels();
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.initLabels()).element());

        initMaterialLabels();
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.initMaterialLabels()).element());

        return element;
    }

    @SampleMethod
    private void initMaterialLabels() {

        Column column = Column.span(1, 2, 6, 12);
        element.appendChild(Card.create("LABELS WITH MATERIAL DESIGN COLORS", "You can use material design color with labels")
                .appendChild(Row.create()
                        .addColumn(column.appendChild(Label.create("Red")
                                .setBackground(Color.RED)
                                .style().setMargin("10px")))
                        .addColumn(column.copy().appendChild(Label.create("Pink")
                                .setBackground(Color.PINK)
                                .style().setMargin("10px")))
                        .addColumn(column.copy().appendChild(Label.create("Purple")
                                .setBackground(Color.PURPLE)
                                .style().setMargin("10px")))
                        .addColumn(column.copy().appendChild(Label.create("Deep Purple")
                                .setBackground(Color.DEEP_PURPLE)
                                .style().setMargin("10px")))
                        .addColumn(column.copy().appendChild(Label.create("Indigo")
                                .setBackground(Color.INDIGO)
                                .style().setMargin("10px")))
                        .addColumn(column.copy().appendChild(Label.create("Blue")
                                .setBackground(Color.BLUE)
                                .style().setMargin("10px")))
                        .addColumn(column.copy().appendChild(Label.create("Light Blue")
                                .setBackground(Color.LIGHT_BLUE)
                                .style().setMargin("10px")))
                        .addColumn(column.copy().appendChild(Label.create("Cyan")
                                .setBackground(Color.CYAN)
                                .style().setMargin("10px")))
                        .addColumn(column.copy().appendChild(Label.create("Teal")
                                .setBackground(Color.TEAL)
                                .style().setMargin("10px")))
                        .addColumn(column.copy().appendChild(Label.create("Green")
                                .setBackground(Color.GREEN)
                                .style().setMargin("10px")))
                        .addColumn(column.copy().appendChild(Label.create("Orange")
                                .setBackground(Color.ORANGE)
                                .style().setMargin("10px")))
                        .addColumn(column.copy().appendChild(Label.create("Yellow")
                                .setBackground(Color.YELLOW)
                                .style().setMargin("10px"))))
                .element());


    }

    @SampleMethod
    private void initLabels() {
        Column column = Column.span(1, 2, 6, 12);
        element.appendChild(Card.create("LABELS")
                .appendChild(Row.create()
                        .addColumn(column.copy().appendChild(Label.createDefault("DEFAULT")
                                .style().setMargin("10px")))
                        .addColumn(column.copy().appendChild(Label.createPrimary("PRIMARY")
                                .style().setMargin("10px")))
                        .addColumn(column.copy().appendChild(Label.createSuccess("SUCCESS")
                                .style().setMargin("10px")))
                        .addColumn(column.copy().appendChild(Label.createInfo("INFO")
                                .style().setMargin("10px")))
                        .addColumn(column.copy().appendChild(Label.createWarning("WARNING")
                                .style().setMargin("10px")))
                        .addColumn(column.copy().appendChild(Label.createDanger("DANGER")
                                .style().setMargin("10px"))))
                .appendChild(Elements.hr())
                .appendChild(Elements.h(1)
                        .style("text-align: left;")
                        .textContent("Example heading ")
                        .add(Label.createDanger("New")))
                .appendChild(Elements.h(2)
                        .textContent("Example heading ")
                        .add(Label.createWarning("New")))
                .appendChild(Elements.h(3)
                        .textContent("Example heading ")
                        .add(Label.createInfo("New")))
                .appendChild(Elements.h(4)
                        .textContent("Example heading ")
                        .add(Label.createSuccess("New")))
                .appendChild(Elements.h(5)
                        .textContent("Example heading ")
                        .add(Label.createPrimary("New")))
                .appendChild(Elements.h(6)
                        .textContent("Example heading ")
                        .add(Label.createDefault("New")))
                .element());



    }
}