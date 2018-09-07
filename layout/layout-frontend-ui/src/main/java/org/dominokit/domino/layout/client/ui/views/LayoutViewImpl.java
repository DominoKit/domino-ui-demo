package org.dominokit.domino.layout.client.ui.views;

import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLAnchorElement;
import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import jsinterop.base.Js;
import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.domino.api.shared.extension.Content;
import org.dominokit.domino.layout.client.presenters.LayoutPresenter;
import org.dominokit.domino.layout.client.views.LayoutView;
import org.dominokit.domino.layout.shared.extension.IsLayout;
import org.dominokit.domino.layout.shared.extension.LayoutContext;
import org.dominokit.domino.ui.grid.Column;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.icons.Icon;
import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.layout.Layout;
import org.dominokit.domino.ui.search.Search;
import org.dominokit.domino.ui.style.Style;
import org.dominokit.domino.ui.style.Styles;
import org.dominokit.domino.ui.themes.Theme;
import org.gwtproject.safehtml.shared.SafeHtmlBuilder;
import org.jboss.gwt.elemento.core.EventType;
import org.jboss.gwt.elemento.core.builder.HtmlContentBuilder;

import static java.util.Objects.nonNull;
import static org.jboss.gwt.elemento.core.Elements.*;

@UiView(presentable = LayoutPresenter.class)
public class LayoutViewImpl implements LayoutView {

    private Layout layout = new Layout().setTitle("Domino UI demo");

    private Content rightPanelContent;

    public LayoutViewImpl() {

        Search search = Search.create();
        layout.getNavigationBar().asElement()
                .insertBefore(search.asElement(), layout.getNavigationBar().asElement().firstChild);

        HtmlContentBuilder<HTMLAnchorElement> searchButton = a().css("js-right-sidebar").add(Icons.ALL.search());
        searchButton.on(EventType.click, event -> search.open());
        layout.getTopBar()
                .appendChild(li().css(Styles.pull_right).add(searchButton).asElement());
        layout.getTopBar().appendChild(li().css(Styles.pull_right).style("padding-top: 3px;").add(makeGithubLink()).asElement());
        layout.showFooter();
        HTMLDivElement copyrightsElement = div()
                .css(Theme.currentTheme.getScheme().darker_3().getBackground())
                .css(Styles.align_center)
                .add(p().style("line-height: 45px; height: 45px; margin: 0px;")
                        .textContent("© 2018 Copyright DominoKit")).asElement();

        Row footerRow = Row.create()
                .style()
                .setMargin("0px")
                .add("demo-footer")
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
                                "<input type=\"hidden\" name=\"cmd\" value=\"_s-xclick\">\n" +
                                "<input type=\"hidden\" name=\"hosted_button_id\" value=\"H4SM3EKUT4C7E\">\n" +
                                "<input type=\"image\" src=\"https://www.paypalobjects.com/en_US/i/btn/btn_donateCC_LG.gif\" border=\"0\" name=\"submit\" alt=\"PayPal - The safer, easier way to pay online!\">\n" +
                                "<img alt=\"\" border=\"0\" src=\"https://www.paypalobjects.com/en_US/i/scr/pixel.gif\" width=\"1\" height=\"1\">\n" +
                                "</form>").toSafeHtml()))
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

        layout.getFooter().appendChild(footerRow);
        layout.getFooter().appendChild(copyrightsElement);
        Theme.addThemeChangeHandler((oldTheme, newTheme) -> Style.of(copyrightsElement)
                .remove(oldTheme.getScheme().darker_3().getBackground())
                .add(newTheme.getScheme().darker_3().getBackground()));

    }

    private HTMLAnchorElement makeGithubLink() {
        HTMLAnchorElement githubLink = a().css("fab fa-github fa-2x", "js-right-sidebar").asElement();
        githubLink.addEventListener("click", evt -> DomGlobal.window.open("https://github.com/DominoKit/domino-ui", "_blank"));
        return githubLink;
    }

    @Override
    public void addActionItem(String iconName, LayoutContext.SelectionHandler selectionHandler) {
        HTMLElement actionItem = layout.addActionItem(Icon.create(iconName));
        actionItem.addEventListener("click", evt -> selectionHandler.onSelected());
    }

    @Override
    public void setRightPanelContent(Content content) {
        if (nonNull(rightPanelContent) && !rightPanelContent.equals(content))
            layout.getRightPanel().removeChild(Js.cast(rightPanelContent.get()));

        rightPanelContent = content;
        layout.getRightPanel().appendChild((HTMLElement)Js.cast(content.get()));
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
    public Content getRightPanel() {
        return (Content<HTMLElement>) () -> layout.getRightPanel().asElement();
    }

    @Override
    public Content getLeftPanel() {
        return (Content<HTMLElement>) () -> layout.getLeftPanel().asElement();
    }

    @Override
    public Content getContentPanel() {
        return (Content<HTMLDivElement>) () -> layout.getContentPanel().asElement();
    }

    @Override
    public Content getTopBar() {
        return (Content<HTMLElement>) () -> layout.getTopBar().asElement();
    }

    @Override
    public IsLayout setTitle(String title) {
        layout.setTitle(title);
        return this;
    }

    @Override
    public Content addActionItem(String icon) {
        return (Content<HTMLElement>) () -> layout.addActionItem(Icon.create(icon));
    }

    @Override
    public IsLayout show() {
        layout.show();
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
}