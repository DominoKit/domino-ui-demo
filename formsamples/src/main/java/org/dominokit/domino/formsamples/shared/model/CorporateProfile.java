
package org.dominokit.domino.formsamples.shared.model;

import org.dominokit.jackson.annotation.JSONMapper;

import java.util.List;

@JSONMapper
public class CorporateProfile {

    public static final CorporateProfile_MapperImpl MAPPER = new CorporateProfile_MapperImpl();

    private Address address;
    private List<Bank> banks;
    private String code;
    private ContactPerson contactPerson;
    private List<CorporateAccount> corporateAccounts;
    private String id;
    private String name;
    private String reference;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Bank> getBanks() {
        return banks;
    }

    public void setBanks(List<Bank> banks) {
        this.banks = banks;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public ContactPerson getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(ContactPerson contactPerson) {
        this.contactPerson = contactPerson;
    }

    public List<CorporateAccount> getCorporateAccounts() {
        return corporateAccounts;
    }

    public void setCorporateAccounts(List<CorporateAccount> corporateAccounts) {
        this.corporateAccounts = corporateAccounts;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

}
