package ru.job4j.io;

import java.util.Scanner;

public class Matches {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Игра 11.");
        boolean turn = true;
        int count = 11;
        while (count > 0) {
            String player = turn ? "Первый игрок" : "Второй игрок";
            System.out.println(player + " введите число от 1 до 3:");
            int matches = Integer.parseInt(input.nextLine());
            if ( matches >0&& matches<4 && count >= matches) {
            count -= matches;
                System.out.println("Осталось спичек: " + count);
                turn = !turn;
            }
else  if (matches >0 && matches <4 &&    count < matches) {
                System.out.println("Превышение количества доступных спичек");
            }
else{
                System.out.println("Нельзя!");
            }
        }
        if (!turn) {
            System.out.println("Выиграл первый игрок");
        } else {
            System.out.println("Выиграл второй игрок");
        }
    }
}
