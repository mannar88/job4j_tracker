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
    public boolean execute(Input input, Store tracker) {
        out.println("=== Edit item ====");
        out.println("Enter id: ");
        int id = input.askInt("Enter id: ");
        out.println("Enter name: ");
        String name = input.askStr("Enter id: ");
        Item item = new Item(name);
        if (tracker.replace(id, item)) {
            out.println("Заявка изменена успешно.");
        } else {
            out.println("Ошибка замены заявки.");
        }
        return true;
    }
}
