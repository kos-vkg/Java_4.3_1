package ru.netology.repository;

import ru.netology.domain.Issue;

import java.util.ArrayList;
import java.util.List;

public class IssueRepository {

    private List<Issue> items = new ArrayList<>();

    public List<Issue> getAll() {
        return items;
    }

    public Issue getById(int id) {
        for (Issue item : items) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;

    }



    public boolean removeById(int id) {
        Issue item = this.getById(id);
        if (item == null) return false;
        items.remove(item);
        return true;
    }

    public boolean add(Issue item) {
        return items.add(item);
    }

    public boolean remove(Issue item) {
        return items.remove(item);
    }

    public boolean addAll(List<Issue> items) {
        return this.items.addAll(items);
    }

    public boolean removeAll(List<Issue> items) {
        return this.items.removeAll(items);
    }
}
