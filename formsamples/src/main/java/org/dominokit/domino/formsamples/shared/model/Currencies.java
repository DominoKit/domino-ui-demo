package org.dominokit.domino.formsamples.shared.model;

import org.dominokit.jacksonapt.annotation.JSONMapper;

import java.util.List;

@JSONMapper
public class Currencies {

    public static final Currencies_MapperImpl MAPPER = new Currencies_MapperImpl();
    private List<CurrencyData> currencies;

    public List<CurrencyData> getCurrencies() {
        return currencies;
    }

    public void setCurrencies(List<CurrencyData> currencies) {
        this.currencies = currencies;
    }
}
