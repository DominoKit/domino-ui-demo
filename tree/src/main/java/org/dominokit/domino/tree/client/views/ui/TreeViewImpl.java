package org.dominokit.domino.tree.client.views.ui;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.domino.componentcase.client.ui.views.CodeCard;
import org.dominokit.domino.componentcase.client.ui.views.LinkToSourceCode;
import org.dominokit.domino.componentcase.shared.extension.ComponentView;
import org.dominokit.domino.tree.client.presenters.TreePresenter;
import org.dominokit.domino.tree.client.views.Countries;
import org.dominokit.domino.tree.client.views.Country;
import org.dominokit.domino.tree.client.views.TreeView;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.grid.Column;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.header.BlockHeader;
import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.notifications.Notification;
import org.dominokit.domino.ui.tree.Tree;
import org.dominokit.domino.ui.tree.TreeItem;

import java.util.List;

import static org.jboss.gwt.elemento.core.Elements.div;

@UiView(presentable = TreePresenter.class)
public class TreeViewImpl extends ComponentView<HTMLDivElement> implements TreeView {

    public static final String MODULE_NAME = "tree";
    private HTMLDivElement element = div().asElement();

    private static final String COUNTRIES= "{\n" +
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

    @Override
    public void init() {
        element.appendChild(LinkToSourceCode.create(MODULE_NAME, this.getClass()).asElement());
        element.appendChild(BlockHeader.create("Tree").asElement());

        simpleTree();

        nestedTree();

        activeAndExpandIcons();
    }

    private void simpleTree() {
        Tree hardwareTree = Tree.create("HARDWARE")
                .appendChild(TreeItem.create("Computer", Icons.ALL.computer())
                        .addClickListener(evt -> Notification.create("Computer").show()))
                .appendChild(TreeItem.create("Headset", Icons.ALL.headset())
                        .addClickListener(evt -> Notification.create("Headset").show()))
                .appendChild(TreeItem.create("Keyboard", Icons.ALL.keyboard())
                        .addClickListener(evt -> Notification.create("Keyboard").show()))
                .appendChild(TreeItem.create("Mouse", Icons.ALL.mouse())
                        .addClickListener(evt -> Notification.create("Mouse").show()))
                .addSeparator()
                .appendChild(TreeItem.create("Laptop", Icons.ALL.laptop())
                        .addClickListener(evt -> Notification.create("Laptop").show()))
                .appendChild(TreeItem.create("Smart phone", Icons.ALL.smartphone())
                        .addClickListener(evt -> Notification.create("Smart phone").show()))
                .appendChild(TreeItem.create("Tablet", Icons.ALL.tablet())
                        .addClickListener(evt -> Notification.create("Tablet").show()))
                .appendChild(TreeItem.create("Speaker", Icons.ALL.speaker())
                        .addClickListener(evt -> Notification.create("Speaker").show()));

        Tree filesTree = Tree.create("FILES")
                .appendChild(TreeItem.create("Folder", Icons.ALL.folder())
                        .addClickListener(evt -> Notification.create("Folder").show()))
                .appendChild(TreeItem.create("Folder open", Icons.ALL.folder_open())
                        .addClickListener(evt -> Notification.create("Folder open").show()))
                .appendChild(TreeItem.create("Upload", Icons.ALL.file_upload())
                        .addClickListener(evt -> Notification.create("Upload").show()))
                .appendChild(TreeItem.create("Download", Icons.ALL.file_download())
                        .addClickListener(evt -> Notification.create("Download").show()))
                .appendChild(TreeItem.create("New folder", Icons.ALL.create_new_folder())
                        .addClickListener(evt -> Notification.create("New folder").show()))
                .appendChild(TreeItem.create("Shared", Icons.ALL.folder_shared())
                        .addClickListener(evt -> Notification.create("Shared").show()))
                .appendChild(TreeItem.create("Attachments", Icons.ALL.attachment())
                        .addClickListener(evt -> Notification.create("Attachments").show()))
                .appendChild(TreeItem.create("Cloud", Icons.ALL.cloud())
                        .addClickListener(evt -> Notification.create("Cloud").show()));

        element.appendChild(Card.create("SIMPLE MENU")
                .appendChild(Row.create()
                        .addColumn(Column.span6().appendChild(hardwareTree))
                        .addColumn(Column.span6().appendChild(filesTree))
                ).asElement());

        element.appendChild(CodeCard.createCodeCard(MODULE_NAME,"simpleTree").asElement());
    }

