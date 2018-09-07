package org.dominokit.domino.buttons.client.views.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLHeadingElement;
import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.domino.buttons.client.presenters.ButtonsPresenter;
import org.dominokit.domino.buttons.client.views.ButtonsView;
import org.dominokit.domino.buttons.client.views.CodeResource;
import org.dominokit.domino.componentcase.client.ui.views.LinkToSourceCode;
import org.dominokit.domino.componentcase.shared.extension.ComponentView;
import org.dominokit.domino.ui.button.*;
import org.dominokit.domino.ui.button.group.ButtonsGroup;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.dropdown.DropDownPosition;
import org.dominokit.domino.ui.dropdown.DropdownAction;
import org.dominokit.domino.ui.grid.Column;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.header.BlockHeader;
import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.style.Style;
import org.dominokit.domino.ui.style.StyleType;
import org.dominokit.domino.ui.style.Styles;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.jboss.gwt.elemento.core.Elements.div;
import static org.jboss.gwt.elemento.core.Elements.h;


@UiView(presentable = ButtonsPresenter.class)
public class ButtonsViewImpl extends ComponentView<HTMLDivElement> implements ButtonsView {

    private static final Logger LOGGER = LoggerFactory.getLogger(ButtonsViewImpl.class);

    private HTMLDivElement element = div().asElement();

    @Override
    public HTMLDivElement getElement() {
        return element;
    }

    @Override
    public void init() {
        GWT.runAsync(new RunAsyncCallback() {
            @Override
            public void onFailure(Throwable reason) {
                LOGGER.error("Failed to run async Buttons view");
            }

            @Override
            public void onSuccess() {
                element.appendChild(LinkToSourceCode.create("buttons", ButtonsViewImpl.this.getClass()).asElement());
                element.appendChild(BlockHeader.create("BUTTONS").asElement());
                initBootstrapButtons();
                initMaterialDesignButtons();
                initButtonSizes();
                initBlockButtons();
                initDisabledButtons();
                initButtons();
                initTextButtons();
                element.appendChild(BlockHeader.create("BUTTON GROUPS", "Group a series of buttons together on a single line with the button group").asElement());
                initButtonsBasicGroup();
                initButtonsToolbar();
                initSizingGroup();
                initNestingGroup();
                initVerticalGroup();
                element.appendChild(BlockHeader.create("BUTTON DROPDOWNS", "Use any button to trigger a dropdown menu by placing it within a .btn-group and providing the proper menu markup.").asElement());
                initSingleDropdownButtons();
                initSplitButton();
                initDropDownPosition();
            }
        });

    }

    private void initDropDownPosition() {
        element.appendChild(Card.create("DROPUP VARIATION", "Trigger dropdown menus above elements.")
                .appendChild(DropdownButton.createDefault("TOP")
                        .appendChild(DropdownAction.create("Action"))
                        .appendChild(DropdownAction.create("Another action"))
                        .setPosition(DropDownPosition.TOP)
                        .style()
                        .setMargin("5px")
                        .setMinWidth("120px"))
                .appendChild(DropdownButton.createDefault("BOTTOM")
                        .appendChild(DropdownAction.create("Action"))
                        .appendChild(DropdownAction.create("Another action"))
                        .setPosition(DropDownPosition.BOTTOM)
                        .style()
                        .setMargin("5px")
                        .setMinWidth("120px"))
                .appendChild(DropdownButton.createDefault("TOP LEFT")
                        .appendChild(DropdownAction.create("Action"))
                        .appendChild(DropdownAction.create("Another action"))
                        .setPosition(DropDownPosition.TOP_LEFT)
                        .style()
                        .setMargin("5px")
                        .setMinWidth("120px"))
                .appendChild(DropdownButton.createDefault("TOP RIGHT")
                        .appendChild(DropdownAction.create("Action"))
                        .appendChild(DropdownAction.create("Another action"))
                        .setPosition(DropDownPosition.TOP_RIGHT)
                        .style()
                        .setMargin("5px")
                        .setMinWidth("120px"))
                .appendChild(DropdownButton.createDefault("BOTTOM LEFT")
                        .appendChild(DropdownAction.create("Action"))
                        .appendChild(DropdownAction.create("Another action"))
                        .setPosition(DropDownPosition.BOTTOM_LEFT)
                        .style()
                        .setMargin("5px")
                        .setMinWidth("120px"))
                .appendChild(DropdownButton.createDefault("BOTTOM RIGHT")
                        .appendChild(DropdownAction.create("Action"))
                        .appendChild(DropdownAction.create("Another action"))
                        .setPosition(DropDownPosition.BOTTOM_RIGHT)
                        .style()
                        .setMargin("5px")
                        .setMinWidth("120px"))
                .asElement());

        this.element.appendChild(Card.createCodeCard(CodeResource.INSTANCE.initDropUp()).asElement());
    }

