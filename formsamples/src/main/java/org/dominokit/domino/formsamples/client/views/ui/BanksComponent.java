package org.dominokit.domino.formsamples.client.views.ui;

import org.dominokit.domino.formsamples.shared.model.Bank;
import org.dominokit.domino.formsamples.shared.model.Branch;
import org.dominokit.domino.ui.forms.suggest.Select;
import org.dominokit.domino.ui.forms.suggest.SelectOption;
import org.dominokit.domino.ui.icons.lib.Icons;
import org.dominokit.domino.ui.utils.PrefixAddOn;

import java.util.List;


public class BanksComponent {

    private Select<Bank> banksSelect;
    private Select<Branch> branchesSelect;

    public BanksComponent(List<Bank> banks) {
        this();
        setBanks(banks);
    }

    public BanksComponent() {
        banksSelect = Select.<Bank>create("Bank")
                .appendChild(PrefixAddOn.of(Icons.bank()));
        branchesSelect = Select.<Branch>create("Branch")
                .appendChild(PrefixAddOn.of(Icons.domain()))
                .disable();

        banksSelect
                .addChangeListener((oldValue, bank) -> {
                    branchesSelect.enable();
                    List<Branch> branches = bank.getBranches();
                    branchesSelect.removeAllOptions();
                    for (Branch branch : branches) {
                        branchesSelect.appendChild(SelectOption.create(branch.getName(), branch, branch.getName()));
                    }
                });
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
            banksSelect.appendChild(SelectOption.create(bank.getSwiftCode(), bank, bank.getName()));
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
