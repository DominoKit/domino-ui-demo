package org.dominokit.domino.basicforms.client.views.ui;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.domino.basicforms.client.presenters.BasicFormsPresenter;
import org.dominokit.domino.basicforms.client.views.BasicFormsView;
import org.dominokit.domino.basicforms.client.views.CodeResource;
import org.dominokit.domino.componentcase.shared.extension.ComponentView;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.column.Column;
import org.dominokit.domino.ui.forms.*;
import org.dominokit.domino.ui.header.BlockHeader;
import org.dominokit.domino.ui.notifications.Notification;
import org.dominokit.domino.ui.row.Row;
import org.dominokit.domino.ui.style.Color;
import org.jboss.gwt.elemento.core.Elements;

@UiView(presentable = BasicFormsPresenter.class)
public class BasicFormsViewImpl extends ComponentView<HTMLDivElement> implements BasicFormsView {

    private HTMLDivElement element = Elements.div().asElement();
    private Card inputCard;
    private Card textAreaCard;
    private Card selectCard;
    private Card checkboxCard;

    @Override
    public HTMLDivElement getElement() {
        return element;
    }

    @Override
    public void init() {
        element.appendChild(BlockHeader.create("BASIC FORM ELEMENTS").asElement());

        inputCard = Card.create("INPUT", "Different sizes and widths.");
        textAreaCard = Card.create("TEXTAREA");
        selectCard = Card.create("SELECT");
        checkboxCard = Card.create("CHECKBOX");

        initBasicExamples();
        initDifferentWidths();
        initDifferentSizes();
        initFloatingLabel();
        initInputStatus();

        initBasicTextAreaExample();

        initSelectExample();

        initCheckboxExample();

        element.appendChild(inputCard.asElement());
        element.appendChild(Card.createCodeCard(CodeResource.INSTANCE.textboxSamples()).asElement());
        element.appendChild(textAreaCard.asElement());
        element.appendChild(Card.createCodeCard(CodeResource.INSTANCE.textareaSamples()).asElement());
        element.appendChild(selectCard.asElement());
        element.appendChild(Card.createCodeCard(CodeResource.INSTANCE.dropdownSamples()).asElement());
        element.appendChild(checkboxCard.asElement());
        element.appendChild(Card.createCodeCard(CodeResource.INSTANCE.checkBoxSamples()).asElement());
    }

