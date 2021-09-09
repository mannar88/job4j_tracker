package ru.job4j.io;

import java.util.Random;
import java.util.Scanner;

public class MagicBall {

private    static  void print (String string) {
        System.out.println(string);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        print("Я великий Оракул. Что ты хочешь узнать? ");
        String question = input.nextLine();
        int answer = new Random().nextInt(3);
        switch (answer) {
            case 0:
                print("Да");
                break;
            case 1:
                print("Нет");
                break;
            default:
                print("Все возможно...");
        }
    }
}
