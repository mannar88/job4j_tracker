package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

public class StartUITest {

    @Test
    public void whenCreateItem() {
        Input in = new StubInput(
                new String[] {"0", "Item name", "1"}
        );
        MemTracker tracker = new MemTracker();
        Output output = new ConsoleOutput();
        List <UserAction> actions = new ArrayList<>();
                actions.add(new CreateItem(output));
                actions.add(new ExitMenu(output));
        new StartUI(output).init(in, tracker, actions);
        assertThat(tracker.findAll().get(0).getName(), is("Item name"));
    }

    @Test
    public void whenReplaceItem() {
        MemTracker tracker = new MemTracker();
        Item item = tracker.add(new Item("Replaced item"));/* Входные данные должны содержать ID добавленной заявки item.getId() */
        String replacedName = "New item name";
        Input in = new StubInput(
                new String[] {"0" , String.valueOf(item.getId()), replacedName, "1"}
        );
        List <UserAction> actions = new ArrayList<>();
                actions.add(new EditItem(new ConsoleOutput()));
                actions.add(new ExitMenu(new ConsoleOutput()));
        new StartUI(new ConsoleOutput()).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName(), is(replacedName));
    }

    @Test
    public void whenDeleteItem() {
        MemTracker tracker = new MemTracker();
        Item item = tracker.add(new Item("Deleted item"));
        Input in = new StubInput(
            new String[] {"0" , String.valueOf(item.getId()), "1"}
        );
        List <UserAction> actions = new ArrayList<>();
                actions.add(new DeleteItem(new ConsoleOutput()));
                actions.add(new ExitMenu(new ConsoleOutput()));
        new StartUI(new ConsoleOutput()).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()), is(nullValue()));
    }

    @Test
    public void whenExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0"}
        );
        MemTracker tracker = new MemTracker();
        List <UserAction> actions = new ArrayList<>();
                actions.add(new ExitMenu(out));
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator() +
                        "0. Выход" + System.lineSeparator()
        ));
    }

    @Test
public  void thenFindItemFalse() {
Output output =new StubOutput();
MemTracker tracker = new MemTracker();
    Input input = new StubInput(new  String[]{
        "0", "0", "1"
    });
    tracker.add(new Item("test"));
List <UserAction> userActions = new ArrayList<>();
        userActions.add(new FindItem(output));
        userActions.add(new ExitMenu(output));
new  StartUI(output).init(input, tracker, userActions);
    assertThat(output.toString(), is("Menu." + System.lineSeparator()
    + "0. Поиск заявки по ID" + System.lineSeparator()
    + "1. Выход" +System.lineSeparator()
    + "=== Find item by id ====" + System.lineSeparator()
    + "Enter id: " + System.lineSeparator()
                    + "Заявка с введенным id: " + "0"  + " не найдена." + System.lineSeparator()
                    + "Menu." + System.lineSeparator()
                    + "0. Поиск заявки по ID" + System.lineSeparator()
                    + "1. Выход" +System.lineSeparator()
    ));
    }

    @Test
    public  void thenFindItemTrue() {
        Output output =new StubOutput();
        MemTracker tracker = new MemTracker();
Item item = new Item("test");
        Input input = new StubInput(new  String[]{
                "0", "1", "1"
        });
        List <UserAction> userActions = new ArrayList<>();
                userActions.add(new FindItem(output));
                userActions.add(new ExitMenu(output));
tracker.add(item);
        new  StartUI(output).init(input, tracker, userActions);
        assertThat(output.toString(), is("Menu." + System.lineSeparator()
                + "0. Поиск заявки по ID" + System.lineSeparator()
                + "1. Выход" +System.lineSeparator()
                + "=== Find item by id ====" + System.lineSeparator()
                + "Enter id: " + System.lineSeparator()
+ item.toString() + System.lineSeparator()
                + "Menu." + System.lineSeparator()
                + "0. Поиск заявки по ID" + System.lineSeparator()
                + "1. Выход" +System.lineSeparator()
        ));
    }

    @Test