    private void nestedTree() {
        Tree hardwareTree = Tree.create("HARDWARE")
                .appendChild(TreeItem.create("Computer", Icons.ALL.desktop_windows())
                        .addClickListener(evt -> Notification.create("Computer").show())

                        .appendChild(TreeItem.create("Headset", Icons.ALL.headset())
                                .addClickListener(evt -> Notification.create("Headset").show()))
                        .appendChild(TreeItem.create("Keyboard", Icons.ALL.keyboard())
                                .addClickListener(evt -> Notification.create("Keyboard").show()))
                        .appendChild(TreeItem.create("Mouse", Icons.ALL.mouse())
                                .addClickListener(evt -> Notification.create("Mouse").show())))

                .appendChild(TreeItem.create("Laptop", Icons.ALL.laptop())
                        .addClickListener(evt -> Notification.create("Laptop").show())

                        .appendChild(TreeItem.create("Chromebook", Icons.ALL.laptop_chromebook())
                                .addClickListener(evt -> Notification.create("Chromebook").show()))
                        .appendChild(TreeItem.create("MacBook", Icons.ALL.laptop_mac())
                                .addClickListener(evt -> Notification.create("MacBook").show())))

                .appendChild(TreeItem.create("Smart phone", Icons.ALL.smartphone())
                        .addClickListener(evt -> Notification.create("Smart phone").show())

                        .appendChild(TreeItem.create("Tablet", Icons.ALL.tablet())
                                .addClickListener(evt -> Notification.create("Tablet").show()))
                        .appendChild(TreeItem.create("Android", Icons.ALL.phone_android())
                                .addClickListener(evt -> Notification.create("Android").show()))
                        .appendChild(TreeItem.create("iPhone", Icons.ALL.phone_iphone())
                                .addClickListener(evt -> Notification.create("iPhone").show())));


        Tree hardwareMenu2 = Tree.create("FILES")
                .setAutoCollapse(false)
                .appendChild(TreeItem.create("Folder", Icons.ALL.folder())
                        .appendChild(TreeItem.create("My files", Icons.ALL.folder_special())
                                .appendChild(TreeItem.create("File 1", Icons.ALL.description())
                                        .addClickListener(evt -> Notification.create("File 1").show()))
                                .appendChild(TreeItem.create("File 2", Icons.ALL.description())
                                        .addClickListener(evt -> Notification.create("File 2").show()))
                                .appendChild(TreeItem.create("File 3", Icons.ALL.description())
                                        .addClickListener(evt -> Notification.create("File 3").show()))
                                .appendChild(TreeItem.create("File 4", Icons.ALL.description())
                                        .addClickListener(evt -> Notification.create("File 4").show()))
                        )
                        .appendChild(TreeItem.create("Upload", Icons.ALL.file_upload()))
                        .appendChild(TreeItem.create("Download", Icons.ALL.file_download()))
                        .appendChild(TreeItem.create("New folder", Icons.ALL.create_new_folder()))
                        .appendChild(TreeItem.create("Shared", Icons.ALL.folder_shared()))
                        .appendChild(TreeItem.create("Attachments", Icons.ALL.attachment()))
                ).appendChild(TreeItem.create("Cloud", Icons.ALL.cloud())
                        .appendChild(TreeItem.create("Upload", Icons.ALL.cloud_upload()))
                        .appendChild(TreeItem.create("Download", Icons.ALL.cloud_download()))
                        .appendChild(TreeItem.create("Offline", Icons.ALL.cloud_off()))
                        .appendChild(TreeItem.create("Queue", Icons.ALL.cloud_queue()))
                );


        element.appendChild(Card.create("SIMPLE NESTED MENU")
                .appendChild(Row.create()
                        .addColumn(Column.span6()
                                .appendChild(BlockHeader.create("Auto collapse"))
                                .appendChild(hardwareTree))
                        .addColumn(Column.span6()
                                .appendChild(BlockHeader.create("Auto collapse OFF"))
                                .appendChild(hardwareMenu2))
                ).asElement());

        element.appendChild(CodeCard.createCodeCard(MODULE_NAME,"nestedTree").asElement());
    }

