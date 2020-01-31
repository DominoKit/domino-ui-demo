package org.dominokit.domino.formsamples.client.views.ui.section;

import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import org.dominokit.domino.formsamples.shared.model.*;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.forms.FieldsGrouping;
import org.dominokit.domino.ui.forms.Select;
import org.dominokit.domino.ui.grid.Column;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.header.BlockHeader;
import org.dominokit.domino.ui.style.Style;

import static org.dominokit.domino.formsamples.client.views.ui.CustomElements.isInvalidatedCard;
import static org.dominokit.domino.formsamples.client.views.ui.CustomElements.markCardValidation;
import static org.jboss.elemento.Elements.div;

public class ApplicantSection implements ImportSection {

    private CorporateAccountsSelect lcSettlementAccountsSelect;
    private CorporateAccountsSelect collateralSettlementAccountsSelect;
    private CorporateAccountsSelect feesAndChargesAccountsSelect;
    private HTMLDivElement element = div().element();
    private final Card card;
    private FieldsGrouping fieldsGrouping = FieldsGrouping.create();

    public ApplicantSection(CorporateProfile corporateProfile) {
        element.appendChild(BlockHeader.create("Buyer (Applicant) *").element());
        lcSettlementAccountsSelect = CorporateAccountsSelect.create("LC settlement accounts", corporateProfile);
        collateralSettlementAccountsSelect = CorporateAccountsSelect.create("Collateral settlement accounts", corporateProfile);
        feesAndChargesAccountsSelect = CorporateAccountsSelect.create("Fees and charges accounts", corporateProfile);

        card = Card.create();

        Select.SelectionHandler<CorporateAccount> corporateAccountSelectionHandler = option -> {
            if(isInvalidatedCard(card) && fieldsGrouping.validate().isValid()){
                markCardValidation(card, true, false);
            }
        };

        lcSettlementAccountsSelect.getAccountSelect()
                .setRequired(true)
                .setAutoValidation(true)
                .groupBy(fieldsGrouping)
                .addSelectionHandler(corporateAccountSelectionHandler);

        collateralSettlementAccountsSelect.getAccountSelect()
                .setRequired(true)
                .setAutoValidation(true)
                .groupBy(fieldsGrouping)
                .addSelectionHandler(corporateAccountSelectionHandler);

        feesAndChargesAccountsSelect.getAccountSelect()
                .setRequired(true)
                .setAutoValidation(true)
                .groupBy(fieldsGrouping)
                .addSelectionHandler(corporateAccountSelectionHandler);


        element.appendChild(card
                .style()
                .setPaddingTop("20px")
                .get()
                .appendChild(Row.create()
                        .addColumn(Column.span4()
                                .appendChild(lcSettlementAccountsSelect)
                        )
                        .addColumn(Column.span4()
                                .appendChild(collateralSettlementAccountsSelect)
                        ).addColumn(Column.span4()
                                .appendChild(feesAndChargesAccountsSelect)
                        )
                )
                .element());
    }

    @Override
    public boolean validate() {
        boolean valid = fieldsGrouping.validate().isValid();
        markCardValidation(card, valid);
        return valid;
    }

    @Override
    public void collect(LetterOfCredit letterOfCredit) {
        Applicant applicant = letterOfCredit.getApplicant();
        setLcAccount(applicant);
        setCollateralAccount(applicant);
        setFeesAndChargesAccount(applicant);
    }

    private void setFeesAndChargesAccount(Applicant applicant) {
        FeesAndChargesSettlementAccount feesAndChargesSettlementAccount = new FeesAndChargesSettlementAccount();
        CorporateAccount feesAndChargesAccount = feesAndChargesAccountsSelect.getAccountSelect().getValue();
        feesAndChargesSettlementAccount.setAccountAlias(feesAndChargesAccount.getAccountAlias());
        feesAndChargesSettlementAccount.setAccountNumber(feesAndChargesAccount.getAccountNumber());
        feesAndChargesSettlementAccount.setIban(feesAndChargesAccount.getIban());
        applicant.setFeesAndChargesSettlementAccount(feesAndChargesSettlementAccount);
    }

    private void setCollateralAccount(Applicant applicant) {
        CollateralSettlementAccount collateralSettlementAccount = new CollateralSettlementAccount();
        CorporateAccount collateralAccount = collateralSettlementAccountsSelect.getAccountSelect().getValue();
        collateralSettlementAccount.setAccountAlias(collateralAccount.getAccountAlias());
        collateralSettlementAccount.setAccountNumber(collateralAccount.getAccountNumber());
        collateralSettlementAccount.setIban(collateralAccount.getIban());
        applicant.setCollateralSettlementAccount(collateralSettlementAccount);
    }

    private void setLcAccount(Applicant applicant) {
        LcSettlementAccount lcSettlementAccount = new LcSettlementAccount();
        CorporateAccount lcAccount = lcSettlementAccountsSelect.getAccountSelect().getValue();
        lcSettlementAccount.setAccountAlias(lcAccount.getAccountAlias());
        lcSettlementAccount.setAccountNumber(lcAccount.getAccountNumber());
        lcSettlementAccount.setIban(lcAccount.getIban());
        applicant.setLcSettlementAccount(lcSettlementAccount);
    }

    @Override
    public HTMLElement element() {
        return element;
    }
}
