package com.progressoft.brix.domino.infobox.client.ui.views;

import com.google.gwt.user.client.ui.Composite;
import com.progressoft.brix.domino.api.client.annotations.UiView;
import com.progressoft.brix.domino.api.shared.extension.Content;
import com.progressoft.brix.domino.infobox.client.presenters.InfoBoxPresenter;
import com.progressoft.brix.domino.infobox.client.views.InfoBoxView;
import com.progressoft.brix.domino.ui.cards.Card;
import com.progressoft.brix.domino.ui.column.Column;
import com.progressoft.brix.domino.ui.header.BlockHeader;
import com.progressoft.brix.domino.ui.icons.Icons;
import com.progressoft.brix.domino.ui.infoboxes.InfoBox;
import com.progressoft.brix.domino.ui.row.Row;
import com.progressoft.brix.domino.ui.style.Background;
import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import elemental2.dom.Node;
import jsinterop.base.Js;

import static org.jboss.gwt.elemento.core.Elements.col;
import static org.jboss.gwt.elemento.core.Elements.div;

@UiView(presentable = InfoBoxPresenter.class)
public class DefaultInfoBoxView extends Composite implements InfoBoxView{

    private HTMLDivElement element=div().asElement();

    public DefaultInfoBoxView() {
        basicInfoBoxes();
    }

    private void basicInfoBoxes() {
        element.appendChild(BlockHeader.create("BASIC INFO BOX", "Simple info box without effects.").asElement());

        Column column=Column.create()
                .onLarge(Column.OnLarge.three)
                .onMedium(Column.OnMedium.three)
                .onSmall(Column.OnSmall.six)
                .onXSmall(Column.OnXSmall.twelve);

        element.appendChild(Row.create()
                .addColumn(column.addElement(InfoBox.create(Icons.ALL.shopping_cart(), "NEW ORDERS", "125")
                        .setIconBackground(Background.RED).asElement()))
                .addColumn(column.copy().addElement(InfoBox.create(Icons.ALL.face(), "NEW MEMBERS", "257")
                        .setIconBackground(Background.INDIGO).asElement()))
                .addColumn(column.copy().addElement(InfoBox.create(Icons.ALL.shopping_cart(), "BOOKMARKS", "117")
                        .setIconBackground(Background.PURPLE).asElement()))
                .addColumn(column.copy().addElement(InfoBox.create(Icons.ALL.favorite(), "LIKES", "1432")
                        .setIconBackground(Background.DEEP_PURPLE).asElement()))
                .asElement());

        element.appendChild(Card.createCodeCard("Column column=Column.create()\n" +
                "        .onLarge(Column.OnLarge.three)\n" +
                "        .onMedium(Column.OnMedium.three)\n" +
                "        .onSmall(Column.OnSmall.six)\n" +
                "        .onXSmall(Column.OnXSmall.twelve);\n" +
                "\n" +
                "element.appendChild(Row.create()\n" +
                "        .addColumn(column.addElement(InfoBox.create(Icons.ALL.shopping_cart(), \"NEW ORDERS\", \"125\")\n" +
                "                .setIconBackground(Background.RED).asElement()))\n" +
                "        .addColumn(column.copy().addElement(InfoBox.create(Icons.ALL.face(), \"NEW MEMBERS\", \"257\")\n" +
                "                .setIconBackground(Background.INDIGO).asElement()))\n" +
                "        .addColumn(column.copy().addElement(InfoBox.create(Icons.ALL.shopping_cart(), \"BOOKMARKS\", \"117\")\n" +
                "                .setIconBackground(Background.PURPLE).asElement()))\n" +
                "        .addColumn(column.copy().addElement(InfoBox.create(Icons.ALL.favorite(), \"LIKES\", \"1432\")\n" +
                "                .setIconBackground(Background.DEEP_PURPLE).asElement()))\n" +
                "        .asElement());").asElement());
    }

    @Override
    public void showIn(Content content) {
        HTMLElement contentElement= Js.cast(content.get());
        contentElement.appendChild(this.element);
    }
}