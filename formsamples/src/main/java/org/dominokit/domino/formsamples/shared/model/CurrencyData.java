package org.dominokit.domino.formsamples.shared.model;

import org.dominokit.jacksonapt.annotation.JSONMapper;

public class CurrencyData {

    private String currencyCode;
    private String displayName;
    private int numericCode;
    private String symbol;
    private int defaultFractionDigits;

    public CurrencyData() {
    }

    public CurrencyData(String currencyCode, String displayName, int numericCode, String symbol, int defaultFractionDigits) {
        this.currencyCode = currencyCode;
        this.displayName = displayName;
        this.numericCode = numericCode;
        this.symbol = symbol;
        this.defaultFractionDigits = defaultFractionDigits;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public int getNumericCode() {
        return numericCode;
    }

    public void setNumericCode(int numericCode) {
        this.numericCode = numericCode;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public int getDefaultFractionDigits() {
        return defaultFractionDigits;
    }

    public void setDefaultFractionDigits(int defaultFractionDigits) {
        this.defaultFractionDigits = defaultFractionDigits;
    }
}
