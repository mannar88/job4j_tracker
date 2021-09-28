package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

public class Tracker {
private List <Item> items = new ArrayList<>();
    private int ids = 1;

    public Item add(Item item) {
        item.setId(ids++);
items.add(item);
        return item;
    }

    public List <Item> findAll() {
        return List.copyOf(items);
    }

    public List <Item> findByName(String key){
List <Item> rst = new ArrayList<>();
for (Item item : items) {
    if (item.getName().equals(key)) {
        rst.add(item);
    }
}
    return  rst;
    }

    private int indexOf(int id) {
        for (int i = 0; i < items.size(); i++) {
if ( items.get(i).getId() == id) {
    return  i;
}
        }
        return -1;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items.get(index): null;
    }

    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        if ( index != -1) {
            item.setId(id);
items.set(index, item);
            return true;
        }
return false;
    }

    public boolean delete(int id) {
int index =indexOf(id);
if ( index != -1) {
items.remove(index);
    return  true;
}
return  false;
    }

    }