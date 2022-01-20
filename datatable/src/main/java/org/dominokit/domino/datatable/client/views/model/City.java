package org.dominokit.domino.datatable.client.views.model;

public class City {

    private int id;
    private String name;
    private String code;
    private boolean flag;

    public City() {
    }

    public City(int id, String name, String code, boolean flag) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.flag = flag;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
