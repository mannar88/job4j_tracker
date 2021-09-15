package ru.job4j.tracker;

public class EditItem implements  UserAction{

    private final Output out;

    public EditItem(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Редактирование заявки";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== Edit item ====");
        System.out.print("Enter id: ");
        int id = input.askInt("Enter id: ");
        System.out.print("Enter name: ");
        String name = input.askStr("Enter id: ");
        Item item = new Item(name);
        if (tracker.replace(id, item)) {
            System.out.println("Заявка изменена успешно.");
        } else {
            System.out.println("Ошибка замены заявки.");
        }
        return true;
    }
}
