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
import org.dominokit.domino.ui.header.BlockHeader;
import org.dominokit.domino.ui.icons.Icons;
import org.jboss.gwt.elemento.core.Elements;

@UiView(presentable = FormsValidationsPresenter.class)
public class FormsValidationsViewImpl extends ComponentView<HTMLDivElement> implements FormsValidationsView {

    private HTMLDivElement element = Elements.div().asElement();
    private Card helperTextCard;
    private Card iconsCard;
    private Card countsCard;
    private Card validationsCard;

    @Override
    public void init() {
        helperTextCard = Card.create("HELPER TEXTS");
        iconsCard = Card.create("ADDONS");
        countsCard = Card.create("WORD COUNTER");
        validationsCard = Card.create("VALIDATIONS");

        initHelperText();
        initIcons();
        initWordCount();
        initValidations();

        element.appendChild(helperTextCard.asElement());
        element.appendChild(Card.createCodeCard(CodeResource.INSTANCE.helperText()).asElement());
        element.appendChild(iconsCard.asElement());
        element.appendChild(Card.createCodeCard(CodeResource.INSTANCE.addons()).asElement());
        element.appendChild(countsCard.asElement());
        element.appendChild(Card.createCodeCard(CodeResource.INSTANCE.wordCount()).asElement());
        element.appendChild(validationsCard.asElement());
        element.appendChild(Card.createCodeCard(CodeResource.INSTANCE.validations()).asElement());
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
                        .addRadio(Radio.create("storyPoint", "Story points"))
                        .addRadio(Radio.create("hours", "Effective hours"))
                        .horizontal()
                        .setHelperText("Helps with sprint reports")
                        .asElement())
                .appendContent(Elements.hr().asElement())
                .appendContent(Elements.br().asElement())
                .appendContent(BlockHeader.create("Switch").asElement())
                .appendContent(SwitchButton.create("Notifications: ")
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
        iconsCard.appendContent(username.asElement())
                .appendContent(password.asElement())
                .appendContent(TextArea.create("Description")
                        .setLeftAddon(Icons.ALL.description().asElement())
                        .asElement());
    }

    private void initWordCount() {
        countsCard.appendContent(TextBox.create("Name").setLength(10)
                .asElement());
        countsCard.appendContent(TextArea.create("Description").setLength(100)
                .asElement());
    }

    private void initValidations() {
        TextBox name = TextBox.create("Name").setRequired(true).setAutoValidation(true);
        TextBox surename = TextBox.create("Surename").setRequired(true).setAutoValidation(true);
        TextBox email = TextBox.create("Email").setRequired(true).setAutoValidation(true);
        RadioGroup gender = RadioGroup.create("gender", "Gender")
                .addRadio(Radio.create("male", "Male"))
                .addRadio(Radio.create("female", "Female"))
                .horizontal()
                .setRequired(true)
                .setAutoValidation(true);
        TextArea description = TextArea.create("Description").setRequired(true).setAutoValidation(true);
        TextBox password = TextBox.password("Password").setRequired(true).setAutoValidation(true);
        CheckBox termsAndConditions = CheckBox.create("I have read and accept the terms").setRequired(true)
                .setAutoValidation(true);
        Select language = Select.create("Language")
                .addOption(SelectOption.create("english", "English"))
                .addOption(SelectOption.create("france", "France"))
                .addOption(SelectOption.create("arabic", "Arabic"))
                .setAutoValidation(true)
                .setRequired(true);

        validationsCard.appendContent(name.asElement())
                .appendContent(surename.asElement())
                .appendContent(email.asElement())
                .appendContent(gender
                        .asElement())
                .appendContent(description.asElement())
                .appendContent(password.asElement())
                .appendContent(language.asElement())
                .appendContent(termsAndConditions.asElement())
                .appendContent(Button.createPrimary("REGISTER")
                        .addClickListener(evt -> {
                            if (name.validate() &
                                    surename.validate() &
                                    email.validate() &
                                    gender.validate() &
                                    description.validate() &
                                    password.validate() &
                                    language.validate() &
                                    termsAndConditions.validate()) {
                                name.clear();
                                surename.clear();
                                email.clear();
                                gender.clear();
                                description.clear();
                                password.clear();
                                language.clear();
                                termsAndConditions.clear();
                            }
                        }).asElement());
    }

    @Override
    public HTMLDivElement getElement() {
        return element;
    }
}