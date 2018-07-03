package org.dominokit.domino.datatable.client.views.model;

import org.dominokit.domino.ui.datatable.events.SearchEvent;
import org.dominokit.domino.ui.datatable.store.SearchFilter;

import static java.util.Objects.nonNull;

public class ContactSearchFilter implements SearchFilter<Contact> {
    @Override
    public boolean filterRecord(SearchEvent searchEvent, Contact contact) {
        String searchText = searchEvent.getSearchText();
        if (nonNull(searchText) && !searchText.isEmpty()) {
            return contact.getName().toLowerCase().contains(searchText.toLowerCase())
                    || contact.getEmail().toLowerCase().contains(searchText.toLowerCase())
                    || contact.getAbout().toLowerCase().contains(searchText.toLowerCase())
                    || contact.getAddress().toLowerCase().contains(searchText.toLowerCase())
                    || contact.getCompany().toLowerCase().contains(searchText.toLowerCase());
        }
        return true;
    }
}
