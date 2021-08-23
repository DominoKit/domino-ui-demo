package org.dominokit.domino.datatable.client.views.ui;

import elemental2.dom.HTMLElement;
import org.dominokit.domino.datatable.client.views.model.Contact;
import org.dominokit.domino.datatable.client.views.model.Gender;
import org.dominokit.domino.ui.datatable.events.TableDataUpdatedEvent;
import org.dominokit.domino.ui.grid.Column;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.infoboxes.InfoBox;
import org.dominokit.domino.ui.style.Color;
import org.jboss.elemento.IsElement;

import java.util.List;

import static org.jboss.elemento.Elements.i;

public class ContactsTopPanel<T> implements IsElement<HTMLElement> {

    private InfoBox loaded_items_count = InfoBox.create(Icons.ALL.timelapse(), "LOADED ITEMS COUNT", "0")
            .setIconColor(Color.INDIGO)
            .setIconBackground(Color.WHITE)
            .setBackground(Color.WHITE)
            .removeShadow()
            .setHoverEffect(InfoBox.HoverEffect.ZOOM);

    private InfoBox totalItemsCount = InfoBox.create(Icons.ALL.timelapse(), "TOTAL ITEMS COUNT", "0")
            .setIconColor(Color.INDIGO)
            .setIconBackground(Color.WHITE)
            .setBackground(Color.WHITE)
            .removeShadow()
            .setHoverEffect(InfoBox.HoverEffect.ZOOM);

    private InfoBox femaleCount = InfoBox.create(i().css("fas fa-female fa-lg").element(), "FEMALES", "0")
            .setIconColor(Color.PINK)
            .setIconBackground(Color.WHITE)
            .setBackground(Color.WHITE)
            .removeShadow()
            .setHoverEffect(InfoBox.HoverEffect.ZOOM);

    private InfoBox maleCount = InfoBox.create(i().css("fas fa-male fa-lg").element(), "MALES", "0")
            .setIconColor(Color.BLUE)
            .setIconBackground(Color.WHITE)
            .setBackground(Color.WHITE)
            .removeShadow()
            .setHoverEffect(InfoBox.HoverEffect.ZOOM);

    private InfoBox goodCount = InfoBox.create(Icons.ALL.timelapse(), "GOOD BALANCE ", "0")
            .setIconColor(Color.GREEN)
            .setIconBackground(Color.WHITE)
            .setBackground(Color.WHITE)
            .removeShadow()
            .setHoverEffect(InfoBox.HoverEffect.ZOOM);

    private InfoBox dangerCount = InfoBox.create(Icons.ALL.timelapse(), "LOW BALANCE", "0")
            .setIconColor(Color.RED)
            .setIconBackground(Color.WHITE)
            .setBackground(Color.WHITE)
            .removeShadow()
            .setHoverEffect(InfoBox.HoverEffect.ZOOM);

    private Row row = Row.create()
            .condenced()
            .style()
            .setMarginBottom("0px")
            .setMarginLeft("0px")
            .setMarginRight("0px")
            .get()
            .addColumn(Column.span2().condenced()
                    .appendChild(loaded_items_count)
            )
            .addColumn(Column.span2().condenced()
                    .appendChild(totalItemsCount)
            )
            .addColumn(Column.span2().condenced()
                    .appendChild(femaleCount)
            )
            .addColumn(Column.span2().condenced()
                    .appendChild(maleCount)
            )
            .addColumn(Column.span2().condenced()
                    .appendChild(goodCount)
            )
            .addColumn(Column.span2().condenced()
                    .appendChild(dangerCount)
            );

    public ContactsTopPanel() {
        femaleCount.getIconElement().style()
                .setProperty("bottom", "15px");
        maleCount.getIconElement()
                .style()
                .setProperty("bottom", "15px");
    }

    public void update(TableDataUpdatedEvent<Contact> event) {
        loaded_items_count.getValueElement().setTextContent(event.getData().size() + "");
    }

    @Override
    public HTMLElement element() {
        return row.element();
    }

    public void update(List<Contact> contacts) {
        totalItemsCount.getValueElement().setTextContent(contacts.size() + "");
        long males = contacts.stream().filter(c -> Gender.male.equals(c.getGender())).count();
        long females = contacts.stream().filter(c -> Gender.female.equals(c.getGender())).count();
        long goods = contacts.stream().filter(c -> c.getBalance() >= 2000).count();
        long bads = contacts.stream().filter(c -> c.getBalance() < 2000).count();
        this.femaleCount.getValueElement().setTextContent(females + "");
        this.maleCount.getValueElement().setTextContent(males + "");
        this.goodCount.getValueElement().setTextContent(goods + "");
        this.dangerCount.getValueElement().setTextContent(bads + "");

    }
}
