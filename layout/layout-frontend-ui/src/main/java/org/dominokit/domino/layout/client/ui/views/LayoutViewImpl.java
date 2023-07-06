package org.dominokit.domino.layout.client.ui.views;

import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLAnchorElement;
import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.domino.api.client.mvp.slots.IsSlot;
import org.dominokit.domino.layout.client.presenters.LayoutProxy;
import org.dominokit.domino.layout.client.views.LayoutView;
import org.dominokit.domino.layout.shared.extension.IsLayout;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.icons.lib.Icons;
import org.dominokit.domino.ui.layout.AppLayout;
import org.dominokit.domino.ui.layout.AppLayoutStyles;
import org.dominokit.domino.ui.layout.LeftDrawerSize;
import org.dominokit.domino.ui.loaders.Loader;
import org.dominokit.domino.ui.loaders.LoaderEffect;
import org.dominokit.domino.ui.menu.direction.DropDirection;
import org.dominokit.domino.ui.scroll.ScrollTop;
import org.dominokit.domino.ui.style.*;
import org.dominokit.domino.ui.themes.DominoThemeDark;
import org.dominokit.domino.ui.themes.DominoThemeLight;
import org.dominokit.domino.ui.themes.DominoThemeManager;
import org.dominokit.domino.ui.upload.FileItem;
import org.dominokit.domino.ui.upload.FilePreviewContainer;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.ElementUtil;
import org.dominokit.domino.ui.utils.ElementsFactory;
import org.dominokit.domino.ui.utils.PostfixAddOn;
import org.dominokit.domino.view.BaseElementView;
import org.dominokit.domino.view.slots.AppendElementSlot;
import org.dominokit.domino.view.slots.SingleElementSlot;
import org.gwtproject.safehtml.shared.SafeHtmlBuilder;

import static org.dominokit.domino.ui.grid.Column.span4;

@UiView(presentable = LayoutProxy.class)
public class LayoutViewImpl extends BaseElementView<HTMLDivElement> implements LayoutView, DominoCss, ElementsFactory {

    private AppLayout layout;

    private Loader loader;
    private SwapCssClass accentClass = SwapCssClass.of(dui_accent_teal);
    private CompositeCssClass accent_button = CompositeCssClass.of(
            dui_min_w_8,
            dui_min_h_8,
            dui_border_solid,
            dui_border_2,
            dui_rounded_full,
            dui_border_white,
            dui_border_solid);

    @Override
    protected HTMLDivElement init() {
        layout = AppLayout.create("Domino UI demo");

        layout.withFooter((layout, footer) -> {
            footer.appendChild(div()
                    .css("dui-p-4")
                    .appendChild(createFooterRow())
                    .appendChild(div()
                            .addCss(dui_text_center)
                            .appendChild(p().css("dui")
                                    .style("line-height: 45px; height: 45px; margin: 0px; text-align: center;")
                                    .textContent("© 2018 Copyright DominoKit")).element())

            );
        });

        DomGlobal.document.body.appendChild(ScrollTop.create(Icons.arrow_up())
                .setBottom(60)
                .element());
        layout.setLeftDrawerSpanDown(true);

        layout.withLeftDrawerContent((parent, drawer) -> {
            drawer.addCss(dui_flex, dui_flex_col);
        });
        layout.withNavBar((parent, self) -> {
            self.appendChild(PostfixAddOn.of(Icons.theme_light_dark()
                            .setTooltip("Dark mode on/off", DropDirection.BEST_MIDDLE_SIDE)
                            .clickable()
                            .addClickListener(evt -> {
                                if (DominoThemeDark.INSTANCE.isApplied()) {
                                    DominoThemeManager.INSTANCE.apply(DominoThemeLight.INSTANCE);
                                } else {
                                    DominoThemeManager.INSTANCE.apply(DominoThemeDark.INSTANCE);
                                }
                            })
                    )
            );
        });

        loader = Loader.create(layout.getContent(), LoaderEffect.PULSE);

        return layout.element();
    }

