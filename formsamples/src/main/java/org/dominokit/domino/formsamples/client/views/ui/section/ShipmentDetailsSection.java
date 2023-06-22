package org.dominokit.domino.formsamples.client.views.ui.section;

import com.google.gwt.i18n.client.DateTimeFormat;
import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import org.dominokit.domino.formsamples.shared.model.LetterOfCredit;
import org.dominokit.domino.formsamples.shared.model.ShipmentDetails;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.datepicker.DateBox;
import org.dominokit.domino.ui.forms.FieldsGrouping;
import org.dominokit.domino.ui.forms.Select;
import org.dominokit.domino.ui.forms.SelectOption;
import org.dominokit.domino.ui.forms.SwitchButton;
import org.dominokit.domino.ui.forms.TextBox;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.header.BlockHeader;
import org.dominokit.domino.ui.icons.lib.Icons;

import static org.dominokit.domino.formsamples.client.views.ui.Constants.DATE_PATTERN;
import static org.dominokit.domino.formsamples.client.views.ui.CustomElements.isInvalidatedCard;
import static org.dominokit.domino.formsamples.client.views.ui.CustomElements.markCardValidation;
import static org.dominokit.domino.ui.grid.Column.span6;
import static org.jboss.elemento.Elements.div;

public class ShipmentDetailsSection implements ImportSection {

    private DateBox latestDateOfShipmentDateBox;
    private Select<String> shipmentBySelect;
    private SwitchButton partialShipmentSwitch;
    private SwitchButton transShipmentSwitch;
    private TextBox shipmentFromTextBox;
    private TextBox shipmentToTextBox;
    private TextBox placeOfDestinationTextBox;
    private Select<String> termsOfDeliverySelect;
    private Card card;
    private HTMLDivElement element = div().element();
    private FieldsGrouping fieldsGrouping = FieldsGrouping.create();

