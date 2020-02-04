package org.dominokit.domino.formsamples.client.views.ui.section;

import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import org.dominokit.domino.formsamples.shared.model.*;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.forms.FieldsGrouping;
import org.dominokit.domino.ui.forms.Select;
import org.dominokit.domino.ui.forms.SelectOption;
import org.dominokit.domino.ui.grid.Column;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.header.BlockHeader;
import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.style.Style;

import java.util.List;

import static org.dominokit.domino.formsamples.client.views.ui.CustomElements.isInvalidatedCard;
import static org.dominokit.domino.formsamples.client.views.ui.CustomElements.markCardValidation;
import static org.jboss.elemento.Elements.div;

public class BeneficiarySection implements ImportSection {

    private Select<Beneficiary> beneficiariesSelect;
    private Select<Account> accountsSelect;
    private Card card;
    private HTMLDivElement element = div().element();
    private FieldsGrouping fieldsGrouping = FieldsGrouping.create();

    public BeneficiarySection(List<Beneficiary> beneficiaries) {
        element.appendChild(BlockHeader.create("Seller(Beneficiary) *").element());

        card = Card.create();


        beneficiariesSelect = Select.<Beneficiary>create("Beneficiary Name")
                .groupBy(fieldsGrouping)
                .setRequired(true)
                .setAutoValidation(true)
                .addLeftAddOn(Icons.ALL.label())
                .addSelectionHandler(option -> revalidate());

        accountsSelect = Select.<Account>create("Through")
                .addLeftAddOn(Icons.ALL.business())
                .groupBy(fieldsGrouping)
                .setRequired(true)
                .setAutoValidation(true)
                .addSelectionHandler(option -> revalidate());

        for (Beneficiary beneficiary : beneficiaries) {
            beneficiariesSelect.appendChild(SelectOption.create(beneficiary, beneficiary.getName()));
        }

        beneficiariesSelect.addSelectionHandler(option -> {
            accountsSelect.removeAllOptions();
            Beneficiary beneficiary = beneficiariesSelect.getValue();
            List<Account> accounts = beneficiary.getAccounts();
            for (Account account : accounts) {
                accountsSelect.appendChild(SelectOption.create(account, account.getAccountAlias()));
            }
        });


        element.appendChild(card
                .style()
                .setPaddingTop("20px")
                .get()
                .appendChild(Row.create()
                        .addColumn(Column.span6()
                                .appendChild(beneficiariesSelect)
                        )
                        .addColumn(Column.span6()
                                .appendChild(accountsSelect)
                        )
                )
                .element());
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
        SellerBeneficiary beneficiary = letterOfCredit.getBeneficiary();
        Beneficiary selectedBeneficiary = beneficiariesSelect.getValue();
        beneficiary.setReference(selectedBeneficiary.getId());
        beneficiary.setName(selectedBeneficiary.getName());
        beneficiary.setAddress(selectedBeneficiary.getAddress());
        ContactPerson contactPerson = new ContactPerson();
        contactPerson.setAddress(selectedBeneficiary.getContactPerson().getAddress());
        contactPerson.setEmail(selectedBeneficiary.getContactPerson().getEmail());
        contactPerson.setName(selectedBeneficiary.getContactPerson().getName());
        beneficiary.setContactPerson(contactPerson);
        beneficiary.setAccount(accountsSelect.getValue());
    }

    @Override
    public HTMLElement element() {
        return element;
    }
}
