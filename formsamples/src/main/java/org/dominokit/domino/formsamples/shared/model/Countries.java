package org.dominokit.domino.formsamples.shared.model;

import org.dominokit.jacksonapt.annotation.JSONMapper;

import java.util.List;

@JSONMapper
public class Countries {

    public static final Countries_MapperImpl MAPPER = new Countries_MapperImpl();

    private List<Country> countries;

    public List<Country> getCountries() {
        return countries;
    }

    public void setCountries(List<Country> countries) {
        this.countries = countries;
    }
}
