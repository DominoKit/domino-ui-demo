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
import org.dominokit.domino.ui.grid.flex.FlexItem;
import org.dominokit.domino.ui.grid.flex.FlexLayout;
import org.dominokit.domino.ui.header.BlockHeader;
import org.dominokit.domino.ui.lists.ListGroup;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.style.Styles;
import org.dominokit.domino.ui.utils.TextNode;
import org.jboss.elemento.Elements;

import java.util.Arrays;

@UiView(presentable = BadgesProxy.class)
@SampleClass
public class BadgesViewImpl extends BaseDemoView<HTMLDivElement> implements BadgesView {


    private HTMLDivElement element = Elements.div().element();

    @Override
    protected HTMLDivElement init() {
        element.appendChild(LinkToSourceCode.create("badges", this.getClass()).element());
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
                        .addColumn(Column.span3().appendChild(Button.createSuccess("SUCCESS ")
                                .large()
                                .block()
                                .appendChild(Badge.create("4"))
                                ))
                        .addColumn(Column.span3().appendChild(Button.createPrimary("PRIMARY")
                                .large()
                                .block()
                                .appendChild(Badge.create("10+"))
                                ))
                        .addColumn(Column.span3().appendChild(Button.createDanger("DANGER")
                                .large()
                                .block()
                                .appendChild(Badge.create("8"))
                                ))
                        .addColumn(Column.span3().appendChild(Button.createWarning("WARNING")
                                .large()
                                .block()
                                .appendChild(Badge.create("3"))
                                ))
                        )
                .element());
    }

    @SampleMethod
    private void buttonExamplesWithMaterialDesignColors() {

        this.element.appendChild(Card.create("BUTTON EXAMPLES WITH MATERIAL DESIGN COLORS")
                .appendChild(Row.create()
                        .addColumn(Column.span3().appendChild(Button.create("GREEN").setBackground(Color.GREEN).large().block()
                                .appendChild(Badge.create("2"))
                                ))
                        .addColumn(Column.span3().appendChild(Button.create("BLUE").setBackground(Color.BLUE).large().block()
                                .appendChild(Badge.create("10+"))
                                ))
                        .addColumn(Column.span3().appendChild(Button.create("RED").setBackground(Color.RED).large().block()
                                .appendChild(Badge.create("13"))
                                ))
                        .addColumn(Column.span3().appendChild(Button.create("ORANGE").setBackground(Color.ORANGE).large().block()
                                .appendChild(Badge.create("5"))
                                ))
                        )
                .appendChild(Row.create()
                        .addColumn(Column.span3().appendChild(Button.create("PINK").setBackground(Color.PINK).large().block()
                                .appendChild(Badge.create("14"))
                                ))
                        .addColumn(Column.span3().appendChild(Button.create("CYAN").setBackground(Color.CYAN).large().block()
                                .appendChild(Badge.create("99+"))
                                ))
                        .addColumn(Column.span3().appendChild(Button.create("TEAL").setBackground(Color.TEAL).large().block()
                                .appendChild(Badge.create("26"))
                                ))
                        .addColumn(Column.span3().appendChild(Button.create("PURPLE").setBackground(Color.PURPLE).large().block()
                                .appendChild(Badge.create("47"))
                                ))
                        )
                .element());
    }

    @SampleMethod
    private void listExample() {

        ListGroup<BadgeSample> listGroup = ListGroup.<BadgeSample>create()
                .setItemRenderer((listGroup1, listItem) -> {
                    listItem.appendChild(FlexLayout.create()
                            .css(Styles.padding_10)
                            .appendChild(FlexItem.create()
                                    .setFlexGrow(1)
                                    .appendChild(TextNode.of(listItem.getValue().desc))
                            )
                            .appendChild(FlexItem.create()
                                    .appendChild(Badge.create(listItem.getValue().badgeText)
                                            .setBackground(listItem.getValue().color)
                                    )
                            )
                    );
                })
                .setItems(Arrays.asList(
                        new BadgeSample("Cras justo odio", "14 new", Color.RED),
                        new BadgeSample("Dapibus ac facilisis in", "99 unread", Color.CYAN),
                        new BadgeSample("Morbi leo risus", "99+", Color.TEAL),
                        new BadgeSample("Porta ac consectetur ac", "21", Color.ORANGE),
                        new BadgeSample("Vestibulum at eros", "18", Color.PURPLE)
                ));

        element.appendChild(Card.create("LIST EXAMPLE", "You can also put badge to list and use the material design colors.")
                .appendChild(listGroup)
                .element());
    }

    private static class BadgeSample{
        private final String desc;
        private final String badgeText;
        private final Color color;

        public BadgeSample(String desc, String badgeText, Color color) {
            this.desc = desc;
            this.badgeText = badgeText;
            this.color = color;
        }
    }

}