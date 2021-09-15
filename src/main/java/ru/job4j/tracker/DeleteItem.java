package ru.job4j.tracker;

public class DeleteItem implements  UserAction{
    @Override
    public String name() {
        return "Удалит заявку";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== Delete item ====");
        System.out.print("Enter id: ");
        int id = input.askInt("Enter id: ");
        if (tracker.delete(id)) {
            System.out.println("Заявка удалена успешно.");
        } else {
            System.out.println("Ошибка удаления заявки.");
        }
        return true;
    }
}
