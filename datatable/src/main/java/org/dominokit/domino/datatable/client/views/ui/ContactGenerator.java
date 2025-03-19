package org.dominokit.domino.datatable.client.views.ui;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// Generator class for Contact objects
public class ContactGenerator {

    // Generates a single Contact instance with sample data
    private static DemoContact generateContact(int index) {
        DemoContact demoContact = new DemoContact();
        demoContact.setId(index);
        demoContact.setFirstName("FirstName" + index);
        demoContact.setLastName("LastName" + index);
        demoContact.setEmail("user" + index + "@example.com");
        demoContact.setPhone("555-000" + index);
        demoContact.setAddress("123 Example St, Apt " + index);
        demoContact.setCity("City" + index);
        demoContact.setState("State" + index);
        demoContact.setZipCode("Zip" + index);
        demoContact.setCountry("Country" + index);
        demoContact.setBirthDate(new Date());
        demoContact.setCompany("Company" + index);
        demoContact.setJobTitle("JobTitle" + index);
        demoContact.setDepartment("Department" + index);
        demoContact.setWebsite("www.example" + index + ".com");
        demoContact.setTwitterHandle("@twitter" + index);
        demoContact.setFacebookId("facebook" + index);
        demoContact.setLinkedinProfile("linkedin" + index);
        demoContact.setNotes("Notes for contact " + index);
        demoContact.setCreatedAt(System.currentTimeMillis());
        demoContact.setUpdatedAt(System.currentTimeMillis());
        demoContact.setActive(index % 2 == 0);
        demoContact.setRating((index % 5) + 1.0); // Rating between 1.0 and 5.0
        demoContact.setCustomField1("Custom1_" + index);
        demoContact.setCustomField2(index * 10);
        return demoContact;
    }

    /**
     * Generates a list of Contact objects.
     *
     * @param count the number of contacts to generate
     * @return a list of dynamically generated Contact objects
     */
    public static List<DemoContact> generateContacts(int count) {
        List<DemoContact> demoContacts = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            demoContacts.add(generateContact(i));
        }
        return demoContacts;
    }
}
