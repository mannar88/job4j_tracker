package ru.job4j.condition;

public class Max {

    public  static  int add (int a, int b){
        return Math.max(a, b);
    }

    public static int add(int a, int b, int c){
        return Math.max(c, add(a, b));
    }

    public  static int add ( int a, int b, int c, int d){
        return  Math.max(d, add(a, b, c));
    }
}
