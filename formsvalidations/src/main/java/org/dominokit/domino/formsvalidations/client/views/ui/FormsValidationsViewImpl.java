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
import org.dominokit.domino.ui.forms.*;
import org.dominokit.domino.ui.grid.Column;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.header.BlockHeader;
import org.dominokit.domino.ui.icons.Icon;
import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.notifications.Notification;
import org.dominokit.domino.ui.popover.Tooltip;
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
                .appendChild(Row.create()
                        .addColumn(Column.span12()
                                .appendChild(TextBox.create("TextBox").setValue("Mr. Joan").setReadOnly(true)))
                        .addColumn(Column.span12()
                                .appendChild(TextArea.create("TextArea").setValue("CEO of the largest company")
                                        .setRows(1)
                                        .setReadOnly(true)))
                        .addColumn(Column.span12()
                                .appendChild(Select.create("Select")
                                        .addOption(SelectOption.create("english", "English"))
                                        .addOption(SelectOption.create("france", "France"))
                                        .addOption(SelectOption.create("arabic", "Arabic"))
                                        .selectAt(0)
                                        .setReadOnly(true)))
                );
    }

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
                        .addOption(SelectOption.create("-- Select a type --", "-- Select a type --"))
                        .addOption(SelectOption.create("Story", "Story"))
                        .addOption(SelectOption.create("Bugfix", "Bugfix"))
                        .addOption(SelectOption.create("Hotfix", "Hotfix"))
                        .setHelperText("Helps with tracking the issues"))
                .appendChild(Elements.hr())
                .appendChild(Elements.br())
                .appendChild(BlockHeader.create("Checkbox"))
                .appendChild(CheckBox.create("I want to receive an news about this task")
                        .setHelperText("news will be sent via email"))
                .appendChild(Elements.hr())
                .appendChild(Elements.br())
                .appendChild(BlockHeader.create("Radio"))
                .appendChild(RadioGroup.create("estimation", "Estimation")
                        .addRadio(Radio.create("storyPoint", "Story points"))
                        .addRadio(Radio.create("hours", "Effective hours"))
                        .horizontal()
                        .setHelperText("Helps with sprint reports")
                        )
                .appendChild(Elements.hr())
                .appendChild(Elements.br())
                .appendChild(BlockHeader.create("Switch"))
                .appendChild(SwitchButton.create().setOffTitle("Notifications: ")
                        .setHelperText("Notifications will be sent via the system"));
    }

    private void initIcons() {
        Icon cancel = Icons.ALL.cancel();

        TextBox username = TextBox.create("Username")
                .setLeftAddon(Icons.ALL.account_circle())
                .setRightAddon(cancel);
        cancel.addClickListener(evt -> username.clear())
                .style().setCursor("pointer");

        HTMLElement showIcon = Icons.ALL.remove_red_eye()
                .style()
                .setCursor("pointer").asElement();
        TextBox password = TextBox.password("Password")
                .setLeftAddon(Icons.ALL.https().asElement())
                .setRightAddon(showIcon);

        showIcon.addEventListener("mousedown", evt -> password.getInputElement().asElement().type = "text");
        showIcon.addEventListener("mouseup", evt -> password.getInputElement().asElement().type = "password");

        Icon info = Icons.ALL.info();
        Tooltip.create(info, "All system pages will be shown in the selected language");
        iconsCard.appendChild(username)
                .appendChild(password)
                .appendChild(TextArea.create("Description")
                        .setLeftAddon(Icons.ALL.description()))
                .appendChild(Select.<String>create("Language")
                        .setLeftAddon(Icons.ALL.language())
                        .setRightAddon(info)
                        .addOption(SelectOption.create("english", "English"))
                        .addOption(SelectOption.create("france", "France"))
                        .addOption(SelectOption.create("arabic", "Arabic"))
                );
    }

    private void initWordCount() {
        countsCard.appendChild(TextBox.create("Name").setLength(10));
        countsCard.appendChild(TextArea.create("Description").setLength(100));
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

    @Override
    public HTMLDivElement getElement() {
        return element;
    }
}