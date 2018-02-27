package com.progressoft.brix.domino.helpers.client.views.ui;

import com.progressoft.brix.domino.api.client.annotations.UiView;
import com.progressoft.brix.domino.api.shared.extension.Content;
import com.progressoft.brix.domino.helpers.client.presenters.HelpersPresenter;
import com.progressoft.brix.domino.helpers.client.views.HelpersView;
import com.progressoft.brix.domino.ui.Typography.Paragraph;
import com.progressoft.brix.domino.ui.cards.Card;
import com.progressoft.brix.domino.ui.column.Column;
import com.progressoft.brix.domino.ui.header.BlockHeader;
import com.progressoft.brix.domino.ui.row.Row;
import com.progressoft.brix.domino.ui.style.Color;
import com.progressoft.brix.domino.ui.style.Styles;
import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import elemental2.dom.Text;
import jsinterop.base.Js;

import static org.jboss.gwt.elemento.core.Elements.*;

@UiView(presentable = HelpersPresenter.class)
public class HelpersViewImpl implements HelpersView {

    private static final String SAMPLE_TEXT = "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";
    private final HTMLDivElement element = div().asElement();

    public HelpersViewImpl() {
        element.appendChild(BlockHeader.create("HELPER CLASSES").asElement());
        textStyles();
        fontSize();
        textAligns();
        marginAndPaddingSpaces();
    }

