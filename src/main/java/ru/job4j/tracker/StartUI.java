package ru.job4j.tracker;


import java.util.ArrayList;
import java.util.List;

public class StartUI {

    private final Output out;

    public StartUI(Output out) {
        this.out = out;
    }

    public void init(Input input, Tracker tracker, List <UserAction> actions) {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = input.askInt("Select: ");
            if (select < 0 || select >= actions.size()) {
                out.println("Не верный ввод");
                continue;
            }
                UserAction action = actions.get(select);
                run = action.execute(input, tracker);
            }
        }

    private void showMenu(List <UserAction> actions) {
        out.println("Menu.");
for (int i = 0; i < actions.size(); i++) {
out.println(i + ". " + actions.get(i).name());
        }
    }

    public static void main(String[] args) {
        Output output = new ConsoleOutput();
        Input input = new ValidateInput(output, new ConsoleInput());
        Tracker tracker = new Tracker();
        List <UserAction> actions = new ArrayList<>();
                actions.add(new CreateItem(output));
actions.add(new ShowAllItems(output));
actions.add(new  EditItem(output));
actions.add(new DeleteItem(output));
actions.add(new FindItem(output));
actions.add(new FindItemsByName(output));
actions.add(new ExitMenu(output));
new StartUI(output).init(input, tracker, actions);;
}
}