    private void initSplitButton() {
        element.appendChild(Card.create("SPLITE BUTTON DROPDOWNS", "Similarly, create split button dropdowns with the same markup changes, only with a separate button.")
                .appendChild(SplitButton.createDefault("DEFAULT")
                        .addDropdown(DropdownButton.createDefault("Toggle Dropdown")
                                .appendChild(DropdownAction.create("Action"))
                                .appendChild(DropdownAction.create("Another action"))
                                .appendChild(DropdownAction.create("Something else here"))
                                .separator()
                                .appendChild(DropdownAction.create("Separated link")))
                        .style().setMargin("10px"))
                .appendChild(SplitButton.createPrimary("PRIMARY")
                        .addDropdown(DropdownButton.createPrimary("Toggle Dropdown")
                                .appendChild(DropdownAction.create("Action"))
                                .appendChild(DropdownAction.create("Another action"))
                                .appendChild(DropdownAction.create("Something else here"))
                                .separator()
                                .appendChild(DropdownAction.create("Separated link")))
                        .style().setMargin("10px"))
                .appendChild(SplitButton.createWarning("WARNING")
                        .addDropdown(DropdownButton.createWarning("Toggle Dropdown")
                                .appendChild(DropdownAction.create("Action"))
                                .appendChild(DropdownAction.create("Another action"))
                                .appendChild(DropdownAction.create("Something else here"))
                                .separator()
                                .appendChild(DropdownAction.create("Separated link")))
                        .style().setMargin("10px"))
                .appendChild(SplitButton.createInfo("INFO")
                        .addDropdown(DropdownButton.createInfo("Toggle Dropdown")
                                .appendChild(DropdownAction.create("Action"))
                                .appendChild(DropdownAction.create("Another action"))
                                .appendChild(DropdownAction.create("Something else here"))
                                .separator()
                                .appendChild(DropdownAction.create("Separated link")))
                        .style().setMargin("10px"))
                .asElement());

        element.appendChild(Card.createCodeCard(CodeResource.INSTANCE.initSplitButton()).asElement());
    }

    private void initSingleDropdownButtons() {
        element.appendChild(Card.create("SINGLE BUTTON DROPDOWNS", "Turn a button into a dropdown toggle with some basic markup changes.")
                .appendChild(DropdownButton.createDefault("DEFAULT")
                        .appendChild(DropdownAction.create("Action"))
                        .appendChild(DropdownAction.create("Another action"))
                        .appendChild(DropdownAction.create("Something else here"))
                        .separator()
                        .appendChild(DropdownAction.create("Separated link"))
                        .style().setMargin("5px"))
                .appendChild(DropdownButton.createPrimary("PRIMARY")
                        .appendChild(DropdownAction.create("Action"))
                        .appendChild(DropdownAction.create("Another action"))
                        .appendChild(DropdownAction.create("Something else here"))
                        .separator()
                        .appendChild(DropdownAction.create("Separated link"))
                        .style().setMargin("5px"))
                .appendChild(DropdownButton.createInfo("INFO")
                        .appendChild(DropdownAction.create("Action"))
                        .appendChild(DropdownAction.create("Another action"))
                        .appendChild(DropdownAction.create("Something else here"))
                        .separator()
                        .appendChild(DropdownAction.create("Separated link"))
                        .style().setMargin("5px"))
                .appendChild(DropdownButton.createWarning("WARNING")
                        .appendChild(DropdownAction.create("Action"))
                        .appendChild(DropdownAction.create("Another action"))
                        .appendChild(DropdownAction.create("Something else here"))
                        .separator()
                        .appendChild(DropdownAction.create("Separated link"))
                        .style().setMargin("5px"))
                .appendChild(DropdownButton.createDanger("DANGER")
                        .appendChild(DropdownAction.create("Action"))
                        .appendChild(DropdownAction.create("Another action"))
                        .appendChild(DropdownAction.create("Something else here"))
                        .separator()
                        .appendChild(DropdownAction.create("Separated link"))
                        .style().setMargin("5px"))
                .appendChild(DropdownButton.create(Icons.ALL.delete())
                        .appendChild(DropdownAction.create("Action"))
                        .appendChild(DropdownAction.create("Another action"))
                        .appendChild(DropdownAction.create("Something else here"))
                        .separator()
                        .appendChild(DropdownAction.create("Separated link"))
                        .style().setMargin("5px"))
                .asElement());

        element.appendChild(Card.createCodeCard(CodeResource.INSTANCE.initSingleDropdownButtons()).asElement());
    }

