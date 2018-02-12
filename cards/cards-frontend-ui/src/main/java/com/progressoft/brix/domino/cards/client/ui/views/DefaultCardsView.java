package com.progressoft.brix.domino.cards.client.ui.views;

import com.progressoft.brix.domino.api.client.annotations.UiView;
import com.progressoft.brix.domino.api.shared.extension.Content;
import com.progressoft.brix.domino.cards.client.presenters.CardsPresenter;
import com.progressoft.brix.domino.cards.client.views.CardsView;
import com.progressoft.brix.domino.ui.cards.Card;
import com.progressoft.brix.domino.ui.column.Column;
import com.progressoft.brix.domino.ui.row.Row;
import elemental2.dom.HTMLElement;
import elemental2.dom.Text;
import jsinterop.base.Js;

import static com.progressoft.brix.domino.ui.column.Column.*;

@UiView(presentable = CardsPresenter.class)
public class DefaultCardsView implements CardsView{

    private Row simpleCardsRow=Row.create();
    private static final String SAMPLE_CONTENT = "Quis pharetra a pharetra fames blandit. Risus faucibus velit Risus imperdiet mattis neque volutpat, etiam lacinia netus dictum magnis per facilisi sociosqu. Volutpat. Ridiculus nostra.";

    public DefaultCardsView() {
        Column column1 = createColumn();

        Card simpleCard=Card.create();
        simpleCard.getBody().appendChild(new Text(SAMPLE_CONTENT));
        column1.asElement().appendChild(simpleCard.asElement());

        Column column2 = createColumn();
        Card simpleCard1=Card.create();
        simpleCard1.getBody().appendChild(new Text(SAMPLE_CONTENT));
        column2.asElement().appendChild(simpleCard1.asElement());

        Column column3 = createColumn();
        Card simpleCard2=Card.create();
        simpleCard2.getBody().appendChild(new Text(SAMPLE_CONTENT));
        column3.asElement().appendChild(simpleCard2.asElement());
    }

    private Column createColumn() {
        return simpleCardsRow.addColumn().onLarge(OnLarge.four)
                    .onMedium(OnMedium.four)
                    .onSmall(OnSmall.twelve)
                    .onXSmall(OnXSmall.twelve);
    }

    @Override
    public void showIn(Content content) {
        HTMLElement contentElement= Js.cast(content.get());
        contentElement.appendChild(simpleCardsRow.asElement());
    }
}