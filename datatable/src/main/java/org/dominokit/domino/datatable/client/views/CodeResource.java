package org.dominokit.domino.datatable.client.views;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ExternalTextResource;

public interface CodeResource extends ClientBundle{

    CodeResource INSTANCE= GWT.create(CodeResource.class);

    @Source("basicTable.txt")
    ExternalTextResource basicTable();

    @Source("fixedBasicTable.txt")
    ExternalTextResource fixedBasicTable();

    @Source("selectionPlugin.txt")
    ExternalTextResource selectionPlugin();

    @Source("markerPlugin.txt")
    ExternalTextResource markerPlugin();

    @Source("recordDetailsPlugin.txt")
    ExternalTextResource recordDetailsPlugin();

    @Source("headerBarPlugin.txt")
    ExternalTextResource headerBarPlugin();

    @Source("sortAndSearch.txt")
    ExternalTextResource sortAndSearch();

    @Source("simplePagination.txt")
    ExternalTextResource simplePagination();

    @Source("scrollingPagination.txt")
    ExternalTextResource scrollingPagination();

    @Source("advancedPagination.txt")
    ExternalTextResource advancedPagination();

    @Source("scrollLoading.txt")
    ExternalTextResource scrollLoading();

    @Source("topPanelPlugin.txt")
    ExternalTextResource topPanelPlugin();

    @Source("groupingTable.txt")
    ExternalTextResource groupingTable();

    @Source("allInOne.txt")
    ExternalTextResource allInOne();

    @Source("generated.json")
    ExternalTextResource generatedJson();
}
