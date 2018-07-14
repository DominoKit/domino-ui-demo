package org.dominokit.domino.datatable.client.views.model;

import org.dominokit.domino.ui.datatable.events.SearchEvent;
import org.dominokit.domino.ui.datatable.store.SearchFilter;

import static java.util.Objects.nonNull;

public class ContactSearchFilter implements SearchFilter<Contact> {
    @Override
    public boolean filterRecord(SearchEvent searchEvent, Contact contact) {
        String searchText = searchEvent.getSearchText();
        String searchField=searchEvent.getSearchField();
        if (nonNull(searchText) && !searchText.isEmpty()) {
            switch (searchField){
                case "name":
                    return filterByName(contact, searchText);
                case "email":
                    return filterByEmail(contact, searchText);
                default:
                    return filterByAll(contact, searchText);
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
