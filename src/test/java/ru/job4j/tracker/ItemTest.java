package ru.job4j.tracker;

import org.junit.Test;
import ru.job4j.tracker.conparator.*;

import java.util.*;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import static org.junit.Assert.assertThat;

public class ItemTest {
    @Test
    public void sorterNameUp() {
        Item a = new Item();
        a.setName("a");
        Item b = new Item();
        b.setName("b");
        Item c = new Item();
        c.setName("c");
        List<Item> items = new ArrayList<>();
        items.add(b);
        items.add(c);
        items.add(a);
        List<Item> expect = Arrays.asList(a, b, c);
        Collections.sort(items, new ItemSorterByNameUp());
        assertThat(items, is(expect));
    }

    @Test
    public void sorterNameDown() {
        Item a = new Item();
        a.setName("a");
        Item b = new Item();
        b.setName("b");
        Item c = new Item();
        c.setName("c");
        List<Item> items = new ArrayList<>();
        items.add(b);
        items.add(c);
        items.add(a);
        List<Item> expect = Arrays.asList(c, b, a);
        Collections.sort(items, new ItemSorterByNameDown());
        assertThat(items, is(expect));
    }

    @Test
    public void sorterByDateUp() throws InterruptedException {
        Item a = new Item();
        TimeUnit.SECONDS.sleep(1);
        Item b = new Item();
        List<Item> items = Arrays.asList(b, a);
        List<Item> expect = Arrays.asList(a, b);
Collections.sort(items, new ItemSorterDateUp());
        assertThat(items, is(expect));
}

    @Test
    public void sorterByDateDown() throws InterruptedException {
        Item a = new Item();
        TimeUnit.SECONDS.sleep(1);
        Item b = new Item();
        List<Item> items = Arrays.asList(a, b);
        List<Item> expect = Arrays.asList(b, a);
        Collections.sort(items, new ItemSorterByDateDown());
        assertThat(items, is(expect));
    }

    @Test
    public  void  sorterIdUp () {
        Item a = new Item();
        a.setId(1);
        Item b = new Item();
        b.setId(2);
        Item c = new Item();
        c.setId(3);
        List <Item> items = Arrays.asList(c, a, b);
        List <Item> expect = Arrays.asList(a, b, c);
        Collections.sort(items, new ItemSorterByIdUp());
        assertThat(items, is(expect));
    }

    @Test
    public  void  sorterIdDown () {
        Item a = new Item();
        a.setId(1);
        Item b = new Item();
        b.setId(2);
        Item c = new Item();
        c.setId(3);
        List <Item> items = Arrays.asList(c, a, b);
        List <Item> expect = Arrays.asList(c, b, a);
        Collections.sort(items, new ItemSorterBiIdDown());
        assertThat(items, is(expect));
    }



}