    private void initVerticalGroup() {
        element.appendChild(Card.create("VERTICAL VARIATION", "Make a set of buttons appear vertically stacked rather than horizontally.")
                .appendChild(ButtonsGroup.create()
                        .appendChild(Button.createDefault("Button"))
                        .appendChild(Button.createPrimary("Button"))
                        .appendChild(DropdownButton.createInfo("Dropdown")
                                .appendChild(DropdownAction.create("Dropdown link"))
                                .appendChild(DropdownAction.create("Dropdown link")))
                        .appendChild(Button.createDanger("Button"))
                        .verticalAlign()
                        .style().setMargin("5px"))
                .asElement());

        element.appendChild(Card.createCodeCard(CodeResource.INSTANCE.initVerticalGroup()).asElement());
    }

    private void initNestingGroup() {
        element.appendChild(Card.create("SIZING", "Dropdown can be used inside a group of buttons.")
                .appendChild(ButtonsGroup.create()
                        .appendChild(Button.create("1").setButtonType(StyleType.DEFAULT))
                        .appendChild(Button.create("2").setButtonType(StyleType.DEFAULT))
                        .appendChild(DropdownButton.create("Dropdown", StyleType.DEFAULT)
                                .appendChild(DropdownAction.create("Dropdown link"))
                                .appendChild(DropdownAction.create("Dropdown link")))
                        .style()
                        .setMargin("5px")
                        .setMinWidth("120px"))
                .appendChild(ButtonsGroup.create()
                        .appendChild(Button.create("1").setButtonType(StyleType.PRIMARY))
                        .appendChild(Button.create("2").setButtonType(StyleType.PRIMARY))
                        .appendChild(DropdownButton.create("Dropdown", StyleType.PRIMARY)
                                .appendChild(DropdownAction.create("Dropdown link"))
                                .appendChild(DropdownAction.create("Dropdown link")))
                        .style()
                        .setMargin("5px")
                        .setMinWidth("120px"))
                .appendChild(ButtonsGroup.create()
                        .appendChild(Button.create("1").setButtonType(StyleType.INFO))
                        .appendChild(Button.create("2").setButtonType(StyleType.INFO))
                        .appendChild(DropdownButton.create("Dropdown", StyleType.INFO)
                                .appendChild(DropdownAction.create("Dropdown link"))
                                .appendChild(DropdownAction.create("Dropdown link")))
                        .style()
                        .setMargin("5px")
                        .setMinWidth("120px"))
                .appendChild(ButtonsGroup.create()
                        .appendChild(Button.create("1").setButtonType(StyleType.SUCCESS))
                        .appendChild(Button.create("2").setButtonType(StyleType.SUCCESS))
                        .appendChild(DropdownButton.create("Dropdown", StyleType.SUCCESS)
                                .appendChild(DropdownAction.create("Dropdown link"))
                                .appendChild(DropdownAction.create("Dropdown link")))
                        .style()
                        .setMargin("5px")
                        .setMinWidth("120px"))
                .appendChild(ButtonsGroup.create()
                        .appendChild(Button.create("1").setButtonType(StyleType.DANGER))
                        .appendChild(Button.create("2").setButtonType(StyleType.DANGER))
                        .appendChild(DropdownButton.create("Dropdown", StyleType.DANGER)
                                .appendChild(DropdownAction.create("Dropdown link"))
                                .appendChild(DropdownAction.create("Dropdown link")))
                        .style()
                        .setMargin("5px")
                        .setMinWidth("120px"))
                .appendChild(ButtonsGroup.create()
                        .appendChild(Button.create("1").setButtonType(StyleType.WARNING))
                        .appendChild(Button.create("2").setButtonType(StyleType.WARNING))
                        .appendChild(DropdownButton.create("Dropdown", StyleType.WARNING)
                                .appendChild(DropdownAction.create("Dropdown link"))
                                .appendChild(DropdownAction.create("Dropdown link")))
                        .style()
                        .setMargin("5px")
                        .setMinWidth("120px"))
                .asElement());

        element.appendChild(Card.createCodeCard(CodeResource.INSTANCE.initNestingGroup()).asElement());
    }

