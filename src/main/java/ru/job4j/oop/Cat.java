package ru.job4j.oop;

public class Cat {

    private String food;
    private String name;

    public void show() {
        System.out.println(" Котенок " + this.name + " съел " + this.food);
    }

    public void giveNick(String nick) {
        this.name = nick;
    }

    public void eat(String meat) {
        this.food = meat;
    }

    public static void main(String[] args) {
        Cat cat = new Cat();
        cat.giveNick("Гаф");
        cat.eat("котлету");
        cat.show();
        cat.giveNick("Черныш");
        cat.eat("рыбу");
        cat.show();
    }
}