package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Issue;
import ru.netology.repository.IssueRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class IssueManagerTest {

    private IssueRepository repository = new IssueRepository();
    IssueManager manager = new IssueManager(repository);
    List<Issue> expestedList = new ArrayList<>();
    List<Issue> actualList = new ArrayList<>();

    Issue t1 = new Issue(1, true, "a1", "l1", "as1", new Date(106));
    Issue t2 = new Issue(2, true, "a1", "l1", "as2", new Date(105));
    Issue t3 = new Issue(3, false, "a3", "l3", "as1", new Date(104));
    Issue t4 = new Issue(4, true, "a1", "l1", "as2", new Date(103));
    Issue t5 = new Issue(5, true, "a3", "l1", "as1", new Date(102));
    Issue t6 = new Issue(6, false, "a3", "l1", "as3", new Date(101));

    public void compareList(List<Issue> expestedList, List<Issue> actualList) {
        Issue[] expected = expestedList.toArray(new Issue[0]);
        Issue[] actual = actualList.toArray(new Issue[0]);
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSetOpenById() {
        manager.addAll(List.of(t1, t2, t3, t4, t5, t6));
        int id = 1;
        Issue item = manager.findById(id);

        manager.setOpenById(id, false);
        boolean expected = false;
        boolean actual = item.isOpen();
        assertEquals(expected, actual);
    }

    @Test
    void shouldSearchClose() {
        manager.addAll(List.of(t1, t2, t3, t4, t5, t6));

        actualList = manager.searchClose();
        expestedList.addAll(List.of(t6, t3));

        compareList(expestedList, actualList);
    }

    @Test
    void shouldSearchOpen() {

        manager.addAll(List.of(t1, t2, t3, t4, t5, t6));

        actualList = manager.searchOpen();
        expestedList.addAll(List.of(t5, t4, t2, t1));

        compareList(expestedList, actualList);
    }

    @Test
    void shouldSearchAssignee() {

        manager.addAll(List.of(t1, t2, t3, t4, t5, t6));

        actualList = manager.searchByAssignee("as1");
        expestedList.addAll(List.of(t5, t3, t1));

        compareList(expestedList, actualList);

    }

    @Test
    void shouldSearchAutor() {

        manager.addAll(List.of(t1, t2, t3, t4, t5));

        actualList = manager.searchByAutor("a1");
        expestedList.addAll(List.of(t4, t2, t1));

        compareList(expestedList, actualList);

    }


//    @Test
//    void shouldSearchOnlyResult() {
//
//        manager.addAll(List.of(t1,t5));
//
//        Issue[] actual = manager.searchBy("a3");
//        Issue[] expected = new Issue[]{t5};
//
//        assertArrayEquals(expected, actual);
//    }
//
//    @Test
//    void shouldSearchEmptyResult() {
//
//        manager.addAll(List.of(t1,t5));
//
//        Issue[] actual = manager.searchBy("a2");
//        Issue[] expected = new Issue[0];
//
//        assertArrayEquals(expected, actual);
//    }

}