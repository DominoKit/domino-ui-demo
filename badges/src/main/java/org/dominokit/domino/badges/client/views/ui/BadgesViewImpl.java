package org.dominokit.domino.badges.client.views.ui;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.SampleClass;
import org.dominokit.domino.SampleMethod;
import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.domino.badges.client.presenters.BadgesProxy;
import org.dominokit.domino.badges.client.views.BadgesView;
import org.dominokit.domino.componentcase.client.ui.views.BaseDemoView;
import org.dominokit.domino.componentcase.client.ui.views.CodeCard;
import org.dominokit.domino.componentcase.client.ui.views.LinkToSourceCode;
import org.dominokit.domino.ui.badges.Badge;
import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.grid.Column;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.icons.lib.Icons;
import org.dominokit.domino.ui.lists.ListGroup;
import org.dominokit.domino.ui.style.CssClass;
import org.dominokit.domino.ui.typography.BlockHeader;

import java.util.Arrays;


@UiView(presentable = BadgesProxy.class)
@SampleClass
public class BadgesViewImpl extends BaseDemoView<HTMLDivElement> implements BadgesView {

    private HTMLDivElement element = div().element();

    @Override
    protected HTMLDivElement init() {
        element.appendChild(LinkToSourceCode.createLink("badges", this.getClass()).element());
        element.appendChild(BlockHeader.create("BADGES").element());

        buttonExample();
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.buttonExample()).element());

        buttonExamplesWithMaterialDesignColors();
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.buttonExamplesWithMaterialDesignColors()).element());

        listExample();
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.listExample())
                .element());

        return element;
    }

    @SampleMethod
    private void buttonExample() {

        element.appendChild(Card.create("BUTTON EXAMPLES")
                .appendChild(Row.create()
                        .appendChild(Column.span3().appendChild(Button.create("SUCCESS")
                                .addCss(dui_success)
                                .appendChild(Badge.create("4").addCss(dui_rounded_full))
                        ))
                        .appendChild(Column.span3().appendChild(Button.create("PRIMARY")
                                .addCss(dui_primary)
                                .appendChild(Badge.create("10+").addCss(dui_bg_white, dui_fg_grey_d_2, dui_rounded_full))
                        ))
                        .appendChild(Column.span3().appendChild(Button.create("DANGER")
                                .addCss(dui_error)
                                .appendChild(Badge.create("8").addCss(dui_bg_white, dui_fg_red, dui_rounded_md))
                        ))
                        .appendChild(Column.span3().appendChild(Button.create("WARNING")
                                .addCss(dui_warning)
                                .appendChild(Badge.create("99999999+").addCss(dui_bg_white, dui_fg_grey_d_2))
                        ))
                )
                .element());
    }

    @SampleMethod
    private void buttonExamplesWithMaterialDesignColors() {

        this.element.appendChild(Card.create("BUTTON EXAMPLES WITH MATERIAL DESIGN COLORS")
                .appendChild(Row.create()
                        .appendChild(Column.span3()
                                .appendChild(Icons.bell()
                                        .appendChild(Badge.create("4").addCss(dui_bg_red, dui_rounded_full, dui_fg_white))
                                )
                        )
                        .appendChild(Column.span3()
                                .appendChild(Icons.bell()
                                        .appendChild(Badge.create("9999999999").addCss(dui_bg_red, dui_rounded_full, dui_fg_white))
                                )
                        )
                        .appendChild(Column.span3()
                                .appendChild(Icons.account()
                                        .appendChild(Badge.create("5")
                                                .addCss(dui_bg_amber,
                                                        dui_rounded_md,
                                                        dui_fg_white,
                                                        dui_top_14
                                                )
                                        )
                                )
                        )
                        .appendChild(Column.span3()
                                .appendChild(Icons.account()
                                        .clickable()
                                        .appendChild(Badge.create("10")
                                                .addCss(dui_bg_amber,
                                                        dui_rounded_xl,
                                                        dui_fg_white,
                                                        dui_top_14
                                                )
                                        )
                                )
                        )
                )
                .element());
    }

    @SampleMethod
    private void listExample() {

        ListGroup<BadgeSample> listGroup = ListGroup.<BadgeSample>create()
                .setItemRenderer((listGroup1, listItem) -> {
                    listItem.appendChild(div().addCss(dui_flex, dui_p_4)
                            .appendChild(div().addCss(dui_flex, dui_items_center, dui_grow_1)
                                    .appendChild(text(listItem.getValue().desc))
                            )
                            .appendChild(div()
                                    .appendChild(Badge.create(listItem.getValue().badgeText)
                                            .addCss(listItem.getValue().cssClasses)
                                    )
                            )
                    );
                })
                .setItems(Arrays.asList(
                        new BadgeSample("Cras justo odio", "14 new", dui_bg_red, dui_rounded_md),
                        new BadgeSample("Dapibus ac facilisis in", "99 unread", dui_bg_cyan, dui_rounded_full),
                        new BadgeSample("Morbi leo risus", "99+", dui_bg_teal, dui_border, dui_border_solid, dui_border_teal_d_4),
                        new BadgeSample("Porta ac consectetur ac", "21", dui_bg_orange, dui_rounded_full, dui_border_1, dui_border_solid, dui_border_amber),
                        new BadgeSample("Vestibulum at eros", "18", dui_bg_inherit, dui_fg_inherit, dui_border_1, dui_border_solid, dui_border_accent_d_2)
                ));

        element.appendChild(Card.create("LIST EXAMPLE", "You can also put badge to list and use the material design colors.")
                .appendChild(listGroup)
                .element());
    }

    private static class BadgeSample {
        private final String desc;
        private final String badgeText;
        private final CssClass[] cssClasses;

        public BadgeSample(String desc, String badgeText, CssClass... cssClasses) {
            this.desc = desc;
            this.badgeText = badgeText;
            this.cssClasses = cssClasses;
        }
    }

}