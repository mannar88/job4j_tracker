package ru.job4j.strategy;

public class Square implements  Shape{
    @Override
    public String draw() {
        String ln = System.lineSeparator();
        return "XXX" +ln
                +"XXX"+ln
                +"XXX" + ln;
    }
}
