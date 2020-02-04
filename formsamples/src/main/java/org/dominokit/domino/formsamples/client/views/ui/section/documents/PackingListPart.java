package org.dominokit.domino.formsamples.client.views.ui.section.documents;

import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import org.dominokit.domino.formsamples.client.views.ui.section.ImportSection;
import org.dominokit.domino.formsamples.shared.model.DocumentsRequired;
import org.dominokit.domino.formsamples.shared.model.LetterOfCredit;
import org.dominokit.domino.formsamples.shared.model.PackingList;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.forms.FieldsGrouping;
import org.dominokit.domino.ui.forms.SwitchButton;
import org.dominokit.domino.ui.forms.TextBox;
import org.dominokit.domino.ui.grid.Column;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.style.Style;

import static org.dominokit.domino.formsamples.client.views.ui.CustomElements.*;
import static org.jboss.elemento.Elements.div;

public class PackingListPart implements ImportSection {

    private TextBox packingListCopiesTextBox;
    private SwitchButton packingListRequiredSwitchButton;
    private TextBox packingListTextBox;
    private Card packingListCard;
    private HTMLDivElement element = div().element();
    private FieldsGrouping fieldsGrouping = FieldsGrouping.create();

    public PackingListPart() {
        packingListCopiesTextBox = createCopiesField()
                .groupBy(fieldsGrouping);
        packingListCopiesTextBox.getInputElement().addEventListener("input", evt -> revalidate());

        packingListTextBox = createDescriptionField()
                .groupBy(fieldsGrouping);
        packingListTextBox.getInputElement().addEventListener("input", evt -> revalidate());

        packingListRequiredSwitchButton = createRequiredField()
                .addChangeHandler(value -> {
                    if (value) {
                        packingListCard.show();
                    } else {
                        packingListCard.hide();
                        revalidate();
                    }
                });

        packingListCard = Card.create("Packing list in")
                .setBodyPaddingTop("40px")
                .hide();

        packingListCard.getHeaderDescription()
                .appendChild(packingListRequiredSwitchButton.element());


        element.appendChild(packingListCard
                .appendChild(Row.create()
                        .addColumn(Column.span4().appendChild(packingListCopiesTextBox.setRequired(true).setAutoValidation(true)))
                        .addColumn(Column.span8().appendChild(packingListTextBox.setRequired(true).setAutoValidation(true))))
                .element());
    }

    @Override
    public void collect(LetterOfCredit letterOfCredit) {
        DocumentsRequired documentsRequired = letterOfCredit.getDocumentsRequired();
        PackingList packingList = new PackingList();
        packingList.setRequired(packingListRequiredSwitchButton.getValue());
        if (packingList.isRequired()) {
            packingList.setDescription(packingListTextBox.getValue());
            packingList.setNumberOfCopies(Integer.parseInt(packingListCopiesTextBox.getValue()));
        }
        documentsRequired.setPackingList(packingList);
    }

    @Override
    public boolean validate() {
        boolean valid = isValid();
        markCardValidation(packingListCard, valid);
        return valid;
    }

    public void revalidate(){
        if(isInvalidatedCard(packingListCard) && isValid()){
            markCardValidation(packingListCard, true, false);
        }
    }

    private boolean isValid() {
        return !packingListRequiredSwitchButton.getValue() || fieldsGrouping.validate().isValid();
    }

    @Override
    public HTMLElement element() {
        return element;
    }
}
