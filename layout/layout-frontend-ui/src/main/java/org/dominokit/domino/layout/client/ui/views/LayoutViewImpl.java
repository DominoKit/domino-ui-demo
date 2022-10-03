package org.dominokit.domino.layout.client.ui.views;

import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLAnchorElement;
import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.domino.api.client.mvp.slots.IsSlot;
import org.dominokit.domino.layout.client.presenters.LayoutProxy;
import org.dominokit.domino.layout.client.views.LayoutView;
import org.dominokit.domino.layout.shared.extension.IsLayout;
import org.dominokit.domino.ui.forms.*;
import org.dominokit.domino.ui.grid.Column;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.grid.flex.FlexItem;
import org.dominokit.domino.ui.grid.flex.FlexJustifyContent;
import org.dominokit.domino.ui.grid.flex.FlexLayout;
import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.layout.AppLayout;
import org.dominokit.domino.ui.layout.AppLayoutStyles;
import org.dominokit.domino.ui.layout.LeftDrawerSize;
import org.dominokit.domino.ui.layout.NavBarUtility;
import org.dominokit.domino.ui.loaders.Loader;
import org.dominokit.domino.ui.loaders.LoaderEffect;
import org.dominokit.domino.ui.menu.CustomMenuItem;
import org.dominokit.domino.ui.menu.Menu;
import org.dominokit.domino.ui.menu.MenuItem;
import org.dominokit.domino.ui.notifications.Notification;
import org.dominokit.domino.ui.scroll.ScrollTop;
import org.dominokit.domino.ui.style.Spacing;
import org.dominokit.domino.ui.style.Style;
import org.dominokit.domino.ui.style.Styles;
import org.dominokit.domino.ui.utils.DominoElement;
import org.dominokit.domino.ui.utils.ElementUtil;
import org.dominokit.domino.view.BaseElementView;
import org.dominokit.domino.view.slots.AppendElementSlot;
import org.dominokit.domino.view.slots.SingleElementSlot;
import org.gwtproject.safehtml.shared.SafeHtmlBuilder;

import java.util.Optional;

import static org.jboss.elemento.Elements.*;

@UiView(presentable = LayoutProxy.class)
public class LayoutViewImpl extends BaseElementView<HTMLDivElement> implements LayoutView {

    private AppLayout layout;

    private HTMLDivElement profileDiv = div().element();
    private HTMLDivElement menuDiv = div().element();
    private Loader loader;

