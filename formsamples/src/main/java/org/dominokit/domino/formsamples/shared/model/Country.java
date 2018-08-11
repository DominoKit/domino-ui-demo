package org.dominokit.domino.formsamples.shared.model;

import java.util.List;

public class Country {
    private String iso;
    private String code;
    private String name;
    private List<String> cities;

    public Country() {
    }

    public Country(String iso, String code, String name) {
        this.iso = iso;
        this.code = code;
        this.name = name;
    }

    public String getIso() {
        return iso;
    }

    public void setIso(String iso) {
        this.iso = iso;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getCities() {
        return cities;
    }

    public void setCities(List<String> cities) {
        this.cities = cities;
    }

    @Override
    public String toString() {
        return "Country{" +
                "iso='" + iso + '\'' +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                '}';
    }


}
