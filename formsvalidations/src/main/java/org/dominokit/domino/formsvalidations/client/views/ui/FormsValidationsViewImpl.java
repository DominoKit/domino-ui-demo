package org.dominokit.domino.formsvalidations.client.views.ui;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.domino.componentcase.shared.extension.ComponentView;
import org.dominokit.domino.formsvalidations.client.presenters.FormsValidationsPresenter;
import org.dominokit.domino.formsvalidations.client.views.FormsValidationsView;
import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.forms.*;
import org.dominokit.domino.ui.header.BlockHeader;
import org.dominokit.domino.ui.notifications.Notification;
import org.jboss.gwt.elemento.core.Elements;

@UiView(presentable = FormsValidationsPresenter.class)
public class FormsValidationsViewImpl extends ComponentView<HTMLDivElement> implements FormsValidationsView {

    private HTMLDivElement element = Elements.div().asElement();
    private Card helperTextCard;
    private Card countsCard;
    private Card validationsCard;

    @Override
    public void init() {
        helperTextCard = Card.create("HELPER TEXTS");
        countsCard = Card.create("WORD COUNTER");
        validationsCard = Card.create("VALIDATIONS");

        initHelperText();
        initWordCount();
        initValidations();

        element.appendChild(helperTextCard.asElement());
        element.appendChild(countsCard.asElement());
        element.appendChild(validationsCard.asElement());
    }

    private void initValidations() {
        TextBox name = TextBox.create("Name").setRequired(true).setAutoValidation(true);
        TextBox surename = TextBox.create("Surename").setRequired(true).setAutoValidation(true);
        TextBox email = TextBox.create("Email").setRequired(true).setAutoValidation(true);
        RadioGroup gender = RadioGroup.create("gender", "Gender")
                .addRadio(Radio.create("Male"))
                .addRadio(Radio.create("Female"))
                .horizontal()
                .setRequired(true)
                .setAutoValidation(true);
        TextArea description = TextArea.create("Description").setRequired(true).setAutoValidation(true);
        TextBox password = TextBox.password("Password").setRequired(true).setAutoValidation(true);
        CheckBox termsAndConditions = CheckBox.create("I have read and accept the terms").setRequired(true)
                .setAutoValidation(true)
                .addCheckHandler(checked -> {
                    Notification.createInfo("asd").show();
                });
        validationsCard.appendContent(name.asElement())
                .appendContent(surename.asElement())
                .appendContent(email.asElement())
                .appendContent(gender
                        .asElement())
                .appendContent(description.asElement())
                .appendContent(password.asElement())
                .appendContent(termsAndConditions.asElement())
                .appendContent(Button.createPrimary("REGISTER")
                        .addClickListener(evt -> {
                            if (name.validate() &
                                    surename.validate() &
                                    email.validate() &
                                    gender.validate() &
                                    description.validate() &
                                    password.validate() &
                                    termsAndConditions.validate()) {
                                name.clear();
                                surename.clear();
                                email.clear();
                                gender.clear();
                                description.clear();
                                password.clear();
                                termsAndConditions.clear();
                            }
                        }).asElement());
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
                .appendContent(Select.create("Task type")
                        .addOption(SelectOption.create("-- Select a type --"))
                        .addOption(SelectOption.create("Story"))
                        .addOption(SelectOption.create("Bugfix"))
                        .addOption(SelectOption.create("Hotfix"))
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
                        .addRadio(Radio.create("Story points"))
                        .addRadio(Radio.create("Effective hours"))
                        .horizontal()
                        .setHelperText("Helps with sprint reports")
                        .asElement())
                .appendContent(Elements.hr().asElement())
                .appendContent(Elements.br().asElement())
                .appendContent(BlockHeader.create("Switch").asElement())
                .appendContent(SwitchButton.create("Notifications: ")
                        .setHelperText("Notifications will be sent via the system").asElement());
    }

    private void initWordCount() {
        countsCard.appendContent(TextBox.create("Name").setLength(10)
                .asElement());
        countsCard.appendContent(TextArea.create("Description").setLength(100)
                .asElement());
    }

    @Override
    public HTMLDivElement getElement() {
        return element;
    }
}