    private void activeAndExpandIcons() {

        List<Country> countries = Countries.MAPPER.read(COUNTRIES).getCountries();

        Tree citiesTree = Tree.create("CITIES")
                .setAutoCollapse(false)
                .enableFolding()
                .enableSearch()
                .autoExpandFound();

        countries.forEach(country -> {
            TreeItem countryItem=TreeItem.create(country.getName(), Icons.ALL.map());
            citiesTree.appendChild(countryItem);
            country.getCities().forEach(city -> {
                TreeItem cityItem = TreeItem.create(city, Icons.ALL.location_city());
                countryItem.appendChild(cityItem);
            });

        });

        Tree foldersExpand = Tree.create("FILES")
                .setAutoCollapse(false)
                .enableFolding()
                .enableSearch()
                .appendChild(TreeItem.create("Folder 1", Icons.ALL.folder())
                        .setExpandIcon(Icons.ALL.folder_open())
                        .appendChild(TreeItem.create("Folder 1-1", Icons.ALL.folder())
                                .setExpandIcon(Icons.ALL.folder_open())
                                .appendChild(TreeItem.create("File 1", Icons.ALL.insert_drive_file())
                                        .setActiveIcon(Icons.ALL.description()))
                                .appendChild(TreeItem.create("File 2", Icons.ALL.insert_drive_file())
                                        .setActiveIcon(Icons.ALL.description()))
                                .appendChild(TreeItem.create("File 3", Icons.ALL.insert_drive_file())
                                        .setActiveIcon(Icons.ALL.description()))
                                .appendChild(TreeItem.create("File 4", Icons.ALL.insert_drive_file())
                                        .setActiveIcon(Icons.ALL.description()))
                        ).appendChild(TreeItem.create("Folder 1-2", Icons.ALL.folder())
                                .setExpandIcon(Icons.ALL.folder_open())
                                .appendChild(TreeItem.create("File 1", Icons.ALL.insert_drive_file())
                                        .setActiveIcon(Icons.ALL.description()))
                                .appendChild(TreeItem.create("File 2", Icons.ALL.insert_drive_file())
                                        .setActiveIcon(Icons.ALL.description()))
                                .appendChild(TreeItem.create("File 3", Icons.ALL.insert_drive_file())
                                        .setActiveIcon(Icons.ALL.description()))
                                .appendChild(TreeItem.create("File 4", Icons.ALL.insert_drive_file())
                                        .setActiveIcon(Icons.ALL.description()))
                        )
                ).appendChild(TreeItem.create("Folder 2", Icons.ALL.folder())
                        .setExpandIcon(Icons.ALL.folder_open())
                        .appendChild(TreeItem.create("Folder 2-1", Icons.ALL.folder())
                                .setExpandIcon(Icons.ALL.folder_open())
                                .appendChild(TreeItem.create("File 1", Icons.ALL.insert_drive_file())
                                        .setActiveIcon(Icons.ALL.description()))
                                .appendChild(TreeItem.create("File 2", Icons.ALL.insert_drive_file())
                                        .setActiveIcon(Icons.ALL.description()))
                                .appendChild(TreeItem.create("File 3", Icons.ALL.insert_drive_file())
                                        .setActiveIcon(Icons.ALL.description()))
                                .appendChild(TreeItem.create("File 4", Icons.ALL.insert_drive_file())
                                        .setActiveIcon(Icons.ALL.description()))
                        ).appendChild(TreeItem.create("Folder 2-2", Icons.ALL.folder())
                                .setExpandIcon(Icons.ALL.folder_open())
                                .appendChild(TreeItem.create("File 1", Icons.ALL.insert_drive_file())
                                        .setActiveIcon(Icons.ALL.description()))
                                .appendChild(TreeItem.create("File 2", Icons.ALL.insert_drive_file())
                                        .setActiveIcon(Icons.ALL.description()))
                                .appendChild(TreeItem.create("File 3", Icons.ALL.insert_drive_file())
                                        .setActiveIcon(Icons.ALL.description()))
                                .appendChild(TreeItem.create("File 4", Icons.ALL.insert_drive_file())
                                        .setActiveIcon(Icons.ALL.description()))
                        )
                ).appendChild(TreeItem.create("Folder 3", Icons.ALL.folder())
                        .setExpandIcon(Icons.ALL.folder_open())
                        .appendChild(TreeItem.create("Folder 3-1", Icons.ALL.folder())
                                .setExpandIcon(Icons.ALL.folder_open())
                                .appendChild(TreeItem.create("File 1", Icons.ALL.insert_drive_file())
                                        .setActiveIcon(Icons.ALL.description()))
                                .appendChild(TreeItem.create("File 2", Icons.ALL.insert_drive_file())
                                        .setActiveIcon(Icons.ALL.description()))
                                .appendChild(TreeItem.create("File 3", Icons.ALL.insert_drive_file())
                                        .setActiveIcon(Icons.ALL.description()))
                                .appendChild(TreeItem.create("File 4", Icons.ALL.insert_drive_file())
                                        .setActiveIcon(Icons.ALL.description()))
                                .expand()
                        ).appendChild(TreeItem.create("Folder 3-2", Icons.ALL.folder())
                                .setExpandIcon(Icons.ALL.folder_open())
                                .expand()
                                .appendChild(TreeItem.create("File 1", Icons.ALL.insert_drive_file())
                                        .setActiveIcon(Icons.ALL.description()))
                                .appendChild(TreeItem.create("File 2", Icons.ALL.insert_drive_file())
                                        .setActiveIcon(Icons.ALL.description()))
                                .appendChild(TreeItem.create("File 3", Icons.ALL.insert_drive_file())
                                        .setActiveIcon(Icons.ALL.description()))
                                .appendChild(TreeItem.create("File 4", Icons.ALL.insert_drive_file())
                                        .setActiveIcon(Icons.ALL.description()))
                                .expand()
                        ).expand()
                );

        element.appendChild(Card.create("ACTIVE/EXPAND ICONS, SEARCH & FOLDING")
                .appendChild(Row.create()
                        .addColumn(Column.span6()
                                .appendChild(BlockHeader.create("Active icon"))
                                .appendChild(citiesTree))
                        .addColumn(Column.span6()
                                        .appendChild(BlockHeader.create("Expand icon"))
                                .appendChild(foldersExpand))
                        ).asElement());

        element.appendChild(CodeCard.createCodeCard(MODULE_NAME,"featuredTree").asElement());
    }

    @Override
    public HTMLDivElement getElement() {
        return element;
    }
}