    private void textStyles() {
        Row row = Row.create();
        Column column = Column.create()
                .onLarge(Column.OnLarge.two)
                .onMedium(Column.OnMedium.two)
                .onSmall(Column.OnSmall.twelve)
                .onXSmall(Column.OnXSmall.twelve);

        element.appendChild(Card.create("TEXT STYLES", "Use ready classes to style your paragraphs.")
                .appendContent(row
                        .addColumn(column.copy()
                                .addElement(Paragraph.create().appendContent(b().textContent("Normal").asElement()).asElement())
                                .addElement(Paragraph.create("Default text").asElement())
                                .addElement(Paragraph.create("Text pink color").setColor(Color.PINK).asElement())
                                .addElement(Paragraph.create("Text cyan color").setColor(Color.CYAN).asElement())
                                .addElement(Paragraph.create("Text teal color").setColor(Color.TEAL).asElement())
                                .addElement(Paragraph.create("Text orange color").setColor(Color.ORANGE).asElement())
                                .addElement(Paragraph.create("Text blue grey color").setColor(Color.BLUE_GREY).asElement())
                        )

                        .addColumn(column.copy()
                                .addElement(Paragraph.create().appendContent(b().textContent("Bold").asElement()).asElement())
                                .addElement(Paragraph.create("Default text").bold().asElement())
                                .addElement(Paragraph.create("Text pink color").bold().setColor(Color.PINK).asElement())
                                .addElement(Paragraph.create("Text cyan color").bold().setColor(Color.CYAN).asElement())
                                .addElement(Paragraph.create("Text teal color").bold().setColor(Color.TEAL).asElement())
                                .addElement(Paragraph.create("Text orange color").bold().setColor(Color.ORANGE).asElement())
                                .addElement(Paragraph.create("Text blue grey color").bold().setColor(Color.BLUE_GREY).asElement())
                        )

                        .addColumn(column.copy()
                                .addElement(Paragraph.create().appendContent(b().textContent("Italic").asElement()).asElement())
                                .addElement(Paragraph.create("Default text").italic().asElement())
                                .addElement(Paragraph.create("Text pink color").italic().setColor(Color.PINK).asElement())
                                .addElement(Paragraph.create("Text cyan color").italic().setColor(Color.CYAN).asElement())
                                .addElement(Paragraph.create("Text teal color").italic().setColor(Color.TEAL).asElement())
                                .addElement(Paragraph.create("Text orange color").italic().setColor(Color.ORANGE).asElement())
                                .addElement(Paragraph.create("Text blue grey color").italic().setColor(Color.BLUE_GREY).asElement())
                        )

                        .addColumn(column.copy()
                                .addElement(Paragraph.create().appendContent(b().textContent("Underline").asElement()).asElement())
                                .addElement(Paragraph.create("Default text").underLine().asElement())
                                .addElement(Paragraph.create("Text pink color").underLine().setColor(Color.PINK).asElement())
                                .addElement(Paragraph.create("Text cyan color").underLine().setColor(Color.CYAN).asElement())
                                .addElement(Paragraph.create("Text teal color").underLine().setColor(Color.TEAL).asElement())
                                .addElement(Paragraph.create("Text orange color").underLine().setColor(Color.ORANGE).asElement())
                                .addElement(Paragraph.create("Text blue grey color").underLine().setColor(Color.BLUE_GREY).asElement())
                        )

                        .addColumn(column.copy()
                                .addElement(Paragraph.create().appendContent(b().textContent("Line through").asElement()).asElement())
                                .addElement(Paragraph.create("Default text").lineThrough().asElement())
                                .addElement(Paragraph.create("Text pink color").lineThrough().setColor(Color.PINK).asElement())
                                .addElement(Paragraph.create("Text cyan color").lineThrough().setColor(Color.CYAN).asElement())
                                .addElement(Paragraph.create("Text teal color").lineThrough().setColor(Color.TEAL).asElement())
                                .addElement(Paragraph.create("Text orange color").lineThrough().setColor(Color.ORANGE).asElement())
                                .addElement(Paragraph.create("Text blue grey color").lineThrough().setColor(Color.BLUE_GREY).asElement())
                        )

                        .addColumn(column.copy()
                                .addElement(Paragraph.create().appendContent(b().textContent("Over line").asElement()).asElement())
                                .addElement(Paragraph.create("Default text").overLine().asElement())
                                .addElement(Paragraph.create("Text pink color").overLine().setColor(Color.PINK).asElement())
                                .addElement(Paragraph.create("Text cyan color").overLine().setColor(Color.CYAN).asElement())
                                .addElement(Paragraph.create("Text teal color").overLine().setColor(Color.TEAL).asElement())
                                .addElement(Paragraph.create("Text orange color").overLine().setColor(Color.ORANGE).asElement())
                                .addElement(Paragraph.create("Text blue grey color").overLine().setColor(Color.BLUE_GREY).asElement())
                        )
                        .asElement())
                .asElement());

        element.appendChild(Card.createCodeCard("element.appendChild(Card.create(\"TEXT STYLES\", \"Use ready classes to style your paragraphs.\")\n" +
                "        .appendContent(row\n" +
                "                .addColumn(column.copy()\n" +
                "                        .addElement(Paragraph.create().appendContent(b().textContent(\"Normal\").asElement()).asElement())\n" +
                "                        .addElement(Paragraph.create(\"Default text\").asElement())\n" +
                "                        .addElement(Paragraph.create(\"Text pink color\").setColor(Color.PINK).asElement())\n" +
                "                        .addElement(Paragraph.create(\"Text cyan color\").setColor(Color.CYAN).asElement())\n" +
                "                        .addElement(Paragraph.create(\"Text teal color\").setColor(Color.TEAL).asElement())\n" +
                "                        .addElement(Paragraph.create(\"Text orange color\").setColor(Color.ORANGE).asElement())\n" +
                "                        .addElement(Paragraph.create(\"Text blue grey color\").setColor(Color.BLUE_GREY).asElement())\n" +
                "                )\n" +
                "\n" +
                "                .addColumn(column.copy()\n" +
                "                        .addElement(Paragraph.create().appendContent(b().textContent(\"Bold\").asElement()).asElement())\n" +
                "                        .addElement(Paragraph.create(\"Default text\").bold().asElement())\n" +
                "                        .addElement(Paragraph.create(\"Text pink color\").bold().setColor(Color.PINK).asElement())\n" +
                "                        .addElement(Paragraph.create(\"Text cyan color\").bold().setColor(Color.CYAN).asElement())\n" +
                "                        .addElement(Paragraph.create(\"Text teal color\").bold().setColor(Color.TEAL).asElement())\n" +
                "                        .addElement(Paragraph.create(\"Text orange color\").bold().setColor(Color.ORANGE).asElement())\n" +
                "                        .addElement(Paragraph.create(\"Text blue grey color\").bold().setColor(Color.BLUE_GREY).asElement())\n" +
                "                )\n" +
                "\n" +
                "                .addColumn(column.copy()\n" +
                "                        .addElement(Paragraph.create().appendContent(b().textContent(\"Italic\").asElement()).asElement())\n" +
                "                        .addElement(Paragraph.create(\"Default text\").italic().asElement())\n" +
                "                        .addElement(Paragraph.create(\"Text pink color\").italic().setColor(Color.PINK).asElement())\n" +
                "                        .addElement(Paragraph.create(\"Text cyan color\").italic().setColor(Color.CYAN).asElement())\n" +
                "                        .addElement(Paragraph.create(\"Text teal color\").italic().setColor(Color.TEAL).asElement())\n" +
                "                        .addElement(Paragraph.create(\"Text orange color\").italic().setColor(Color.ORANGE).asElement())\n" +
                "                        .addElement(Paragraph.create(\"Text blue grey color\").italic().setColor(Color.BLUE_GREY).asElement())\n" +
                "                )\n" +
                "\n" +
                "                .addColumn(column.copy()\n" +
                "                        .addElement(Paragraph.create().appendContent(b().textContent(\"Under line\").asElement()).asElement())\n" +
                "                        .addElement(Paragraph.create(\"Default text\").underLine().asElement())\n" +
                "                        .addElement(Paragraph.create(\"Text pink color\").underLine().setColor(Color.PINK).asElement())\n" +
                "                        .addElement(Paragraph.create(\"Text cyan color\").underLine().setColor(Color.CYAN).asElement())\n" +
                "                        .addElement(Paragraph.create(\"Text teal color\").underLine().setColor(Color.TEAL).asElement())\n" +
                "                        .addElement(Paragraph.create(\"Text orange color\").underLine().setColor(Color.ORANGE).asElement())\n" +
                "                        .addElement(Paragraph.create(\"Text blue grey color\").underLine().setColor(Color.BLUE_GREY).asElement())\n" +
                "                )\n" +
                "\n" +
                "                .addColumn(column.copy()\n" +
                "                        .addElement(Paragraph.create().appendContent(b().textContent(\"Line through\").asElement()).asElement())\n" +
                "                        .addElement(Paragraph.create(\"Default text\").lineThrough().asElement())\n" +
                "                        .addElement(Paragraph.create(\"Text pink color\").lineThrough().setColor(Color.PINK).asElement())\n" +
                "                        .addElement(Paragraph.create(\"Text cyan color\").lineThrough().setColor(Color.CYAN).asElement())\n" +
                "                        .addElement(Paragraph.create(\"Text teal color\").lineThrough().setColor(Color.TEAL).asElement())\n" +
                "                        .addElement(Paragraph.create(\"Text orange color\").lineThrough().setColor(Color.ORANGE).asElement())\n" +
                "                        .addElement(Paragraph.create(\"Text blue grey color\").lineThrough().setColor(Color.BLUE_GREY).asElement())\n" +
                "                )\n" +
                "\n" +
                "                .addColumn(column.copy()\n" +
                "                        .addElement(Paragraph.create().appendContent(b().textContent(\"Over line\").asElement()).asElement())\n" +
                "                        .addElement(Paragraph.create(\"Default text\").overLine().asElement())\n" +
                "                        .addElement(Paragraph.create(\"Text pink color\").overLine().setColor(Color.PINK).asElement())\n" +
                "                        .addElement(Paragraph.create(\"Text cyan color\").overLine().setColor(Color.CYAN).asElement())\n" +
                "                        .addElement(Paragraph.create(\"Text teal color\").overLine().setColor(Color.TEAL).asElement())\n" +
                "                        .addElement(Paragraph.create(\"Text orange color\").overLine().setColor(Color.ORANGE).asElement())\n" +
                "                        .addElement(Paragraph.create(\"Text blue grey color\").overLine().setColor(Color.BLUE_GREY).asElement())\n" +
                "                )\n" +
                "                .asElement())\n" +
                "        .asElement());")
                .asElement());
    }

