package ru.job4j.collection;

import org.junit.Test;
import java.util.Comparator;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.assertThat;

public class JobTest {

    @Test
    public void whenCompatorByProrityDown() {
        Comparator<Job> cmpNamePriority = new JobDescByPriorityDown();
        int rsl = cmpNamePriority.compare(
                new Job("B", 1),
                new Job("A", 0)
        );
    assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenCompatorByNameUp() {
        Comparator<Job> cmpNamePriority = new JobDescByNameUp();
        int rsl = cmpNamePriority.compare(
                new Job("B", 1),
                new Job("A", 0)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenCompatorByProrityUp() {
        Comparator<Job> cmpNamePriority = new JobDescByPriorityUp();
        int rsl = cmpNamePriority.compare(
                new Job("B", 1),
                new Job("A", 0)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenCompatorByNameDown() {
        Comparator<Job> cmpNamePriority = new JobDescByNameDown();
        int rsl = cmpNamePriority.compare(
                new Job("B", 1),
                new Job("A", 0)
        );
    assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenCompatorByNameAndPrority() {
        Comparator<Job> cmpNamePriority = new JobDescByNameDown().thenComparing(new JobDescByPriorityDown());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenCompatorByNameAndProrityUp() {
        Comparator<Job> cmpNamePriority = new JobDescByPriorityUp().thenComparing(new JobDescByNameUp());
        int rsl = cmpNamePriority.compare(
                new Job("B", 0),
                new Job("A", 0)
        );
        assertThat(rsl, greaterThan(0));
    }


}