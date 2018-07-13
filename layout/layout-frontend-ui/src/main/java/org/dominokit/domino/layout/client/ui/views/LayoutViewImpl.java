package org.dominokit.domino.layout.client.ui.views;

import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import jsinterop.base.Js;
import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.domino.api.shared.extension.Content;
import org.dominokit.domino.layout.client.presenters.LayoutPresenter;
import org.dominokit.domino.layout.client.views.LayoutView;
import org.dominokit.domino.layout.shared.extension.IsLayout;
import org.dominokit.domino.layout.shared.extension.LayoutContext;
import org.dominokit.domino.ui.icons.Icon;
import org.dominokit.domino.ui.layout.Layout;

import static java.util.Objects.nonNull;

@UiView(presentable = LayoutPresenter.class)
public class LayoutViewImpl implements LayoutView {

    private Layout layout = new Layout().setTitle("Domino UI demo");

    private Content rightPanelContent;

    public LayoutViewImpl() {
        DomGlobal.document.body.style.background = "#e9e9e9";
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
        layout.getRightPanel().appendChild(Js.cast(content.get()));
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
        return (Content<HTMLElement>) () -> layout.getRightPanel();
    }

    @Override
    public Content getLeftPanel() {
        return (Content<HTMLElement>) () -> layout.getLeftPanel();
    }

    @Override
    public Content getContentPanel() {
        return (Content<HTMLDivElement>) () -> layout.getContentPanel();
    }

    @Override
    public Content getTopBar() {
        return (Content<HTMLElement>) () -> layout.getTopBar();
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