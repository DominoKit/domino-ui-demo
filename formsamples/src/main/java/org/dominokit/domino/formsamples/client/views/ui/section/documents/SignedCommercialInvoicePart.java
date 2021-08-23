package org.dominokit.domino.formsamples.client.views.ui.section.documents;

import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import org.dominokit.domino.formsamples.client.views.ui.section.ImportSection;
import org.dominokit.domino.formsamples.shared.model.Country;
import org.dominokit.domino.formsamples.shared.model.DocumentsRequired;
import org.dominokit.domino.formsamples.shared.model.LetterOfCredit;
import org.dominokit.domino.formsamples.shared.model.SignedCommercialInvoice;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.forms.FieldsGrouping;
import org.dominokit.domino.ui.forms.Select;
import org.dominokit.domino.ui.forms.SelectOption;
import org.dominokit.domino.ui.forms.SwitchButton;
import org.dominokit.domino.ui.forms.TextBox;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.icons.Icons;

import java.util.List;

import static org.dominokit.domino.formsamples.client.views.ui.CustomElements.createCopiesField;
import static org.dominokit.domino.formsamples.client.views.ui.CustomElements.createCountriesSelect;
import static org.dominokit.domino.formsamples.client.views.ui.CustomElements.createDescriptionField;
import static org.dominokit.domino.formsamples.client.views.ui.CustomElements.createRequiredField;
import static org.dominokit.domino.formsamples.client.views.ui.CustomElements.isInvalidatedCard;
import static org.dominokit.domino.formsamples.client.views.ui.CustomElements.markCardValidation;
import static org.dominokit.domino.ui.grid.Column.span4;
import static org.dominokit.domino.ui.grid.Column.span6;
import static org.dominokit.domino.ui.grid.Column.span8;
import static org.jboss.elemento.Elements.div;

public class SignedCommercialInvoicePart implements ImportSection {

    private TextBox signedCommercialInvoiceOriginalCopiesTextBox;
    private TextBox signedCommercialInvoiceCopiesTextBox;
    private SwitchButton signedCommercialInvoiceRequiredSwitchButton;
    private TextBox signedCommercialInvoiceTextBox;

    private Select<String> signedCommercialLocalizationEntitiesSelect;
    private Select<Country> signedCommercialOriginCountrySelect;
    private Select<Country> signedCommercialOriginOfGoodsCountrySelect;
    private Select<Country> signedCommercialOriginOfLocalizationEntityCountrySelect;
    private Card signedCommercialInvoiceInCard;

    private FieldsGrouping fieldsGrouping = FieldsGrouping.create();

    private HTMLDivElement element = div().element();


    public SignedCommercialInvoicePart(List<Country> countries) {

        signedCommercialInvoiceInCard = Card.create("Signed commercial invoice in")
                .setBodyPaddingTop("40px")
                .hide();

        signedCommercialInvoiceOriginalCopiesTextBox = createCopiesField()
                .groupBy(fieldsGrouping)
                .setLabel("Number of original copies");
        signedCommercialInvoiceOriginalCopiesTextBox.getInputElement().addEventListener("input", evt -> revalidate());

        signedCommercialInvoiceCopiesTextBox = createCopiesField()
                .groupBy(fieldsGrouping);
        signedCommercialInvoiceCopiesTextBox.getInputElement().addEventListener("input", evt -> revalidate());

        signedCommercialInvoiceRequiredSwitchButton = createRequiredField()
                .groupBy(fieldsGrouping)
                .addChangeHandler(value -> {
                    if (value) {
                        signedCommercialInvoiceInCard.show();
                    } else {
                        signedCommercialInvoiceInCard.hide();
                        revalidate();
                    }
                });

        signedCommercialInvoiceTextBox = createDescriptionField()
                .groupBy(fieldsGrouping)
        ;
        signedCommercialInvoiceTextBox.getInputElement().addEventListener("input", evt -> revalidate());

        signedCommercialLocalizationEntitiesSelect = Select.<String>create("Legalization entities")
                .groupBy(fieldsGrouping)
                .setAutoValidation(true)
                .setRequired(true)
                .addLeftAddOn(Icons.ALL.domain())
                .appendChild(SelectOption.create("Chamber of commerce", "Chamber of commerce"))
                .appendChild(SelectOption.create("Official trade office", "Official trade office"))
                .appendChild(SelectOption.create("Chamber of industries", "Chamber of industries"))
                .addSelectionHandler(option -> revalidate());

        signedCommercialOriginCountrySelect = createCountriesSelect("Country of origins", countries)
                .groupBy(fieldsGrouping)
                .setAutoValidation(true)
                .setRequired(true)
                .addSelectionHandler(option -> revalidate());

        signedCommercialOriginOfGoodsCountrySelect = createCountriesSelect("Origin of goods", countries)
                .groupBy(fieldsGrouping)
                .setAutoValidation(true)
                .setRequired(true)
                .addSelectionHandler(option -> revalidate());

        signedCommercialOriginOfLocalizationEntityCountrySelect = createCountriesSelect("Country of legalization entities", countries)
                .groupBy(fieldsGrouping)
                .setAutoValidation(true)
                .setRequired(true)
                .addSelectionHandler(option -> revalidate());


        signedCommercialInvoiceInCard.getHeaderDescription()
                .appendChild(signedCommercialInvoiceRequiredSwitchButton.element());

        element.appendChild(signedCommercialInvoiceInCard
                .appendChild(Row.create()
                        .addColumn(span4().appendChild(signedCommercialInvoiceOriginalCopiesTextBox))
                        .addColumn(span4().appendChild(signedCommercialInvoiceCopiesTextBox))
                        .addColumn(span8().appendChild(signedCommercialInvoiceTextBox))

                ).appendChild(Row.create()
                        .addColumn(span6().appendChild(signedCommercialLocalizationEntitiesSelect))
                        .addColumn(span6().appendChild(signedCommercialOriginCountrySelect))
                ).appendChild(Row.create()
                        .addColumn(span6().appendChild(signedCommercialOriginOfGoodsCountrySelect))
                        .addColumn(span6().appendChild(signedCommercialOriginOfLocalizationEntityCountrySelect)))
                .element());
    }

    @Override
    public void collect(LetterOfCredit letterOfCredit) {
        DocumentsRequired documentsRequired = letterOfCredit.getDocumentsRequired();
        SignedCommercialInvoice signedCommercialInvoice = new SignedCommercialInvoice();
        signedCommercialInvoice.setRequired(signedCommercialInvoiceRequiredSwitchButton.getValue());
        if (signedCommercialInvoice.isRequired()) {
            signedCommercialInvoice.setDescription(signedCommercialInvoiceTextBox.getValue());
            signedCommercialInvoice.setNumberOfCopies(Integer.parseInt(signedCommercialInvoiceCopiesTextBox.getValue()));
        }
        documentsRequired.setSignedCommercialInvoice(signedCommercialInvoice);
    }

    @Override
    public boolean validate() {
        boolean valid = isValid();
        markCardValidation(signedCommercialInvoiceInCard, valid);
        return valid;
    }

    public void revalidate() {
        if (isInvalidatedCard(signedCommercialInvoiceInCard) && isValid()) {
            markCardValidation(signedCommercialInvoiceInCard, true, false);
        }
    }

    private boolean isValid() {
        return !signedCommercialInvoiceRequiredSwitchButton.getValue() || fieldsGrouping.validate().isValid();
    }

    @Override
    public HTMLElement element() {
        return element;
    }
}
