package org.dominokit.domino.formsamples.client.views.ui;

import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.domino.componentcase.client.ui.views.LinkToSourceCode;
import org.dominokit.domino.componentcase.shared.extension.ComponentView;
import org.dominokit.domino.formsamples.client.presenters.FormSamplesPresenter;
import org.dominokit.domino.formsamples.client.views.FormSamplesView;
import org.dominokit.domino.formsamples.shared.model.*;
import org.dominokit.domino.ui.dialogs.MessageDialog;
import org.dominokit.domino.ui.utils.ElementUtil;

import java.util.Arrays;
import java.util.List;

import static org.jboss.gwt.elemento.core.Elements.div;

@UiView(presentable = FormSamplesPresenter.class)
public class FormSamplesViewImpl extends ComponentView<HTMLElement> implements FormSamplesView, FormSamplesView.FormSamplesUIHandlers {


    private static final String BANKS_JSON = "[\n" +
            "  {\n" +
            "    \"name\": \"Bank XYZ\",\n" +
            "    \"swiftCode\": \"ABCDEFGHIXXX\",\n" +
            "    \"shortName\": \"A.B.C.D\",\n" +
            "    \"address\": {\n" +
            "      \"countryISOCode\": \"OM\",\n" +
            "      \"city\": \"City Y\",\n" +
            "      \"street\": \"Street ABC\",\n" +
            "      \"apartment\": \"Building XYZ\",\n" +
            "      \"zipCode\": \"123\",\n" +
            "      \"mailBox\": \"PO Box 123\",\n" +
            "      \"phoneNumber\": \"+900 12345678\",\n" +
            "      \"faxNumber\": \"+900 12345678\"\n" +
            "    },\n" +
            "    \"contactPerson\": {\n" +
            "      \"name\": \"\\tMr Noman person\",\n" +
            "      \"contactNumber\": \"+900 12345678\",\n" +
            "      \"email\": \"xyz@abcdefghi.com\",\n" +
            "      \"address\": {\n" +
            "        \"countryISOCode\": \"OM\",\n" +
            "        \"city\": \"City x\",\n" +
            "        \"street\": \"ABC Street\",\n" +
            "        \"apartment\": \"Building XYZ\",\n" +
            "        \"zipCode\": \"123\",\n" +
            "        \"mailBox\": \"PO Box 123\",\n" +
            "        \"phoneNumber\": \"+900 12345678\",\n" +
            "        \"faxNumber\": \"+900 12345678\"\n" +
            "      }\n" +
            "    }\n" +
            "  }\n" +
            "]";
    private static final String BENEFICIARIES_JSON = "[\n" +
            "  {\n" +
            "    \"id\": \"71328a43-d119-4e99-8bd0-629c9fa39415\",\n" +
            "    \"processInstanceId\": \"39\",\n" +
            "    \"tenantId\": \"corpay\",\n" +
            "    \"createdDate\": 1532217600000,\n" +
            "    \"createdBy\": \"1\",\n" +
            "    \"updatedDate\": null,\n" +
            "    \"updatedBy\": null,\n" +
            "    \"name\": \"Corp. ABC\",\n" +
            "    \"profileType\": \"bank\",\n" +
            "    \"description\": null,\n" +
            "    \"address\": {\n" +
            "      \"id\": \"4658f7d3-b94c-4875-af45-41fc41b774e8\",\n" +
            "      \"processInstanceId\": null,\n" +
            "      \"tenantId\": null,\n" +
            "      \"createdDate\": null,\n" +
            "      \"createdBy\": null,\n" +
            "      \"updatedDate\": null,\n" +
            "      \"updatedBy\": null,\n" +
            "      \"countryIsoCode\": \"JOR\",\n" +
            "      \"city\": \"Amman\",\n" +
            "      \"street\": null,\n" +
            "      \"apartment\": null,\n" +
            "      \"zipCode\": null,\n" +
            "      \"mailBox\": null\n" +
            "    },\n" +
            "    \"email\": null,\n" +
            "    \"poBox\": null,\n" +
            "    \"phone\": null,\n" +
            "    \"fax\": null,\n" +
            "    \"contactPerson\": {\n" +
            "      \"id\": \"1d8577a5-e332-498a-b1fc-11ef936dc997\",\n" +
            "      \"processInstanceId\": null,\n" +
            "      \"tenantId\": null,\n" +
            "      \"createdDate\": null,\n" +
            "      \"createdBy\": null,\n" +
            "      \"updatedDate\": null,\n" +
            "      \"updatedBy\": null,\n" +
            "      \"name\": \"Noman person\",\n" +
            "      \"contactNumber\": \"07896654545\",\n" +
            "      \"address\": null,\n" +
            "      \"email\": null\n" +
            "    },\n" +
            "    \"startingDate\": 1532217600000,\n" +
            "    \"expiryDate\": 1847836800000,\n" +
            "    \"state\": \"ACTIVE\",\n" +
            "    \"accounts\": [\n" +
            "      {\n" +
            "        \"id\": \"1\",\n" +
            "        \"processInstanceId\": null,\n" +
            "        \"tenantId\": null,\n" +
            "        \"createdDate\": null,\n" +
            "        \"createdBy\": null,\n" +
            "        \"updatedDate\": null,\n" +
            "        \"updatedBy\": null,\n" +
            "        \"iban\": \"AB89ABCD0000000000009235351490\",\n" +
            "        \"accountAlias\": \"current account\",\n" +
            "        \"accountNumber\": \"009235351490\",\n" +
            "        \"country\": \"Kuwait\",\n" +
            "        \"bank\": \"Bank XYZ\",\n" +
            "        \"bicCode\": \"XYZ\",\n" +
            "        \"currency\": \"JOD\",\n" +
            "        \"accountState\": \"ACTIVE\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": \"2\",\n" +
            "        \"processInstanceId\": null,\n" +
            "        \"tenantId\": null,\n" +
            "        \"createdDate\": null,\n" +
            "        \"createdBy\": null,\n" +
            "        \"updatedDate\": null,\n" +
            "        \"updatedBy\": null,\n" +
            "        \"iban\": \"AB62ABCD0000000000009235351491\",\n" +
            "        \"accountAlias\": \"main account\",\n" +
            "        \"accountNumber\": \"123456789123\",\n" +
            "        \"country\": \"Jordan\",\n" +
            "        \"bank\": \"Bank CBA\",\n" +
            "        \"bicCode\": \"CBA\",\n" +
            "        \"currency\": \"JOD\",\n" +
            "        \"accountState\": \"ACTIVE\"\n" +
            "      }\n" +
            "    ],\n" +
            "    \"agreements\": []\n" +
            "  }\n" +
            "]";
    private static final String COUNTRIES_JSON = "{\n" +
            "  \"countries\": [\n" +
            "    {\n" +
            "      \"iso\": \"AND\",\n" +
            "      \"code\": \"AD\",\n" +
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
            "      \"iso\": \"ARE\",\n" +
            "      \"code\": \"AE\",\n" +
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
            "      \"iso\": \"AFG\",\n" +
            "      \"code\": \"AF\",\n" +
            "      \"name\": \"Afghanistan\",\n" +
            "      \"cities\": [\n" +
            "        \"Kabul\",\n" +
            "        \"Badakhshan\",\n" +
            "        \"Badghis\",\n" +
            "        \"Baghlan\",\n" +
            "        \"Balkh\",\n" +
            "        \"Bamian\",\n" +
            "        \"Farah\",\n" +
            "        \"Faryab\",\n" +
            "        \"Ghazni\",\n" +
            "        \"Ghowr\",\n" +
            "        \"Helmand\",\n" +
            "        \"Herat\",\n" +
            "        \"Jowzjan\",\n" +
            "        \"Kabol\",\n" +
            "        \"Kandahar\",\n" +
            "        \"Kapisa\",\n" +
            "        \"Khowst\",\n" +
            "        \"Konar\",\n" +
            "        \"Kondoz\",\n" +
            "        \"Laghman\",\n" +
            "        \"Lowgar\",\n" +
            "        \"Nangarhar\",\n" +
            "        \"Nimruz\",\n" +
            "        \"Nurestan\",\n" +
            "        \"Oruzgan\",\n" +
            "        \"Paktia\",\n" +
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
            "      \"iso\": \"AIA\",\n" +
            "      \"code\": \"AI\",\n" +
            "      \"name\": \"Anguilla\",\n" +
            "      \"cities\": [\n" +
            "        \"The Valley\"\n" +
            "      ]\n" +
            "    },\n" +
            "    {\n" +
            "      \"iso\": \"ALB\",\n" +
            "      \"code\": \"AL\",\n" +
            "      \"name\": \"Albania\",\n" +
            "      \"cities\": [\n" +
            "        \"Tirana\",\n" +
            "        \"Berat\",\n" +
            "        \"Bulqize\",\n" +
            "        \"Delvine\",\n" +
            "        \"Devoll\",\n" +
            "        \"Diber\",\n" +
            "        \"Durres\",\n" +
            "        \"Elbasan\",\n" +
            "        \"Fier\",\n" +
            "        \"Gjirokaster\",\n" +
            "        \"Gramsh\",\n" +
            "        \"Has\",\n" +
            "        \"Kavaje\",\n" +
            "        \"Kolonje\",\n" +
            "        \"Korce\",\n" +
            "        \"Kruje\",\n" +
            "        \"Kucove\",\n" +
            "        \"Kukes\",\n" +
            "        \"Kurbin\",\n" +
            "        \"Lezhe\",\n" +
            "        \"Librazhd\",\n" +
            "        \"Lushnje\",\n" +
            "        \"Malesi e Madhe\",\n" +
            "        \"Mallakaster\",\n" +
            "        \"Mat\",\n" +
            "        \"Mirdite\",\n" +
            "        \"Peqin\",\n" +
            "        \"Permet\",\n" +
            "        \"Pogradec\",\n" +
            "        \"Puke\",\n" +
            "        \"Sarande\",\n" +
            "        \"Shkoder\",\n" +
            "        \"Skrapar\",\n" +
            "        \"Tepelene\",\n" +
            "        \"Tirane\",\n" +
            "        \"Tropoje\",\n" +
            "        \"Vlore\"\n" +
            "      ]\n" +
            "    },\n" +
            "    {\n" +
            "      \"iso\": \"ARM\",\n" +
            "      \"code\": \"AM\",\n" +
            "      \"name\": \"Armenia\",\n" +
            "      \"cities\": [\n" +
            "        \"Yerevan\",\n" +
            "        \"Aragatsotn\",\n" +
            "        \"Ararat\",\n" +
            "        \"Armavir\",\n" +
            "        \"Geghark'unik'\",\n" +
            "        \"Kotayk'\",\n" +
            "        \"Lorri\",\n" +
            "        \"Shirak\",\n" +
            "        \"Syunik'\",\n" +
            "        \"Tavush\",\n" +
            "        \"Vayots' Dzor\"\n" +
            "      ]\n" +
            "    },\n" +
            "    {\n" +
            "      \"iso\": \"ANT\",\n" +
            "      \"code\": \"AN\",\n" +
            "      \"name\": \"Netherlands Antilles\",\n" +
            "      \"cities\": [\n" +
            "        \"Willemstad\"\n" +
            "      ]\n" +
            "    },\n" +
            "    {\n" +
            "      \"iso\": \"AGO\",\n" +
            "      \"code\": \"AO\",\n" +
            "      \"name\": \"Angola\",\n" +
            "      \"cities\": [\n" +
            "        \"Luanda\",\n" +
            "        \"Bengo\",\n" +
            "        \"Benguela\",\n" +
            "        \"Bie\",\n" +
            "        \"Cabinda\",\n" +
            "        \"Cuando Cubango\",\n" +
            "        \"Cuanza Norte\",\n" +
            "        \"Cuanza Sul\",\n" +
            "        \"Cunene\",\n" +
            "        \"Huambo\",\n" +
            "        \"Huila\",\n" +
            "        \"Lunda Norte\",\n" +
            "        \"Lunda Sul\",\n" +
            "        \"Malanje\",\n" +
            "        \"Moxico\",\n" +
            "        \"Namibe\",\n" +
            "        \"Uige\",\n" +
            "        \"Zaire\"\n" +
            "      ]\n" +
            "    },\n" +
            "    {\n" +
            "      \"iso\": \"ARG\",\n" +
            "      \"code\": \"AR\",\n" +
            "      \"name\": \"Argentina\",\n" +
            "      \"cities\": [\n" +
            "        \"Buenos Aires\",\n" +
            "        \"Catamarca\",\n" +
            "        \"Chaco\",\n" +
            "        \"Chubut\",\n" +
            "        \"Cordoba\",\n" +
            "        \"Corrientes\",\n" +
            "        \"Entre Rios\",\n" +
            "        \"Formosa\",\n" +
            "        \"Jujuy\",\n" +
            "        \"La Pampa\",\n" +
            "        \"La Rioja\",\n" +
            "        \"Mendoza\",\n" +
            "        \"Misiones\",\n" +
            "        \"Neuquen\",\n" +
            "        \"Rio Negro\",\n" +
            "        \"Salta\",\n" +
            "        \"San Juan\",\n" +
            "        \"San Luis\",\n" +
            "        \"Santa Cruz\",\n" +
            "        \"Santa Fe\",\n" +
            "        \"Santiago del Estero\",\n" +
            "        \"Tucuman\"\n" +
            "      ]\n" +
            "    },\n" +
            "    {\n" +
            "      \"iso\": \"AUT\",\n" +
            "      \"code\": \"AT\",\n" +
            "      \"name\": \"Austria\",\n" +
            "      \"cities\": [\n" +
            "        \"Vienna\",\n" +
            "        \"Burgenland\",\n" +
            "        \"Kaernten\",\n" +
            "        \"Niederoesterreich\",\n" +
            "        \"Oberoesterreich\",\n" +
            "        \"Salzburg\",\n" +
            "        \"Steiermark\",\n" +
            "        \"Tirol\",\n" +
            "        \"Vorarlberg\",\n" +
            "        \"Wien\"\n" +
            "      ]\n" +
            "    },\n" +
            "    {\n" +
            "      \"iso\": \"AUS\",\n" +
            "      \"code\": \"AU\",\n" +
            "      \"name\": \"Australia\",\n" +
            "      \"cities\": [\n" +
            "        \"Canberra\",\n" +
            "        \"Australian Capital Territory\",\n" +
            "        \"New South Wales\",\n" +
            "        \"Northern Territory\",\n" +
            "        \"Queensland\",\n" +
            "        \"South Australia\",\n" +
            "        \"Tasmania\",\n" +
            "        \"Victoria\",\n" +
            "        \"Western Australia\"\n" +
            "      ]\n" +
            "    },\n" +
            "    {\n" +
            "      \"iso\": \"ABW\",\n" +
            "      \"code\": \"AW\",\n" +
            "      \"name\": \"Aruba\",\n" +
            "      \"cities\": [\n" +
            "        \"Oranjestad\"\n" +
            "      ]\n" +
            "    },\n" +
            "    {\n" +
            "      \"iso\": \"AZE\",\n" +
            "      \"code\": \"AZ\",\n" +
            "      \"name\": \"Azerbaijan\",\n" +
            "      \"cities\": [\n" +
            "        \"Baku (Baki)\",\n" +
            "        \"Abseron\",\n" +
            "        \"Agcabadi\",\n" +
            "        \"Agdam\",\n" +
            "        \"Agdas\",\n" +
            "        \"Agstafa\",\n" +
            "        \"Agsu\",\n" +
            "        \"Ali Bayramli\",\n" +
            "        \"Astara\",\n" +
            "        \"Balakan\",\n" +
            "        \"Barda\",\n" +
            "        \"Beylaqan\",\n" +
            "        \"Bilasuvar\",\n" +
            "        \"Cabrayil\",\n" +
            "        \"Calilabad\",\n" +
            "        \"Daskasan\",\n" +
            "        \"Davaci\",\n" +
            "        \"Fuzuli\",\n" +
            "        \"Gadabay\",\n" +
            "        \"Ganca\",\n" +
            "        \"Goranboy\",\n" +
            "        \"Goycay\",\n" +
            "        \"Haciqabul\",\n" +
            "        \"Imisli\",\n" +
            "        \"Ismayilli\",\n" +
            "        \"Kalbacar\",\n" +
            "        \"Kurdamir\",\n" +
            "        \"Lacin\",\n" +
            "        \"Lankaran\",\n" +
            "        \"Lankaran\",\n" +
            "        \"Lerik\",\n" +
            "        \"Masalli\",\n" +
            "        \"Mingacevir\",\n" +
            "        \"Naftalan\",\n" +
            "        \"Naxcivan\",\n" +
            "        \"Neftcala\",\n" +
            "        \"Oguz\",\n" +
            "        \"Qabala\",\n" +
            "        \"Qax\",\n" +
            "        \"Qazax\",\n" +
            "        \"Qobustan\",\n" +
            "        \"Quba\",\n" +
            "        \"Qubadli\",\n" +
            "        \"Qusar\",\n" +
            "        \"Saatli\",\n" +
            "        \"Sabirabad\",\n" +
            "        \"Saki\",\n" +
            "        \"Saki\",\n" +
            "        \"Salyan\",\n" +
            "        \"Samaxi\",\n" +
            "        \"Samkir\",\n" +
            "        \"Samux\",\n" +
            "        \"Siyazan\",\n" +
            "        \"Sumqayit\",\n" +
            "        \"Susa\",\n" +
            "        \"Susa\",\n" +
            "        \"Tartar\",\n" +
            "        \"Tovuz\",\n" +
            "        \"Ucar\",\n" +
            "        \"Xacmaz\",\n" +
            "        \"Xankandi\",\n" +
            "        \"Xanlar\",\n" +
            "        \"Xizi\",\n" +
            "        \"Xocali\",\n" +
            "        \"Xocavand\",\n" +
            "        \"Yardimli\",\n" +
            "        \"Yevlax\",\n" +
            "        \"Yevlax\",\n" +
            "        \"Zangilan\",\n" +
            "        \"Zaqatala\",\n" +
            "        \"Zardab\"\n" +
            "      ]\n" +
            "    },\n" +
            "    {\n" +
            "      \"iso\": \"BRB\",\n" +
            "      \"code\": \"BB\",\n" +
            "      \"name\": \"Barbados\",\n" +
            "      \"cities\": [\n" +
            "        \"Bridgetown\",\n" +
            "        \"Christ Church\",\n" +
            "        \"Saint Andrew\",\n" +
            "        \"Saint George\",\n" +
            "        \"Saint James\",\n" +
            "        \"Saint John\",\n" +
            "        \"Saint Joseph\",\n" +
            "        \"Saint Lucy\",\n" +
            "        \"Saint Michael\",\n" +
            "        \"Saint Peter\",\n" +
            "        \"Saint Philip\",\n" +
            "        \"Saint Thomas\"\n" +
            "      ]\n" +
            "    },\n" +
            "    {\n" +
            "      \"iso\": \"BGD\",\n" +
            "      \"code\": \"BD\",\n" +
            "      \"name\": \"Bangladesh\",\n" +
            "      \"cities\": [\n" +
            "        \"Dhaka\",\n" +
            "        \"Barisal\",\n" +
            "        \"Chittagong\",\n" +
            "        \"Khulna\",\n" +
            "        \"Rajshahi\",\n" +
            "        \"Sylhet\"\n" +
            "      ]\n" +
            "    },\n" +
            "    {\n" +
            "      \"iso\": \"BEL\",\n" +
            "      \"code\": \"BE\",\n" +
            "      \"name\": \"Belgium\",\n" +
            "      \"cities\": [\n" +
            "        \"Brussels\",\n" +
            "        \"Antwerpen\",\n" +
            "        \"Brabant Wallon\",\n" +
            "        \"Brussels (Bruxelles)\",\n" +
            "        \"Hainaut\",\n" +
            "        \"Liege\",\n" +
            "        \"Limburg\",\n" +
            "        \"Luxembourg\",\n" +
            "        \"Namur\",\n" +
            "        \"Oost-Vlaanderen\",\n" +
            "        \"Vlaams-Brabant\",\n" +
            "        \"West-Vlaanderen\"\n" +
            "      ]\n" +
            "    },\n" +
            "    {\n" +
            "      \"iso\": \"BFA\",\n" +
            "      \"code\": \"BF\",\n" +
            "      \"name\": \"Burkina Faso\",\n" +
            "      \"cities\": [\n" +
            "        \"Ouagadougou\",\n" +
            "        \"Bale\",\n" +
            "        \"Bam\",\n" +
            "        \"Banwa\",\n" +
            "        \"Bazega\",\n" +
            "        \"Bougouriba\",\n" +
            "        \"Boulgou\",\n" +
            "        \"Boulkiemde\",\n" +
            "        \"Comoe\",\n" +
            "        \"Ganzourgou\",\n" +
            "        \"Gnagna\",\n" +
            "        \"Gourma\",\n" +
            "        \"Houet\",\n" +
            "        \"Ioba\",\n" +
            "        \"Kadiogo\",\n" +
            "        \"Kenedougou\",\n" +
            "        \"Komandjari\",\n" +
            "        \"Kompienga\",\n" +
            "        \"Kossi\",\n" +
            "        \"Koupelogo\",\n" +
            "        \"Kouritenga\",\n" +
            "        \"Kourweogo\",\n" +
            "        \"Leraba\",\n" +
            "        \"Loroum\",\n" +
            "        \"Mouhoun\",\n" +
            "        \"Nahouri\",\n" +
            "        \"Namentenga\",\n" +
            "        \"Nayala\",\n" +
            "        \"Naumbiel\",\n" +
            "        \"Oubritenga\",\n" +
            "        \"Oudalan\",\n" +
            "        \"Passore\",\n" +
            "        \"Poni\",\n" +
            "        \"Samentenga\",\n" +
            "        \"Sanguie\",\n" +
            "        \"Seno\",\n" +
            "        \"Sissili\",\n" +
            "        \"Soum\",\n" +
            "        \"Sourou\",\n" +
            "        \"Tapoa\",\n" +
            "        \"Tuy\",\n" +
            "        \"Yagha\",\n" +
            "        \"Yatenga\",\n" +
            "        \"Ziro\",\n" +
            "        \"Zondomo\",\n" +
            "        \"Zoundweogo\"\n" +
            "      ]\n" +
            "    },\n" +
            "    {\n" +
            "      \"iso\": \"BGR\",\n" +
            "      \"code\": \"BG\",\n" +
            "      \"name\": \"Bulgaria\",\n" +
            "      \"cities\": [\n" +
            "        \"Sofiya\",\n" +
            "        \"Blagoevgrad\",\n" +
            "        \"Burgas\",\n" +
            "        \"Dobrich\",\n" +
            "        \"Gabrovo\",\n" +
            "        \"Khaskovo\",\n" +
            "        \"Kurdzhali\",\n" +
            "        \"Kyustendil\",\n" +
            "        \"Lovech\",\n" +
            "        \"Montana\",\n" +
            "        \"Pazardzhik\",\n" +
            "        \"Pernik\",\n" +
            "        \"Pleven\",\n" +
            "        \"Plovdiv\",\n" +
            "        \"Razgrad\",\n" +
            "        \"Ruse\",\n" +
            "        \"Shumen\",\n" +
            "        \"Silistra\",\n" +
            "        \"Sliven\",\n" +
            "        \"Smolyan\",\n" +
            "        \"Sofiya-Grad\",\n" +
            "        \"Stara Zagora\",\n" +
            "        \"Turgovishte\",\n" +
            "        \"Varna\",\n" +
            "        \"Veliko Turnovo\",\n" +
            "        \"Vidin\",\n" +
            "        \"Vratsa\",\n" +
            "        \"Yambol\"\n" +
            "      ]\n" +
            "    },\n" +
            "    {\n" +
            "      \"iso\": \"BHR\",\n" +
            "      \"code\": \"BH\",\n" +
            "      \"name\": \"Bahrain\",\n" +
            "      \"cities\": [\n" +
            "        \"Manama\",\n" +
            "        \"Al Hadd\",\n" +
            "        \"Al Manamah\",\n" +
            "        \"Al Mintaqah al Gharbiyah\",\n" +
            "        \"Al Mintaqah al Wusta\",\n" +
            "        \"Al Mintaqah ash Shamaliyah\",\n" +
            "        \"Al Muharraq\",\n" +
            "        \"Ar Rifa' wa al Mintaqah al Janubiyah\",\n" +
            "        \"Jidd Hafs\",\n" +
            "        \"Madinat Hamad\",\n" +
            "        \"Madinat 'Isa\",\n" +
            "        \"Juzur Hawar\",\n" +
            "        \"Sitrah\"\n" +
            "      ]\n" +
            "    },\n" +
            "    {\n" +
            "      \"iso\": \"BDI\",\n" +
            "      \"code\": \"BI\",\n" +
            "      \"name\": \"Burundi\",\n" +
            "      \"cities\": [\n" +
            "        \"Bujumbura\",\n" +
            "        \"Bubanza\",\n" +
            "        \"Bujumbura\",\n" +
            "        \"Bururi\",\n" +
            "        \"Cankuzo\",\n" +
            "        \"Cibitoke\",\n" +
            "        \"Gitega\",\n" +
            "        \"Karuzi\",\n" +
            "        \"Kayanza\",\n" +
            "        \"Kirundo\",\n" +
            "        \"Makamba\",\n" +
            "        \"Muramvya\",\n" +
            "        \"Muyinga\",\n" +
            "        \"Mwaro\",\n" +
            "        \"Ngozi\",\n" +
            "        \"Rutana\",\n" +
            "        \"Ruyigi\"\n" +
            "      ]\n" +
            "    },\n" +
            "    {\n" +
            "      \"iso\": \"BEN\",\n" +
            "      \"code\": \"BJ\",\n" +
            "      \"name\": \"Benin\",\n" +
            "      \"cities\": [\n" +
            "        \"Porto-Novo\",\n" +
            "        \"Alibori\",\n" +
            "        \"Atakora\",\n" +
            "        \"Atlantique\",\n" +
            "        \"Borgou\",\n" +
            "        \"Collines\",\n" +
            "        \"Couffo\",\n" +
            "        \"Donga\",\n" +
            "        \"Littoral\",\n" +
            "        \"Mono\",\n" +
            "        \"Oueme\",\n" +
            "        \"Plateau\",\n" +
            "        \"Zou\"\n" +
            "      ]\n" +
            "    },\n" +
            "    {\n" +
            "      \"iso\": \"BMU\",\n" +
            "      \"code\": \"BM\",\n" +
            "      \"name\": \"Bermuda\",\n" +
            "      \"cities\": [\n" +
            "        \"Hamilton\",\n" +
            "        \"Devonshire\",\n" +
            "        \"Hamilton\",\n" +
            "        \"Hamilton\",\n" +
            "        \"Paget\",\n" +
            "        \"Pembroke\",\n" +
            "        \"Saint George\",\n" +
            "        \"Saint George's\",\n" +
            "        \"Sandys\",\n" +
            "        \"Smith's\",\n" +
            "        \"Southampton\",\n" +
            "        \"Warwick\"\n" +
            "      ]\n" +
            "    },\n" +
            "    {\n" +
            "      \"iso\": \"BRN\",\n" +
            "      \"code\": \"BN\",\n" +
            "      \"name\": \"Brunei\",\n" +
            "      \"cities\": [\n" +
            "        \"Bandar Seri Begawan\",\n" +
            "        \"Belait\",\n" +
            "        \"Brunei/Muara\",\n" +
            "        \"Temburong\",\n" +
            "        \"Tutong\"\n" +
            "      ]\n" +
            "    },\n" +
            "    {\n" +
            "      \"iso\": \"BOL\",\n" +
            "      \"code\": \"BO\",\n" +
            "      \"name\": \"Bolivia\",\n" +
            "      \"cities\": [\n" +
            "        \"La Paz\",\n" +
            "        \"Sucre\",\n" +
            "        \"Chuquisaca\",\n" +
            "        \"Cochabamba\",\n" +
            "        \"Beni\",\n" +
            "        \"Oruro\",\n" +
            "        \"Pando\",\n" +
            "        \"Potosi\",\n" +
            "        \"Santa Cruz\",\n" +
            "        \"Tarija\"\n" +
            "      ]\n" +
            "    },\n" +
            "    {\n" +
            "      \"iso\": \"BRA\",\n" +
            "      \"code\": \"BR\",\n" +
            "      \"name\": \"Brazil\",\n" +
            "      \"cities\": [\n" +
            "        \"Brasilia\",\n" +
            "        \"Acre\",\n" +
            "        \"Alagoas\",\n" +
            "        \"Amapa\",\n" +
            "        \"Amazonas\",\n" +
            "        \"Bahia\",\n" +
            "        \"Ceara\",\n" +
            "        \"Distrito Federal\",\n" +
            "        \"Espirito Santo\",\n" +
            "        \"Goias\",\n" +
            "        \"Maranhao\",\n" +
            "        \"Mato Grosso\",\n" +
            "        \"Mato Grosso do Sul\",\n" +
            "        \"Minas Gerais\",\n" +
            "        \"Para\",\n" +
            "        \"Paraiba\",\n" +
            "        \"Parana\",\n" +
            "        \"Pernambuco\",\n" +
            "        \"Piaui\",\n" +
            "        \"Rio de Janeiro\",\n" +
            "        \"Rio Grande do Norte\",\n" +
            "        \"Rio Grande do Sul\",\n" +
            "        \"Rondonia\",\n" +
            "        \"Roraima\",\n" +
            "        \"Santa Catarina\",\n" +
            "        \"Sao Paulo\",\n" +
            "        \"Sergipe\",\n" +
            "        \"Tocantins\"\n" +
            "      ]\n" +
            "    },\n" +
            "    {\n" +
            "      \"iso\": \"BHS\",\n" +
            "      \"code\": \"BS\",\n" +
            "      \"name\": \"Bahamas\",\n" +
            "      \"cities\": [\n" +
            "        \"Nassau\",\n" +
            "        \"Acklins/Crooked Islands\",\n" +
            "        \"Bimini\",\n" +
            "        \"Cat Island\",\n" +
            "        \"Exuma\",\n" +
            "        \"Freeport\",\n" +
            "        \"Fresh Creek\",\n" +
            "        \"Governor's Harbour\",\n" +
            "        \"Green Turtle Cay\",\n" +
            "        \"Harbour Island\",\n" +
            "        \"High Rock\",\n" +
            "        \"Inagua\",\n" +
            "        \"Kemps Bay\",\n" +
            "        \"Long Island\",\n" +
            "        \"Marsh Harbour\",\n" +
            "        \"Mayaguana\",\n" +
            "        \"New Providence\",\n" +
            "        \"Nichollstown/Berry Islands\",\n" +
            "        \"Ragged Island\",\n" +
            "        \"Rock Sound\",\n" +
            "        \"Sandy Point\",\n" +
            "        \"San Salvador/Rum Cay\"\n" +
            "      ]\n" +
            "    },\n" +
            "    {\n" +
            "      \"iso\": \"BTN\",\n" +
            "      \"code\": \"BT\",\n" +
            "      \"name\": \"Bhutan\",\n" +
            "      \"cities\": [\n" +
            "        \"Thimphu\",\n" +
            "        \"Bumthang\",\n" +
            "        \"Chhukha\",\n" +
            "        \"Chirang\",\n" +
            "        \"Dagana\",\n" +
            "        \"Gasa\",\n" +
            "        \"Geylegphug\",\n" +
            "        \"Ha\",\n" +
            "        \"Lhuntshi\",\n" +
            "        \"Mongar\",\n" +
            "        \"Paro\",\n" +
            "        \"Pemagatsel\",\n" +
            "        \"Punakha\",\n" +
            "        \"Samchi\",\n" +
            "        \"Samdrup Jongkhar\",\n" +
            "        \"Shemgang\",\n" +
            "        \"Tashigang\",\n" +
            "        \"Tongsa\",\n" +
            "        \"Wangdi Phodrang\",\n" +
            "        \"Yangtse\"\n" +
            "      ]\n" +
            "    },\n" +
            "    {\n" +
            "      \"iso\": \"BWA\",\n" +
            "      \"code\": \"BW\",\n" +
            "      \"name\": \"Botswana\",\n" +
            "      \"cities\": [\n" +
            "        \"Gaborone\",\n" +
            "        \"Central\",\n" +
            "        \"Chobe\",\n" +
            "        \"Francistown\",\n" +
            "        \"Ghanzi\",\n" +
            "        \"Kgalagadi\",\n" +
            "        \"Kgatleng\",\n" +
            "        \"Kweneng\",\n" +
            "        \"Lobatse\",\n" +
            "        \"Ngamiland\",\n" +
            "        \"North-East\",\n" +
            "        \"Selebi-Pikwe\",\n" +
            "        \"South-East\",\n" +
            "        \"Southern\"\n" +
            "      ]\n" +
            "    },\n" +
            "    {\n" +
            "      \"iso\": \"BLR\",\n" +
            "      \"code\": \"BY\",\n" +
            "      \"name\": \"Belarus\",\n" +
            "      \"cities\": [\n" +
            "        \"Minsk\",\n" +
            "        \"Brest\",\n" +
            "        \"Homyel'\",\n" +
            "        \"Horad Minsk\",\n" +
            "        \"Hrodna\",\n" +
            "        \"Mahilyow\",\n" +
            "        \"Vitsyebsk\"\n" +
            "      ]\n" +
            "    },\n" +
            "    {\n" +
            "      \"iso\": \"BLZ\",\n" +
            "      \"code\": \"BZ\",\n" +
            "      \"name\": \"Belize\",\n" +
            "      \"cities\": [\n" +
            "        \"Belmopan\",\n" +
            "        \"Belize\",\n" +
            "        \"Cayo\",\n" +
            "        \"Corozal\",\n" +
            "        \"Orange Walk\",\n" +
            "        \"Stann Creek\",\n" +
            "        \"Toledo\"\n" +
            "      ]\n" +
            "    },\n" +
            "    {\n" +
            "      \"iso\": \"CAN\",\n" +
            "      \"code\": \"CA\",\n" +
            "      \"name\": \"Canada\",\n" +
            "      \"cities\": [\n" +
            "        \"Ottawa\",\n" +
            "        \"Alberta\",\n" +
            "        \"British Columbia\",\n" +
            "        \"Manitoba\",\n" +
            "        \"New Brunswick\",\n" +
            "        \"Newfoundland and Labrador\",\n" +
            "        \"Northwest Territories\",\n" +
            "        \"Nova Scotia\",\n" +
            "        \"Nunavut\",\n" +
            "        \"Ontario\",\n" +
            "        \"Prince Edward Island\",\n" +
            "        \"Quebec\",\n" +
            "        \"Saskatchewan\",\n" +
            "        \"Yukon Territory\"\n" +
            "      ]\n" +
            "    },\n" +
            "    {\n" +
            "      \"iso\": \"CAF\",\n" +
            "      \"code\": \"CF\",\n" +
            "      \"name\": \"Central African Republic\",\n" +
            "      \"cities\": [\n" +
            "        \"Bangui\",\n" +
            "        \"Bamingui-Bangoran\",\n" +
            "        \"Basse-Kotto\",\n" +
            "        \"Gribingui\",\n" +
            "        \"Haute-Kotto\",\n" +
            "        \"Haute-Sangha\",\n" +
            "        \"Haut-Mbomou\",\n" +
            "        \"Kemo-Gribingui\",\n" +
            "        \"Lobaye\",\n" +
            "        \"Mbomou\",\n" +
            "        \"Nana-Mambere\",\n" +
            "        \"Ombella-Mpoko\",\n" +
            "        \"Ouaka\",\n" +
            "        \"Ouham\",\n" +
            "        \"Ouham-Pende\",\n" +
            "        \"Sangha\",\n" +
            "        \"Vakaga\"\n" +
            "      ]\n" +
            "    },\n" +
            "    {\n" +
            "      \"iso\": \"CHE\",\n" +
            "      \"code\": \"CH\",\n" +
            "      \"name\": \"Switzerland\",\n" +
            "      \"cities\": [\n" +
            "        \"Bern\",\n" +
            "        \"Aargau\",\n" +
            "        \"Appenzell Ausser-Rhoden\",\n" +
            "        \"Appenzell Inner-Rhoden\",\n" +
            "        \"Basel-Landschaft\",\n" +
            "        \"Basel-Stadt\",\n" +
            "        \"Fribourg\",\n" +
            "        \"Geneve\",\n" +
            "        \"Glarus\",\n" +
            "        \"Graubunden\",\n" +
            "        \"Jura\",\n" +
            "        \"Luzern\",\n" +
            "        \"Neuchatel\",\n" +
            "        \"Nidwalden\",\n" +
            "        \"Obwalden\",\n" +
            "        \"Sankt Gallen\",\n" +
            "        \"Schaffhausen\",\n" +
            "        \"Schwyz\",\n" +
            "        \"Solothurn\",\n" +
            "        \"Thurgau\",\n" +
            "        \"Ticino\",\n" +
            "        \"Uri\",\n" +
            "        \"Valais\",\n" +
            "        \"Vaud\",\n" +
            "        \"Zug\",\n" +
            "        \"Zurich\"\n" +
            "      ]\n" +
            "    },\n" +
            "    {\n" +
            "      \"iso\": \"CHL\",\n" +
            "      \"code\": \"CL\",\n" +
            "      \"name\": \"Chile\",\n" +
            "      \"cities\": [\n" +
            "        \"Santiago\",\n" +
            "        \"Antofagasta\",\n" +
            "        \"Araucania\",\n" +
            "        \"Atacama\",\n" +
            "        \"Bio-Bio\",\n" +
            "        \"Coquimbo\",\n" +
            "        \"Los Lagos\",\n" +
            "        \"Maule\",\n" +
            "        \"Tarapaca\",\n" +
            "        \"Valparaiso\"\n" +
            "      ]\n" +
            "    },\n" +
            "    {\n" +
            "      \"iso\": \"CMR\",\n" +
            "      \"code\": \"CM\",\n" +
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
            "      \"iso\": \"CHN\",\n" +
            "      \"code\": \"CN\",\n" +
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
            "        \"Hainan\",\n" +
            "        \"Hebei\",\n" +
            "        \"Heilongjiang\",\n" +
            "        \"Henan\",\n" +
            "        \"Hubei\",\n" +
            "        \"Hunan\",\n" +
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
            "      \"iso\": \"COL\",\n" +
            "      \"code\": \"CO\",\n" +
            "      \"name\": \"Colombia\",\n" +
            "      \"cities\": [\n" +
            "        \"Bogota\",\n" +
            "        \"Amazonas\",\n" +
            "        \"Antioquia\",\n" +
            "        \"Arauca\",\n" +
            "        \"Atlantico\",\n" +
            "        \"Bolivar\",\n" +
            "        \"Boyaca\",\n" +
            "        \"Caldas\",\n" +
            "        \"Caqueta\",\n" +
            "        \"Casanare\",\n" +
            "        \"Cauca\",\n" +
            "        \"Cesar\",\n" +
            "        \"Choco\",\n" +
            "        \"Cordoba\",\n" +
            "        \"Cundinamarca\",\n" +
            "        \"Guainia\",\n" +
            "        \"Guaviare\",\n" +
            "        \"Huila\",\n" +
            "        \"La Guajira\",\n" +
            "        \"Magdalena\",\n" +
            "        \"Meta\",\n" +
            "        \"Narino\",\n" +
            "        \"Norte de Santander\",\n" +
            "        \"Putumayo\",\n" +
            "        \"Quindio\",\n" +
            "        \"Risaralda\",\n" +
            "        \"San Andres/Providencia\",\n" +
            "        \"Santander\",\n" +
            "        \"Sucre\",\n" +
            "        \"Tolima\",\n" +
            "        \"Valle del Cauca\",\n" +
            "        \"Vaupes\",\n" +
            "        \"Vichada\"\n" +
            "      ]\n" +
            "    },\n" +
            "    {\n" +
            "      \"iso\": \"CRI\",\n" +
            "      \"code\": \"CR\",\n" +
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
            "      \"iso\": \"CUB\",\n" +
            "      \"code\": \"CU\",\n" +
            "      \"name\": \"Cuba\",\n" +
            "      \"cities\": [\n" +
            "        \"Havana\",\n" +
            "        \"Camaguey\",\n" +
            "        \"Ciego de Avila\",\n" +
            "        \"Cienfuegos\",\n" +
            "        \"Ciudad de La Habana\",\n" +
            "        \"Granma\",\n" +
            "        \"Guantanamo\",\n" +
            "        \"Holguin\",\n" +
            "        \"Isla de la Juventud\",\n" +
            "        \"La Habana\",\n" +
            "        \"Las Tunas\",\n" +
            "        \"Matanzas\",\n" +
            "        \"Pinar del Rio\",\n" +
            "        \"Sancti Spiritus\",\n" +
            "        \"Santiago de Cuba\",\n" +
            "        \"Villa Clara\"\n" +
            "      ]\n" +
            "    },\n" +
            "    {\n" +
            "      \"iso\": \"CPV\",\n" +
            "      \"code\": \"CV\",\n" +
            "      \"name\": \"Cape Verde\",\n" +
            "      \"cities\": [\n" +
            "        \"Praia\",\n" +
            "        \"Boa Vista\",\n" +
            "        \"Brava\",\n" +
            "        \"Calheta\",\n" +
            "        \"Maio\",\n" +
            "        \"Mosteiros\",\n" +
            "        \"Paul\",\n" +
            "        \"Porto Novo\",\n" +
            "        \"Ribeira Grande\",\n" +
            "        \"Sal\",\n" +
            "        \"Santa Catarina\",\n" +
            "        \"Santa Cruz\",\n" +
            "        \"Sao Domingos\",\n" +
            "        \"Sao Nicolau\",\n" +
            "        \"Sao Filipe\",\n" +
            "        \"Sao Vicente\",\n" +
            "        \"Tarrafal\"\n" +
            "      ]\n" +
            "    },\n" +
            "    {\n" +
            "      \"iso\": \"CYP\",\n" +
            "      \"code\": \"CY\",\n" +
            "      \"name\": \"Cyprus\",\n" +
            "      \"cities\": [\n" +
            "        \"Nicosia\",\n" +
            "        \"Famagusta\",\n" +
            "        \"Kyrenia\",\n" +
            "        \"Larnaca\",\n" +
            "        \"Limassol\",\n" +
            "        \"Paphos\"\n" +
            "      ]\n" +
            "    },\n" +
            "    {\n" +
            "      \"iso\": \"CZE\",\n" +
            "      \"code\": \"CZ\",\n" +
            "      \"name\": \"Czech Republic\",\n" +
            "      \"cities\": [\n" +
            "        \"Prague (Praha)\",\n" +
            "        \"Jihocesky\",\n" +
            "        \"Jihomoravsky\",\n" +
            "        \"Karlovarsky\",\n" +
            "        \"Kralovehradecky\",\n" +
            "        \"Liberecky\",\n" +
            "        \"Moravskoslezsky\",\n" +
            "        \"Olomoucky\",\n" +
            "        \"Pardubicky\",\n" +
            "        \"Plzensky\",\n" +
            "        \"Stredocesky\",\n" +
            "        \"Ustecky\",\n" +
            "        \"Vysocina\",\n" +
            "        \"Zlinsky\"\n" +
            "      ]\n" +
            "    },\n" +
            "    {\n" +
            "      \"iso\": \"DEU\",\n" +
            "      \"code\": \"DE\",\n" +
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
            "      \"iso\": \"DJI\",\n" +
            "      \"code\": \"DJ\",\n" +
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
            "      \"iso\": \"DNK\",\n" +
            "      \"code\": \"DK\",\n" +
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
            "      \"iso\": \"DMA\",\n" +
            "      \"code\": \"DM\",\n" +
            "      \"name\": \"Dominica\",\n" +
            "      \"cities\": [\n" +
            "        \"Roseau\",\n" +
            "        \"Saint Andrew\",\n" +
            "        \"Saint David\",\n" +
            "        \"Saint George\",\n" +
            "        \"Saint John\",\n" +
            "        \"Saint Joseph\",\n" +
            "        \"Saint Luke\",\n" +
            "        \"Saint Mark\",\n" +
            "        \"Saint Patrick\",\n" +
            "        \"Saint Paul\",\n" +
            "        \"Saint Peter\"\n" +
            "      ]\n" +
            "    }\n" +
            "  ]\n" +
            "}";
    private static final String CURRENCIES_JSON = "{\n" +
            "  \"currencies\": [\n" +
            "    {\n" +
            "      \"currencyCode\": \"AED\",\n" +
            "      \"displayName\": \"United Arab Emirates Dirham\",\n" +
            "      \"numericCode\": 784,\n" +
            "      \"symbol\": \"AED\",\n" +
            "      \"defaultFractionDigits\": 2\n" +
            "    },\n" +
            "    {\n" +
            "      \"currencyCode\": \"JOD\",\n" +
            "      \"displayName\": \"Jordanian Dinar\",\n" +
            "      \"numericCode\": 400,\n" +
            "      \"symbol\": \"JOD\",\n" +
            "      \"defaultFractionDigits\": 3\n" +
            "    },\n" +
            "    {\n" +
            "      \"currencyCode\": \"SYP\",\n" +
            "      \"displayName\": \"Syrian Pound\",\n" +
            "      \"numericCode\": 760,\n" +
            "      \"symbol\": \"SYP\",\n" +
            "      \"defaultFractionDigits\": 2\n" +
            "    },\n" +
            "    {\n" +
            "      \"currencyCode\": \"HRK\",\n" +
            "      \"displayName\": \"Kuna\",\n" +
            "      \"numericCode\": 191,\n" +
            "      \"symbol\": \"HRK\",\n" +
            "      \"defaultFractionDigits\": 2\n" +
            "    },\n" +
            "    {\n" +
            "      \"currencyCode\": \"EUR\",\n" +
            "      \"displayName\": \"Euro\",\n" +
            "      \"numericCode\": 978,\n" +
            "      \"symbol\": \"EUR\",\n" +
            "      \"defaultFractionDigits\": 2\n" +
            "    },\n" +
            "    {\n" +
            "      \"currencyCode\": \"PAB\",\n" +
            "      \"displayName\": \"Panamanian Balboa\",\n" +
            "      \"numericCode\": 590,\n" +
            "      \"symbol\": \"PAB\",\n" +
            "      \"defaultFractionDigits\": 2\n" +
            "    },\n" +
            "    {\n" +
            "      \"currencyCode\": \"EUR\",\n" +
            "      \"displayName\": \"Euro\",\n" +
            "      \"numericCode\": 978,\n" +
            "      \"symbol\": \"EUR\",\n" +
            "      \"defaultFractionDigits\": 2\n" +
            "    },\n" +
            "    {\n" +
            "      \"currencyCode\": \"VEF\",\n" +
            "      \"displayName\": \"Venezuelan BolÃ\u00ADvar\",\n" +
            "      \"numericCode\": 937,\n" +
            "      \"symbol\": \"VEF\",\n" +
            "      \"defaultFractionDigits\": 2\n" +
            "    },\n" +
            "    {\n" +
            "      \"currencyCode\": \"TWD\",\n" +
            "      \"displayName\": \"New Taiwan Dollar\",\n" +
            "      \"numericCode\": 901,\n" +
            "      \"symbol\": \"TWD\",\n" +
            "      \"defaultFractionDigits\": 2\n" +
            "    },\n" +
            "    {\n" +
            "      \"currencyCode\": \"DKK\",\n" +
            "      \"displayName\": \"Danish Krone\",\n" +
            "      \"numericCode\": 208,\n" +
            "      \"symbol\": \"DKK\",\n" +
            "      \"defaultFractionDigits\": 2\n" +
            "    },\n" +
            "    {\n" +
            "      \"currencyCode\": \"USD\",\n" +
            "      \"displayName\": \"US Dollar\",\n" +
            "      \"numericCode\": 840,\n" +
            "      \"symbol\": \"$\",\n" +
            "      \"defaultFractionDigits\": 2\n" +
            "    },\n" +
            "    {\n" +
            "      \"currencyCode\": \"VND\",\n" +
            "      \"displayName\": \"Vietnamese Dong\",\n" +
            "      \"numericCode\": 704,\n" +
            "      \"symbol\": \"VND\",\n" +
            "      \"defaultFractionDigits\": 0\n" +
            "    },\n" +
            "    {\n" +
            "      \"currencyCode\": \"USD\",\n" +
            "      \"displayName\": \"US Dollar\",\n" +
            "      \"numericCode\": 840,\n" +
            "      \"symbol\": \"$\",\n" +
            "      \"defaultFractionDigits\": 2\n" +
            "    },\n" +
            "    {\n" +
            "      \"currencyCode\": \"EUR\",\n" +
            "      \"displayName\": \"Euro\",\n" +
            "      \"numericCode\": 978,\n" +
            "      \"symbol\": \"EUR\",\n" +
            "      \"defaultFractionDigits\": 2\n" +
            "    },\n" +
            "    {\n" +
            "      \"currencyCode\": \"SEK\",\n" +
            "      \"displayName\": \"Swedish Krona\",\n" +
            "      \"numericCode\": 752,\n" +
            "      \"symbol\": \"SEK\",\n" +
            "      \"defaultFractionDigits\": 2\n" +
            "    },\n" +
            "    {\n" +
            "      \"currencyCode\": \"BOB\",\n" +
            "      \"displayName\": \"Bolivian Boliviano\",\n" +
            "      \"numericCode\": 68,\n" +
            "      \"symbol\": \"BOB\",\n" +
            "      \"defaultFractionDigits\": 2\n" +
            "    },\n" +
            "    {\n" +
            "      \"currencyCode\": \"SGD\",\n" +
            "      \"displayName\": \"Singapore Dollar\",\n" +
            "      \"numericCode\": 702,\n" +
            "      \"symbol\": \"SGD\",\n" +
            "      \"defaultFractionDigits\": 2\n" +
            "    },\n" +
            "    {\n" +
            "      \"currencyCode\": \"BHD\",\n" +
            "      \"displayName\": \"Bahraini Dinar\",\n" +
            "      \"numericCode\": 48,\n" +
            "      \"symbol\": \"BHD\",\n" +
            "      \"defaultFractionDigits\": 3\n" +
            "    },\n" +
            "    {\n" +
            "      \"currencyCode\": \"SAR\",\n" +
            "      \"displayName\": \"Saudi Riyal\",\n" +
            "      \"numericCode\": 682,\n" +
            "      \"symbol\": \"SAR\",\n" +
            "      \"defaultFractionDigits\": 2\n" +
            "    },\n" +
            "    {\n" +
            "      \"currencyCode\": \"YER\",\n" +
            "      \"displayName\": \"Yemeni Rial\",\n" +
            "      \"numericCode\": 886,\n" +
            "      \"symbol\": \"YER\",\n" +
            "      \"defaultFractionDigits\": 2\n" +
            "    },\n" +
            "    {\n" +
            "      \"currencyCode\": \"INR\",\n" +
            "      \"displayName\": \"Indian Rupee\",\n" +
            "      \"numericCode\": 356,\n" +
            "      \"symbol\": \"INR\",\n" +
            "      \"defaultFractionDigits\": 2\n" +
            "    },\n" +
            "    {\n" +
            "      \"currencyCode\": \"EUR\",\n" +
            "      \"displayName\": \"Euro\",\n" +
            "      \"numericCode\": 978,\n" +
            "      \"symbol\": \"EUR\",\n" +
            "      \"defaultFractionDigits\": 2\n" +
            "    },\n" +
            "    {\n" +
            "      \"currencyCode\": \"EUR\",\n" +
            "      \"displayName\": \"Euro\",\n" +
            "      \"numericCode\": 978,\n" +
            "      \"symbol\": \"EUR\",\n" +
            "      \"defaultFractionDigits\": 2\n" +
            "    },\n" +
            "    {\n" +
            "      \"currencyCode\": \"BAM\",\n" +
            "      \"displayName\": \"Bosnia-Herzegovina Convertible Mark\",\n" +
            "      \"numericCode\": 977,\n" +
            "      \"symbol\": \"BAM\",\n" +
            "      \"defaultFractionDigits\": 2\n" +
            "    },\n" +
            "    {\n" +
            "      \"currencyCode\": \"UAH\",\n" +
            "      \"displayName\": \"Ukrainian Hryvnia\",\n" +
            "      \"numericCode\": 980,\n" +
            "      \"symbol\": \"UAH\",\n" +
            "      \"defaultFractionDigits\": 2\n" +
            "    },\n" +
            "    {\n" +
            "      \"currencyCode\": \"CHF\",\n" +
            "      \"displayName\": \"Swiss Franc\",\n" +
            "      \"numericCode\": 756,\n" +
            "      \"symbol\": \"CHF\",\n" +
            "      \"defaultFractionDigits\": 2\n" +
            "    },\n" +
            "    {\n" +
            "      \"currencyCode\": \"ARS\",\n" +
            "      \"displayName\": \"Argentine Peso\",\n" +
            "      \"numericCode\": 32,\n" +
            "      \"symbol\": \"ARS\",\n" +
            "      \"defaultFractionDigits\": 2\n" +
            "    },\n" +
            "    {\n" +
            "      \"currencyCode\": \"EGP\",\n" +
            "      \"displayName\": \"Egyptian Pound\",\n" +
            "      \"numericCode\": 818,\n" +
            "      \"symbol\": \"EGP\",\n" +
            "      \"defaultFractionDigits\": 2\n" +
            "    },\n" +
            "    {\n" +
            "      \"currencyCode\": \"JPY\",\n" +
            "      \"displayName\": \"Japanese Yen\",\n" +
            "      \"numericCode\": 392,\n" +
            "      \"symbol\": \"JPY\",\n" +
            "      \"defaultFractionDigits\": 0\n" +
            "    },\n" +
            "    {\n" +
            "      \"currencyCode\": \"SVC\",\n" +
            "      \"displayName\": \"Salvadoran ColÃ³n\",\n" +
            "      \"numericCode\": 222,\n" +
            "      \"symbol\": \"SVC\",\n" +
            "      \"defaultFractionDigits\": 2\n" +
            "    },\n" +
            "    {\n" +
            "      \"currencyCode\": \"BRL\",\n" +
            "      \"displayName\": \"Brazilian Real\",\n" +
            "      \"numericCode\": 986,\n" +
            "      \"symbol\": \"BRL\",\n" +
            "      \"defaultFractionDigits\": 2\n" +
            "    },\n" +
            "    {\n" +
            "      \"currencyCode\": \"ISK\",\n" +
            "      \"displayName\": \"Icelandic KrÃ³na\",\n" +
            "      \"numericCode\": 352,\n" +
            "      \"symbol\": \"ISK\",\n" +
            "      \"defaultFractionDigits\": 0\n" +
            "    },\n" +
            "    {\n" +
            "      \"currencyCode\": \"CZK\",\n" +
            "      \"displayName\": \"Czech Republic Koruna\",\n" +
            "      \"numericCode\": 203,\n" +
            "      \"symbol\": \"CZK\",\n" +
            "      \"defaultFractionDigits\": 2\n" +
            "    },\n" +
            "    {\n" +
            "      \"currencyCode\": \"PLN\",\n" +
            "      \"displayName\": \"Polish Zloty\",\n" +
            "      \"numericCode\": 985,\n" +
            "      \"symbol\": \"PLN\",\n" +
            "      \"defaultFractionDigits\": 2\n" +
            "    },\n" +
            "    {\n" +
            "      \"currencyCode\": \"EUR\",\n" +
            "      \"displayName\": \"Euro\",\n" +
            "      \"numericCode\": 978,\n" +
            "      \"symbol\": \"EUR\",\n" +
            "      \"defaultFractionDigits\": 2\n" +
            "    },\n" +
            "    {\n" +
            "      \"currencyCode\": \"CSD\",\n" +
            "      \"displayName\": \"Serbian Dinar (2002-2006)\",\n" +
            "      \"numericCode\": 891,\n" +
            "      \"symbol\": \"CSD\",\n" +
            "      \"defaultFractionDigits\": 2\n" +
            "    },\n" +
            "    {\n" +
            "      \"currencyCode\": \"MYR\",\n" +
            "      \"displayName\": \"Malaysian Ringgit\",\n" +
            "      \"numericCode\": 458,\n" +
            "      \"symbol\": \"MYR\",\n" +
            "      \"defaultFractionDigits\": 2\n" +
            "    },\n" +
            "    {\n" +
            "      \"currencyCode\": \"EUR\",\n" +
            "      \"displayName\": \"Euro\",\n" +
            "      \"numericCode\": 978,\n" +
            "      \"symbol\": \"EUR\",\n" +
            "      \"defaultFractionDigits\": 2\n" +
            "    },\n" +
            "    {\n" +
            "      \"currencyCode\": \"COP\",\n" +
            "      \"displayName\": \"Colombian Peso\",\n" +
            "      \"numericCode\": 170,\n" +
            "      \"symbol\": \"COP\",\n" +
            "      \"defaultFractionDigits\": 2\n" +
            "    },\n" +
            "    {\n" +
            "      \"currencyCode\": \"BGN\",\n" +
            "      \"displayName\": \"Bulgarian Lev\",\n" +
            "      \"numericCode\": 975,\n" +
            "      \"symbol\": \"BGN\",\n" +
            "      \"defaultFractionDigits\": 2\n" +
            "    },\n" +
            "    {\n" +
            "      \"currencyCode\": \"BAM\",\n" +
            "      \"displayName\": \"Bosnia-Herzegovina Convertible Mark\",\n" +
            "      \"numericCode\": 977,\n" +
            "      \"symbol\": \"BAM\",\n" +
            "      \"defaultFractionDigits\": 2\n" +
            "    },\n" +
            "    {\n" +
            "      \"currencyCode\": \"PYG\",\n" +
            "      \"displayName\": \"Paraguayan Guarani\",\n" +
            "      \"numericCode\": 600,\n" +
            "      \"symbol\": \"PYG\",\n" +
            "      \"defaultFractionDigits\": 0\n" +
            "    },\n" +
            "    {\n" +
            "      \"currencyCode\": \"USD\",\n" +
            "      \"displayName\": \"US Dollar\",\n" +
            "      \"numericCode\": 840,\n" +
            "      \"symbol\": \"$\",\n" +
            "      \"defaultFractionDigits\": 2\n" +
            "    },\n" +
            "    {\n" +
            "      \"currencyCode\": \"USD\",\n" +
            "      \"displayName\": \"US Dollar\",\n" +
            "      \"numericCode\": 840,\n" +
            "      \"symbol\": \"$\",\n" +
            "      \"defaultFractionDigits\": 2\n" +
            "    },\n" +
            "    {\n" +
            "      \"currencyCode\": \"SDG\",\n" +
            "      \"displayName\": \"Sudanese Pound\",\n" +
            "      \"numericCode\": 938,\n" +
            "      \"symbol\": \"SDG\",\n" +
            "      \"defaultFractionDigits\": 2\n" +
            "    },\n" +
            "    {\n" +
            "      \"currencyCode\": \"RON\",\n" +
            "      \"displayName\": \"Romanian Leu\",\n" +
            "      \"numericCode\": 946,\n" +
            "      \"symbol\": \"RON\",\n" +
            "      \"defaultFractionDigits\": 2\n" +
            "    },\n" +
            "    {\n" +
            "      \"currencyCode\": \"PHP\",\n" +
            "      \"displayName\": \"Philippine Peso\",\n" +
            "      \"numericCode\": 608,\n" +
            "      \"symbol\": \"PHP\",\n" +
            "      \"defaultFractionDigits\": 2\n" +
            "    },\n" +
            "    {\n" +
            "      \"currencyCode\": \"TND\",\n" +
            "      \"displayName\": \"Tunisian Dinar\",\n" +
            "      \"numericCode\": 788,\n" +
            "      \"symbol\": \"TND\",\n" +
            "      \"defaultFractionDigits\": 3\n" +
            "    },\n" +
            "    {\n" +
            "      \"currencyCode\": \"EUR\",\n" +
            "      \"displayName\": \"Euro\",\n" +
            "      \"numericCode\": 978,\n" +
            "      \"symbol\": \"EUR\",\n" +
            "      \"defaultFractionDigits\": 2\n" +
            "    },\n" +
            "    {\n" +
            "      \"currencyCode\": \"GTQ\",\n" +
            "      \"displayName\": \"Guatemalan Quetzal\",\n" +
            "      \"numericCode\": 320,\n" +
            "      \"symbol\": \"GTQ\",\n" +
            "      \"defaultFractionDigits\": 2\n" +
            "    },\n" +
            "    {\n" +
            "      \"currencyCode\": \"KRW\",\n" +
            "      \"displayName\": \"South Korean Won\",\n" +
            "      \"numericCode\": 410,\n" +
            "      \"symbol\": \"KRW\",\n" +
            "      \"defaultFractionDigits\": 0\n" +
            "    },\n" +
            "    {\n" +
            "      \"currencyCode\": \"EUR\",\n" +
            "      \"displayName\": \"Euro\",\n" +
            "      \"numericCode\": 978,\n" +
            "      \"symbol\": \"EUR\",\n" +
            "      \"defaultFractionDigits\": 2\n" +
            "    },\n" +
            "    {\n" +
            "      \"currencyCode\": \"MXN\",\n" +
            "      \"displayName\": \"Mexican Peso\",\n" +
            "      \"numericCode\": 484,\n" +
            "      \"symbol\": \"MXN\",\n" +
            "      \"defaultFractionDigits\": 2\n" +
            "    },\n" +
            "    {\n" +
            "      \"currencyCode\": \"RUB\",\n" +
            "      \"displayName\": \"Russian Ruble\",\n" +
            "      \"numericCode\": 643,\n" +
            "      \"symbol\": \"RUB\",\n" +
            "      \"defaultFractionDigits\": 2\n" +
            "    },\n" +
            "    {\n" +
            "      \"currencyCode\": \"HNL\",\n" +
            "      \"displayName\": \"Honduran Lempira\",\n" +
            "      \"numericCode\": 340,\n" +
            "      \"symbol\": \"HNL\",\n" +
            "      \"defaultFractionDigits\": 2\n" +
            "    },\n" +
            "    {\n" +
            "      \"currencyCode\": \"HKD\",\n" +
            "      \"displayName\": \"Hong Kong Dollar\",\n" +
            "      \"numericCode\": 344,\n" +
            "      \"symbol\": \"HKD\",\n" +
            "      \"defaultFractionDigits\": 2\n" +
            "    },\n" +
            "    {\n" +
            "      \"currencyCode\": \"NOK\",\n" +
            "      \"displayName\": \"Norwegian Krone\",\n" +
            "      \"numericCode\": 578,\n" +
            "      \"symbol\": \"NOK\",\n" +
            "      \"defaultFractionDigits\": 2\n" +
            "    },\n" +
            "    {\n" +
            "      \"currencyCode\": \"HUF\",\n" +
            "      \"displayName\": \"Hungarian Forint\",\n" +
            "      \"numericCode\": 348,\n" +
            "      \"symbol\": \"HUF\",\n" +
            "      \"defaultFractionDigits\": 2\n" +
            "    },\n" +
            "    {\n" +
            "      \"currencyCode\": \"THB\",\n" +
            "      \"displayName\": \"Thai Baht\",\n" +
            "      \"numericCode\": 764,\n" +
            "      \"symbol\": \"THB\",\n" +
            "      \"defaultFractionDigits\": 2\n" +
            "    },\n" +
            "    {\n" +
            "      \"currencyCode\": \"IQD\",\n" +
            "      \"displayName\": \"Iraqi Dinar\",\n" +
            "      \"numericCode\": 368,\n" +
            "      \"symbol\": \"IQD\",\n" +
            "      \"defaultFractionDigits\": 3\n" +
            "    },\n" +
            "    {\n" +
            "      \"currencyCode\": \"CLP\",\n" +
            "      \"displayName\": \"Chilean Peso\",\n" +
            "      \"numericCode\": 152,\n" +
            "      \"symbol\": \"CLP\",\n" +
            "      \"defaultFractionDigits\": 0\n" +
            "    },\n" +
            "    {\n" +
            "      \"currencyCode\": \"MAD\",\n" +
            "      \"displayName\": \"Moroccan Dirham\",\n" +
            "      \"numericCode\": 504,\n" +
            "      \"symbol\": \"MAD\",\n" +
            "      \"defaultFractionDigits\": 2\n" +
            "    },\n" +
            "    {\n" +
            "      \"currencyCode\": \"EUR\",\n" +
            "      \"displayName\": \"Euro\",\n" +
            "      \"numericCode\": 978,\n" +
            "      \"symbol\": \"EUR\",\n" +
            "      \"defaultFractionDigits\": 2\n" +
            "    },\n" +
            "    {\n" +
            "      \"currencyCode\": \"TRY\",\n" +
            "      \"displayName\": \"Turkish Lira\",\n" +
            "      \"numericCode\": 949,\n" +
            "      \"symbol\": \"TRY\",\n" +
            "      \"defaultFractionDigits\": 2\n" +
            "    },\n" +
            "    {\n" +
            "      \"currencyCode\": \"EUR\",\n" +
            "      \"displayName\": \"Euro\",\n" +
            "      \"numericCode\": 978,\n" +
            "      \"symbol\": \"EUR\",\n" +
            "      \"defaultFractionDigits\": 2\n" +
            "    },\n" +
            "    {\n" +
            "      \"currencyCode\": \"QAR\",\n" +
            "      \"displayName\": \"Qatari Rial\",\n" +
            "      \"numericCode\": 634,\n" +
            "      \"symbol\": \"QAR\",\n" +
            "      \"defaultFractionDigits\": 2\n" +
            "    },\n" +
            "    {\n" +
            "      \"currencyCode\": \"EUR\",\n" +
            "      \"displayName\": \"Euro\",\n" +
            "      \"numericCode\": 978,\n" +
            "      \"symbol\": \"EUR\",\n" +
            "      \"defaultFractionDigits\": 2\n" +
            "    },\n" +
            "    {\n" +
            "      \"currencyCode\": \"EUR\",\n" +
            "      \"displayName\": \"Euro\",\n" +
            "      \"numericCode\": 978,\n" +
            "      \"symbol\": \"EUR\",\n" +
            "      \"defaultFractionDigits\": 2\n" +
            "    },\n" +
            "    {\n" +
            "      \"currencyCode\": \"OMR\",\n" +
            "      \"displayName\": \"Omani Rial\",\n" +
            "      \"numericCode\": 512,\n" +
            "      \"symbol\": \"OMR\",\n" +
            "      \"defaultFractionDigits\": 3\n" +
            "    },\n" +
            "    {\n" +
            "      \"currencyCode\": \"ALL\",\n" +
            "      \"displayName\": \"Albanian Lek\",\n" +
            "      \"numericCode\": 8,\n" +
            "      \"symbol\": \"ALL\",\n" +
            "      \"defaultFractionDigits\": 2\n" +
            "    },\n" +
            "    {\n" +
            "      \"currencyCode\": \"DOP\",\n" +
            "      \"displayName\": \"Dominican Peso\",\n" +
            "      \"numericCode\": 214,\n" +
            "      \"symbol\": \"DOP\",\n" +
            "      \"defaultFractionDigits\": 2\n" +
            "    },\n" +
            "    {\n" +
            "      \"currencyCode\": \"CUP\",\n" +
            "      \"displayName\": \"Cuban Peso\",\n" +
            "      \"numericCode\": 192,\n" +
            "      \"symbol\": \"CUP\",\n" +
            "      \"defaultFractionDigits\": 2\n" +
            "    },\n" +
            "    {\n" +
            "      \"currencyCode\": \"NZD\",\n" +
            "      \"displayName\": \"New Zealand Dollar\",\n" +
            "      \"numericCode\": 554,\n" +
            "      \"symbol\": \"NZD\",\n" +
            "      \"defaultFractionDigits\": 2\n" +
            "    },\n" +
            "    {\n" +
            "      \"currencyCode\": \"RSD\",\n" +
            "      \"displayName\": \"Serbian Dinar\",\n" +
            "      \"numericCode\": 941,\n" +
            "      \"symbol\": \"RSD\",\n" +
            "      \"defaultFractionDigits\": 2\n" +
            "    },\n" +
            "    {\n" +
            "      \"currencyCode\": \"CHF\",\n" +
            "      \"displayName\": \"Swiss Franc\",\n" +
            "      \"numericCode\": 756,\n" +
            "      \"symbol\": \"CHF\",\n" +
            "      \"defaultFractionDigits\": 2\n" +
            "    },\n" +
            "    {\n" +
            "      \"currencyCode\": \"UYU\",\n" +
            "      \"displayName\": \"Uruguayan Peso\",\n" +
            "      \"numericCode\": 858,\n" +
            "      \"symbol\": \"UYU\",\n" +
            "      \"defaultFractionDigits\": 2\n" +
            "    },\n" +
            "    {\n" +
            "      \"currencyCode\": \"EUR\",\n" +
            "      \"displayName\": \"Euro\",\n" +
            "      \"numericCode\": 978,\n" +
            "      \"symbol\": \"EUR\",\n" +
            "      \"defaultFractionDigits\": 2\n" +
            "    },\n" +
            "    {\n" +
            "      \"currencyCode\": \"ILS\",\n" +
            "      \"displayName\": \"Israeli New Sheqel\",\n" +
            "      \"numericCode\": 376,\n" +
            "      \"symbol\": \"ILS\",\n" +
            "      \"defaultFractionDigits\": 2\n" +
            "    },\n" +
            "    {\n" +
            "      \"currencyCode\": \"ZAR\",\n" +
            "      \"displayName\": \"South African Rand\",\n" +
            "      \"numericCode\": 710,\n" +
            "      \"symbol\": \"ZAR\",\n" +
            "      \"defaultFractionDigits\": 2\n" +
            "    },\n" +
            "    {\n" +
            "      \"currencyCode\": \"THB\",\n" +
            "      \"displayName\": \"Thai Baht\",\n" +
            "      \"numericCode\": 764,\n" +
            "      \"symbol\": \"THB\",\n" +
            "      \"defaultFractionDigits\": 2\n" +
            "    },\n" +
            "    {\n" +
            "      \"currencyCode\": \"EUR\",\n" +
            "      \"displayName\": \"Euro\",\n" +
            "      \"numericCode\": 978,\n" +
            "      \"symbol\": \"EUR\",\n" +
            "      \"defaultFractionDigits\": 2\n" +
            "    },\n" +
            "    {\n" +
            "      \"currencyCode\": \"EUR\",\n" +
            "      \"displayName\": \"Euro\",\n" +
            "      \"numericCode\": 978,\n" +
            "      \"symbol\": \"EUR\",\n" +
            "      \"defaultFractionDigits\": 2\n" +
            "    },\n" +
            "    {\n" +
            "      \"currencyCode\": \"NOK\",\n" +
            "      \"displayName\": \"Norwegian Krone\",\n" +
            "      \"numericCode\": 578,\n" +
            "      \"symbol\": \"NOK\",\n" +
            "      \"defaultFractionDigits\": 2\n" +
            "    },\n" +
            "    {\n" +
            "      \"currencyCode\": \"AUD\",\n" +
            "      \"displayName\": \"Australian Dollar\",\n" +
            "      \"numericCode\": 36,\n" +
            "      \"symbol\": \"AUD\",\n" +
            "      \"defaultFractionDigits\": 2\n" +
            "    },\n" +
            "    {\n" +
            "      \"currencyCode\": \"EUR\",\n" +
            "      \"displayName\": \"Euro\",\n" +
            "      \"numericCode\": 978,\n" +
            "      \"symbol\": \"EUR\",\n" +
            "      \"defaultFractionDigits\": 2\n" +
            "    },\n" +
            "    {\n" +
            "      \"currencyCode\": \"CAD\",\n" +
            "      \"displayName\": \"Canadian Dollar\",\n" +
            "      \"numericCode\": 124,\n" +
            "      \"symbol\": \"CAD\",\n" +
            "      \"defaultFractionDigits\": 2\n" +
            "    },\n" +
            "    {\n" +
            "      \"currencyCode\": \"EUR\",\n" +
            "      \"displayName\": \"Euro\",\n" +
            "      \"numericCode\": 978,\n" +
            "      \"symbol\": \"EUR\",\n" +
            "      \"defaultFractionDigits\": 2\n" +
            "    },\n" +
            "    {\n" +
            "      \"currencyCode\": \"EUR\",\n" +
            "      \"displayName\": \"Euro\",\n" +
            "      \"numericCode\": 978,\n" +
            "      \"symbol\": \"EUR\",\n" +
            "      \"defaultFractionDigits\": 2\n" +
            "    },\n" +
            "    {\n" +
            "      \"currencyCode\": \"CRC\",\n" +
            "      \"displayName\": \"Costa Rican ColÃ³n\",\n" +
            "      \"numericCode\": 188,\n" +
            "      \"symbol\": \"CRC\",\n" +
            "      \"defaultFractionDigits\": 2\n" +
            "    },\n" +
            "    {\n" +
            "      \"currencyCode\": \"KWD\",\n" +
            "      \"displayName\": \"Kuwaiti Dinar\",\n" +
            "      \"numericCode\": 414,\n" +
            "      \"symbol\": \"KWD\",\n" +
            "      \"defaultFractionDigits\": 3\n" +
            "    },\n" +
            "    {\n" +
            "      \"currencyCode\": \"LYD\",\n" +
            "      \"displayName\": \"Libyan Dinar\",\n" +
            "      \"numericCode\": 434,\n" +
            "      \"symbol\": \"LYD\",\n" +
            "      \"defaultFractionDigits\": 3\n" +
            "    },\n" +
            "    {\n" +
            "      \"currencyCode\": \"CHF\",\n" +
            "      \"displayName\": \"Swiss Franc\",\n" +
            "      \"numericCode\": 756,\n" +
            "      \"symbol\": \"CHF\",\n" +
            "      \"defaultFractionDigits\": 2\n" +
            "    },\n" +
            "    {\n" +
            "      \"currencyCode\": \"EUR\",\n" +
            "      \"displayName\": \"Euro\",\n" +
            "      \"numericCode\": 978,\n" +
            "      \"symbol\": \"EUR\",\n" +
            "      \"defaultFractionDigits\": 2\n" +
            "    },\n" +
            "    {\n" +
            "      \"currencyCode\": \"DZD\",\n" +
            "      \"displayName\": \"Algerian Dinar\",\n" +
            "      \"numericCode\": 12,\n" +
            "      \"symbol\": \"DZD\",\n" +
            "      \"defaultFractionDigits\": 2\n" +
            "    },\n" +
            "    {\n" +
            "      \"currencyCode\": \"EUR\",\n" +
            "      \"displayName\": \"Euro\",\n" +
            "      \"numericCode\": 978,\n" +
            "      \"symbol\": \"EUR\",\n" +
            "      \"defaultFractionDigits\": 2\n" +
            "    },\n" +
            "    {\n" +
            "      \"currencyCode\": \"EUR\",\n" +
            "      \"displayName\": \"Euro\",\n" +
            "      \"numericCode\": 978,\n" +
            "      \"symbol\": \"EUR\",\n" +
            "      \"defaultFractionDigits\": 2\n" +
            "    },\n" +
            "    {\n" +
            "      \"currencyCode\": \"EUR\",\n" +
            "      \"displayName\": \"Euro\",\n" +
            "      \"numericCode\": 978,\n" +
            "      \"symbol\": \"EUR\",\n" +
            "      \"defaultFractionDigits\": 2\n" +
            "    },\n" +
            "    {\n" +
            "      \"currencyCode\": \"EUR\",\n" +
            "      \"displayName\": \"Euro\",\n" +
            "      \"numericCode\": 978,\n" +
            "      \"symbol\": \"EUR\",\n" +
            "      \"defaultFractionDigits\": 2\n" +
            "    },\n" +
            "    {\n" +
            "      \"currencyCode\": \"SGD\",\n" +
            "      \"displayName\": \"Singapore Dollar\",\n" +
            "      \"numericCode\": 702,\n" +
            "      \"symbol\": \"SGD\",\n" +
            "      \"defaultFractionDigits\": 2\n" +
            "    },\n" +
            "    {\n" +
            "      \"currencyCode\": \"CAD\",\n" +
            "      \"displayName\": \"Canadian Dollar\",\n" +
            "      \"numericCode\": 124,\n" +
            "      \"symbol\": \"CAD\",\n" +
            "      \"defaultFractionDigits\": 2\n" +
            "    },\n" +
            "    {\n" +
            "      \"currencyCode\": \"EUR\",\n" +
            "      \"displayName\": \"Euro\",\n" +
            "      \"numericCode\": 978,\n" +
            "      \"symbol\": \"EUR\",\n" +
            "      \"defaultFractionDigits\": 2\n" +
            "    },\n" +
            "    {\n" +
            "      \"currencyCode\": \"CNY\",\n" +
            "      \"displayName\": \"Chinese Yuan\",\n" +
            "      \"numericCode\": 156,\n" +
            "      \"symbol\": \"CNY\",\n" +
            "      \"defaultFractionDigits\": 2\n" +
            "    },\n" +
            "    {\n" +
            "      \"currencyCode\": \"JPY\",\n" +
            "      \"displayName\": \"Japanese Yen\",\n" +
            "      \"numericCode\": 392,\n" +
            "      \"symbol\": \"JPY\",\n" +
            "      \"defaultFractionDigits\": 0\n" +
            "    },\n" +
            "    {\n" +
            "      \"currencyCode\": \"EUR\",\n" +
            "      \"displayName\": \"Euro\",\n" +
            "      \"numericCode\": 978,\n" +
            "      \"symbol\": \"EUR\",\n" +
            "      \"defaultFractionDigits\": 2\n" +
            "    },\n" +
            "    {\n" +
            "      \"currencyCode\": \"RSD\",\n" +
            "      \"displayName\": \"Serbian Dinar\",\n" +
            "      \"numericCode\": 941,\n" +
            "      \"symbol\": \"RSD\",\n" +
            "      \"defaultFractionDigits\": 2\n" +
            "    },\n" +
            "    {\n" +
            "      \"currencyCode\": \"INR\",\n" +
            "      \"displayName\": \"Indian Rupee\",\n" +
            "      \"numericCode\": 356,\n" +
            "      \"symbol\": \"INR\",\n" +
            "      \"defaultFractionDigits\": 2\n" +
            "    },\n" +
            "    {\n" +
            "      \"currencyCode\": \"LBP\",\n" +
            "      \"displayName\": \"Lebanese Pound\",\n" +
            "      \"numericCode\": 422,\n" +
            "      \"symbol\": \"LBP\",\n" +
            "      \"defaultFractionDigits\": 2\n" +
            "    },\n" +
            "    {\n" +
            "      \"currencyCode\": \"NIO\",\n" +
            "      \"displayName\": \"Nicaraguan CÃ³rdoba\",\n" +
            "      \"numericCode\": 558,\n" +
            "      \"symbol\": \"NIO\",\n" +
            "      \"defaultFractionDigits\": 2\n" +
            "    },\n" +
            "    {\n" +
            "      \"currencyCode\": \"MKD\",\n" +
            "      \"displayName\": \"Macedonian Denar\",\n" +
            "      \"numericCode\": 807,\n" +
            "      \"symbol\": \"MKD\",\n" +
            "      \"defaultFractionDigits\": 2\n" +
            "    },\n" +
            "    {\n" +
            "      \"currencyCode\": \"BYN\",\n" +
            "      \"displayName\": \"Belarusian Ruble\",\n" +
            "      \"numericCode\": 933,\n" +
            "      \"symbol\": \"BYN\",\n" +
            "      \"defaultFractionDigits\": 2\n" +
            "    },\n" +
            "    {\n" +
            "      \"currencyCode\": \"EUR\",\n" +
            "      \"displayName\": \"Euro\",\n" +
            "      \"numericCode\": 978,\n" +
            "      \"symbol\": \"EUR\",\n" +
            "      \"defaultFractionDigits\": 2\n" +
            "    },\n" +
            "    {\n" +
            "      \"currencyCode\": \"PEN\",\n" +
            "      \"displayName\": \"Peruvian Sol\",\n" +
            "      \"numericCode\": 604,\n" +
            "      \"symbol\": \"PEN\",\n" +
            "      \"defaultFractionDigits\": 2\n" +
            "    },\n" +
            "    {\n" +
            "      \"currencyCode\": \"IDR\",\n" +
            "      \"displayName\": \"Indonesian Rupiah\",\n" +
            "      \"numericCode\": 360,\n" +
            "      \"symbol\": \"IDR\",\n" +
            "      \"defaultFractionDigits\": 2\n" +
            "    },\n" +
            "    {\n" +
            "      \"currencyCode\": \"GBP\",\n" +
            "      \"displayName\": \"British Pound Sterling\",\n" +
            "      \"numericCode\": 826,\n" +
            "      \"symbol\": \"GBP\",\n" +
            "      \"defaultFractionDigits\": 2\n" +
            "    }\n" +
            "  ]\n" +
            "}";
    private static final String PROFILE_JSON = "{\"id\":\"1\",\"name\":\"Progressoft corp.\",\"code\":\"PSF\",\"reference\":\"PSFT\",\"address\":{\"id\":\"1\",\"countryISOCode\":\"OM\",\"city\":\"Muscat\",\"street\":\"street\",\"zipCode\":\"MSS\",\"apartment\":\"apartment\",\"mailBox\":\"mailBox\",\"phoneNumber\":\"1234567\",\"faxNumber\":\"12345678\"},\"corporateAccounts\":[{\"accountAccessibility\":\"OUT\",\"accountType\":\"SAVING\",\"currency\":{\"currencyCode\":\"KWD\",\"defaultFractionDigits\":3,\"numericCode\":414},\"iban\":\"AB89ABCD0000000000009235351490\",\"accountAlias\":\"LG.Inc\",\"accountNumber\":\"0000000000009235351490\"},{\"accountAccessibility\":\"IN\",\"accountType\":\"SAVING\",\"currency\":{\"currencyCode\":\"KWD\",\"defaultFractionDigits\":3,\"numericCode\":414},\"iban\":\"AB62ABCD0000000000009235351491\",\"accountAlias\":\"Hewlett-Packard\",\"accountNumber\":\"0000000000009235351491\"},{\"accountAccessibility\":\"OUT\",\"accountType\":\"SAVING\",\"currency\":{\"currencyCode\":\"KWD\",\"defaultFractionDigits\":3,\"numericCode\":414},\"iban\":\"AB35ABCD0000000000009235351492\",\"accountAlias\":\"Progressoft\",\"accountNumber\":\"0000000000009235351492\"},{\"accountAccessibility\":\"IN_OUT\",\"accountType\":\"SAVING\",\"currency\":{\"currencyCode\":\"KWD\",\"defaultFractionDigits\":3,\"numericCode\":414},\"iban\":\"AB08ABCD0000000000009235351493\",\"accountAlias\":\"Netflix\",\"accountNumber\":\"0000000000009235351493\"},{\"accountAccessibility\":\"OUT\",\"accountType\":\"SAVING\",\"currency\":{\"currencyCode\":\"KWD\",\"defaultFractionDigits\":3,\"numericCode\":414},\"iban\":\"AB78ABCD0000000000009235351494\",\"accountAlias\":\"Amazon\",\"accountNumber\":\"0000000000009235351494\"},{\"accountAccessibility\":\"IN\",\"accountType\":\"SAVING\",\"currency\":{\"currencyCode\":\"KWD\",\"defaultFractionDigits\":3,\"numericCode\":414},\"iban\":\"AB51ABCD0000000000009235351495\",\"accountAlias\":\"Google\",\"accountNumber\":\"0000000000009235351495\"},{\"accountAccessibility\":\"IN\",\"accountType\":\"SAVING\",\"currency\":{\"currencyCode\":\"KWD\",\"defaultFractionDigits\":3,\"numericCode\":414},\"iban\":\"AB24ABCD0000000000009235351496\",\"accountAlias\":\"Versend\",\"accountNumber\":\"0000000000009235351496\"},{\"accountAccessibility\":\"IN_OUT\",\"accountType\":\"SAVING\",\"currency\":{\"currencyCode\":\"KWD\",\"defaultFractionDigits\":3,\"numericCode\":414},\"iban\":\"AB94ABCD0000000000009235351497\",\"accountAlias\":\"Aramex\",\"accountNumber\":\"0000000000009235351497\"}],\"banks\":[{\"name\":\"Bank ABC\",\"swiftCode\":\"ABCDEFGHXXX\",\"shortName\":\"S.A.O.J\",\"branches\":[{\"name\":\"Muscat\",\"address\":{\"id\":\"2\",\"countryISOCode\":\"OM\",\"city\":\"Muscat\",\"street\":\"street\",\"zipCode\":\"MSS\",\"apartment\":\"apartment\",\"mailBox\":\"mailBox\",\"phoneNumber\":\"1235898\",\"faxNumber\":\"36465141\"},\"contactPerson\":{\"name\":\"Hadil-Muscat\",\"mobileNumber\":\"9843358717\",\"email\":\"noman.mail@compay.com\"}},{\"name\":\"HeadQuater\",\"address\":{\"id\":\"1\",\"countryISOCode\":\"OM\",\"city\":\"Muscat\",\"street\":\"street\",\"zipCode\":\"MSS\",\"apartment\":\"apartment\",\"mailBox\":\"mailBox\",\"phoneNumber\":\"1235898\",\"faxNumber\":\"36465141\"},\"contactPerson\":{\"name\":\"Hadil\",\"mobileNumber\":\"9843358716\",\"email\":\"noman@company.com\"}}]}],\"contactPerson\":null}";
    private final HTMLDivElement element = div().css("content-margin").asElement();

