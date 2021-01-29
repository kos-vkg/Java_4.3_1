package ru.netology.domain;

import java.util.Objects;

public class Label {

    //private int id;
    private String group;
    private String name;

    public Label() {
    }

    public Label(/*int id,*/ String group, String name) {
        // this.id = id;
        this.group = group;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Label label = (Label) o;
        return Objects.equals(group, label.group) &&
                Objects.equals(name, label.name);
    }

//    public int getId() {
//        return id;
//    }

//    public void setId(int id) {
//        this.id = id;
//    }

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
