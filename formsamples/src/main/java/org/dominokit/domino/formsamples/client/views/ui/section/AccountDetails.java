package org.dominokit.domino.formsamples.client.views.ui.section;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.formsamples.shared.model.CorporateAccount;
import org.dominokit.domino.ui.column.Column;
import org.dominokit.domino.ui.forms.TextBox;
import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.row.Row;
import org.jboss.gwt.elemento.core.IsElement;

public final class AccountDetails implements IsElement<HTMLDivElement> {

    private TextBox accountNumberHeader;
    private TextBox ibanHeader;
    private TextBox currencyHeader;
    private HTMLDivElement element;

    public AccountDetails() {
        accountNumberHeader = TextBox.create("Account number")
                .setLeftAddon(Icons.ALL.account_balance_wallet())
                .setReadOnly(true);

        ibanHeader = TextBox.create("IBAN")
                .setLeftAddon(Icons.ALL.code())
                .setReadOnly(true);

        currencyHeader = TextBox.create("Currency")
                .setLeftAddon(Icons.ALL.attach_money())
                .setReadOnly(true);

        element = Row.create()
                .style()
                .setPaddingTop("20px")
                .get()
                .addColumn(Column.span12()
                        .addElement(accountNumberHeader)
                )
                .addColumn(Column.span12()
                        .addElement(ibanHeader)
                )
                .addColumn(Column.span12()
                        .addElement(currencyHeader)
                ).asElement();
    }

    @Override
    public HTMLDivElement asElement() {
        return element;
    }

    public void setAccount(CorporateAccount account) {
        accountNumberHeader.setValue(account.getAccountNumber());
        ibanHeader.setValue(account.getIban());
        currencyHeader.setValue(account.getCurrency().getCurrencyCode());
    }
}
