package TickTack;

import java.util.Scanner;

public class TickTackGame {

        static final int SIZE = 3;
        static char [][] pole;
        static final char X = 'X';
        static final char O = '0';
        static char EMPTY = '1';
        static Scanner scanner = new Scanner(System.in);
        public static void main(String[] args) {
            Player player = new Player();
            player.playerName();
            map();
            printMap();
            while (true) {
                hodIgroka();
                printMap();
                if (checkWin(X)){
                    System.out.println("*** Вы выиграли ***");
                    break;
                }
                if (check()) {
                    System.out.println("*** Игра завершена. Ничья ***");
                    break;
                }
                hodComputer();
                printMap();
                if (checkWin(O)){
                    System.out.println("*** Вы проиграли ***");
                    break;
                }
//                if (check()) {
//                    System.out.println("*** Игра завершена. Ничья ***");
//                    break;
//                }
            }
        }
        public static void map(){
            System.out.println("Игровое поле");
            pole = new char[SIZE][SIZE];
            for( int i = 0; i < SIZE; i ++){
                for ( int j = 0; j < SIZE; j ++){
                    pole[i][j] = EMPTY ++;
                }
            }
        }
        public static void printMap(){
            System.out.println();
            for( int i = 0; i < SIZE; i ++){
                System.out.print( "  | ");
                for( int j = 0; j < SIZE; j ++){
                    System.out.print(pole[i][j] + " | ");
                }
                System.out.println();
                System.out.println("  -------------");
            }
            System.out.println();
        }

        public static void hodIgroka() {
            int p;
                System.out.println("*** Введите клетку хода ***");
                System.out.println();
                p = scanner.nextInt();
              do {
                    switch (p) {
                        case 1: pole[0][0] = X; break;
                        case 2: pole[0][1] = X; break;
                        case 3: pole[0][2] = X; break;
                        case 4: pole[1][0] = X; break;
                        case 5: pole[1][1] = X; break;
                        case 6: pole[1][2] = X; break;
                        case 7: pole[2][0] = X; break;
                        case 8: pole[2][1] = X; break;
                        case 9: pole[2][2] = X; break;
                        default:
                            System.out.println("Неверный ввод, выберите число в диапазоне от 1 до 9");
                            continue;
                    }
              } while (!isEmpty());


        }

        public static boolean isEmpty() {
            for (int i = 0; i < SIZE * SIZE; i++){
                if (pole[i / SIZE][i % SIZE] == EMPTY) {
                    return false;
                }
            }

            return true;
        }

        public static void hodComputer() {
            int x, y;
            System.out.println("*** Компьютер ходит ***");
            do {

                x = (int) (Math.random() * SIZE);
                y = (int) (Math.random() * SIZE);
            } while (!isEmpty());
            pole[x][y] = O;

        }

    public static boolean check() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (pole[i][j] != EMPTY) return false;


            }
        }
        return true;

    }

        public static boolean checkWin(char playerField) {

            for (int i = 0; i < SIZE; i++){
                if ((pole[i][0] == playerField && pole[i][1] == playerField && pole[i][2] == playerField) || (pole[0][i] == playerField && pole[1][i] == playerField && pole[2][i] == playerField)){
                 return true;
                }
                if ((pole[0][0] == playerField && pole[1][1] == playerField && pole[2][2] == playerField || pole[0][2] == playerField && pole[1][1] == playerField && pole[2][0] == playerField)){
                    return true;
                }
            }return false;
        }



}
