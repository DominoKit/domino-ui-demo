package org.dominokit.domino.typography.client.views.ui;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.SampleClass;
import org.dominokit.domino.SampleMethod;
import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.domino.componentcase.client.ui.views.BaseDemoView;
import org.dominokit.domino.componentcase.client.ui.views.CodeCard;
import org.dominokit.domino.componentcase.client.ui.views.Constants;
import org.dominokit.domino.componentcase.client.ui.views.LinkToSourceCode;
import org.dominokit.domino.typography.client.presenters.TypographyProxy;
import org.dominokit.domino.typography.client.views.TypographyView;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.grid.Column;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.typography.BlockHeader;
import org.dominokit.domino.ui.typography.Blockquote;

@UiView(presentable = TypographyProxy.class)
@SampleClass
public class TypographyViewImpl extends BaseDemoView<HTMLDivElement> implements TypographyView {
    private DivElement element;

    @Override
    protected HTMLDivElement init() {
        element = div();

        element.appendChild(LinkToSourceCode.createLink("typography", this.getClass()));
        element.appendChild(BlockHeader.create("TYPOGRAPHY"));

        bodyCopy();
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.bodyCopy()));

        heading();
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.heading()));

        textStyles();
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.textStyles()));

        blockqoute();
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.blockqoute()));

        lists();
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.lists()));

        fontSizes();
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.fontSizes()));

        return element.element();
    }

    @SampleMethod
    private void bodyCopy() {
        element.appendChild(Card.create("LEAD", "Use LEAD style make a paragraph with larger fonts on big screens.")
                .setCollapsible(true)
                .appendChild(BlockHeader.create("Leading none"))
                .appendChild(p().addCss(dui_leading_none).textContent(Constants.LARGE_PARAGRAPH))
                .appendChild(BlockHeader.create("Leading tight"))
                .appendChild(p().addCss(dui_leading_tight).textContent(Constants.LARGE_PARAGRAPH))
                .appendChild(BlockHeader.create("Leading snug"))
                .appendChild(p().addCss(dui_leading_snug).textContent(Constants.LARGE_PARAGRAPH))
                .appendChild(BlockHeader.create("Leading normal"))
                .appendChild(p().addCss(dui_leading_normal).textContent(Constants.LARGE_PARAGRAPH))
                .appendChild(BlockHeader.create("Leading relaxed"))
                .appendChild(p().addCss(dui_leading_relaxed).textContent(Constants.LARGE_PARAGRAPH))
                .appendChild(BlockHeader.create("Leading loose"))
                .appendChild(p().addCss(dui_leading_loose).textContent(Constants.LARGE_PARAGRAPH))
                .appendChild(BlockHeader.create("Leading 3"))
                .appendChild(p().addCss(dui_leading_3).textContent(Constants.LARGE_PARAGRAPH))
                .appendChild(BlockHeader.create("Leading 4"))
                .appendChild(p().addCss(dui_leading_4).textContent(Constants.LARGE_PARAGRAPH))
                .appendChild(BlockHeader.create("Leading 5"))
                .appendChild(p().addCss(dui_leading_5).textContent(Constants.LARGE_PARAGRAPH))
                .appendChild(BlockHeader.create("Leading 6"))
                .appendChild(p().addCss(dui_leading_6).textContent(Constants.LARGE_PARAGRAPH))
                .appendChild(BlockHeader.create("Leading 7"))
                .appendChild(p().addCss(dui_leading_7).textContent(Constants.LARGE_PARAGRAPH))
                .appendChild(BlockHeader.create("Leading 8"))
                .appendChild(p().addCss(dui_leading_8).textContent(Constants.LARGE_PARAGRAPH))
                .appendChild(BlockHeader.create("Leading 9"))
                .appendChild(p().addCss(dui_leading_9).textContent(Constants.LARGE_PARAGRAPH))
                .appendChild(BlockHeader.create("Leading 10"))
                .appendChild(p().addCss(dui_leading_10).textContent(Constants.LARGE_PARAGRAPH))
        );


    }

    @SampleMethod
    private void heading() {
        element.appendChild(Card.create("HEADINGS")
                .setCollapsible(true)
                .appendChild(h(1).textContent("h1. Text Heading."))
                .appendChild(p(Constants.SAMPLE_TEXT))
                .appendChild(h(2).textContent("h2. Text Heading."))
                .appendChild(p(Constants.SAMPLE_TEXT))
                .appendChild(h(3).textContent("h3. Text Heading."))
                .appendChild(p(Constants.SAMPLE_TEXT))
                .appendChild(h(4).textContent("h4. Text Heading."))
                .appendChild(p(Constants.SAMPLE_TEXT))
                .appendChild(h(5).textContent("h5. Text Heading."))
                .appendChild(p(Constants.SAMPLE_TEXT))
                .appendChild(h(6).textContent("h6. Text Heading."))
                .appendChild(p(Constants.SAMPLE_TEXT))
        );
    }

    @SampleMethod
    private void textStyles() {

        element.appendChild(Card.create("TEXT STYLES", "Use ready classes to style your paragraphs.")
                .setCollapsible(true)
                .appendChild(Row.create()
                        .appendChild(Column.span2()
                                .appendChild(p().appendChild(b().textContent("Normal")))
                                .appendChild(p("Default text"))
                                .appendChild(p("Text pink color").addCss(dui_fg_pink))
                                .appendChild(p("Text cyan color").addCss(dui_fg_cyan))
                                .appendChild(p("Text teal color").addCss(dui_fg_teal))
                                .appendChild(p("Text orange color").addCss(dui_fg_orange))
                                .appendChild(p("Text blue grey color").addCss(dui_fg_blue_grey))
                        )
                        .appendChild(Column.span2()
                                .appendChild(p().appendChild(b().textContent("Bold")))
                                .appendChild(p("Default text").addCss(dui_font_bold))
                                .appendChild(p("Text pink color").addCss(dui_font_bold, dui_fg_pink))
                                .appendChild(p("Text cyan color").addCss(dui_font_bold, dui_fg_cyan))
                                .appendChild(p("Text teal color").addCss(dui_font_bold, dui_fg_teal))
                                .appendChild(p("Text orange color").addCss(dui_font_bold, dui_fg_orange))
                                .appendChild(p("Text blue grey color").addCss(dui_font_bold, dui_fg_blue_grey))
                        )
                        .appendChild(Column.span2()
                                .appendChild(p().appendChild(b().textContent("Italic")))
                                .appendChild(p("Default text").addCss(dui_italic))
                                .appendChild(p("Text pink color").addCss(dui_italic, dui_fg_pink))
                                .appendChild(p("Text cyan color").addCss(dui_italic, dui_fg_cyan))
                                .appendChild(p("Text teal color").addCss(dui_italic, dui_fg_teal))
                                .appendChild(p("Text orange color").addCss(dui_italic, dui_fg_orange))
                                .appendChild(p("Text blue grey color").addCss(dui_italic, dui_fg_blue_grey))
                        )
                        .appendChild(Column.span2()
                                .appendChild(p().appendChild(b().textContent("Under line")))
                                .appendChild(p("Default text").addCss(dui_underline))
                                .appendChild(p("Text pink color").addCss(dui_underline, dui_fg_pink))
                                .appendChild(p("Text cyan color").addCss(dui_underline, dui_fg_cyan))
                                .appendChild(p("Text teal color").addCss(dui_underline, dui_fg_teal))
                                .appendChild(p("Text orange color").addCss(dui_underline, dui_fg_orange))
                                .appendChild(p("Text blue grey color").addCss(dui_underline, dui_fg_blue_grey))
                        )
                        .appendChild(Column.span2()
                                .appendChild(p().appendChild(b().textContent("Line through")))
                                .appendChild(p("Default text").addCss(dui_line_through))
                                .appendChild(p("Text pink color").addCss(dui_line_through, dui_fg_pink))
                                .appendChild(p("Text cyan color").addCss(dui_line_through, dui_fg_cyan))
                                .appendChild(p("Text teal color").addCss(dui_line_through, dui_fg_teal))
                                .appendChild(p("Text orange color").addCss(dui_line_through, dui_fg_orange))
                                .appendChild(p("Text blue grey color").addCss(dui_line_through, dui_fg_blue_grey))
                        )
                        .appendChild(Column.span2()
                                .appendChild(p().appendChild(b().textContent("Over line")))
                                .appendChild(p("Default text").addCss(dui_overline))
                                .appendChild(p("Text pink color").addCss(dui_overline, dui_fg_pink))
                                .appendChild(p("Text cyan color").addCss(dui_overline, dui_fg_cyan))
                                .appendChild(p("Text teal color").addCss(dui_overline, dui_fg_teal))
                                .appendChild(p("Text orange color").addCss(dui_overline, dui_fg_orange))
                                .appendChild(p("Text blue grey color").addCss(dui_overline, dui_fg_blue_grey))
                        )
                ));
    }

    @SampleMethod
    private void blockqoute() {
        element.appendChild(Card.create("BLOCKQUOTES")
                .setCollapsible(true)
                .appendChild(Blockquote.create("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer posuere erat a ante."))
                .appendChild(Blockquote.create("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer posuere erat a ante.")
                        .withFooter((parent, footer) -> {
                            footer
                                    .appendChild(text("Someone famous in "))
                                    .appendChild(cite().textContent("source title."));
                        })
                )
                .appendChild(Blockquote.create("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer posuere erat a ante.")
                        .withFooter((parent, footer) -> {
                            footer
                                    .appendChild(cite().textContent("source title. "))
                                    .appendChild(text("Someone famous in"));
                        })
                ));


    }

    @SampleMethod
    private void lists() {
        element.appendChild(Row.create()
                .appendChild(Column.span4()
                        .appendChild(Card.create("UNORDERED LIST")
                                .setCollapsible(true)
                                .appendChild(ul()
                                        .appendChild(li().textContent("Lorem ipsum dolor sit amet"))
                                        .appendChild(li().textContent("Consectetur adipiscing elit"))
                                        .appendChild(li().textContent("Integer molestie lorem at massa"))
                                        .appendChild(li().textContent("Facilisis in pretium nisl aliquet"))
                                        .appendChild(li().textContent("Nulla volutpat aliquam velit")
                                                .appendChild(ul()
                                                        .appendChild(li().textContent("Phasellus iaculis neque"))
                                                        .appendChild(li().textContent("Purus sodales ultricies"))
                                                        .appendChild(li().textContent("Vestibulum laoreet porttitor sem"))
                                                        .appendChild(li().textContent("Ac tristique libero volutpat at"))
                                                )
                                        )
                                        .appendChild(li().textContent("Faucibus porta lacus fringilla vel"))
                                        .appendChild(li().textContent("Aenean sit amet erat nunc"))
                                        .appendChild(li().textContent("Eget porttitor lorem")))))
                .appendChild(Column.span4()
                        .appendChild(Card.create("ORDERED LIST")
                                .appendChild(ol()
                                        .appendChild(li().textContent("Lorem ipsum dolor sit amet"))
                                        .appendChild(li().textContent("Consectetur adipiscing elit"))
                                        .appendChild(li().textContent("Integer molestie lorem at massa"))
                                        .appendChild(li().textContent("Facilisis in pretium nisl aliquet"))
                                        .appendChild(li().textContent("Nulla volutpat aliquam velit")
                                                .appendChild(ol()
                                                        .appendChild(li().textContent("Phasellus iaculis neque"))
                                                        .appendChild(li().textContent("Purus sodales ultricies"))
                                                        .appendChild(li().textContent("Vestibulum laoreet porttitor sem"))
                                                        .appendChild(li().textContent("Ac tristique libero volutpat at"))
                                                )
                                        )
                                        .appendChild(li().textContent("Faucibus porta lacus fringilla vel"))
                                        .appendChild(li().textContent("Aenean sit amet erat nunc"))
                                        .appendChild(li().textContent("Eget porttitor lorem"))
                                )
                        ))
                .appendChild(Column.span4()
                        .appendChild(Card.create("UNSTYLED LIST")
                                .appendChild(ul().addCss(dui_list_none)
                                        .appendChild(li().textContent("Lorem ipsum dolor sit amet"))
                                        .appendChild(li().textContent("Consectetur adipiscing elit"))
                                        .appendChild(li().textContent("Integer molestie lorem at massa"))
                                        .appendChild(li().textContent("Facilisis in pretium nisl aliquet"))
                                        .appendChild(li().textContent("Nulla volutpat aliquam velit")
                                                .appendChild(ul().addCss(dui_list_none)
                                                        .appendChild(li().textContent("Phasellus iaculis neque"))
                                                        .appendChild(li().textContent("Purus sodales ultricies"))
                                                        .appendChild(li().textContent("Vestibulum laoreet porttitor sem"))
                                                        .appendChild(li().textContent("Ac tristique libero volutpat at"))
                                                )
                                        )
                                        .appendChild(li().textContent("Faucibus porta lacus fringilla vel"))
                                        .appendChild(li().textContent("Aenean sit amet erat nunc"))
                                        .appendChild(li().textContent("Eget porttitor lorem"))
                                )
                        ))
        );


    }

    @SampleMethod
    private void fontSizes() {
        element.appendChild(Card.create("FONT SIZES", "Use ready classes to change a text fot size.")
                .setCollapsible(true)
                .appendChild(div()
                        .appendChild(BlockHeader.create("Font 0"))
                        .appendChild(p().appendChild(b().textContent("Lorem ipsum.").addCss(dui_font_size_0)))
                        .appendChild(BlockHeader.create("Font px"))
                        .appendChild(p().appendChild(b().textContent("Lorem ipsum.").addCss(dui_font_size_px)))
                        .appendChild(BlockHeader.create("Font 2px"))
                        .appendChild(p().appendChild(b().textContent("Lorem ipsum.").addCss(dui_font_size_2px)))
                        .appendChild(BlockHeader.create("Font 4px"))
                        .appendChild(p().appendChild(b().textContent("Lorem ipsum.").addCss(dui_font_size_4px)))
                        .appendChild(BlockHeader.create("Font 8px"))
                        .appendChild(p().appendChild(b().textContent("Lorem ipsum.").addCss(dui_font_size_8px)))
                        .appendChild(BlockHeader.create("Font 0.5"))
                        .appendChild(p().appendChild(b().textContent("Lorem ipsum.").addCss(dui_font_size_0_5)))
                        .appendChild(BlockHeader.create("Font 1"))
                        .appendChild(p().appendChild(b().textContent("Lorem ipsum.").addCss(dui_font_size_1)))
                        .appendChild(BlockHeader.create("Font 1.5"))
                        .appendChild(p().appendChild(b().textContent("Lorem ipsum.").addCss(dui_font_size_1_5)))
                        .appendChild(BlockHeader.create("Font 2"))
                        .appendChild(p().appendChild(b().textContent("Lorem ipsum.").addCss(dui_font_size_2)))
                        .appendChild(BlockHeader.create("Font 2.5"))
                        .appendChild(p().appendChild(b().textContent("Lorem ipsum.").addCss(dui_font_size_2_5)))
                        .appendChild(BlockHeader.create("Font 3"))
                        .appendChild(p().appendChild(b().textContent("Lorem ipsum.").addCss(dui_font_size_3)))
                        .appendChild(BlockHeader.create("Font 3.5"))
                        .appendChild(p().appendChild(b().textContent("Lorem ipsum.").addCss(dui_font_size_3_5)))
                        .appendChild(BlockHeader.create("Font 4"))
                        .appendChild(p().appendChild(b().textContent("Lorem ipsum.").addCss(dui_font_size_4)))
                        .appendChild(BlockHeader.create("Font 5"))
                        .appendChild(p().appendChild(b().textContent("Lorem ipsum.").addCss(dui_font_size_5)))
                        .appendChild(BlockHeader.create("Font 6"))
                        .appendChild(p().appendChild(b().textContent("Lorem ipsum.").addCss(dui_font_size_6)))
                        .appendChild(BlockHeader.create("Font 7"))
                        .appendChild(p().appendChild(b().textContent("Lorem ipsum.").addCss(dui_font_size_7)))
                        .appendChild(BlockHeader.create("Font 8"))
                        .appendChild(p().appendChild(b().textContent("Lorem ipsum.").addCss(dui_font_size_8)))
                        .appendChild(BlockHeader.create("Font 9"))
                        .appendChild(p().appendChild(b().textContent("Lorem ipsum.").addCss(dui_font_size_9)))
                        .appendChild(BlockHeader.create("Font 10"))
                        .appendChild(p().appendChild(b().textContent("Lorem ipsum.").addCss(dui_font_size_10)))
                        .appendChild(BlockHeader.create("Font 11"))
                        .appendChild(p().appendChild(b().textContent("Lorem ipsum.").addCss(dui_font_size_11)))
                        .appendChild(BlockHeader.create("Font 12"))
                        .appendChild(p().appendChild(b().textContent("Lorem ipsum.").addCss(dui_font_size_12)))
                        .appendChild(BlockHeader.create("Font 14"))
                        .appendChild(p().appendChild(b().textContent("Lorem ipsum.").addCss(dui_font_size_14)))
                        .appendChild(BlockHeader.create("Font 16"))
                        .appendChild(p().appendChild(b().textContent("Lorem ipsum.6").addCss(dui_font_size_16)))
                        .appendChild(BlockHeader.create("Font 20"))
                        .appendChild(p().appendChild(b().textContent("Lorem ipsum.").addCss(dui_font_size_20)))
                        .appendChild(BlockHeader.create("Font 24"))
                        .appendChild(p().appendChild(b().textContent("Lorem ipsum.").addCss(dui_font_size_24)))
                        .appendChild(BlockHeader.create("Font 28"))
                        .appendChild(p().appendChild(b().textContent("Lorem ipsum.").addCss(dui_font_size_28)))
                        .appendChild(BlockHeader.create("Font 32"))
                        .appendChild(p().appendChild(b().textContent("font 32").addCss(dui_font_size_32)))
                        .appendChild(BlockHeader.create("Font 36"))
                        .appendChild(p().appendChild(b().textContent("Lorem ipsum.").addCss(dui_font_size_36)))
                        .appendChild(BlockHeader.create("Font 40"))
                        .appendChild(p().appendChild(b().textContent("Lorem ipsum.").addCss(dui_font_size_40)))
                        .appendChild(BlockHeader.create("Font 44"))
                        .appendChild(p().appendChild(b().textContent("Lorem ipsum.").addCss(dui_font_size_44)))
                        .appendChild(BlockHeader.create("Font 48"))
                        .appendChild(p().appendChild(b().textContent("Lorem ipsum.").addCss(dui_font_size_48)))
                        .appendChild(BlockHeader.create("Font 52"))
                        .appendChild(p().appendChild(b().textContent("Lorem ipsum.").addCss(dui_font_size_52)))
                        .appendChild(BlockHeader.create("Font 56"))
                        .appendChild(p().appendChild(b().textContent("Lorem ipsum.").addCss(dui_font_size_56)))
                        .appendChild(BlockHeader.create("Font 60"))
                        .appendChild(p().appendChild(b().textContent("Lorem ipsum.").addCss(dui_font_size_60)))
                        .appendChild(BlockHeader.create("Font 64"))
                        .appendChild(p().appendChild(b().textContent("Lorem ipsum.").addCss(dui_font_size_64)))
                        .appendChild(BlockHeader.create("Font 72"))
                        .appendChild(p().appendChild(b().textContent("Lorem ipsum.").addCss(dui_font_size_72)))
                        .appendChild(BlockHeader.create("Font 80"))
                        .appendChild(p().appendChild(b().textContent("Lorem ipsum.").addCss(dui_font_size_80)))
                        .appendChild(BlockHeader.create("Font 96"))
                        .appendChild(p().appendChild(b().textContent("Lorem ipsum.").addCss(dui_font_size_96)))
                        .appendChild(BlockHeader.create("Font 50%"))
                        .appendChild(p().appendChild(b().textContent("Lorem ipsum.").addCss(dui_font_size_1_2p)))
                        .appendChild(BlockHeader.create("Font 33%"))
                        .appendChild(p().appendChild(b().textContent("Lorem ipsum.").addCss(dui_font_size_1_3p)))
                        .appendChild(BlockHeader.create("Font 66%"))
                        .appendChild(p().appendChild(b().textContent("Lorem ipsum.").addCss(dui_font_size_2_3p)))
                        .appendChild(BlockHeader.create("Font 25%"))
                        .appendChild(p().appendChild(b().textContent("Lorem ipsum.").addCss(dui_font_size_1_4p)))
                        .appendChild(BlockHeader.create("Font 75%"))
                        .appendChild(p().appendChild(b().textContent("Lorem ipsum.").addCss(dui_font_size_3_4p)))
                        .appendChild(BlockHeader.create("Font 100%"))
                        .appendChild(p().appendChild(b().textContent("Lorem ipsum.").addCss(dui_font_size_full)))
                ));
    }
}