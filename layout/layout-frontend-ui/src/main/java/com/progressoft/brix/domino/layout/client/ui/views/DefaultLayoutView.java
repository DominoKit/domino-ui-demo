package com.progressoft.brix.domino.layout.client.ui.views;

import com.progressoft.brix.domino.api.client.annotations.UiView;
import com.progressoft.brix.domino.api.shared.extension.Content;
import com.progressoft.brix.domino.layout.client.presenters.LayoutPresenter;
import com.progressoft.brix.domino.layout.client.views.LayoutView;
import com.progressoft.brix.domino.layout.shared.extension.IsLayout;
import com.progressoft.brix.domino.layout.shared.extension.LayoutContext;
import com.progressoft.brix.domino.ui.icons.Icon;
import com.progressoft.brix.domino.ui.layout.Layout;
import com.progressoft.brix.domino.ui.themes.Theme;
import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import jsinterop.base.Js;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

@UiView(presentable = LayoutPresenter.class)
public class DefaultLayoutView implements LayoutView {

    private Layout layout = new Layout().setTitle("Domino UI demo");

    private Content rightPanelContent;


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
    public IsLayout show(String theme) {
        layout.show(Theme.of(theme));
        return this;
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