    private void initSizingGroup() {

        element.appendChild(Card.create("SIZING", "Instead of applying button sizing classes to every button in a group, size can be applied to the group and will be applied to every button.")
                .appendChild(Row.create()
                        .addColumn(Column.span3()
                                .style().add(Styles.align_center).get()
                                .appendChild(heading("Large Button Group"))
                                .appendChild(ButtonsGroup.create()
                                        .appendChild(Button.createDefault("LEFT"))
                                        .appendChild(Button.createDefault("MIDDLE"))
                                        .appendChild(Button.createDefault("RIGHT"))
                                        .setSize(ButtonSize.LARGE)
                                        .style().setMargin("15px")))
                        .addColumn(Column.span3()
                                .style().add(Styles.align_center).get()
                                .appendChild(heading("Default Button Group"))
                                .appendChild(ButtonsGroup.create()
                                        .appendChild(Button.createDefault("LEFT"))
                                        .appendChild(Button.createDefault("MIDDLE"))
                                        .appendChild(Button.createDefault("RIGHT"))
                                        .style().setMargin("15px")))
                        .addColumn(Column.span3()
                                .style().add(Styles.align_center).get()
                                .appendChild(heading("Small Button Group"))
                                .appendChild(ButtonsGroup.create()
                                        .appendChild(Button.createDefault("LEFT"))
                                        .appendChild(Button.createDefault("MIDDLE"))
                                        .appendChild(Button.createDefault("RIGHT"))
                                        .setSize(ButtonSize.SMALL)
                                        .style().setMargin("15px")))
                        .addColumn(Column.span3()
                                .style().add(Styles.align_center).get()
                                .appendChild(heading("Extra-Small Button Group"))
                                .appendChild(ButtonsGroup.create()
                                        .appendChild(Button.createDefault("LEFT"))
                                        .appendChild(Button.createDefault("MIDDLE"))
                                        .appendChild(Button.createDefault("RIGHT"))
                                        .setSize(ButtonSize.XSMALL)
                                        .style().setMargin("15px"))))
                .asElement());

        element.appendChild(Card.createCodeCard(CodeResource.INSTANCE.initSizingGroup()).asElement());
    }

    private void initButtonsToolbar() {
        element.appendChild(Card.create("BUTTON TOOLBAR", "Create buttons toolbar")
                .appendChild(Row.create()
                        .addColumn(Column.span3()
                                .appendChild(ButtonsToolbar.create()
                                        .addGroup(ButtonsGroup.create()
                                                .appendChild(Button.createDefault("1"))
                                                .appendChild(Button.createDefault("2"))
                                                .appendChild(Button.createDefault("3")))
                                        .addGroup(ButtonsGroup.create()
                                                .appendChild(Button.createDefault("4"))
                                                .appendChild(Button.createDefault("5"))
                                                .appendChild(Button.createDefault("6")))
                                        .addGroup(ButtonsGroup.create()
                                                .appendChild(Button.createDefault("7")))
                                        .style()
                                        .setMargin("5px")
                                        .setFloat("left")))
                        .addColumn(Column.span3()
                                .appendChild(ButtonsToolbar.create()
                                        .addGroup(ButtonsGroup.create()
                                                .appendChild(Button.createPrimary("1"))
                                                .appendChild(Button.createPrimary("2"))
                                                .appendChild(Button.createPrimary("3")))
                                        .addGroup(ButtonsGroup.create()
                                                .appendChild(Button.createPrimary("4"))
                                                .appendChild(Button.createPrimary("5"))
                                                .appendChild(Button.createPrimary("6")))
                                        .addGroup(ButtonsGroup.create()
                                                .appendChild(Button.createPrimary("7")))
                                        .style()
                                        .setMargin("5px")
                                        .setFloat("left")))
                        .addColumn(Column.span3()
                                .appendChild(ButtonsToolbar.create()
                                        .addGroup(ButtonsGroup.create()
                                                .appendChild(Button.createInfo("1"))
                                                .appendChild(Button.createInfo("2"))
                                                .appendChild(Button.createInfo("3")))
                                        .addGroup(ButtonsGroup.create()
                                                .appendChild(Button.createInfo("4"))
                                                .appendChild(Button.createInfo("5"))
                                                .appendChild(Button.createInfo("6")))
                                        .addGroup(ButtonsGroup.create()
                                                .appendChild(Button.createInfo("7")))
                                        .style()
                                        .setMargin("5px")
                                        .setFloat("left")))
                        .addColumn(Column.span3()
                                .appendChild(ButtonsToolbar.create()
                                        .addGroup(ButtonsGroup.create()
                                                .appendChild(Button.create("1").setBackground(Color.PURPLE))
                                                .appendChild(Button.create("2").setBackground(Color.PURPLE))
                                                .appendChild(Button.create("3").setBackground(Color.PURPLE)))
                                        .addGroup(ButtonsGroup.create()
                                                .appendChild(Button.create("4").setBackground(Color.PURPLE))
                                                .appendChild(Button.create("5").setBackground(Color.PURPLE))
                                                .appendChild(Button.create("6").setBackground(Color.PURPLE)))
                                        .addGroup(ButtonsGroup.create()
                                                .appendChild(Button.create("7").setBackground(Color.PURPLE)))
                                        .style()
                                        .setMargin("5px")
                                        .setFloat("left")))
                )
                .asElement());

        element.appendChild(Card.createCodeCard(CodeResource.INSTANCE.initButtonsToolbar()).asElement());
    }

