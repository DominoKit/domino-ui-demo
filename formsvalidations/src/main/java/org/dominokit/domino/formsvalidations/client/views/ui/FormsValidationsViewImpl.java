package org.dominokit.domino.formsvalidations.client.views.ui;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.SampleClass;
import org.dominokit.domino.SampleMethod;
import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.domino.componentcase.client.ui.views.BaseDemoView;
import org.dominokit.domino.componentcase.client.ui.views.CodeCard;
import org.dominokit.domino.componentcase.client.ui.views.LinkToSourceCode;
import org.dominokit.domino.formsvalidations.client.presenters.FormsValidationsProxy;
import org.dominokit.domino.formsvalidations.client.views.FormsValidationsView;
import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.forms.*;
import org.dominokit.domino.ui.forms.suggest.Select;
import org.dominokit.domino.ui.forms.suggest.SelectOption;
import org.dominokit.domino.ui.forms.validations.ValidationResult;
import org.dominokit.domino.ui.grid.Column;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.icons.lib.Icons;
import org.dominokit.domino.ui.menu.direction.DropDirection;
import org.dominokit.domino.ui.notifications.Notification;
import org.dominokit.domino.ui.typography.BlockHeader;
import org.dominokit.domino.ui.utils.PostfixAddOn;
import org.dominokit.domino.ui.utils.PrefixAddOn;

@UiView(presentable = FormsValidationsProxy.class)
@SampleClass
public class FormsValidationsViewImpl extends BaseDemoView<HTMLDivElement> implements FormsValidationsView {

    private DivElement element;
    private Card countsCard;
    private Card validationsCard;
    private Card readOnlyCard;

