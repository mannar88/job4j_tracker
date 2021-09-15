package ru.job4j.tracker;

public class ExitMenu implements UserAction{

    private final Output out;

    public ExitMenu(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Выход";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        return false;
    }
}