    private CorporateProfile corporateProfile;
    private List<Country> countries;
    private List<Beneficiary> beneficiaries;
    private List<Bank> banks;
    private List<CurrencyData> currencies;
    private AddLCImportComponent addLCImportComponent;

    @Override
    public void onSuccessCreate(String bodyAsString) {
        MessageDialog.createMessage("LOC import has been created successfully " + bodyAsString + "")
                .success()
                .open();
    }

    @Override
    public void onErrorCreate(String errorMessage) {
        MessageDialog.createMessage("Error while creating LOC import [ " + errorMessage + " ]")
                .error()
                .open();
    }

    @Override
    public void init() {

        DomGlobal.setTimeout(p0 -> {
            this.corporateProfile = CorporateProfile.MAPPER.read(PROFILE_JSON);
            this.countries = Countries.MAPPER.read(COUNTRIES_JSON).getCountries();
            this.beneficiaries = Arrays.asList(Beneficiary.MAPPER.readArray(BENEFICIARIES_JSON.replace("countryIsoCode", "countryISOCode"), Beneficiary[]::new));
            this.banks = Arrays.asList(Bank.MAPPER.readArray(BANKS_JSON, Bank[]::new));
            this.currencies = Currencies.MAPPER.read(CURRENCIES_JSON).getCurrencies();

            reBuildForm();

        }, 50);
    }

    private void reBuildForm() {
        ElementUtil.clear(element);
        element.appendChild(LinkToSourceCode.create("formsamples", this.getClass()).asElement());
        addLCImportComponent = new AddLCImportComponent(corporateProfile, countries, beneficiaries, banks, currencies);
        addLCImportComponent.setUiHandlers(FormSamplesViewImpl.this);
        element.appendChild(addLCImportComponent.asElement());
    }

    @Override
    public HTMLElement getElement() {
        return element;
    }

    @Override
    public void setUiHandlers(FormSamplesUIHandlers uiHandlers) {

    }

    @Override
    public void onCreate(LetterOfCredit letterOfCredit) {
        MessageDialog.createMessage("Your item created.")
                .success()
                .onClose(() -> {
                    ElementUtil.scrollTop();
                    reBuildForm();
                })
                .open();
    }
}