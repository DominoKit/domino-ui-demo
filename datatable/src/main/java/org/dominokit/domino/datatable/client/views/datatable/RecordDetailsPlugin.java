package org.dominokit.domino.datatable.client.views.datatable;

import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import elemental2.dom.HTMLTableCellElement;
import elemental2.dom.HTMLTableRowElement;
import org.dominokit.domino.ui.button.IconButton;
import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.loaders.Loader;
import org.dominokit.domino.ui.loaders.LoaderEffect;
import org.dominokit.domino.ui.style.Style;
import org.dominokit.domino.ui.utils.ElementUtil;

import static java.util.Objects.nonNull;
import static org.jboss.gwt.elemento.core.Elements.*;

public class RecordDetailsPlugin<T> implements DataTablePlugin<T> {

    private HTMLDivElement element=div().asElement();
    private HTMLTableCellElement td = td().css("details-td").add(element).asElement();
    private HTMLTableRowElement tr = tr().add(td).asElement();
    private IconButton expandedButton;

    private final CellElement<T> cellElement;

    public RecordDetailsPlugin(CellElement<T> cellElement) {
        this.cellElement = cellElement;
    }

    @Override
    public void onBeforeAddHeaders(DataTable<T> dataTable) {
        dataTable.getTableConfig().insertColumnFirst(ColumnConfig.<T>create("data-table-details-cm")
        .setCellElement(row -> {
            IconButton expandButton = IconButton.create(Icons.ALL.fullscreen());
            expandButton.linkify();
            HTMLElement htmlElement = expandButton.asElement();
            Style.of(htmlElement)
                    .setProperty("padding", "0px")
            .setHeight("26px");

            expandButton.addClickListener(evt -> {
                if(nonNull(expandedButton)){
                    expandedButton.setIcon(Icons.ALL.fullscreen());
                }

                if(expandButton.equals(expandedButton)){
                    tr.remove();
                    ElementUtil.clear(element);
                    expandedButton=null;
                }else{
                    tr.remove();
                    ElementUtil.clear(element);
                    expandedButton=expandButton;

                    expandButton.setIcon(Icons.ALL.fullscreen_exit());

                    ElementUtil.builderFor(td).attr("colspan", dataTable.getTableConfig().getColumns().size() + "");
                    element.appendChild(cellElement.asElement(row));
                    dataTable.bodyElement().insertBefore(tr, row.asElement().nextSibling);

                }

            });
            return htmlElement;
        })
        .setHeaderElement(columnTitle -> {
            HTMLElement htmlElement = IconButton.create(Icons.ALL.fullscreen()).linkify().disable().asElement();
            Style.of(htmlElement)
                    .setProperty("padding", "0px")
                    .setHeight("26px");

            return htmlElement;
        })
                .asHeader()
        .textAlign("center"));
    }

    public HTMLDivElement getElement() {
        return element;
    }

    public HTMLTableCellElement getTd() {
        return td;
    }

    public HTMLTableRowElement getTr() {
        return tr;
    }
}
