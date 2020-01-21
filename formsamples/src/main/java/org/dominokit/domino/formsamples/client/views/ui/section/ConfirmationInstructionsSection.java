package org.dominokit.domino.formsamples.client.views.ui.section;

import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import org.dominokit.domino.formsamples.shared.model.ConfirmationInstructions;
import org.dominokit.domino.formsamples.shared.model.CorporateProfile;
import org.dominokit.domino.formsamples.shared.model.LetterOfCredit;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.forms.SwitchButton;
import org.dominokit.domino.ui.grid.Column;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.style.Style;

import static org.dominokit.domino.formsamples.client.views.ui.CustomElements.isInvalidatedCard;
import static org.dominokit.domino.formsamples.client.views.ui.CustomElements.markCardValidation;
import static org.jboss.gwt.elemento.core.Elements.div;

public class ConfirmationInstructionsSection implements ImportSection {
    private SwitchButton chargesInstructionsRequiredSwitch;
    private SwitchButton confirmationChargesOnSwitch;
    private CorporateAccountsSelect confirmationChargesAccountSelect;
    private Card confirmationInstructionsCard;
    private HTMLDivElement element = div().element();

    public ConfirmationInstructionsSection(CorporateProfile corporateProfile) {

        confirmationChargesAccountSelect = CorporateAccountsSelect.create("Confirmation charges account", corporateProfile);
        confirmationChargesAccountSelect
                .getAccountSelect()
                .setAutoValidation(true)
                .setRequired(true)
                .addSelectionHandler(option -> revalidate())
                .hide();


        chargesInstructionsRequiredSwitch = Style.of(SwitchButton.create())
                .setMarginBottom("0px")
                .get()
                .setOffTitle("Required")
                .addChangeHandler(value -> {
                    if (value) {
                        confirmationInstructionsCard.show();
                    } else {
                        confirmationInstructionsCard.hide();
                        revalidate();
                    }
                });

        confirmationChargesOnSwitch = SwitchButton.create("Confirmation charges on", "Beneficiary", "Applicant")
                .addChangeHandler(value -> {
                    if (value) {
                        confirmationChargesAccountSelect.show();
                    } else {
                        confirmationChargesAccountSelect.hide();
                        revalidate();
                    }
                });

        confirmationInstructionsCard = Card.create("Confirmation Instructions", "")
                .hide();
        confirmationInstructionsCard.getHeaderDescription()
                .appendChild(chargesInstructionsRequiredSwitch.element());

        confirmationInstructionsCard.bodyStyle()
                .setPaddingTop("40px");

        element.appendChild(confirmationInstructionsCard
                .appendChild(Row.create()
                        .addColumn(Column.span6().appendChild(confirmationChargesOnSwitch))
                        .addColumn(Column.span6().appendChild(confirmationChargesAccountSelect))
                ).element());
    }

    @Override
    public void collect(LetterOfCredit letterOfCredit) {
        ConfirmationInstructions confirmationInstructions = letterOfCredit.getConfirmationInstructions();
        confirmationInstructions.setConfirmationRequired(chargesInstructionsRequiredSwitch.getValue());
        if (confirmationInstructions.isConfirmationRequired()) {
            confirmationInstructions.setConfirmationChargesOn(confirmationChargesOnSwitch.getValue() ? "APPLICANT" : "BENEFICIARIES");
        }
    }

    @Override
    public boolean validate() {
        boolean valid = isValid();
        markCardValidation(confirmationInstructionsCard, valid);
        return valid;
    }

    public void revalidate() {
        if (isInvalidatedCard(confirmationInstructionsCard) && isValid()) {
            markCardValidation(confirmationInstructionsCard, true, false);
        }
    }

    private boolean isValid() {
        return !chargesInstructionsRequiredSwitch.getValue() || (
                !confirmationChargesOnSwitch.getValue() ||
                        confirmationChargesAccountSelect.getAccountSelect().validate().isValid()
        );
    }

    @Override
    public HTMLElement element() {
        return element;
    }
}
