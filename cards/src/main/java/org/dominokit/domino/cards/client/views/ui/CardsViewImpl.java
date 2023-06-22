package org.dominokit.domino.cards.client.views.ui;

import elemental2.core.JsDate;
import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.SampleClass;
import org.dominokit.domino.SampleMethod;
import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.domino.cards.client.presenters.CardsProxy;
import org.dominokit.domino.cards.client.views.CardsView;
import org.dominokit.domino.componentcase.client.ui.views.BaseDemoView;
import org.dominokit.domino.componentcase.client.ui.views.CodeCard;
import org.dominokit.domino.componentcase.client.ui.views.LinkToSourceCode;
import org.dominokit.domino.ui.badges.Badge;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.cards.HeaderPosition;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.grid.Column;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.icons.lib.Icons;
import org.dominokit.domino.ui.notifications.Notification;
import org.dominokit.domino.ui.style.ColorsCss;
import org.dominokit.domino.ui.typography.BlockHeader;
import org.dominokit.domino.ui.utils.PostfixAddOn;
import org.dominokit.domino.ui.utils.PrefixAddOn;

import java.util.Date;

@UiView(presentable = CardsProxy.class)
@SampleClass
public class CardsViewImpl extends BaseDemoView<HTMLDivElement> implements CardsView {

    private static final String SAMPLE_CONTENT = "Quis pharetra a pharetra fames blandit. Risus faucibus velit Risus imperdiet mattis neque volutpat, etiam lacinia netus dictum magnis per facilisi sociosqu. Volutpat. Ridiculus nostra.";

    private DivElement element = div();

