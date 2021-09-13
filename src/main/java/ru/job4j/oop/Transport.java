package ru.job4j.oop;

public class Transport {
    public static void main(String[] args) {
        Vehicle airplane = new Airplane();
        Vehicle train = new Train();
        Vehicle bus = new Bus();
    Vehicle [] transports = new  Vehicle[] {airplane, train, bus};
        for (Vehicle arra:transports) {
            arra.move();
        }
    }
}
