package org.dominokit.domino.formsamples.client.views.ui;

import org.dominokit.domino.formsamples.shared.model.Bank;
import org.dominokit.domino.formsamples.shared.model.Branch;
import org.dominokit.domino.ui.forms.Select;
import org.dominokit.domino.ui.forms.SelectOption;
import org.dominokit.domino.ui.icons.Icons;

import java.util.List;

import static org.jboss.elemento.Elements.i;

public class BanksComponent {

    private Select<Bank> banksSelect;
    private Select<Branch> branchesSelect;

    public BanksComponent() {
        banksSelect = Select.<Bank>create("Bank")
                .addLeftAddOn(i().css("fas", "fa-university", "fa-lg"));
        branchesSelect = Select.<Branch>create("Branch")
                .addLeftAddOn(Icons.ALL.domain_mdi())
                .disable();

        banksSelect.addSelectionHandler(option -> {
            branchesSelect.enable();
            Bank bank = option.getValue();
            List<Branch> branches = bank.getBranches();
            branchesSelect.removeAllOptions();
            for (Branch branch : branches) {
                branchesSelect.appendChild(SelectOption.create(branch, branch.getName()));
            }
        });
    }

    public BanksComponent(List<Bank> banks) {
        this();
        setBanks(banks);
    }

    public static BanksComponent create() {
        return new BanksComponent();
    }

    public static BanksComponent create(List<Bank> banks) {
        return new BanksComponent(banks);
    }

    public BanksComponent setBanks(List<Bank> banks) {
        banksSelect.removeAllOptions();
        for (Bank bank : banks) {
            banksSelect.appendChild(SelectOption.create(bank, bank.getSwiftCode(), bank.getName()));
        }
        return this;
    }

    public Select<Bank> getBanksSelect() {
        return banksSelect;
    }

    public Select<Branch> getBranchesSelect() {
        return branchesSelect;
    }
}
