package org.dominokit.domino.formsamples.client.views.ui.section;

import elemental2.dom.HTMLElement;
import org.dominokit.domino.formsamples.shared.model.CorporateAccount;
import org.dominokit.domino.formsamples.shared.model.CorporateProfile;
import org.dominokit.domino.ui.forms.Select;
import org.dominokit.domino.ui.forms.SelectOption;
import org.dominokit.domino.ui.icons.Icon;
import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.popover.Popover;
import org.dominokit.domino.ui.popover.Tooltip;
import org.dominokit.domino.ui.style.Style;
import org.dominokit.domino.ui.utils.IsCollapsible;
import org.jboss.elemento.IsElement;

public class CorporateAccountsSelect implements IsElement<HTMLElement>, IsCollapsible<CorporateAccountsSelect> {

    private Select<CorporateAccount> accountSelect;
    private AccountDetails accountDetails;

    public static CorporateAccountsSelect create(String title, CorporateProfile corporateProfile) {
        return new CorporateAccountsSelect(title, corporateProfile);
    }

    public CorporateAccountsSelect(String title, CorporateProfile corporateProfile) {
        accountDetails = new AccountDetails();

        Icon correspondentChargesAccountIcon = Style.of(Icons.ALL.info_outline())
                .setProperty("cursor", "pointer")
                .get();

        accountSelect = Select.<CorporateAccount>create(title)
                .addLeftAddOn(Icons.ALL.account_balance_wallet())
                .setRightAddon(correspondentChargesAccountIcon);

        Tooltip.create(correspondentChargesAccountIcon.element(), "Show details");
        Style.of(Popover.create(correspondentChargesAccountIcon.element(), "Account details", accountDetails.element())
                .position(new AccountDetailsPopupPosition(accountSelect)))
                .setWidth("330px");

        for (CorporateAccount corporateAccount : corporateProfile.getCorporateAccounts()) {
            accountSelect.appendChild(SelectOption.create(corporateAccount, corporateAccount.getAccountAlias()));
        }

        accountSelect.addSelectionHandler(option -> accountDetails.setAccount(option.getValue()));

    }

    public Select<CorporateAccount> getAccountSelect() {
        return accountSelect;
    }


    @Override
    public HTMLElement element() {
        return accountSelect.element();
    }

    @Override
    public CorporateAccountsSelect show() {
        accountSelect.show();
        return this;
    }

    @Override
    public CorporateAccountsSelect hide() {
        accountSelect.hide();
        return this;
    }

    @Override
    public CorporateAccountsSelect toggleDisplay() {
        accountSelect.toggleDisplay();
        return this;
    }

    @Override
    public CorporateAccountsSelect toggleDisplay(boolean state) {
        accountSelect.toggleDisplay(state);
        return this;
    }

    @Override
    public boolean isHidden() {
        return accountSelect.isHidden();
    }
}
