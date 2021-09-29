package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
String[]leftarray = left.split("\\.");
String[] rightarray = right.split("\\.");
return  Integer.compare(Integer.parseInt(leftarray[0]), Integer.parseInt(rightarray[0]));
    }
}