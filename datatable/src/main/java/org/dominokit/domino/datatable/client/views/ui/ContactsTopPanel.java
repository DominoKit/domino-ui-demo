package org.dominokit.domino.datatable.client.views.ui;

import elemental2.dom.HTMLElement;
import org.dominokit.domino.datatable.client.views.model.Contact;
import org.dominokit.domino.datatable.client.views.model.Gender;
import org.dominokit.domino.ui.IsElement;
import org.dominokit.domino.ui.datatable.events.TableDataUpdatedEvent;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.icons.lib.Icons;
import org.dominokit.domino.ui.infoboxes.InfoBox;
import org.dominokit.domino.ui.style.SpacingCss;

import java.util.List;

import static org.dominokit.domino.ui.style.ColorsCss.*;
import static org.dominokit.domino.ui.style.DisplayCss.dui_elevation_0;
import static org.dominokit.domino.ui.style.GenericCss.dui_fg;
import static org.dominokit.domino.ui.style.SpacingCss.dui_gap_0;
import static org.dominokit.domino.ui.style.SpacingCss.dui_items_start;
import static org.dominokit.domino.ui.utils.ElementsFactory.elements;


public class ContactsTopPanel<T> implements IsElement<HTMLElement> {

    private InfoBox loaded_items_count = InfoBox.create(Icons.timelapse(), "LOADED COUNT", "0")
            .withContent((parent, self) -> self.addCss(dui_items_start))
            .withIcon((parent, self) -> self.addCss(dui_bg_dominant, dui_fg_indigo_l_1))
            .addCss(dui_fg_indigo_l_1, dui_elevation_0)
            .setHoverEffect(InfoBox.HoverEffect.ZOOM);

    private InfoBox totalItemsCount = InfoBox.create(Icons.timelapse(), "TOTAL COUNT", "0")
            .withContent((parent, self) -> self.addCss(dui_items_start))
            .withIcon((parent, self) -> self.addCss(dui_bg_dominant, dui_fg_indigo_l_1))
            .addCss(dui_fg_indigo_l_1, dui_elevation_0)
            .setHoverEffect(InfoBox.HoverEffect.ZOOM);

    private InfoBox femaleCount = InfoBox.create(Icons.gender_female(), "FEMALES", "0")
            .withContent((parent, self) -> self.addCss(dui_items_start))
            .withIcon((parent, self) -> self.addCss(dui_fg_pink, dui_bg_dominant))
            .addCss(dui_fg_pink, dui_elevation_0)
            .setHoverEffect(InfoBox.HoverEffect.ZOOM);

    private InfoBox maleCount = InfoBox.create(Icons.gender_male(), "MALES", "0")
            .withContent((parent, self) -> self.addCss(dui_items_start))
            .withIcon((parent, self) -> self.addCss(dui_fg_blue, dui_bg_dominant))
            .addCss(dui_fg_blue, dui_elevation_0)
            .setHoverEffect(InfoBox.HoverEffect.ZOOM);

    private InfoBox goodCount = InfoBox.create(Icons.timelapse(), "GOOD BALANCE ", "0")
            .withContent((parent, self) -> self.addCss(dui_items_start))
            .withIcon((parent, self) -> self.addCss(dui_fg_green, dui_bg_dominant))
            .addCss(dui_fg_green, dui_elevation_0)
            .setHoverEffect(InfoBox.HoverEffect.ZOOM);

    private InfoBox dangerCount = InfoBox.create(Icons.timelapse(), "LOW BALANCE", "0")
            .withContent((parent, self) -> self.addCss(dui_items_start))
            .withIcon((parent, self) -> self.addCss(dui_fg_red, dui_bg_dominant))
            .addCss(dui_fg_red, dui_elevation_0)
            .setHoverEffect(InfoBox.HoverEffect.ZOOM);

    private Row row = Row.create()
            .addCss(dui_gap_0)
            .span2(loaded_items_count)
            .span2(totalItemsCount)
            .span2(femaleCount)
            .span2(maleCount)
            .span2(goodCount)
            .span2(dangerCount);

    public ContactsTopPanel() {

    }

    public void update(TableDataUpdatedEvent<Contact> event) {
        loaded_items_count.setInfo(event.getData().size() + "");
    }

    @Override
    public HTMLElement element() {
        return row.element();
    }

    public void update(List<Contact> contacts) {
        totalItemsCount.setInfo(contacts.size() + "");

        long males = contacts.stream().filter(c -> Gender.male.equals(c.getGender())).count();
        long females = contacts.stream().filter(c -> Gender.female.equals(c.getGender())).count();
        long goods = contacts.stream().filter(c -> c.getBalance() >= 2000).count();
        long bads = contacts.stream().filter(c -> c.getBalance() < 2000).count();

        this.femaleCount.setInfo(females + "");
        this.maleCount.setInfo(males + "");
        this.goodCount.setInfo(goods + "");
        this.dangerCount.setInfo(bads + "");
    }
}
