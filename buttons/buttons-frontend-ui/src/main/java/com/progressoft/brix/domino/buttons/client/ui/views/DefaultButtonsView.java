package com.progressoft.brix.domino.buttons.client.ui.views;

import com.progressoft.brix.domino.api.client.annotations.UiView;
import com.progressoft.brix.domino.api.shared.extension.Content;
import com.progressoft.brix.domino.buttons.client.presenters.ButtonsPresenter;
import com.progressoft.brix.domino.buttons.client.views.ButtonsView;
import com.progressoft.brix.domino.ui.button.*;
import com.progressoft.brix.domino.ui.button.group.ButtonsGroup;
import com.progressoft.brix.domino.ui.button.group.JustifiedGroup;
import com.progressoft.brix.domino.ui.cards.Card;
import com.progressoft.brix.domino.ui.column.Column;
import com.progressoft.brix.domino.ui.header.BlockHeader;
import com.progressoft.brix.domino.ui.icons.Icons;
import com.progressoft.brix.domino.ui.row.Row;
import com.progressoft.brix.domino.ui.style.Background;
import elemental2.dom.CSSProperties;
import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import elemental2.dom.HTMLHeadingElement;
import jsinterop.base.Js;
import org.jboss.gwt.elemento.core.Elements;

import java.util.Arrays;
import java.util.List;

import static com.progressoft.brix.domino.ui.button.IconButton.CircleSize;
import static org.jboss.gwt.elemento.core.Elements.div;

@UiView(presentable = ButtonsPresenter.class)
public class DefaultButtonsView implements ButtonsView {

    private HTMLDivElement element = div().asElement();

    public DefaultButtonsView() {
        element.appendChild(BlockHeader.create("BUTTONS").asElement());
        initBootstrapButtons();
        initMaterialDesignButtons();
        initButtonSizes();
        initBlockButtons();
        initDisabledButtons();
        initIconButtons();
        initTextIconButtons();
        element.appendChild(BlockHeader.create("BUTTON GROUPS", "Group a series of buttons together on a single line with the button group").asElement());
        initButtonsBasicGroup();
        initButtonsToolbar();
        initSizingGroup();
        initNestingGroup();
        initVerticalGroup();
        initJustifyGroup();
    }

    private void initJustifyGroup() {
        Card justifiedGroupCard = Card.create("JUSTIFIED BUTTON GROUPS", "Make a group of buttons stretch at equal sizes to span the entire width of its parent. Also works with button dropdowns within the button group.");

        DropdownButton dropDown = DropdownButton.createDefault("Drop down")
                .addAction(DropdownAction.create("Action"))
                .separator()
                .addAction(DropdownAction.create("Action2"));


        JustifiedGroup justifiedGroup = JustifiedGroup.create();
        justifiedGroup.addButton(Button.createPrimary("LEFT"));
        justifiedGroup.addButton(Button.createInfo("MIDDLE"));
        justifiedGroup.addButton(Button.createDanger("RIGHT"));
        justifiedGroup.addDropDown(dropDown);

        setStyle(justifiedGroup.asElement());

        justifiedGroupCard.getBody().appendChild(justifiedGroup.asElement());

        element.appendChild(justifiedGroupCard.asElement());

        createCodeBlock("JustifiedGroup justifiedGroup = JustifiedGroup.create();\n" +
                "justifiedGroup.addButton(Button.createPrimary(\"LEFT\"));\n" +
                "justifiedGroup.addButton(Button.createInfo(\"MIDDLE\"));\n" +
                "justifiedGroup.addButton(Button.createDanger(\"RIGHT\"));\n" +
                "justifiedGroup.addDropDown(dropDown);\n" +
                "element.appendChild(justifiedGroup.asElement());");
    }

    private void initVerticalGroup() {
        Card verticalGroupCard = Card.create("VERTICAL VARIATION", "Make a set of buttons appear vertically stacked rather than horizontally.");

        ButtonsGroup group = ButtonsGroup.create()
                .addButton(Button.createDefault("Button"))
                .addButton(Button.createPrimary("Button"))
                .addDropDown(DropdownButton.createInfo("Dropdown")
                        .addAction(DropdownAction.create("Dropdown link"))
                        .addAction(DropdownAction.create("Dropdown link")))
                .addButton(Button.createDanger("Button"))
                .verticalAlign();
        setMargin(group.asElement());

        verticalGroupCard.getBody().appendChild(group.asElement());

        element.appendChild(verticalGroupCard.asElement());

        createCodeBlock("element.appendChild(ButtonsGroup.create()\n" +
                "                .addButton(Button.createDefault(\"Button\"))\n" +
                "                .addButton(Button.createPrimary(\"Button\"))\n" +
                "                .addDropDown(DropdownButton.createInfo(\"Dropdown\")\n" +
                "                        .addAction(DropdownAction.create(\"Dropdown link\"))\n" +
                "                        .addAction(DropdownAction.create(\"Dropdown link\")))\n" +
                "                .addButton(Button.createDanger(\"Button\"))\n" +
                "                .verticalAlign());");
    }

