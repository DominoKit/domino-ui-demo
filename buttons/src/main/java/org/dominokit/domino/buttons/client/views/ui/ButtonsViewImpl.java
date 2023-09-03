package org.dominokit.domino.buttons.client.views.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.SampleClass;
import org.dominokit.domino.SampleMethod;
import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.domino.buttons.client.presenters.ButtonsProxy;
import org.dominokit.domino.buttons.client.views.ButtonsView;
import org.dominokit.domino.componentcase.client.ui.views.BaseDemoView;
import org.dominokit.domino.componentcase.client.ui.views.CodeCard;
import org.dominokit.domino.componentcase.client.ui.views.LinkToSourceCode;
import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.button.ButtonsToolbar;
import org.dominokit.domino.ui.button.DropdownButton;
import org.dominokit.domino.ui.button.LinkButton;
import org.dominokit.domino.ui.button.group.ButtonsGroup;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.elements.HeadingElement;
import org.dominokit.domino.ui.grid.Column;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.icons.lib.Icons;
import org.dominokit.domino.ui.menu.Menu;
import org.dominokit.domino.ui.menu.MenuItem;
import org.dominokit.domino.ui.typography.BlockHeader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.dominokit.domino.ui.grid.Column.Span._12;
import static org.dominokit.domino.ui.grid.Column.Span._3;
import static org.dominokit.domino.ui.grid.Column.Span._6;
import static org.dominokit.domino.ui.menu.direction.DropDirection.BOTTOM_LEFT;
import static org.dominokit.domino.ui.menu.direction.DropDirection.BOTTOM_MIDDLE;
import static org.dominokit.domino.ui.menu.direction.DropDirection.BOTTOM_RIGHT;
import static org.dominokit.domino.ui.menu.direction.DropDirection.TOP_LEFT;
import static org.dominokit.domino.ui.menu.direction.DropDirection.TOP_MIDDLE;
import static org.dominokit.domino.ui.menu.direction.DropDirection.TOP_RIGHT;

@UiView(presentable = ButtonsProxy.class)
@SampleClass
public class ButtonsViewImpl extends BaseDemoView<HTMLDivElement> implements ButtonsView {

    private static final Logger LOGGER = LoggerFactory.getLogger(ButtonsViewImpl.class);

    private DivElement element;

    @Override
    protected HTMLDivElement init() {
        element = div();

        uiHandlers.startLoading();
        GWT.runAsync(new RunAsyncCallback() {
            @Override
            public void onFailure(Throwable reason) {
                LOGGER.error("Failed to run async Buttons view");
            }

            @Override
            public void onSuccess() {
                element.appendChild(LinkToSourceCode.createLink("buttons", ButtonsViewImpl.this.getClass()).element());
                element.appendChild(BlockHeader.create("BUTTONS").element());
                initSimpleButtons();
                element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.initSimpleButtons()).element());

                initButtonSizes();
                element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.initButtonSizes()).element());

