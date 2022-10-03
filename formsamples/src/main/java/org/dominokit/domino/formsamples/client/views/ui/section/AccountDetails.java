package org.dominokit.domino.formsamples.client.views.ui.section;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.formsamples.shared.model.CorporateAccount;
import org.dominokit.domino.ui.forms.TextBox;
import org.dominokit.domino.ui.grid.Column;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.icons.Icons;
import org.jboss.elemento.IsElement;

public final class AccountDetails implements IsElement<HTMLDivElement> {

    private TextBox accountNumberHeader;
    private TextBox ibanHeader;
    private TextBox currencyHeader;
    private HTMLDivElement element;

    public AccountDetails() {
        accountNumberHeader = TextBox.create("Account number")
                .addLeftAddOn(Icons.ALL.wallet_mdi())
                .setReadOnly(true);

        ibanHeader = TextBox.create("IBAN")
                .addLeftAddOn(Icons.ALL.code_array_mdi())
                .setReadOnly(true);

        currencyHeader = TextBox.create("Currency")
                .addLeftAddOn(Icons.ALL.home_currency_usd_mdi())
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
