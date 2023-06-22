package org.dominokit.domino.tree.client.views;

import org.dominokit.jackson.annotation.JSONMapper;

import java.util.List;

@JSONMapper
public class Countries {

    public static final String COUNTRIES = "{\n" +
            "  \"countries\": [\n" +
            "    {\n" +
            "      \"name\": \"Andorra\",\n" +
            "      \"cities\": [\n" +
            "        \"Andorra la Vella\",\n" +
            "        \"Canillo\",\n" +
            "        \"Encamp\",\n" +
            "        \"La Massana\",\n" +
            "        \"Escaldes-Engordany\",\n" +
            "        \"Ordino\",\n" +
            "        \"Sant Julia de Loria\"\n" +
            "      ]\n" +
            "    },\n" +
            "    {\n" +
            "\n" +
            "      \"name\": \"United Arab Emirates\",\n" +
            "      \"cities\": [\n" +
            "        \"Abu Dhabi\",\n" +
            "        \"'Ajman\",\n" +
            "        \"Al Fujayrah\",\n" +
            "        \"Ash Shariqah (Sharjah)\",\n" +
            "        \"Dubayy (Dubai)\",\n" +
            "        \"Ra's al Khaymah\",\n" +
            "        \"Umm al Qaywayn\"\n" +
            "      ]\n" +
            "    },\n" +
            "    {\n" +
            "\n" +
            "      \"name\": \"Afghanistan\",\n" +
            "      \"cities\": [\n" +
            "        \"Kabul\",\n" +
            "        \"Badakhshan\",\n" +
            "        \"Farah\",\n" +
            "        \"Khowst\",\n" +
            "        \"Konar\",\n" +
            "        \"Kondoz\",\n" +
            "        \"Paktika\",\n" +
            "        \"Parvan\",\n" +
            "        \"Samangan\",\n" +
            "        \"Sar-e Pol\",\n" +
            "        \"Takhar\",\n" +
            "        \"Vardak\",\n" +
            "        \"Zabol\"\n" +
            "      ]\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"Anguilla\",\n" +
            "      \"cities\": [\n" +
            "        \"The Valley\"\n" +
            "      ]\n" +
            "    },\n" +
            "\n" +
            "    {\n" +
            "      \"name\": \"Cameroon\",\n" +
            "      \"cities\": [\n" +
            "        \"Yaounde\",\n" +
            "        \"Adamaoua\",\n" +
            "        \"Centre\",\n" +
            "        \"Est\",\n" +
            "        \"Extreme-Nord\",\n" +
            "        \"Littoral\",\n" +
            "        \"Nord\",\n" +
            "        \"Nord-Ouest\",\n" +
            "        \"Ouest\",\n" +
            "        \"Sud\",\n" +
            "        \"Sud-Ouest\"\n" +
            "      ]\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"China\",\n" +
            "      \"cities\": [\n" +
            "        \"Beijing\",\n" +
            "        \"Anhui\",\n" +
            "        \"Chongqing\",\n" +
            "        \"Fujian\",\n" +
            "        \"Gansu\",\n" +
            "        \"Guangdong\",\n" +
            "        \"Guangxi\",\n" +
            "        \"Guizhou\",\n" +
            "        \"Jiangsu\",\n" +
            "        \"Jiangxi\",\n" +
            "        \"Jilin\",\n" +
            "        \"Liaoning\",\n" +
            "        \"Nei Mongol\",\n" +
            "        \"Ningxia\",\n" +
            "        \"Qinghai\",\n" +
            "        \"Shaanxi\",\n" +
            "        \"Shandong\",\n" +
            "        \"Shanghai\",\n" +
            "        \"Shanxi\",\n" +
            "        \"Sichuan\",\n" +
            "        \"Tianjin\",\n" +
            "        \"Xinjiang\",\n" +
            "        \"Xizang (Tibet)\",\n" +
            "        \"Yunnan\",\n" +
            "        \"Zhejiang\"\n" +
            "      ]\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"Colombia\",\n" +
            "      \"cities\": [\n" +
            "        \"Bogota\",\n" +
            "        \"Amazonas\",\n" +
            "        \"Antioquia\",\n" +
            "        \"Arauca\",\n" +
            "        \"Atlantico\",\n" +
            "        \"Bolivar\",\n" +
            "        \"Boyaca\",\n" +
            "        \"Cundinamarca\",\n" +
            "        \"Guaviare\",\n" +
            "        \"Huila\",\n" +
            "        \"La Guajira\",\n" +
            "        \"Meta\",\n" +
            "        \"Norte de Santander\",\n" +
            "        \"Putumayo\",\n" +
            "        \"Quindio\",\n" +
            "        \"Risaralda\",\n" +
            "        \"Santander\",\n" +
            "        \"Sucre\",\n" +
            "        \"Tolima\",\n" +
            "        \"Vichada\"\n" +
            "      ]\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"Costa Rica\",\n" +
            "      \"cities\": [\n" +
            "        \"San Jose\",\n" +
            "        \"Alajuela\",\n" +
            "        \"Cartago\",\n" +
            "        \"Guanacaste\",\n" +
            "        \"Heredia\",\n" +
            "        \"Limon\",\n" +
            "        \"Puntarenas\"\n" +
            "      ]\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"Germany\",\n" +
            "      \"cities\": [\n" +
            "        \"Berlin\",\n" +
            "        \"Baden-Wuerttemberg\",\n" +
            "        \"Bayern\",\n" +
            "        \"Berlin\",\n" +
            "        \"Brandenburg\",\n" +
            "        \"Bremen\",\n" +
            "        \"Hamburg\",\n" +
            "        \"Hessen\",\n" +
            "        \"Mecklenburg-Vorpommern\",\n" +
            "        \"Niedersachsen\",\n" +
            "        \"Nordrhein-Westfalen\",\n" +
            "        \"Rheinland-Pfalz\",\n" +
            "        \"Saarland\",\n" +
            "        \"Sachsen\",\n" +
            "        \"Sachsen-Anhalt\",\n" +
            "        \"Schleswig-Holstein\",\n" +
            "        \"Thueringen\"\n" +
            "      ]\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"Djibouti\",\n" +
            "      \"cities\": [\n" +
            "        \"Djibouti\",\n" +
            "        \"'Ali Sabih\",\n" +
            "        \"Dikhil\",\n" +
            "        \"Obock\",\n" +
            "        \"Tadjoura\"\n" +
            "      ]\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"Denmark\",\n" +
            "      \"cities\": [\n" +
            "        \"Copenhagen (Kobenhavn)\",\n" +
            "        \"Arhus\",\n" +
            "        \"Bornholm\",\n" +
            "        \"Fredericksberg\",\n" +
            "        \"Frederiksborg\",\n" +
            "        \"Fyn\",\n" +
            "        \"Kobenhavns\",\n" +
            "        \"Nordjylland\",\n" +
            "        \"Ribe\",\n" +
            "        \"Ringkobing\",\n" +
            "        \"Roskilde\",\n" +
            "        \"Sonderjylland\",\n" +
            "        \"Storstrom\",\n" +
            "        \"Vejle\",\n" +
            "        \"Vestsjalland\",\n" +
            "        \"Viborg\"\n" +
            "      ]\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"Dominica\",\n" +
            "      \"cities\": [\n" +
            "        \"Roseau\",\n" +
            "        \"Saint Andrew\",\n" +
            "        \"Saint David\",\n" +
            "        \"Saint George\"\n" +
            "      ]\n" +
            "    }\n" +
            "  ]\n" +
            "}";

    public static final Countries_MapperImpl MAPPER = new Countries_MapperImpl();

    private List<Country> countries;

    public List<Country> getCountries() {
        return countries;
    }

    public void setCountries(List<Country> countries) {
        this.countries = countries;
    }
}