    @Override
    protected HTMLDivElement init() {
//        Search search = Search.create();
        layout = AppLayout.create("Domino UI demo")
                .toggleLeftDrawerSpanUp()
                .toggleLeftDrawerSpanDown()
                .toggleLeftOverlay()
                .withContent((parent, self) -> {
                            self.appendChild(DominoElement.div().addCss("dui-bg-white", "dui-p-8")
                                    .appendChild(new Select<String, String>(source -> Optional.of(SimpleSelectOption.create(source, source, source, source)
                                                    .addLeftAddOn(Icons.ALL.earth_mdi())
                                            ))
                                                    .setLabel("Select field")
                                                    .setPlaceholder("Select place holder")
                                                    .setOptionValueRenderer((select, option) -> DominoElement.span().setTextContent(String.valueOf(option.getValue())).element())
                                                    .addItems("Jordan", "Japan", "Jamaica", "South america", "South korea", "Egypt")
                                                    .setClearable(true)
                                                    .setSearchable(true)
                                                    .withValue("Jordan")
                                                    .addLeftAddOn(Icons.ALL.earth_mdi())
                                                    .setMissingItemHandler(SimpleSelectOption::create)
                                    )
                                    .appendChild(new MultiSelect<String, String>(source -> Optional.of(SimpleSelectOption.create(source, source, source, source)))
                                            .setLabel("Select field")
                                            .setPlaceholder("Select place holder")
                                            .setOptionValueRenderer((select, option) -> DominoElement.span().addCss(Spacing.M_X_0_5).setTextContent(option.getValue() + ",").element())
                                            .addItems("Jordan", "Japan", "Jamaica", "South america", "South korea", "Egypt")
                                            .setClearable(true)
                                            .setSearchable(true)
                                            .setAutoCloseOnSelect(false)
                                            .addLeftAddOn(Icons.ALL.earth_mdi())
                                            .setMissingItemHandler(SimpleSelectOption::create)
                                    )
                                    .appendChild(new SuggestionBox<String>(LocalSuggestBoxStore.<String, String>create(source -> Optional.of(SimpleSelectOption.create(source, source, source, source)), "sample", "test", "value", "testing", "volume")
                                                    .setMissingHandlers(missingValue -> Optional.of(SimpleSelectOption.create(missingValue)),
                                                            inputValue -> Optional.of(SimpleSelectOption.create(inputValue))
                                                    )
                                            )
                                                    .setOptionValueRenderer((select, option) -> DominoElement.span().addCss(Spacing.M_X_0_5).setTextContent(option.getValue() + ",")
                                                            .apply(e -> e.addClickListener(evt -> option.deselect()))
                                                            .element())
                                                    .setLabel("Suggest box")
                                                    .setPlaceholder("Start typing...")
                                    )
                                    .appendChild(new MultiSuggestBox<String>(LocalSuggestBoxStore.<String, String>create(source -> Optional.of(SimpleSelectOption.create(source, source, source, source)), "sample", "test", "value", "testing", "volume")
                                                    .setMissingHandlers(missingValue -> Optional.of(SimpleSelectOption.create(missingValue)),
                                                            inputValue -> Optional.of(SimpleSelectOption.create(inputValue))
                                                    )
                                            )
                                                    .setOptionValueRenderer((select, option) -> DominoElement.span().addCss(Spacing.M_X_0_5).setTextContent(option.getValue() + ",")
                                                            .apply(e -> e.addClickListener(evt -> option.deselect()))
                                                            .element())
                                                    .setLabel("Multi Suggest box")
                                                    .setPlaceholder("Start typing...")
                                    )

                                    .appendChild(TextBox.create("Domain")
                                            .addLeftAddOn(Icons.ALL.server_mdi().clickable())
                                            .addRightAddOn(Icons.ALL.database_mdi().clickable())
                                            .setPrefix("Server address")
                                            .setPostfix("Database")
                                            .setMaxLength(100)
                                            .setHelperText("This is a sample text field")
                                            .setRequired(true, "this field is required")
                                            .setAutoValidation(true)
                                            .setPlaceholder("Place holder")
                                            .fixErrorsPosition(true)
                                            .setCountFormatter((count, maxCount) -> "Remains : " + (maxCount - count))
                                    )
                                    .appendChild(CheckBox.create("Sample checkbox")
                                            .setLabel("Checkbox label")
                                            .filled(true)
                                            .setHelperText("Checkbox helper text")
                                            .setRequired(true)
                                    )
                                    .appendChild(SwitchButton.create()
                                            .setHelperText("Switch note"))
                                    .appendChild(SwitchButton.create("Enable user", "Yes")
                                            .setHelperText("Switch note")
                                            .check())
                                    .appendChild(SwitchButton.create("Enable user", "No", "Yes")
                                            .condenseLabels()
                                            .setHelperText("Switch note"))

                                    .appendChild(RadioGroup.<String>create("sample", "Radio group")
                                            .appendChild(Radio.create("value1", "Option-1"))
                                            .appendChild(Radio.create("value2", "Option-2"))
                                            .appendChild(Radio.create("value3", "Option-3"))
                                            .appendChild(Radio.create("value4", "Option-4"))
                                            .appendChild(Radio.create("value5", "Option-5"))
                                    )
                                    .appendChild(RadioGroup.<String>create("sample2", "Radio group")
                                            .withGap(true)
                                            .appendChild(Radio.create("value1", "Option-1"))
                                            .appendChild(Radio.create("value2", "Option-2"))
                                            .appendChild(Radio.create("value3", "Option-3"))
                                            .appendChild(Radio.create("value4", "Option-4"))
                                            .appendChild(Radio.create("value5", "Option-5"))
                                    )
                                    .appendChild(RadioGroup.<String>create("sample3", "Radio group")
                                            .withGap(true)
                                            .vertical()
                                            .appendChild(Radio.create("value1", "Option-1"))
                                            .appendChild(Radio.create("value2", "Option-2"))
                                            .appendChild(Radio.create("value3", "Option-3"))
                                            .appendChild(Radio.create("value4", "Option-4"))
                                            .appendChild(Radio.create("value5", "Option-5"))
                                    )

                                    .appendChild(Menu.<String>create()
                                            .setIcon(Icons.ALL.file_mdi())
                                            .setTitle("Files")
                                            .appendAction(Icons.ALL.folder_key_outline_mdi()
                                                    .size18()
                                                    .clickable()
                                                    .addClickListener(evt -> {
                                                        Notification.create("Action clicked").show();
                                                    })
                                            )
                                            .appendAction(Icons.ALL.folder_heart_outline_mdi()
                                                    .size18()
                                                    .clickable()
                                                    .addClickListener(evt -> {
                                                        Notification.create("Action clicked").show();
                                                    })
                                            )
                                            .setSearchable(true)
                                            .setMissingItemHandler((token, menu) -> menu.appendChild(MenuItem.create(token, "The item was initially missing")))
                                            .appendChild(MenuItem.<String>create("New ...")
                                                    .setKey("new-key")
                                                    .value("new-value")
                                            )
                                            .appendChild(MenuItem.<String>create("Open")
                                                    .setKey("open-key")
                                                    .value("open-value")
                                                    .addLeftAddOn(FlexItem.of(Icons.ALL.folder_open_mdi().size18()))
                                            )
                                            .appendChild(MenuItem.<String>create("Close")
                                                    .setKey("close-key")
                                                    .value("close-value")
                                                    .addLeftAddOn(FlexItem.of(Icons.ALL.close_box_mdi().size18()))
                                            )
                                            .appendChild(MenuItem.<String>create("Close all")
                                                    .setKey("close-all-key")
                                                    .value("close-all-value")
                                                    .addLeftAddOn(FlexItem.of(Icons.ALL.close_box_multiple_mdi().size18()))
                                            ).appendSeparator()
                                            .appendChild(CustomMenuItem.create()
                                                    .setKey("custom-key")
                                                    .value("custom-value")
                                                    .appendChild(FlexLayout.create()
                                                            .css("dui-flex", "dui-w-full", "dui-justify-center", "dui-gap-4")
                                                            .setJustifyContent(FlexJustifyContent.CENTER)
                                                            .setGap("10px")
                                                            .appendChild(FlexItem.create().appendChild(Icons.ALL.content_cut_mdi().size18().setTooltip("Cut").clickable()))
                                                            .appendChild(FlexItem.create().appendChild(Icons.ALL.content_copy_mdi().size18().setTooltip("Copy").clickable()))
                                                            .appendChild(FlexItem.create().appendChild(Icons.ALL.content_paste_mdi().size18().setTooltip("Paste").clickable()))
                                                    )
                                            )
                                            .appendSeparator()
                                            .appendChild(MenuItem.<String>create("Project structure")
                                                    .setKey("structure-key")
                                                    .value("structure-value")
                                                    .addLeftAddOn(FlexItem.of(Icons.ALL.folder_settings_variant_mdi().size18()))
                                            )
                                            .appendChild(MenuItem.<String>create("Settings")
                                                    .setKey("settings-key")
                                                    .value("settings-value")
                                                    .addLeftAddOn(FlexItem.of(Icons.ALL.settings_mdi().size18()))
                                            )
                                            .appendSeparator()
                                            .appendChild(MenuItem.<String>create("Invalidate cache", "Takes effect after restart")
                                                    .setKey("cache-key")
                                                    .value("cache-value")
                                            )
                                            .appendChild(MenuItem.<String>create("Restart")
                                                    .setKey("restart-key")
                                                    .value("restart-value")
                                                    .addRightAddOn(FlexItem.of(Icons.ALL.information_mdi()
                                                                    .size18()
                                                                    .setTooltip("Just a tool tip!")
                                                            )
                                                    )
                                            )
                                            .addSelectionListener((menuItem, selectedItems) -> {
                                                menuItem.ifPresent(item -> {
                                                    Notification.create("Key : " + item.getKey() + ", value : " + item.getValue()).show();
                                                });
                                            })
                                    )
                            );

                        }
                )
                .withNavBar((parent, self) -> {
                    self
//                            .appendChild(search)
//                            .appendChild(NavBarUtility.of(Icons.ALL.magnify_mdi()
//                                            .css("dui-clickable")
//                                            .addClickListener(evt -> search.open())
//                                    )
//                            )
                            .appendChild(NavBarUtility.of(Icons.ALL.github_face_mdi()
                                            .css("dui-clickable")
                                            .addClickListener(evt -> DomGlobal.window.open("https://github.com/DominoKit/domino-ui", "_blank"))
                                    )

                            )
                            .appendChild(NavBarUtility.of(DominoElement.of(img("/images/patreon-2296036-1911995.png"))
                                            .css("dui", "dui-clickable", "dui-w-8", "dui-h-8")

                                            .addClickListener(evt -> DomGlobal.window.open("https://www.patreon.com/bePatron?u=30748189", "_blank"))
                                    )

                            )
                            .appendChild(NavBarUtility.of(Icons.ALL.dots_vertical_mdi()
                                            .css("dui-clickable")
                                            .addClickListener(evt -> {
                                            })
                                    )

                            )
                    ;
                });

        layout.withFooter((layout, footer) -> {
            footer.appendChild(DominoElement.div()
                    .css("dui-p-4")
                    .appendChild(createFooterRow())
                    .appendChild(div()
                            .css(Styles.align_center)
                            .add(p().css("dui")
                                    .style("line-height: 45px; height: 45px; margin: 0px; text-align: center;")
                                    .textContent("© 2018 Copyright DominoKit")).element())

            );
        });

        DomGlobal.document.body.appendChild(ScrollTop.create(Icons.ALL.arrow_up_mdi())
                .setBottom(60)
                .element());

        layout.withLeftDrawerContent((parent, drawer) -> {
            drawer
                    .appendChild(profileDiv)
                    .appendChild(menuDiv);
        });

        loader = Loader.create(layout.getContent(), LoaderEffect.PULSE);

        return layout.element();
    }

