package org.dominokit.domino.formsamples.client.views.ui.section;

import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import org.dominokit.domino.formsamples.shared.model.ChargesInstructions;
import org.dominokit.domino.formsamples.shared.model.CorporateProfile;
import org.dominokit.domino.formsamples.shared.model.LetterOfCredit;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.forms.SwitchButton;
import org.dominokit.domino.ui.grid.Column;
import org.dominokit.domino.ui.grid.Row;

import static org.dominokit.domino.formsamples.client.views.ui.CustomElements.isInvalidatedCard;
import static org.dominokit.domino.formsamples.client.views.ui.CustomElements.markCardValidation;
import static org.jboss.gwt.elemento.core.Elements.div;

public class CorrespondentChargesInstructionsSection implements ImportSection {

    private SwitchButton correspondentChargesSwitch;
    private CorporateAccountsSelect corporateAccountsSelect;
    private Card correspondentChargesInstructionsCard;
    private HTMLDivElement element = div().element();

    public CorrespondentChargesInstructionsSection(CorporateProfile corporateProfile) {

        correspondentChargesInstructionsCard = Card.create("Correspondent Charges Instructions", "")
                .hide();
        correspondentChargesInstructionsCard.bodyStyle()
                .setPaddingTop("40px");

        correspondentChargesSwitch = SwitchButton.create()
                .style()
                .setMarginBottom("0px")
                .get()
                .setOnTitle("Applicant")
                .setOffTitle("Beneficiary")
                .addChangeHandler(value -> {
                    if (value) {
                        correspondentChargesInstructionsCard.show();
                    } else {
                        correspondentChargesInstructionsCard.hide();
                        revalidate();
                    }
                });

        correspondentChargesInstructionsCard.getHeaderDescription().appendChild(correspondentChargesSwitch.element());

        corporateAccountsSelect = CorporateAccountsSelect.create("Charges Instructions", corporateProfile);
        corporateAccountsSelect.getAccountSelect()
                .dropup()
                .setAutoValidation(true)
                .setRequired(true)
                .addSelectionHandler(option -> revalidate());

        element.appendChild(correspondentChargesInstructionsCard
                .appendChild(Row.create()
                        .addColumn(Column.span6().appendChild(corporateAccountsSelect))
                ).element());
    }

    @Override
    public void collect(LetterOfCredit letterOfCredit) {
        ChargesInstructions chargesInstructions = letterOfCredit.getChargesInstructions();
        chargesInstructions.setOutsideCountryChargesOn(correspondentChargesSwitch.getValue() ? "APPLICANT" : "BENEFICIARIES");
    }

    @Override
    public boolean validate() {
        boolean valid = isValid();
        markCardValidation(correspondentChargesInstructionsCard, valid);
        return valid;
    }

    public void revalidate() {
        if (isInvalidatedCard(correspondentChargesInstructionsCard) && isValid()) {
            markCardValidation(correspondentChargesInstructionsCard, true, false);
        }
    }

    private boolean isValid() {
        return !correspondentChargesSwitch.getValue() ||
                corporateAccountsSelect.getAccountSelect().validate().isValid();
    }

    @Override
    public HTMLElement element() {
        return element;
    }
}
