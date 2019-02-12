package org.dominokit.domino.formsamples.client.views.ui.section;

import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import org.dominokit.domino.formsamples.client.views.ui.BanksComponent;
import org.dominokit.domino.formsamples.shared.model.*;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.forms.FieldsGrouping;
import org.dominokit.domino.ui.forms.Select;
import org.dominokit.domino.ui.forms.TextBox;
import org.dominokit.domino.ui.grid.Column;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.header.BlockHeader;
import org.dominokit.domino.ui.icons.Icons;

import java.util.List;

import static org.dominokit.domino.formsamples.client.views.ui.CustomElements.markCardValidation;
import static org.jboss.gwt.elemento.core.Elements.div;


public class IssuerBankSection implements ImportSection {

    private Select<Bank> issuerBanksSelect;
    private Select<Branch> issuerBranchesSelect;
    private TextBox issuerAddressTextBox;
    private TextBox issuerContactPersonTextBox;
    private Row issuerBankInfoRow;
    private Card card;
    private HTMLDivElement element = div().asElement();
    private FieldsGrouping fieldsGrouping = FieldsGrouping.create();

    public IssuerBankSection(CorporateProfile corporateProfile) {
        element.appendChild(BlockHeader.create("Issuer Bank *").asElement());

        List<Bank> banks = corporateProfile.getBanks();
        BanksComponent banksComponent = BanksComponent.create(banks);

        issuerBranchesSelect = banksComponent
                .getBranchesSelect()
                .groupBy(fieldsGrouping)
                .setRequired(true)
                .setAutoValidation(true);

        issuerBanksSelect = banksComponent
                .getBanksSelect()
                .groupBy(fieldsGrouping)
                .setRequired(true)
                .setAutoValidation(true);

        issuerAddressTextBox = TextBox.create("Address");
        issuerContactPersonTextBox = TextBox.create("Contact Person");

        issuerBankInfoRow = Row.create()
                .addColumn(Column.span6()
                        .appendChild(issuerAddressTextBox
                                .setLeftAddon(Icons.ALL.location_on())
                                .setReadOnly(true)))
                .addColumn(Column.span6()
                        .appendChild(issuerContactPersonTextBox
                                .setLeftAddon(Icons.ALL.person())
                                .setReadOnly(true))
                ).hide();

        issuerBranchesSelect.addSelectionHandler(option -> issuerBankInfoRow.show());

        issuerBanksSelect.addSelectionHandler(option -> issuerBankInfoRow.hide());


        card = Card.create();
        element.appendChild(card
                .style()
                .setPaddingTop("20px")
                .get()
                .appendChild(Row.create()
                        .addColumn(Column.span6().appendChild(issuerBanksSelect))
                        .addColumn(Column.span6().appendChild(issuerBranchesSelect))
                ).appendChild(issuerBankInfoRow)
                .asElement());

        issuerBanksSelect.focus();

        issuerBranchesSelect.addSelectionHandler(option -> {
            Branch branch = option.getValue();
            issuerAddressTextBox.setValue(branch.getAddress().getCountryISOCode() + " - " + branch.getAddress().getCity());
            issuerContactPersonTextBox.setValue(branch.getContactPerson().getName());
            markCardValidation(card, true, false);
        });

    }

    @Override
    public void collect(LetterOfCredit letterOfCredit) {
        Issuer issuer = letterOfCredit.getIssuer();
        issuer.setBank(issuerBanksSelect.getValue().getSwiftCode());
        issuer.setBranch(issuerBranchesSelect.getValue().getName());
    }

    @Override
    public boolean validate() {
        boolean valid = fieldsGrouping.validate().isValid();
        markCardValidation(card, valid);
        return valid;
    }

    @Override
    public HTMLElement asElement() {
        return element;
    }
}
