package org.dominokit.domino.applayout.client.views.ui;

import com.google.gwt.core.client.GWT;
import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.domino.applayout.client.presenters.AppLayoutProxy;
import org.dominokit.domino.applayout.client.views.AppLayoutView;
import org.dominokit.domino.componentcase.client.ui.views.CodeCard;
import org.dominokit.domino.componentcase.client.ui.views.LinkToSourceCode;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.code.Code;
import org.dominokit.domino.ui.grid.Column;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.header.BlockHeader;
import org.dominokit.domino.ui.style.Styles;
import org.dominokit.domino.ui.thumbnails.Thumbnail;
import org.dominokit.domino.componentcase.client.ui.views.BaseDemoView;

import static org.jboss.elemento.Elements.*;

@UiView(presentable = AppLayoutProxy.class)
public class AppLayoutViewImpl extends BaseDemoView<HTMLDivElement> implements AppLayoutView {
    private HTMLDivElement element;

    @Override
    protected HTMLDivElement init() {
        element = div().element();
        initAppLayoutSample();
        return element;
    }

    private void initAppLayoutSample() {
        element.appendChild(LinkToSourceCode.create("appLayout", this.getClass()).element());
        element.appendChild(BlockHeader.create("LAYOUT", "Default domino-ui layout has, Navigation bar - 1,2,3 -, left panel - 4 -, center panel - 5 -, hidden footer - 6 - and hidden right panel - 7 -").element());
        element.appendChild(Row.create()
                .addColumn(Column.span6()
                        .appendChild(Card.create()
                                .appendChild(Thumbnail.create()
                                        .setContent(img(GWT.getModuleBaseURL() + "images/layout/layout-1.png")
                                                .css(Styles.img_responsive)
                                                .element()))))
                .addColumn(Column.span6()
                        .appendChild(Card.create()
                                .appendChild(Thumbnail.create()
                                        .setContent(img(GWT.getModuleBaseURL() + "images/layout/layout-2.png")
                                                .css(Styles.img_responsive)
                                                .element()))))
                .element());

        element.appendChild(Card.create("USAGE")
                .appendChild(h(4).textContent("Basic"))
                .appendChild(br())
                .appendChild(h(5).textContent("Add default layout to the document body and pass the app title"))
                .appendChild(CodeCard.preBlock("Layout.create(\"App title\").show();"))
                .appendChild(h(6).textContent("This will add a layout with a navigation bar, left panel, left panel toggle, and a center panel using the default Indigo color."))
                .appendChild(br())
                .appendChild(h(5).textContent("Changing the default theme"))
                .appendChild(CodeCard.preBlock("Layout.create(\"App title\").show(ColorScheme.PINK);"))
                .appendChild(h(6).textContent("This will add the layout with pink theme."))
                .appendChild(br())
                .appendChild(h(5).textContent("Adding elements to navigation bar right side"))
                .appendChild(CodeCard.preBlock("layout.getTopBar().appendChild(li().add(a().add(Icons.ALL.style())).element());"))
                .appendChild(h(6).textContent("This will add an icon to the right of the navigation bar."))
                .appendChild(br())
                .appendChild(h(4).textContent("Left panel"))
                .appendChild(br())
                .appendChild(h(5).textContent("By default the left panel is closed and the navigation bar has a toggle button - 2 - to open/close it."))
                .appendChild(h(5).textContent("You can show/hide the left panel programmatically"))
                .appendChild(CodeCard.preBlock("layout.showLeftPanel();\n" +
                        "layout.hideLeftPanel();"))
                .appendChild(h(6).textContent("By default left appear over the content and when open an overlay appears to block the center contents."))
                .appendChild(br())
                .appendChild(h(5).textContent("Fix the left panel position"))
                .appendChild(CodeCard.preBlock("layout.fixLeftPanelPosition();"))
                .appendChild(h(6).textContent("Fixing the left panel position will make it always visible, hide the navigation bar toggle button, push and narrow the center content and wont block the center content with an overlay."))
                .appendChild(br())
                .appendChild(h(5).textContent("Disable left panel"))
                .appendChild(CodeCard.preBlock("layout.disableLeftPanel();"))
                .appendChild(h(6).textContent("Disabling the left panel will completely hide it and will also hide the navigation bar toggle button."))
                .appendChild(br())
                .appendChild(h(5).textContent("UnFix the left panel position"))
                .appendChild(CodeCard.preBlock("layout.unfixLeftPanelPosition();"))
                .appendChild(h(6).textContent("This will revert the left panel to its default behavior."))
                .appendChild(h(6).textContent("Use the media queries to fix/unfix the left panel for different devices."))
                .appendChild(br())
                .appendChild(h(5).textContent("Add content to the left panel"))
                .appendChild(CodeCard.preBlock("layout.getLeftPanel()\n" +
                        "                .appendChild(Tree.create(\"Menu\")\n" +
                        "                        .addTreeItem(TreeItem.create(\"Item1\", Icons.ALL.folder()))\n" +
                        "                        .addTreeItem(TreeItem.create(\"Item 2\", Icons.ALL.description()))\n" +
                        "                        .element());"))
                .appendChild(h(6).textContent("This will append a tree to the left panel, you can append any element of any kind."))
                .appendChild(br())
                .appendChild(h(5).textContent("Change left panel size"))
                .appendChild(CodeCard.preBlock("layout.setLeftPanelSize(LeftPanelSize.SMALL | LeftPanelSize.DEFAULT | LeftPanelSize.LARGE);"))
                .appendChild(h(6).textContent("This will change the width of the left panel."))
                .appendChild(br())
                .appendChild(h(4).textContent("Center panel"))
                .appendChild(br())
                .appendChild(h(5).textContent("Add content to the center panel"))
                .appendChild(CodeCard.preBlock("layout.getContentPanel()\n" +
                        "                .appendChild(BlockHeader.create(\"Title\", \"Some description\")\n" +
                        "                        .element());"))
                .appendChild(h(6).textContent("This wil add a block header to the center panel."))
                .appendChild(br())
                .appendChild(h(5).textContent("Clear the center panel"))
                .appendChild(CodeCard.preBlock("ElementUtil.clear(layout.getContentPanel());"))
                .appendChild(h(6).textContent("This will remove all added content from the center panel."))
                .appendChild(br())
                .appendChild(h(4).textContent("Right panel"))
                .appendChild(h(6).textContent("Right panel is hidden by default and there is no button to show/hide it, but can be controlled programmatically"))
                .appendChild(br())
                .appendChild(h(5).textContent("Show/Hide right panel"))
                .appendChild(CodeCard.preBlock("layout.showRightPanel();\n" +
                        "        layout.hideRightPanel();"))
                .appendChild(h(6).textContent("Showing the right panel will automatically hide the left panel unless it is fixed."))
                .appendChild(h(6).textContent("Showing the left panel will automatically hide the right panel unless the left panel is fixed."))
                .appendChild(h(6).textContent("Right panel position can not be fixed."))
                .appendChild(h(6).textContent("Show Right panel will always cover the center content and block it with an overlay."))
                .appendChild(br())
                .appendChild(h(5).textContent("Adding content the right panel"))
                .appendChild(CodeCard.preBlock("layout.getRightPanel()\n" +
                        "                .appendChild(BlockHeader.create(\"Settings\", \"System configurations\")\n" +
                        "                        .element());"))
                .appendChild(h(6).textContent("Right panel allows adding any element of any kind."))
                .appendChild(br())
                .appendChild(h(5).textContent("Clear the right panel"))
                .appendChild(CodeCard.preBlock("ElementUtil.clear(layout.getRightPanel());"))
                .appendChild(h(6).textContent("This will remove all added content from the right panel."))
                .appendChild(br())
                .appendChild(h(4).textContent("Footer"))
                .appendChild(h(6).textContent("Footer is hidden by default."))
                .appendChild(br())
                .appendChild(h(5).textContent("Show/Hide footer"))
                .appendChild(CodeCard.preBlock("layout.showFooter();\n" +
                        "        layout.hideFooter();"))
                .appendChild(h(6).textContent("by default adding content to the center panel will push the footer down."))
                .appendChild(h(6).textContent("when there is little content in the center panel the footer will stick to the bottom of the window."))
                .appendChild(br())
                .appendChild(h(5).textContent("Fix the footer position"))
                .appendChild(CodeCard.preBlock("layout.fixFooter();"))
                .appendChild(h(6).textContent("Fixing the footer will make it always visible at the bottom of the window and the content of the center panel will scroll beyond it"))
                .appendChild(br())
                .appendChild(h(5).textContent("Adding content to the footer"))
                .appendChild(CodeCard.preBlock("layout.getFooter()\n" +
                        "                .appendChild(p().textContent(\"© 2018 Copyright DominoKit\"));"))
                .appendChild(h(6).textContent("The footer allows adding any element of any kind"))

                .element());
    }
}