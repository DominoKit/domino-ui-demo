package org.dominokit.domino.uidemoserver.shared.model;

import org.dominokit.jacksonapt.annotation.JSONMapper;

import java.util.List;

@JSONMapper
public class ContactList {

    private List<Contact> contacts;

    public ContactList() {
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }
}
