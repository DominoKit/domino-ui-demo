package org.dominokit.domino.gridLayout.client.views.ui;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.componentcase.shared.extension.ComponentView;
import org.dominokit.domino.gridLayout.client.views.GridLayoutView;
import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.domino.gridLayout.client.presenters.GridLayoutPresenter;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.code.Code;
import org.dominokit.domino.ui.forms.CheckBox;
import org.dominokit.domino.ui.grid.Column;
import org.dominokit.domino.ui.grid.GridLayout;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.grid.SectionSpan;
import org.dominokit.domino.ui.header.BlockHeader;
import org.dominokit.domino.ui.sliders.Slider;
import org.dominokit.domino.ui.style.Style;

import static org.jboss.gwt.elemento.core.Elements.*;
import static org.jboss.gwt.elemento.core.Elements.br;

@UiView(presentable = GridLayoutPresenter.class)
public class GridLayoutViewImpl extends ComponentView<HTMLDivElement> implements GridLayoutView{

    private HTMLDivElement element = div().asElement();

    @Override
    public void init() {
        element.appendChild(BlockHeader.create("GRID LAYOUT", "12 Columns based custom layout.").asElement());
        initLayoutSamples();
    }

    private void initLayoutSamples() {
        GridLayout gridLayout = GridLayout.create()
                .style()
                .setHeight("500px").get();

        gridLayout.getContentElement().style().add("demo-layout-section", "demo-content");
        gridLayout.getHeaderElement().style().add("demo-layout-section", "demo-header");
        gridLayout.getFooterElement().style().add("demo-layout-section", "demo-l-footer");
        gridLayout.getLeftElement().style().add("demo-layout-section", "demo-left");
        gridLayout.getRightElement().style().add("demo-layout-section", "demo-right");

        gridLayout.getContentElement().appendChild(span().textContent("Content").asElement());
        gridLayout.getHeaderElement().appendChild(span().textContent("Header").asElement());
        gridLayout.getFooterElement().appendChild(span().textContent("Footer").asElement());
        gridLayout.getLeftElement().appendChild(span().textContent("Left").asElement());
        gridLayout.getRightElement().appendChild(span().textContent("Right").asElement());

        Slider headerSlider = Slider.create(6, 0, 0)
                .withThumb()
                .setStep(1);
        headerSlider.addChangeHandler(value -> {
            if (value == 0) {
                gridLayout.removeHeader();
            } else {
                gridLayout.addHeader(SectionSpan.valueOf("_" + value));
            }
        });

        Slider leftSlider = Slider.create(6, 0, 0)
                .withThumb()
                .setStep(1);
        CheckBox leftSpanUpCheck = CheckBox.create("Span Up");
        CheckBox leftSpanDownCheck = CheckBox.create("Span Down");
        leftSpanUpCheck
                .addChangeHandler(value -> {
                    if (leftSlider.getValue() > 0) {
                        gridLayout.addLeft(SectionSpan.valueOf("_" + leftSlider.getValue()), value, leftSpanDownCheck.getValue());
                    }
                });

        leftSpanDownCheck
                .addChangeHandler(value -> {
                    if (leftSlider.getValue() > 0) {
                        gridLayout.addLeft(SectionSpan.valueOf("_" + leftSlider.getValue()), leftSpanUpCheck.getValue(), value);
                    }
                });
        leftSlider.addChangeHandler(value -> {
            if (value == 0) {
                gridLayout.removeLeft();
            } else {
                gridLayout.addLeft(SectionSpan.valueOf("_" + value), leftSpanUpCheck.getValue(), leftSpanDownCheck.getValue());
            }
        });


        Slider rightSlider = Slider.create(6, 0, 0)
                .withThumb()
                .setStep(1);
        CheckBox rightSpanUpCheck = CheckBox.create("Span Up");
        CheckBox rightSpanDownCheck = CheckBox.create("Span Down");
        rightSpanUpCheck
                .addChangeHandler(value -> {
                    if (rightSlider.getValue() > 0) {
                        gridLayout.addRight(SectionSpan.valueOf("_" + rightSlider.getValue()), value, rightSpanDownCheck.getValue());
                    }
                });

        rightSpanDownCheck
                .addChangeHandler(value -> {
                    if (rightSlider.getValue() > 0) {
                        gridLayout.addRight(SectionSpan.valueOf("_" + rightSlider.getValue()), rightSpanUpCheck.getValue(), value);
                    }
                });
        rightSlider.addChangeHandler(value -> {
            if (value == 0) {
                gridLayout.removeRight();
            } else {
                gridLayout.addRight(SectionSpan.valueOf("_" + value), rightSpanUpCheck.getValue(), rightSpanDownCheck.getValue());
            }
        });


        Slider footerSlider = Slider.create(6, 0, 0)
                .withThumb()
                .setStep(1);
        footerSlider.addChangeHandler(value -> {
            if (value == 0) {
                gridLayout.removeFooter();
            } else {
                gridLayout.addFooter(SectionSpan.valueOf("_" + value));
            }
        });

        Slider gapSlider = Slider.create(10, 0, 0)
                .withThumb()
                .setStep(1)
                .addChangeHandler(value -> gridLayout.setGap(value + "px"));

        element.appendChild(Card.create()
                .appendChild(Row.create()
                        .addColumn(Column.span2()
                                .appendChild(headerSlider)
                                .appendChild(h(5).textContent("Header")))
                        .addColumn(Column.span2()
                                .appendChild(leftSlider)
                                .appendChild(h(5).textContent("Left"))
                                .appendChild(leftSpanUpCheck)
                                .appendChild(leftSpanDownCheck)
                        )
                        .addColumn(Column.span2()
                                .appendChild(rightSlider)
                                .appendChild(h(5).textContent("Right"))
                                .appendChild(rightSpanUpCheck)
                                .appendChild(rightSpanDownCheck)
                        )
                        .addColumn(Column.span2()
                                .appendChild(footerSlider)
                                .appendChild(h(5).textContent("Footer"))
                        )
                        .addColumn(Column.span2()
                                .appendChild(gapSlider)
                                .appendChild(h(5).textContent("Gap"))
                        )
                )
                .appendChild(gridLayout)
                .asElement());
        element.appendChild(Card.create("USAGE")
                .appendChild(BlockHeader.create("Basic", "Grid layout is a 12 columns grid based layout with a content section and another 4 optional sections: Header. Footer, Left and Right. ")
                .appendChild(a().attr("href", "https://developer.mozilla.org/en-US/docs/Web/CSS/grid")
                        .textContent("Please checkout css grid on MDN"))
                .appendChild(br()))
                .appendChild(h(5).textContent("The GridLayout is a single div element that can hold up to 5 other divs for each section"))
                .appendChild(br())
                .appendChild(h(5).textContent("The Content"))
                .appendChild(h(6).textContent("Content section is the only section in the GridLayout by default, it covers all 12 rows and columns of the grid by default."))
                .appendChild(br())
                .appendChild(h(5).textContent("Changing the default theme"))
                .appendChild(Code.block("Layout.create(\"App title\").show(ColorScheme.PINK);"))
                .appendChild(h(6).textContent("This will add the layout with pink theme."))
                .appendChild(br())
                .appendChild(h(5).textContent("Adding elements to navigation bar right side"))
                .appendChild(Code.block("layout.getTopBar().appendChild(li().add(a().add(Icons.ALL.style())).asElement());"))
                .appendChild(h(6).textContent("This will add an icon to the right of the navigation bar."))
                .appendChild(br())
                .appendChild(h(4).textContent("Left panel"))
                .appendChild(br())
                .appendChild(h(5).textContent("By default the left panel is closed and the navigation bar has a toggle button - 2 - to open/close it."))
                .appendChild(h(5).textContent("You can show/hide the left panel programmatically"))
                .appendChild(Code.block("layout.showLeftPanel();\n" +
                        "layout.hideLeftPanel();"))
                .appendChild(h(6).textContent("By default left appear over the content and when open an overlay appears to block the center contents."))
                .appendChild(br())
                .appendChild(h(5).textContent("Fix the left panel position"))
                .appendChild(Code.block("layout.fixLeftPanelPosition();"))
                .appendChild(h(6).textContent("Fixing the left panel position will make it always visible, hide the navigation bar toggle button, push and narrow the center content and wont block the center content with an overlay."))
                .appendChild(br())
                .appendChild(h(5).textContent("UnFix the left panel position"))
                .appendChild(Code.block("layout.unfixLeftPanelPosition();"))
                .appendChild(h(6).textContent("This will revert the left panel to its default behavior."))
                .appendChild(h(6).textContent("Use the media queries to fix/unfix the left panel for different devices."))
                .appendChild(br())
                .appendChild(h(5).textContent("Add content to the left panel"))
                .appendChild(Code.block("layout.getLeftPanel()\n" +
                        "                .appendChild(Tree.create(\"Menu\")\n" +
                        "                        .addTreeItem(TreeItem.create(\"Item1\", Icons.ALL.folder()))\n" +
                        "                        .addTreeItem(TreeItem.create(\"Item 2\", Icons.ALL.description()))\n" +
                        "                        .asElement());"))
                .appendChild(h(6).textContent("This will append a tree to the left panel, you can append any element of any kind."))
                .appendChild(br())
                .appendChild(h(4).textContent("Center panel"))
                .appendChild(br())
                .appendChild(h(5).textContent("Add content to the center panel"))
                .appendChild(Code.block("layout.getContentPanel()\n" +
                        "                .appendChild(BlockHeader.create(\"Title\", \"Some description\")\n" +
                        "                        .asElement());"))
                .appendChild(h(6).textContent("This wil add a block header to the center panel."))
                .appendChild(br())
                .appendChild(h(5).textContent("Clear the center panel"))
                .appendChild(Code.block("ElementUtil.clear(layout.getContentPanel());"))
                .appendChild(h(6).textContent("This will remove all added content from the center panel."))
                .appendChild(br())
                .appendChild(h(4).textContent("Right panel"))
                .appendChild(h(6).textContent("Right panel is hidden by default and there is no button to show/hide it, but can be controlled programmatically"))
                .appendChild(br())
                .appendChild(h(5).textContent("Show/Hide right panel"))
                .appendChild(Code.block("layout.showRightPanel();\n" +
                        "        layout.hideRightPanel();"))
                .appendChild(h(6).textContent("Showing the right panel will automatically hide the left panel unless it is fixed."))
                .appendChild(h(6).textContent("Showing the left panel will automatically hide the right panel unless the left panel is fixed."))
                .appendChild(h(6).textContent("Right panel position can not be fixed."))
                .appendChild(h(6).textContent("Show Right panel will always cover the center content and block it with an overlay."))
                .appendChild(br())
                .appendChild(h(5).textContent("Adding content the right panel"))
                .appendChild(Code.block("layout.getRightPanel()\n" +
                        "                .appendChild(BlockHeader.create(\"Settings\", \"System configurations\")\n" +
                        "                        .asElement());"))
                .appendChild(h(6).textContent("Right panel allows adding any element of any kind."))
                .appendChild(br())
                .appendChild(h(5).textContent("Clear the right panel"))
                .appendChild(Code.block("ElementUtil.clear(layout.getRightPanel());"))
                .appendChild(h(6).textContent("This will remove all added content from the right panel."))
                .appendChild(br())
                .appendChild(h(4).textContent("Footer"))
                .appendChild(h(6).textContent("Footer is hidden by default."))
                .appendChild(br())
                .appendChild(h(5).textContent("Show/Hide footer"))
                .appendChild(Code.block("layout.showFooter();\n" +
                        "        layout.hideFooter();"))
                .appendChild(h(6).textContent("by default adding content to the center panel will push the footer down."))
                .appendChild(h(6).textContent("when there is little content in the center panel the footer will stick to the bottom of the window."))
                .appendChild(br())
                .appendChild(h(5).textContent("Fix the footer position"))
                .appendChild(Code.block("layout.fixFooter();"))
                .appendChild(h(6).textContent("Fixing the footer will make it always visible at the bottom of the window and the content of the center panel will scroll beyond it"))
                .appendChild(br())
                .appendChild(h(5).textContent("Adding content to the footer"))
                .appendChild(Code.block("layout.getFooter()\n" +
                        "                .appendChild(p().textContent(\"© 2018 Copyright DominoKit\"));"))
                .appendChild(h(6).textContent("The footer allows adding any element of any kind"))

                .asElement());

    }


    @Override
    public HTMLDivElement getElement() {
        return element;
    }
}