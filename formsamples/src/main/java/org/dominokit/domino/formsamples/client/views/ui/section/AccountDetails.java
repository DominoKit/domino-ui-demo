package org.dominokit.domino.formsamples.client.views.ui.section;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.formsamples.shared.model.CorporateAccount;
import org.dominokit.domino.ui.forms.TextBox;
import org.dominokit.domino.ui.grid.Column;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.icons.Icons;
import org.jboss.gwt.elemento.core.IsElement;

public final class AccountDetails implements IsElement<HTMLDivElement> {

    private TextBox accountNumberHeader;
    private TextBox ibanHeader;
    private TextBox currencyHeader;
    private HTMLDivElement element;

    public AccountDetails() {
        accountNumberHeader = TextBox.create("Account number")
                .addLeftAddOn(Icons.ALL.account_balance_wallet())
                .setReadOnly(true);

        ibanHeader = TextBox.create("IBAN")
                .addLeftAddOn(Icons.ALL.code())
                .setReadOnly(true);

        currencyHeader = TextBox.create("Currency")
                .addLeftAddOn(Icons.ALL.attach_money())
                .setReadOnly(true);

        element = Row.create()
                .style()
                .setPaddingTop("20px")
                .get()
                .addColumn(Column.span12()
                        .appendChild(accountNumberHeader)
                )
                .addColumn(Column.span12()
                        .appendChild(ibanHeader)
                )
                .addColumn(Column.span12()
                        .appendChild(currencyHeader)
                ).element();
    }

    @Override
    public HTMLDivElement element() {
        return element;
    }

    public void setAccount(CorporateAccount account) {
        accountNumberHeader.setValue(account.getAccountNumber());
        ibanHeader.setValue(account.getIban());
        currencyHeader.setValue(account.getCurrency().getCurrencyCode());
    }
}