    private void initNestingGroup() {
        Card card = Card.create("SIZING", "Dropdown can be used inside a group of buttons.");

        HTMLElement defaultGroup = numbersNestedGroup(ButtonType.DEFAULT);
        setStyle(defaultGroup);

        HTMLElement primaryGroup = numbersNestedGroup(ButtonType.PRIMARY);
        setStyle(primaryGroup);

        HTMLElement infoGroup = numbersNestedGroup(ButtonType.INFO);
        setStyle(infoGroup);

        HTMLElement successGroup = numbersNestedGroup(ButtonType.SUCCESS);
        setStyle(successGroup);

        HTMLElement dangerGroup = numbersNestedGroup(ButtonType.DANGER);
        setStyle(dangerGroup);

        HTMLElement warningGroup = numbersNestedGroup(ButtonType.WARNING);
        setStyle(warningGroup);

        card.appendContent(defaultGroup);
        card.appendContent(primaryGroup);
        card.appendContent(infoGroup);
        card.appendContent(successGroup);
        card.appendContent(dangerGroup);
        card.appendContent(warningGroup);

        element.appendChild(card.asElement());

        createCodeBlock("DropdownButton defaultDropDown = DropdownButton.createDefault(\"Dropdown\")\n" +
                "                .addAction(DropdownAction.create(\"Dropdown link\"))\n" +
                "                .addAction(DropdownAction.create(\"Dropdown link\"));\n" +
                "\n" +
                "element.appendChild(ButtonsGroup.create()\n" +
                "                .addButton(Button.createDefault(\"1\"))\n" +
                "                .addButton(Button.createDefault(\"2\"))\n" +
                "                .addDropDown(defaultDropDown).asElement());");
    }

    private HTMLElement numbersNestedGroup(ButtonType type) {
        DropdownButton primaryDropDown = DropdownButton.create("Dropdown")
                .setButtonType(type)
                .addAction(DropdownAction.create("Dropdown link"))
                .addAction(DropdownAction.create("Dropdown link"));

        return ButtonsGroup.create()
                .addButton(Button.create("1").setButtonType(type))
                .addButton(Button.create("2").setButtonType(type))
                .addDropDown(primaryDropDown).asElement();
    }

    private void initSizingGroup() {
        Card card = Card.create("SIZING", "Instead of applying button sizing classes to every button in a group, size can be applied to the group and will be applied to every button.");

        Row row = Row.create();

        Column column1 = Column.create()
                .onLarge(Column.OnLarge.three)
                .onMedium(Column.OnMedium.three)
                .onSmall(Column.OnSmall.four)
                .onXSmall(Column.OnXSmall.six);

        HTMLElement largeGroup = ButtonsGroup.create()
                .addButton(Button.createDefault("LEFT"))
                .addButton(Button.createDefault("MIDDLE"))
                .addButton(Button.createDefault("RIGHT"))
                .setSize(ButtonSize.LARGE)
                .asElement();

        setMargin(largeGroup, "20px");

        column1.asElement().appendChild(heading("Large Button Group"));
        column1.asElement().appendChild(largeGroup);


        Column column2 = column1.copy();
        HTMLElement defaultGroup = ButtonsGroup.create()
                .addButton(Button.createDefault("LEFT"))
                .addButton(Button.createDefault("MIDDLE"))
                .addButton(Button.createDefault("RIGHT"))
                .asElement();

        setMargin(defaultGroup, "20px");

        column2.asElement().appendChild(heading("Default Button Group"));
        column2.asElement().appendChild(defaultGroup);

        Column column3 = column1.copy();
        HTMLElement smallGroup = ButtonsGroup.create()
                .addButton(Button.createDefault("LEFT"))
                .addButton(Button.createDefault("MIDDLE"))
                .addButton(Button.createDefault("RIGHT"))
                .setSize(ButtonSize.SMALL)
                .asElement();

        setMargin(smallGroup, "20px");

        column3.asElement().appendChild(heading("Small Button Group"));
        column3.asElement().appendChild(smallGroup);

        Column column4 = column1.copy();
        HTMLElement xsmallGroup = ButtonsGroup.create()
                .addButton(Button.createDefault("LEFT"))
                .addButton(Button.createDefault("MIDDLE"))
                .addButton(Button.createDefault("RIGHT"))
                .setSize(ButtonSize.XSMALL)
                .asElement();

        setMargin(xsmallGroup, "20px");

        column4.asElement().appendChild(heading("Extra-Small Button Group"));
        column4.asElement().appendChild(xsmallGroup);


        column1.asElement().classList.add("align-center");
        column2.asElement().classList.add("align-center");
        column3.asElement().classList.add("align-center");
        column4.asElement().classList.add("align-center");

        row.addColumn(column1).addColumn(column2).addColumn(column3).addColumn(column4);

        card.appendContent(row.asElement());

        element.appendChild(card.asElement());

        createCodeBlock("element.appendChild(ButtonsGroup.create()\n" +
                "                .addButton(Button.createDefault(\"LEFT\"))\n" +
                "                .addButton(Button.createDefault(\"MIDDLE\"))\n" +
                "                .addButton(Button.createDefault(\"RIGHT\"))\n" +
                "                .setSize(ButtonSize.LARGE)\n" +
                "                .asElement());\n" +
                "\n" +
                "element.appendChild(ButtonsGroup.create()\n" +
                "                .addButton(Button.createDefault(\"LEFT\"))\n" +
                "                .addButton(Button.createDefault(\"MIDDLE\"))\n" +
                "                .addButton(Button.createDefault(\"RIGHT\"))\n" +
                "                .asElement());\n" +
                "                \n" +
                "element.appendChild(ButtonsGroup.create()\n" +
                "                .addButton(Button.createDefault(\"LEFT\"))\n" +
                "                .addButton(Button.createDefault(\"MIDDLE\"))\n" +
                "                .addButton(Button.createDefault(\"RIGHT\"))\n" +
                "                .setSize(ButtonSize.SMALL)\n" +
                "                .asElement());\n" +
                "                \n" +
                "element.appendChild(ButtonsGroup.create()\n" +
                "                .addButton(Button.createDefault(\"LEFT\"))\n" +
                "                .addButton(Button.createDefault(\"MIDDLE\"))\n" +
                "                .addButton(Button.createDefault(\"RIGHT\"))\n" +
                "                .setSize(ButtonSize.XSMALL)\n" +
                "                .asElement());");
    }

