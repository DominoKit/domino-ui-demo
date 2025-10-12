package org.dominokit.domino.datatable.client.views.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;
import com.google.gwt.user.client.Random;
import elemental2.core.Global;
import elemental2.dom.HTMLDivElement;
import elemental2.dom.Node;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;
import org.dominokit.domino.SampleClass;
import org.dominokit.domino.SampleMethod;
import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.domino.componentcase.client.ui.views.BaseDemoView;
import org.dominokit.domino.componentcase.client.ui.views.CodeCard;
import org.dominokit.domino.componentcase.client.ui.views.LinkToSourceCode;
import org.dominokit.domino.datatable.client.presenters.LiveGridDatatableProxy;
import org.dominokit.domino.datatable.client.views.DatatableView;
import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.datatable.CellRenderer;
import org.dominokit.domino.ui.datatable.ColumnConfig;
import org.dominokit.domino.ui.datatable.DataTable;
import org.dominokit.domino.ui.datatable.RowCell;
import org.dominokit.domino.ui.datatable.TableConfig;
import org.dominokit.domino.ui.datatable.model.Category;
import org.dominokit.domino.ui.datatable.model.Filter;
import org.dominokit.domino.ui.datatable.plugins.column.*;
import org.dominokit.domino.ui.datatable.plugins.filter.header.TextHeaderFilter;
import org.dominokit.domino.ui.datatable.plugins.selection.SelectionPlugin;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.forms.IntegerBox;
import org.dominokit.domino.ui.grid.flex.FlexDirection;
import org.dominokit.domino.ui.grid.flex.FlexLayout;
import org.dominokit.domino.ui.typography.BlockHeader;
import org.dominokit.domino.ui.utils.FillerElement;
import org.dominokit.domino.ui.utils.PostfixAddOn;
import org.dominokit.pro.domino.ui.datatable.plugins.livegrid.LiveViewPlugin;
import org.dominokit.pro.domino.ui.datatable.store.LocalListLiveViewDataStore;

import java.util.ArrayList;
import java.util.List;

import static org.dominokit.domino.ui.utils.Domino.*;

@UiView(presentable = LiveGridDatatableProxy.class)
@SampleClass(includeClassName = true)
public class LiveGridDataTableViewImpl extends BaseDemoView<HTMLDivElement> implements DatatableView {

    private final Resources resources = GWT.create(Resources.class);
    private DivElement element;

    @Override
    protected HTMLDivElement init() {
        element = div();

        element.appendChild(LinkToSourceCode.createLink("datatable", this.getClass()));
        element.appendChild(BlockHeader.create("DATA TABLES", "For detailed demo code please visit: ")
                .appendChild(a()
                        .setAttribute("href", "https://github.com/DominoKit/domino-ui-demo/tree/master/datatable")
                        .setAttribute("target", "_blank")
                        .textContent("Data table demo source code"))
        );


        liveGrid();
        element.appendChild(CodeCard.createLazyCodeCard(LiveGridDataTableViewImpl_CodeResource.INSTANCE.liveGrid()));

        return element.element();
    }

