package ru.job4j.tracker;


import java.util.List;

public class FindItemsByName implements  UserAction{

    private final Output out;

    public FindItemsByName(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Поииск заявки по имени";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        out.println("=== Find items by name ====");
        out.println("Enter name: ");
        String name = input.askStr("Enter id: ");
        List <Item>  items = tracker.findByName(name);
        if(items.size() >0)
        {
            for (Item item : items) {
                out.println(item);
            }
        } else
        {
            out.println("Заявки с именем: " + name + " не найдены.");
        }
        return true;
    }
}
