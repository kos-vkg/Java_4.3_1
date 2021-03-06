package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Issue;
import ru.netology.domain.Label;
import ru.netology.repository.IssueRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class IssueManagerTest {

    private IssueRepository repository = new IssueRepository();
    IssueManager manager = new IssueManager(repository);

    List<Issue> expectedList = new ArrayList<>();
    List<Issue> actualList = new ArrayList<>();

    Label l1 = new Label("comp:", "c1");
    Label l2 = new Label("comp:", "c2");
    Label l3 = new Label("type:", "t1");
    Label l4 = new Label("type:", "t2");

    List<Label> ll1 = new ArrayList<>(List.of(l1, l2));
    List<Label> ll2 = new ArrayList<>(List.of(l2, l3));
    List<Label> ll3 = new ArrayList<>(List.of(l2, l4));
    List<Label> ll4 = new ArrayList<>(List.of(l1, l2, l3, l4));

    Issue t1 = new Issue(1, true, "a1", ll4, "as1", new Date(106));
    Issue t2 = new Issue(2, true, "a1", ll1, "as2", new Date(105));
    Issue t3 = new Issue(3, false, "a3", ll2, "as1", new Date(104));
    Issue t4 = new Issue(4, true, "a1", ll1, "as2", new Date(103));
    Issue t5 = new Issue(5, true, "a3", ll3, "as1", new Date(102));
    Issue t6 = new Issue(6, false, "a3", ll1, "as3", new Date(101));

    public void compareList(List<Issue> expectedList, List<Issue> actualList) {
        Issue[] expected = expectedList.toArray(new Issue[0]);
        Issue[] actual = actualList.toArray(new Issue[0]);
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchLabel() {
        manager.addAll(List.of(t1, t2, t3, t4, t5, t6));

        actualList = manager.searchByLabel(l2);
        expectedList.addAll(List.of(t6, t5, t4, t3, t2, t1));

        compareList(expectedList, actualList);
    }


    @Test
    void shouldSetOpenById() {
        manager.addAll(List.of(t1, t2, t3, t4, t5, t6));
        int id = 1;
        Issue item = manager.findById(id);
        boolean result = manager.setOpenById(id, false);
        boolean actual = item.isOpen();
        assertTrue(result);
        assertFalse(actual);
    }

    @Test
    void shouldSearchClose() {
        manager.addAll(List.of(t1, t2, t3, t4, t5, t6));
        actualList = manager.searchClose();
        expectedList.addAll(List.of(t6, t3));
        compareList(expectedList, actualList);
    }

    @Test
    void shouldSearchOpen() {
        manager.addAll(List.of(t1, t2, t3, t4, t5, t6));
        actualList = manager.searchOpen();
        expectedList.addAll(List.of(t5, t4, t2, t1));
        compareList(expectedList, actualList);
    }

    @Test
    void shouldSearchAssignee() {
        manager.addAll(List.of(t1, t2, t3, t4, t5, t6));
        actualList = manager.searchByAssignee("as1");
        expectedList.addAll(List.of(t5, t3, t1));
        compareList(expectedList, actualList);
    }

    @Test
    void shouldSearchAuthor() {
        manager.addAll(List.of(t1, t2, t3, t4, t5));
        actualList = manager.searchByAutor("a1");
        expectedList.addAll(List.of(t4, t2, t1));
        compareList(expectedList, actualList);
    }

    @Test
    void shouldAddIssue() {
        manager.add(t1);
        manager.add(t2);
        manager.add(t3);
        actualList = manager.getAll();
        expectedList.addAll(List.of(t1, t2, t3));
        compareList(expectedList, actualList);
    }

    @Test
    void shouldRemoveById() {
        manager.addAll(List.of(t1, t2, t3));
        manager.removeById(2);
        actualList = manager.getAll();
        expectedList.addAll(List.of(t1, t3));
        compareList(expectedList, actualList);
    }


}