package org.dominokit.domino.menubar.client.views.ui;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.SampleClass;
import org.dominokit.domino.SampleMethod;
import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.domino.componentcase.client.ui.views.BaseDemoView;
import org.dominokit.domino.componentcase.client.ui.views.CodeCard;
import org.dominokit.domino.componentcase.client.ui.views.LinkToSourceCode;
import org.dominokit.domino.menubar.client.presenters.MenuBarProxy;
import org.dominokit.domino.menubar.client.views.MenuBarView;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.icons.lib.Icons;
import org.dominokit.domino.ui.menu.Menu;
import org.dominokit.domino.ui.menu.MenuItem;
import org.dominokit.domino.ui.notifications.Notification;
import org.dominokit.domino.ui.search.SearchBox;
import org.dominokit.domino.ui.typography.BlockHeader;
import org.dominokit.domino.ui.utils.PostfixAddOn;
import org.dominokit.domino.ui.utils.PrefixAddOn;
import org.dominokit.domino.ui.utils.Separator;
import org.dominokit.pro.domino.ui.menu.MenuBar;
import org.dominokit.pro.domino.ui.menu.MenuEntry;

import static org.dominokit.domino.ui.utils.Domino.*;

@UiView(presentable = MenuBarProxy.class)
@SampleClass
public class MenuBarViewImpl extends BaseDemoView<HTMLDivElement> implements MenuBarView {

    private DivElement element = div();