    @SampleMethod
    private void liveGrid() {

        TableConfig<Car> tableConfig = new TableConfig<Car>()
                .setFixed(true)
                .addColumn(ColumnConfig.<Car>create("index", "ID")
                        .setRenderer(cell -> cell.appendChild(text("" + cell.getRecord().getId()))
                        )
                        .setWidth("64px")
                )
                .addColumn(ColumnConfig.<Car>create("make", "Make")
                        .setWidth("200px")
                        .setRenderer(cell -> cell.appendChild(text(cell.getTableRow().getRecord().getMake()))
                        )
                        .applyMeta(ColumnFilterMeta.<Car>of(TextHeaderFilter.create()))
                )
                .addColumn(ColumnConfig.<Car>create("model", "Model")
                        .setRenderer(cell -> cell.appendChild(text(cell.getTableRow().getRecord().getModel())))
                        .setWidth("400px")
                )
                .addColumn(ColumnConfig.<Car>create("price", "Price")
                        .setRenderer(this::priceRenderer)
                        .setWidth("200px")
                )
                .addColumn(ColumnConfig.<Car>create("color", "Color")
                        .setRenderer(cell -> cell.appendChild(text(cell.getRecord().getColor().getLabel())))
                        .setWidth("200px")
                )
                .addPlugin(new SelectionPlugin<>())
                .addPlugin(new LiveViewPlugin<>())
                .addPlugin(new ResizeColumnsPlugin<Car>()
                        .configure(config -> config.setClipContent(true))
                )
                .addPlugin(new PinColumnsPlugin<Car>()
                        .setConfig(PinColumnsConfig.of(false, true))
                )
                .addPlugin(new ColumnHeaderFilterPlugin<>());
        ;

        LocalListLiveViewDataStore<Car> store = new LocalListLiveViewDataStore<>();

        store.setSearchFilter((event, record) -> {
            List<Filter> filters = event.getByCategory(Category.HEADER_FILTER);
            if (filters.size() == 1) {
                // we only support a Make search for now
                Filter filter = filters.get(0);
                if (filter.getValues().size() == 1) {
                    String s = filter.getValues().get(0);
                    return record.getMake().toLowerCase().contains(s.toLowerCase());
                }
            }
            return true;
        });
        DataTable<Car> dataTable = new DataTable<>(tableConfig, store)
                .setCondensed(true)
                .setBordered(true);

        //int initialValue = 1_000_000;
        int initialValue = 5_000;

        List<Car> backingData = new ArrayList<>(generateData(initialValue));
        IntegerBox countBox = IntegerBox.create("Row Count")
                .setMarginBottom("0")
                .withValue(initialValue);
        countBox.addChangeListener((oldValue, newValue) -> {
            if (countBox.validate().isValid()) {
                backingData.clear();
                backingData.addAll(generateData(countBox.getValue()));
            }
        });

        element.appendChild(Card.create("Live Grid")
                .appendChild(div()
                        .addCss(dui_flex, dui_gap_4, dui_p_y_4, dui_items_end)
                        .appendChild(countBox
                                .addCss(dui_w_96)
                                .appendChild(PostfixAddOn.of(Button.create("Load Data")
                                        .addCss(dui_primary)
                                        .addClickListener(evt -> {
                                            if (countBox.validate().isValid()) {
                                                store.setData(backingData);
                                            }
                                        }))
                                )
                        )
                        .appendChild(FillerElement.create().addCss(dui_grow_1))
                )
                .appendChild(dataTable)
        );
    }

    private void priceRenderer(RowCell<Car> cell) {
        cell.appendChild(text(
                NumberFormat.getFormat("$##,##0.00")
                        .format(cell.getRecord().getPrice())));
    }

    private List<Car> generateData(int records) {
        Data data = Js.cast(Global.JSON.parse(resources.makeModelData().getText()));
        MakeModel[] makeModels = data.getData();
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < records; i++) {
            MakeModel makeModel = makeModels[Random.nextInt(makeModels.length)];
            double price = Random.nextDouble() * 50_000;
            CarColor color = CarColor.values()[Random.nextInt(CarColor.values().length)];
            cars.add(new Car(i + 1, makeModel.getMake(), makeModel.getModel(), price, color));
        }
        return cars;
    }


    private enum CarColor {
        RED,
        BLUE,
        YELLOW;

        String getLabel() {
            return name().charAt(0) + name().substring(1).toLowerCase();
        }
    }

    interface Resources extends ClientBundle {
        @Source("make_model.json")
        TextResource makeModelData();
    }

    @JsType(isNative = true)
    interface MakeModel {
        @JsProperty
        String getMake();

        @JsProperty
        String getModel();

        @JsProperty
        int getYear();
    }

    @JsType(isNative = true)
    interface Data {
        @JsProperty
        MakeModel[] getData();
    }

    private static final class Car {
        private int id;
        private String make;
        private String model;
        private double price;
        private CarColor color;

        public Car() {
        }

        public Car(String make, String model, double price, CarColor color) {
            this.make = make;
            this.model = model;
            this.price = price;
            this.color = color;
        }

        public Car(int id, String make, String model, double price, CarColor color) {
            this.id = id;
            this.make = make;
            this.model = model;
            this.price = price;
            this.color = color;
        }

        public CarColor getColor() {
            return color;
        }

        public void setColor(CarColor color) {
            this.color = color;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getMake() {
            return make;
        }

        public void setMake(String make) {
            this.make = make;
        }

        public String getModel() {
            return model;
        }

        public void setModel(String model) {
            this.model = model;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }
    }

}
