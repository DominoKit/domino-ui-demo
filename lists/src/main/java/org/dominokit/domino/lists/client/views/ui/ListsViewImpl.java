package org.dominokit.domino.lists.client.views.ui;

import elemental2.dom.Event;
import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.SampleClass;
import org.dominokit.domino.SampleMethod;
import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.domino.componentcase.client.ui.views.BaseDemoView;
import org.dominokit.domino.componentcase.client.ui.views.CodeCard;
import org.dominokit.domino.componentcase.client.ui.views.LinkToSourceCode;
import org.dominokit.domino.lists.client.presenters.ListsProxy;
import org.dominokit.domino.lists.client.views.ListsView;
import org.dominokit.domino.ui.badges.Badge;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.grid.Column;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.grid.flex.FlexItem;
import org.dominokit.domino.ui.grid.flex.FlexLayout;
import org.dominokit.domino.ui.header.BlockHeader;
import org.dominokit.domino.ui.lists.ListGroup;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.themes.Theme;
import org.dominokit.domino.ui.utils.DominoElement;
import org.dominokit.domino.ui.utils.TextNode;
import org.dominokit.domino.uidemoserver.shared.model.Contact;
import org.dominokit.domino.uidemoserver.shared.services.DemoServiceFactory;
import org.jboss.elemento.Elements;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.dominokit.domino.ui.style.Styles.*;
import static org.jboss.elemento.Elements.h;
import static org.jboss.elemento.Elements.img;

@UiView(presentable = ListsProxy.class)
@SampleClass
public class ListsViewImpl extends BaseDemoView<HTMLDivElement> implements ListsView {

    private HTMLDivElement element = Elements.div().element();

