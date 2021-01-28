package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Issue;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class IssueRepositoryTest {
    private IssueRepository repository = new IssueRepository();
    List<Issue> issues = new ArrayList<>();

    Issue issue1 = new Issue(1, true, "a1", "l1", "as1",new Date(102));
    Issue issue2 = new Issue(2, true, "a2", "l2", "as1",new Date(101));
    Issue issue3 = new Issue(3, true, "a3", "l3", "as1",new Date(101));

    @Test
    public void shouldAdd() {

        repository.add(issue1);
        issues.addAll(List.of(issue1));

        Issue[] expected = issues.toArray(new Issue[0]);
        Issue[] actual = repository.getAll().toArray(new Issue[0]);
        assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldRemoveById() {
        repository.add(issue1);

        repository.removeById(1);

        Issue[] expected = new Issue[0];
        Issue[] actual = repository.getAll().toArray(new Issue[0]);
        assertArrayEquals(expected, actual);
    }


//    @Test
//    public void shouldRemoveByMissingId() {
//        repository.add(issue1);
//        assertThrows(NotFoundException.class, () -> repository.removeById(2));
//    }

}

