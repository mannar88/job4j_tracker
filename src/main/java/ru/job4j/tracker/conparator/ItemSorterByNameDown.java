package ru.job4j.tracker.conparator;

import ru.job4j.tracker.Item;

import java.util.Comparator;

public class ItemSorterByNameDown implements Comparator <Item> {
    @Override
    public int compare(Item o1, Item o2) {
        return -1*(o1.getName().compareTo(o2.getName()));
    }
}
