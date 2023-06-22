package org.dominokit.domino.modals.client.views.ui;

import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.SampleClass;
import org.dominokit.domino.SampleMethod;
import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.domino.componentcase.client.ui.views.BaseDemoView;
import org.dominokit.domino.componentcase.client.ui.views.CodeCard;
import org.dominokit.domino.componentcase.client.ui.views.LinkToSourceCode;
import org.dominokit.domino.modals.client.presenters.ModalsProxy;
import org.dominokit.domino.modals.client.views.ModalsView;
import org.dominokit.domino.ui.badges.Badge;
import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.dialogs.Dialog;
import org.dominokit.domino.ui.dialogs.DialogSize;
import org.dominokit.domino.ui.dialogs.DialogType;
import org.dominokit.domino.ui.dialogs.Window;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.forms.suggest.Select;
import org.dominokit.domino.ui.forms.suggest.SelectOption;
import org.dominokit.domino.ui.grid.Column;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.icons.lib.Icons;
import org.dominokit.domino.ui.layout.NavBar;
import org.dominokit.domino.ui.menu.Menu;
import org.dominokit.domino.ui.menu.MenuItem;
import org.dominokit.domino.ui.style.SwapCssClass;
import org.dominokit.domino.ui.typography.BlockHeader;
import org.dominokit.domino.ui.utils.FooterContent;
import org.dominokit.domino.ui.utils.PostfixAddOn;
import org.dominokit.domino.ui.utils.PrefixAddOn;

@UiView(presentable = ModalsProxy.class)
@SampleClass
public class ModalsViewImpl extends BaseDemoView<HTMLDivElement> implements ModalsView {

    private static final String SAMPLE_CONTENT = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin sodales orci ante, sed ornare eros vestibulum ut. Ut accumsan vitae eros sit amet tristique. Nullam scelerisque nunc enim, non dignissim nibh faucibus ullamcorper. Fusce pulvinar libero vel ligula iaculis ullamcorper. Integer dapibus, mi ac tempor varius, purus nibh mattis erat, vitae porta nunc nisi non tellus. Vivamus mollis ante non massa egestas fringilla. Vestibulum egestas consectetur nunc at ultricies. Morbi quis consectetur nunc.";
    private DivElement element;

