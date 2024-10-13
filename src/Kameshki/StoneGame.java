package Kameshki;

import java.util.Scanner;

public class StoneGame {
    static int playerNums;
    static int randomNum;
    static Player player1;
    static Player player2;
    static int gameCount;

    public static void main(String[] args) {
        System.out.println("☺ Игрок 1, введите ваше имя");
        player1 = new Player(new Scanner(System.in).nextLine());
        System.out.println("☺ Игрок 2, введите ваше имя");
        player2 = new Player(new Scanner(System.in).nextLine());
        computerRandom();
        enterNum();
        winCount();

    }

    static void computerRandom() {
        randomNum = (int) ((Math.random() + 1) * 100);
        System.out.println("♥ Компьютер загадывает число от 1 до 100 ♥");
        //System.out.println(randomNum);//это для проверки
    }

    static void enterNum() {
        int i = 0;
        while (playerNums < randomNum) {
            System.out.println("Игрок " + player1.playerName + " вводит число");
            playerNums = playerNums + new Scanner(System.in).nextInt();
            // System.out.println("Ваша сумма - " + playerNums);// проверка
            i++;
            if (playerNums < randomNum) {
                System.out.println("Игрок " + player2.playerName + " вводит число");
                playerNums = playerNums + new Scanner(System.in).nextInt();
                // System.out.println("Ваша сумма - " + playerNums);//проверка
                i++;
            }
        }
        if (playerNums == randomNum) {
            if (i % 2 == 0) {
                System.out.println("Выиграл " + player1.playerName);
                player1.wins++;
            } else System.out.println("Выиграл " + player2.playerName);
            player2.wins++;
        }
        if (playerNums > randomNum) {
            if (i % 2 == 0) {
                System.out.println("Проиграл " + player1.playerName);
                player2.wins++;
            } else System.out.println("Проиграл " + player2.playerName);
            player1.wins++;
        }

        //System.out.println(i);//для проверки
        System.out.println("Компьютер загадал - " + randomNum);
        System.out.println("Ваша сумма - " + playerNums);

    }

    static void winCount() {
        gameCount = 0;
        gameCount++;
        System.out.println("Количество сыгранных игр - " + gameCount);
        System.out.println("Количество побед : " + player1.playerName + " : " + player1.wins);
        System.out.println("Количество побед : " + player2.playerName + " : " + player2.wins);


    }

}