    private void initButtonsToolbar() {
        Card card = Card.create("BUTTON TOOLBAR", "Create buttons toolbar");

        Row row = Row.create();

        ButtonsGroup firstDefaultGroup = ButtonsGroup.create()
                .addButton(Button.createDefault("1"))
                .addButton(Button.createDefault("2"))
                .addButton(Button.createDefault("3"));

        ButtonsGroup secondDefaultGroup = ButtonsGroup.create()
                .addButton(Button.createDefault("4"))
                .addButton(Button.createDefault("5"))
                .addButton(Button.createDefault("6"));

        ButtonsGroup thirdDefaultGroup = ButtonsGroup.create()
                .addButton(Button.createDefault("7"));

        ButtonsToolbar defaultButtonsToolbar = ButtonsToolbar.create()
                .addGroup(firstDefaultGroup)
                .addGroup(secondDefaultGroup)
                .addGroup(thirdDefaultGroup);

        setMargin(defaultButtonsToolbar.asElement());

        row.asElement().appendChild(defaultButtonsToolbar.asElement());

        ButtonsGroup firstPrimaryGroup = ButtonsGroup.create()
                .addButton(Button.createPrimary("1"))
                .addButton(Button.createPrimary("2"))
                .addButton(Button.createPrimary("3"));

        ButtonsGroup secondPrimaryGroup = ButtonsGroup.create()
                .addButton(Button.createPrimary("4"))
                .addButton(Button.createPrimary("5"))
                .addButton(Button.createPrimary("6"));

        ButtonsGroup thirdPrimaryGroup = ButtonsGroup.create()
                .addButton(Button.createPrimary("7"));

        ButtonsToolbar primaryButtonsToolbar = ButtonsToolbar.create()
                .addGroup(firstPrimaryGroup)
                .addGroup(secondPrimaryGroup)
                .addGroup(thirdPrimaryGroup);

        setMargin(primaryButtonsToolbar.asElement());

        row.asElement().appendChild(primaryButtonsToolbar.asElement());

        ButtonsGroup firstInfoGroup = ButtonsGroup.create()
                .addButton(Button.createInfo("1"))
                .addButton(Button.createInfo("2"))
                .addButton(Button.createInfo("3"));

        ButtonsGroup secondInfoGroup = ButtonsGroup.create()
                .addButton(Button.createInfo("4"))
                .addButton(Button.createInfo("5"))
                .addButton(Button.createInfo("6"));

        ButtonsGroup thirdInfoGroup = ButtonsGroup.create()
                .addButton(Button.createInfo("7"));

        ButtonsToolbar infoButtonsToolbar = ButtonsToolbar.create()
                .addGroup(firstInfoGroup)
                .addGroup(secondInfoGroup)
                .addGroup(thirdInfoGroup);

        setMargin(infoButtonsToolbar.asElement());

        row.asElement().appendChild(infoButtonsToolbar.asElement());

        ButtonsGroup firstColorGroup = ButtonsGroup.create()
                .addButton(Button.create("1").setBackground(Background.PURPLE))
                .addButton(Button.create("2").setBackground(Background.PURPLE))
                .addButton(Button.create("3").setBackground(Background.PURPLE));

        ButtonsGroup secondColorGroup = ButtonsGroup.create()
                .addButton(Button.create("4").setBackground(Background.PURPLE))
                .addButton(Button.create("5").setBackground(Background.PURPLE))
                .addButton(Button.create("6").setBackground(Background.PURPLE));

        ButtonsGroup thirdColorGroup = ButtonsGroup.create()
                .addButton(Button.create("7").setBackground(Background.PURPLE));

        ButtonsToolbar colorButtonsToolbar = ButtonsToolbar.create()
                .addGroup(firstColorGroup)
                .addGroup(secondColorGroup)
                .addGroup(thirdColorGroup);

        setMargin(colorButtonsToolbar.asElement());

        row.asElement().appendChild(colorButtonsToolbar.asElement());

        infoButtonsToolbar.asElement().style.cssFloat = "left";
        defaultButtonsToolbar.asElement().style.cssFloat = "left";
        primaryButtonsToolbar.asElement().style.cssFloat = "left";
        colorButtonsToolbar.asElement().style.cssFloat = "left";
        card.appendContent(row.asElement());
        element.appendChild(card.asElement());

        createCodeBlock("ButtonsGroup firstGroup = ButtonsGroup.create()\n" +
                "                .addButton(Button.createDefault(\"1\"))\n" +
                "                .addButton(Button.createDefault(\"2\"))\n" +
                "                .addButton(Button.createDefault(\"3\"));\n" +
                "\n" +
                "ButtonsGroup secondGroup = ButtonsGroup.create()\n" +
                "                .addButton(Button.createDefault(\"4\"))\n" +
                "                .addButton(Button.createDefault(\"5\"))\n" +
                "                .addButton(Button.createDefault(\"6\"));\n" +
                "\n" +
                "ButtonsGroup thirdGroup = ButtonsGroup.create()\n" +
                "                .addButton(Button.createDefault(\"7\"));\n" +
                "\n" +
                "ButtonsToolbar buttonsToolbar = ButtonsToolbar.create()\n" +
                "                .addGroup(firstGroup)\n" +
                "                .addGroup(secondGroup)\n" +
                "                .addGroup(thirdGroup);\n" +
                "                \n" +
                "element.appendChild(buttonsToolbar.asElement());");
    }

