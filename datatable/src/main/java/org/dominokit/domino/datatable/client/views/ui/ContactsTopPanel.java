package org.dominokit.domino.datatable.client.views.ui;

import elemental2.dom.HTMLElement;
import org.dominokit.domino.datatable.client.views.model.Contact;
import org.dominokit.domino.datatable.client.views.model.Gender;
import org.dominokit.domino.ui.column.Column;
import org.dominokit.domino.ui.datatable.events.TableDataUpdatedEvent;
import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.infoboxes.InfoBox;
import org.dominokit.domino.ui.row.Row;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.style.Style;
import org.jboss.gwt.elemento.core.IsElement;

import java.util.List;

import static org.jboss.gwt.elemento.core.Elements.i;

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

    private InfoBox femaleCount = InfoBox.create(i().css("fas fa-female fa-lg").asElement(), "FEMALES", "0")
            .setIconColor(Color.PINK)
            .setIconBackground(Color.WHITE)
            .setBackground(Color.WHITE)
            .removeShadow()
            .setHoverEffect(InfoBox.HoverEffect.ZOOM);

    private InfoBox maleCount = InfoBox.create(i().css("fas fa-male fa-lg").asElement(), "MALES", "0")
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

    private Column column = Column.create()
            .onLarge(Column.OnLarge.two)
            .onMedium(Column.OnMedium.two)
            .onSmall(Column.OnSmall.twelve)
            .onXSmall(Column.OnXSmall.twelve);
    private Row row = Row.create()
            .condenced()
            .style().setMarginBottom("0px")
            .get()
            .addColumn(column.copy().condenced()
                    .addElement(loaded_items_count)
            )
            .addColumn(column.copy().condenced()
                    .addElement(totalItemsCount)
            )
            .addColumn(column.copy().condenced()
                    .addElement(femaleCount)
            )
            .addColumn(column.copy().condenced()
                    .addElement(maleCount)
            )
            .addColumn(column.copy().condenced()
                    .addElement(goodCount)
            )
            .addColumn(column.copy().condenced()
                    .addElement(dangerCount)
            );

    public ContactsTopPanel() {
        Style.of(femaleCount.getIconElement())
                .setProperty("bottom", "15px");
        Style.of(maleCount.getIconElement())
                .setProperty("bottom", "15px");
    }

    public void update(TableDataUpdatedEvent<Contact> event) {
        loaded_items_count.getValueElement().textContent = event.getData().size() + "";
    }

    @Override
    public HTMLElement asElement() {
        return Style.of(row)
                .setMarginLeft("0px")
                .setMarginRight("0px").get().asElement();
    }

    public void update(List<Contact> contacts) {
        totalItemsCount.getValueElement().textContent = contacts.size() + "";
        long males = contacts.stream().filter(c -> Gender.male.equals(c.getGender())).count();
        long females = contacts.stream().filter(c -> Gender.female.equals(c.getGender())).count();
        long goods = contacts.stream().filter(c -> c.getDoubleBalance() >= 2000).count();
        long bads = contacts.stream().filter(c -> c.getDoubleBalance() < 2000).count();
        this.femaleCount.getValueElement().textContent = females + "";
        this.maleCount.getValueElement().textContent = males + "";
        this.goodCount.getValueElement().textContent = goods + "";
        this.dangerCount.getValueElement().textContent = bads + "";

    }
}
