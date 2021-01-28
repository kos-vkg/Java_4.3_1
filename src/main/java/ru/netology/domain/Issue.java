package ru.netology.domain;

import java.util.Date;
import java.util.Objects;

public class Issue implements Comparable<Issue> {

    private int id;
    private boolean open;
    private String autor;
    private String label;
    private String assignee;
    private Date date;

    public Issue() {
    }

    public Issue(int id, boolean open, String autor, String label, String assignee, Date date) {
        this.id = id;
        this.open = open;
        this.autor = autor;
        this.label = label;
        this.assignee = assignee;
        this.date = date;
    }

    @Override
    public int compareTo(Issue o) {
        return this.date.compareTo(o.date);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Issue issue = (Issue) o;
        return id == issue.id &&
                open == issue.open &&
                Objects.equals(autor, issue.autor) &&
                Objects.equals(label, issue.label) &&
                Objects.equals(assignee, issue.assignee) &&
                Objects.equals(date,issue.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, open, autor, label, assignee, date);
    }

    @Override
    public String toString() {
        return "Issue{" +
                "id=" + id +
                ", open=" + open +
                ", autor='" + autor + '\'' +
                ", label='" + label + '\'' +
                ", assignee='" + assignee + '\'' +
                ", date='" + date + '\'' +
                '}';
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