    private void fontSize() {
        Column column = Column.create()
                .onLarge(Column.OnLarge.two)
                .onMedium(Column.OnMedium.two)
                .onSmall(Column.OnSmall.twelve)
                .onXSmall(Column.OnXSmall.twelve);

        element.appendChild(Card.create("FONT SIZES", "Use ready classes to change text font size.")
                .appendContent(Row.create()
                        .addColumn(column.copy().addElement(div().css(Styles.font_6).textContent("font-6").asElement()))
                        .addColumn(column.copy().addElement(div().css(Styles.font_10).textContent("font-10").asElement()))
                        .addColumn(column.copy().addElement(div().css(Styles.font_12).textContent("font-12").asElement()))
                        .addColumn(column.copy().addElement(div().css(Styles.font_15).textContent("font-15").asElement()))
                        .addColumn(column.copy().addElement(div().css(Styles.font_20).textContent("font-20").asElement()))
                        .addColumn(column.copy().addElement(div().css(Styles.font_24).textContent("font-24").asElement()))
                        .asElement())
                .appendContent(Row.create()
                        .addColumn(column.copy().addElement(div().css(Styles.font_32).textContent("font-32").asElement()))
                        .addColumn(column.copy().addElement(div().css(Styles.font_40).textContent("font-40").asElement()))
                        .addColumn(column.copy().addElement(div().css(Styles.font_42).textContent("font-42").asElement()))
                        .addColumn(column.copy().addElement(div().css(Styles.font_45).textContent("font-45").asElement()))
                        .addColumn(column.copy().addElement(div().css(Styles.font_48).textContent("font-48").asElement()))
                        .addColumn(column.copy().addElement(div().css(Styles.font_50).textContent("font-50").asElement()))
                        .asElement())
                .asElement());

        element.appendChild(Card.createCodeCard("element.appendChild(Card.create(\"FONT SIZES\",\"Use ready classes to change text font size.\")\n" +
                "        .appendContent(Row.create()\n" +
                "                .addColumn(column.copy().addElement(div().css(Styles.font_6).textContent(\"font-6\").asElement()))\n" +
                "                .addColumn(column.copy().addElement(div().css(Styles.font_10).textContent(\"font-10\").asElement()))\n" +
                "                .addColumn(column.copy().addElement(div().css(Styles.font_12).textContent(\"font-12\").asElement()))\n" +
                "                .addColumn(column.copy().addElement(div().css(Styles.font_15).textContent(\"font-15\").asElement()))\n" +
                "                .addColumn(column.copy().addElement(div().css(Styles.font_20).textContent(\"font-20\").asElement()))\n" +
                "                .addColumn(column.copy().addElement(div().css(Styles.font_24).textContent(\"font-24\").asElement()))\n" +
                "        .asElement())\n" +
                "        .appendContent(Row.create()\n" +
                "                .addColumn(column.copy().addElement(div().css(Styles.font_32).textContent(\"font-32\").asElement()))\n" +
                "                .addColumn(column.copy().addElement(div().css(Styles.font_40).textContent(\"font-40\").asElement()))\n" +
                "                .addColumn(column.copy().addElement(div().css(Styles.font_42).textContent(\"font-42\").asElement()))\n" +
                "                .addColumn(column.copy().addElement(div().css(Styles.font_45).textContent(\"font-45\").asElement()))\n" +
                "                .addColumn(column.copy().addElement(div().css(Styles.font_48).textContent(\"font-48\").asElement()))\n" +
                "                .addColumn(column.copy().addElement(div().css(Styles.font_50).textContent(\"font-50\").asElement()))\n" +
                "                .asElement())\n" +
                ".asElement());")
                .asElement());
    }