    private Row createFooterRow() {
        return Row.create()
                .setMargin("0px")
                .appendChild(span4()
                        .setMarginBottom("20px")
                        .appendChild(h(4)
                                .textContent("Support us")
                        )
                        .appendChild(p().textContent("Your donation will help us to continue working on domino-ui and let it grow to meet your needs, and is highly appreciated."))
                        .appendChild(div().setInnerHtml(new SafeHtmlBuilder().appendHtmlConstant("<form action=\"https://www.paypal.com/cgi-bin/webscr\" method=\"post\" target=\"_top\">\n" +
                                "<input type=\"hidden\" name=\"cmd\" value=\"_s-xclick\" />\n" +
                                "<input type=\"hidden\" name=\"lc\" value=\"US\" />\n" +
                                "<input type=\"hidden\" name=\"hosted_button_id\" value=\"AW5YG4LTTYNPS\" />\n" +
                                "<input type=\"image\" src=\"https://www.paypalobjects.com/en_US/i/btn/btn_donateCC_LG.gif\" border=\"0\" name=\"submit\" title=\"PayPal - The safer, easier way to pay online!\" alt=\"Donate with PayPal button\" />\n" +
                                "<img alt=\"\" border=\"0\" src=\"https://www.paypal.com/en_JO/i/scr/pixel.gif\" width=\"1\" height=\"1\" />\n" +
                                "</form>\n").toSafeHtml()))
                )
                .appendChild(span4()
                        .setMarginBottom("20px")
                        .appendChild(h(4)
                                .textContent("Join discussions")
                        )
                        .appendChild(p().textContent("Join our Gitter channel for positive discussions, feedback, announcements and ask questions, it is lively in there."))
                        .appendChild(p().setInnerHtml(new SafeHtmlBuilder().appendHtmlConstant("<a title=\"Gitter\" href=\"https://gitter.im/domino-gwt/domino-ui\" rel=\"nofollow\"><img src=\"https://camo.githubusercontent.com/da2edb525cde1455a622c58c0effc3a90b9a181c/68747470733a2f2f6261646765732e6769747465722e696d2f4a6f696e253230436861742e737667\" data-canonical-src=\"https://badges.gitter.im/Join%20Chat.svg\" style=\"max-width:100%;\"></a>").toSafeHtml()))
                )
                .appendChild(span4()
                        .setMarginBottom("20px")
                        .appendChild(h(4)
                                .textContent("Our repository")
                        )
                        .appendChild(p().textContent("Contribute to our library at our official Domino-ui Github repository by forking, making pull requests or filing issues."))
                        .appendChild(div().setInnerHtml(new SafeHtmlBuilder().appendHtmlConstant("<iframe src=\"https://ghbtns.com/github-btn.html?user=DominoKit&amp;repo=domino-ui&amp;type=star&amp;count=true&amp;size=large\" frameborder=\"0\" scrolling=\"0\" width=\"125px\" height=\"30px\"></iframe>").toSafeHtml()))
                );
    }


    @Override
    public IsSlot<?> getContentSlot() {
        return SingleElementSlot.of(layout.getContent());
    }

    @Override
    public IsSlot<?> getMenuPanelSlot() {
        return AppendElementSlot.of(layout.getLeftDrawerContent());
    }

    @Override
    public IsSlot<?> getTopBarSlot() {
        return AppendElementSlot.of(layout.getNavBar());
    }

    @Override
    public IsSlot<?> getRightPanelSlot() {
        return SingleElementSlot.of(layout.getRightDrawerContent());
    }

    private HTMLAnchorElement makeGithubLink() {
        HTMLAnchorElement githubLink = a().css("fab fa-github fa-2x", "js-right-sidebar").element();
        githubLink.addEventListener("click", evt -> {
            DomGlobal.window.open("https://github.com/DominoKit/domino-ui", "_blank");
        });
        return githubLink;
    }

    @Override
    public void startLoading() {
        loader.start();
    }

    @Override
    public void stopLoading() {
        loader.stop();
    }

    @Override
    public void spanDown(boolean spanDown) {
        layout.setLeftDrawerSpanDown(spanDown);
    }

    @Override
    public void spanUp(boolean spanUp) {
        layout.setLeftDrawerSpanUp(spanUp);
    }

    @Override
    public void toggleRightPanel() {
        layout.toggleRightDrawer();
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
    public boolean isRightPanelVisible() {
        return layout.containsCss(AppLayoutStyles.dui_right_open.getCssClass());
    }

    @Override
    public IsLayout fixLeftPanelPosition() {
        layout.showLeftDrawer();
        layout.setShrinkContent(true);
        layout.setAutoCloseLeftDrawer(false);
        return this;
    }

    @Override
    public IsLayout unfixLeftPanelPosition() {
        layout.setShrinkContent(false);
        layout.setAutoCloseLeftDrawer(true);
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

}