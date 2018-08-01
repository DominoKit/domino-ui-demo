package org.dominokit.domino.formsvalidations.client.views.ui;

import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.domino.componentcase.shared.extension.ComponentView;
import org.dominokit.domino.formsvalidations.client.presenters.FormsValidationsPresenter;
import org.dominokit.domino.formsvalidations.client.views.CodeResource;
import org.dominokit.domino.formsvalidations.client.views.FormsValidationsView;
import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.column.Column;
import org.dominokit.domino.ui.forms.*;
import org.dominokit.domino.ui.header.BlockHeader;
import org.dominokit.domino.ui.icons.Icon;
import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.notifications.Notification;
import org.dominokit.domino.ui.popover.Tooltip;
import org.dominokit.domino.ui.row.Row;
import org.dominokit.domino.ui.utils.ValidationResult;
import org.jboss.gwt.elemento.core.Elements;

@UiView(presentable = FormsValidationsPresenter.class)
public class FormsValidationsViewImpl extends ComponentView<HTMLDivElement> implements FormsValidationsView {

    private HTMLDivElement element = Elements.div().asElement();
    private Card helperTextCard;
    private Card iconsCard;
    private Card countsCard;
    private Card validationsCard;
    private Card readOnlyCard;

    @Override
    public void init() {
        element.appendChild(BlockHeader.create("FIELDS DECORATION").asElement());
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

        element.appendChild(helperTextCard.asElement());
        element.appendChild(Card.createCodeCard(CodeResource.INSTANCE.helperText()).asElement());
        element.appendChild(iconsCard.asElement());
        element.appendChild(Card.createCodeCard(CodeResource.INSTANCE.addons()).asElement());
        element.appendChild(countsCard.asElement());
        element.appendChild(Card.createCodeCard(CodeResource.INSTANCE.wordCount()).asElement());
        element.appendChild(validationsCard.asElement());
        element.appendChild(Card.createCodeCard(CodeResource.INSTANCE.validations()).asElement());
        element.appendChild(readOnlyCard.asElement());
        element.appendChild(Card.createCodeCard(CodeResource.INSTANCE.readOnly()).asElement());
    }

    private void initReadOnly() {
        readOnlyCard
                .appendContent(Row.create()
                        .addColumn(Column.create(12)
                                .addElement(TextBox.create("TextBox").setValue("Mr. Joan").setReadOnly(true)))
                        .addColumn(Column.create(12)
                                .addElement(TextArea.create("TextArea").setValue("CEO of the largest company")
                                        .setRows(1)
                                        .setReadOnly(true)))
                        .addColumn(Column.create(12)
                                .addElement(Select.create("Select")
                                        .addOption(SelectOption.create("english", "English"))
                                        .addOption(SelectOption.create("france", "France"))
                                        .addOption(SelectOption.create("arabic", "Arabic"))
                                        .selectAt(0)
                                        .setReadOnly(true)))
                );
    }

    private void initHelperText() {
        helperTextCard
                .appendContent(BlockHeader.create("Text Box").asElement())
                .appendContent(TextBox.create("Task Name")
                        .setHelperText("Each task should have unique name.").asElement())
                .appendContent(Elements.hr().asElement())
                .appendContent(Elements.br().asElement())
                .appendContent(BlockHeader.create("Text Area").asElement())
                .appendContent(TextArea.create("Description").setHelperText("Less than 100 words")
                        .asElement())
                .appendContent(Elements.hr().asElement())
                .appendContent(Elements.br().asElement())
                .appendContent(BlockHeader.create("Select").asElement())
                .appendContent(Select.<String>create("Task type")
                        .addOption(SelectOption.create("-- Select a type --", "-- Select a type --"))
                        .addOption(SelectOption.create("Story", "Story"))
                        .addOption(SelectOption.create("Bugfix", "Bugfix"))
                        .addOption(SelectOption.create("Hotfix", "Hotfix"))
                        .setHelperText("Helps with tracking the issues")
                        .asElement())
                .appendContent(Elements.hr().asElement())
                .appendContent(Elements.br().asElement())
                .appendContent(BlockHeader.create("Checkbox").asElement())
                .appendContent(CheckBox.create("I want to receive an news about this task")
                        .setHelperText("news will be sent via email").asElement())
                .appendContent(Elements.hr().asElement())
                .appendContent(Elements.br().asElement())
                .appendContent(BlockHeader.create("Radio").asElement())
                .appendContent(RadioGroup.create("estimation", "Estimation")
                        .addRadio(Radio.create("storyPoint", "Story points"))
                        .addRadio(Radio.create("hours", "Effective hours"))
                        .horizontal()
                        .setHelperText("Helps with sprint reports")
                        .asElement())
                .appendContent(Elements.hr().asElement())
                .appendContent(Elements.br().asElement())
                .appendContent(BlockHeader.create("Switch").asElement())
                .appendContent(SwitchButton.create().setOffTitle("Notifications: ")
                        .setHelperText("Notifications will be sent via the system").asElement());
    }

