
package org.dominokit.domino.formsamples.shared.model;

public class CorporateAccount {

    private String accountAccessibility;
    private String accountAlias;
    private String accountNumber;
    private String accountType;
    private CurrencyData currency;
    private String iban;

    public String getAccountAccessibility() {
        return accountAccessibility;
    }

    public void setAccountAccessibility(String accountAccessibility) {
        this.accountAccessibility = accountAccessibility;
    }

    public String getAccountAlias() {
        return accountAlias;
    }

    public void setAccountAlias(String accountAlias) {
        this.accountAlias = accountAlias;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public CurrencyData getCurrency() {
        return currency;
    }

    public void setCurrency(CurrencyData currency) {
        this.currency = currency;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

}