    private void initButtonsBasicGroup() {
        Card card = Card.create("BASIC EXAMPLE", "Create group of buttons");

        HTMLElement defaultGroup = ButtonsGroup.create()
                .addButton(Button.createDefault("LEFT"))
                .addButton(Button.createDefault("MIDDLE"))
                .addButton(Button.createDefault("RIGHT"))
                .asElement();

        setStyle(defaultGroup);

        card.appendContent(defaultGroup);

        HTMLElement primaryGroup = ButtonsGroup.create()
                .addButton(Button.createPrimary("LEFT"))
                .addButton(Button.createPrimary("MIDDLE"))
                .addButton(Button.createPrimary("RIGHT"))
                .asElement();

        setStyle(primaryGroup);

        card.appendContent(primaryGroup);

        HTMLElement successGroup = ButtonsGroup.create()
                .addButton(Button.createSuccess("LEFT"))
                .addButton(Button.createSuccess("MIDDLE"))
                .addButton(Button.createSuccess("RIGHT"))
                .asElement();

        setStyle(successGroup);

        card.appendContent(successGroup);

        HTMLElement infoGroup = ButtonsGroup.create()
                .addButton(Button.createInfo("LEFT"))
                .addButton(Button.createInfo("MIDDLE"))
                .addButton(Button.createInfo("RIGHT"))
                .asElement();

        setStyle(infoGroup);

        card.appendContent(infoGroup);

        HTMLElement dangerGroup = ButtonsGroup.create()
                .addButton(Button.createDanger("LEFT"))
                .addButton(Button.createDanger("MIDDLE"))
                .addButton(Button.createDanger("RIGHT"))
                .asElement();

        setStyle(dangerGroup);

        card.appendContent(dangerGroup);

        HTMLElement purpleGroup = ButtonsGroup.create()
                .addButton(Button.create("LEFT").setBackground(Background.PURPLE))
                .addButton(Button.create("MIDDLE").setBackground(Background.PURPLE))
                .addButton(Button.create("RIGHT").setBackground(Background.PURPLE))
                .asElement();

        setStyle(purpleGroup);

        card.appendContent(purpleGroup);

        element.appendChild(card.asElement());

        createCodeBlock("ButtonsGroup group = ButtonsGroup.create()\n" +
                "                .addButton(Button.createDefault(\"LEFT\"))\n" +
                "                .addButton(Button.createDefault(\"MIDDLE\"))\n" +
                "                .addButton(Button.createDefault(\"RIGHT\"));\n" +
                "\n" +
                "element.appendChild(group.asElement());");
    }

    private void initTextIconButtons() {
        Card card = Card.create("ICON & TEXT BUTTONS", "Make icon & text buttons");

        HTMLElement extension = IconButton.createDefault(Icons.ALL.extension()).setContent("EXTENSION").asElement();
        HTMLElement home = IconButton.createPrimary(Icons.ALL.home()).setContent("HOME").asElement();
        HTMLElement lock = IconButton.createSuccess(Icons.ALL.lock()).setContent("LOCK").asElement();
        HTMLElement scanWifi = IconButton.createInfo(Icons.ALL.perm_scan_wifi()).setContent("SCAN WIFI").asElement();
        HTMLElement takeOff = IconButton.createWarning(Icons.ALL.flight_takeoff()).setContent("TAKE OFF").asElement();
        HTMLElement print = IconButton.createDanger(Icons.ALL.print()).setContent("PRINT").asElement();

        setStyle(extension);
        setStyle(home);
        setStyle(lock);
        setStyle(scanWifi);
        setStyle(takeOff);
        setStyle(print);

        card.appendContent(extension);
        card.appendContent(home);
        card.appendContent(lock);
        card.appendContent(scanWifi);
        card.appendContent(takeOff);
        card.appendContent(print);

        element.appendChild(card.asElement());

        createCodeBlock("element.appendChild(Button.createDefault(\"EXTENSION\").setIcon(Icons.ALL.extension()).asElement());\n" +
                "element.appendChild(Button.createPrimary(\"HOME\").setIcon(Icons.ALL.home()).asElement());\n" +
                "element.appendChild(Button.createSuccess(\"LOCK\").setIcon(Icons.ALL.lock()).asElement());\n" +
                "element.appendChild(Button.createInfo(\"SCAN WIFI\").setIcon(Icons.ALL.perm_scan_wifi()).asElement());\n" +
                "element.appendChild(Button.createWarning(\"TAKE OFF\").setIcon(Icons.ALL.flight_takeoff()).asElement());\n" +
                "element.appendChild(Button.createDanger(\"PRINT\").setIcon(Icons.ALL.print()).asElement());");
    }