    @Override
    protected HTMLDivElement init() {
        element = div();

        element.appendChild(LinkToSourceCode.createLink("formsvalidations", this.getClass()).element());
        element.appendChild(BlockHeader.create("FIELDS DECORATION").element());
        countsCard = Card.create("WORD COUNTER");
        validationsCard = Card.create("VALIDATIONS");
        readOnlyCard = Card.create("READ ONLY");

        initHelperText();
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.initHelperText()).element());
        initIcons();
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.initIcons()).element());
        initWordCount();
        initValidations();
        initReadOnly();

        element.appendChild(countsCard.element());
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.initWordCount()).element());
        element.appendChild(validationsCard.element());
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.initValidations()).element());
        element.appendChild(readOnlyCard.element());
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.initReadOnly()).element());

        return element.element();
    }

    @SampleMethod
    private void initHelperText() {
        element.appendChild(Card.create("HELPER TEXTS")
                .appendChild(BlockHeader.create("Text Box"))
                .appendChild(TextBox.create("Task Name")
                        .setHelperText("Each task should have unique name."))
                .appendChild(br())
                .appendChild(BlockHeader.create("Text Area"))
                .appendChild(TextAreaBox.create("Description").setHelperText("Less than 100 words"))
                .appendChild(br())
                .appendChild(BlockHeader.create("Select"))
                .appendChild(Select.<String>create("Task type")
                        .appendChild(SelectOption.create("-- Select a type --", "-- Select a type --"))
                        .appendChild(SelectOption.create("Story", "Story"))
                        .appendChild(SelectOption.create("Bugfix", "Bugfix"))
                        .appendChild(SelectOption.create("Hotfix", "Hotfix"))
                        .setHelperText("Helps with tracking the issues"))
                .appendChild(br())
                .appendChild(BlockHeader.create("Checkbox"))
                .appendChild(CheckBox.create("I want to receive an news about this task")
                        .setHelperText("news will be sent via email"))
                .appendChild(br())
                .appendChild(BlockHeader.create("Radio"))
                .appendChild(RadioGroup.<String>create("estimation", "Estimation")
                        .appendChild(Radio.create("storyPoint", "Story points"))
                        .appendChild(Radio.create("hours", "Effective hours"))
                        .horizontal()
                        .setHelperText("Helps with sprint reports")
                )
                .appendChild(br())
                .appendChild(BlockHeader.create("Switch"))
                .appendChild(SwitchButton.create().setOffTitle("Notifications: ")
                        .setHelperText("Notifications will be sent via the system"))
        );
    }

    @SampleMethod
    private void initIcons() {
        element.appendChild(Card.create("ADDONS")
                .appendChild(TextBox.create("Username")
                        .appendChild(PrefixAddOn.of(Icons.account_circle()))
                        .apply(self -> {
                            self.appendChild(PostfixAddOn.of(Icons.close_circle()
                                    .clickable()
                                    .addClickListener(evt -> self.clear())));
                        }))
                .appendChild(PasswordBox.create("Password")
                        .appendChild(PrefixAddOn.of(Icons.shield()))
                        .apply(self1 -> self1
                                .appendChild(PostfixAddOn.of(Icons.eye_off()
                                                .clickable()
                                                .addEventListener("mousedown", evt1 -> self1.getInputElement().element().type = "text")
                                                .addEventListener("mouseup", evt1 -> self1.getInputElement().element().type = "password")
                                        )
                                )))
                .appendChild(TextAreaBox.create("Description")
                        .appendChild(PrefixAddOn.of(Icons.note()))
                        .appendChild(PostfixAddOn.of(Icons.text()))
                )
                .appendChild(Select.<String>create("Language")
                        .appendChild(PrefixAddOn.of(Icons.earth()))
                        .appendChild(PostfixAddOn.of(Icons.information()
                                .setTooltip("All system pages will be shown in the selected language", DropDirection.BEST_SIDE_UP_DOWN)
                        ))
                        .appendChild(SelectOption.create("english", "English"))
                        .appendChild(SelectOption.create("france", "France"))
                        .appendChild(SelectOption.create("arabic", "Arabic"))
                )
        );
    }

    @SampleMethod
    private void initWordCount() {
        countsCard.appendChild(TextBox.create("Name")
                .setMaxLength(10)
        );
        countsCard.appendChild(TextAreaBox.create("Description").setMaxLength(100));
    }

    @SampleMethod
    private void initValidations() {
        FieldsGrouping fieldsGrouping = FieldsGrouping.create();

        validationsCard
                .appendChild(Row.create()
                        .appendChild(Column.span12()
                                .appendChild(TextBox.create("Name")
                                        .groupBy(fieldsGrouping))))
                .appendChild(Row.create()
                        .appendChild(Column.span12()
                                .appendChild(TextBox.create("Surename")
                                        .groupBy(fieldsGrouping))))
                .appendChild(Row.create()
                        .appendChild(Column.span12()
                                .appendChild(TextBox.create("Email")
                                        .groupBy(fieldsGrouping))))
                .appendChild(Row.create()
                        .appendChild(Column.span12()
                                .appendChild(RadioGroup.<String>create("gender", "Gender")
                                        .appendChild(Radio.create("male", "Male"))
                                        .appendChild(Radio.create("female", "Female"))
                                        .horizontal()
                                        .setShowRequiredIndicator(true)
                                        .groupBy(fieldsGrouping))))
                .appendChild(Row.create()
                        .appendChild(Column.span12()
                                .appendChild(TextAreaBox.create("Description").groupBy(fieldsGrouping))))
                .appendChild(Row.create()
                        .appendChild(Column.span12()
                                .appendChild(PasswordBox.create("Password").groupBy(fieldsGrouping))))
                .appendChild(Row.create()
                        .appendChild(Column.span12()
                                .appendChild(Select.<String>create("Language")
                                        .appendChild(SelectOption.create("english", "English"))
                                        .appendChild(SelectOption.create("france", "France"))
                                        .appendChild(SelectOption.create("arabic", "Arabic"))
                                        .groupBy(fieldsGrouping))))
                .appendChild(Row.create()
                        .appendChild(Column.span12()
                                .appendChild(CheckBox.create("I have read and accept the terms").groupBy(fieldsGrouping))))
                .appendChild(Row.create()
                        .appendChild(Column.span12()
                                .appendChild(Button.create("REGISTER")
                                        .addCss(dui_primary)
                                        .addClickListener(evt -> {
                                            ValidationResult validationResult = fieldsGrouping.validate();
                                            if (validationResult.isValid()) {
                                                fieldsGrouping.clear();
                                            } else {
                                                Notification.create("Error " + validationResult.getErrorMessage())
                                                        .addCss(dui_error)
                                                        .show();
                                            }
                                        })
                                )
                        )
                );
        fieldsGrouping.setAutoValidation(true).setRequired(true);
    }

    @SampleMethod
    private void initReadOnly() {
        readOnlyCard
                .appendChild(Row.create()
                        .appendChild(Column.span12()
                                .appendChild(TextBox.create("TextBox")
                                        .withValue("Mr. Joan")
                                        .setReadOnly(true)))
                        .appendChild(Column.span12()
                                .appendChild(TextAreaBox.create("TextArea")
                                        .withValue("CEO of the largest company")
                                        .setRows(1)
                                        .setReadOnly(true)))
                        .appendChild(Column.span12()
                                .appendChild(Select.create("Select")
                                        .appendChild(SelectOption.create("english", "English"))
                                        .appendChild(SelectOption.create("france", "France"))
                                        .appendChild(SelectOption.create("arabic", "Arabic"))
                                        .selectAt(0)
                                        .setReadOnly(true)))
                        .appendChild(Column.span12()
                                .appendChild(SwitchButton.create()
                                        .setOffTitle("Required")
                                        .check()
                                        .setReadOnly(true)))
                        .appendChild(Column.span12()
                                .appendChild(SwitchButton.create("Required", "Yes", "No")
                                        .setReadOnly(true)))
                        .appendChild(Column.span12()
                                .appendChild(CheckBox.create("Readonly checkbox")
                                        .check()
                                        .setReadOnly(true)
                                )
                        )
                        .appendChild(Column.span12()
                                .appendChild(CheckBox.create("Readonly checkbox")
                                        .setReadOnly(true)
                                )
                        )
                );
    }
}