    @Override
    protected HTMLDivElement init() {

        element.appendChild(LinkToSourceCode.create("lists", this.getClass()).element());
        element.appendChild(BlockHeader.create("LIST GROUPS").element());

        listSample();
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.listSample())
                .element());

        return element;
    }

    @SampleMethod
    private void listSample() {

        ListGroup<Contact> singleSelectList = ListGroup.create();
        ListGroup<Contact> multiSelectList = ListGroup.create();
        element.appendChild(Card.create()
                .appendChild(Row.create()
                        .appendChild(Column.span6()
                                .appendChild(h(4).textContent("Single select"))
                                .appendChild(singleSelectList
                                        .setItemRenderer((listGroup, item) -> {
                                            item
                                                    .setSelectable(true)
                                                    .appendChild(FlexLayout
                                                            .create()
                                                            .apply(self -> {
                                                                if (!item.getValue().isActive()) {
                                                                    self.css(Color.GREY_LIGHTEN_4.getBackground());
                                                                }
                                                            })
                                                            .appendChild(FlexItem.create()
                                                                    .styler(style -> style.setWidth("5px"))
                                                                    .css(ContactUiUtils.getColor(item.getValue()).getBackground())
                                                            )

                                                            .appendChild(FlexItem.create()
                                                                    .appendChild(DominoElement.of(img(ContactUiUtils.getAvatarUrl(item.getValue())))
                                                                            .apply(self -> {
                                                                                if (!item.getValue().isActive()) {
                                                                                    self.style().setProperty("filter", "grayscale(100%)");
                                                                                }
                                                                            })
                                                                    )
                                                            )
                                                            .appendChild(FlexItem.create()
                                                                    .setFlexGrow(1)
                                                                    .css(padding_5)
                                                                    .styler(style -> style
                                                                            .setLineHeight("62px")
                                                                    )
                                                                    .appendChild(TextNode.of(item.getValue().getName()))
                                                            )
                                                            .appendChild(FlexItem.create()
                                                                    .styler(style -> style.setLineHeight("43px"))
                                                                    .css(padding_10)
                                                                    .appendChild(Badge
                                                                            .create(item.getValue().getBalance() + "")
                                                                            .setBackground(ContactUiUtils.getBalanceColor(item.getValue()).color())
                                                                    )
                                                            )

                                                            .appendChild(FlexItem.create()
                                                                    .css(p_l_10, p_r_15)
                                                                    .styler(style -> style
                                                                            .setLineHeight("62px")
                                                                            .setPaddingTop("3px")
                                                                    )
                                                                    .appendChild(ContactUiUtils.getGenderElement(item.getValue()))
                                                            )
                                                    )
                                                    .setDisabled(!item.getValue().isActive())
                                                    .onSelectionChange((item1, selected) -> {
                                                        if (selected) {
                                                            item.css(Theme.currentTheme.getScheme().color().getBackground());
                                                        } else {
                                                            item.removeCss(Theme.currentTheme.getScheme().color().getBackground());
                                                        }
                                                    });
                                        })
                                )
                        )
                        .appendChild(Column.span6()
                                .appendChild(h(4).textContent("Multi select"))
                                .appendChild(multiSelectList
                                        .setMultiSelect(true)
                                        .setItemRenderer((listGroup, item) -> {
                                            item
                                                    .setSelectable(true)
                                                    .appendChild(FlexLayout
                                                            .create()
                                                            .apply(self -> {
                                                                if (!item.getValue().isActive()) {
                                                                    self.css(Color.GREY_LIGHTEN_4.getBackground());
                                                                }
                                                            })
                                                            .appendChild(FlexItem.create()
                                                                    .styler(style -> style.setWidth("5px"))
                                                                    .css(ContactUiUtils.getColor(item.getValue()).getBackground())
                                                            )

                                                            .appendChild(FlexItem.create()
                                                                    .appendChild(DominoElement.of(img(ContactUiUtils.getAvatarUrl(item.getValue())))
                                                                            .apply(self -> {
                                                                                if (!item.getValue().isActive()) {
                                                                                    self.style().setProperty("filter", "grayscale(100%)");
                                                                                }
                                                                            })
                                                                    )
                                                            )
                                                            .appendChild(FlexItem.create()
                                                                    .setFlexGrow(1)
                                                                    .css(padding_5)
                                                                    .styler(style -> style
                                                                            .setLineHeight("62px")
                                                                    )
                                                                    .appendChild(TextNode.of(item.getValue().getName()))
                                                            )
                                                            .appendChild(FlexItem.create()
                                                                    .styler(style -> style.setLineHeight("43px"))
                                                                    .css(padding_10)
                                                                    .appendChild(Badge
                                                                            .create(item.getValue().getBalance() + "")
                                                                            .setBackground(ContactUiUtils.getBalanceColor(item.getValue()).color())
                                                                    )
                                                            )

                                                            .appendChild(FlexItem.create()
                                                                    .css(p_l_10, p_r_15)
                                                                    .styler(style -> style
                                                                            .setLineHeight("62px")
                                                                            .setPaddingTop("3px")
                                                                    )
                                                                    .appendChild(ContactUiUtils.getGenderElement(item.getValue()))
                                                            )
                                                    )
                                                    .setDisabled(!item.getValue().isActive())
                                                    .onSelectionChange((item1, selected) -> {
                                                        if (selected) {
                                                            item.css(Theme.currentTheme.getScheme().color().getBackground());
                                                        } else {
                                                            item.removeCss(Theme.currentTheme.getScheme().color().getBackground());
                                                        }
                                                    });
                                        })
                                )
                        ))
                .element());


        Random random = new Random();
        int i = random.nextInt(100 - 10);
        DemoServiceFactory.INSTANCE
                .list()
                .onSuccess(items -> {
                    singleSelectList.setItems(items.subList(i, i + 10));
                    multiSelectList.setItems(items.subList(i, i + 10));
                })
                .onFailed(failedResponse -> {
                })
                .send();
    }

    private Color getStatusColor(Status status) {
        if (Status.ONLINE.equals(status)) {
            return Color.GREEN;
        } else if (Status.AWAY.equals(status)) {
            return Color.AMBER;
        } else if (Status.DO_NOT_DISTURB.equals(status)) {
            return Color.RED;
        } else {
            return Color.GREY;
        }
    }

    private List<Person> createList(int size) {
        List<Person> collect = IntStream.range(0, size)
                .mapToObj(i -> new Person(i, "name-" + i, randomStatus(i)))
                .collect(Collectors.toList());
        return collect;
    }

    private Status randomStatus(int seed) {
        Random random = new Random(seed);
        int i = random.nextInt(100);
        if (i < 25) {
            return Status.ONLINE;
        } else if (i < 50) {
            return Status.AWAY;
        } else if (i < 75) {
            return Status.DO_NOT_DISTURB;
        } else {
            return Status.OFFLINE;
        }
    }

}