    private void initIconButtons() {
        Card card = Card.create("ICON BUTTONS", "Make icon buttons");

        Row normal = Row.create();
        HTMLHeadingElement normal_circle = heading("Normal Icon Button");
        normal.asElement().appendChild(normal_circle);
        card.appendContent(normal.asElement());

        Row row = Row.create();

        HTMLElement homeIcon = IconButton.createDefault(Icons.ALL.home()).setButtonType(ButtonType.DEFAULT).asElement();
        HTMLElement micIcon = IconButton.createPrimary(Icons.ALL.mic()).setButtonType(ButtonType.PRIMARY).asElement();
        HTMLElement moreIcon = IconButton.createInfo(Icons.ALL.more()).setButtonType(ButtonType.INFO).asElement();
        HTMLElement keyboardIcon = IconButton.createSuccess(Icons.ALL.keyboard()).setButtonType(ButtonType.SUCCESS).asElement();
        HTMLElement acUnitIcon = IconButton.createWarning(Icons.ALL.ac_unit()).setButtonType(ButtonType.WARNING).asElement();
        HTMLElement accessAlarmIcon = IconButton.createDanger(Icons.ALL.access_alarm()).setButtonType(ButtonType.DANGER).asElement();

        setMargin(homeIcon);
        setMargin(micIcon);
        setMargin(moreIcon);
        setMargin(keyboardIcon);
        setMargin(acUnitIcon);
        setMargin(accessAlarmIcon);

        row.asElement().appendChild(homeIcon);
        row.asElement().appendChild(micIcon);
        row.asElement().appendChild(moreIcon);
        row.asElement().appendChild(keyboardIcon);
        row.asElement().appendChild(acUnitIcon);
        row.asElement().appendChild(accessAlarmIcon);

        card.appendContent(row.asElement());

        Row smallCircle = Row.create();
        HTMLHeadingElement small_icon_button = heading("Small Circle Icon Button");
        smallCircle.asElement().appendChild(small_icon_button);
        card.appendContent(smallCircle.asElement());

        Row row1 = Row.create();

        HTMLElement addCircleIconCRL = IconButton.createDefault(Icons.ALL.add_circle()).circle(CircleSize.SMALL).setButtonType(ButtonType.DEFAULT).asElement();
        HTMLElement placeIconCRL = IconButton.createPrimary(Icons.ALL.place()).circle(CircleSize.SMALL).setButtonType(ButtonType.PRIMARY).asElement();
        HTMLElement airplaneModeActiveIconCRL = IconButton.createInfo(Icons.ALL.airplanemode_active()).circle(CircleSize.SMALL).setButtonType(ButtonType.INFO).asElement();
        HTMLElement albumIconCRL = IconButton.createSuccess(Icons.ALL.album()).circle(CircleSize.SMALL).setButtonType(ButtonType.SUCCESS).asElement();
        HTMLElement weekendIconCRL = IconButton.createWarning(Icons.ALL.weekend()).circle(CircleSize.SMALL).setButtonType(ButtonType.WARNING).asElement();
        HTMLElement airplayIconCRL = IconButton.createDanger(Icons.ALL.airplay()).circle(CircleSize.SMALL).setButtonType(ButtonType.DANGER).asElement();

        setMargin(addCircleIconCRL);
        setMargin(placeIconCRL);
        setMargin(airplaneModeActiveIconCRL);
        setMargin(albumIconCRL);
        setMargin(weekendIconCRL);
        setMargin(airplayIconCRL);

        row1.asElement().appendChild(addCircleIconCRL);
        row1.asElement().appendChild(placeIconCRL);
        row1.asElement().appendChild(airplaneModeActiveIconCRL);
        row1.asElement().appendChild(albumIconCRL);
        row1.asElement().appendChild(weekendIconCRL);
        row1.asElement().appendChild(airplayIconCRL);

        card.appendContent(row1.asElement());

        Row large = Row.create();
        HTMLHeadingElement large_circle = heading("Large Circle Icon Button");
        large.asElement().appendChild(large_circle);
        card.appendContent(large.asElement());

        Row row2 = Row.create();

        HTMLElement adjustIconCRL = IconButton.createDefault(Icons.ALL.adjust()).circle(CircleSize.LARGE).setButtonType(ButtonType.DEFAULT).asElement();
        HTMLElement alloutIconCRL = IconButton.createPrimary(Icons.ALL.all_out()).circle(CircleSize.LARGE).setButtonType(ButtonType.PRIMARY).asElement();
        HTMLElement appsIconCRL = IconButton.createInfo(Icons.ALL.apps()).circle(CircleSize.LARGE).setButtonType(ButtonType.INFO).asElement();
        HTMLElement artTrackIconCRL = IconButton.createSuccess(Icons.ALL.art_track()).circle(CircleSize.LARGE).setButtonType(ButtonType.SUCCESS).asElement();
        HTMLElement assessmentIconCRL = IconButton.createWarning(Icons.ALL.assessment()).circle(CircleSize.LARGE).setButtonType(ButtonType.WARNING).asElement();
        HTMLElement assistantIconCRL = IconButton.createDanger(Icons.ALL.assistant()).circle(CircleSize.LARGE).setButtonType(ButtonType.DANGER).asElement();

        setMargin(adjustIconCRL);
        setMargin(alloutIconCRL);
        setMargin(appsIconCRL);
        setMargin(artTrackIconCRL);
        setMargin(assessmentIconCRL);
        setMargin(assistantIconCRL);

        row2.asElement().appendChild(adjustIconCRL);
        row2.asElement().appendChild(alloutIconCRL);
        row2.asElement().appendChild(appsIconCRL);
        row2.asElement().appendChild(artTrackIconCRL);
        row2.asElement().appendChild(assessmentIconCRL);
        row2.asElement().appendChild(assistantIconCRL);


        card.appendContent(row2.asElement());

        element.appendChild(card.asElement());

        createCodeBlock("// NORMAL\n" +
                "element.appendChild(IconButton.create(Icons.ALL.home()).setButtonType(ButtonType.DEFAULT).asElement());\n" +
                "element.appendChild(IconButton.create(Icons.ALL.mic()).setButtonType(ButtonType.PRIMARY).asElement());\n" +
                "element.appendChild(IconButton.create(Icons.ALL.more()).setButtonType(ButtonType.INFO).asElement());\n" +
                "element.appendChild(IconButton.create(Icons.ALL.keyboard()).setButtonType(ButtonType.SUCCESS).asElement());\n" +
                "element.appendChild(IconButton.create(Icons.ALL.ac_unit()).setButtonType(ButtonType.WARNING).asElement());\n" +
                "element.appendChild(IconButton.create(Icons.ALL.access_alarm()).setButtonType(ButtonType.DANGER).asElement());\n" +
                "\n" +
                "// SMALL CIRCLE\n" +
                "element.appendChild(IconButton.create(Icons.ALL.add_circle()).setButtonType(ButtonType.DEFAULT).circle(CircleSize.SMALL).asElement());\n" +
                "element.appendChild(IconButton.create(Icons.ALL.place()).setButtonType(ButtonType.PRIMARY).circle(CircleSize.SMALL).asElement());\n" +
                "element.appendChild(IconButton.create(Icons.ALL.airplanemode_active()).setButtonType(ButtonType.INFO).circle(CircleSize.SMALL).asElement());\n" +
                "element.appendChild(IconButton.create(Icons.ALL.album()).setButtonType(ButtonType.SUCCESS).circle(CircleSize.SMALL).asElement());\n" +
                "element.appendChild(IconButton.create(Icons.ALL.weekend()).setButtonType(ButtonType.WARNING).circle(CircleSize.SMALL).asElement());\n" +
                "element.appendChild(IconButton.create(Icons.ALL.airplay()).setButtonType(ButtonType.DANGER).circle(CircleSize.SMALL).asElement());\n" +
                "\n" +
                "// LARGE CIRCLE\n" +
                "element.appendChild(IconButton.create(Icons.ALL.adjust()).setButtonType(ButtonType.DEFAULT).circle(CircleSize.LARGE).asElement());\n" +
                "element.appendChild(IconButton.create(Icons.ALL.all_out()).setButtonType(ButtonType.PRIMARY).circle(CircleSize.LARGE).asElement());\n" +
                "element.appendChild(IconButton.create(Icons.ALL.apps()).setButtonType(ButtonType.INFO).circle(CircleSize.LARGE).asElement());\n" +
                "element.appendChild(IconButton.create(Icons.ALL.art_track()).setButtonType(ButtonType.SUCCESS).circle(CircleSize.LARGE).asElement());\n" +
                "element.appendChild(IconButton.create(Icons.ALL.assessment()).setButtonType(ButtonType.WARNING).circle(CircleSize.LARGE).asElement());\n" +
                "element.appendChild(IconButton.create(Icons.ALL.assistant()).setButtonType(ButtonType.DANGER).circle(CircleSize.LARGE).asElement());\n");
    }

