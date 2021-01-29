package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Issue;
import ru.netology.domain.Label;
import ru.netology.repository.IssueRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EmptyIssueManagerTest {

    private IssueRepository repository = new IssueRepository();
    IssueManager manager = new IssueManager(repository);

    List<Issue> expectedList = new ArrayList<>();
    List<Issue> actualList = new ArrayList<>();

    Label l1 = new Label("comp:", "c1");
    Label l2 = new Label("comp:", "c2");

    List<Label> ll1 = new ArrayList<>(List.of(l1));
    List<Label> ll2 = new ArrayList<>(List.of());

    Issue t1 = new Issue(1, true, "a1", ll1, "as1", new Date(106));
    Issue t2 = new Issue(2, true, "a2", ll2, "as1", new Date(106));

    public void compareList(List<Issue> expectedList, List<Issue> actualList) {
        Issue[] expected = expectedList.toArray(new Issue[0]);
        Issue[] actual = actualList.toArray(new Issue[0]);
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchNotLabel() {
        manager.addAll(List.of(t1));
        actualList = manager.searchByLabel(l2);
        expectedList.addAll(List.of());
        compareList(expectedList, actualList);
    }

    @Test
    void shouldSearchEmptyLabel() {
        manager.addAll(List.of(t2));
        actualList = manager.searchByLabel(l2);
        expectedList.addAll(List.of());
        compareList(expectedList, actualList);
    }

    @Test
    void shouldSearchEmptyIssue() {
        manager.addAll(List.of());
        actualList = manager.searchByLabel(l2);
        expectedList.addAll(List.of());
        compareList(expectedList, actualList);
    }

    @Test
    void shouldSetOpenByMissingId() {
        manager.addAll(List.of(t1));
        int id = 2;
        boolean actual = manager.setOpenById(id, true);
        assertFalse(actual);
    }

    @Test
    void shouldSetOpenByIdEmptyIssue() {
        manager.addAll(List.of());
        boolean actual = manager.setOpenById(1, true);
        assertFalse(actual);
    }

    @Test
    void shouldSearchCloseByMissing() {
        manager.addAll(List.of(t1));
        manager.setOpenById(1, true);
        actualList = manager.searchClose();
        expectedList.addAll(List.of());
        compareList(expectedList, actualList);
    }

    @Test
    void shouldSearchCloseEmptyIssue() {
        manager.addAll(List.of());
        actualList = manager.searchClose();
        expectedList.addAll(List.of());
        compareList(expectedList, actualList);
    }

    @Test
    void shouldSearchOpenByMissing() {
        manager.addAll(List.of(t1));
        manager.setOpenById(1, false);
        actualList = manager.searchOpen();
        expectedList.addAll(List.of());
        compareList(expectedList, actualList);
    }

    @Test
    void shouldSearchOpenEmptyIssue() {
        manager.addAll(List.of());
        actualList = manager.searchOpen();
        expectedList.addAll(List.of());
        compareList(expectedList, actualList);
    }

    @Test
    void shouldSearchMissingAssignee() {
        manager.addAll(List.of(t1));
        actualList = manager.searchByAssignee("as2");
        expectedList.addAll(List.of());
        compareList(expectedList, actualList);
    }

    @Test
    void shouldSearchAssigneeEmptyIssue() {
        manager.addAll(List.of());
        actualList = manager.searchByAssignee("as1");
        expectedList.addAll(List.of());
        compareList(expectedList, actualList);
    }

    @Test
    void shouldSearchMissingAuthor() {
        manager.addAll(List.of(t1));
        actualList = manager.searchByAutor("a2");
        expectedList.addAll(List.of());
        compareList(expectedList, actualList);
    }

    @Test
    void shouldSearchAuthorEmptyIssue() {
        manager.addAll(List.of());
        actualList = manager.searchByAutor("a2");
        expectedList.addAll(List.of());
        compareList(expectedList, actualList);
    }

    @Test
    void shouldGetAllIssue() {
        actualList = manager.getAll();
        expectedList.addAll(List.of());
        compareList(expectedList, actualList);
    }

    @Test
    void shouldRemoveByMissingId() {
        manager.addAll(List.of(t1));
        boolean actual = manager.removeById(2);
        actualList = manager.getAll();
        expectedList.addAll(List.of(t1));
        compareList(expectedList, actualList);
        assertFalse(actual);
    }

    @Test
    void shouldRemoveByIdEmptyIssue() {
        manager.addAll(List.of());
        boolean actual = manager.removeById(2);
        actualList = manager.getAll();
        expectedList.addAll(List.of());
        compareList(expectedList, actualList);
        assertFalse(actual);
    }

}