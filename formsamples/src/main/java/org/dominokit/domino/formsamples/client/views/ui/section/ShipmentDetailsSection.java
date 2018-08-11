package org.dominokit.domino.formsamples.client.views.ui.section;

import com.google.gwt.i18n.client.DateTimeFormat;
import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import org.dominokit.domino.formsamples.shared.model.LetterOfCredit;
import org.dominokit.domino.formsamples.shared.model.ShipmentDetails;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.datepicker.DateBox;
import org.dominokit.domino.ui.forms.*;
import org.dominokit.domino.ui.header.BlockHeader;
import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.row.Row;
import org.dominokit.domino.ui.style.Style;

import static org.dominokit.domino.formsamples.client.views.ui.Constants.DATE_PATTERN;
import static org.dominokit.domino.formsamples.client.views.ui.CustomElements.isInvalidatedCard;
import static org.dominokit.domino.formsamples.client.views.ui.CustomElements.markCardValidation;
import static org.dominokit.domino.ui.column.Column.span6;
import static org.jboss.gwt.elemento.core.Elements.div;

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
    private HTMLDivElement element = div().asElement();
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
                .setLeftAddon(Icons.ALL.date_range());
        latestDateOfShipmentDateBox.getDatePicker().addDateSelectionHandler((date, dateTimeFormatInfo) -> revalidate());
        latestDateOfShipmentDateBox.getInputElement().addEventListener("input", evt -> revalidate());

        shipmentBySelect = Select.<String>create("Shipment By")
                .groupBy(fieldsGrouping)
                .setRequired(true)
                .setAutoValidation(true)
                .setLeftAddon(Icons.ALL.local_shipping())
                .addOption(SelectOption.create("AIR_FREIGHT", "Air Freight"))
                .addOption(SelectOption.create("SEA_FREIGHT", "Sea Freight"))
                .addOption(SelectOption.create("LAND", "Land"))
                .addOption(SelectOption.create("MULTIMODAL", "Multimodal"))
                .addSelectionHandler(option -> revalidate());

        partialShipmentSwitch = SwitchButton.create("Partial Shipments", "Not permitted", "Permitted")
                .setValue(true);

        transShipmentSwitch = SwitchButton.create("Transshipment", "Not permitted", "Permitted");

        shipmentFromTextBox = TextBox.create("Shipment From")
                .groupBy(fieldsGrouping)
                .setRequired(true)
                .setAutoValidation(true)
                .setLeftAddon(Icons.ALL.location_on());
        shipmentFromTextBox.getInputElement().addEventListener("input", evt -> revalidate());

        shipmentToTextBox = TextBox.create("Shipment To")
                .groupBy(fieldsGrouping)
                .setRequired(true)
                .setAutoValidation(true)
                .setLeftAddon(Icons.ALL.location_on());

        shipmentToTextBox.getInputElement().addEventListener("input", evt -> revalidate());

        placeOfDestinationTextBox = TextBox.create("Place Of Destination")
                .groupBy(fieldsGrouping)
                .setRequired(true)
                .setAutoValidation(true)
                .setLeftAddon(Icons.ALL.location_on());
        placeOfDestinationTextBox.getInputElement().addEventListener("input", evt -> revalidate());

        termsOfDeliverySelect = Select.<String>create("Terms Of Delivery (Incoterms 2010)")
                .groupBy(fieldsGrouping)
                .setRequired(true)
                .setAutoValidation(true)
                .setLeftAddon(Icons.ALL.card_membership())
                .addOption(SelectOption.create("EXW", "EXW – Ex Works (named place of delivery)"))
                .addOption(SelectOption.create("FCA", "FCA – Free Carrier (named place of delivery)"))
                .addOption(SelectOption.create("CPT", "CPT – Carriage Paid To (named place of destination)"))
                .addOption(SelectOption.create("CIP", "CIP – Carriage and Insurance Paid to (named place of destination)"))
                .addOption(SelectOption.create("DAT", "DAT – Delivered At Terminal (named terminal at port or place of destination)"))
                .addOption(SelectOption.create("DAP", "DAP – Delivered At Place (named place of destination)"))
                .addOption(SelectOption.create("DDP", "DDP – Delivered Duty Paid (named place of destination)"))
                .addOption(SelectOption.create("FAS", "FAS – Free Alongside Ship (named port of shipment)"))
                .addOption(SelectOption.create("FOB", "FOB – Free on Board (named port of shipment)"))
                .addOption(SelectOption.create("CFR", "CFR – Cost and Freight (named port of destination)"))
                .addOption(SelectOption.create("CIF", "CIF – Cost, Insurance & Freight (named port of destination)"))
                .addSelectionHandler(option -> revalidate());

        element.appendChild(BlockHeader.create("Shipment Details").asElement());

        element.appendChild(Style.of(card)
                .setPaddingTop("20px")
                .get()
                .appendChild(Row.create()
                        .addColumn(span6().addElement(latestDateOfShipmentDateBox))
                        .addColumn(span6().addElement(transShipmentSwitch))
                )
                .appendChild(Row.create()
                        .addColumn(span6().addElement(shipmentBySelect))
                        .addColumn(span6().addElement(partialShipmentSwitch))
                )
                .appendChild(Row.create()
                        .addColumn(span6().addElement(shipmentFromTextBox))
                        .addColumn(span6().addElement(shipmentToTextBox))
                )
                .appendChild(Row.create()
                        .addColumn(span6().addElement(termsOfDeliverySelect))
                        .addColumn(span6().addElement(placeOfDestinationTextBox))
                ).asElement());

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
    public HTMLElement asElement() {
        return element;
    }
}