    private void initCheckboxExample() {
        Column column = Column.create()
                .onLarge(Column.OnLarge.two)
                .onSmall(Column.OnSmall.six);
        checkboxCard.appendContent(Elements.h(5).textContent("Basic Examples").asElement());
        checkboxCard.appendContent(Row.create()
                .addColumn(column
                        .addElement(CheckBox.create("default_checkbox", "Default").asElement()))
                .addColumn(column.copy()
                        .addElement(CheckBox.create("filled_in_checkbox", "Filled In").filledIn().asElement()))
                .addColumn(column.copy()
                        .addElement(CheckBox.create("disbaled_checkbox", "Default - Disabled").check().disable().asElement()))
                .addColumn(column.copy()
                        .addElement(CheckBox.create("filled_in_disbaled_checkbox", "Filled In - Disabled").check().filledIn().disable().asElement()))
                .asElement());

        checkboxCard.appendContent(Elements.h(5).textContent("With Material Design Colors").asElement());

        checkboxCard.appendContent(Row.create()
                .addColumn(column.copy()
                        .addElement(CheckBox.create("red_checkbox", "RED").setColor(Color.RED).check().asElement()))
                .addColumn(column.copy()
                        .addElement(CheckBox.create("pink_checkbox", "PINK").setColor(Color.PINK).check().asElement()))
                .addColumn(column.copy()
                        .addElement(CheckBox.create("DEEP_PURPLE_checkbox", "DEEP PURPLE").setColor(Color.DEEP_PURPLE).check().asElement()))
                .addColumn(column.copy()
                        .addElement(CheckBox.create("INDIGO_checkbox", "INDIGO").setColor(Color.INDIGO).check().asElement()))
                .addColumn(column.copy()
                        .addElement(CheckBox.create("BLUE_checkbox", "BLUE").setColor(Color.BLUE).check().asElement()))
                .addColumn(column.copy()
                        .addElement(CheckBox.create("CYAN_checkbox", "CYAN").setColor(Color.CYAN).check().asElement()))
                .addColumn(column.copy()
                        .addElement(CheckBox.create("TEAL_checkbox", "TEAL").setColor(Color.TEAL).check().asElement()))
                .addColumn(column.copy()
                        .addElement(CheckBox.create("GREEN_checkbox", "GREEN").setColor(Color.GREEN).check().asElement()))
                .addColumn(column.copy()
                        .addElement(CheckBox.create("LIME_checkbox", "LIME").setColor(Color.LIME).check().asElement()))
                .addColumn(column.copy()
                        .addElement(CheckBox.create("YELLOW_checkbox", "YELLOW").setColor(Color.YELLOW).check().asElement()))
                .addColumn(column.copy()
                        .addElement(CheckBox.create("AMBER_checkbox", "AMBER").setColor(Color.AMBER).check().asElement()))
                .addColumn(column.copy()
                        .addElement(CheckBox.create("ORANGE_checkbox", "ORANGE").setColor(Color.ORANGE).check().asElement()))
                .addColumn(column.copy()
                        .addElement(CheckBox.create("GREY_checkbox", "GREY").setColor(Color.GREY).check().asElement()))
                .asElement());

        checkboxCard.appendContent(Elements.h(5).textContent("With Material Design Colors - Filled In").asElement());

        checkboxCard.appendContent(Row.create()
                .addColumn(column.copy()
                        .addElement(CheckBox.create("red_checkbox_filled_in", "RED").setColor(Color.RED).check().filledIn().asElement()))
                .addColumn(column.copy()
                        .addElement(CheckBox.create("pink_checkbox_filled_in", "PINK").setColor(Color.PINK).check().filledIn().asElement()))
                .addColumn(column.copy()
                        .addElement(CheckBox.create("DEEP_PURPLE_checkbox_filled_in", "DEEP PURPLE").setColor(Color.DEEP_PURPLE).check().filledIn().asElement()))
                .addColumn(column.copy()
                        .addElement(CheckBox.create("INDIGO_checkbox_filled_in", "INDIGO").setColor(Color.INDIGO).check().filledIn().asElement()))
                .addColumn(column.copy()
                        .addElement(CheckBox.create("BLUE_checkbox_filled_in", "BLUE").setColor(Color.BLUE).check().filledIn().asElement()))
                .addColumn(column.copy()
                        .addElement(CheckBox.create("CYAN_checkbox_filled_in", "CYAN").setColor(Color.CYAN).check().filledIn().asElement()))
                .addColumn(column.copy()
                        .addElement(CheckBox.create("TEAL_checkbox_filled_in", "TEAL").setColor(Color.TEAL).check().filledIn().asElement()))
                .addColumn(column.copy()
                        .addElement(CheckBox.create("GREEN_checkbox_filled_in", "GREEN").setColor(Color.GREEN).check().filledIn().asElement()))
                .addColumn(column.copy()
                        .addElement(CheckBox.create("LIME_checkbox_filled_in", "LIME").setColor(Color.LIME).check().filledIn().asElement()))
                .addColumn(column.copy()
                        .addElement(CheckBox.create("YELLOW_checkbox_filled_in", "YELLOW").setColor(Color.YELLOW).check().filledIn().asElement()))
                .addColumn(column.copy()
                        .addElement(CheckBox.create("AMBER_checkbox_filled_in", "AMBER").setColor(Color.AMBER).check().filledIn().asElement()))
                .addColumn(column.copy()
                        .addElement(CheckBox.create("ORANGE_checkbox_filled_in", "ORANGE").setColor(Color.ORANGE).check().filledIn().asElement()))
                .addColumn(column.copy()
                        .addElement(CheckBox.create("GREY_checkbox_filled_in", "GREY").setColor(Color.GREY).check().filledIn().asElement()))
                .asElement());
    }

    private void initSelectExample() {
        Column column = Column.create().onSmall(Column.OnSmall.six);
        selectCard.appendContent(Row.create()
                .addColumn(column
                        .addElement(DropDown.create()
                                .addOption(DropDownOption.create("-- please select --"))
                                .addOption(DropDownOption.create("10"))
                                .addOption(DropDownOption.create("20"))
                                .addOption(DropDownOption.create("30"))
                                .addOption(DropDownOption.create("40"))
                                .addOption(DropDownOption.create("50"))
                                .selectAt(0)
                                .setSelectionHandler(option -> {
                                    Notification.create("Item selected [ " + option.getValue() + " ]").show();
                                }).asElement()))
                .addColumn(column.copy()
                        .addElement(DropDown.create()
                                .addOption(DropDownOption.create("Disabled"))
                                .selectAt(0)
                                .disable()
                                .asElement())).asElement());

        selectCard.appendContent(BlockHeader.create("Drop up example").asElement());

        selectCard.appendContent(Row.create()
                .addColumn(column.copy()
                        .addElement(DropDown.create()
                                .addOption(DropDownOption.create("-- please select --"))
                                .addOption(DropDownOption.create("10"))
                                .addOption(DropDownOption.create("20"))
                                .addOption(DropDownOption.create("30"))
                                .addOption(DropDownOption.create("40"))
                                .addOption(DropDownOption.create("50"))
                                .selectAt(0)
                                .dropup()
                                .setSelectionHandler(option -> {
                                    Notification.create("Item selected [ " + option.getValue() + " ]").show();
                                }).asElement())).asElement());
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
                .appendContent(TextArea.create("Start typing here...").asElement());

        textAreaCard.appendContent(BlockHeader.create("Auto Growing Vertical Direction").asElement())
                .appendContent(TextArea.create("Start typing here...").autoSize().asElement());
    }
}