                initDisabledButtons();
                element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.initDisabledButtons()).element());

                initButtons();
                element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.initButtons()).element());

                initTextButtons();
                element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.initTextButtons()).element());

                element.appendChild(BlockHeader.create("BUTTON GROUPS", "Group a series of buttons together on a single line with the button group").element());
                initButtonsBasicGroup();
                element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.initButtonsBasicGroup()).element());

                initButtonsToolbar();
                element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.initButtonsToolbar()).element());

                initSizingGroup();
                element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.initSizingGroup()).element());

                initNestingGroup();
                element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.initNestingGroup()).element());

                initVerticalGroup();
                element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.initVerticalGroup()).element());

                initSplitButton();
                element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.initSplitButton()).element());

                initDropDownPosition();
                element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.initDropDownPosition()).element());

                uiHandlers.stopLoading();
            }
        });

        return element.element();
    }

    @SampleMethod
    private void initSimpleButtons() {
        element.appendChild(Card.create("BOOTSTRAP DEFAULT BUTTONS", "Use any of the available button classes to quickly create a styled button")
                .appendChild(LinkButton.create("DEFAULT")
                        .addCss(dui_w_28, dui_m_1))
                .appendChild(Button.create("PRIMARY")
                        .addCss(dui_primary, dui_w_28, dui_m_1))
                .appendChild(Button.create("SUCCESS")
                        .addCss(dui_success, dui_w_28, dui_m_1))
                .appendChild(Button.create("INFO")
                        .addCss(dui_info, dui_w_28, dui_m_1))
                .appendChild(Button.create("WARNING")
                        .addCss(dui_warning, dui_w_28, dui_m_1))
                .appendChild(Button.create("DANGER")
                        .addCss(dui_error, dui_w_28, dui_m_1))
                .element());
    }

    @SampleMethod
    private void initButtonSizes() {
        element.appendChild(Card.create("BUTTON SIZES", "You can resize the buttons")
                .appendChild(Row.create().addCss(dui_m_3)
                        .span12(
                                Row.create()
                                        .appendChild(Column.colspan(_3, _3, _6, _12)
                                                .appendChild(Row.create()
                                                        .appendChild(Button.create("LARGE")
                                                                .addCss(dui_large, dui_w_32, dui_m_1)
                                                        )
                                                )
                                                .appendChild(Row.create()
                                                        .appendChild(Button.create("DEFAULT")
                                                                .addCss(dui_w_32, dui_m_1)
                                                        )
                                                )
                                                .appendChild(Row.create()
                                                        .appendChild(Button.create("SMALL")
                                                                .addCss(dui_small, dui_w_32, dui_m_1)
                                                        )
                                                )
                                                .appendChild(Row.create()
                                                        .appendChild(Button.create("XSMALL")
                                                                .addCss(dui_xsmall, dui_w_32, dui_m_1)
                                                        )
                                                )
                                        )
                                        .appendChild(Column.colspan(_3, _3, _6, _12)
                                                .appendChild(Row.create()
                                                        .appendChild(Button.create("LARGE")
                                                                .addCss(dui_primary, dui_large, dui_w_32, dui_m_1)
                                                        )
                                                )
                                                .appendChild(Row.create()
                                                        .appendChild(Button.create("DEFAULT")
                                                                .addCss(dui_primary, dui_w_32, dui_m_1)
                                                        )
                                                )
                                                .appendChild(Row.create()
                                                        .appendChild(Button.create("SMALL")
                                                                .addCss(dui_primary, dui_small, dui_w_32, dui_m_1)
                                                        )
                                                )
                                                .appendChild(Row.create()
                                                        .appendChild(Button.create("XSMALL")
                                                                .addCss(dui_primary, dui_xsmall, dui_w_32, dui_m_1)
                                                        )
                                                )
                                        )
                                        .appendChild(Column.colspan(_3, _3, _6, _12)
                                                .appendChild(Row.create()
                                                        .appendChild(Button.create("LARGE")
                                                                .addCss(dui_warning, dui_large, dui_w_32, dui_m_1)
                                                        )
                                                )
                                                .appendChild(Row.create()
                                                        .appendChild(Button.create("DEFAULT")
                                                                .addCss(dui_warning, dui_w_32, dui_m_1)
                                                        )
                                                )
                                                .appendChild(Row.create()
                                                        .appendChild(Button.create("SMALL")
                                                                .addCss(dui_warning, dui_small, dui_w_32, dui_m_1)
                                                        )
                                                )
                                                .appendChild(Row.create()
                                                        .appendChild(Button.create("XSMALL")
                                                                .addCss(dui_warning, dui_xsmall, dui_w_32, dui_m_1)
                                                        )
                                                )
                                        )
                                        .appendChild(Column.colspan(_3, _3, _6, _12)
                                                .appendChild(Row.create()
                                                        .appendChild(Button.create("LARGE")
                                                                .addCss(dui_info, dui_large, dui_w_32, dui_m_1)
                                                        )
                                                )
                                                .appendChild(Row.create()
                                                        .appendChild(Button.create("DEFAULT")
                                                                .addCss(dui_info, dui_w_32, dui_m_1)
                                                        )
                                                )
                                                .appendChild(Row.create()
                                                        .appendChild(Button.create("SMALL")
                                                                .addCss(dui_info, dui_small, dui_w_32, dui_m_1)
                                                        )
                                                )
                                                .appendChild(Row.create()
                                                        .appendChild(Button.create("XSMALL")
                                                                .addCss(dui_info, dui_xsmall, dui_w_32, dui_m_1)
                                                        )
                                                )
                                        )
                        )
                ).element());
    }

    @SampleMethod
    private void initDisabledButtons() {
        element.appendChild(Card.create("DISABLED BUTTONS", "Make buttons look unclickable by fading them back with opacity")
                .appendChild(Button.create("DEFAULT")
                        .addCss(dui_m_1, dui_w_28)
                        .disable()
                )
                .appendChild(Button.create("PRIMARY")
                        .addCss(dui_primary, dui_m_1, dui_w_28)
                        .disable()
                )
                .appendChild(Button.create("INFO")
                        .addCss(dui_info, dui_m_1, dui_w_28)
                        .disable()
                )
                .appendChild(Button.create("WARNING")
                        .addCss(dui_warning, dui_m_1, dui_w_28)
                        .disable()
                )
                .appendChild(Button.create("DANGER")
                        .addCss(dui_error, dui_m_1, dui_w_28)
                        .disable()
                )
                .element());
    }

    @SampleMethod
    private void initButtons() {
        element.appendChild(Card.create("ICON BUTTONS", "Make icon buttons")
                .appendChild(Row.create()
                        .span12(heading("Normal Icon Button"))
                        .appendChild(Row.create()
                                .appendChild(Column.span1()
                                        .appendChild(Button.create(Icons.home())
                                                .addCss(dui_m_1)
                                        )
                                )
                                .appendChild(Column.span1()
                                        .appendChild(Button.create(Icons.home())
                                                .addCss(dui_primary, dui_m_1)
                                        )
                                )
                                .appendChild(Column.span1()
                                        .appendChild(Button.create(Icons.more())
                                                .addCss(dui_info, dui_m_1)
                                        )
                                )
                                .appendChild(Column.span1()
                                        .appendChild(Button.create(Icons.keyboard())
                                                .addCss(dui_success, dui_m_1)
                                        )
                                )
                                .appendChild(Column.span1()
                                        .appendChild(Button.create(Icons.air_conditioner())
                                                .addCss(dui_warning, dui_m_1)
                                        )
                                )
                                .appendChild(Column.span1()
                                        .appendChild(Button.create(Icons.alarm())
                                                .addCss(dui_error, dui_m_1)
                                        )
                                )
                        )
                )
                .appendChild(Row.create()
                        .span12(heading("Small Circle Icon Button"))
                        .appendChild(Row.create()
                                .appendChild(Column.span1()
                                        .appendChild(Button.create(Icons.circle())
                                                .circle()
                                                .addCss(dui_small, dui_m_1)
                                        )
                                )
                                .appendChild(Column.span1()
                                        .appendChild(Button.create(Icons.select_place())
                                                .circle()
                                                .addCss(dui_primary, dui_small, dui_m_1)
                                        )
                                )
                                .appendChild(Column.span1()
                                        .appendChild(Button.create(Icons.airplane_off())
                                                .circle()
                                                .addCss(dui_info, dui_small, dui_m_1)
                                        )
                                )
                                .appendChild(Column.span1()
                                        .appendChild(Button.create(Icons.album())
                                                .circle()
                                                .addCss(dui_success, dui_small, dui_m_1)
                                        )
                                )
                                .appendChild(Column.span1()
                                        .appendChild(Button.create(Icons.calendar_weekend())
                                                .circle()
                                                .addCss(dui_warning, dui_small, dui_m_1)
                                        )
                                )
                                .appendChild(Column.span1()
                                        .appendChild(Button.create(Icons.cast_variant())
                                                .circle()
                                                .addCss(dui_error, dui_small, dui_m_1)
                                        )
                                )
                        )
                )
                .appendChild(Row.create()
                        .span12(heading("Large Circle Icon Button"))
                        .appendChild(Row.create()
                                .appendChild(Column.span1()
                                        .appendChild(Button.create(Icons.adjust())
                                                .circle()
                                                .addCss(dui_large, dui_m_1)
                                        )
                                )
                                .appendChild(Column.span1()
                                        .appendChild(Button.create(Icons.microsoft_outlook())
                                                .circle()
                                                .addCss(dui_primary, dui_large, dui_m_1)
                                        )
                                )
                                .appendChild(Column.span1()
                                        .appendChild(Button.create(Icons.apps())
                                                .circle()
                                                .addCss(dui_info, dui_large, dui_m_1)
                                        )
                                )
                                .appendChild(Column.span1()
                                        .appendChild(Button.create(Icons.account_music())
                                                .circle()
                                                .addCss(dui_success, dui_large, dui_m_1)
                                        )
                                )
                                .appendChild(Column.span1()
                                        .appendChild(Button.create(Icons.assistant())
                                                .circle()
                                                .addCss(dui_warning, dui_large, dui_m_1)
                                        )
                                )
                                .appendChild(Column.span1()
                                        .appendChild(Button.create(Icons.compass())
                                                .circle()
                                                .addCss(dui_error, dui_large, dui_m_1)
                                        )
                                )
                        )
                )
                .element());
    }

    @SampleMethod
    private void initTextButtons() {
        element.appendChild(Card.create("ICON & TEXT BUTTONS", "Make icon & text buttons")
                .appendChild(Button.create(Icons.widgets(), "EXTENSION")
                        .addCss(dui_m_1)
                )
                .appendChild(Button.create(Icons.home(), "Home")
                        .addCss(dui_m_1)
                        .setReversed(true)
                )
                .appendChild(Button.create(Icons.home(), "Home")
                        .addCss(dui_primary, dui_m_1)
                )
                .appendChild(Button.create(Icons.lock(), "LOCK")
                        .addCss(dui_accent, dui_m_1)
                )
                .element());
    }

    @SampleMethod
    private void initButtonsBasicGroup() {
        element.appendChild(Card.create("BASIC EXAMPLE", "Create group of buttons")
                .appendChild(ButtonsGroup.create()
                        .addCss(dui_m_4)
                        .appendChild(Button.create("LEFT"))
                        .appendChild(Button.create("MIDDLE"))
                        .appendChild(Button.create("RIGHT"))
                )
                .appendChild(ButtonsGroup.create().addCss(dui_primary)
                        .addCss(dui_m_4)
                        .appendChild(Button.create("LEFT"))
                        .appendChild(Button.create("MIDDLE"))
                        .appendChild(Button.create("RIGHT"))
                )
                .appendChild(ButtonsGroup.create().addCss(dui_success)
                        .addCss(dui_m_4)
                        .appendChild(Button.create("LEFT"))
                        .appendChild(Button.create("MIDDLE"))
                        .appendChild(Button.create("RIGHT"))
                )
                .appendChild(ButtonsGroup.create().addCss(dui_info)
                        .addCss(dui_m_4)
                        .appendChild(Button.create("LEFT"))
                        .appendChild(Button.create("MIDDLE"))
                        .appendChild(Button.create("RIGHT"))
                )
                .appendChild(ButtonsGroup.create().addCss(dui_warning)
                        .addCss(dui_m_4)
                        .appendChild(Button.create("LEFT"))
                        .appendChild(Button.create("MIDDLE"))
                        .appendChild(Button.create("RIGHT"))
                )
                .appendChild(ButtonsGroup.create().addCss(dui_error)
                        .addCss(dui_m_4)
                        .appendChild(Button.create("LEFT"))
                        .appendChild(Button.create("MIDDLE"))
                        .appendChild(Button.create("RIGHT"))
                )
                .appendChild(ButtonsGroup.create().addCss(dui_accent)
                        .addCss(dui_m_4)
                        .appendChild(Button.create("LEFT"))
                        .appendChild(Button.create("MIDDLE"))
                        .appendChild(Button.create("RIGHT"))
                )
                .element());
    }

    @SampleMethod
    private void initButtonsToolbar() {
        element.appendChild(Card.create("BUTTON TOOLBAR", "Create buttons toolbar")
                .appendChild(Row.create()
                        .appendChild(Column.span3()
                                .appendChild(ButtonsToolbar.create()
                                        .appendChild(ButtonsGroup.create()
                                                .addCss(dui_m_1)
                                                .appendChild(Button.create("1"))
                                                .appendChild(Button.create("2"))
                                                .appendChild(Button.create("3"))
                                        )
                                        .appendChild(ButtonsGroup.create()
                                                .addCss(dui_m_1)
                                                .appendChild(Button.create("4"))
                                                .appendChild(Button.create("5"))
                                                .appendChild(Button.create("6"))
                                        )
                                        .appendChild(ButtonsGroup.create()
                                                .addCss(dui_m_1)
                                                .appendChild(Button.create("7"))
                                        )
                                )
                        )
                        .appendChild(Column.span3()
                                .appendChild(ButtonsToolbar.create()
                                        .appendChild(ButtonsGroup.create().addCss(dui_primary, dui_m_1)
                                                .appendChild(Button.create("1"))
                                                .appendChild(Button.create("2"))
                                                .appendChild(Button.create("3"))
                                        )
                                        .appendChild(ButtonsGroup.create().addCss(dui_primary, dui_m_1)
                                                .appendChild(Button.create("4"))
                                                .appendChild(Button.create("5"))
                                                .appendChild(Button.create("6"))
                                        )
                                        .appendChild(ButtonsGroup.create().addCss(dui_primary, dui_m_1)
                                                .appendChild(Button.create("7"))
                                        )
                                )
                        )
                        .appendChild(Column.span3()
                                .appendChild(ButtonsToolbar.create()
                                        .appendChild(ButtonsGroup.create().addCss(dui_info, dui_m_1)
                                                .appendChild(Button.create("1"))
                                                .appendChild(Button.create("2"))
                                                .appendChild(Button.create("3"))
                                        )
                                        .appendChild(ButtonsGroup.create().addCss(dui_info, dui_m_1)
                                                .appendChild(Button.create("4"))
                                                .appendChild(Button.create("5"))
                                                .appendChild(Button.create("6"))
                                        )
                                        .appendChild(ButtonsGroup.create().addCss(dui_info, dui_m_1)
                                                .appendChild(Button.create("7"))
                                        )
                                )
                        )
                        .appendChild(Column.span3()
                                .appendChild(ButtonsToolbar.create()
                                        .appendChild(ButtonsGroup.create()
                                                .appendChild(Button.create("1").addCss(dui_purple, dui_fg_white))
                                                .appendChild(Button.create("2").addCss(dui_purple, dui_fg_white))
                                                .appendChild(Button.create("3").addCss(dui_purple, dui_fg_white))
                                        )
                                        .appendChild(ButtonsGroup.create()
                                                .appendChild(Button.create("4").addCss(dui_purple, dui_fg_white))
                                                .appendChild(Button.create("5").addCss(dui_purple, dui_fg_white))
                                                .appendChild(Button.create("6").addCss(dui_purple, dui_fg_white))
                                        )
                                        .appendChild(ButtonsGroup.create()
                                                .appendChild(Button.create("7").addCss(dui_purple, dui_fg_white))
                                        )
                                )
                        )
                )
                .element());
    }

    @SampleMethod
    private void initSizingGroup() {

        element.appendChild(Card.create("SIZING", "Instead of applying button sizing classes to every button in a group, size can be applied to the group and will be applied to every button.")
                .appendChild(Row.create()
                        .appendChild(Column.span3().addCss(dui_text_center)
                                .appendChild(heading("Large Button Group"))
                                .appendChild(ButtonsGroup.create()
                                        .addCss(dui_large, dui_m_4)
                                        .appendChild(Button.create("LEFT"))
                                        .appendChild(Button.create("MIDDLE"))
                                        .appendChild(Button.create("RIGHT"))
                                )
                        )
                        .appendChild(Column.span3().addCss(dui_text_center)
                                .appendChild(heading("Large Button Group"))
                                .appendChild(ButtonsGroup.create()
                                        .addCss(dui_m_4)
                                        .appendChild(Button.create("LEFT"))
                                        .appendChild(Button.create("MIDDLE"))
                                        .appendChild(Button.create("RIGHT"))
                                )
                        )
                        .appendChild(Column.span3().addCss(dui_text_center)
                                .appendChild(heading("Large Button Group"))
                                .appendChild(ButtonsGroup.create()
                                        .addCss(dui_small, dui_m_4)
                                        .appendChild(Button.create("LEFT"))
                                        .appendChild(Button.create("MIDDLE"))
                                        .appendChild(Button.create("RIGHT"))
                                )
                        )
                        .appendChild(Column.span3().addCss(dui_text_center)
                                .appendChild(heading("Large Button Group"))
                                .appendChild(ButtonsGroup.create()
                                        .addCss(dui_xsmall, dui_m_4)
                                        .appendChild(Button.create("LEFT"))
                                        .appendChild(Button.create("MIDDLE"))
                                        .appendChild(Button.create("RIGHT"))
                                )
                        )
                )
                .element());
    }

    @SampleMethod
    private void initNestingGroup() {
        element.appendChild(Card.create("SIZING", "Dropdown can be used inside a group of buttons.")
                .appendChild(ButtonsGroup.create()
                        .appendChild(Button.create("1"))
                        .appendChild(Button.create("2"))
                        .appendChild(DropdownButton.create(
                                        Button.create("DROPDOWN"),
                                        Menu.create()
                                                .appendChild(MenuItem.create("Action"))
                                                .appendChild(MenuItem.create("Another action"))
                                                .setDropDirection(BOTTOM_RIGHT)
                                )
                        ).addCss(dui_m_1)
                )
                .appendChild(ButtonsGroup.create()
                        .appendChild(Button.create("1"))
                        .appendChild(Button.create("2"))
                        .appendChild(DropdownButton.create(
                                        Button.create("DROPDOWN"),
                                        Menu.create()
                                                .appendChild(MenuItem.create("Action"))
                                                .appendChild(MenuItem.create("Another action"))
                                                .setDropDirection(BOTTOM_RIGHT)
                                )
                        ).addCss(dui_primary, dui_m_1)
                )
                .appendChild(ButtonsGroup.create()
                        .appendChild(Button.create("1"))
                        .appendChild(Button.create("2"))
                        .appendChild(DropdownButton.create(
                                        Button.create("DROPDOWN"),
                                        Menu.create()
                                                .appendChild(MenuItem.create("Action"))
                                                .appendChild(MenuItem.create("Another action"))
                                                .setDropDirection(BOTTOM_RIGHT)
                                )
                        ).addCss(dui_accent, dui_m_1)
                )
                .appendChild(ButtonsGroup.create()
                        .appendChild(Button.create("1"))
                        .appendChild(Button.create("2"))
                        .appendChild(DropdownButton.create(
                                        Button.create("DROPDOWN"),
                                        Menu.create()
                                                .appendChild(MenuItem.create("Action"))
                                                .appendChild(MenuItem.create("Another action"))
                                                .setDropDirection(BOTTOM_RIGHT)
                                )
                        ).addCss(dui_warning, dui_m_1)
                )
                .element());


    }

    @SampleMethod
    private void initVerticalGroup() {
        element.appendChild(Card.create("VERTICAL VARIATION", "Make a set of buttons appear vertically stacked rather than horizontally.")
                .appendChild(ButtonsGroup.create()
                        .addCss(dui_vertical, dui_m_1)
                        .appendChild(Button.create("Button"))
                        .appendChild(Button.create("Button").addCss(dui_primary))
                        .appendChild(DropdownButton.create(
                                        Button.create("DROPDOWN"),
                                        Menu.create()
                                                .appendChild(MenuItem.create("Action"))
                                                .appendChild(MenuItem.create("Another action"))
                                                .setDropDirection(BOTTOM_RIGHT)
                                )
                        )
                        .appendChild(Button.create("Button").addCss(dui_error))
                )
                .element()
        );


    }

    @SampleMethod
    private void initSplitButton() {
        element.appendChild(Card.create("SPLIT BUTTON DROPDOWNS", "Similarly, create split button dropdowns with the same markup changes, only with a separate button.")
                .appendChild(ButtonsGroup.create(
                                Button.create("DEFAULT").addCss(dui_w_28),
                                DropdownButton.create(
                                        Button.create(Icons.chevron_down()),
                                        Menu.create()
                                                .appendChild(MenuItem.create("Action"))
                                                .appendChild(MenuItem.create("Another action"))
                                                .setDropDirection(BOTTOM_RIGHT)
                                )
                        ).addCss(dui_m_1)
                )
                .appendChild(ButtonsGroup.create(
                                Button.create(Icons.home()),
                                DropdownButton.create(
                                        Button.create(Icons.chevron_down()),
                                        Menu.create()
                                                .appendChild(MenuItem.create("Action"))
                                                .appendChild(MenuItem.create("Another action"))
                                                .setDropDirection(BOTTOM_RIGHT)
                                )
                        ).addCss(dui_m_1)
                )
                .appendChild(ButtonsGroup.create(
                                Button.create("DEFAULT"),
                                DropdownButton.create(
                                        Button.create(Icons.chevron_down()),
                                        Menu.create()
                                                .appendChild(MenuItem.create("Action"))
                                                .appendChild(MenuItem.create("Another action"))
                                                .setDropDirection(BOTTOM_RIGHT)
                                )
                        ).addCss(dui_m_1, dui_primary)
                )
                .appendChild(ButtonsGroup.create(
                                Button.create("DEFAULT"),
                                DropdownButton.create(
                                        Button.create(Icons.chevron_down()),
                                        Menu.create()
                                                .appendChild(MenuItem.create("Action"))
                                                .appendChild(MenuItem.create("Another action"))
                                                .setDropDirection(BOTTOM_RIGHT)
                                )
                        ).addCss(dui_m_1, dui_accent)
                )
                .element());


    }

    @SampleMethod
    private void initDropDownPosition() {
        element
                .appendChild(Card.create("DROPUP VARIATION", "Trigger dropdown menus above elements.")
                .appendChild(DropdownButton.create(
                                LinkButton.create("DEFAULT").addCss(dui_m_1),
                                Menu.create()
                                        .appendChild(MenuItem.create("Action"))
                                        .appendChild(MenuItem.create("Another action"))
                                        .setDropDirection(TOP_MIDDLE)
                        )
                )
                .appendChild(DropdownButton.create(
                                LinkButton.create("DEFAULT").addCss(dui_m_1),
                                Menu.create()
                                        .appendChild(MenuItem.create("Action"))
                                        .appendChild(MenuItem.create("Another action"))
                                        .setDropDirection(BOTTOM_MIDDLE)
                        )
                )
                .appendChild(DropdownButton.create(
                                LinkButton.create("DEFAULT").addCss(dui_m_1),
                                Menu.create()
                                        .appendChild(MenuItem.create("Action"))
                                        .appendChild(MenuItem.create("Another action"))
                                        .setDropDirection(TOP_LEFT)
                        )
                )
                .appendChild(DropdownButton.create(
                                LinkButton.create("DEFAULT").addCss(dui_m_1),
                                Menu.create()
                                        .appendChild(MenuItem.create("Action"))
                                        .appendChild(MenuItem.create("Another action"))
                                        .setDropDirection(TOP_RIGHT)
                        )
                )
                .appendChild(DropdownButton.create(
                                LinkButton.create("DEFAULT").addCss(dui_m_1),
                                Menu.create()
                                        .appendChild(MenuItem.create("Action"))
                                        .appendChild(MenuItem.create("Another action"))
                                        .setDropDirection(BOTTOM_LEFT)
                        )
                )
                .appendChild(DropdownButton.create(
                                LinkButton.create("DEFAULT").addCss(dui_m_1),
                                Menu.create()
                                        .appendChild(MenuItem.create("Action"))
                                        .appendChild(MenuItem.create("Another action"))
                                        .setDropDirection(BOTTOM_RIGHT)
                        )
                )
                .element());
    }

    private HeadingElement heading(String content) {
        return h(2)
                .textContent(content)
                .addCss(dui_m_t_6, dui_font_size_4);
    }


}