    @Override
    protected HTMLDivElement init() {
        element = div();

        element.appendChild(LinkToSourceCode.createLink("modals", this.getClass()));
        element.appendChild(BlockHeader.create("MODALS"));

        initModalsSize();
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.initModalsSize()));

        initSheets();
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.initSheets()));

        initModalColor();
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.initModalColor()));

        initWindow();
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.initWindow()));

        return element.element();
    }

    @SampleMethod
    private void initModalsSize() {

        // ------------ Default size -------------
        Dialog defaultSizeDialog = Dialog.create()
                .withHeader((dialog, header) ->
                        header.appendChild(NavBar.create("DEFAULT SIZE")
                                .addCss(dui_h_8, dui_p_0)
                                .appendChild(PrefixAddOn.of(Icons.dots_vertical()
                                                .clickable()
                                                .setDropMenu(Menu.<String>create()
                                                        .appendChild(MenuItem.create("ACTION 1"))
                                                        .appendChild(MenuItem.create("ACTION 2"))
                                                        .appendChild(MenuItem.create("ACTION 3"))
                                                )
                                        )
                                )
                                .appendChild(PostfixAddOn.of(Badge.create("15+").addCss(dui_accent, dui_rounded_full)))
                                .appendChild(PostfixAddOn.of(Icons.close()
                                                .addCss(dui_fg_red)
                                                .clickable()
                                                .addClickListener(evt -> dialog.close())
                                        )
                                )
                        )
                )
                .appendChild(text(SAMPLE_CONTENT))
                .appendChild(Select.<Integer>create("Sample")
                        .appendItems(item -> SelectOption.create(String.valueOf(item), item, String.valueOf(item)), 1, 2, 3)
                )
                .withContentFooter((dialog, footer) -> {
                    footer.addCss(dui_flex, dui_gap_1, dui_justify_end);
                    dialog
                            .appendChild(FooterContent.of(Button.create("CLOSE")
                                    .addClickListener(evt -> dialog.close()))
                            )
                            .appendChild(FooterContent.of(Button.create(Icons.cursor_default_click(), "CLICK ME")));
                });

        Dialog largeSizeDialog = Dialog.create()
                .setStretchWidth(DialogSize.LARGE)
                .setStretchHeight(DialogSize.LARGE)
                .withHeader((dialog, header) ->
                        header.appendChild(NavBar.create("LARGE SIZE")
                                .addCss(dui_h_8, dui_p_0)
                                .appendChild(PrefixAddOn.of(Icons.dots_vertical()
                                                .clickable()
                                                .setDropMenu(Menu.<String>create()
                                                        .appendChild(MenuItem.create("ACTION 1"))
                                                        .appendChild(MenuItem.create("ACTION 2"))
                                                        .appendChild(MenuItem.create("ACTION 3"))
                                                )
                                        )
                                )
                                .appendChild(PostfixAddOn.of(Badge.create("15+").addCss(dui_accent, dui_rounded_full)))
                                .appendChild(PostfixAddOn.of(Icons.close()
                                                .addCss(dui_fg_red)
                                                .clickable()
                                                .addClickListener(evt -> dialog.close())
                                        )
                                )
                        )
                )
                .appendChild(text(SAMPLE_CONTENT))
                .withContentFooter((dialog, footer) -> {
                    footer.addCss(dui_flex, dui_gap_1, dui_justify_end);
                    dialog
                            .appendChild(FooterContent.of(Button.create("CLOSE")
                                    .addClickListener(evt -> dialog.close()))
                            )
                            .appendChild(FooterContent.of(Button.create(Icons.cursor_default_click(), "CLICK ME")));
                });

        Dialog smallSizeDialog = Dialog.create()
                .setStretchWidth(DialogSize.SMALL)
                .setStretchHeight(DialogSize.SMALL)
                .withHeader((dialog, header) ->
                        header.appendChild(NavBar.create("SMALL SIZE")
                                .addCss(dui_h_8, dui_p_0)
                                .appendChild(PrefixAddOn.of(Icons.dots_vertical()
                                                .clickable()
                                                .setDropMenu(Menu.<String>create()
                                                        .appendChild(MenuItem.create("ACTION 1"))
                                                        .appendChild(MenuItem.create("ACTION 2"))
                                                        .appendChild(MenuItem.create("ACTION 3"))
                                                )
                                        )
                                )
                                .appendChild(PostfixAddOn.of(Badge.create("15+").addCss(dui_accent, dui_rounded_full)))
                                .appendChild(PostfixAddOn.of(Icons.close()
                                                .addCss(dui_fg_red)
                                                .clickable()
                                                .addClickListener(evt -> dialog.close())
                                        )
                                )
                        )
                )
                .appendChild(text(SAMPLE_CONTENT))
                .withContentFooter((dialog, footer) -> {
                    footer.addCss(dui_flex, dui_gap_1, dui_justify_end);
                    dialog
                            .appendChild(FooterContent.of(Button.create("CLOSE")
                                    .addClickListener(evt -> dialog.close()))
                            )
                            .appendChild(FooterContent.of(Button.create(Icons.cursor_default_click(), "CLICK ME")));
                });

        element.appendChild(Card.create("MODAL SIZE EXAMPLE", "Modals are streamlined, but flexible, dialog prompts with the minimum required functionality and smart defaults.")
                .appendChild(Row.create()
                        .span4(Button.create("MODAL - DEFAULT SIZE")
                                .addClickListener(evt -> defaultSizeDialog.open())
                        )
                        .span4(Button.create("MODAL - LARGE SIZE")
                                .addClickListener(evt -> largeSizeDialog.open())
                        )
                        .span4(Button.create("MODAL - SMALL SIZE")
                                .addClickListener(evt -> smallSizeDialog.open())
                        )
                )
        );
    }

    @SampleMethod
    private void initSheets() {

        Dialog leftSheetDialog = Dialog.create()
                .setType(DialogType.LEFT_SHEET)
                .withHeader((dialog, header) ->
                        header.appendChild(NavBar.create("SHEET DIALOG")
                                .addCss(dui_h_8, dui_p_0)
                                .appendChild(PrefixAddOn.of(Icons.dots_vertical()
                                                .clickable()
                                                .setDropMenu(Menu.<String>create()
                                                        .appendChild(MenuItem.create("ACTION 1"))
                                                        .appendChild(MenuItem.create("ACTION 2"))
                                                        .appendChild(MenuItem.create("ACTION 3"))
                                                )
                                        )
                                )
                                .appendChild(PostfixAddOn.of(Badge.create("15+").addCss(dui_accent, dui_rounded_full)))
                                .appendChild(PostfixAddOn.of(Icons.close()
                                                .addCss(dui_fg_red)
                                                .clickable()
                                                .addClickListener(evt -> dialog.close())
                                        )
                                )
                        )
                )
                .apply(dialog -> {
                    dialog
                            .appendChild(div().addCss(dui_flex, dui_gap_1, dui_flex_wrap)
                                    .appendChild(Button.create("VERY LARGE").addClickListener(evt -> dialog.setStretchWidth(DialogSize.VERY_LARGE)))
                                    .appendChild(Button.create("LARGE").addClickListener(evt -> dialog.setStretchWidth(DialogSize.LARGE)))
                                    .appendChild(Button.create("MEDIUM").addClickListener(evt -> dialog.setStretchWidth(DialogSize.MEDIUM)))
                                    .appendChild(Button.create("SMALL").addClickListener(evt -> dialog.setStretchWidth(DialogSize.SMALL)))
                                    .appendChild(Button.create("VERY SMALL").addClickListener(evt -> dialog.setStretchWidth(DialogSize.VERY_SMALL)))
                            );
                })
                .appendChild(text(SAMPLE_CONTENT))
                .withContentFooter((dialog, footer) -> {
                    footer.addCss(dui_flex, dui_gap_1, dui_justify_end);
                    dialog
                            .appendChild(FooterContent.of(Button.create("CLOSE")
                                    .addClickListener(evt -> dialog.close()))
                            )
                            .appendChild(FooterContent.of(Button.create(Icons.cursor_default_click(), "CLICK ME")));
                });

        Dialog rightSheetDialog = Dialog.create()
                .setType(DialogType.RIGHT_SHEET)
                .withHeader((dialog, header) ->
                        header.appendChild(NavBar.create("SHEET DIALOG")
                                .addCss(dui_h_8, dui_p_0)
                                .appendChild(PrefixAddOn.of(Icons.dots_vertical()
                                                .clickable()
                                                .setDropMenu(Menu.<String>create()
                                                        .appendChild(MenuItem.create("ACTION 1"))
                                                        .appendChild(MenuItem.create("ACTION 2"))
                                                        .appendChild(MenuItem.create("ACTION 3"))
                                                )
                                        )
                                )
                                .appendChild(PostfixAddOn.of(Badge.create("15+").addCss(dui_accent, dui_rounded_full)))
                                .appendChild(PostfixAddOn.of(Icons.close()
                                                .addCss(dui_fg_red)
                                                .clickable()
                                                .addClickListener(evt -> dialog.close())
                                        )
                                )
                        )
                )
                .apply(dialog -> {
                    dialog
                            .appendChild(div().addCss(dui_flex, dui_gap_1, dui_flex_wrap)
                                    .appendChild(Button.create("VERY LARGE").addClickListener(evt -> dialog.setStretchWidth(DialogSize.VERY_LARGE)))
                                    .appendChild(Button.create("LARGE").addClickListener(evt -> dialog.setStretchWidth(DialogSize.LARGE)))
                                    .appendChild(Button.create("MEDIUM").addClickListener(evt -> dialog.setStretchWidth(DialogSize.MEDIUM)))
                                    .appendChild(Button.create("SMALL").addClickListener(evt -> dialog.setStretchWidth(DialogSize.SMALL)))
                                    .appendChild(Button.create("VERY SMALL").addClickListener(evt -> dialog.setStretchWidth(DialogSize.VERY_SMALL)))
                            );
                })
                .appendChild(text(SAMPLE_CONTENT))
                .withContentFooter((dialog, footer) -> {
                    footer.addCss(dui_flex, dui_gap_1, dui_justify_end);
                    dialog
                            .appendChild(FooterContent.of(Button.create("CLOSE")
                                    .addClickListener(evt -> dialog.close()))
                            )
                            .appendChild(FooterContent.of(Button.create(Icons.cursor_default_click(), "CLICK ME")));
                });

        Dialog topSheetDialog = Dialog.create()
                .setType(DialogType.TOP_SHEET)
                .withHeader((dialog, header) ->
                        header.appendChild(NavBar.create("SHEET DIALOG")
                                .addCss(dui_h_8, dui_p_0)
                                .appendChild(PrefixAddOn.of(Icons.dots_vertical()
                                                .clickable()
                                                .setDropMenu(Menu.<String>create()
                                                        .appendChild(MenuItem.create("ACTION 1"))
                                                        .appendChild(MenuItem.create("ACTION 2"))
                                                        .appendChild(MenuItem.create("ACTION 3"))
                                                )
                                        )
                                )
                                .appendChild(PostfixAddOn.of(Badge.create("15+").addCss(dui_accent, dui_rounded_full)))
                                .appendChild(PostfixAddOn.of(Icons.close()
                                                .addCss(dui_fg_red)
                                                .clickable()
                                                .addClickListener(evt -> dialog.close())
                                        )
                                )
                        )
                )
                .apply(dialog -> {
                    dialog
                            .appendChild(div().addCss(dui_flex, dui_gap_1, dui_flex_wrap)
                                    .appendChild(Button.create("VERY LARGE").addClickListener(evt -> dialog.setStretchHeight(DialogSize.VERY_LARGE)))
                                    .appendChild(Button.create("LARGE").addClickListener(evt -> dialog.setStretchHeight(DialogSize.LARGE)))
                                    .appendChild(Button.create("MEDIUM").addClickListener(evt -> dialog.setStretchHeight(DialogSize.MEDIUM)))
                                    .appendChild(Button.create("SMALL").addClickListener(evt -> dialog.setStretchHeight(DialogSize.SMALL)))
                                    .appendChild(Button.create("VERY SMALL").addClickListener(evt -> dialog.setStretchHeight(DialogSize.VERY_SMALL)))
                            );
                })
                .appendChild(text(SAMPLE_CONTENT))
                .withContentFooter((dialog, footer) -> {
                    footer.addCss(dui_flex, dui_gap_1, dui_justify_end);
                    dialog
                            .appendChild(FooterContent.of(Button.create("CLOSE")
                                    .addClickListener(evt -> dialog.close()))
                            )
                            .appendChild(FooterContent.of(Button.create(Icons.cursor_default_click(), "CLICK ME")));
                });

        Dialog bottomSheetDialog = Dialog.create()
                .setType(DialogType.BOTTOM_SHEET)
                .withHeader((dialog, header) ->
                        header.appendChild(NavBar.create("SHEET DIALOG")
                                .addCss(dui_h_8, dui_p_0)
                                .appendChild(PrefixAddOn.of(Icons.dots_vertical()
                                                .clickable()
                                                .setDropMenu(Menu.<String>create()
                                                        .appendChild(MenuItem.create("ACTION 1"))
                                                        .appendChild(MenuItem.create("ACTION 2"))
                                                        .appendChild(MenuItem.create("ACTION 3"))
                                                )
                                        )
                                )
                                .appendChild(PostfixAddOn.of(Badge.create("15+").addCss(dui_accent, dui_rounded_full)))
                                .appendChild(PostfixAddOn.of(Icons.close()
                                                .addCss(dui_fg_red)
                                                .clickable()
                                                .addClickListener(evt -> dialog.close())
                                        )
                                )
                        )
                )
                .apply(dialog -> {
                    dialog
                            .appendChild(div().addCss(dui_flex, dui_gap_1, dui_flex_wrap)
                                    .appendChild(Button.create("VERY LARGE").addClickListener(evt -> dialog.setStretchHeight(DialogSize.VERY_LARGE)))
                                    .appendChild(Button.create("LARGE").addClickListener(evt -> dialog.setStretchHeight(DialogSize.LARGE)))
                                    .appendChild(Button.create("MEDIUM").addClickListener(evt -> dialog.setStretchHeight(DialogSize.MEDIUM)))
                                    .appendChild(Button.create("SMALL").addClickListener(evt -> dialog.setStretchHeight(DialogSize.SMALL)))
                                    .appendChild(Button.create("VERY SMALL").addClickListener(evt -> dialog.setStretchHeight(DialogSize.VERY_SMALL)))
                            );
                })
                .appendChild(text(SAMPLE_CONTENT))
                .withContentFooter((dialog, footer) -> {
                    footer.addCss(dui_flex, dui_gap_1, dui_justify_end);
                    dialog
                            .appendChild(FooterContent.of(Button.create("CLOSE")
                                    .addClickListener(evt -> dialog.close()))
                            )
                            .appendChild(FooterContent.of(Button.create(Icons.cursor_default_click(), "CLICK ME")));
                });

        element.appendChild(Card.create("SHEETS MODALS", "Sheets are modal that stick to screen edges.")
                .appendChild(Row.create()
                        .span3(Button.create("LEFT SHEET")
                                .addClickListener(evt -> leftSheetDialog.open())
                        )
                        .span3(Button.create("TOP SHEET")
                                .addClickListener(evt -> topSheetDialog.open())
                        )
                        .span3(Button.create("BOTTOM SHEET")
                                .addClickListener(evt -> bottomSheetDialog.open())
                        )
                        .span3(Button.create("RIGHT SHEET")
                                .addClickListener(evt -> rightSheetDialog.open())
                        )
                )
        );


    }

    @SampleMethod
    private void initModalColor() {

        Dialog coloredDialog = Dialog.create()
                .setModal(true)
                .setAutoClose(false)
                .withHeader((dialog, header) ->
                        header.appendChild(NavBar.create("COLORED DIALOG")
                                .addCss(dui_h_8, dui_p_0)
                                .appendChild(PrefixAddOn.of(Icons.dots_vertical()
                                                .clickable()
                                                .setDropMenu(Menu.<String>create()
                                                        .appendChild(MenuItem.create("ACTION 1"))
                                                        .appendChild(MenuItem.create("ACTION 2"))
                                                        .appendChild(MenuItem.create("ACTION 3"))
                                                )
                                        )
                                )
                                .appendChild(PostfixAddOn.of(Badge.create("15+").addCss(dui_bg_d_2, dui_fg, dui_rounded_full)))
                                .appendChild(PostfixAddOn.of(Icons.close()
                                                .addCss(dui_fg)
                                                .clickable()
                                                .addClickListener(evt -> dialog.close())
                                        )
                                )
                        )
                )
                .appendChild(text(SAMPLE_CONTENT))
                .withContentFooter((dialog, footer) -> {
                    footer.addCss(dui_flex, dui_gap_1, dui_justify_end, dui_bg_d_2);
                    dialog
                            .appendChild(FooterContent.of(Button.create("CLOSE")
                                    .addClickListener(evt -> dialog.close()))
                            )
                            .appendChild(FooterContent.of(Button.create(Icons.cursor_default_click(), "CLICK ME")));
                });

        SwapCssClass dialogColor = SwapCssClass.of();

        element.appendChild(Card.create("WITH MATERIAL DESIGN COLORS", "You can use material design colors.")
                .appendChild(div()
                        .addCss(dui_flex, dui_justify_between, dui_flex_wrap)
                        .appendChild(Button.create("RED")
                                .addCss(dialogColor.replaceWith(dui_red), dui_w_32, dui_m_b_4)
                                .addClickListener(evt -> coloredDialog
                                        .addCss(dialogColor.replaceWith(dui_red))
                                        .open()
                                )
                        )
                        .appendChild(Button.create("PINK")
                                .addCss(dialogColor.replaceWith(dui_pink), dui_w_32, dui_m_b_4)
                                .addClickListener(evt -> coloredDialog
                                        .addCss(dialogColor.replaceWith(dui_pink))
                                        .open()
                                )
                        )
                        .appendChild(Button.create("PURPLE")
                                .addCss(dialogColor.replaceWith(dui_purple), dui_w_32, dui_m_b_4)
                                .addClickListener(evt -> coloredDialog
                                        .addCss(dialogColor.replaceWith(dui_purple))
                                        .open()
                                )
                        )
                        .appendChild(Button.create("DEEP PURPLE")
                                .addCss(dialogColor.replaceWith(dui_deep_purple), dui_w_32, dui_m_b_4)
                                .addClickListener(evt -> coloredDialog
                                        .addCss(dialogColor.replaceWith(dui_deep_purple))
                                        .open()
                                )
                        )
                        .appendChild(Button.create("INDIGO")
                                .addCss(dialogColor.replaceWith(dui_indigo), dui_w_32, dui_m_b_4)
                                .addClickListener(evt -> coloredDialog
                                        .addCss(dialogColor.replaceWith(dui_indigo))
                                        .open()
                                )
                        )
                        .appendChild(Button.create("BLUE")
                                .addCss(dialogColor.replaceWith(dui_blue), dui_w_32, dui_m_b_4)
                                .addClickListener(evt -> coloredDialog
                                        .addCss(dialogColor.replaceWith(dui_blue))
                                        .open()
                                )
                        )
                        .appendChild(Button.create("ORANGE")
                                .addCss(dialogColor.replaceWith(dui_orange), dui_w_32, dui_m_b_4)
                                .addClickListener(evt -> coloredDialog
                                        .addCss(dialogColor.replaceWith(dui_orange))
                                        .open()
                                )
                        )
                        .appendChild(Button.create("GREEN")
                                .addCss(dialogColor.replaceWith(dui_green), dui_w_32, dui_m_b_4)
                                .addClickListener(evt -> coloredDialog
                                        .addCss(dialogColor.replaceWith(dui_green))
                                        .open()
                                )
                        )
                        .appendChild(Button.create("TEAL")
                                .addCss(dialogColor.replaceWith(dui_teal), dui_w_32, dui_m_b_4)
                                .addClickListener(evt -> coloredDialog
                                        .addCss(dialogColor.replaceWith(dui_teal))
                                        .open()
                                )
                        )
                        .appendChild(Button.create("ACCENT")
                                .addCss(dialogColor.replaceWith(dui_accent), dui_w_32, dui_m_b_4)
                                .addClickListener(evt -> coloredDialog
                                        .addCss(dialogColor.replaceWith(dui_accent))
                                        .open()
                                )
                        )
                )
        );
    }

    @SampleMethod
    private void initWindow() {
        element.appendChild(Card.create("Window", "Use window to create modals that can be maximized and move.")
                .appendChild(Row.create()
                        .appendChild(Column.span3()
                                .appendChild(Button.create("SIMPLE WINDOW")
                                        .addClickListener(evt -> {
                                            new Window("Simple window")
                                                    .setFixed()
                                                    .setStretchWidth(DialogSize.SMALL)
                                                    .setStretchHeight(DialogSize.SMALL)
                                                    .withHeader((parent, header) -> header.addCss(dui_pink))
                                                    .appendChild(text(SAMPLE_CONTENT))
                                                    .open();
                                        })
                                )
                        )
                        .appendChild(Column.span3()
                                .appendChild(Button.create("MODAL WINDOW")
                                        .addClickListener(evt -> {
                                            new Window("Modal window")
                                                    .setFixed()
                                                    .setModal(true)
                                                    .setStretchWidth(DialogSize.SMALL)
                                                    .setStretchHeight(DialogSize.SMALL)
                                                    .withHeader((parent, header) -> header.addCss(dui_accent))
                                                    .appendChild(text(SAMPLE_CONTENT))
                                                    .open();
                                        })
                                )
                        )
                        .appendChild(Column.span3()
                                .appendChild(Button.create("NO DRAG WINDOW")
                                        .addClickListener(evt -> {
                                            new Window("No drag window")
                                                    .setFixed()
                                                    .setModal(true)
                                                    .setDraggable(false)
                                                    .setStretchWidth(DialogSize.SMALL)
                                                    .setStretchHeight(DialogSize.SMALL)
                                                    .withHeader((parent, header) -> header.addCss(dui_teal))
                                                    .appendChild(text(SAMPLE_CONTENT))
                                                    .open();
                                        })
                                )
                        )
                        .appendChild(Column.span3()
                                .appendChild(Button.create("LARGE WINDOW")
                                        .addClickListener(evt -> {
                                            new Window("Large window")
                                                    .setFixed()
                                                    .setModal(true)
                                                    .setStretchWidth(DialogSize.LARGE)
                                                    .setStretchHeight(DialogSize.LARGE)
                                                    .withHeader((parent, header) -> header.addCss(dui_indigo))
                                                    .appendChild(text(SAMPLE_CONTENT))
                                                    .open();
                                        })
                                )
                        )

                )
        );
    }

    @Override
    public void cleanup() {
        DomGlobal.document.querySelectorAll(".dui-dialog-box")
                .asList()
                .forEach(e -> elementOf(e).remove());
    }
}