    private HTMLHeadingElement heading(String content) {
        HTMLHeadingElement headingElement = Elements.h(2, content).asElement();
        headingElement.style.marginTop = CSSProperties.MarginTopUnionType.of("25px");
        headingElement.style.marginBottom = CSSProperties.MarginBottomUnionType.of("15px");
        headingElement.style.fontSize = CSSProperties.FontSizeUnionType.of("15px");
        headingElement.style.color = "#000";
        headingElement.style.display = "block";
        return headingElement;
    }

    private void initDisabledButtons() {
        Card card = Card.create("DISABLED BUTTONS", "Make buttons look unclickable by fading them back with opacity");


        HTMLElement defaultDisabled = Button.createDefault("DEFAULT").disable().asElement();
        HTMLElement primaryDisabled = Button.createPrimary("PRIMARY").disable().asElement();
        HTMLElement infoDisabled = Button.createInfo("INFO").disable().asElement();
        HTMLElement warningDisabled = Button.createWarning("WARNING").disable().asElement();
        HTMLElement dangerDisabled = Button.createDanger("DANGER").disable().asElement();

        setStyle(defaultDisabled);
        setStyle(primaryDisabled);
        setStyle(infoDisabled);
        setStyle(warningDisabled);
        setStyle(dangerDisabled);

        card.appendContent(defaultDisabled);
        card.appendContent(primaryDisabled);
        card.appendContent(infoDisabled);
        card.appendContent(warningDisabled);
        card.appendContent(dangerDisabled);

        element.appendChild(card.asElement());

        createCodeBlock("element.appendChild(Button.createDefault(\"DEFAULT\").setBlock(true).disbale().asElement());\n" +
                "element.appendChild(Button.createPrimary(\"PRIMARY\").setBlock(true).disbale().asElement());\n" +
                "element.appendChild(Button.createInfo(\"INFO\").setBlock(true).disbale().asElement());\n" +
                "element.appendChild(Button.createWarning(\"WARNING\").setBlock(true).disbale().asElement());\n" +
                "element.appendChild(Button.createDanger(\"DANGER\").setBlock(true).disbale().asElment());");
    }