    private void textAligns() {

        Column column = Column.create()
                .onLarge(Column.OnLarge.three)
                .onMedium(Column.OnMedium.three)
                .onSmall(Column.OnSmall.twelve)
                .onXSmall(Column.OnXSmall.twelve);

        element.appendChild(Card.create("TEXT ALIGNS", "You can use ready classes to change text alignment.")
                .appendContent(Row.create()
                        .addColumn(column.copy()
                                .addElement(Paragraph.create().appendContent(b().textContent("Align left").asElement()).alignLeft().asElement())
                                .addElement(div().css(Styles.align_left).textContent(SAMPLE_TEXT).asElement())
                        )
                        .addColumn(column.copy()
                                .addElement(Paragraph.create().appendContent(b().textContent("Align center").asElement()).alignCenter().asElement())
                                .addElement(div().css(Styles.align_center).textContent(SAMPLE_TEXT).asElement())
                        )
                        .addColumn(column.copy()
                                .addElement(Paragraph.create().appendContent(b().textContent("Align right").asElement()).alignRight().asElement())
                                .addElement(div().css(Styles.align_right).textContent(SAMPLE_TEXT).asElement())
                        )
                        .addColumn(column.copy()
                                .addElement(Paragraph.create().appendContent(b().textContent("Align justify").asElement()).alignJustify().asElement())
                                .addElement(div().css(Styles.align_justify).textContent(SAMPLE_TEXT).asElement())
                        )
                        .asElement())
                .asElement());

        element.appendChild(Card.createCodeCard("element.appendChild(Card.create(\"TEXT ALIGNS\",\"You can use ready classes to change text alignment.\")\n" +
                "        .appendContent(Row.create()\n" +
                "                .addColumn(column.copy()\n" +
                "                        .addElement(Paragraph.create().appendContent(b().textContent(\"Align left\").asElement()).alignLeft().asElement())\n" +
                "                        .addElement(div().css(Styles.align_left).textContent(SAMPLE_TEXT).asElement())\n" +
                "                )\n" +
                "                .addColumn(column.copy()\n" +
                "                        .addElement(Paragraph.create().appendContent(b().textContent(\"Align center\").asElement()).alignCenter().asElement())\n" +
                "                        .addElement(div().css(Styles.align_center).textContent(SAMPLE_TEXT).asElement())\n" +
                "                )\n" +
                "                .addColumn(column.copy()\n" +
                "                        .addElement(Paragraph.create().appendContent(b().textContent(\"Align right\").asElement()).alignRight().asElement())\n" +
                "                        .addElement(div().css(Styles.align_right).textContent(SAMPLE_TEXT).asElement())\n" +
                "                )\n" +
                "                .addColumn(column.copy()\n" +
                "                        .addElement(Paragraph.create().appendContent(b().textContent(\"Align justify\").asElement()).alignJustify().asElement())\n" +
                "                        .addElement(div().css(Styles.align_justify).textContent(SAMPLE_TEXT).asElement())\n" +
                "                )\n" +
                "                .asElement())\n" +
                "        .asElement());")
                .asElement());
    }

