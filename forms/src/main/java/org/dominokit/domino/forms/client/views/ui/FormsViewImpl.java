package org.dominokit.domino.forms.client.views.ui;

import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.domino.componentcase.shared.extension.ComponentView;
import org.dominokit.domino.forms.client.presenters.FormsPresenter;
import org.dominokit.domino.forms.client.views.CodeResource;
import org.dominokit.domino.forms.client.views.FormsView;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.column.Column;
import org.dominokit.domino.ui.forms.TextBox;
import org.dominokit.domino.ui.header.BlockHeader;
import org.dominokit.domino.ui.row.Row;
import elemental2.dom.HTMLDivElement;
import org.jboss.gwt.elemento.core.Elements;

@UiView(presentable = FormsPresenter.class)
public class FormsViewImpl extends ComponentView<HTMLDivElement> implements FormsView {

    private HTMLDivElement element = Elements.div().asElement();
    private Card card;

    @Override
    public HTMLDivElement getElement() {
        return element;
    }

    @Override
    public void init() {
        element.appendChild(BlockHeader.create("BASIC FORM ELEMENTS").asElement());

        card = Card.create("INPUT", "Different sizes and widths.");

        initBasicExamples();
        initDifferentWidths();
        initDifferentSizes();
        initFloatingLabel();
        initInputStatus();

        element.appendChild(card.asElement());
        element.appendChild(Card.createCodeCard(CodeResource.INSTANCE.forms()).asElement());
    }

    private void initBasicExamples() {
        card.appendContent(BlockHeader.create("Basic Examples").asElement())
                .appendContent(TextBox.create("Username").asElement())
                .appendContent(TextBox.password("Password").asElement());
    }

    private void initDifferentWidths() {
        Column column6Size = Column.create().onSmall(Column.OnSmall.six);
        Column column4Size = Column.create().onSmall(Column.OnSmall.four);
        Column column3Size = Column.create().onSmall(Column.OnSmall.three);


        card.appendContent(BlockHeader.create("Different Widths").asElement())
                .appendContent(Row.create()
                        .addColumn(column6Size
                                .addElement(TextBox.create("col-sm-6").asElement()))
                        .addColumn(column6Size.copy()
                                .addElement(TextBox.create("col-sm-6").asElement()))
                        .asElement())
                .appendContent(Row.create()
                        .addColumn(column4Size
                                .addElement(TextBox.create("col-sm-4").asElement()))
                        .addColumn(column4Size.copy()
                                .addElement(TextBox.create("col-sm-4").asElement()))
                        .addColumn(column4Size.copy()
                                .addElement(TextBox.create("col-sm-4").asElement()))
                        .asElement())
                .appendContent(Row.create()
                        .addColumn(column3Size
                                .addElement(TextBox.create("col-sm-3").asElement()))
                        .addColumn(column3Size.copy()
                                .addElement(TextBox.create("col-sm-3").asElement()))
                        .addColumn(column3Size.copy()
                                .addElement(TextBox.create("col-sm-3").asElement()))
                        .addColumn(column3Size.copy()
                                .addElement(TextBox.create("col-sm-3").asElement()))
                        .asElement());
    }

    private void initDifferentSizes() {
        card.appendContent(BlockHeader.create("Different Sizes").asElement())
                .appendContent(TextBox.create("Large Input").large().asElement())
                .appendContent(TextBox.create("Default Input").asElement())
                .appendContent(TextBox.create("Small Input").small().asElement());
    }

    private void initFloatingLabel() {
        card.appendContent(BlockHeader.create("Floating Label Examples").asElement())
                .appendContent(TextBox.create("Username").floating().asElement())
                .appendContent(TextBox.password("Password").floating().asElement())
                .appendContent(TextBox.create("Large Input").large().floating().asElement())
                .appendContent(TextBox.create("Default Input").floating().asElement())
                .appendContent(TextBox.create("Small Input").small().floating().asElement());
    }

    private void initInputStatus() {
        Column column6Size = Column.create().onSmall(Column.OnSmall.six);

        card.appendContent(BlockHeader.create("Input Status").asElement())
                .appendContent(Row.create()
                        .addColumn(column6Size
                                .addElement(TextBox.create("Focused").focus().asElement()))
                        .addColumn(column6Size.copy()
                                .addElement(TextBox.create("Disabled").disable().asElement())).asElement());
    }
}