    private void initButtonsBasicGroup() {
        element.appendChild(Card.create("BASIC EXAMPLE", "Create group of buttons")
                .appendChild(ButtonsGroup.create()
                        .appendChild(Button.createDefault("LEFT"))
                        .appendChild(Button.createDefault("MIDDLE"))
                        .appendChild(Button.createDefault("RIGHT"))
                        .style()
                        .setMargin("5px")
                        .setMinWidth("120px"))
                .appendChild(ButtonsGroup.create()
                        .appendChild(Button.createPrimary("LEFT"))
                        .appendChild(Button.createPrimary("MIDDLE"))
                        .appendChild(Button.createPrimary("RIGHT"))
                        .style()
                        .setMargin("5px")
                        .setMinWidth("120px"))
                .appendChild(ButtonsGroup.create()
                        .appendChild(Button.createSuccess("LEFT"))
                        .appendChild(Button.createSuccess("MIDDLE"))
                        .appendChild(Button.createSuccess("RIGHT"))
                        .style()
                        .setMargin("5px")
                        .setMinWidth("120px"))
                .appendChild(ButtonsGroup.create()
                        .appendChild(Button.createInfo("LEFT"))
                        .appendChild(Button.createInfo("MIDDLE"))
                        .appendChild(Button.createInfo("RIGHT"))
                        .style()
                        .setMargin("5px")
                        .setMinWidth("120px"))
                .appendChild(ButtonsGroup.create()
                        .appendChild(Button.createDanger("LEFT"))
                        .appendChild(Button.createDanger("MIDDLE"))
                        .appendChild(Button.createDanger("RIGHT"))
                        .style()
                        .setMargin("5px")
                        .setMinWidth("120px"))
                .appendChild(ButtonsGroup.create()
                        .appendChild(Button.create("LEFT").setBackground(Color.PURPLE))
                        .appendChild(Button.create("MIDDLE").setBackground(Color.PURPLE))
                        .appendChild(Button.create("RIGHT").setBackground(Color.PURPLE))
                        .style()
                        .setMargin("5px")
                        .setMinWidth("120px")).asElement());

        element.appendChild(Card.createCodeCard(CodeResource.INSTANCE.initButtonsBasicGroup()).asElement());
    }

    private void initTextButtons() {
        element.appendChild(Card.create("ICON & TEXT BUTTONS", "Make icon & text buttons")
                .appendChild(Button.create(Icons.ALL.extension())
                        .setContent("EXTENSION")
                        .setContent("EXTENSION")
                        .style()
                        .setMargin("5px")
                        .setMinWidth("120px"))
                .appendChild(Button.createPrimary(Icons.ALL.home())
                        .setContent("HOME")
                        .style()
                        .setMargin("5px")
                        .setMinWidth("120px"))
                .appendChild(Button.createSuccess(Icons.ALL.lock())
                        .setContent("LOCK")
                        .style()
                        .setMargin("5px")
                        .setMinWidth("120px"))
                .appendChild(Button.createInfo(Icons.ALL.perm_scan_wifi())
                        .setContent("SCAN WIFI")
                        .style()
                        .setMargin("5px")
                        .setMinWidth("120px"))
                .appendChild(Button.createWarning(Icons.ALL.flight_takeoff())
                        .setContent("TAKE OFF")
                        .style()
                        .setMargin("5px")
                        .setMinWidth("120px"))
                .appendChild(Button.createDanger(Icons.ALL.print())
                        .setContent("PRINT")
                        .style()
                        .setMargin("5px")
                        .setMinWidth("120px"))
                .asElement());

        element.appendChild(Card.createCodeCard(CodeResource.INSTANCE.initTextButtons()).asElement());
    }