    private void marginAndPaddingSpaces() {

        Column marginColumn = Column.create()
                .onLarge(Column.OnLarge.four)
                .onMedium(Column.OnMedium.four)
                .onSmall(Column.OnSmall.twelve)
                .onXSmall(Column.OnXSmall.twelve);

        Column paddingColumn = Column.create()
                .onLarge(Column.OnLarge.three)
                .onMedium(Column.OnMedium.three)
                .onSmall(Column.OnSmall.twelve)
                .onXSmall(Column.OnXSmall.twelve);

        element.appendChild(Card.create("MARGIN & PADDING SPACES", "Use ready classes to apply margins and padding to your elements.")
                .appendContent(Paragraph.create().appendContent(b().textContent("Margins").asElement()).asElement())
                .appendContent(Row.create()
                        .addColumn(marginColumn.copy()
                                .addElement(span().css(Color.RED.getStyle(), Styles.font_bold).textContent("M").asElement())
                                .addElement(new Text("argin "))
                                .addElement(span().css(Color.RED.getStyle(), Styles.font_bold).textContent("T").asElement())
                                .addElement(new Text("op "))
                                .addElement(span().css(Color.RED.getStyle(), Styles.font_bold).textContent("10").asElement())
                                .addElement(new Text("px → "))
                                .addElement(code().textContent(".m-t-10").asElement())
                        )
                        .addColumn(marginColumn.copy()
                                .addElement(span().css(Color.RED.getStyle(), Styles.font_bold).textContent("M").asElement())
                                .addElement(new Text("argin "))
                                .addElement(span().css(Color.RED.getStyle(), Styles.font_bold).textContent("T").asElement())
                                .addElement(new Text("op "))
                                .addElement(span().css(Color.RED.getStyle(), Styles.font_bold).textContent("0").asElement())
                                .addElement(new Text("px → "))
                                .addElement(code().textContent(".m-t-0").asElement())
                        )
                        .addColumn(marginColumn.copy()
                                .addElement(span().css(Color.RED.getStyle(), Styles.font_bold).textContent("M").asElement())
                                .addElement(new Text("argin "))
                                .addElement(span().css(Color.RED.getStyle(), Styles.font_bold).textContent("T").asElement())
                                .addElement(new Text("op "))
                                .addElement(span().css(Color.RED.getStyle(), Styles.font_bold).textContent("-10").asElement())
                                .addElement(new Text("px → "))
                                .addElement(code().textContent(".m-t--10").asElement())
                        )
                        .asElement())
                .appendContent(Row.create()
                        .addColumn(marginColumn.copy()
                                .addElement(span().css(Color.RED.getStyle(), Styles.font_bold).textContent("M").asElement())
                                .addElement(new Text("argin "))
                                .addElement(span().css(Color.RED.getStyle(), Styles.font_bold).textContent("L").asElement())
                                .addElement(new Text("eft "))
                                .addElement(span().css(Color.RED.getStyle(), Styles.font_bold).textContent("35").asElement())
                                .addElement(new Text("px → "))
                                .addElement(code().textContent(".m-l-35").asElement())
                        )
                        .addColumn(marginColumn.copy()
                                .addElement(span().css(Color.RED.getStyle(), Styles.font_bold).textContent("M").asElement())
                                .addElement(new Text("argin "))
                                .addElement(span().css(Color.RED.getStyle(), Styles.font_bold).textContent("L").asElement())
                                .addElement(new Text("eft "))
                                .addElement(span().css(Color.RED.getStyle(), Styles.font_bold).textContent("0").asElement())
                                .addElement(new Text("px → "))
                                .addElement(code().textContent(".m-l-0").asElement())
                        )
                        .addColumn(marginColumn.copy()
                                .addElement(span().css(Color.RED.getStyle(), Styles.font_bold).textContent("M").asElement())
                                .addElement(new Text("argin "))
                                .addElement(span().css(Color.RED.getStyle(), Styles.font_bold).textContent("L").asElement())
                                .addElement(new Text("eft "))
                                .addElement(span().css(Color.RED.getStyle(), Styles.font_bold).textContent("-35").asElement())
                                .addElement(new Text("px → "))
                                .addElement(code().textContent(".m-l--35").asElement())
                        )
                        .asElement())
                .appendContent(Row.create()
                        .addColumn(marginColumn.copy()
                                .addElement(span().css(Color.RED.getStyle(), Styles.font_bold).textContent("M").asElement())
                                .addElement(new Text("argin "))
                                .addElement(span().css(Color.RED.getStyle(), Styles.font_bold).textContent("B").asElement())
                                .addElement(new Text("ottom "))
                                .addElement(span().css(Color.RED.getStyle(), Styles.font_bold).textContent("15").asElement())
                                .addElement(new Text("px → "))
                                .addElement(code().textContent(".m-b-15").asElement())
                        )
                        .addColumn(marginColumn.copy()
                                .addElement(span().css(Color.RED.getStyle(), Styles.font_bold).textContent("M").asElement())
                                .addElement(new Text("argin "))
                                .addElement(span().css(Color.RED.getStyle(), Styles.font_bold).textContent("B").asElement())
                                .addElement(new Text("ottom "))
                                .addElement(span().css(Color.RED.getStyle(), Styles.font_bold).textContent("0").asElement())
                                .addElement(new Text("px → "))
                                .addElement(code().textContent(".m-b-0").asElement())
                        )
                        .addColumn(marginColumn.copy()
                                .addElement(span().css(Color.RED.getStyle(), Styles.font_bold).textContent("M").asElement())
                                .addElement(new Text("argin "))
                                .addElement(span().css(Color.RED.getStyle(), Styles.font_bold).textContent("B").asElement())
                                .addElement(new Text("ottom "))
                                .addElement(span().css(Color.RED.getStyle(), Styles.font_bold).textContent("-20").asElement())
                                .addElement(new Text("px → "))
                                .addElement(code().textContent(".m-l--20").asElement())
                        )
                        .asElement())
                .appendContent(Row.create()
                        .addColumn(marginColumn.copy()
                                .addElement(span().css(Color.RED.getStyle(), Styles.font_bold).textContent("M").asElement())
                                .addElement(new Text("argin "))
                                .addElement(span().css(Color.RED.getStyle(), Styles.font_bold).textContent("R").asElement())
                                .addElement(new Text("ight "))
                                .addElement(span().css(Color.RED.getStyle(), Styles.font_bold).textContent("30").asElement())
                                .addElement(new Text("px → "))
                                .addElement(code().textContent(".m-r-30").asElement())
                        )
                        .addColumn(marginColumn.copy()
                                .addElement(span().css(Color.RED.getStyle(), Styles.font_bold).textContent("M").asElement())
                                .addElement(new Text("argin "))
                                .addElement(span().css(Color.RED.getStyle(), Styles.font_bold).textContent("R").asElement())
                                .addElement(new Text("ight "))
                                .addElement(span().css(Color.RED.getStyle(), Styles.font_bold).textContent("0").asElement())
                                .addElement(new Text("px → "))
                                .addElement(code().textContent(".m-r-0").asElement())
                        )
                        .addColumn(marginColumn.copy()
                                .addElement(span().css(Color.RED.getStyle(), Styles.font_bold).textContent("M").asElement())
                                .addElement(new Text("argin "))
                                .addElement(span().css(Color.RED.getStyle(), Styles.font_bold).textContent("R").asElement())
                                .addElement(new Text("ight "))
                                .addElement(span().css(Color.RED.getStyle(), Styles.font_bold).textContent("-30").asElement())
                                .addElement(new Text("px → "))
                                .addElement(code().textContent(".m-r--30").asElement())
                        )
                        .asElement())
                .appendContent(Row.create()
                        .addColumn(marginColumn.copy()
                                .addElement(span().css(Color.RED.getStyle(), Styles.font_bold).textContent("ALL M").asElement())
                                .addElement(new Text("argin "))
                                .addElement(span().css(Color.RED.getStyle(), Styles.font_bold).textContent("0").asElement())
                                .addElement(new Text("px → "))
                                .addElement(code().textContent(".margin-0").asElement())
                        ).asElement())
                .appendContent(Paragraph.create().appendContent(b().textContent("Paddings").asElement()).asElement())
                .appendContent(Row.create()
                        .addColumn(paddingColumn.copy()
                                .addElement(span().css(Color.RED.getStyle(), Styles.font_bold).textContent("P").asElement())
                                .addElement(new Text("adding "))
                                .addElement(span().css(Color.RED.getStyle(), Styles.font_bold).textContent("T").asElement())
                                .addElement(new Text("op "))
                                .addElement(span().css(Color.RED.getStyle(), Styles.font_bold).textContent("10").asElement())
                                .addElement(new Text("px → "))
                                .addElement(code().textContent(".p-t-10").asElement())
                        )
                        .addColumn(paddingColumn.copy()
                                .addElement(span().css(Color.RED.getStyle(), Styles.font_bold).textContent("P").asElement())
                                .addElement(new Text("adding "))
                                .addElement(span().css(Color.RED.getStyle(), Styles.font_bold).textContent("T").asElement())
                                .addElement(new Text("op "))
                                .addElement(span().css(Color.RED.getStyle(), Styles.font_bold).textContent("0").asElement())
                                .addElement(new Text("px → "))
                                .addElement(code().textContent(".p-t-0").asElement())
                        )
                        .addColumn(paddingColumn.copy()
                                .addElement(span().css(Color.RED.getStyle(), Styles.font_bold).textContent("P").asElement())
                                .addElement(new Text("adding "))
                                .addElement(span().css(Color.RED.getStyle(), Styles.font_bold).textContent("L").asElement())
                                .addElement(new Text("eft "))
                                .addElement(span().css(Color.RED.getStyle(), Styles.font_bold).textContent("35").asElement())
                                .addElement(new Text("px → "))
                                .addElement(code().textContent(".p-l-35").asElement())
                        )
                        .addColumn(paddingColumn.copy()
                                .addElement(span().css(Color.RED.getStyle(), Styles.font_bold).textContent("P").asElement())
                                .addElement(new Text("adding "))
                                .addElement(span().css(Color.RED.getStyle(), Styles.font_bold).textContent("L").asElement())
                                .addElement(new Text("eft "))
                                .addElement(span().css(Color.RED.getStyle(), Styles.font_bold).textContent("0").asElement())
                                .addElement(new Text("px → "))
                                .addElement(code().textContent(".p-l-0").asElement())
                        )
                        .asElement())
                .appendContent(Row.create()
                        .addColumn(paddingColumn.copy()
                                .addElement(span().css(Color.RED.getStyle(), Styles.font_bold).textContent("P").asElement())
                                .addElement(new Text("adding "))
                                .addElement(span().css(Color.RED.getStyle(), Styles.font_bold).textContent("B").asElement())
                                .addElement(new Text("ottom "))
                                .addElement(span().css(Color.RED.getStyle(), Styles.font_bold).textContent("15").asElement())
                                .addElement(new Text("px → "))
                                .addElement(code().textContent(".p-b-15").asElement())
                        )
                        .addColumn(paddingColumn.copy()
                                .addElement(span().css(Color.RED.getStyle(), Styles.font_bold).textContent("P").asElement())
                                .addElement(new Text("adding "))
                                .addElement(span().css(Color.RED.getStyle(), Styles.font_bold).textContent("B").asElement())
                                .addElement(new Text("ottom "))
                                .addElement(span().css(Color.RED.getStyle(), Styles.font_bold).textContent("0").asElement())
                                .addElement(new Text("px → "))
                                .addElement(code().textContent(".p-b-0").asElement())
                        )
                        .addColumn(paddingColumn.copy()
                                .addElement(span().css(Color.RED.getStyle(), Styles.font_bold).textContent("P").asElement())
                                .addElement(new Text("adding "))
                                .addElement(span().css(Color.RED.getStyle(), Styles.font_bold).textContent("R").asElement())
                                .addElement(new Text("ight "))
                                .addElement(span().css(Color.RED.getStyle(), Styles.font_bold).textContent("30").asElement())
                                .addElement(new Text("px → "))
                                .addElement(code().textContent(".p-r-30").asElement())
                        )
                        .addColumn(paddingColumn.copy()
                                .addElement(span().css(Color.RED.getStyle(), Styles.font_bold).textContent("P").asElement())
                                .addElement(new Text("adding "))
                                .addElement(span().css(Color.RED.getStyle(), Styles.font_bold).textContent("R").asElement())
                                .addElement(new Text("ight "))
                                .addElement(span().css(Color.RED.getStyle(), Styles.font_bold).textContent("0").asElement())
                                .addElement(new Text("px → "))
                                .addElement(code().textContent(".p-r-0").asElement())
                        )
                        .asElement())
                .appendContent(Row.create()
                        .addColumn(paddingColumn.copy()
                                .addElement(span().css(Color.RED.getStyle(), Styles.font_bold).textContent("ALL P").asElement())
                                .addElement(new Text("adding "))
                                .addElement(span().css(Color.RED.getStyle(), Styles.font_bold).textContent("0").asElement())
                                .addElement(new Text("px → "))
                                .addElement(code().textContent(".padding-0").asElement())
                        )
                        .asElement())
                .asElement());
    }

    @Override
    public void showIn(Content content) {
        HTMLElement contentElement = Js.cast(content.get());
        contentElement.appendChild(element);
    }
}