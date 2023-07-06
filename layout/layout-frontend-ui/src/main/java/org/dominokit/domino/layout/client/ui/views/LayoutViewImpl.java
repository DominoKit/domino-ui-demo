package org.dominokit.domino.layout.client.ui.views;

import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLAnchorElement;
import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.domino.api.client.mvp.slots.IsSlot;
import org.dominokit.domino.layout.client.presenters.LayoutProxy;
import org.dominokit.domino.layout.client.views.LayoutView;
import org.dominokit.domino.layout.shared.extension.IsLayout;
import org.dominokit.domino.ui.grid.Column;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.grid.flex.FlexItem;
import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.layout.Layout;
import org.dominokit.domino.ui.layout.LayoutActionItem;
import org.dominokit.domino.ui.loaders.Loader;
import org.dominokit.domino.ui.loaders.LoaderEffect;
import org.dominokit.domino.ui.menu.Menu;
import org.dominokit.domino.ui.menu.MenuItem;
import org.dominokit.domino.ui.scroll.ScrollTop;
import org.dominokit.domino.ui.search.Search;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.style.Style;
import org.dominokit.domino.ui.style.Styles;
import org.dominokit.domino.ui.themes.Theme;
import org.dominokit.domino.ui.utils.DominoElement;
import org.dominokit.domino.ui.utils.ElementUtil;
import org.dominokit.domino.ui.utils.ScreenMedia;
import org.dominokit.domino.view.BaseElementView;
import org.dominokit.domino.view.slots.AppendElementSlot;
import org.dominokit.domino.view.slots.SingleElementSlot;
import org.gwtproject.safehtml.shared.SafeHtmlBuilder;
import org.jboss.elemento.EventType;
import org.jboss.elemento.HtmlContentBuilder;

import static org.jboss.elemento.Elements.a;
import static org.jboss.elemento.Elements.div;
import static org.jboss.elemento.Elements.h;
import static org.jboss.elemento.Elements.img;
import static org.jboss.elemento.Elements.li;
import static org.jboss.elemento.Elements.p;

@UiView(presentable = LayoutProxy.class)
public class LayoutViewImpl extends BaseElementView<HTMLDivElement> implements LayoutView {

    private Layout layout = new Layout().setTitle("Domino UI demo");

    private HTMLDivElement profileDiv = div().element();
    private HTMLDivElement menuDiv = div().element();
    private Loader loader;

