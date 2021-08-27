package ru.job4j.oop;

import java.nio.FloatBuffer;

public class Battery {

    private int load;

public  Battery ( int load) {
    this.load = load;
}

    public void exchange(Battery another) {
another.load += this.load;
this.load = 0;
}

    public static void main(String[] args) {

    Battery left = new Battery(10);
    Battery right = new Battery(0);
        System.out.println("Было " + left.load + " " + right.load);
left.exchange(right);
        System.out.println("Стало " + left.load + " " + right.load);
}
}