    @Override
    protected HTMLDivElement init() {
        element.appendChild(LinkToSourceCode.createLink("cards", this.getClass()).element());

        cardsWithoutHeaders();
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.cardsWithoutHeaders()).element());

        cardsWithHeaders();
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.cardsWithHeaders()).element());

        coloredCards();
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.coloredCards()).element());

        collapsibleCards();
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.collapsibleCards()).element());

        cardLogo();
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.cardLogo()).element());

        subheader();
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.subheader()).element());

        return element.element();
    }

    @SampleMethod
    private void cardsWithoutHeaders() {
        element.appendChild(BlockHeader.create("CARDS WITH HEADERS", "Simple cards without headers.").element());
        element
                .appendChild(Row.create()
                        .appendChild(Column.span4()
                                .appendChild(Card.create()
                                        .appendChild(text(SAMPLE_CONTENT))
                                )
                        )
                        .appendChild(Column.span4()
                                .appendChild(Card.create()
                                        .addCss(dui_bg_accent, dui_fg_white)
                                        .appendChild(text(SAMPLE_CONTENT))
                                )
                        )
                        .appendChild(Column.span4()
                                .appendChild(Card.create()
                                        .addCss(dui_teal)
                                        .appendChild(text(SAMPLE_CONTENT))
                                )
                        )
                )
        ;
    }

    @SampleMethod
    private void cardsWithHeaders() {
        element.appendChild(BlockHeader.create("CARDS WITH HEADERS", "cards can have a header that has a Title and an optional description.").element());
        element
                .appendChild(Row.create()
                        .appendChild(Column.span4()
                                .appendChild(Card.create("Card Title", "Description text here...")
                                        .appendChild(text(SAMPLE_CONTENT))
                                        .withHeader((card, header) -> {
                                            header.appendChild(PostfixAddOn.of(Icons.dots_vertical()
                                                    .clickable()
                                                    .addClickListener(evt -> Notification.create("More action selected").show())
                                            ));
                                        })
                                )
                        )
                        .appendChild(Column.span4()
                                .appendChild(Card.create("Card Title", "Description text here...")
                                        .addCss(dui_bg_accent, dui_fg_white)
                                        .appendChild(text(SAMPLE_CONTENT))
                                        .withHeader((card, header) -> {
                                            header.appendChild(PostfixAddOn.of(Icons.dots_vertical()
                                                    .clickable()
                                                    .addClickListener(evt -> Notification.create("More action selected").show())
                                            ));
                                        })
                                )
                        )
                        .appendChild(Column.span4()
                                .appendChild(Card.create("Card Title", "Description text here...")
                                        .addCss(dui_teal)
                                        .appendChild(text(SAMPLE_CONTENT))
                                        .withHeader((card, header) -> {
                                            header.appendChild(PostfixAddOn.of(Icons.dots_vertical()
                                                    .clickable()
                                                    .addClickListener(evt -> Notification.create("More action selected").show())
                                            ));
                                        })
                                )
                        )
                )
                .appendChild(Row.create()
                        .appendChild(Column.span4()
                                .appendChild(Card.create("Card Title", "Description text here...")
                                        .setHeaderPosition(HeaderPosition.BOTTOM)
                                        .appendChild(text(SAMPLE_CONTENT))
                                        .withHeader((card, header) -> {
                                            header.appendChild(PostfixAddOn.of(Icons.dots_vertical()
                                                    .clickable()
                                                    .addClickListener(evt -> Notification.create("More action selected").show())
                                            ));
                                        })
                                )
                        )
                        .appendChild(Column.span4()
                                .appendChild(Card.create("Card Title", "Description text here...")
                                        .setHeaderPosition(HeaderPosition.BOTTOM)
                                        .addCss(dui_accent)
                                        .appendChild(text(SAMPLE_CONTENT))
                                        .withHeader((card, header) -> {
                                            header.appendChild(PostfixAddOn.of(Icons.dots_vertical()
                                                    .clickable()
                                                    .addClickListener(evt -> Notification.create("More action selected").show())
                                            ));
                                        })
                                )
                        )
                        .appendChild(Column.span4()
                                .appendChild(Card.create("Card Title", "Description text here...")
                                        .setHeaderPosition(HeaderPosition.BOTTOM)
                                        .addCss(dui_teal)
                                        .appendChild(text(SAMPLE_CONTENT))
                                        .withHeader((card, header) -> {
                                            header.appendChild(PostfixAddOn.of(Icons.dots_vertical()
                                                    .clickable()
                                                    .addClickListener(evt -> Notification.create("More action selected").show())
                                            ));
                                        })
                                )
                        )
                );
    }

    @SampleMethod
    private void coloredCards() {
        element.appendChild(BlockHeader.create("COLORED CARDS", "You can control the background color of card, card header and card body."));
        element
                .appendChild(Row.create()
                        .appendChild(Column.span4()
                                .appendChild(Card.create("Card Title", "Description text here...")
                                        .appendChild(text(SAMPLE_CONTENT))
                                        .withHeader((card, header) -> {
                                            header
                                                    .addCss(dui_accent)
                                                    .appendChild(PostfixAddOn.of(Icons.dots_vertical()
                                                            .clickable()
                                                            .addClickListener(evt -> Notification.create("More action selected").show())
                                                    ));
                                        })
                                )
                        )
                        .appendChild(Column.span4()
                                .appendChild(Card.create("Card Title", "Description text here...")
                                        .appendChild(text(SAMPLE_CONTENT))
                                        .withHeader((card, header) -> {
                                            header
                                                    .addCss(dui_blue)
                                                    .appendChild(PostfixAddOn.of(Icons.dots_vertical()
                                                            .clickable()
                                                            .addClickListener(evt -> Notification.create("More action selected").show())
                                                    ));
                                        })
                                )
                        )
                        .appendChild(Column.span4()
                                .appendChild(Card.create("Card Title", "Description text here...")
                                        .appendChild(text(SAMPLE_CONTENT))
                                        .withHeader((card, header) -> {
                                            header
                                                    .addCss(dui_teal)
                                                    .appendChild(PostfixAddOn.of(Icons.dots_vertical()
                                                            .clickable()
                                                            .addClickListener(evt -> Notification.create("More action selected").show())
                                                    ));
                                        })
                                )
                        )
                )
                .appendChild(Row.create()
                        .appendChild(Column.span4()
                                .appendChild(Card.create("Card Title", "Description text here...")
                                        .setHeaderPosition(HeaderPosition.BOTTOM)
                                        .appendChild(text(SAMPLE_CONTENT))
                                        .withHeader((card, header) -> {
                                            header
                                                    .addCss(dui_accent)
                                                    .appendChild(PostfixAddOn.of(Icons.dots_vertical()
                                                            .clickable()
                                                            .addClickListener(evt -> Notification.create("More action selected").show())
                                                    ));
                                        })
                                )
                        )
                        .appendChild(Column.span4()
                                .appendChild(Card.create("Card Title", "Description text here...")
                                        .setHeaderPosition(HeaderPosition.BOTTOM)
                                        .appendChild(text(SAMPLE_CONTENT))
                                        .withHeader((card, header) -> {
                                            header
                                                    .addCss(dui_blue)
                                                    .appendChild(PostfixAddOn.of(Icons.dots_vertical()
                                                            .clickable()
                                                            .addClickListener(evt -> Notification.create("More action selected").show())
                                                    ));
                                        })
                                )
                        )
                        .appendChild(Column.span4()
                                .appendChild(Card.create("Card Title", "Description text here...")
                                        .setHeaderPosition(HeaderPosition.BOTTOM)
                                        .appendChild(text(SAMPLE_CONTENT))
                                        .withHeader((card, header) -> {
                                            header
                                                    .addCss(dui_teal)
                                                    .appendChild(PostfixAddOn.of(Icons.dots_vertical()
                                                            .clickable()
                                                            .addClickListener(evt -> Notification.create("More action selected").show())
                                                    ));
                                        })
                                )
                        )
                )

                .appendChild(Row.create()
                        .appendChild(Column.span4()
                                .appendChild(Card.create("Card Title", "Description text here...")
                                        .appendChild(text(SAMPLE_CONTENT))
                                        .withBody((card, body) -> body.addCss(dui_accent))
                                        .withHeader((card, header) -> {
                                            header
                                                    .appendChild(PostfixAddOn.of(Icons.dots_vertical()
                                                            .clickable()
                                                            .addClickListener(evt -> Notification.create("More action selected").show())
                                                    ));
                                        })
                                )
                        )
                        .appendChild(Column.span4()
                                .appendChild(Card.create("Card Title", "Description text here...")
                                        .appendChild(text(SAMPLE_CONTENT))
                                        .withBody((card, body) -> body.addCss(dui_blue))
                                        .withHeader((card, header) -> {
                                            header
                                                    .appendChild(PostfixAddOn.of(Icons.dots_vertical()
                                                            .clickable()
                                                            .addClickListener(evt -> Notification.create("More action selected").show())
                                                    ));
                                        })
                                )
                        )
                        .appendChild(Column.span4()
                                .appendChild(Card.create("Card Title", "Description text here...")
                                        .appendChild(text(SAMPLE_CONTENT))
                                        .withBody((card, body) -> body.addCss(dui_teal))
                                        .withHeader((card, header) -> {
                                            header
                                                    .appendChild(PostfixAddOn.of(Icons.dots_vertical()
                                                            .clickable()
                                                            .addClickListener(evt -> Notification.create("More action selected").show())
                                                    ));
                                        })
                                )
                        )
                )
                .appendChild(Row.create()
                        .appendChild(Column.span4()
                                .appendChild(Card.create("Card Title", "Description text here...")
                                        .setHeaderPosition(HeaderPosition.BOTTOM)
                                        .appendChild(text(SAMPLE_CONTENT))
                                        .withBody((card, body) -> body.addCss(dui_accent))
                                        .withHeader((card, header) -> {
                                            header
                                                    .appendChild(PostfixAddOn.of(Icons.dots_vertical()
                                                            .clickable()
                                                            .addClickListener(evt -> Notification.create("More action selected").show())
                                                    ));
                                        })
                                )
                        )
                        .appendChild(Column.span4()
                                .appendChild(Card.create("Card Title", "Description text here...")
                                        .setHeaderPosition(HeaderPosition.BOTTOM)
                                        .appendChild(text(SAMPLE_CONTENT))
                                        .withBody((card, body) -> body.addCss(dui_blue))
                                        .withHeader((card, header) -> {
                                            header
                                                    .appendChild(PostfixAddOn.of(Icons.dots_vertical()
                                                            .clickable()
                                                            .addClickListener(evt -> Notification.create("More action selected").show())
                                                    ));
                                        })
                                )
                        )
                        .appendChild(Column.span4()
                                .appendChild(Card.create("Card Title", "Description text here...")
                                        .setHeaderPosition(HeaderPosition.BOTTOM)
                                        .appendChild(text(SAMPLE_CONTENT))
                                        .withBody((card, body) -> body.addCss(dui_teal))
                                        .withHeader((card, header) -> {
                                            header
                                                    .appendChild(PostfixAddOn.of(Icons.dots_vertical()
                                                            .clickable()
                                                            .addClickListener(evt -> Notification.create("More action selected").show())
                                                    ));
                                        })
                                )
                        )
                )

                .appendChild(Row.create()
                        .appendChild(Column.span4()
                                .appendChild(Card.create("Card Title", "Description text here...")
                                        .appendChild(text(SAMPLE_CONTENT))
                                        .withBody((card, body) -> body.addCss(dui_accent))
                                        .withHeader((card, header) -> {
                                            header
                                                    .addCss(dui_bg_accent_d_2, dui_fg_white)
                                                    .appendChild(PostfixAddOn.of(Icons.dots_vertical()
                                                            .clickable()
                                                            .addClickListener(evt -> Notification.create("More action selected").show())
                                                    ));
                                        })
                                )
                        )
                        .appendChild(Column.span4()
                                .appendChild(Card.create("Card Title", "Description text here...")
                                        .appendChild(text(SAMPLE_CONTENT))
                                        .withBody((card, body) -> body.addCss(dui_blue))
                                        .withHeader((card, header) -> {
                                            header
                                                    .addCss(dui_bg_blue_d_2, dui_fg_white)
                                                    .appendChild(PostfixAddOn.of(Icons.dots_vertical()
                                                            .clickable()
                                                            .addClickListener(evt -> Notification.create("More action selected").show())
                                                    ));
                                        })
                                )
                        )
                        .appendChild(Column.span4()
                                .appendChild(Card.create("Card Title", "Description text here...")
                                        .appendChild(text(SAMPLE_CONTENT))
                                        .withBody((card, body) -> body.addCss(dui_teal))
                                        .withHeader((card, header) -> {
                                            header
                                                    .addCss(dui_bg_teal_d_2, dui_fg_white)
                                                    .appendChild(PostfixAddOn.of(Icons.dots_vertical()
                                                            .clickable()
                                                            .addClickListener(evt -> Notification.create("More action selected").show())
                                                    ));
                                        })
                                )
                        )
                )
                .appendChild(Row.create()
                        .appendChild(Column.span4()
                                .appendChild(Card.create("Card Title", "Description text here...")
                                        .setHeaderPosition(HeaderPosition.BOTTOM)
                                        .appendChild(text(SAMPLE_CONTENT))
                                        .withBody((card, body) -> body.addCss(dui_accent))
                                        .withHeader((card, header) -> {
                                            header
                                                    .addCss(dui_bg_accent_d_2, dui_fg_white)
                                                    .appendChild(PostfixAddOn.of(Icons.dots_vertical()
                                                            .clickable()
                                                            .addClickListener(evt -> Notification.create("More action selected").show())
                                                    ));
                                        })
                                )
                        )
                        .appendChild(Column.span4()
                                .appendChild(Card.create("Card Title", "Description text here...")
                                        .setHeaderPosition(HeaderPosition.BOTTOM)
                                        .appendChild(text(SAMPLE_CONTENT))
                                        .withBody((card, body) -> body.addCss(dui_blue))
                                        .withHeader((card, header) -> {
                                            header
                                                    .addCss(dui_bg_blue_d_2, dui_fg_white)
                                                    .appendChild(PostfixAddOn.of(Icons.dots_vertical()
                                                            .clickable()
                                                            .addClickListener(evt -> Notification.create("More action selected").show())
                                                    ));
                                        })
                                )
                        )
                        .appendChild(Column.span4()
                                .appendChild(Card.create("Card Title", "Description text here...")
                                        .setHeaderPosition(HeaderPosition.BOTTOM)
                                        .appendChild(text(SAMPLE_CONTENT))
                                        .withBody((card, body) -> body.addCss(dui_teal))
                                        .withHeader((card, header) -> {
                                            header
                                                    .addCss(dui_bg_teal_d_2, dui_fg_white)
                                                    .appendChild(PostfixAddOn.of(Icons.dots_vertical()
                                                            .clickable()
                                                            .addClickListener(evt -> Notification.create("More action selected").show())
                                                    ));
                                        })
                                )
                        )
                );
    }

    @SampleMethod
    private void collapsibleCards() {
        element.appendChild(BlockHeader.create("COLLAPSIBLE CARDS", "cards can be collapsible.").element());

        element
                .appendChild(Row.create()
                        .appendChild(Column.span4()
                                .appendChild(Card.create("Card Title", "Description text here...")
                                        .setCollapsible(true)
                                        .appendChild(text(SAMPLE_CONTENT))
                                        .withHeader((card, header) -> {
                                            header.appendChild(PostfixAddOn.of(Icons.dots_vertical()
                                                    .clickable()
                                                    .addClickListener(evt -> Notification.create("More action selected").show())
                                            ));
                                        })
                                )
                        )
                        .appendChild(Column.span4().addCss(dui_relative)
                                .appendChild(Card.create("Card Title", "Description text here...")
                                        .setCollapsible(true)
                                        .setHeaderPosition(HeaderPosition.BOTTOM)
                                        .addCss(dui_accent, dui_absolute, dui_bottom_0)
                                        .appendChild(text(SAMPLE_CONTENT))
                                        .withHeader((card, header) -> {
                                            header.appendChild(PostfixAddOn.of(Icons.dots_vertical()
                                                    .clickable()
                                                    .addClickListener(evt -> Notification.create("More action selected").show())
                                            ));
                                        })
                                )
                        )
                        .appendChild(Column.span4()
                                .appendChild(Card.create("Card Title", "Description text here...")
                                        .setCollapsible(true)
                                        .setHeaderPosition(HeaderPosition.BOTTOM)
                                        .addCss(dui_teal)
                                        .appendChild(text(SAMPLE_CONTENT))
                                        .withHeader((card, header) -> {
                                            header.appendChild(PostfixAddOn.of(Icons.dots_vertical()
                                                    .clickable()
                                                    .addClickListener(evt -> Notification.create("More action selected").show())
                                            ));
                                        })
                                )
                        )
                );
    }

    @SampleMethod
    private void cardLogo() {
        element.appendChild(BlockHeader.create("CARDS WITH LOGO", "Cards can have logo image in the header"));
        element
                .appendChild(Row.create()
                        .appendChild(Column.span4()
                                .appendChild(Card.create("Card Title", "Description text here...")
                                        .setCollapsible(true)
                                        .appendChild(text(SAMPLE_CONTENT))
                                        .withHeader((card, header) -> {
                                            header
                                                    .setLogo(img("http://placehold.jp/3d4070/ffffff/36x36.png"))
                                                    .appendChild(PostfixAddOn.of(Icons.dots_horizontal()
                                                            .clickable()
                                                            .addClickListener(evt -> Notification.create("More action selected").show())
                                                    ))
                                                    .appendChild(PrefixAddOn.of(Icons.dots_vertical().clickable()));
                                        })
                                )
                        )
                        .appendChild(Column.span4().addCss(dui_relative)
                                .appendChild(Card.create("Card Title", "Description text here...")
                                        .setCollapsible(true)
                                        .setHeaderPosition(HeaderPosition.BOTTOM)
                                        .addCss(dui_accent, dui_absolute, dui_bottom_0)
                                        .appendChild(text(SAMPLE_CONTENT))
                                        .withHeader((card, header) -> {
                                            header
                                                    .setLogo(img("http://placehold.jp/3d4070/ffffff/36x36.png").addCss(dui_rounded_full))
                                                    .appendChild(PostfixAddOn.of(Icons.dots_horizontal()
                                                            .clickable()
                                                            .addClickListener(evt -> Notification.create("More action selected").show())
                                                    ))
                                                    .appendChild(PrefixAddOn.of(Icons.dots_vertical().clickable()));
                                        })
                                )
                        )
                        .appendChild(Column.span4()
                                .appendChild(Card.create("Card Title", "Description text here...")
                                        .setCollapsible(true)
                                        .setHeaderPosition(HeaderPosition.BOTTOM)
                                        .addCss(dui_teal)
                                        .appendChild(text(SAMPLE_CONTENT))
                                        .withHeader((card, header) -> {
                                            header
                                                    .setLogo(img("http://placehold.jp/3d4070/ffffff/36x36.png"))
                                                    .appendChild(PostfixAddOn.of(Icons.dots_horizontal()
                                                            .clickable()
                                                            .addClickListener(evt -> Notification.create("More action selected").show())
                                                    ))
                                                    .appendChild(PrefixAddOn.of(Icons.dots_vertical().clickable()));
                                        })
                                )
                        )
                );
    }

    @SampleMethod
    private void subheader() {
        element.appendChild(BlockHeader.create("SUB HEADER", "Cards can have an additional sub header."));
        element
                .appendChild(Row.create()
                        .appendChild(Column.span6()
                                .appendChild(Card.create("Card Title", "Description text here...")
                                        .setCollapsible(true)
                                        .appendChild(text(SAMPLE_CONTENT))
                                        .withHeader((card, header) -> {
                                            header
                                                    .setLogo(img("http://placehold.jp/36x36.png"))
                                                    .appendChild(PostfixAddOn.of(Badge.create("25+")))
                                                    .appendChild(PostfixAddOn.of(Icons.dots_horizontal()
                                                            .clickable()
                                                            .addClickListener(evt -> Notification.create("More action selected").show())
                                                    ))
                                                    .appendChild(PrefixAddOn.of(Icons.dots_vertical().clickable()))
                                                    .withSubHeader((mainHeader, subHeader) -> {
                                                        subHeader
                                                                .appendChild(small().textContent(new JsDate().toLocaleDateString()).addCss(dui_grow_1))
                                                                .appendChild(PostfixAddOn.of(Badge.create("important").addCss(dui_red)));
                                                    });
                                        })
                                )
                        )
                        .appendChild(Column.span6()
                                .appendChild(Card.create("Card Title", "Description text here...")
                                        .setCollapsible(true)
                                        .setHeaderPosition(HeaderPosition.BOTTOM)
                                        .addCss(dui_teal)
                                        .appendChild(text(SAMPLE_CONTENT))
                                        .withHeader((card, header) -> {
                                            header
                                                    .setLogo(img("http://placehold.jp/36x36.png"))
                                                    .appendChild(PostfixAddOn.of(Badge.create("25+").addCss(dui_bg_teal_d_2, dui_fg_white)))
                                                    .appendChild(PostfixAddOn.of(Icons.dots_horizontal()
                                                            .clickable()
                                                            .addClickListener(evt -> Notification.create("More action selected").show())
                                                    ))
                                                    .appendChild(PrefixAddOn.of(Icons.dots_vertical().clickable()))
                                                    .withSubHeader((mainHeader, subHeader) -> {
                                                        subHeader
                                                                .appendChild(small().textContent(new JsDate().toLocaleDateString()).addCss(dui_grow_1))
                                                                .appendChild(PostfixAddOn.of(Badge.create("important").addCss(dui_red)));
                                                    });
                                        })
                                )
                        )
                );
    }
}