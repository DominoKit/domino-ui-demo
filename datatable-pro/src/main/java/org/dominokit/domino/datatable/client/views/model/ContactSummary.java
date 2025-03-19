package org.dominokit.domino.datatable.client.views.model;

public class ContactSummary {
    private String type;
    private double balance;
    private int age;

    public ContactSummary(String type, double balance, int age) {
        this.type = type;
        this.balance = balance;
        this.age = age;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
