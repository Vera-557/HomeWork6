package KrNol;

import java.util.Scanner;

 class Game {
     static int answer;
    static final int SIZE = 3;
    static char[][] pole;
    static final char X = 'X';
    static final char O = '0';
    static final char EMPTY = '-';
    static Scanner scanner = new Scanner(System.in);
     public static void main(String[] args) {
         Player p = new Player();
         Game h = new Game();
         p.playAgain();
         answer = new Scanner(System.in).nextInt();
         if (answer == 1){
             Game q = new Game();
         }
     }
        public static void map(){
        System.out.println("Игровое поле");
        pole = new char[SIZE][SIZE];
        for( int i = 0; i < SIZE; i ++){
            for ( int j = 0; j < SIZE; j ++){
                pole[i][j] = EMPTY;
                //System.out.print(pole[i][j] + " ");

            }//System.out.println();
        }
    }
    public static void printMap(){
        for( int i = 0; i <= SIZE; i ++){
            System.out.print(i + " ");
        }
        System.out.println();
        for( int i = 0; i < SIZE; i ++){
            System.out.print((i + 1) + " ");
            for( int j = 0; j < SIZE; j ++){
                System.out.print(pole[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void hodIgroka() {
        int x, y;
        do {
            System.out.println("*** Введите координаты хода ***");
            System.out.println();
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
        } while (!isEmpty(x, y));
        pole[x][y] = X;

    }

    public static boolean isEmpty(int x, int y) {
        if (x < 0 || y < 0 || x >= SIZE || y >= SIZE) {
            return false;
        }
        if (pole[x][y] != EMPTY) {
            return false;
        }
        return true;
    }

    public static void hodComputer() {
        int x, y;
        System.out.println("*** Компьютер ходит ***");
        do {

            x = (int) (Math.random() * SIZE);
            y = (int) (Math.random() * SIZE);
        } while (!isEmpty(x, y));
        pole[x][y] = O;
    }

    public static boolean check() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (pole[i][j] == EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean checkWin(char playerField) {
        if (pole[0][0] == playerField && pole[0][1] == playerField && pole[0][2] == playerField) return true;
        if (pole[1][0] == playerField && pole[1][1] == playerField && pole[1][2] == playerField) return true;
        if (pole[2][0] == playerField && pole[2][1] == playerField && pole[2][2] == playerField) return true;

        if (pole[0][0] == playerField && pole[1][0] == playerField && pole[2][0] == playerField) return true;
        if (pole[0][1] == playerField && pole[1][1] == playerField && pole[2][1] == playerField) return true;
        if (pole[0][2] == playerField && pole[1][2] == playerField && pole[2][2] == playerField) return true;

        if (pole[0][0] == playerField && pole[1][1] == playerField && pole[2][2] == playerField) return true;
        if (pole[0][2] == playerField && pole[1][1] == playerField && pole[2][0] == playerField) return true;

        return false;
    }

    public Game() {
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
            if (check()) {
                System.out.println("*** Игра завершена. Ничья ***");
                break;
            }
        }

    }
}