package org.dominokit.domino.formsamples.client.views.ui;

import org.dominokit.domino.formsamples.shared.model.Country;
import org.dominokit.domino.ui.forms.Select;
import org.dominokit.domino.ui.forms.SelectOption;
import org.dominokit.domino.ui.icons.lib.Icons;

import java.util.List;

import static org.jboss.elemento.Elements.i;

public class CountriesComponent {

    private Select<Country> countriesSelect;
    private Select<String> citiesSelect;

    public CountriesComponent(List<Country> countries) {
        this();
        setCountries(countries);
    }

    public CountriesComponent() {
        countriesSelect = Select.<Country>create("Country")
                .addLeftAddOn(i().css("fas", "fa-globe", "fa-lg"));
        citiesSelect = Select.<String>create("City")
                .addLeftAddOn(Icons.city())
                .disable();

        countriesSelect.addSelectionHandler(option -> {
            citiesSelect.enable();
            citiesSelect.removeAllOptions();
            Country country = option.getValue();
            for (String city : country.getCities()) {
                citiesSelect.appendChild(SelectOption.create(city, city));
            }
        });
    }

    public static CountriesComponent create(List<Country> countries) {
        return new CountriesComponent(countries);
    }

    public static CountriesComponent create() {
        return new CountriesComponent();
    }

    public CountriesComponent setCountries(List<Country> countries) {
        countriesSelect.removeAllOptions();
        for (Country country : countries) {
            countriesSelect.appendChild(SelectOption.create(country, country.getName()));
        }
        return this;
    }

    public Select<Country> getCountriesSelect() {
        return countriesSelect;
    }

    public Select<String> getCitiesSelect() {
        return citiesSelect;
    }
}
