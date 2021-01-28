package ru.netology.manager;


import ru.netology.domain.Issue;
import ru.netology.repository.IssueRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
//import java.util.Collection;
//import java.util.List;

public class IssueManager {

    private IssueRepository repository;

    public IssueManager(IssueRepository repository) {
        this.repository = repository;
    }


    public void add(Issue item) {
        repository.add(item);
    }

    public void addAll(List<Issue> items) {
        repository.addAll(items);
    }


    public boolean setOpenById(int id, boolean open){
        Issue item = repository.getById(id);
        if(item == null) return false;
        if(item.isOpen() == open) return true;
        item.setOpen(open);
        repository.removeById(id);
        repository.add(item);
        return true;
    }

    public List<Issue> searchByAutor(String field) {
        List<Issue> result = new ArrayList<>();
        for (Issue item : repository.getAll()) {
            if (item.getAutor().equalsIgnoreCase(field)) {
                result.add(item);
            }
        }
        Collections.sort(result);  // Arrays.sort(result);
        return result;
    }

    public List<Issue> searchByAssignee(String field) {
        List<Issue> result = new ArrayList<>();
        for (Issue item : repository.getAll()) {
            if (item.getAssignee().equalsIgnoreCase(field)) {
                result.add(item);
            }
        }
        Collections.sort(result);  // Arrays.sort(result);
        return result;
    }

    public List<Issue> searchOpen() {
        List<Issue> result = new ArrayList<>();
        for (Issue item : repository.getAll()) {
            if (item.isOpen()) {
                result.add(item);
            }
        }
        Collections.sort(result);
        return result;
    }

    public List<Issue> searchClose() {
        List<Issue> result = new ArrayList<>();
        for (Issue item : repository.getAll()) {
            if (!item.isOpen()) {
                result.add(item);
            }
        }
        Collections.sort(result);
        return result;
    }

    public Issue[] getAllArray() {
        return repository.getAll().toArray(new Issue[0]);

    }

    public void removeById(int id) {
        repository.removeById(id);
    }

    public Issue findById(int id) {
        return repository.getById(id);
    }


}
