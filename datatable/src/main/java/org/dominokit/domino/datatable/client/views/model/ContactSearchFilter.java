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

        boolean foundBySearch = searchFilters.isEmpty() || foundBySearch(contact, searchFilters.get(0));
        boolean foundByHeaderFilter = headerFilters.stream().allMatch(filter -> findByHeaderFilter(contact, filter));

        return foundBySearch && foundByHeaderFilter;
    }

    private boolean findByHeaderFilter(Contact contact, Filter filter) {
        if (nonNull(filter.getValues().get(0)) && !filter.getValues().get(0).isEmpty()) {
            switch (filter.getFieldName()) {
                case "firstName":
                    return filterByName(contact, filter.getValues().get(0));
                case "email":
                    return filterByEmail(contact, filter.getValues().get(0));
                case "status":
                    return filterByStatus(contact, filter.getValues().get(0));
                case "gender":
                    return filterByGender(contact, filter.getValues().get(0));
                case "eyeColor":
                    return filterByEyeColor(contact, filter.getValues().get(0));
                case "balance":
                    return filterByEyeBalance(contact, filter.getValues().get(0));
                case "phone":
                    return filterByEyePhone(contact, filter.getValues().get(0));
                default:
                    return false;
            }
        }
        return false;
    }

    private boolean filterByEyePhone(Contact contact, String searchContext) {
        return contact.getPhone().contains(searchContext);
    }

    private boolean filterByEyeBalance(Contact contact, String searchText) {
        return contact.getBalance() == Double.parseDouble(searchText);
    }

    private boolean filterByEyeColor(Contact contact, String searchText) {
        return contact.getEyeColor().equals(EyeColor.valueOf(searchText));
    }

    private boolean filterByGender(Contact contact, String searchText) {
        return contact.getGender().equals(Gender.valueOf(searchText));
    }

    private boolean filterByStatus(Contact contact, String searchValue) {
        return contact.isActive() == Boolean.parseBoolean(searchValue);
    }

    private boolean foundBySearch(Contact contact, Filter searchFilter) {
        if (nonNull(searchFilter.getValues().get(0)) && !searchFilter.getValues().get(0).isEmpty()) {
            return filterByAll(contact, searchFilter.getValues().get(0));
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