    @Override
    public IsSlot<?> getContentSlot() {
        return SingleElementSlot.of(layout.getContent());
    }

    @Override
    public IsSlot<?> getMenuPanelSlot() {
        return SingleElementSlot.of(menuDiv);
    }

    @Override
    public IsSlot<?> getProfilePanelSlot() {
        return SingleElementSlot.of(profileDiv);
    }

    @Override
    public IsSlot<?> getTopBarSlot() {
        return AppendElementSlot.of(layout.getNavBar());
    }

    @Override
    public IsSlot<?> getRightPanelSlot() {
        return SingleElementSlot.of(layout.getRightDrawerContent());
    }

    private Row createFooterRow() {
        return Row.create()
                .style()
                .setMargin("0px")
                .addCss("demo-footer")
                .get()
                .addColumn(Column.span4()
                        .style()
                        .setMarginBottom("20px")
                        .get()
                        .appendChild(h(4)
                                .textContent("Support us")
                        )
                        .appendChild(p().textContent("Your donation will help us to continue working on domino-ui and let it grow to meet your needs, and is highly appreciated."))
                        .appendChild(div().innerHtml(new SafeHtmlBuilder().appendHtmlConstant("<form action=\"https://www.paypal.com/cgi-bin/webscr\" method=\"post\" target=\"_top\">\n" +
                                "<input type=\"hidden\" name=\"cmd\" value=\"_s-xclick\" />\n" +
                                "<input type=\"hidden\" name=\"lc\" value=\"US\" />\n" +
                                "<input type=\"hidden\" name=\"hosted_button_id\" value=\"AW5YG4LTTYNPS\" />\n" +
                                "<input type=\"image\" src=\"https://www.paypalobjects.com/en_US/i/btn/btn_donateCC_LG.gif\" border=\"0\" name=\"submit\" title=\"PayPal - The safer, easier way to pay online!\" alt=\"Donate with PayPal button\" />\n" +
                                "<img alt=\"\" border=\"0\" src=\"https://www.paypal.com/en_JO/i/scr/pixel.gif\" width=\"1\" height=\"1\" />\n" +
                                "</form>\n").toSafeHtml()))
                )
                .addColumn(Column.span4()
                        .style()
                        .setMarginBottom("20px")
                        .get()
                        .appendChild(h(4)
                                .textContent("Join discussions")
                        )
                        .appendChild(p().textContent("Join our Gitter channel for positive discussions, feedback, announcements and ask questions, it is lively in there."))
                        .appendChild(p().innerHtml(new SafeHtmlBuilder().appendHtmlConstant("<a title=\"Gitter\" href=\"https://gitter.im/domino-gwt/domino-ui\" rel=\"nofollow\"><img src=\"https://camo.githubusercontent.com/da2edb525cde1455a622c58c0effc3a90b9a181c/68747470733a2f2f6261646765732e6769747465722e696d2f4a6f696e253230436861742e737667\" data-canonical-src=\"https://badges.gitter.im/Join%20Chat.svg\" style=\"max-width:100%;\"></a>").toSafeHtml()))
                )
                .addColumn(Column.span4()
                        .style()
                        .setMarginBottom("20px")
                        .get()
                        .appendChild(h(4)
                                .textContent("Our repository")
                        )
                        .appendChild(p().textContent("Contribute to our library at our official Domino-ui Github repository by forking, making pull requests or filing issues."))
                        .appendChild(Style.of(div().innerHtml(new SafeHtmlBuilder().appendHtmlConstant("<iframe src=\"https://ghbtns.com/github-btn.html?user=DominoKit&amp;repo=domino-ui&amp;type=star&amp;count=true&amp;size=large\" frameborder=\"0\" scrolling=\"0\" width=\"125px\" height=\"30px\"></iframe>").toSafeHtml())))
                );
    }

