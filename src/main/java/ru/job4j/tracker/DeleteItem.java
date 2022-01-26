package ru.job4j.tracker;


public class DeleteItem implements  UserAction{

    private final Output out;

    public DeleteItem(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Удалит заявку";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        out.println("=== Delete item ====");
        out.println("Enter id: ");
        int id = input.askInt("Enter id: ");
        if (tracker.delete(id)) {
            out.println("Заявка удалена успешно.");
        } else {
            out.println("Ошибка удаления заявки.");
        }
        return true;
    }
}