    private void initButtons() {
        element.appendChild(Card.create("ICON BUTTONS", "Make icon buttons")
                .appendChild(Row.create()
                        .fullSpan(column -> column.appendChild(heading("Normal Icon Button"))))
                .appendChild(Row.create()
                        .addColumn(Column.span1()
                                .appendChild(Button.create(Icons.ALL.home())
                                        .setButtonType(StyleType.DEFAULT)
                                        .style().setMargin("5px")))
                        .addColumn(Column.span1()
                                .appendChild(Button.createPrimary(Icons.ALL.mic())
                                        .setButtonType(StyleType.PRIMARY)
                                        .style().setMargin("5px")))
                        .addColumn(Column.span1()
                                .appendChild(Button.createInfo(Icons.ALL.more())
                                        .setButtonType(StyleType.INFO)
                                        .style().setMargin("5px")))
                        .addColumn(Column.span1()
                                .appendChild(Button.createSuccess(Icons.ALL.keyboard())
                                        .setButtonType(StyleType.SUCCESS)
                                        .style().setMargin("5px")))
                        .addColumn(Column.span1()
                                .appendChild(Button.createWarning(Icons.ALL.ac_unit())
                                        .setButtonType(StyleType.WARNING)
                                        .style().setMargin("5px")))
                        .addColumn(Column.span1()
                                .appendChild(Button.createDanger(Icons.ALL.access_alarm())
                                        .setButtonType(StyleType.DANGER)
                                        .style().setMargin("5px")))
                )
                .appendChild(Row.create()
                        .fullSpan(column -> column.appendChild(heading("Small Circle Icon Button"))))
                .appendChild(Row.create()
                        .addColumn(Column.span1()
                                .appendChild(Button.create(Icons.ALL.add_circle())
                                        .circle(CircleSize.SMALL)
                                        .setButtonType(StyleType.DEFAULT)
                                        .style().setMargin("5px")))
                        .addColumn(Column.span1()
                                .appendChild(Button.createPrimary(Icons.ALL.place())
                                        .circle(CircleSize.SMALL)
                                        .setButtonType(StyleType.PRIMARY)
                                        .style().setMargin("5px")))
                        .addColumn(Column.span1()
                                .appendChild(Button.createInfo(Icons.ALL.airplanemode_active())
                                        .circle(CircleSize.SMALL)
                                        .setButtonType(StyleType.INFO)
                                        .style().setMargin("5px")))
                        .addColumn(Column.span1()
                                .appendChild(Button.createSuccess(Icons.ALL.album())
                                        .circle(CircleSize.SMALL)
                                        .setButtonType(StyleType.SUCCESS)
                                        .style().setMargin("5px")))
                        .addColumn(Column.span1()
                                .appendChild(Button.createWarning(Icons.ALL.weekend())
                                        .circle(CircleSize.SMALL)
                                        .setButtonType(StyleType.WARNING)
                                        .style().setMargin("5px")))
                        .addColumn(Column.span1()
                                .appendChild(Button.createDanger(Icons.ALL.airplay())
                                        .circle(CircleSize.SMALL)
                                        .setButtonType(StyleType.DANGER)
                                        .style().setMargin("5px")))
                )
                .appendChild(Row.create()
                        .fullSpan(column -> column.appendChild(heading("Large Circle Icon Button"))))
                .appendChild(Row.create()
                        .addColumn(Column.span1()
                                .appendChild(Button.create(Icons.ALL.adjust())
                                        .circle(CircleSize.LARGE)
                                        .setButtonType(StyleType.DEFAULT)
                                        .style().setMargin("5px")))
                        .addColumn(Column.span1()
                                .appendChild(Button.createPrimary(Icons.ALL.all_out())
                                        .circle(CircleSize.LARGE)
                                        .setButtonType(StyleType.PRIMARY)
                                        .style().setMargin("5px")))
                        .addColumn(Column.span1()
                                .appendChild(Button.createInfo(Icons.ALL.apps())
                                        .circle(CircleSize.LARGE)
                                        .setButtonType(StyleType.INFO)
                                        .style().setMargin("5px")))
                        .addColumn(Column.span1()
                                .appendChild(Button.createSuccess(Icons.ALL.art_track())
                                        .circle(CircleSize.LARGE)
                                        .setButtonType(StyleType.SUCCESS)
                                        .style().setMargin("5px")))
                        .addColumn(Column.span1()
                                .appendChild(Button.createWarning(Icons.ALL.assessment())
                                        .circle(CircleSize.LARGE)
                                        .setButtonType(StyleType.WARNING)
                                        .style().setMargin("5px")))
                        .addColumn(Column.span1()
                                .appendChild(Button.createDanger(Icons.ALL.assistant())
                                        .circle(CircleSize.LARGE)
                                        .setButtonType(StyleType.DANGER)
                                        .style().setMargin("5px")))
                ).asElement());

        element.appendChild(Card.createCodeCard(CodeResource.INSTANCE.initIconButtons()).asElement());
    }

