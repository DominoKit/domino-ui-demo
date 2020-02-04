package org.dominokit.domino.gridLayout.client.views.ui;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.SampleClass;
import org.dominokit.domino.SampleMethod;
import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.domino.componentcase.client.ui.views.CodeCard;
import org.dominokit.domino.componentcase.client.ui.views.LinkToSourceCode;
import org.dominokit.domino.gridLayout.client.presenters.GridLayoutProxy;
import org.dominokit.domino.gridLayout.client.views.GridLayoutView;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.code.Code;
import org.dominokit.domino.ui.forms.CheckBox;
import org.dominokit.domino.ui.grid.Column;
import org.dominokit.domino.ui.grid.GridLayout;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.grid.SectionSpan;
import org.dominokit.domino.ui.header.BlockHeader;
import org.dominokit.domino.ui.sliders.Slider;
import org.dominokit.domino.componentcase.client.ui.views.BaseDemoView;

import static org.jboss.elemento.Elements.*;

@UiView(presentable = GridLayoutProxy.class)
public class GridLayoutViewImpl extends BaseDemoView<HTMLDivElement> implements GridLayoutView {

    private HTMLDivElement element;

    @Override
    protected HTMLDivElement init() {
        element = div().element();

        element.appendChild(LinkToSourceCode.create("gridLayout", this.getClass()).element());
        element.appendChild(BlockHeader.create("GRID LAYOUT", "12 Columns based custom layout.").element());
        initLayoutSamples();

        return element;
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

        gridLayout.getContentElement().appendChild(span().textContent("Content").element());
        gridLayout.getHeaderElement().appendChild(span().textContent("Header").element());
        gridLayout.getFooterElement().appendChild(span().textContent("Footer").element());
        gridLayout.getLeftElement().appendChild(span().textContent("Left").element());
        gridLayout.getRightElement().appendChild(span().textContent("Right").element());

        Slider headerSlider = Slider.create(6, 0, 0)
                .withThumb()
                .setStep(1);
        headerSlider.addChangeHandler(value -> {
            if (value == 0) {
                gridLayout.hideHeader();
            } else {
                gridLayout.setHeaderSpan(SectionSpan.valueOf("_" + value));
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
                        gridLayout.setLeftSpan(SectionSpan.valueOf("_" + leftSlider.getValue()), value, leftSpanDownCheck.getValue());
                    }
                });

        leftSpanDownCheck
                .addChangeHandler(value -> {
                    if (leftSlider.getValue() > 0) {
                        gridLayout.setLeftSpan(SectionSpan.valueOf("_" + leftSlider.getValue()), leftSpanUpCheck.getValue(), value);
                    }
                });
        leftSlider.addChangeHandler(value -> {
            if (value == 0) {
                gridLayout.hideLeft();
            } else {
                gridLayout.setLeftSpan(SectionSpan.valueOf("_" + value), leftSpanUpCheck.getValue(), leftSpanDownCheck.getValue());
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
                        gridLayout.setRightSpan(SectionSpan.valueOf("_" + rightSlider.getValue()), value, rightSpanDownCheck.getValue());
                    }
                });

        rightSpanDownCheck
                .addChangeHandler(value -> {
                    if (rightSlider.getValue() > 0) {
                        gridLayout.setRightSpan(SectionSpan.valueOf("_" + rightSlider.getValue()), rightSpanUpCheck.getValue(), value);
                    }
                });
        rightSlider.addChangeHandler(value -> {
            if (value == 0) {
                gridLayout.hideRight();
            } else {
                gridLayout.setRightSpan(SectionSpan.valueOf("_" + value), rightSpanUpCheck.getValue(), rightSpanDownCheck.getValue());
            }
        });


        Slider footerSlider = Slider.create(6, 0, 0)
                .withThumb()
                .setStep(1);
        footerSlider.addChangeHandler(value -> {
            if (value == 0) {
                gridLayout.hideFooter();
            } else {
                gridLayout.setFooterSpan(SectionSpan.valueOf("_" + value));
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
                .element());
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