    private void initBlockButtons() {
        Card card = Card.create("BLOCK BUTTONS", "Create block level buttons");

        HTMLElement defaultBlock = Button.createDefault("DEFAULT").setBlock(true).asElement();
        HTMLElement primaryBlock = Button.createPrimary("PRIMARY").setBlock(true).asElement();
        HTMLElement infoBlock = Button.createInfo("INFO").setBlock(true).asElement();
        HTMLElement warningBlock = Button.createWarning("WARNING").setBlock(true).asElement();
        HTMLElement dangerBlock = Button.createDanger("DANGER").setBlock(true).asElement();

        setStyle(defaultBlock);
        setStyle(primaryBlock);
        setStyle(infoBlock);
        setStyle(warningBlock);
        setStyle(dangerBlock);

        card.appendContent(defaultBlock);
        card.appendContent(primaryBlock);
        card.appendContent(infoBlock);
        card.appendContent(warningBlock);
        card.appendContent(dangerBlock);

        element.appendChild(card.asElement());

        createCodeBlock("element.appendChild(Button.createDefault(\"DEFAULT\").setBlock(true).asElement());\n" +
                "element.appendChild(Button.createPrimary(\"PRIMARY\").setBlock(true).asElement());\n" +
                "element.appendChild(Button.createInfo(\"INFO\").setBlock(true).asElement());\n" +
                "element.appendChild(Button.createWarning(\"WARNING\").setBlock(true).asElement());\n" +
                "element.appendChild(Button.createDanger(\"DANGER\").setBlock(true).asElment());");

    }

    private void initButtonSizes() {
        Card card = Card.create("BUTTON SIZES", "You can resize the buttons");

        List<Button> defaultList = Arrays.asList(Button.createDefault("DEFAULT LARGE").setSize(ButtonSize.LARGE),
                Button.createDefault("DEFAULT"),
                Button.createDefault("DEFAULT SMALL").setSize(ButtonSize.SMALL),
                Button.createDefault("DEFAULT XSMALL").setSize(ButtonSize.XSMALL));

        Column defaultColumn = verticalButtons(defaultList);

        List<Button> primaryList = Arrays.asList(Button.createPrimary("PRIMARY LARGE").setSize(ButtonSize.LARGE),
                Button.createPrimary("PRIMARY"),
                Button.createPrimary("PRIMARY SMALL").setSize(ButtonSize.SMALL),
                Button.createPrimary("PRIMARY XSMALL").setSize(ButtonSize.XSMALL));

        Column primaryColumn = verticalButtons(primaryList);

        List<Button> dangerList = Arrays.asList(Button.createDanger("DANGER LARGE").setSize(ButtonSize.LARGE),
                Button.createDanger("DANGER"),
                Button.createDanger("DANGER SMALL").setSize(ButtonSize.SMALL),
                Button.createDanger("DANGER XSMALL").setSize(ButtonSize.XSMALL));

        Column dangerColumn = verticalButtons(dangerList);

        List<Button> warningList = Arrays.asList(Button.createWarning("DANGER LARGE").setSize(ButtonSize.LARGE),
                Button.createWarning("DANGER"),
                Button.createWarning("DANGER SMALL").setSize(ButtonSize.SMALL),
                Button.createWarning("DANGER XSMALL").setSize(ButtonSize.XSMALL));

        Column warningColumn = verticalButtons(warningList);

        List<Button> colorList = Arrays.asList(Button.create("PURPLE LARGE").setBackground(Background.PURPLE).setSize(ButtonSize.LARGE),
                Button.create("PURPLE").setBackground(Background.PURPLE),
                Button.create("PURPLE SMALL").setBackground(Background.PURPLE).setSize(ButtonSize.SMALL),
                Button.create("PURPLE XSMALL").setBackground(Background.PURPLE).setSize(ButtonSize.XSMALL));

        Column colorColumn = verticalButtons(colorList);

        Row row = Row.create()
                .addColumn(defaultColumn)
                .addColumn(primaryColumn)
                .addColumn(dangerColumn)
                .addColumn(warningColumn)
                .addColumn(colorColumn);

        card.appendContent(row.asElement());
        element.appendChild(card.asElement());

        createCodeBlock("element.appendChild(Button.create(\"PURPLE LARGE\").setBackground(Background.PURPLE).setSize(ButtonSize.LARGE).asElement());\n" +
                "element.appendChild(Button.create(\"PURPLE\").setBackground(Background.PURPLE).asElement());\n" +
                "element.appendChild(Button.create(\"PURPLE SMALL\").setBackground(Background.PURPLE).setSize(Buttonize.SMALL).asElement());\n" +
                "element.appendChild(Button.create(\"PURPLE XSMALL\").setBackground(Background.PURPLE).setSize(ButtonSize.XSMALL).asElement());");

    }

