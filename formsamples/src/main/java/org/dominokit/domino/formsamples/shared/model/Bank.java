
package org.dominokit.domino.formsamples.shared.model;

import org.dominokit.jackson.annotation.JSONMapper;

import java.util.List;

@JSONMapper
public class Bank {

    public static final Bank_MapperImpl MAPPER = new Bank_MapperImpl();

    private Address address;
    private ContactPerson contactPerson;
    private String name;
    private String shortName;
    private String swiftCode;
    private List<Branch> branches;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public ContactPerson getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(ContactPerson contactPerson) {
        this.contactPerson = contactPerson;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getSwiftCode() {
        return swiftCode;
    }

    public void setSwiftCode(String swiftCode) {
        this.swiftCode = swiftCode;
    }

    public List<Branch> getBranches() {
        return branches;
    }

    public void setBranches(List<Branch> branches) {
        this.branches = branches;
    }
}
