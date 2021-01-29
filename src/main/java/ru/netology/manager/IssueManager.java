package ru.netology.manager;

import ru.netology.domain.Issue;
import ru.netology.domain.Label;
import ru.netology.repository.IssueRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

    public boolean setOpenById(int id, boolean open) {
        Issue item = repository.getById(id);
        if (item == null) return false;
        if (item.isOpen() == open) return true;
        item.setOpen(open);
        repository.removeById(id);
        repository.add(item);
        return true;
    }

    public List<Issue> searchByLabel(Label label) {
        List<Issue> result = new ArrayList<>();
        for (Issue item : repository.getAll()) {
            List<Label> labelList = item.getLabel();
            for (Label trueLabel : labelList) {
                if (trueLabel.equals(label)) {
                    result.add(item);
                }
            }
        }
        Collections.sort(result);  // Arrays.sort(result);
        return result;
    }

    public List<Issue> searchByAutor(String field) {
        List<Issue> result = new ArrayList<>();
        for (Issue item : repository.getAll()) {
            if (item.getAutor().equalsIgnoreCase(field)) {
                result.add(item);
            }
        }
        Collections.sort(result);
        return result;
    }

    public List<Issue> searchByAssignee(String field) {
        List<Issue> result = new ArrayList<>();
        for (Issue item : repository.getAll()) {
            if (item.getAssignee().equalsIgnoreCase(field)) {
                result.add(item);
            }
        }
        Collections.sort(result);
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

    public Issue findById(int id) {
        return repository.getById(id);
    }

    public List<Issue> getAll() {
        return repository.getAll();
    }

    public boolean removeById(int id) {
      return repository.removeById(id);
    }
}
