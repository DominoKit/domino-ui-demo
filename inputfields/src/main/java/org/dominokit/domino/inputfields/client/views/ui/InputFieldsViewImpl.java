package org.dominokit.domino.inputfields.client.views.ui;

import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.SampleClass;
import org.dominokit.domino.SampleMethod;
import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.domino.componentcase.client.ui.views.BaseDemoView;
import org.dominokit.domino.componentcase.client.ui.views.CodeCard;
import org.dominokit.domino.componentcase.client.ui.views.LinkToSourceCode;
import org.dominokit.domino.inputfields.client.presenters.InputFieldsProxy;
import org.dominokit.domino.inputfields.client.views.InputFieldsView;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.forms.BigDecimalBox;
import org.dominokit.domino.ui.forms.CheckBox;
import org.dominokit.domino.ui.forms.DoubleBox;
import org.dominokit.domino.ui.forms.EmailBox;
import org.dominokit.domino.ui.forms.FloatBox;
import org.dominokit.domino.ui.forms.IntegerBox;
import org.dominokit.domino.ui.forms.LongBox;
import org.dominokit.domino.ui.forms.Radio;
import org.dominokit.domino.ui.forms.RadioGroup;
import org.dominokit.domino.ui.forms.ShortBox;
import org.dominokit.domino.ui.forms.SwitchButton;
import org.dominokit.domino.ui.forms.TelephoneBox;
import org.dominokit.domino.ui.forms.TextBox;
import org.dominokit.domino.ui.grid.Column;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.notifications.Notification;
import org.dominokit.domino.ui.typography.BlockHeader;
import org.dominokit.domino.ui.utils.DominoElement;

import java.math.BigDecimal;

@UiView(presentable = InputFieldsProxy.class)
@SampleClass
public class InputFieldsViewImpl extends BaseDemoView<HTMLDivElement> implements InputFieldsView {

    private DivElement element;

    @Override
    protected HTMLDivElement init() {
        element = div();

        element.appendChild(LinkToSourceCode.createLink("inputfields", this.getClass()));
        element.appendChild(BlockHeader.create("INPUT FIELDS"));

        initNumberFields();
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.initNumberFields()));
        initAdvancedFields();
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.initAdvancedFields()));


        return element.element();
    }

    @SampleMethod
    private void initNumberFields() {
        element.appendChild(Card.create("NUMBER FIELDS")
                .setCollapsible(true)
                .appendChild(Row.create()
                        .appendChild(Column.span12().appendChild(BlockHeader.create("Integer box")))
                        .appendChild(Column.span12().appendChild(IntegerBox.create("Integer box")
                                .withValue(456465)
                                .setAutoValidation(true)
                                .addChangeListener((oldValue, newValue) -> Notification.create("Value changed, Old[" + oldValue + "], New [" + newValue + "]").show())
                        )))
                .appendChild(Row.create()
                        .appendChild(Column.span12().appendChild(BlockHeader.create("Double box")))
                        .appendChild(Column.span12().appendChild(DoubleBox.create("Double box")
                                .withValue(1234.357892)
                                .addChangeListener((oldValue, newValue) -> Notification.create("Value changed, Old[" + oldValue + "], New [" + newValue + "]").show())
                        )))
                .appendChild(Row.create()
                        .appendChild(Column.span12().appendChild(BlockHeader.create("Long box")))
                        .appendChild(Column.span12().appendChild(LongBox.create("Long box")
                                .withValue(654654654351138L)
                                .addChangeListener((oldValue, newValue) -> Notification.create("Value changed, Old[" + oldValue + "], New [" + newValue + "]").show())
                        )))
                .appendChild(Row.create()
                        .appendChild(Column.span12().appendChild(BlockHeader.create("Float box")))
                        .appendChild(Column.span12().appendChild(FloatBox.create("Float box")
                                .withValue(987164.54789600024F)
                                .addChangeListener((oldValue, newValue) -> Notification.create("Value changed, Old[" + oldValue + "], New [" + newValue + "]").show())
                        )))
                .appendChild(Row.create()
                        .appendChild(Column.span12().appendChild(BlockHeader.create("Short box")))
                        .appendChild(Column.span12().appendChild(ShortBox.create("Short box")
                                .withValue((short) 5486)
                                .addChangeListener((oldValue, newValue) -> Notification.create("Value changed, Old[" + oldValue + "], New [" + newValue + "]").show())
                        )))
                .appendChild(Row.create()
                        .appendChild(Column.span12().appendChild(BlockHeader.create("BigDecimal box")))
                        .appendChild(Column.span12().appendChild(BigDecimalBox.create("BigDecimal box")
                                .withValue(new BigDecimal("5477996.32148451"))
                                .addChangeListener((oldValue, newValue) -> Notification.create("Value changed, Old[" + oldValue + "], New [" + newValue + "]").show())
                        )))
        );
    }

    @SampleMethod
    private void initAdvancedFields() {
        EmailBox emailBox = EmailBox.create("Email box")
                .addDataListOption("akabme@gmail.com")
                .addDataListOption("rafat.albarouki@gmail.com");

        TelephoneBox telephoneBox = TelephoneBox.create("Telephone box")
                .addDataListOption("+954 648 2154 87")
                .addDataListOption("+01 654 87 2154");
        element
                .appendChild(Card.create("ADVANCED FIELDS")
                        .setCollapsible(true)
                        .appendChild(BlockHeader.create("Email box"))
                        .appendChild(Row.create()
                                .appendChild(Column.span4()
                                        .appendChild(TextBox.create("Email pattern")
                                                .setHelperText("Set email pattern e.g. [a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,}$")
                                                .addChangeListener((oldValue, newValue) -> {
                                                    emailBox.setPattern(newValue);
                                                    emailBox.validate();
                                                }))
                                )
                                .appendChild(Column.span4()
                                        .appendChild(CheckBox.create("Multiple")
                                                .setHelperText("Allows comma separated emails")
                                                .addChangeListener((oldValue, newValue) -> {
                                                    emailBox.setMultiple(newValue);
                                                    emailBox.validate();
                                                })))
                                .appendChild(Column.span4().appendChild(CheckBox.create("Data list")
                                        .check()
                                        .setHelperText("Shows data list options")
                                        .addChangeListener((oldValue, newValue) -> emailBox.setDataListEnabled(newValue))
                                ))
                        )
                        .appendChild(Row.create()
                                .appendChild(Column.span12().appendChild(emailBox))
                        )
                        .appendChild(BlockHeader.create("Telephone box"))
                        .appendChild(Row.create()
                                .appendChild(Column.span6().appendChild(TextBox.create("Telephone pattern")
                                        .setHelperText("Set telephone pattern e.g. [0-9]{3}-[0-9]{3}-[0-9]{4} for [xxx-xxx-xxxx]")
                                        .addChangeListener((oldValue, newValue) -> {
                                            telephoneBox.setPattern(newValue);
                                            telephoneBox.validate();
                                        })))
                                .appendChild(Column.span6().appendChild(CheckBox.create("Data list options")
                                        .check()
                                        .setHelperText("Shows data list options")
                                        .addChangeListener((oldValue, newValue) -> telephoneBox.setDataListEnabled(newValue))
                                ))
                        )
                        .appendChild(Row.create()
                                .appendChild(Column.span12().appendChild(telephoneBox))
                        )
                )
        ;
    }
}