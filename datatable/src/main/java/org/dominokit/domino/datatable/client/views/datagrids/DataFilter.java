package org.dominokit.domino.datatable.client.views.datagrids;

public interface DataFilter<T> {
    boolean onSearch(T record, String token, boolean caseSensitive);
}
