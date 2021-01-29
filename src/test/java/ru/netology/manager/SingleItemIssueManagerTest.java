package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Issue;
import ru.netology.domain.Label;
import ru.netology.repository.IssueRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SingleItemIssueManagerTest {

    private IssueRepository repository = new IssueRepository();
    IssueManager manager = new IssueManager(repository);

    List<Issue> expectedList = new ArrayList<>();
    List<Issue> actualList = new ArrayList<>();

    Label l1 = new Label("comp:", "c1");

    List<Label> ll1 = new ArrayList<>(List.of(l1));

    Issue t1 = new Issue(1, true, "a1", ll1, "as1", new Date(106));

    public void compareList(List<Issue> expectedList, List<Issue> actualList) {
        Issue[] expected = expectedList.toArray(new Issue[0]);
        Issue[] actual = actualList.toArray(new Issue[0]);
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchLabel() {
        manager.addAll(List.of(t1));
        actualList = manager.searchByLabel(l1);
        expectedList.addAll(List.of(t1));
        compareList(expectedList, actualList);
    }

    @Test
    void shouldSetOpenById() {
        manager.addAll(List.of(t1));
        int id = 1;
        Issue item = manager.findById(id);
        boolean relust = manager.setOpenById(id, true);
        boolean actual = item.isOpen();
        assertTrue(actual);
        assertTrue(relust);
    }

    @Test
    void shouldSearchClose() {
        manager.addAll(List.of(t1));
        int id = 1;
        manager.setOpenById(id, false);
        actualList = manager.searchClose();
        expectedList.addAll(List.of(t1));
        compareList(expectedList, actualList);
    }

    @Test
    void shouldSearchOpen() {
        manager.addAll(List.of(t1));
        int id = 1;
        manager.setOpenById(id, true);
        actualList = manager.searchOpen();
        expectedList.addAll(List.of(t1));
        compareList(expectedList, actualList);
    }

    @Test
    void shouldSearchAssignee() {
        manager.addAll(List.of(t1));
        actualList = manager.searchByAssignee("as1");
        expectedList.addAll(List.of(t1));
        compareList(expectedList, actualList);
    }

    @Test
    void shouldSearchAuthor() {
        manager.addAll(List.of(t1));
        actualList = manager.searchByAutor("a1");
        expectedList.addAll(List.of(t1));
        compareList(expectedList, actualList);
    }

    @Test
    void shouldAddIssue() {
        manager.add(t1);
        actualList = manager.getAll();
        expectedList.addAll(List.of(t1));
        compareList(expectedList, actualList);
    }

    @Test
    void shouldRemoveById() {
        manager.addAll(List.of(t1));
        boolean actual = manager.removeById(1);
        actualList = manager.getAll();
        expectedList.addAll(List.of());
        compareList(expectedList, actualList);
        assertTrue(actual);
    }
}