    private void initIcons() {
        HTMLElement cancel = Icons.ALL.cancel().asElement();
        TextBox username = TextBox.create("Username")
                .setLeftAddon(Icons.ALL.account_circle().asElement())
                .setRightAddon(cancel);

        cancel.style.cursor = "pointer";
        cancel.addEventListener("click", evt -> {
            username.clear();
        });

        HTMLElement showIcon = Icons.ALL.remove_red_eye().asElement();
        TextBox password = TextBox.password("Password")
                .setLeftAddon(Icons.ALL.https().asElement())
                .setRightAddon(showIcon);

        showIcon.style.cursor = "pointer";
        showIcon.addEventListener("mousedown", evt -> {
            password.getInputElement().type = "text";
        });
        showIcon.addEventListener("mouseup", evt -> {
            password.getInputElement().type = "password";
        });
        Icon info = Icons.ALL.info();
        Tooltip.create(info.asElement(), "All system pages will be shown in the selected language");
        iconsCard.appendContent(username.asElement())
                .appendContent(password.asElement())
                .appendContent(TextArea.create("Description")
                        .setLeftAddon(Icons.ALL.description().asElement())
                        .asElement())
                .appendContent(Select.<String>create("Language")
                        .setLeftAddon(Icons.ALL.language())
                        .setRightAddon(info)
                        .addOption(SelectOption.create("english", "English"))
                        .addOption(SelectOption.create("france", "France"))
                        .addOption(SelectOption.create("arabic", "Arabic"))
                );
    }

    private void initWordCount() {
        countsCard.appendContent(TextBox.create("Name").setLength(10)
                .asElement());
        countsCard.appendContent(TextArea.create("Description").setLength(100)
                .asElement());
    }

    private void initValidations() {
        FieldsGrouping fieldsGrouping = FieldsGrouping.create();
        TextBox name = TextBox.create("Name").groupBy(fieldsGrouping);
        TextBox surename = TextBox.create("Surename").groupBy(fieldsGrouping);
        TextBox email = TextBox.create("Email").groupBy(fieldsGrouping);
        RadioGroup gender = RadioGroup.create("gender", "Gender")
                .addRadio(Radio.create("male", "Male"))
                .addRadio(Radio.create("female", "Female"))
                .horizontal()
                .groupBy(fieldsGrouping);
        TextArea description = TextArea.create("Description").groupBy(fieldsGrouping);
        TextBox password = TextBox.password("Password").groupBy(fieldsGrouping);
        CheckBox termsAndConditions = CheckBox.create("I have read and accept the terms").groupBy(fieldsGrouping);
        Select language = Select.create("Language")
                .addOption(SelectOption.create("english", "English"))
                .addOption(SelectOption.create("france", "France"))
                .addOption(SelectOption.create("arabic", "Arabic"))
                .groupBy(fieldsGrouping);

        fieldsGrouping.setAutoValidation(true).setRequired(true);

        validationsCard
                .appendContent(Row.create()
                        .addColumn(Column.create(12)
                                .addElement(name)))
                .appendContent(Row.create()
                        .addColumn(Column.create(12)
                                .addElement(surename)))
                .appendContent(Row.create()
                        .addColumn(Column.create(12)
                                .addElement(email)))
                .appendContent(Row.create()
                        .addColumn(Column.create(12)
                                .addElement(gender)))
                .appendContent(Row.create()
                        .addColumn(Column.create(12)
                                .addElement(description)))
                .appendContent(Row.create()
                        .addColumn(Column.create(12)
                                .addElement(password)))
                .appendContent(Row.create()
                        .addColumn(Column.create(12)
                                .addElement(language)))
                .appendContent(Row.create()
                        .addColumn(Column.create(12)
                                .addElement(termsAndConditions)))
                .appendContent(Row.create()
                        .addColumn(Column.create(12)
                                .addElement(Button.createPrimary("REGISTER")
                                        .addClickListener(evt -> {
                                            ValidationResult validationResult = fieldsGrouping.validate();
                                            if (validationResult.isValid()) {
                                                fieldsGrouping.clear();
                                            } else {
                                                Notification.createDanger("Error " + validationResult.getErrorMessage()).show();
                                            }
                                        }))));
    }

    @Override
    public HTMLDivElement getElement() {
        return element;
    }
}