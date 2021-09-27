package ru.job4j.collection;

import java.util.HashSet;

public class UsageHashSet {
    public static void main(String[] args) {
        HashSet<String> autos = new HashSet<String>();
        autos.add("Lada");
        autos.add("BMV");
        autos.add("Volga");
        autos.add("Toyota");
        for (String string : autos) {
            System.out.println(string);
        }
    }
}