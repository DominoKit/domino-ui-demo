package org.dominokit.domino.datatable.client.views.model;

import org.dominokit.domino.ui.datatable.events.SearchEvent;
import org.dominokit.domino.ui.datatable.model.Category;
import org.dominokit.domino.ui.datatable.model.Filter;
import org.dominokit.domino.ui.datatable.store.SearchFilter;

import java.util.List;

import static java.util.Objects.nonNull;

public class ContactSearchFilter implements SearchFilter<Contact> {
    @Override
    public boolean filterRecord(SearchEvent searchEvent, Contact contact) {
        List<Filter> searchFilters = searchEvent.getByCategory(Category.SEARCH);
        List<Filter> headerFilters = searchEvent.getByCategory(Category.HEADER_FILTER);

        Filter searchFilter = searchFilters.get(0);

        boolean foundBySearch = foundBySearch(contact, searchFilter);
        boolean foundByHeaderFilter = headerFilters.stream().allMatch(filter -> findByHeaderFilter(contact, filter));

        return foundBySearch && foundByHeaderFilter;
    }

    private boolean findByHeaderFilter(Contact contact, Filter filter) {
        if (nonNull(filter.getValues().get(0)) && !filter.getValues().get(0).isEmpty()) {
            switch (filter.getFieldName()) {
                case "name":
                    return filterByName(contact, filter.getValues().get(0));
                case "email":
                    return filterByEmail(contact, filter.getValues().get(0));
                default:
                    return false;
            }
        }
        return false;
    }

    private boolean foundBySearch(Contact contact, Filter searchFilter) {
        if (nonNull(searchFilter.getValues().get(0)) && !searchFilter.getValues().get(0).isEmpty()) {
            switch (searchFilter.getFieldName()) {
                case "name":
                    return filterByName(contact, searchFilter.getValues().get(0));
                case "email":
                    return filterByEmail(contact, searchFilter.getValues().get(0));
                default:
                    return filterByAll(contact, searchFilter.getValues().get(0));
            }
        }
        return true;
    }

    private boolean filterByAll(Contact contact, String searchText) {
        return filterByName(contact, searchText)
                || filterByEmail(contact, searchText);
    }

    private boolean filterByEmail(Contact contact, String searchText) {
        return contact.getEmail().toLowerCase().contains(searchText.toLowerCase());
    }

    private boolean filterByName(Contact contact, String searchText) {
        return contact.getName().toLowerCase().contains(searchText.toLowerCase());
    }
}
