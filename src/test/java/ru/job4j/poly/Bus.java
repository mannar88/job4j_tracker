package ru.job4j.poly;

public class Bus implements  Transport{

    private boolean engine = false;

    @Override
    public void drive() {

        engine = true;
    }

    @Override
    public void passengers(int count) {
        System.out.println(count);
    }

    @Override
    public double price(int petrol) {
        return petrol * 47.7;
    }
}
