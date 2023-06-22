package org.dominokit.domino.lists.client.views.ui;

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
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.grid.Column;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.lists.ListGroup;
import org.dominokit.domino.ui.style.BooleanCssClass;
import org.dominokit.domino.ui.typography.BlockHeader;
import org.dominokit.domino.uidemoserver.shared.model.Contact;
import org.dominokit.domino.uidemoserver.shared.services.DemoServiceFactory;

import java.util.Random;

@UiView(presentable = ListsProxy.class)
@SampleClass
public class ListsViewImpl extends BaseDemoView<HTMLDivElement> implements ListsView {

    private DivElement element = div();

    @Override
    protected HTMLDivElement init() {

        element.appendChild(LinkToSourceCode.createLink("lists", this.getClass()).element());
        element.appendChild(BlockHeader.create("LIST GROUPS").element());

        listSample();
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.listSample())
                .element());

        return element.element();
    }

    @SampleMethod
    private void listSample() {

        ListGroup<Contact> singleSelectList;
        ListGroup<Contact> multiSelectList;
        element.appendChild(Card.create()
                .appendChild(Row.create()
                        .appendChild(Column.span6()
                                        .appendChild(h(4).textContent("Single select"))
                                        .appendChild(singleSelectList = ListGroup.<Contact>create()
                                                        .setItemRenderer((listGroup, item) -> {
                                                            item
                                                                    .setSelectable(true)
                                                                    .appendChild(div().addCss(dui_flex, dui_items_center, dui_h_16, BooleanCssClass.of(dui_opacity_50, !item.getValue().isActive()))
                                                                            .appendChild(span().addCss(dui_h_full, dui_w_1, dui_self_stretch, ContactUiUtils.getColor(item.getValue()).getBackground()))
                                                                            .appendChild(img(ContactUiUtils.getAvatarUrl(item.getValue()))
                                                                                    .addCss(dui_h_16, dui_w_16)
                                                                                    .setOrRemoveCssProperty("filter", "grayscale(100%)", imageElement -> !item.getValue().isActive())
                                                                            )
                                                                            .appendChild(span()
                                                                                    .textContent(item.getValue().getName())
                                                                                    .addCss(dui_grow_1, dui_p_1)
                                                                            )
                                                                            .appendChild(Badge
                                                                                    .create(String.valueOf(item.getValue().getBalance()))
                                                                                    .addCss(ContactUiUtils.getColor(item.getValue()).getCss(), dui_fg_white, dui_order_none)
                                                                            )
                                                                            .appendChild(ContactUiUtils.getGenderElement(item.getValue()))
                                                                    )
                                                                    .setDisabled(!item.getValue().isActive())
                                                                    .addSelectionListener((source, selection) -> {
                                                                        item.addCss(BooleanCssClass.of(dui_bg_accent_l_4, selection.contains(item)));
                                                                    });
                                                        })
                                        )
                        )
                        .appendChild(Column.span6()
                                .appendChild(h(4).textContent("Multi select"))
                                .appendChild(multiSelectList = ListGroup.<Contact>create()
                                        .setMultiSelect(true)
                                        .setItemRenderer((listGroup, item) -> {
                                            item
                                                    .setSelectable(true)
                                                    .appendChild(div().addCss(dui_flex, dui_items_center, dui_h_16, BooleanCssClass.of(dui_opacity_50, !item.getValue().isActive()))
                                                            .appendChild(span().addCss(dui_h_full, dui_w_1, dui_self_stretch, ContactUiUtils.getColor(item.getValue()).getBackground()))
                                                            .appendChild(img(ContactUiUtils.getAvatarUrl(item.getValue()))
                                                                    .addCss(dui_h_16, dui_w_16)
                                                                    .setOrRemoveCssProperty("filter", "grayscale(100%)", imageElement -> !item.getValue().isActive())
                                                            )
                                                            .appendChild(span()
                                                                    .textContent(item.getValue().getName())
                                                                    .addCss(dui_grow_1, dui_p_1)
                                                            )
                                                            .appendChild(Badge
                                                                    .create(String.valueOf(item.getValue().getBalance()))
                                                                    .addCss(ContactUiUtils.getColor(item.getValue()).getCss(), dui_fg_white, dui_order_none)
                                                            )
                                                            .appendChild(ContactUiUtils.getGenderElement(item.getValue()))
                                                    )
                                                    .setDisabled(!item.getValue().isActive())
                                                    .addSelectionListener((source, selection) -> {
                                                        item.addCss(BooleanCssClass.of(dui_bg_accent_l_4, selection.contains(item)));
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


}