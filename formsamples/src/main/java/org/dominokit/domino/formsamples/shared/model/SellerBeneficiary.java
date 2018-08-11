package org.dominokit.domino.formsamples.shared.model;

public class SellerBeneficiary {
    private String reference;
    private Address address;
    private String name;
    private ContactPerson contactPerson;
    private Account account;

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getReference() {
        return reference;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setContactPerson(ContactPerson contactPerson) {
        this.contactPerson = contactPerson;
    }

    public ContactPerson getContactPerson() {
        return contactPerson;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Account getAccount() {
        return account;
    }

    @Override
    public String toString() {
        return
                "SellerBeneficiary{" +
                        "reference = '" + reference + '\'' +
                        ",address = '" + address + '\'' +
                        ",name = '" + name + '\'' +
                        ",contactPerson = '" + contactPerson + '\'' +
                        ",account = '" + account + '\'' +
                        "}";
    }
}