    private HTMLAnchorElement makeGithubLink() {
        HTMLAnchorElement githubLink = a().css("fab fa-github fa-2x", "js-right-sidebar").element();
        githubLink.addEventListener("click", evt -> {
            DomGlobal.window.open("https://github.com/DominoKit/domino-ui", "_blank");
        });
        return githubLink;
    }


    @Override
    public void toggleRightPanel() {
        layout.toggleRightDrawer();
    }

    @Override
    public void toggleLeftPanel() {
        layout.toggleLeftDrawer();
    }

    @Override
    public IsLayout showLeftPanel() {
        layout.toggleLeftDrawer();
        return this;
    }

    @Override
    public IsLayout hideLeftPanel() {
        layout.toggleLeftDrawer();
        return this;
    }

    @Override
    public IsLayout setTitle(String title) {
        layout.withNavBar((layout, navbar) -> navbar.setTitle(title));
        return this;
    }

    @Override
    public IsLayout showRightPanel() {
        layout.toggleRightDrawer();
        return this;
    }

    @Override
    public IsLayout hideRightPanel() {
        layout.toggleRightDrawer();
        return this;
    }

    @Override
    public IsLayout fixLeftPanelPosition() {
//        layout.fixLeftPanelPosition();
        return this;
    }

    @Override
    public IsLayout unfixLeftPanelPosition() {
//        layout.unfixLeftPanelPosition();
        return this;
    }

    @Override
    public IsLayout setLeftPanelSize(String size) {
        layout.setLeftDrawerSize(LeftDrawerSize.valueOf(size));
        return this;
    }

    @Override
    public IsLayout scrollTop() {
        ElementUtil.scrollTop();
        return this;
    }

    @Override
    public boolean isRightPanelVisible() {
        return layout.containsCss(AppLayoutStyles.RIGHT_OPEN.getCssClass());
    }

    @Override
    public void startLoading() {
        loader.start();
    }

    @Override
    public void stopLoading() {
        loader.stop();
    }
}