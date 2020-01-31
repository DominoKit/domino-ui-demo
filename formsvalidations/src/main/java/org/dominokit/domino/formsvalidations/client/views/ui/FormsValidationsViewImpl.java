package org.dominokit.domino.formsvalidations.client.views.ui;

import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import org.dominokit.domino.SampleClass;
import org.dominokit.domino.SampleMethod;
import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.domino.componentcase.client.ui.views.CodeCard;
import org.dominokit.domino.componentcase.client.ui.views.LinkToSourceCode;
import org.dominokit.domino.formsvalidations.client.presenters.FormsValidationsProxy;
import org.dominokit.domino.formsvalidations.client.views.FormsValidationsView;
import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.forms.*;
import org.dominokit.domino.ui.forms.validations.ValidationResult;
import org.dominokit.domino.ui.grid.Column;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.header.BlockHeader;
import org.dominokit.domino.ui.icons.Icon;
import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.notifications.Notification;
import org.dominokit.domino.ui.popover.Tooltip;
import org.dominokit.domino.componentcase.client.ui.views.BaseDemoView;
import org.jboss.elemento.Elements;

@UiView(presentable = FormsValidationsProxy.class)
@SampleClass
public class FormsValidationsViewImpl extends BaseDemoView<HTMLDivElement> implements FormsValidationsView {

    private HTMLDivElement element;
    private Card helperTextCard;
    private Card iconsCard;
    private Card countsCard;
    private Card validationsCard;
    private Card readOnlyCard;