    @Override
    protected HTMLDivElement init() {
        Search search = Search.create();
        layout
                .spanLeftPanelUp()
                .autoFixLeftPanel()
                .getNavigationBar()
                .insertBefore(search, layout.getNavigationBar().firstChild());

        HtmlContentBuilder<HTMLAnchorElement> searchButton = a().css("js-right-sidebar").add(Icons.ALL.search());
        searchButton.on(EventType.click, event -> search.open());
        layout.getTopBar()
                .appendChild(li().css(Styles.pull_right).add(searchButton).element());
        LayoutActionItem btnRefresh = LayoutActionItem.create(Icons.ALL.refresh().setTooltip("Refresh")).addClickListener(l->DomGlobal.console.info("test"));
        layout.getTopBar().appendChild(btnRefresh);
        layout.getTopBar()
                .appendChild(DominoElement.of(li()
                                .css(Styles.pull_right)
                                .style("padding-top: 3px;")
                                .add(makeGithubLink())
                        )
                        .setTooltip("Github")
                        .showOn(ScreenMedia.MEDIUM_AND_UP)
                        .hideOn(ScreenMedia.SMALL_AND_DOWN)
                        .element());
        layout.getTopBar()
                .appendChild(DominoElement.of(li().add(a()
                                        .attr("href", "https://www.patreon.com/bePatron?u=30748189")
                                        .css("d-patreon")
                                        .add(img("/images/patreon-2296036-1911995.png"))
                                ))
                                .showOn(ScreenMedia.MEDIUM_AND_UP)
                                .hideOn(ScreenMedia.SMALL_AND_DOWN)
                );

        ;
        layout.getTopBar()
                .appendChild(DominoElement.of(li().css(Styles.pull_right)
                                .add(a()
                                        .css(Styles.m_t_10)
                                        .add(Icons.ALL.dots_vertical_mdi()
                                                .clickable()
                                                .setColor(Color.WHITE)
                                        )
                                ))
                        .showOn(ScreenMedia.SMALL_AND_DOWN)
                        .hideOn(ScreenMedia.MEDIUM_AND_UP)
                        .setDropMenu(Menu.<String>create()
                                .setUseSmallScreensDirection(false)
                                .appendChild(MenuItem.<String>create("Github")
                                        .addLeftAddOn(FlexItem.of(Icons.ALL.github_circle_mdi()))
                                        .addSelectionHandler(selectable -> DomGlobal.window.open("https://github.com/DominoKit/domino-ui", "_blank"))
                                )
                                .appendChild(MenuItem.<String>create("Patreon")
                                        .addLeftAddOn(FlexItem.of(Icons.ALL.patreon_mdi()))
                                        .addSelectionHandler(selectable -> DomGlobal.window.open("https://www.patreon.com/bePatron?u=30748189", "_blank"))
                                )
                        )
                        )
        ;


        layout.showFooter();
        Row footerRow = createFooterRow();

        HTMLDivElement copyrightsElement = div()
                .css(Theme.currentTheme.getScheme().darker_3().getBackground())
                .css(Styles.align_center)
                .add(p().style("line-height: 45px; height: 45px; margin: 0px;")
                        .textContent("© 2018 Copyright DominoKit")).element();

        layout.getFooter().appendChild(footerRow);
        layout.getFooter().appendChild(copyrightsElement);

        Theme.addThemeChangeHandler((oldTheme, newTheme) -> Style.of(copyrightsElement)
                .removeCss(oldTheme.getScheme().darker_3().getBackground())
                .addCss(newTheme.getScheme().darker_3().getBackground()));

        DomGlobal.document.body.appendChild(ScrollTop.create(Icons.ALL.arrow_upward())
                .setBottom(60)
                .element());

        layout.getLeftPanel()
                .appendChild(profileDiv)
                .appendChild(menuDiv);

        layout.getContentPanel()
                .style().setMinHeight("calc(100vh - 365px)");
        loader = Loader.create(layout.getContentPanel(), LoaderEffect.PULSE);

        return layout.element();
    }

    @Override
    public IsSlot<?> getContentSlot() {
        return SingleElementSlot.of(layout.getContentPanel());
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
        return AppendElementSlot.of(layout.getTopBar());
    }

    @Override
    public IsSlot<?> getRightPanelSlot() {
        return SingleElementSlot.of(layout.getRightPanel());
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
        layout.toggleRightPanel();
    }

    @Override
    public void toggleLeftPanel() {
        layout.toggleLeftPanel();
    }

    @Override
    public IsLayout showLeftPanel() {
        layout.showLeftPanel();
        return this;
    }

    @Override
    public IsLayout hideLeftPanel() {
        layout.hideLeftPanel();
        return this;
    }

    @Override
    public IsLayout setTitle(String title) {
        layout.setTitle(title);
        return this;
    }

    @Override
    public IsLayout showRightPanel() {
        layout.showRightPanel();
        return this;
    }

    @Override
    public IsLayout hideRightPanel() {
        layout.hideRightPanel();
        return this;
    }

    @Override
    public IsLayout fixLeftPanelPosition() {
        layout.fixLeftPanelPosition();
        return this;
    }

    @Override
    public IsLayout unfixLeftPanelPosition() {
        layout.unfixLeftPanelPosition();
        return this;
    }

    @Override
    public IsLayout setLeftPanelSize(String size) {
        Layout.LeftPanelSize leftPanelSize = Layout.LeftPanelSize.valueOf(size);
        layout.setLeftPanelSize(leftPanelSize);
        return this;
    }

    @Override
    public IsLayout scrollTop() {
        ElementUtil.scrollTop();
        return this;
    }

    @Override
    public boolean isRightPanelVisible() {
        return layout.isRightPanelVisible();
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