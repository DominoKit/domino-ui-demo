package org.dominokit.domino.formsvalidations.client.views;

public class CodeResource {

    public static String helperText() {
        return "helperTextCard\n" +
                "        .appendContent(BlockHeader.create(\"Text Box\").asElement())\n" +
                "        .appendContent(TextBox.create(\"Task Name\")\n" +
                "                .setHelperText(\"Each task should have unique name.\").asElement())\n" +
                "        .appendContent(Elements.hr().asElement())\n" +
                "        .appendContent(Elements.br().asElement())\n" +
                "        .appendContent(BlockHeader.create(\"Text Area\").asElement())\n" +
                "        .appendContent(TextArea.create(\"Description\").setHelperText(\"Less than 100 words\")\n" +
                "                .asElement())\n" +
                "        .appendContent(Elements.hr().asElement())\n" +
                "        .appendContent(Elements.br().asElement())\n" +
                "        .appendContent(BlockHeader.create(\"Select\").asElement())\n" +
                "        .appendContent(Select.create(\"Task type\")\n" +
                "                .addOption(SelectOption.create(\"-- Select a type --\"))\n" +
                "                .addOption(SelectOption.create(\"Story\"))\n" +
                "                .addOption(SelectOption.create(\"Bugfix\"))\n" +
                "                .addOption(SelectOption.create(\"Hotfix\"))\n" +
                "                .setHelperText(\"Helps with tracking the issues\")\n" +
                "                .asElement())\n" +
                "        .appendContent(Elements.hr().asElement())\n" +
                "        .appendContent(Elements.br().asElement())\n" +
                "        .appendContent(BlockHeader.create(\"Checkbox\").asElement())\n" +
                "        .appendContent(CheckBox.create(\"I want to receive an news about this task\")\n" +
                "                .setHelperText(\"news will be sent via email\").asElement())\n" +
                "        .appendContent(Elements.hr().asElement())\n" +
                "        .appendContent(Elements.br().asElement())\n" +
                "        .appendContent(BlockHeader.create(\"Radio\").asElement())\n" +
                "        .appendContent(RadioGroup.create(\"estimation\", \"Estimation\")\n" +
                "                .addRadio(Radio.create(\"storyPoint\", \"Story points\"))\n" +
                "                .addRadio(Radio.create(\"hours\", \"Effective hours\"))\n" +
                "                .horizontal()\n" +
                "                .setHelperText(\"Helps with sprint reports\")\n" +
                "                .asElement())\n" +
                "        .appendContent(Elements.hr().asElement())\n" +
                "        .appendContent(Elements.br().asElement())\n" +
                "        .appendContent(BlockHeader.create(\"Switch\").asElement())\n" +
                "        .appendContent(SwitchButton.create(\"Notifications: \")\n" +
                "                .setHelperText(\"Notifications will be sent via the system\").asElement());";
    }

    public static String addons() {
        return "HTMLElement cancel = Icons.ALL.cancel().asElement();\n" +
                "TextBox username = TextBox.create(\"Username\")\n" +
                "        .setLeftAddon(Icons.ALL.account_circle().asElement())\n" +
                "        .setRightAddon(cancel);\n" +
                "\n" +
                "cancel.style.cursor = \"pointer\";\n" +
                "cancel.addEventListener(\"click\", evt -> {\n" +
                "    username.clear();\n" +
                "});\n" +
                "\n" +
                "HTMLElement showIcon = Icons.ALL.remove_red_eye().asElement();\n" +
                "TextBox password = TextBox.password(\"Password\")\n" +
                "        .setLeftAddon(Icons.ALL.https().asElement())\n" +
                "        .setRightAddon(showIcon);\n" +
                "\n" +
                "showIcon.style.cursor = \"pointer\";\n" +
                "showIcon.addEventListener(\"mousedown\", evt -> {\n" +
                "    password.getInputElement().type = \"text\";\n" +
                "});\n" +
                "showIcon.addEventListener(\"mouseup\", evt -> {\n" +
                "    password.getInputElement().type = \"password\";\n" +
                "});\n" +
                "iconsCard.appendContent(username.asElement())\n" +
                "        .appendContent(password.asElement())\n" +
                "        .appendContent(TextArea.create(\"Description\")\n" +
                "                .setLeftAddon(Icons.ALL.description().asElement())\n" +
                "                .asElement());";
    }

    public static String wordCount() {
        return "countsCard.appendContent(TextBox.create(\"Name\").setLength(10)\n" +
                "        .asElement());\n" +
                "countsCard.appendContent(TextArea.create(\"Description\").setLength(100)\n" +
                "        .asElement());";
    }

    public static String validations() {
        return "TextBox name = TextBox.create(\"Name\").setRequired(true).setAutoValidation(true);\n" +
                "TextBox surename = TextBox.create(\"Surename\").setRequired(true).setAutoValidation(true);\n" +
                "TextBox email = TextBox.create(\"Email\").setRequired(true).setAutoValidation(true);\n" +
                "RadioGroup gender = RadioGroup.create(\"gender\", \"Gender\")\n" +
                "        .addRadio(Radio.create(\"male\", \"Male\"))\n" +
                "        .addRadio(Radio.create(\"female\", \"Female\"))\n" +
                "        .horizontal()\n" +
                "        .setRequired(true)\n" +
                "        .setAutoValidation(true);\n" +
                "TextArea description = TextArea.create(\"Description\").setRequired(true).setAutoValidation(true);\n" +
                "TextBox password = TextBox.password(\"Password\").setRequired(true).setAutoValidation(true);\n" +
                "CheckBox termsAndConditions = CheckBox.create(\"I have read and accept the terms\").setRequired(true)\n" +
                "        .setAutoValidation(true);\n" +
                "Select language = Select.create(\"Language\")\n" +
                "        .addOption(SelectOption.create(\"english\", \"English\"))\n" +
                "        .addOption(SelectOption.create(\"france\", \"France\"))\n" +
                "        .addOption(SelectOption.create(\"arabic\", \"Arabic\"))\n" +
                "        .setAutoValidation(true)\n" +
                "        .setRequired(true);\n" +
                "\n" +
                "validationsCard.appendContent(name.asElement())\n" +
                "        .appendContent(surename.asElement())\n" +
                "        .appendContent(email.asElement())\n" +
                "        .appendContent(gender\n" +
                "                .asElement())\n" +
                "        .appendContent(description.asElement())\n" +
                "        .appendContent(password.asElement())\n" +
                "        .appendContent(language.asElement())\n" +
                "        .appendContent(termsAndConditions.asElement())\n" +
                "        .appendContent(Button.createPrimary(\"REGISTER\")\n" +
                "                .addClickListener(evt -> {\n" +
                "                    if (name.validate() &\n" +
                "                            surename.validate() &\n" +
                "                            email.validate() &\n" +
                "                            gender.validate() &\n" +
                "                            description.validate() &\n" +
                "                            password.validate() &\n" +
                "                            language.validate() &\n" +
                "                            termsAndConditions.validate()) {\n" +
                "                        name.clear();\n" +
                "                        surename.clear();\n" +
                "                        email.clear();\n" +
                "                        gender.clear();\n" +
                "                        description.clear();\n" +
                "                        password.clear();\n" +
                "                        language.clear();\n" +
                "                        termsAndConditions.clear();\n" +
                "                    }\n" +
                "                }).asElement());";
    }
}
