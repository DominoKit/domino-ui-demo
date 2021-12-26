package org.dominokit.domino.dropdown.client.views.ui;

import elemental2.dom.Event;
import elemental2.dom.EventListener;
import elemental2.dom.HTMLDivElement;
import jsinterop.base.Js;
import org.dominokit.domino.ui.forms.TextBox;
import org.dominokit.domino.ui.icons.Icon;
import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.DominoElement;
import org.dominokit.domino.ui.utils.ElementUtil;
import org.gwtproject.timer.client.Timer;
import org.jboss.elemento.EventType;

import java.util.HashSet;
import java.util.Set;

import static java.util.Objects.nonNull;

/**
 * A predefined action to add a search box the data table
 */
public class SearchBox extends BaseDominoElement<HTMLDivElement, SearchBox> {

    private String searchToolTip = "Search";
    private String clearSearchToolTip = "Clear search";

    private int autoSearchDelay = 200;
    private DominoElement<HTMLDivElement> root = DominoElement.div().css("search-box");
    private final TextBox textBox;
    private boolean autoSearch = true;
    private Timer autoSearchTimer;
    private EventListener autoSearchEventListener;
    private final Icon searchIcon;
    private final Icon clearIcon;

    private Set<SearchListener> searchListeners = new HashSet<>();

    public static SearchBox create(){
        return new SearchBox();
    }

    /**
     * creates a new instance
     */
    public SearchBox() {
        init(this);
        searchIcon =
                Icons.ALL
                        .search()
                        .addClickListener(
                                evt -> {
                                    autoSearchTimer.cancel();
                                    doSearch();
                                })
                        .setTooltip(searchToolTip)
                        .style()
                        .setCursor("pointer")
                        .get();

        clearIcon =
                Icons.ALL.clear().setTooltip(clearSearchToolTip).style().setCursor("pointer").get();

        textBox =
                TextBox.create()
                        .floating()
                        .setPlaceholder(searchToolTip)
                        .addLeftAddOn(searchIcon)
                        .addRightAddOn(clearIcon)
                        .setMarginBottom("0px");

        clearIcon.addClickListener(
                evt -> clearSearch());

        root.appendChild(textBox.element());

        autoSearchTimer =
                new Timer() {
                    @Override
                    public void run() {
                        doSearch();
                    }
                };

        autoSearchEventListener =
                evt -> {
                    autoSearchTimer.cancel();
                    autoSearchTimer.schedule(autoSearchDelay);
                };

        setAutoSearch(true);
        root.addClickListener(Event::stopPropagation);
    }

    public void clearSearch() {
        textBox.clear();
        autoSearchTimer.cancel();
        doSearch();
    }

    /**
     * @return boolean, true if the auto search is enabled
     */
    public boolean isAutoSearch() {
        return autoSearch;
    }

    /**
     * Enable/Disable auto search when enabled the search will triggered while the user is typing
     * with a delay otherwise the search will only be triggered when the user click on search or
     * press Enter
     *
     * @param autoSearch boolean
     * @return same action instance
     */
    public SearchBox setAutoSearch(boolean autoSearch) {
        this.autoSearch = autoSearch;

        if (autoSearch) {
            textBox.addEventListener("input", autoSearchEventListener);
        } else {
            textBox.removeEventListener("input", autoSearchEventListener);
            autoSearchTimer.cancel();
        }

        textBox.addEventListener(
                EventType.keypress.getName(),
                evt -> {
                    if (ElementUtil.isEnterKey(Js.uncheckedCast(evt))) {
                        doSearch();
                    }
                });

        return this;
    }

    /**
     * @return int search delay in milliseconds
     */
    public int getAutoSearchDelay() {
        return autoSearchDelay;
    }

    /**
     * @param autoSearchDelayInMillies int auto search delay in milliseconds
     */
    public void setAutoSearchDelay(int autoSearchDelayInMillies) {
        this.autoSearchDelay = autoSearchDelayInMillies;
    }

    private void doSearch() {
        searchListeners.forEach(searchListener -> searchListener.onSearch(textBox.getValue()));
    }

    /**
     * Set the search icon tooltip
     *
     * @param searchToolTip String
     * @return same action instance
     */
    public SearchBox setSearchToolTip(String searchToolTip) {
        this.searchToolTip = searchToolTip;
        searchIcon.setTooltip(searchToolTip);
        textBox.setPlaceholder(searchToolTip);
        return this;
    }

    /**
     * Set the clear search icon tooltip
     *
     * @param clearSearchToolTip String
     * @return same action instance
     */
    public SearchBox setClearSearchToolTip(String clearSearchToolTip) {
        this.clearSearchToolTip = clearSearchToolTip;
        clearIcon.setTooltip(clearSearchToolTip);
        return this;
    }

    public SearchBox addSearchListener(SearchListener searchListener) {
        if (nonNull(searchListener)) {
            this.searchListeners.add(searchListener);
        }
        return this;
    }

    public SearchBox removeSearchListener(SearchListener searchListener) {
        if (nonNull(searchListener)) {
            this.searchListeners.remove(searchListener);
        }
        return this;
    }

    public SearchBox clearSearchListeners() {
        this.searchListeners.clear();
        return this;
    }

    public String getSearchToolTip() {
        return searchToolTip;
    }

    public String getClearSearchToolTip() {
        return clearSearchToolTip;
    }

    public TextBox getTextBox() {
        return textBox;
    }

    public Icon getSearchIcon() {
        return searchIcon;
    }

    public Icon getClearIcon() {
        return clearIcon;
    }

    public Set<SearchListener> getSearchListeners() {
        return searchListeners;
    }

    @Override
    public HTMLDivElement element() {
        return root.element();
    }

    @FunctionalInterface
    public interface SearchListener {
        void onSearch(String token);
    }
}