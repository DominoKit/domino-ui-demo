package org.dominokit.domino.datatable.client.views.datatable;

import elemental2.dom.HTMLTableCellElement;
import elemental2.dom.Text;

public class ColumnConfig<T> {

    private final String name;
    private String title;
    private HTMLTableCellElement headElement;
    private boolean header=false;
    private String minWidth;
    private String maxWidth;
    private String textAlign;
    private CellElement<T> cellElement= row -> new Text("");
    private HeaderElement headerElement= columnTitle -> new Text(columnTitle);


    public static <T> ColumnConfig<T> create(String name){
        return new ColumnConfig<>(name);
    }

    public static <T> ColumnConfig<T> create(String name, String title){
        return new ColumnConfig<>(name, title);
    }

    public ColumnConfig(String name, String title) {
        this.name = name;
        this.title = title;
    }

    public ColumnConfig(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public String getName() {
        return name;
    }

    public ColumnConfig<T> asHeader(){
        this.header=true;
        return this;
    }

    public ColumnConfig<T> minWidth(String minWidth){
        this.minWidth=minWidth;
        return this;
    }

    public ColumnConfig<T> maxWidth(String maxWidth){
        this.maxWidth=maxWidth;
        return this;
    }

    public ColumnConfig<T> textAlign(String textAlign){
        this.textAlign=textAlign;
        return this;
    }

    public HeaderElement getHeaderElement() {
        return headerElement;
    }

    public ColumnConfig<T> setHeaderElement(HeaderElement headerElement) {
        this.headerElement = headerElement;
        return this;
    }

    public boolean isHeader() {
        return header;
    }

    public String getMinWidth() {
        return minWidth;
    }

    public String getMaxWidth() {
        return maxWidth;
    }

    public String getTextAlign() {
        return textAlign;
    }

    public ColumnConfig<T> setTitle(String title) {
        this.title = title;
        return this;
    }

    public HTMLTableCellElement getHeadElement() {
        return headElement;
    }

    protected void setHeadElement(HTMLTableCellElement headElement) {
        this.headElement = headElement;
    }

    public CellElement<T> getCellElement() {
        return cellElement;
    }

    public ColumnConfig<T> setCellElement(CellElement<T> cellElement) {
        this.cellElement = cellElement;
        return this;
    }

}
