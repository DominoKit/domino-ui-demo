package org.dominokit.domino.fieldmasking.client.views.ui;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.domino.componentcase.shared.extension.ComponentView;
import org.dominokit.domino.fieldmasking.client.presenters.FieldMaskingPresenter;
import org.dominokit.domino.fieldmasking.client.views.FieldMaskingView;
import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.column.Column;
import org.dominokit.domino.ui.forms.TextBox;
import org.dominokit.domino.ui.header.BlockHeader;
import org.dominokit.domino.ui.masking.FieldMasking;
import org.dominokit.domino.ui.masking.RegExpMasking;
import org.dominokit.domino.ui.masking.Regex;
import org.dominokit.domino.ui.row.Row;
import org.dominokit.domino.ui.style.Style;
import org.jboss.gwt.elemento.core.Elements;

@UiView(presentable = FieldMaskingPresenter.class)
public class FieldMaskingViewImpl extends ComponentView<HTMLDivElement> implements FieldMaskingView {

    private HTMLDivElement element = Elements.div().asElement();
    private Card regexCard;
    private Card patternCard;

    @Override
    public void init() {
        regexCard = Card.create("REGEX MASKING", "You can apply any regex to a field");
        patternCard = Card.create("PATTERN MASKING");

        initRegexExamples();
        initPatternExamples();

        element.appendChild(regexCard.asElement());
        element.appendChild(patternCard.asElement());
    }

    private void initRegexExamples() {
        TextBox numbers = TextBox.create("NUMBERS").setHelperText("Accepts numbers only");
        FieldMasking.forField(numbers).numbersOnly().mask();
        TextBox alphabetical = TextBox.create("ALPHABETICAL").setHelperText("Accepts letters only");
        FieldMasking.forField(alphabetical).alphabeticalOnly().mask();
        TextBox alphanumeric = TextBox.create("ALPHANUMERIC").setHelperText("Accepts letters and numbers only");
        FieldMasking.forField(alphanumeric).alphanumericOnly().mask();

        regexCard
                .appendContent(BlockHeader.create("Predefined Regex").asElement())
                .appendContent(numbers.asElement())
                .appendContent(alphabetical.asElement())
                .appendContent(alphanumeric.asElement())
                .appendContent(BlockHeader.create("Custom Regex", "You can pass any regex too.").asElement());


        Column column = Column.create()
                .onLarge(Column.OnLarge.six)
                .onMedium(Column.OnMedium.six)
                .onSmall(Column.OnSmall.twelve)
                .onXSmall(Column.OnXSmall.twelve);


        TextBox type_here = TextBox.create("Type Here").floating().setHelperText("type any value which matches [ " + Regex.NUMBERS_ONLY_REGEX + " ] regex");
        TextBox regex = TextBox.create("RegExp").floating();
        regex.setValue(Regex.NUMBERS_ONLY_REGEX);

        Style.of(type_here).setProperty("margin-top", "40px");
        RegExpMasking regExpMasking = FieldMasking.forField(type_here).regex(Regex.NUMBERS_ONLY_REGEX);

        Button apply_regex = Button.createPrimary("APPLY REGEX");
        apply_regex.addClickListener(evt -> {
            type_here.clear();
            String regexValue = regex.getValue();
            type_here.setHelperText("type any value which matches [ " + regexValue + " ] regex");
            regExpMasking.setRegex(regexValue);
        });

        regExpMasking.mask();

        regexCard.appendContent(type_here.asElement())
                .appendContent(Row.create()
                        .addColumn(column.copy().addElement(regex.asElement()))
                        .addColumn(column.copy().addElement(apply_regex.asElement())).asElement());
    }

    private void initPatternExamples() {
        TextBox phone = TextBox.create("phone");

        FieldMasking.forField(phone).pattern("https://000.0[00].0[00].0[00]:00[00]").mask();

        patternCard.appendContent(phone.asElement());
    }

    @Override
    public HTMLDivElement getElement() {
        return element;
    }
}