public  void thenFindItemsByNameFalse() {
        Output output = new StubOutput();
        MemTracker tracker = new MemTracker();
        Input input = new StubInput(new  String[]{
                "0",
                "test",
                "1"
        });
    List<UserAction> userActions = new ArrayList<>();
            userActions.add(new FindItemsByName(output));
            userActions.add(new ExitMenu(output));
new  StartUI(output).init(input, tracker, userActions);
assertThat(output.toString(), is(
        "Menu." + System.lineSeparator()
        +"0. Поииск заявки по имени" + System.lineSeparator()
            + "1. Выход" +System.lineSeparator()
+ "=== Find items by name ====" +System.lineSeparator()
+ "Enter name: " + System.lineSeparator()
+ "Заявки с именем: " + "test" + " не найдены." + System.lineSeparator()
+ "Menu." + System.lineSeparator()
                    +"0. Поииск заявки по имени" + System.lineSeparator()
                    + "1. Выход" +System.lineSeparator()
    ));
    }

    @Test
    public  void thenFindItemsByNameTrue() {
        Output output = new StubOutput();
        MemTracker tracker = new MemTracker();
        Item item = new Item("test");
        Input input = new StubInput(new  String[]{
                "0",
                "test",
                "1"
        });
        List <UserAction> userActions = new ArrayList<>();
                userActions.add(new FindItemsByName(output));
                userActions.add(new ExitMenu(output));
        tracker.add(item);
        new  StartUI(output).init(input, tracker, userActions);
        assertThat(output.toString(), is(
                "Menu." + System.lineSeparator()
                        +"0. Поииск заявки по имени" + System.lineSeparator()
                        + "1. Выход" +System.lineSeparator()
                        + "=== Find items by name ====" +System.lineSeparator()
                        + "Enter name: " + System.lineSeparator()
+ item.toString() + System.lineSeparator()
                        + "Menu." + System.lineSeparator()
                        +"0. Поииск заявки по имени" + System.lineSeparator()
                        + "1. Выход" +System.lineSeparator()
        ));
    }


    @Test
    public  void thenShowAllItemsFalse() {
    MemTracker tracker = new MemTracker();
    Output output = new StubOutput();
    Input input = new StubInput(new  String[] {
        "0",
            "1"
    });
List <UserAction> userActions = new ArrayList<>();
        userActions.add(new ShowAllItems(output));
        userActions.add(new ExitMenu(output));
new  StartUI(output).init(input, tracker, userActions);
assertThat(output.toString(), is(
        "Menu." + System.lineSeparator()
+ "0. Ввывод всех заявок." + System.lineSeparator()
        + "1. Выход" + System.lineSeparator()
+ "=== Show all items ====" + System.lineSeparator()
+ "Хранилище еще не содержит заявок" + System.lineSeparator()
+ "Menu." + System.lineSeparator()
                + "0. Ввывод всех заявок." + System.lineSeparator()
                + "1. Выход" + System.lineSeparator()
));
    }

    @Test
public  void thenShowAllItemsTrue() {
        MemTracker tracker = new MemTracker();
        Item item = new Item("test");
        Output output = new StubOutput();
        Input input = new StubInput(new  String[] {
                "0",
                "1"
        });
        List <UserAction> userActions = new ArrayList<>();
                userActions.add(new ShowAllItems(output));
                userActions.add(new ExitMenu(output));
        tracker.add(item);
        new  StartUI(output).init(input, tracker, userActions);
        assertThat(output.toString(), is(
                "Menu." + System.lineSeparator()
                        + "0. Ввывод всех заявок." + System.lineSeparator()
                        + "1. Выход" + System.lineSeparator()
                        + "=== Show all items ====" + System.lineSeparator()
+ item.toString() + System.lineSeparator()
                        + "Menu." + System.lineSeparator()
                        + "0. Ввывод всех заявок." + System.lineSeparator()
                        + "1. Выход" + System.lineSeparator()
        ));
    }

    @Test
    public void whenInvalidExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {
                        "2",
                        "0"
                }
        );
        MemTracker tracker = new MemTracker();
        List <UserAction> actions = new ArrayList<>();
                actions.add(new ExitMenu(out));
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                        "Menu." + ln
                                + "0. Выход" + ln
                                + "Не верный ввод" + ln
                                + "Menu." + ln
                                + "0. Выход" + ln
                )
        );
    }


}