    private Column verticalButtons(List<Button> buttons) {
        Column column = createColumn();

        for (Button button : buttons) {
            setStyle(button.asElement());
            column.asElement().appendChild(button.asElement());
        }
        return column;
    }

    private Column createColumn() {
        return Column.create()
                .onLarge(Column.OnLarge.two)
                .onMedium(Column.OnMedium.two)
                .onSmall(Column.OnSmall.three)
                .onXSmall(Column.OnXSmall.six);
    }

    private void initBootstrapButtons() {
        Card card = Card.create("BOOTSTRAP DEFAULT BUTTONS", "Use any of the available button classes to quickly create a styled button");

        HTMLElement defaultBtn = Button.createDefault("DEFAULT").asElement();
        setStyle(defaultBtn);
        card.appendContent(defaultBtn);

        HTMLElement primaryBtn = Button.createPrimary("PRIMARY").asElement();
        setStyle(primaryBtn);
        card.appendContent(primaryBtn);

        HTMLElement successBtn = Button.createSuccess("SUCCESS").asElement();
        setStyle(successBtn);
        card.appendContent(successBtn);

        HTMLElement infoBtn = Button.createInfo("INFO").asElement();
        setStyle(infoBtn);
        card.appendContent(infoBtn);

        HTMLElement warningBtn = Button.createWarning("WARNING").asElement();
        setStyle(warningBtn);
        card.appendContent(warningBtn);

        HTMLElement dangerBtn = Button.createDanger("DANGER").asElement();
        setStyle(dangerBtn);
        card.appendContent(dangerBtn);

        element.appendChild(card.asElement());


        createCodeBlock("element.appendContent(Button.createDefault(\"DEFAULT\").asElement());\n" +
                "element.appendContent(Button.createPrimary(\"PRIMARY\").asElement());\n" +
                "element.appendContent(Button.createSuccess(\"SUCCESS\").asElement());\n" +
                "element.appendContent(Button.createInfo(\"INFO\").asElement());\n" +
                "element.appendContent(Button.createWarning(\"WARNING\").asElement());\n" +
                "element.appendContent(Button.createDanger(\"DANGER\").asElement());");
    }

    private void initMaterialDesignButtons() {
        Card card = Card.create("METARIAL DESIGN BUTTONS", "Use any of the available button classes to quickly create a styled button");

        HTMLElement redBtn = Button.create("RED").setBackground(Background.RED).asElement();
        setStyle(redBtn);
        card.appendContent(redBtn);

        HTMLElement purpleBtn = Button.create("PURPLE").setBackground(Background.PURPLE).asElement();
        setStyle(purpleBtn);
        card.appendContent(purpleBtn);

        HTMLElement indigoBtn = Button.create("INDIGO").setBackground(Background.INDIGO).asElement();
        setStyle(indigoBtn);
        card.appendContent(indigoBtn);

        HTMLElement lightBlueBtn = Button.create("LIGHT BLUE").setBackground(Background.LIGHT_BLUE).asElement();
        setStyle(lightBlueBtn);
        card.appendContent(lightBlueBtn);

        HTMLElement greenBtn = Button.create("GREEN").setBackground(Background.GREEN).asElement();
        setStyle(greenBtn);
        card.appendContent(greenBtn);

        element.appendChild(card.asElement());

        createCodeBlock("card.appendContent(Button.create(\"RED\").setBackground(Background.RED).asElement());\n" +
                "card.appendContent(Button.create(\"PURPLE\").setBackground(Background.PURPLE).asElement());\n" +
                "card.appendContent(Button.create(\"INDIGO\").setBackground(Background.INDIGO).asElement());\n" +
                "card.appendContent(Button.create(\"LIGHT BLUE\").setBackground(Background.LIGHT_BLUE).asElement());\n" +
                "card.appendContent(Button.create(\"GREEN\").setBackground(Background.GREEN).asElement());");
    }

    private void setStyle(HTMLElement element) {
        setMargin(element);
        element.style.minWidth = CSSProperties.MinWidthUnionType.of("140px");
    }

    private void setMargin(HTMLElement element) {
        setMargin(element, "5px");
    }

    private void setMargin(HTMLElement element, String margin) {
        element.style.margin = CSSProperties.MarginUnionType.of(margin);
    }

    @Override
    public void showIn(Content content) {
        HTMLElement contentElement = Js.cast(content.get());
        contentElement.appendChild(element);
    }

    private void createCodeBlock(String s) {
        element.appendChild(Card.createCodeCard(s).asElement());
    }
}