    @Override
    protected HTMLDivElement init() {
        element = Elements.div().element();

        element.appendChild(LinkToSourceCode.create("formsvalidations", this.getClass()).element());
        element.appendChild(BlockHeader.create("FIELDS DECORATION").element());
        helperTextCard = Card.create("HELPER TEXTS");
        iconsCard = Card.create("ADDONS");
        countsCard = Card.create("WORD COUNTER");
        validationsCard = Card.create("VALIDATIONS");
        readOnlyCard = Card.create("READ ONLY");

        initHelperText();
        initIcons();
        initWordCount();
        initValidations();
        initReadOnly();

        element.appendChild(helperTextCard.element());
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.initHelperText()).element());
        element.appendChild(iconsCard.element());
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.initIcons()).element());
        element.appendChild(countsCard.element());
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.initWordCount()).element());
        element.appendChild(validationsCard.element());
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.initValidations()).element());
        element.appendChild(readOnlyCard.element());
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.initReadOnly()).element());

        return element;
    }


    @SampleMethod
    private void initReadOnly() {
        readOnlyCard
                .appendChild(Row.create()
                        .addColumn(Column.span12()
                                .appendChild(TextBox.create("TextBox").value("Mr. Joan").setReadOnly(true)))
                        .addColumn(Column.span12()
                                .appendChild(TextArea.create("TextArea").value("CEO of the largest company")
                                        .setRows(1)
                                        .setReadOnly(true)))
                        .addColumn(Column.span12()
                                .appendChild(Select.create("Select")
                                        .appendChild(SelectOption.create("english", "English"))
                                        .appendChild(SelectOption.create("france", "France"))
                                        .appendChild(SelectOption.create("arabic", "Arabic"))
                                        .selectAt(0)
                                        .setReadOnly(true)))
                        .addColumn(Column.span12()
                                .appendChild(SwitchButton.create()
                                        .setOffTitle("Required")
                                        .check()
                                        .setReadOnly(true)))
                        .addColumn(Column.span12()
                                .appendChild(SwitchButton.create("Required", "Yes", "No")
                                        .setReadOnly(true)))
                );
    }

    @SampleMethod
    private void initHelperText() {
        helperTextCard
                .appendChild(BlockHeader.create("Text Box"))
                .appendChild(TextBox.create("Task Name")
                        .setHelperText("Each task should have unique name."))
                .appendChild(Elements.hr())
                .appendChild(Elements.br())
                .appendChild(BlockHeader.create("Text Area"))
                .appendChild(TextArea.create("Description").setHelperText("Less than 100 words"))
                .appendChild(Elements.hr())
                .appendChild(Elements.br())
                .appendChild(BlockHeader.create("Select"))
                .appendChild(Select.<String>create("Task type")
                        .appendChild(SelectOption.create("-- Select a type --", "-- Select a type --"))
                        .appendChild(SelectOption.create("Story", "Story"))
                        .appendChild(SelectOption.create("Bugfix", "Bugfix"))
                        .appendChild(SelectOption.create("Hotfix", "Hotfix"))
                        .setHelperText("Helps with tracking the issues"))
                .appendChild(Elements.hr())
                .appendChild(Elements.br())
                .appendChild(BlockHeader.create("Checkbox"))
                .appendChild(CheckBox.create("I want to receive an news about this task")
                        .setHelperText("news will be sent via email"))
                .appendChild(Elements.hr())
                .appendChild(Elements.br())
                .appendChild(BlockHeader.create("Radio"))
                .appendChild(RadioGroup.<String>create("estimation", "Estimation")
                        .appendChild(Radio.create("storyPoint", "Story points"))
                        .appendChild(Radio.create("hours", "Effective hours"))
                        .horizontal()
                        .setHelperText("Helps with sprint reports")
                )
                .appendChild(Elements.hr())
                .appendChild(Elements.br())
                .appendChild(BlockHeader.create("Switch"))
                .appendChild(SwitchButton.create().setOffTitle("Notifications: ")
                        .setHelperText("Notifications will be sent via the system"));
    }

    @SampleMethod
    private void initIcons() {
        Icon cancel = Icons.ALL.cancel();

        TextBox username = TextBox.create("Username")
                .addLeftAddOn(Icons.ALL.account_circle())
                .setRightAddon(cancel);
        cancel.addClickListener(evt -> username.clear())
                .style().setCursor("pointer");

        HTMLElement showIcon = Icons.ALL.remove_red_eye().clickable()
                .style()
                .setCursor("pointer").element();
        TextBox password = TextBox.password("Password")
                .addLeftAddOn(Icons.ALL.https().element())
                .setRightAddon(showIcon);

        showIcon.addEventListener("mousedown", evt -> password.getInputElement().element().type = "text");
        showIcon.addEventListener("mouseup", evt -> password.getInputElement().element().type = "password");

        Icon info = Icons.ALL.info();
        Tooltip.create(info, "All system pages will be shown in the selected language");
        iconsCard.appendChild(username)
                .appendChild(password)
                .appendChild(TextArea.create("Description")
                        .addLeftAddOn(Icons.ALL.description()))
                .appendChild(Select.<String>create("Language")
                        .addLeftAddOn(Icons.ALL.language())
                        .setRightAddon(info)
                        .appendChild(SelectOption.create("english", "English"))
                        .appendChild(SelectOption.create("france", "France"))
                        .appendChild(SelectOption.create("arabic", "Arabic"))
                );
    }

    @SampleMethod
    private void initWordCount() {
        countsCard.appendChild(TextBox.create("Name").setMaxLength(10));
        countsCard.appendChild(TextArea.create("Description").setMaxLength(100));
    }

    @SampleMethod
    private void initValidations() {
        FieldsGrouping fieldsGrouping = FieldsGrouping.create();
        TextBox name = TextBox.create("Name").groupBy(fieldsGrouping);
        TextBox surename = TextBox.create("Surename").groupBy(fieldsGrouping);
        TextBox email = TextBox.create("Email").groupBy(fieldsGrouping);
        RadioGroup<String> gender = RadioGroup.<String>create("gender", "Gender")
                .appendChild(Radio.create("male", "Male"))
                .appendChild(Radio.create("female", "Female"))
                .horizontal()
                .groupBy(fieldsGrouping);
        TextArea description = TextArea.create("Description").groupBy(fieldsGrouping);
        TextBox password = TextBox.password("Password").groupBy(fieldsGrouping);
        CheckBox termsAndConditions = CheckBox.create("I have read and accept the terms").groupBy(fieldsGrouping);
        Select language = Select.create("Language")
                .appendChild(SelectOption.create("english", "English"))
                .appendChild(SelectOption.create("france", "France"))
                .appendChild(SelectOption.create("arabic", "Arabic"))
                .groupBy(fieldsGrouping);

        fieldsGrouping.setAutoValidation(true).setRequired(true);

        validationsCard
                .appendChild(Row.create()
                        .addColumn(Column.span12()
                                .appendChild(name)))
                .appendChild(Row.create()
                        .addColumn(Column.span12()
                                .appendChild(surename)))
                .appendChild(Row.create()
                        .addColumn(Column.span12()
                                .appendChild(email)))
                .appendChild(Row.create()
                        .addColumn(Column.span12()
                                .appendChild(gender)))
                .appendChild(Row.create()
                        .addColumn(Column.span12()
                                .appendChild(description)))
                .appendChild(Row.create()
                        .addColumn(Column.span12()
                                .appendChild(password)))
                .appendChild(Row.create()
                        .addColumn(Column.span12()
                                .appendChild(language)))
                .appendChild(Row.create()
                        .addColumn(Column.span12()
                                .appendChild(termsAndConditions)))
                .appendChild(Row.create()
                        .addColumn(Column.span12()
                                .appendChild(Button.createPrimary("REGISTER")
                                        .addClickListener(evt -> {
                                            ValidationResult validationResult = fieldsGrouping.validate();
                                            if (validationResult.isValid()) {
                                                fieldsGrouping.clear();
                                            } else {
                                                Notification.createDanger("Error " + validationResult.getErrorMessage()).show();
                                            }
                                        }))));
    }
}