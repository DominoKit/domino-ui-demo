package org.dominokit.domino.inputfields.client.views.ui;

import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.SampleClass;
import org.dominokit.domino.SampleMethod;
import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.domino.componentcase.client.ui.views.CodeCard;
import org.dominokit.domino.componentcase.client.ui.views.LinkToSourceCode;
import org.dominokit.domino.inputfields.client.presenters.InputFieldsProxy;
import org.dominokit.domino.inputfields.client.views.InputFieldsView;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.forms.*;
import org.dominokit.domino.ui.grid.Column;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.header.BlockHeader;
import org.dominokit.domino.ui.utils.DominoElement;
import org.dominokit.domino.componentcase.client.ui.views.BaseDemoView;

import java.math.BigDecimal;

import static org.jboss.elemento.Elements.div;

@UiView(presentable = InputFieldsProxy.class)
@SampleClass
public class InputFieldsViewImpl extends BaseDemoView<HTMLDivElement> implements InputFieldsView {

    private DominoElement<HTMLDivElement> element;
    private Card numberFieldsCard;
    private Card advancedFieldsCard;

    @Override
    protected HTMLDivElement init() {
        element = DominoElement.div();

        element.appendChild(LinkToSourceCode.create("inputfields", this.getClass()).element());
        element.appendChild(BlockHeader.create("INPUT FIELDS"));
        numberFieldsCard = Card.create("NUMBER FIELDS");
        advancedFieldsCard = Card.create("ADVANCED FIELDS");

        initNumberFields();
        initAdvancedFields();

        element.appendChild(numberFieldsCard);
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.initNumberFields()));
        element.appendChild(advancedFieldsCard);
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.initAdvancedFields()));

        return element.element();
    }

    @SampleMethod
    private void initNumberFields() {
        numberFieldsCard
                .appendChild(Row.create()
                        .appendChild(Column.span12().appendChild(BlockHeader.create("Integer box")))
                        .appendChild(Column.span12().appendChild(IntegerBox.create("Integer box")
                                .value(456465)
                                .setAutoValidation(true)
                                .apply(self -> self.addChangeHandler(value -> DomGlobal.console.info(self.getValue())))
                        )))
                .appendChild(Row.create()
                        .appendChild(Column.span12().appendChild(BlockHeader.create("Double box")))
                        .appendChild(Column.span12().appendChild(DoubleBox.create("Double box")
                                .value(1234.357892)
                                .apply(self -> self.addChangeHandler(value -> DomGlobal.console.info(self.getValue())))
                        )))
                .appendChild(Row.create()
                        .appendChild(Column.span12().appendChild(BlockHeader.create("Long box")))
                        .appendChild(Column.span12().appendChild(LongBox.create("Long box")
                                .value(654654654351138L)
                                .apply(self -> self.addChangeHandler(value -> DomGlobal.console.info(self.getValue())))
                        )))
                .appendChild(Row.create()
                        .appendChild(Column.span12().appendChild(BlockHeader.create("Float box")))
                        .appendChild(Column.span12().appendChild(FloatBox.create("Float box")
                                .value(987164.54789600024F)
                                .apply(self -> self.addChangeHandler(value -> DomGlobal.console.info(self.getValue())))
                        )))
                .appendChild(Row.create()
                        .appendChild(Column.span12().appendChild(BlockHeader.create("Short box")))
                        .appendChild(Column.span12().appendChild(ShortBox.create("Short box")
                                .value((short) 5486)
                                .apply(self -> self.addChangeHandler(value -> DomGlobal.console.info(self.getValue())))
                        )))
                .appendChild(Row.create()
                        .appendChild(Column.span12().appendChild(BlockHeader.create("BigDecimal box")))
                        .appendChild(Column.span12().appendChild(BigDecimalBox.create("BigDecimal box")
                                .value(new BigDecimal(5477996.32148451))
                                .apply(self -> self.addChangeHandler(value -> DomGlobal.console.info(self.getValue())))
                        )));
    }

    @SampleMethod
    private void initAdvancedFields() {
        EmailBox emailBox = EmailBox.create("Email box")
                .addSuggestedValue("akabme@gmail.com")
                .addSuggestedValue("rafat.albarouki@gmail.com");

        TelephoneBox telephoneBox = TelephoneBox.create("Telephone box")
                .addSuggestedValue("+954 648 2154 87")
                .addSuggestedValue("+01 654 87 2154");
        advancedFieldsCard
                .appendChild(Row.create()
                        .appendChild(Column.span12().appendChild(BlockHeader.create("Email box")))
                        .appendChild(Column.span4().appendChild(TextBox.create("Email pattern")
                                .setHelperText("Set email pattern e.g. .+@globex.com")
                                .addChangeHandler(value -> {
                                    emailBox.setPattern(value);
                                    emailBox.validate();
                                })))
                        .appendChild(Column.span4().appendChild(CheckBox.create("Multiple")
                                .setHelperText("Allows comma separated emails")
                                .addChangeHandler(value -> {
                                    emailBox.setMultiple(value);
                                    emailBox.validate();
                                })))
                        .appendChild(Column.span4().appendChild(CheckBox.create("Suggestions")
                                .check()
                                .setHelperText("Shows suggestions")
                                .addChangeHandler(emailBox::setEnableSuggestions)))
                        .appendChild(Column.span12().appendChild(emailBox)))
                .appendChild(Row.create()
                        .appendChild(Column.span12().appendChild(BlockHeader.create("Telephone box")))
                        .appendChild(Column.span6().appendChild(TextBox.create("Telephone pattern")
                                .setHelperText("Set telephone pattern e.g. [0-9]{3}-[0-9]{3}-[0-9]{4} for [xxx-xxx-xxxx]")
                                .addChangeHandler(value -> {
                                    telephoneBox.setPattern(value);
                                    telephoneBox.validate();
                                })))
                        .appendChild(Column.span6().appendChild(CheckBox.create("Suggestions")
                                .check()
                                .setHelperText("Shows suggestions")
                                .addChangeHandler(telephoneBox::setEnableSuggestions)))
                        .appendChild(Column.span12().appendChild(telephoneBox)));
    }
}