    private HTMLHeadingElement heading(String content) {
        return Style.of(h(2, content))
                .setMarginTop("25px")
                .setMarginBottom("0px")
                .setFontSize("15px")
                .setColor("#000")
                .setDisplay("block").get().asElement();
    }

    private void initDisabledButtons() {
        element.appendChild(Card.create("DISABLED BUTTONS", "Make buttons look unclickable by fading them back with opacity")
                .appendChild(Button.createDefault("DEFAULT")
                        .disable()
                        .style()
                        .setMargin("5px")
                        .setMinWidth("120px"))
                .appendChild(Button.createPrimary("PRIMARY")
                        .disable()
                        .style()
                        .setMargin("5px")
                        .setMinWidth("120px"))
                .appendChild(Button.createInfo("INFO")
                        .disable()
                        .style()
                        .setMargin("5px")
                        .setMinWidth("120px"))
                .appendChild(Button.createWarning("WARNING")
                        .disable()
                        .style()
                        .setMargin("5px")
                        .setMinWidth("120px"))
                .appendChild(Button.createDanger("DANGER")
                        .disable()
                        .style()
                        .setMargin("5px")
                        .setMinWidth("120px"))
                .asElement());

        element.appendChild(Card.createCodeCard(CodeResource.INSTANCE.initDisabledButtons()).asElement());
    }

    private void initBlockButtons() {
        element.appendChild(Card.create("BLOCK BUTTONS", "Create block level buttons")
                .appendChild(Button.createDefault("DEFAULT")
                        .setBlock(true)
                        .style()
                        .setMargin("5px")
                        .setMinWidth("120px"))
                .appendChild(Button.createPrimary("PRIMARY")
                        .setBlock(true)
                        .style()
                        .setMargin("5px")
                        .setMinWidth("120px"))
                .appendChild(Button.createInfo("INFO")
                        .setBlock(true)
                        .style()
                        .setMargin("5px")
                        .setMinWidth("120px"))
                .appendChild(Button.createWarning("WARNING")
                        .setBlock(true)
                        .style()
                        .setMargin("5px")
                        .setMinWidth("120px"))
                .appendChild(Button.createDanger("DANGER")
                        .setBlock(true)
                        .style()
                        .setMargin("5px")
                        .setMinWidth("120px"))
                .asElement());

        element.appendChild(Card.createCodeCard(CodeResource.INSTANCE.initBlockButtons()).asElement());

    }

