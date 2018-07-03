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
            .setIconBackground(Color.INDIGO)
            .setBackground(Color.INDIGO)
            .flip()
            .setHoverEffect(InfoBox.HoverEffect.EXPAND);
    private InfoBox totalItemsCount = InfoBox.create(Icons.ALL.timelapse(), "TOTAL ITEMS COUNT", "0")
            .setIconBackground(Color.INDIGO)
            .setBackground(Color.INDIGO)
            .flip()
            .setHoverEffect(InfoBox.HoverEffect.EXPAND);
    private InfoBox femaleCount = InfoBox.create(i().css("fas fa-female fa-lg", Color.WHITE.getStyle()).asElement(), "FEMALES", "0")
            .setIconBackground(Color.PINK)
            .setBackground(Color.PINK)
            .flip()
            .setHoverEffect(InfoBox.HoverEffect.EXPAND);
    private InfoBox maleCount = InfoBox.create(i().css("fas fa-male fa-lg", Color.WHITE.getStyle()).asElement(), "MALES", "0")
            .setIconBackground(Color.BLUE)
            .setBackground(Color.BLUE)
            .flip()
            .setHoverEffect(InfoBox.HoverEffect.EXPAND);

    private InfoBox goodCount = InfoBox.create(Icons.ALL.timelapse(), "GOOD BALANCE ", "0")
            .setIconBackground(Color.GREEN)
            .setBackground(Color.GREEN)
            .flip()
            .setHoverEffect(InfoBox.HoverEffect.EXPAND);
    private InfoBox dangerCount = InfoBox.create(Icons.ALL.timelapse(), "LOW BALANCE", "0")
            .setIconBackground(Color.RED)
            .setBackground(Color.RED)
            .flip()
            .setHoverEffect(InfoBox.HoverEffect.EXPAND);
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
