package org.dominokit.domino.typography.client.views.ui;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.SampleClass;
import org.dominokit.domino.SampleMethod;
import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.domino.componentcase.client.ui.views.CodeCard;
import org.dominokit.domino.componentcase.client.ui.views.Constants;
import org.dominokit.domino.componentcase.client.ui.views.LinkToSourceCode;
import org.dominokit.domino.typography.client.presenters.TypographyProxy;
import org.dominokit.domino.typography.client.views.TypographyView;
import org.dominokit.domino.ui.Typography.Blockquote;
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

@UiView(presentable = TypographyProxy.class)
@SampleClass
public class TypographyViewImpl extends BaseDemoView<HTMLDivElement> implements TypographyView {
    private HTMLDivElement element;

    @Override
    protected HTMLDivElement init() {
        element = div().element();

        element.appendChild(LinkToSourceCode.create("typography", this.getClass()).element());
        element.appendChild(BlockHeader.create("TYPOGRAPHY").element());

        bodyCopy();
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.bodyCopy()).element());

        fontSizes();
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.fontSizes()).element());

        heading();
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.heading()).element());

        textStyles();
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.textStyles()).element());

        blockqoute();
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.blockqoute()).element());

        lists();
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.lists()).element());

        return element;
    }

    @SampleMethod
    private void lists() {
        Row row = Row.create();

        element.appendChild(row
                .addColumn(Column.span4()
                        .appendChild(Card.create("UNORDERED LIST")
                                .appendChild(ul()
                                        .add(li().textContent("Lorem ipsum dolor sit amet"))
                                        .add(li().textContent("Consectetur adipiscing elit"))
                                        .add(li().textContent("Integer molestie lorem at massa"))
                                        .add(li().textContent("Facilisis in pretium nisl aliquet"))
                                        .add(li().textContent("Nulla volutpat aliquam velit")
                                                .add(ul()
                                                        .add(li().textContent("Phasellus iaculis neque"))
                                                        .add(li().textContent("Purus sodales ultricies"))
                                                        .add(li().textContent("Vestibulum laoreet porttitor sem"))
                                                        .add(li().textContent("Ac tristique libero volutpat at"))
                                                )
                                        )
                                        .add(li().textContent("Faucibus porta lacus fringilla vel"))
                                        .add(li().textContent("Aenean sit amet erat nunc"))
                                        .add(li().textContent("Eget porttitor lorem")))))
                .addColumn(Column.span4()
                        .appendChild(Card.create("ORDERED LIST")
                                .appendChild(ol()
                                        .add(li().textContent("Lorem ipsum dolor sit amet"))
                                        .add(li().textContent("Consectetur adipiscing elit"))
                                        .add(li().textContent("Integer molestie lorem at massa"))
                                        .add(li().textContent("Facilisis in pretium nisl aliquet"))
                                        .add(li().textContent("Nulla volutpat aliquam velit")
                                                .add(ol()
                                                        .add(li().textContent("Phasellus iaculis neque"))
                                                        .add(li().textContent("Purus sodales ultricies"))
                                                        .add(li().textContent("Vestibulum laoreet porttitor sem"))
                                                        .add(li().textContent("Ac tristique libero volutpat at"))
                                                )
                                        )
                                        .add(li().textContent("Faucibus porta lacus fringilla vel"))
                                        .add(li().textContent("Aenean sit amet erat nunc"))
                                        .add(li().textContent("Eget porttitor lorem"))
                                )
                        ))
                .addColumn(Column.span4()
                        .appendChild(Card.create("UNSTYLED LIST")
                                .appendChild(ul().css(Styles.LIST_UNSTYLED)
                                        .add(li().textContent("Lorem ipsum dolor sit amet"))
                                        .add(li().textContent("Consectetur adipiscing elit"))
                                        .add(li().textContent("Integer molestie lorem at massa"))
                                        .add(li().textContent("Facilisis in pretium nisl aliquet"))
                                        .add(li().textContent("Nulla volutpat aliquam velit")
                                                .add(ul()
                                                        .add(li().textContent("Phasellus iaculis neque"))
                                                        .add(li().textContent("Purus sodales ultricies"))
                                                        .add(li().textContent("Vestibulum laoreet porttitor sem"))
                                                        .add(li().textContent("Ac tristique libero volutpat at"))
                                                )
                                        )
                                        .add(li().textContent("Faucibus porta lacus fringilla vel"))
                                        .add(li().textContent("Aenean sit amet erat nunc"))
                                        .add(li().textContent("Eget porttitor lorem"))
                                )
                        )).element()
        );


    }

    @SampleMethod
    private void bodyCopy() {
        element.appendChild(Card.create("BODY COPY", "Use LEAD style make a paragraph with larger fonts on big screens.")
                .appendChild(p().css(Styles.LEAD).textContent(Constants.SMALLER_PARAGRAPH))
                .appendChild(p().textContent(Constants.LARGE_PARAGRAPH))
                .appendChild(p().textContent(Constants.SMALL_PARAGRAPH)).element()
        );


    }

    @SampleMethod
    private void fontSizes() {
        element.appendChild(Card.create("FONT SIZES", "Use ready classes to change a text fot size.")
                .appendChild(Row.create()
                        .addColumn(Column.span12()
                                .appendChild(Paragraph.create().appendChild(b().css(Styles.font_72).textContent("font-72")))
                                .appendChild(Paragraph.create().appendChild(b().css(Styles.font_60).textContent("font-60")))
                                .appendChild(Paragraph.create().appendChild(b().css(Styles.font_50).textContent("font-50")))
                                .appendChild(Paragraph.create().appendChild(b().css(Styles.font_48).textContent("font-48")))
                                .appendChild(Paragraph.create().appendChild(b().css(Styles.font_45).textContent("font-45")))
                                .appendChild(Paragraph.create().appendChild(b().css(Styles.font_42).textContent("font-42")))
                                .appendChild(Paragraph.create().appendChild(b().css(Styles.font_40).textContent("font-40")))
                                .appendChild(Paragraph.create().appendChild(b().css(Styles.font_32).textContent("font-32")))
                                .appendChild(Paragraph.create().appendChild(b().css(Styles.font_24).textContent("font-24")))
                                .appendChild(Paragraph.create().appendChild(b().css(Styles.font_20).textContent("font-20")))
                                .appendChild(Paragraph.create().appendChild(b().css(Styles.font_15).textContent("font-15")))
                                .appendChild(Paragraph.create().appendChild(b().css(Styles.font_12).textContent("font-12")))
                                .appendChild(Paragraph.create().appendChild(b().css(Styles.font_10).textContent("font-10")))
                                .appendChild(Paragraph.create().appendChild(b().css(Styles.font_6).textContent("font-6")))
                        )).element());



    }

    @SampleMethod
    private void heading() {
        element.appendChild(Card.create("HEADINGS")
                .appendChild(h(1).textContent("h1. Text Heading."))
                .appendChild(Paragraph.create(Constants.SAMPLE_TEXT))
                .appendChild(h(2).textContent("h2. Text Heading."))
                .appendChild(Paragraph.create(Constants.SAMPLE_TEXT))
                .appendChild(h(3).textContent("h3. Text Heading."))
                .appendChild(Paragraph.create(Constants.SAMPLE_TEXT))
                .appendChild(h(4).textContent("h4. Text Heading."))
                .appendChild(Paragraph.create(Constants.SAMPLE_TEXT))
                .appendChild(h(5).textContent("h5. Text Heading."))
                .appendChild(Paragraph.create(Constants.SAMPLE_TEXT))
                .appendChild(h(6).textContent("h6. Text Heading."))
                .appendChild(Paragraph.create(Constants.SAMPLE_TEXT))
                .element()
        );


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
                                .appendChild(Paragraph.create().appendChild(b().textContent("Under line")))
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
                ).element());


    }

    @SampleMethod
    private void blockqoute() {
        element.appendChild(Card.create("BLOCKQUOTES")
                .appendChild(Blockquote.create("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer posuere erat a ante.")
                )
                .appendChild(Blockquote.create("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer posuere erat a ante.")
                        .appendFooterChild(TextNode.of("Someone famous in "))
                        .appendFooterChild(cite().textContent("source title."))
                )
                .appendChild(Blockquote.create("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer posuere erat a ante.")
                        .appendFooterChild(TextNode.of("Someone famous in "))
                        .appendFooterChild(cite().textContent("source title."))
                        .reverse()
                ).element());


    }
}