    private void initButtonSizes() {
        element.appendChild(Card.create("BUTTON SIZES", "You can resize the buttons")
                .appendChild(Row.create()
                        .style().setMargin("10px")
                        .get()
                        .fullSpan(column -> {
                            column.appendChild(Row.create()
                                    .addColumn(Column.span(3, 3, 6, 12)
                                            .appendChild(Row.create()
                                                    .appendChild(Button.createDefault("LARGE")
                                                            .setSize(ButtonSize.LARGE)
                                                            .style()
                                                            .setMargin("5px")
                                                            .setMinWidth("200px")))
                                            .appendChild(Row.create()
                                                    .appendChild(Button.createDefault("DEFAULT")
                                                            .style()
                                                            .setMargin("5px")
                                                            .setMinWidth("200px")))
                                            .appendChild(Row.create()
                                                    .appendChild(Button.createDefault("SMALL").setSize(ButtonSize.SMALL)
                                                            .style()
                                                            .setMargin("5px")
                                                            .setMinWidth("200px")))
                                            .appendChild(Row.create()
                                                    .appendChild(Button.createDefault("XSMALL").setSize(ButtonSize.XSMALL)
                                                            .style()
                                                            .setMargin("5px")
                                                            .setMinWidth("200px"))))
                                    .addColumn(Column.span(3, 3, 6, 12)
                                            .appendChild(Row.create()
                                                    .appendChild(Button.createPrimary("LARGE").setSize(ButtonSize.LARGE)
                                                            .style()
                                                            .setMargin("5px")
                                                            .setMinWidth("200px")))
                                            .appendChild(Row.create()
                                                    .appendChild(Button.createPrimary("DEFAULT")
                                                            .style()
                                                            .setMargin("5px")
                                                            .setMinWidth("200px")))
                                            .appendChild(Row.create()
                                                    .appendChild(Button.createPrimary("SMALL").setSize(ButtonSize.SMALL)
                                                            .style()
                                                            .setMargin("5px")
                                                            .setMinWidth("200px")))
                                            .appendChild(Row.create()
                                                    .appendChild(Button.createPrimary("XSMALL").setSize(ButtonSize.XSMALL)
                                                            .style()
                                                            .setMargin("5px")
                                                            .setMinWidth("200px"))))
                                    .addColumn(Column.span(3, 3, 6, 12)
                                            .appendChild(Row.create()
                                                    .appendChild(Button.createWarning("LARGE").setSize(ButtonSize.LARGE)
                                                            .style()
                                                            .setMargin("5px")
                                                            .setMinWidth("200px")))
                                            .appendChild(Row.create()
                                                    .appendChild(Button.createWarning("DEFAULT")
                                                            .style()
                                                            .setMargin("5px")
                                                            .setMinWidth("200px")))
                                            .appendChild(Row.create()
                                                    .appendChild(Button.createWarning("SMALL").setSize(ButtonSize.SMALL)
                                                            .style()
                                                            .setMargin("5px")
                                                            .setMinWidth("200px")))
                                            .appendChild(Row.create()
                                                    .appendChild(Button.createWarning("XSMALL").setSize(ButtonSize.XSMALL)
                                                            .style()
                                                            .setMargin("5px")
                                                            .setMinWidth("200px"))))
                                    .addColumn(Column.span(3, 3, 6, 12)
                                            .appendChild(Row.create()
                                                    .appendChild(Button.createInfo("LARGE").setSize(ButtonSize.LARGE)
                                                            .style()
                                                            .setMargin("5px")
                                                            .setMinWidth("200px")))
                                            .appendChild(Row.create()
                                                    .appendChild(Button.createInfo("DEFAULT")
                                                            .style()
                                                            .setMargin("5px")
                                                            .setMinWidth("200px")))
                                            .appendChild(Row.create()
                                                    .appendChild(Button.createInfo("SMALL").setSize(ButtonSize.SMALL)
                                                            .style()
                                                            .setMargin("5px")
                                                            .setMinWidth("200px")))
                                            .appendChild(Row.create()
                                                    .appendChild(Button.createInfo("XSMALL").setSize(ButtonSize.XSMALL)
                                                            .style()
                                                            .setMargin("5px")
                                                            .setMinWidth("200px")))));
                        })
                ).asElement());

        element.appendChild(Card.createCodeCard(CodeResource.INSTANCE.initButtonSizes()).asElement());

    }

    private void initBootstrapButtons() {
        element.appendChild(Card.create("BOOTSTRAP DEFAULT BUTTONS", "Use any of the available button classes to quickly create a styled button")
                .appendChild(Button.createDefault("DEFAULT")
                        .style()
                        .setMargin("5px")
                        .setMinWidth("120px"))
                .appendChild(Button.createPrimary("PRIMARY")
                        .style()
                        .setMargin("5px")
                        .setMinWidth("120px"))
                .appendChild(Button.createSuccess("SUCCESS")
                        .style()
                        .setMargin("5px")
                        .setMinWidth("120px"))
                .appendChild(Button.createInfo("INFO")
                        .style()
                        .setMargin("5px")
                        .setMinWidth("120px"))
                .appendChild(Button.createWarning("WARNING")
                        .style()
                        .setMargin("5px")
                        .setMinWidth("120px"))
                .appendChild(Button.createDanger("DANGER")
                        .style()
                        .setMargin("5px")
                        .setMinWidth("120px"))
                .asElement());

        element.appendChild(Card.createCodeCard(CodeResource.INSTANCE.initBootstrapButtons()).asElement());
    }

    private void initMaterialDesignButtons() {
        element.appendChild(Card.create("METARIAL DESIGN BUTTONS", "Use any of the available button classes to quickly create a styled button")
                .appendChild(Button.create("RED").setBackground(Color.RED)
                        .style()
                        .setMargin("5px")
                        .setMinWidth("120px"))
                .appendChild(Button.create("PURPLE").setBackground(Color.PURPLE)
                        .style()
                        .setMargin("5px")
                        .setMinWidth("120px"))
                .appendChild(Button.create("INDIGO").setBackground(Color.INDIGO)
                        .style()
                        .setMargin("5px")
                        .setMinWidth("120px"))
                .appendChild(Button.create("LIGHT BLUE").setBackground(Color.LIGHT_BLUE)
                        .style()
                        .setMargin("5px")
                        .setMinWidth("120px"))
                .appendChild(Button.create("GREEN").setBackground(Color.GREEN)
                        .style()
                        .setMargin("5px")
                        .setMinWidth("120px"))
                .asElement());

        element.appendChild(Card.createCodeCard(CodeResource.INSTANCE.initMaterialDesignButtons()).asElement());
    }
}