package org.dominokit.domino.helpers.client.views.ui;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.SampleClass;
import org.dominokit.domino.SampleMethod;
import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.domino.componentcase.client.ui.views.CodeCard;
import org.dominokit.domino.componentcase.client.ui.views.LinkToSourceCode;
import org.dominokit.domino.helpers.client.presenters.HelpersProxy;
import org.dominokit.domino.helpers.client.views.HelpersView;
import org.dominokit.domino.ui.Typography.Paragraph;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.grid.Column;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.header.BlockHeader;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.style.Styles;
import org.dominokit.domino.ui.utils.TextNode;
import org.dominokit.domino.componentcase.client.ui.views.BaseDemoView;

import static org.jboss.elemento.Elements.*;

@UiView(presentable = HelpersProxy.class)
@SampleClass
public class HelpersViewImpl extends BaseDemoView<HTMLDivElement> implements HelpersView {

    private static final String SAMPLE_TEXT = "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";
    private HTMLDivElement element = div().element();

    @Override
    protected HTMLDivElement init() {

        element.appendChild(LinkToSourceCode.create("helpers", this.getClass()).element());
        element.appendChild(BlockHeader.create("HELPER CLASSES").element());

        textStyles();
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.textStyles())
                .element());

        fontSize();
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.fontSize())
                .element());

        textAligns();
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.textAligns())
                .element());

        marginAndPaddingSpaces();
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.marginAndPaddingSpaces())
                .element());

        return element;
    }

    @SampleMethod
    private void textStyles() {

        element.appendChild(Card.create("TEXT STYLES", "Use ready classes to style your paragraphs.")
                .appendChild(Row.create()
                        .addColumn(Column.span2()
                                .appendChild(Paragraph.create().appendChild(b().textContent("Normal")))
                                .appendChild(Paragraph.create("Default text"))
                                .appendChild(Paragraph.create("Text pink color").setColor(Color.PINK))
                                .appendChild(Paragraph.create("Text cyan color").setColor(Color.CYAN))
                                .appendChild(Paragraph.create("Text teal color").setColor(Color.TEAL))
                                .appendChild(Paragraph.create("Text orange color").setColor(Color.ORANGE))
                                .appendChild(Paragraph.create("Text blue grey color").setColor(Color.BLUE_GREY))
                        )

                        .addColumn(Column.span2()
                                .appendChild(Paragraph.create().appendChild(b().textContent("Bold")))
                                .appendChild(Paragraph.create("Default text").bold())
                                .appendChild(Paragraph.create("Text pink color").bold().setColor(Color.PINK))
                                .appendChild(Paragraph.create("Text cyan color").bold().setColor(Color.CYAN))
                                .appendChild(Paragraph.create("Text teal color").bold().setColor(Color.TEAL))
                                .appendChild(Paragraph.create("Text orange color").bold().setColor(Color.ORANGE))
                                .appendChild(Paragraph.create("Text blue grey color").bold().setColor(Color.BLUE_GREY))
                        )

                        .addColumn(Column.span2()
                                .appendChild(Paragraph.create().appendChild(b().textContent("Italic")))
                                .appendChild(Paragraph.create("Default text").italic())
                                .appendChild(Paragraph.create("Text pink color").italic().setColor(Color.PINK))
                                .appendChild(Paragraph.create("Text cyan color").italic().setColor(Color.CYAN))
                                .appendChild(Paragraph.create("Text teal color").italic().setColor(Color.TEAL))
                                .appendChild(Paragraph.create("Text orange color").italic().setColor(Color.ORANGE))
                                .appendChild(Paragraph.create("Text blue grey color").italic().setColor(Color.BLUE_GREY))
                        )

                        .addColumn(Column.span2()
                                .appendChild(Paragraph.create().appendChild(b().textContent("Underline")))
                                .appendChild(Paragraph.create("Default text").underLine())
                                .appendChild(Paragraph.create("Text pink color").underLine().setColor(Color.PINK))
                                .appendChild(Paragraph.create("Text cyan color").underLine().setColor(Color.CYAN))
                                .appendChild(Paragraph.create("Text teal color").underLine().setColor(Color.TEAL))
                                .appendChild(Paragraph.create("Text orange color").underLine().setColor(Color.ORANGE))
                                .appendChild(Paragraph.create("Text blue grey color").underLine().setColor(Color.BLUE_GREY))
                        )

                        .addColumn(Column.span2()
                                .appendChild(Paragraph.create().appendChild(b().textContent("Line through")))
                                .appendChild(Paragraph.create("Default text").lineThrough())
                                .appendChild(Paragraph.create("Text pink color").lineThrough().setColor(Color.PINK))
                                .appendChild(Paragraph.create("Text cyan color").lineThrough().setColor(Color.CYAN))
                                .appendChild(Paragraph.create("Text teal color").lineThrough().setColor(Color.TEAL))
                                .appendChild(Paragraph.create("Text orange color").lineThrough().setColor(Color.ORANGE))
                                .appendChild(Paragraph.create("Text blue grey color").lineThrough().setColor(Color.BLUE_GREY))
                        )

                        .addColumn(Column.span2()
                                .appendChild(Paragraph.create().appendChild(b().textContent("Over line")))
                                .appendChild(Paragraph.create("Default text").overLine())
                                .appendChild(Paragraph.create("Text pink color").overLine().setColor(Color.PINK))
                                .appendChild(Paragraph.create("Text cyan color").overLine().setColor(Color.CYAN))
                                .appendChild(Paragraph.create("Text teal color").overLine().setColor(Color.TEAL))
                                .appendChild(Paragraph.create("Text orange color").overLine().setColor(Color.ORANGE))
                                .appendChild(Paragraph.create("Text blue grey color").overLine().setColor(Color.BLUE_GREY))
                        )
                        )
                .element());


    }

    @SampleMethod
    private void fontSize() {

        element.appendChild(Card.create("FONT SIZES", "Use ready classes to change text font size.")
                .appendChild(Row.create()
                        .addColumn(Column.span2().appendChild(div().css(Styles.font_6).textContent("font-6")))
                        .addColumn(Column.span2().appendChild(div().css(Styles.font_10).textContent("font-10")))
                        .addColumn(Column.span2().appendChild(div().css(Styles.font_12).textContent("font-12")))
                        .addColumn(Column.span2().appendChild(div().css(Styles.font_15).textContent("font-15")))
                        .addColumn(Column.span2().appendChild(div().css(Styles.font_20).textContent("font-20")))
                        .addColumn(Column.span2().appendChild(div().css(Styles.font_24).textContent("font-24")))
                        )
                .appendChild(Row.create()
                        .addColumn(Column.span2().appendChild(div().css(Styles.font_32).textContent("font-32")))
                        .addColumn(Column.span2().appendChild(div().css(Styles.font_40).textContent("font-40")))
                        .addColumn(Column.span2().appendChild(div().css(Styles.font_42).textContent("font-42")))
                        .addColumn(Column.span2().appendChild(div().css(Styles.font_45).textContent("font-45")))
                        .addColumn(Column.span2().appendChild(div().css(Styles.font_48).textContent("font-48")))
                        .addColumn(Column.span2().appendChild(div().css(Styles.font_50).textContent("font-50")))
                        )
                .element());


    }

    @SampleMethod
    private void textAligns() {

        element.appendChild(Card.create("TEXT ALIGNS", "You can use ready classes to change text alignment.")
                .appendChild(Row.create()
                        .addColumn(Column.span3()
                                .appendChild(Paragraph.create().appendChild(b().textContent("Align left")).alignLeft())
                                .appendChild(div().css(Styles.align_left).textContent(SAMPLE_TEXT))
                        )
                        .addColumn(Column.span3()
                                .appendChild(Paragraph.create().appendChild(b().textContent("Align center")).alignCenter())
                                .appendChild(div().css(Styles.align_center).textContent(SAMPLE_TEXT))
                        )
                        .addColumn(Column.span3()
                                .appendChild(Paragraph.create().appendChild(b().textContent("Align right")).alignRight())
                                .appendChild(div().css(Styles.align_right).textContent(SAMPLE_TEXT))
                        )
                        .addColumn(Column.span3()
                                .appendChild(Paragraph.create().appendChild(b().textContent("Align justify")).alignJustify())
                                .appendChild(div().css(Styles.align_justify).textContent(SAMPLE_TEXT))
                        )
                        )
                .element());


    }

    @SampleMethod
    private void marginAndPaddingSpaces() {

        element.appendChild(Card.create("MARGIN & PADDING SPACES", "Use ready classes to apply margins and padding to your elements.")
                .appendChild(Paragraph.create().appendChild(b().textContent("Margins")))
                .appendChild(Row.create()
                        .addColumn(Column.span4()
                                .appendChild(span().css(Color.RED.getStyle(), Styles.font_bold).textContent("M"))
                                .appendChild(TextNode.of("argin "))
                                .appendChild(span().css(Color.RED.getStyle(), Styles.font_bold).textContent("T"))
                                .appendChild(TextNode.of("op "))
                                .appendChild(span().css(Color.RED.getStyle(), Styles.font_bold).textContent("10"))
                                .appendChild(TextNode.of("px → "))
                                .appendChild(code().textContent(".m-t-10"))
                        )
                        .addColumn(Column.span4()
                                .appendChild(span().css(Color.RED.getStyle(), Styles.font_bold).textContent("M"))
                                .appendChild(TextNode.of("argin "))
                                .appendChild(span().css(Color.RED.getStyle(), Styles.font_bold).textContent("T"))
                                .appendChild(TextNode.of("op "))
                                .appendChild(span().css(Color.RED.getStyle(), Styles.font_bold).textContent("0"))
                                .appendChild(TextNode.of("px → "))
                                .appendChild(code().textContent(".m-t-0"))
                        )
                        .addColumn(Column.span4()
                                .appendChild(span().css(Color.RED.getStyle(), Styles.font_bold).textContent("M"))
                                .appendChild(TextNode.of("argin "))
                                .appendChild(span().css(Color.RED.getStyle(), Styles.font_bold).textContent("T"))
                                .appendChild(TextNode.of("op "))
                                .appendChild(span().css(Color.RED.getStyle(), Styles.font_bold).textContent("-10"))
                                .appendChild(TextNode.of("px → "))
                                .appendChild(code().textContent(".m-t--10"))
                        )
                        )
                .appendChild(Row.create()
                        .addColumn(Column.span4()
                                .appendChild(span().css(Color.RED.getStyle(), Styles.font_bold).textContent("M"))
                                .appendChild(TextNode.of("argin "))
                                .appendChild(span().css(Color.RED.getStyle(), Styles.font_bold).textContent("L"))
                                .appendChild(TextNode.of("eft "))
                                .appendChild(span().css(Color.RED.getStyle(), Styles.font_bold).textContent("35"))
                                .appendChild(TextNode.of("px → "))
                                .appendChild(code().textContent(".m-l-35"))
                        )
                        .addColumn(Column.span4()
                                .appendChild(span().css(Color.RED.getStyle(), Styles.font_bold).textContent("M"))
                                .appendChild(TextNode.of("argin "))
                                .appendChild(span().css(Color.RED.getStyle(), Styles.font_bold).textContent("L"))
                                .appendChild(TextNode.of("eft "))
                                .appendChild(span().css(Color.RED.getStyle(), Styles.font_bold).textContent("0"))
                                .appendChild(TextNode.of("px → "))
                                .appendChild(code().textContent(".m-l-0"))
                        )
                        .addColumn(Column.span4()
                                .appendChild(span().css(Color.RED.getStyle(), Styles.font_bold).textContent("M"))
                                .appendChild(TextNode.of("argin "))
                                .appendChild(span().css(Color.RED.getStyle(), Styles.font_bold).textContent("L"))
                                .appendChild(TextNode.of("eft "))
                                .appendChild(span().css(Color.RED.getStyle(), Styles.font_bold).textContent("-35"))
                                .appendChild(TextNode.of("px → "))
                                .appendChild(code().textContent(".m-l--35"))
                        )
                        )
                .appendChild(Row.create()
                        .addColumn(Column.span4()
                                .appendChild(span().css(Color.RED.getStyle(), Styles.font_bold).textContent("M"))
                                .appendChild(TextNode.of("argin "))
                                .appendChild(span().css(Color.RED.getStyle(), Styles.font_bold).textContent("B"))
                                .appendChild(TextNode.of("ottom "))
                                .appendChild(span().css(Color.RED.getStyle(), Styles.font_bold).textContent("15"))
                                .appendChild(TextNode.of("px → "))
                                .appendChild(code().textContent(".m-b-15"))
                        )
                        .addColumn(Column.span4()
                                .appendChild(span().css(Color.RED.getStyle(), Styles.font_bold).textContent("M"))
                                .appendChild(TextNode.of("argin "))
                                .appendChild(span().css(Color.RED.getStyle(), Styles.font_bold).textContent("B"))
                                .appendChild(TextNode.of("ottom "))
                                .appendChild(span().css(Color.RED.getStyle(), Styles.font_bold).textContent("0"))
                                .appendChild(TextNode.of("px → "))
                                .appendChild(code().textContent(".m-b-0"))
                        )
                        .addColumn(Column.span4()
                                .appendChild(span().css(Color.RED.getStyle(), Styles.font_bold).textContent("M"))
                                .appendChild(TextNode.of("argin "))
                                .appendChild(span().css(Color.RED.getStyle(), Styles.font_bold).textContent("B"))
                                .appendChild(TextNode.of("ottom "))
                                .appendChild(span().css(Color.RED.getStyle(), Styles.font_bold).textContent("-20"))
                                .appendChild(TextNode.of("px → "))
                                .appendChild(code().textContent(".m-l--20"))
                        )
                        )
                .appendChild(Row.create()
                        .addColumn(Column.span4()
                                .appendChild(span().css(Color.RED.getStyle(), Styles.font_bold).textContent("M"))
                                .appendChild(TextNode.of("argin "))
                                .appendChild(span().css(Color.RED.getStyle(), Styles.font_bold).textContent("R"))
                                .appendChild(TextNode.of("ight "))
                                .appendChild(span().css(Color.RED.getStyle(), Styles.font_bold).textContent("30"))
                                .appendChild(TextNode.of("px → "))
                                .appendChild(code().textContent(".m-r-30"))
                        )
                        .addColumn(Column.span4()
                                .appendChild(span().css(Color.RED.getStyle(), Styles.font_bold).textContent("M"))
                                .appendChild(TextNode.of("argin "))
                                .appendChild(span().css(Color.RED.getStyle(), Styles.font_bold).textContent("R"))
                                .appendChild(TextNode.of("ight "))
                                .appendChild(span().css(Color.RED.getStyle(), Styles.font_bold).textContent("0"))
                                .appendChild(TextNode.of("px → "))
                                .appendChild(code().textContent(".m-r-0"))
                        )
                        .addColumn(Column.span4()
                                .appendChild(span().css(Color.RED.getStyle(), Styles.font_bold).textContent("M"))
                                .appendChild(TextNode.of("argin "))
                                .appendChild(span().css(Color.RED.getStyle(), Styles.font_bold).textContent("R"))
                                .appendChild(TextNode.of("ight "))
                                .appendChild(span().css(Color.RED.getStyle(), Styles.font_bold).textContent("-30"))
                                .appendChild(TextNode.of("px → "))
                                .appendChild(code().textContent(".m-r--30"))
                        )
                        )
                .appendChild(Row.create()
                        .addColumn(Column.span4()
                                .appendChild(span().css(Color.RED.getStyle(), Styles.font_bold).textContent("ALL M"))
                                .appendChild(TextNode.of("argin "))
                                .appendChild(span().css(Color.RED.getStyle(), Styles.font_bold).textContent("0"))
                                .appendChild(TextNode.of("px → "))
                                .appendChild(code().textContent(".margin-0"))
                        ))
                .appendChild(Paragraph.create().appendChild(b().textContent("Paddings")))
                .appendChild(Row.create()
                        .addColumn(Column.span3()
                                .appendChild(span().css(Color.RED.getStyle(), Styles.font_bold).textContent("P"))
                                .appendChild(TextNode.of("adding "))
                                .appendChild(span().css(Color.RED.getStyle(), Styles.font_bold).textContent("T"))
                                .appendChild(TextNode.of("op "))
                                .appendChild(span().css(Color.RED.getStyle(), Styles.font_bold).textContent("10"))
                                .appendChild(TextNode.of("px → "))
                                .appendChild(code().textContent(".p-t-10"))
                        )
                        .addColumn(Column.span3()
                                .appendChild(span().css(Color.RED.getStyle(), Styles.font_bold).textContent("P"))
                                .appendChild(TextNode.of("adding "))
                                .appendChild(span().css(Color.RED.getStyle(), Styles.font_bold).textContent("T"))
                                .appendChild(TextNode.of("op "))
                                .appendChild(span().css(Color.RED.getStyle(), Styles.font_bold).textContent("0"))
                                .appendChild(TextNode.of("px → "))
                                .appendChild(code().textContent(".p-t-0"))
                        )
                        .addColumn(Column.span3()
                                .appendChild(span().css(Color.RED.getStyle(), Styles.font_bold).textContent("P"))
                                .appendChild(TextNode.of("adding "))
                                .appendChild(span().css(Color.RED.getStyle(), Styles.font_bold).textContent("L"))
                                .appendChild(TextNode.of("eft "))
                                .appendChild(span().css(Color.RED.getStyle(), Styles.font_bold).textContent("35"))
                                .appendChild(TextNode.of("px → "))
                                .appendChild(code().textContent(".p-l-35"))
                        )
                        .addColumn(Column.span3()
                                .appendChild(span().css(Color.RED.getStyle(), Styles.font_bold).textContent("P"))
                                .appendChild(TextNode.of("adding "))
                                .appendChild(span().css(Color.RED.getStyle(), Styles.font_bold).textContent("L"))
                                .appendChild(TextNode.of("eft "))
                                .appendChild(span().css(Color.RED.getStyle(), Styles.font_bold).textContent("0"))
                                .appendChild(TextNode.of("px → "))
                                .appendChild(code().textContent(".p-l-0"))
                        )
                        )
                .appendChild(Row.create()
                        .addColumn(Column.span3()
                                .appendChild(span().css(Color.RED.getStyle(), Styles.font_bold).textContent("P"))
                                .appendChild(TextNode.of("adding "))
                                .appendChild(span().css(Color.RED.getStyle(), Styles.font_bold).textContent("B"))
                                .appendChild(TextNode.of("ottom "))
                                .appendChild(span().css(Color.RED.getStyle(), Styles.font_bold).textContent("15"))
                                .appendChild(TextNode.of("px → "))
                                .appendChild(code().textContent(".p-b-15"))
                        )
                        .addColumn(Column.span3()
                                .appendChild(span().css(Color.RED.getStyle(), Styles.font_bold).textContent("P"))
                                .appendChild(TextNode.of("adding "))
                                .appendChild(span().css(Color.RED.getStyle(), Styles.font_bold).textContent("B"))
                                .appendChild(TextNode.of("ottom "))
                                .appendChild(span().css(Color.RED.getStyle(), Styles.font_bold).textContent("0"))
                                .appendChild(TextNode.of("px → "))
                                .appendChild(code().textContent(".p-b-0"))
                        )
                        .addColumn(Column.span3()
                                .appendChild(span().css(Color.RED.getStyle(), Styles.font_bold).textContent("P"))
                                .appendChild(TextNode.of("adding "))
                                .appendChild(span().css(Color.RED.getStyle(), Styles.font_bold).textContent("R"))
                                .appendChild(TextNode.of("ight "))
                                .appendChild(span().css(Color.RED.getStyle(), Styles.font_bold).textContent("30"))
                                .appendChild(TextNode.of("px → "))
                                .appendChild(code().textContent(".p-r-30"))
                        )
                        .addColumn(Column.span3()
                                .appendChild(span().css(Color.RED.getStyle(), Styles.font_bold).textContent("P"))
                                .appendChild(TextNode.of("adding "))
                                .appendChild(span().css(Color.RED.getStyle(), Styles.font_bold).textContent("R"))
                                .appendChild(TextNode.of("ight "))
                                .appendChild(span().css(Color.RED.getStyle(), Styles.font_bold).textContent("0"))
                                .appendChild(TextNode.of("px → "))
                                .appendChild(code().textContent(".p-r-0"))
                        )
                        )
                    .appendChild(Row.create()
                        .addColumn(Column.span3()
                                .appendChild(span().css(Color.RED.getStyle(), Styles.font_bold).textContent("ALL P"))
                                .appendChild(TextNode.of("adding "))
                                .appendChild(span().css(Color.RED.getStyle(), Styles.font_bold).textContent("0"))
                                .appendChild(TextNode.of("px → "))
                                .appendChild(code().textContent(".padding-0"))
                        )
                        )
                .element());
    }
}