package org.dominokit.domino.gridLayout.client.views.ui;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.domino.componentcase.client.ui.views.BaseDemoView;
import org.dominokit.domino.componentcase.client.ui.views.CodeCard;
import org.dominokit.domino.componentcase.client.ui.views.LinkToSourceCode;
import org.dominokit.domino.gridLayout.client.presenters.GridLayoutProxy;
import org.dominokit.domino.gridLayout.client.views.GridLayoutView;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.forms.CheckBox;
import org.dominokit.domino.ui.grid.Column;
import org.dominokit.domino.ui.grid.GridLayout;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.grid.SectionSpan;
import org.dominokit.domino.ui.sliders.Slider;
import org.dominokit.domino.ui.typography.BlockHeader;

@UiView(presentable = GridLayoutProxy.class)
public class GridLayoutViewImpl extends BaseDemoView<HTMLDivElement> implements GridLayoutView {

    private DivElement element;

    @Override
    protected HTMLDivElement init() {
        element = div();

        element.appendChild(LinkToSourceCode.createLink("gridLayout", this.getClass()).element());
        element.appendChild(BlockHeader.create("GRID LAYOUT", "12 Columns based custom layout.").element());
        initLayoutSamples();

        return element.element();
    }

    private void initLayoutSamples() {
        GridLayout gridLayout = GridLayout.create()
                .setHeight("500px");

        gridLayout
                .withContent((parent, content) -> content
                        .addCss("demo-layout-section", "demo-content")
                        .appendChild(span().textContent("Content"))
                )
                .withHeader((parent, header) -> header
                        .addCss("demo-layout-section", "demo-header")
                        .appendChild(span().textContent("Header"))
                )
                .withFooter((parent, footer) -> footer
                        .addCss("demo-layout-section", "demo-l-footer")
                        .appendChild(span().textContent("Footer"))
                )
                .withLeftPanel((parent, leftPanel) -> leftPanel
                        .addCss("demo-layout-section", "demo-left")
                        .appendChild(span().textContent("Left"))
                )
                .withRightPanel((parent, rightPanel) -> rightPanel
                        .addCss("demo-layout-section", "demo-right")
                        .appendChild(span().textContent("Right"))
                );



        Slider headerSlider = Slider.create(6, 0, 1)
                .withThumb()
                .setStep(1);
        headerSlider.addChangeListener((oldValue, newValue) -> {
                gridLayout.setHeaderSpan(SectionSpan.valueOf("_" + newValue));
        });

        Slider leftSlider = Slider.create(6, 0, 3)
                .withThumb()
                .setStep(1);
        CheckBox leftSpanUpCheck = CheckBox.create("Span Up");
        CheckBox leftSpanDownCheck = CheckBox.create("Span Down");
        leftSpanUpCheck
                .addChangeListener((oldValue, newValue) -> {
                        gridLayout.setLeftSpan(SectionSpan.valueOf("_" + leftSlider.getValue()), newValue, leftSpanDownCheck.getValue());
                });

        leftSpanDownCheck
                .addChangeListener((oldValue, newValue) -> {
                        gridLayout.setLeftSpan(SectionSpan.valueOf("_" + leftSlider.getValue()), leftSpanUpCheck.getValue(), newValue);
                });
        leftSlider.addChangeListener((oldValue, newValue) -> {
                gridLayout.setLeftSpan(SectionSpan.valueOf("_" + newValue), leftSpanUpCheck.getValue(), leftSpanDownCheck.getValue());
        });


        Slider rightSlider = Slider.create(6, 0, 3)
                .withThumb()
                .setStep(1);
        CheckBox rightSpanUpCheck = CheckBox.create("Span Up");
        CheckBox rightSpanDownCheck = CheckBox.create("Span Down");
        rightSpanUpCheck
                .addChangeListener((oldValue, newValue) -> {
                        gridLayout.setRightSpan(SectionSpan.valueOf("_" + rightSlider.getValue()), newValue, rightSpanDownCheck.getValue());
                });

        rightSpanDownCheck
                .addChangeListener((oldValue, newValue) -> {
                        gridLayout.setRightSpan(SectionSpan.valueOf("_" + rightSlider.getValue()), rightSpanUpCheck.getValue(), newValue);
                });
        rightSlider.addChangeListener((oldValue, newValue) -> {
                gridLayout.setRightSpan(SectionSpan.valueOf("_" + newValue), rightSpanUpCheck.getValue(), rightSpanDownCheck.getValue());
        });


        Slider footerSlider = Slider.create(6, 0, 1)
                .withThumb()
                .setStep(1);
        footerSlider.addChangeListener((oldValue, newValue) -> {
                gridLayout.setFooterSpan(SectionSpan.valueOf("_" + newValue));
        });

        Slider gapSlider = Slider.create(10, 0, 0)
                .withThumb()
                .setStep(1)
                .addChangeListener((oldValue, newValue) -> gridLayout.setGap(newValue + "px"));

        element.appendChild(Card.create()
                .appendChild(Row.create()
                        .appendChild(Column.span2()
                                .appendChild(headerSlider)
                                .appendChild(h(5).textContent("Header")))
                        .appendChild(Column.span2()
                                .appendChild(leftSlider)
                                .appendChild(h(5).textContent("Left"))
                                .appendChild(leftSpanUpCheck)
                                .appendChild(leftSpanDownCheck)
                        )
                        .appendChild(Column.span2()
                                .appendChild(rightSlider)
                                .appendChild(h(5).textContent("Right"))
                                .appendChild(rightSpanUpCheck)
                                .appendChild(rightSpanDownCheck)
                        )
                        .appendChild(Column.span2()
                                .appendChild(footerSlider)
                                .appendChild(h(5).textContent("Footer"))
                        )
                        .appendChild(Column.span2()
                                .appendChild(gapSlider)
                                .appendChild(h(5).textContent("Gap"))
                        )
                )
                .appendChild(gridLayout)
                .element());
        element.appendChild(Card.create("USAGE")
                .appendChild(BlockHeader.create("Basic", "Grid layout is a 12 columns grid based layout with a content section and another 4 optional sections: Header. Footer, Left and Right. ")
                        .appendChild(a().setAttribute("href", "https://developer.mozilla.org/en-US/docs/Web/CSS/grid")
                                .textContent("Please checkout css grid on MDN"))
                        .appendChild(br()))
                .appendChild(h(5).textContent("The GridLayout is a single div element that can hold up to 5 other divs for each section"))
                .appendChild(br())
                .appendChild(h(5).textContent("The Content"))
                .appendChild(h(6).textContent("Content section is the only section in the GridLayout by default, it covers all 12 rows and columns of the grid by default."))
                .appendChild(br())
                .appendChild(h(5).textContent("Creating a grid layout"))
                .appendChild(CodeCard.preBlock("GridLayout gridLayout = GridLayout.create()\n" +
                        "                .style()\n" +
                        "                .setHeight(\"500px\").get();"))
                .appendChild(h(6).textContent("This will create a gridlayout of 500px."))
                .appendChild(br())
                .appendChild(h(5).textContent("Changing a section size"))
                .appendChild(CodeCard.preBlock("gridLayout.setHeaderSpan(SectionSpan._2);\n" +
                        "gridLayout.setLeftSpan(SectionSpan._3);\n" +
                        "gridLayout.setRightSpan(SectionSpan._4);\n" +
                        "gridLayout.setFooterSpan(SectionSpan._2);"))
                .appendChild(h(6).textContent("You can span a section to cover up to 6 rows or columns."))
                .appendChild(br())
                .appendChild(h(4).textContent("Adding elements to the gridLayout sections"))
                .appendChild(br())
                .appendChild(CodeCard.preBlock("gridLayout.getContentElement().appendChild(otherElement);\n" +
                        "gridLayout.getHeaderElement().appendChild(otherElement);\n" +
                        "gridLayout.getLeftElement().appendChild(otherElement);\n" +
                        "gridLayout.getRightElement().appendChild(otherElement);\n" +
                        "gridLayout.getFooterElement().appendChild(otherElement);\n"))
                .appendChild(h(6).textContent("You have to span a section to make the appended elements show up."))
                .appendChild(br())
                .appendChild(h(5).textContent("Hiding a section"))
                .appendChild(CodeCard.preBlock("gridLayout.hideHeader();\n" +
                        "gridLayout.hideLeft();\n" +
                        "gridLayout.hideRight();\n" +
                        "gridLayout.hideFooter();\n"))
                .appendChild(h(6).textContent("You can hide all sections except the content section."))
                .appendChild(br())

                .element());

    }
}