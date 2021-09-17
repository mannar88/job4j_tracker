package ru.job4j.tracker;


public  class CreateItem implements  UserAction{

    private final Output out;

    public CreateItem(Output out) {
        this.out = out;
    }

    @Override
    public String name() {

        return "Новая заявка";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Create a new Item ====");
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        tracker.add(item);
        return true;
    }
}