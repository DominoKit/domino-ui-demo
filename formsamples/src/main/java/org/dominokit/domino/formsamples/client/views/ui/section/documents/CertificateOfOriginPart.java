package org.dominokit.domino.formsamples.client.views.ui.section.documents;

import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import org.dominokit.domino.formsamples.client.views.ui.section.ImportSection;
import org.dominokit.domino.formsamples.shared.model.CertificateOfOrigin;
import org.dominokit.domino.formsamples.shared.model.Country;
import org.dominokit.domino.formsamples.shared.model.DocumentsRequired;
import org.dominokit.domino.formsamples.shared.model.LetterOfCredit;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.forms.*;
import org.dominokit.domino.ui.grid.Column;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.icons.Icons;

import java.util.List;

import static org.dominokit.domino.formsamples.client.views.ui.CustomElements.*;
import static org.jboss.gwt.elemento.core.Elements.div;

public class CertificateOfOriginPart implements ImportSection {

    private final TextBox numberOfCopiesTextBox;
    private TextBox certificateOfOriginCopiesTextBox;
    private SwitchButton certificateOfOriginRequiredSwitchButton;
    private TextBox certificateOfOriginTextBox;

    private Select<String> certificateOfOriginLocalizationEntitiesSelect;
    private Select<Country> certificateOfOriginOriginCountrySelect;
    private Select<Country> certificateOfOriginOriginOfGoodsCountrySelect;
    private Select<Country> certificateOfOriginOriginOfLocalizationEntitiesCountrySelect;

    private FieldsGrouping fieldsGrouping = FieldsGrouping.create();

    private Card certificateOfOriginCard;

    private HTMLDivElement element = div().asElement();

    public CertificateOfOriginPart(List<Country> countries) {
        certificateOfOriginCopiesTextBox = createCopiesField()
                .setLabel("Original copies")
                .groupBy(fieldsGrouping);

        certificateOfOriginCopiesTextBox.getInputElement().addEventListener("input", evt -> revalidate());

        numberOfCopiesTextBox = createCopiesField()
                .groupBy(fieldsGrouping);
        numberOfCopiesTextBox.getInputElement().addEventListener("input", evt -> revalidate());

        certificateOfOriginRequiredSwitchButton = createRequiredField()
                .groupBy(fieldsGrouping)
                .addChangeHandler(value -> {
                    if (value) {
                        certificateOfOriginCard.expand();
                    } else {
                        certificateOfOriginCard.collapse();
                        revalidate();
                    }
                });

        certificateOfOriginTextBox = createDescriptionField()
                .groupBy(fieldsGrouping);
        certificateOfOriginTextBox.getInputElement().addEventListener("input", evt -> revalidate());

        certificateOfOriginLocalizationEntitiesSelect = Select.<String>create("Legalization entities")
                .groupBy(fieldsGrouping)
                .setAutoValidation(true)
                .setRequired(true)
                .setLeftAddon(Icons.ALL.domain())
                .addOption(SelectOption.create("Chamber of commerce", "Chamber of commerce"))
                .addOption(SelectOption.create("Official trade office", "Official trade office"))
                .addOption(SelectOption.create("Chamber of industries", "Chamber of industries"))
                .addSelectionHandler(option -> revalidate());

        certificateOfOriginOriginCountrySelect = createCountriesSelect("Country of origins", countries)
                .groupBy(fieldsGrouping)
                .setAutoValidation(true)
                .setRequired(true)
                .addSelectionHandler(option -> revalidate());

        certificateOfOriginOriginOfGoodsCountrySelect = createCountriesSelect("Origin of goods", countries)
                .groupBy(fieldsGrouping)
                .setAutoValidation(true)
                .setRequired(true)
                .addSelectionHandler(option -> revalidate());

        certificateOfOriginOriginOfLocalizationEntitiesCountrySelect = createCountriesSelect("Country of legalization entities", countries)
                .groupBy(fieldsGrouping)
                .setAutoValidation(true)
                .setRequired(true)
                .addSelectionHandler(option -> revalidate());

        certificateOfOriginCard = Card.create("Certificate of origin in")
                .setBodyPaddingTop("40px")
                .collapse();

        certificateOfOriginCard.getHeaderDescription().appendChild(certificateOfOriginRequiredSwitchButton.asElement());


        element.appendChild(certificateOfOriginCard
                .appendChild(Row.create()
                        .addColumn(Column.span4().appendChild(certificateOfOriginCopiesTextBox))
                        .addColumn(Column.span4().appendChild(numberOfCopiesTextBox))
                ).appendChild(Row.create()
                        .addColumn(Column.span8().appendChild(certificateOfOriginTextBox)))
                .appendChild(Row.create()
                        .addColumn(Column.span6().appendChild(certificateOfOriginLocalizationEntitiesSelect))
                        .addColumn(Column.span6().appendChild(certificateOfOriginOriginCountrySelect))
                ).appendChild(Row.create()
                        .addColumn(Column.span6().copy().appendChild(certificateOfOriginOriginOfGoodsCountrySelect))
                        .addColumn(Column.span6().copy().appendChild(certificateOfOriginOriginOfLocalizationEntitiesCountrySelect)))
                .asElement());

    }


    @Override
    public void collect(LetterOfCredit letterOfCredit) {
        DocumentsRequired documentsRequired = letterOfCredit.getDocumentsRequired();
        CertificateOfOrigin certificateOfOrigin = new CertificateOfOrigin();
        certificateOfOrigin.setRequired(certificateOfOriginRequiredSwitchButton.getValue());
        if (certificateOfOrigin.isRequired()) {
            certificateOfOrigin.setDescription(certificateOfOriginTextBox.getValue());
            certificateOfOrigin.setNumberOfCopies(Integer.parseInt(certificateOfOriginCopiesTextBox.getValue()));
        }
        documentsRequired.setCertificateOfOrigin(certificateOfOrigin);
    }

    @Override
    public boolean validate() {
        boolean valid = isValid();
        markCardValidation(certificateOfOriginCard, valid);
        return valid;
    }

    public void revalidate() {
        if (isInvalidatedCard(certificateOfOriginCard) && isValid()) {
            markCardValidation(certificateOfOriginCard, true, false);
        }
    }

    private boolean isValid() {
        return !certificateOfOriginRequiredSwitchButton.getValue() ||
                fieldsGrouping.validate().isValid();
    }

    @Override
    public HTMLElement asElement() {
        return element;
    }
}