    public ShipmentDetailsSection() {
        card = Card.create();

        latestDateOfShipmentDateBox = DateBox.create()
                .groupBy(fieldsGrouping)
                .setRequired(true)
                .setAutoValidation(true)
                .setPattern(DATE_PATTERN)
                .setHelperText(DATE_PATTERN)
                .setLabel("Latest Date Of Shipment")
                .addLeftAddOn(Icons.calendar_range());
        latestDateOfShipmentDateBox.getDatePicker().addDateSelectionHandler((date, dateTimeFormatInfo) -> revalidate());
        latestDateOfShipmentDateBox.getInputElement().addEventListener("input", evt -> revalidate());

        shipmentBySelect = Select.<String>create("Shipment By")
                .groupBy(fieldsGrouping)
                .setRequired(true)
                .setAutoValidation(true)
                .addLeftAddOn(Icons.ship_wheel())
                .appendChild(SelectOption.create("AIR_FREIGHT", "Air Freight"))
                .appendChild(SelectOption.create("SEA_FREIGHT", "Sea Freight"))
                .appendChild(SelectOption.create("LAND", "Land"))
                .appendChild(SelectOption.create("MULTIMODAL", "Multimodal"))
                .addSelectionHandler(option -> revalidate());

        partialShipmentSwitch = SwitchButton.create("Partial Shipments", "Not permitted", "Permitted")
                .value(true);

        transShipmentSwitch = SwitchButton.create("Transshipment", "Not permitted", "Permitted");

        shipmentFromTextBox = TextBox.create("Shipment From")
                .groupBy(fieldsGrouping)
                .setRequired(true)
                .setAutoValidation(true)
                .addLeftAddOn(Icons.location_enter());
        shipmentFromTextBox.getInputElement().addEventListener("input", evt -> revalidate());

        shipmentToTextBox = TextBox.create("Shipment To")
                .groupBy(fieldsGrouping)
                .setRequired(true)
                .setAutoValidation(true)
                .addLeftAddOn(Icons.location_enter());

        shipmentToTextBox.getInputElement().addEventListener("input", evt -> revalidate());

        placeOfDestinationTextBox = TextBox.create("Place Of Destination")
                .groupBy(fieldsGrouping)
                .setRequired(true)
                .setAutoValidation(true)
                .addLeftAddOn(Icons.location_enter());
        placeOfDestinationTextBox.getInputElement().addEventListener("input", evt -> revalidate());

        termsOfDeliverySelect = Select.<String>create("Terms Of Delivery (Incoterms 2010)")
                .groupBy(fieldsGrouping)
                .setRequired(true)
                .setAutoValidation(true)
                .addLeftAddOn(Icons.wallet_membership())
                .appendChild(SelectOption.create("EXW", "EXW – Ex Works (named place of delivery)"))
                .appendChild(SelectOption.create("FCA", "FCA – Free Carrier (named place of delivery)"))
                .appendChild(SelectOption.create("CPT", "CPT – Carriage Paid To (named place of destination)"))
                .appendChild(SelectOption.create("CIP", "CIP – Carriage and Insurance Paid to (named place of destination)"))
                .appendChild(SelectOption.create("DAT", "DAT – Delivered At Terminal (named terminal at port or place of destination)"))
                .appendChild(SelectOption.create("DAP", "DAP – Delivered At Place (named place of destination)"))
                .appendChild(SelectOption.create("DDP", "DDP – Delivered Duty Paid (named place of destination)"))
                .appendChild(SelectOption.create("FAS", "FAS – Free Alongside Ship (named port of shipment)"))
                .appendChild(SelectOption.create("FOB", "FOB – Free on Board (named port of shipment)"))
                .appendChild(SelectOption.create("CFR", "CFR – Cost and Freight (named port of destination)"))
                .appendChild(SelectOption.create("CIF", "CIF – Cost, Insurance & Freight (named port of destination)"))
                .addSelectionHandler(option -> revalidate());

        element.appendChild(BlockHeader.create("Shipment Details *").element());

        element.appendChild(card
                .style()
                .setPaddingTop("20px")
                .get()
                .appendChild(Row.create()
                        .addColumn(span6().appendChild(latestDateOfShipmentDateBox))
                        .addColumn(span6().appendChild(transShipmentSwitch))
                )
                .appendChild(Row.create()
                        .addColumn(span6().appendChild(shipmentBySelect))
                        .addColumn(span6().appendChild(partialShipmentSwitch))
                )
                .appendChild(Row.create()
                        .addColumn(span6().appendChild(shipmentFromTextBox))
                        .addColumn(span6().appendChild(shipmentToTextBox))
                )
                .appendChild(Row.create()
                        .addColumn(span6().appendChild(termsOfDeliverySelect))
                        .addColumn(span6().appendChild(placeOfDestinationTextBox))
                ).element());

    }

    private void revalidate() {
        if (isInvalidatedCard(card) && fieldsGrouping.validate().isValid()) {
            markCardValidation(card, true, false);
        }
    }

    @Override
    public boolean validate() {
        boolean valid = fieldsGrouping.validate().isValid();
        markCardValidation(card, valid);
        return valid;
    }

    @Override
    public void collect(LetterOfCredit letterOfCredit) {
        ShipmentDetails shipmentDetails = letterOfCredit.getShipmentDetails();
        shipmentDetails.setLatestDateOfShipment(DateTimeFormat.getFormat(DATE_PATTERN).format(latestDateOfShipmentDateBox.getValue()));
        shipmentDetails.setPartialShipmentsPermitted(partialShipmentSwitch.getValue());
        shipmentDetails.setTransshipmentPermitted(transShipmentSwitch.getValue());
        shipmentDetails.setShipmentBy(shipmentBySelect.getValue());
        shipmentDetails.setShipmentFrom(shipmentFromTextBox.getValue());
        shipmentDetails.setShipmentTo(shipmentToTextBox.getValue());
        shipmentDetails.setPlaceOfDestination(placeOfDestinationTextBox.getValue());
        shipmentDetails.setTermsOfDelivery(termsOfDeliverySelect.getValue());
    }

    @Override
    public HTMLElement element() {
        return element;
    }
}
