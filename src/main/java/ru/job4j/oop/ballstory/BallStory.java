package ru.job4j.oop.ballstory;

public class BallStory {

    public static void main(String[] args) {
        Ball kolobok = new Ball();
Hare hare = new Hare();
Wolf wolf = new Wolf();
    Fox fox = new Fox();
    hare.tryEat(kolobok);
    wolf.tryEat(kolobok);
    fox.tryEat(kolobok);
    }
}
