package org.dominokit.domino.datatable.client.views.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.dominokit.domino.ui.datatable.plugins.tree.IsTreeNode;
import org.dominokit.jackson.annotation.JSONMapper;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Contact implements IsTreeNode {

    private int index;
    private boolean active;
    private Double balance;
    private String picture;
    private short age;
    private EyeColor eyeColor;
    private String name;
    private Gender gender;
    private String company;
    private String email;
    private String phone;
    private String address;
    private String about;

    private int depth =0;
    @JsonIgnore
    private boolean hasChildren = true;

    private List<Contact> friends = new ArrayList<>();

    public Contact() {
    }

    public Contact(Contact other) {
        this.index = other.index;
        this.active = other.active;
        this.balance = other.balance;
        this.picture = other.picture;
        this.age = other.age;
        this.eyeColor = other.eyeColor;
        this.name = other.name;
        this.gender = other.gender;
        this.company = other.company;
        this.email = other.email;
        this.phone = other.phone;
        this.address = other.address;
        this.about = other.about;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public short getAge() {
        return age;
    }

    public void setAge(short age) {
        this.age = age;
    }

    public EyeColor getEyeColor() {
        return eyeColor;
    }

    public void setEyeColor(EyeColor eyeColor) {
        this.eyeColor = eyeColor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String stringBalance(){
        return "$"+balance;
    }

    public void setFriends(List<Contact> subList) {
        this.friends = subList;
    }

    public List<Contact> getFriends() {
        return friends;
    }

    public void addFriend(Contact contact){
        friends.add(contact);
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "index=" + index +
                ", name='" + name + '\'' +
                '}';
    }

    public void setHasChildren(boolean hasChildren) {
        this.hasChildren = hasChildren;
    }

    @Override
    public boolean hasChildren() {
        return hasChildren;
    }
}