    @Override
    protected HTMLDivElement init() {

        element.appendChild(LinkToSourceCode.createLink("menu-bar", MenuBarViewImpl.class));
        element.appendChild(BlockHeader.create("Menu bar")
                .element());

        basicMenuBar();
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.basicMenuBar()));

        withBackgroundColors();
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.withBackgroundColors()));

        withAddOns();
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.withAddOns()));

        return element.element();
    }

    @SampleMethod
    private void basicMenuBar() {
        element.appendChild(Card.create("BASIC MENU BAR", "Basic menu bar")
                .withBody((parent, self) -> self.addCss(dui_p_0))
                .appendChild(new MenuBar()
                        .addCss(dui_elevation_2)
                        .appendChild(new MenuEntry("file", "<u>F</u>ile")
                                .setDropMenu(makeFileMenu().addCss(dui_accent_blue))
                        )
                        .appendChild(new MenuEntry("edit", "<u>E</u>dit").setDropMenu(makeEditMenu()))
                        .appendChild(new MenuEntry("view", "<u>V</u>iew").setDropMenu(makeHelpMenu()))
                )
                .appendChild(div().addCss(dui_w_full, dui_h_64))
        );
    }

    @SampleMethod
    private void withBackgroundColors() {
        element.appendChild(Card.create("WITH BACKGROUND", "Use custom background for menu bar")
                .withBody((parent, self) -> self.addCss(dui_p_0))
                .appendChild(new MenuBar()
                        .addCss(dui_blue)
                        .appendChild(new MenuEntry("File")
                                .setDropMenu(makeFileMenu().addCss(dui_accent_blue))
                        )
                        .appendChild(new MenuEntry("Edit").setDropMenu(makeEditMenu().addCss(dui_accent_blue)))
                        .appendChild(new MenuEntry("View").setDropMenu(makeHelpMenu().addCss(dui_accent_blue)))
                )
                .appendChild(div().addCss(dui_w_full, dui_h_64))
        );
    }

    @SampleMethod
    private void withAddOns() {
        element.appendChild(Card.create("WITH ADDONS", "Add prefix/postfix addons")
                .withBody((parent, self) -> self.addCss(dui_p_0))
                .appendChild(new MenuBar()
                        .addCss(dui_accent, dui_h_14)
                        .withPrefixElement((parent, self) -> self.appendChild(Icons.view_headline().clickable()))
                        .withPostfixElement((parent, self) -> {
                            self
                                    .appendChild(SearchBox.create()
                                            .addCss(dui_bg_l_1, dui_rounded_md, dui_fg_white, dui_h_11)
                                            .setCssProperty("--dui-form-field-placeholder-color", "var(--dui-color-5")
                                    )
                                    .appendChild(Icons.cog().clickable())
                            ;
                        })
                        .appendChild(new MenuEntry("File")
                                .setDropMenu(makeFileMenu())
                        )
                        .appendChild(new MenuEntry("Edit").setDropMenu(makeEditMenu()))
                        .appendChild(new MenuEntry("View").setDropMenu(makeHelpMenu()))
                )
                .appendChild(div().addCss(dui_w_full, dui_h_64))
        );
    }

    private Menu<String> makeFileMenu() {
        return Menu.<String>create()
                .appendChild(MenuItem.<String>create("New ...")
                        .setKey("new-key")
                        .withValue("new-value")
                )
                .appendChild(MenuItem.<String>create("Open")
                        .setKey("open-key")
                        .withValue("open-value")
                        .appendChild(PrefixAddOn.of(Icons.folder_open().addCss(dui_font_size_5)))
                )
                .appendChild(MenuItem.<String>create("Close")
                        .setKey("close-key")
                        .withValue("close-value")
                        .appendChild(PrefixAddOn.of(Icons.close_box().addCss(dui_font_size_5)))
                )
                .appendChild(MenuItem.<String>create("Close all")
                        .setKey("close-all-key")
                        .withValue("close-all-value")
                        .appendChild(PrefixAddOn.of(Icons.close_box_multiple().addCss(dui_font_size_5)))
                )
                .appendChild(Separator.create())
                .appendChild(MenuItem.<String>create("Project structure")
                        .setKey("structure-key")
                        .withValue("structure-value")
                        .appendChild(PrefixAddOn.of(Icons.folder_cog().addCss(dui_font_size_5)))
                )
                .appendChild(MenuItem.<String>create("Settings")
                        .setKey("settings-key")
                        .withValue("settings-value")
                        .appendChild(PrefixAddOn.of(Icons.cog().addCss(dui_font_size_5)))
                )
                .appendChild(Separator.create())
                .appendChild(MenuItem.<String>create("Invalidate cache", "Takes effect after restart")
                        .setKey("cache-key")
                        .withValue("cache-value")
                )
                .appendChild(MenuItem.<String>create("Restart")
                        .setKey("restart-key")
                        .withValue("restart-value")
                        .appendChild(PostfixAddOn.of(Icons.information()
                                        .addCss(dui_font_size_5)
                                        .setTooltip("Just a tool tip!")
                                )
                        )
                )
                .addSelectionListener((source, selectedItems) -> {
                    source.ifPresent(menuItem -> {
                        Notification.create("Key : " + menuItem.getKey() + ", value : " + menuItem.getValue()).show();
                    });
                });
    }

    private Menu<String> makeEditMenu() {
        return Menu.<String>create()
                .appendChild(MenuItem.<String>create("Undo")
                        .setKey("undo-key")
                        .withValue("undo-value")
                        .appendChild(PrefixAddOn.of(Icons.undo().addCss(dui_font_size_5)))
                )
                .appendChild(MenuItem.<String>create("Redo")
                        .setKey("redo-key")
                        .withValue("redo-value")
                        .appendChild(PrefixAddOn.of(Icons.redo().addCss(dui_font_size_5)))
                )
                .appendChild(Separator.create())
                .appendChild(MenuItem.<String>create("Cut")
                        .setKey("cut-key")
                        .withValue("cut-value")
                        .appendChild(PrefixAddOn.of(Icons.content_cut().addCss(dui_font_size_5)))
                )
                .appendChild(MenuItem.<String>create("Copy")
                        .setKey("copy-key")
                        .withValue("copy-value")
                        .appendChild(PrefixAddOn.of(Icons.content_copy().addCss(dui_font_size_5)))
                )
                .appendChild(MenuItem.<String>create("Paste")
                        .setKey("paste-key")
                        .withValue("paste-value")
                        .appendChild(PrefixAddOn.of(Icons.content_paste().addCss(dui_font_size_5)))
                )
                .appendChild(MenuItem.<String>create("Delete")
                        .setKey("delete-key")
                        .withValue("delete-value")
                        .appendChild(PrefixAddOn.of(Icons.delete().addCss(dui_font_size_5)))
                );

    }

    private Menu<String> makeHelpMenu() {
        return Menu.<String>create()
                .appendChild(MenuItem.<String>create("Help")
                        .setKey("help-key")
                        .withValue("help-value")
                        .appendChild(PrefixAddOn.of(Icons.help().addCss(dui_font_size_5)))
                        .setMenu(Menu.<String>create()
                                .appendChild(MenuItem.<String>create("Documentation")
                                        .setKey("Documentation-key")
                                        .withValue("Documentation-value")
                                )
                                .appendChild(MenuItem.<String>create("Samples")
                                        .setKey("Samples-key")
                                        .withValue("Samples-value")
                                )
                                .appendChild(MenuItem.<String>create("Tools")
                                        .setKey("Tools-key")
                                        .withValue("Tools-value")
                                        .setMenu(Menu.<String>create()
                                                .appendChild(MenuItem.<String>create("Editor")
                                                        .setKey("Editor-key")
                                                        .withValue("Editor-value")
                                                )
                                                .appendChild(MenuItem.<String>create("Log viewer")
                                                        .setKey("Log viewer-key")
                                                        .withValue("Log viewer-value")
                                                )
                                        )
                                )
                                .appendChild(MenuItem.<String>create("About us")
                                        .setKey("About us-key")
                                        .withValue("About us-value")
                                )
                        )
                )
                .appendChild(MenuItem.<String>create("Documentation")
                        .setKey("documentation-key")
                        .withValue("documentation-value")
                        .appendChild(PrefixAddOn.of(Icons.file_document().addCss(dui_font_size_5)))
                )
                .appendChild(MenuItem.<String>create("Getting started")
                        .setKey("getting-started-key")
                        .withValue("getting-started-value")
                        .appendChild(PrefixAddOn.of(Icons.help_box().addCss(dui_font_size_5)))
                )
                .appendChild(Separator.create())
                .appendChild(MenuItem.<String>create("About...")
                        .setKey("about-key")
                        .withValue("about-value")
                );
    }

}