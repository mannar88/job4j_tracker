package ru.job4j.tracker;

public class ExitMenu implements UserAction{
    @Override
    public String name() {
        return "Выход";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        return false;
    }
}
