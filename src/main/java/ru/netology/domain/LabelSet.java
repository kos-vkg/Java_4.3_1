package ru.netology.domain;

public class LabelSet {

    private int id;
    private int idIssue;
    private String group;
    private String name;

    public LabelSet() {
    }

    public LabelSet(int id, int idIssue, String group, String name) {
        this.id = id;
        this.idIssue = idIssue;
        this.group = group;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdIssue() {
        return idIssue;
    }

    public void setIdIssue(int idIssue) {
        this.idIssue = idIssue;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
