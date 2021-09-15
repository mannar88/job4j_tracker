package ru.job4j.tracker;

public class FindItemsByName implements  UserAction{
    @Override
    public String name() {
        return "Поииск заявки по имени";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== Find items by name ====");
        System.out.print("Enter name: ");
        String name = input.askStr("Enter id: ");
        Item[] items = tracker.findByName(name);
        if(items.length >0)
        {
            for (Item item : items) {
                System.out.println(item);
            }
        } else
        {
            System.out.println("Заявки с именем: " + name + " не найдены.");
        }
        return true;
    }
}
