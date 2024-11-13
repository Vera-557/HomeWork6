package TickTack;

import java.util.Scanner;

class Player {
   String namePlayer;
   public void playerName(){
       System.out.println("Введите ваше имя");
        namePlayer = new Scanner(System.in).next().trim();
       System.out.println("Здравствуйте " + namePlayer + ", давайте сыграем");
   }
         public void playAgain(){
       System.out.println(namePlayer + "хотите сыграть еще раз?");
             System.out.println(" да - 1");
         }

   public Player() {
       playerName();
   }
}
