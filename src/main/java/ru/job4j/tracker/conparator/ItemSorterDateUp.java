package ru.job4j.tracker.conparator;

import ru.job4j.tracker.Item;

import java.util.Comparator;

public class ItemSorterDateUp implements Comparator<Item> {
    @Override
    public int compare(Item o1, Item o2) {
        return o1.getCreated().compareTo(o2.getCreated());
    }
}
