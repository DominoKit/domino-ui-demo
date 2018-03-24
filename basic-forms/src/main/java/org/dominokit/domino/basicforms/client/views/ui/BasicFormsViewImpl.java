package org.dominokit.domino.basicforms.client.views.ui;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.domino.basicforms.client.presenters.BasicFormsPresenter;
import org.dominokit.domino.basicforms.client.views.BasicFormsView;
import org.dominokit.domino.basicforms.client.views.CodeResource;
import org.dominokit.domino.componentcase.shared.extension.ComponentView;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.column.Column;
import org.dominokit.domino.ui.forms.TextArea;
import org.dominokit.domino.ui.forms.TextBox;
import org.dominokit.domino.ui.header.BlockHeader;
import org.dominokit.domino.ui.row.Row;
import org.jboss.gwt.elemento.core.Elements;

@UiView(presentable = BasicFormsPresenter.class)
public class BasicFormsViewImpl extends ComponentView<HTMLDivElement> implements BasicFormsView {

    private HTMLDivElement element = Elements.div().asElement();
    private Card inputCard;
    private Card textAreaCard;

    @Override
    public HTMLDivElement getElement() {
        return element;
    }

    @Override
    public void init() {
        element.appendChild(BlockHeader.create("BASIC FORM ELEMENTS").asElement());

        inputCard = Card.create("INPUT", "Different sizes and widths.");
        textAreaCard = Card.create("TEXTAREA");

        initBasicExamples();
        initDifferentWidths();
        initDifferentSizes();
        initFloatingLabel();
        initInputStatus();

        initBasicTextAreaExample();

        element.appendChild(inputCard.asElement());
        element.appendChild(Card.createCodeCard(CodeResource.INSTANCE.textboxSamples()).asElement());
        element.appendChild(textAreaCard.asElement());
        element.appendChild(Card.createCodeCard(CodeResource.INSTANCE.textareaSamples()).asElement());

    }

    private void initBasicExamples() {
        inputCard.appendContent(BlockHeader.create("Basic Example").asElement())
                .appendContent(TextBox.create("Username").asElement())
                .appendContent(TextBox.password("Password").asElement());
    }

    private void initDifferentWidths() {
        Column column6Size = Column.create().onSmall(Column.OnSmall.six);
        Column column4Size = Column.create().onSmall(Column.OnSmall.four);
        Column column3Size = Column.create().onSmall(Column.OnSmall.three);


        inputCard.appendContent(BlockHeader.create("Different Widths").asElement())
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
        inputCard.appendContent(BlockHeader.create("Different Sizes").asElement())
                .appendContent(TextBox.create("Large Input").large().asElement())
                .appendContent(TextBox.create("Default Input").asElement())
                .appendContent(TextBox.create("Small Input").small().asElement());
    }

    private void initFloatingLabel() {
        inputCard.appendContent(BlockHeader.create("Floating Label Examples").asElement())
                .appendContent(TextBox.create("Username").floating().asElement())
                .appendContent(TextBox.password("Password").floating().asElement())
                .appendContent(TextBox.create("Large Input").large().floating().asElement())
                .appendContent(TextBox.create("Default Input").floating().asElement())
                .appendContent(TextBox.create("Small Input").small().floating().asElement());
    }

    private void initInputStatus() {
        Column column6Size = Column.create().onSmall(Column.OnSmall.six);

        inputCard.appendContent(BlockHeader.create("Input Status").asElement())
                .appendContent(Row.create()
                        .addColumn(column6Size
                                .addElement(TextBox.create("Focused").focus().asElement()))
                        .addColumn(column6Size.copy()
                                .addElement(TextBox.create("Disabled").disable().asElement())).asElement());
    }

    private void initBasicTextAreaExample() {
        textAreaCard.appendContent(BlockHeader.create("Basic Examples").asElement())
                .appendContent(TextArea.create("Please type what you want...").asElement());

        textAreaCard.appendContent(BlockHeader.create("Auto Growing Vertical Direction").asElement())
                .appendContent(TextArea.create("Please type what you want...").autoSize().asElement());
    }
}