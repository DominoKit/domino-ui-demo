package org.dominokit.domino.datatable.client.task;

import org.dominokit.domino.datatable.client.views.model.Contact;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class ContactsProvider {

    public static final ContactsProvider instance =  new ContactsProvider();

    static List<Contact> contacts;

    public static void setContacts(List<Contact> contacts) {
        ContactsProvider.contacts = contacts;
    }

    public List<Contact> contactsList(int count) {
        List<Contact> contacts = new ArrayList<>();

        int randomIndex;
        Random random = new Random(new Date().getTime());
        for (int rootIndex = 0; rootIndex < count; rootIndex++) {
            randomIndex = random.nextInt(contacts.size() - 1);
            Contact root = new Contact(contacts.get(randomIndex));
            root.setDepth(0);
            root.setIndex(rootIndex);
            contacts.add(root);
        }

        return contacts;
    }

    public void addFriends(Contact root, int leavesCount, int depth, int maxDepth) {
        int randomIndex;
        Random random = new Random(new Date().getTime());
        if (depth > 0 && root.getDepth() < maxDepth) {
            for (int leafIndex = 0; leafIndex < leavesCount; leafIndex++) {
                randomIndex = random.nextInt(contacts.size() - 1);
                Contact friend = new Contact(contacts.get(randomIndex));
                int childDepth = root.getDepth() + 1;
                friend.setDepth(childDepth);
                friend.setIndex(leafIndex);
                if(childDepth == maxDepth){
                    friend.setHasChildren(false);
                }
                root.addFriend(friend);
                addFriends(friend, leavesCount, depth - 1, maxDepth);
            }
        }

        root.getFriends().sort((o1, o2) -> Double.compare(o2.getIndex(), o1.getIndex()));
    }

    public List<Contact> subList() {
        return subList(0, 15);
    }

    public List<Contact> subList(int size) {
        return subList( 0, size);
    }

    public List<Contact> subList(int from, int to) {
        return contacts.subList(from, to).stream().map(Contact::new).collect(Collectors.toList());
    }
}
