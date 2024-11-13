package Battleship;

import java.util.Random;
import java.util.Scanner;

public class GameBattleShip {

    static char[][] map;
    static final int MAPSIZE = 10;
    static final char EMPTYFIELD = '~';
    static final char SHIP = '█';
    static Scanner scanner = new Scanner(System.in);
    private static final int SIZE = 10;
    private static char[][] board = new char[SIZE][SIZE];
    private static boolean[][] ship = new boolean[SIZE][SIZE];
    private static int [] shipsRemaining = {4, 3, 3, 2, 2, 2, 1, 1, 1, 1};
    static final char HIT = '֍';
    static final char MISS = 'X';

    public static void main(String[] args) {
        System.out.println("Компьютер расставляет свои корабли");
        initializeBoard();
        placeShips();
        printBoard();
        metodRazmeshenijaKorablejIgroka();
        hodComputer();
    }

    // Здесь моя карта и я размещаю мои корабли
    // Я сделала проверку размещения кораблей, но они все еще могут соприкасаться
    public static void initialMap() {
        map = new char[MAPSIZE][MAPSIZE];
        for (int i = 0; i < MAPSIZE; i++) {
            for (int j = 0; j < MAPSIZE; j++) {
                map[i][j] = EMPTYFIELD;
            }
        }
    }

    public static void printMap() {
        for (int i = 0; i <= MAPSIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < MAPSIZE; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < MAPSIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void playerTurn() {
        System.out.println("•••Размещаем 4 палубный кораблик•••");
        System.out.println("•••Ставим корабль по вертикали или горизонтали? •••\n •••1 = по-горизонтали •••\n •••любой другой символ = по-вертикали•••");
        int x, y, z;
        z = scanner.nextInt();// это выбор направления действия
        if (z == 1) {
            System.out.println("•••По-горизонтали•••\n*** Выберите координату отсчета ***\n Сначала строка(столб слева)\n");
            x = scanner.nextInt() - 1;
            while (x < 0 || x >= MAPSIZE) {
                System.out.println("Такие координаты ввести невозможно\n Попробуйте еще раз \n Сначала строка(столб слева)\n");
                x = scanner.nextInt() - 1;
            }
            y = scanner.nextInt() - 1;
            while (y < 0 || y >= 7) {
                //7 это максимально допустимое число для столбца, учитывая, что у корабля 4 палубы, а мы идем по горизонтали
                System.out.println("Такие координаты ввести невозможно\n Попробуйте еще раз \n");
                y = scanner.nextInt() - 1;
            }
            for (int i = 0; i < 4; i++) {
                map[x][y + i] = SHIP;
            }

        } else {
            System.out.println("•••По-вертикали•••\n*** Выберите координату отсчета ***\n Сначала строка(столб слева)\n");
            x = scanner.nextInt() - 1;
            while (x < 0 || x >= 7) {
                System.out.println("Такие координаты ввести невозможно\n Попробуйте еще раз \n Сначала строка(столб слева)\n");
                x = scanner.nextInt() - 1;
            }
            y = scanner.nextInt() - 1;
            while (y < 0 || y >= MAPSIZE) {
                System.out.println("Такие координаты ввести невозможно\n Попробуйте еще раз ");
                y = scanner.nextInt() - 1;
            }
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    map[x + j][y] = SHIP;
                }
            }

        }
    }

    public static void playerTurnThreeShip() {
        System.out.println("•••Размещаем 3 палубный кораблик•••");
        System.out.println("•••Ставим корабль по вертикали или горизонтали? •••\n •••1 = по-горизонтали •••\n •••любой другой символ = по-вертикали•••");
        int x, y, z;
        z = scanner.nextInt();
        if (z == 1) {

            System.out.println("•••По-горизонтали•••\n*** Выберите координату отсчета ***\n Сначала строка(столб слева)\n");
            x = scanner.nextInt() - 1;
            while (x < 0 || x >= MAPSIZE) {
                System.out.println("Такие координаты ввести невозможно\n Попробуйте еще раз \n Сначала строка(столб слева)\n");
                x = scanner.nextInt() - 1;
            }
            y = scanner.nextInt() - 1;
            while (y < 0 || y >= 8) {
                System.out.println("Такие координаты ввести невозможно\n Попробуйте еще раз \n");
                y = scanner.nextInt() - 1;
            }
            for (int i = 0; i < 3; i++) {
                map[x][y + i] = SHIP;
            }

        } else {

            System.out.println("•••По-вертикали•••\n*** Выберите координату отсчета ***\n Сначала строка(столб слева)\n");
            x = scanner.nextInt() - 1;
            while (x < 0 || x >= 8) {
                System.out.println("Такие координаты ввести невозможно\n Попробуйте еще раз \n Сначала строка(столб слева)\n");
                x = scanner.nextInt() - 1;
            }
            y = scanner.nextInt() - 1;
            while (y < 0 || y >= MAPSIZE) {
                System.out.println("Такие координаты ввести невозможно\n Попробуйте еще раз ");
                y = scanner.nextInt() - 1;
            }
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    map[x + j][y] = SHIP;
                }
            }


        }
    }

    public static void playerTurnTwoShip() {
        System.out.println("•••Размещаем 2 палубный кораблик•••");
        System.out.println("•••Ставим корабль по вертикали или горизонтали? •••\n •••1 = по-горизонтали •••\n •••любой другой символ = по-вертикали•••");
        int x, y, z;
        z = scanner.nextInt();
        if (z == 1) {

            System.out.println("•••По-горизонтали•••\n*** Выберите координату отсчета ***\n Сначала строка(столб слева)\n");
            x = scanner.nextInt() - 1;
            while (x < 0 || x >= MAPSIZE) {
                System.out.println("Такие координаты ввести невозможно\n Попробуйте еще раз \n Сначала строка(столб слева)\n");
                x = scanner.nextInt() - 1;
            }
            y = scanner.nextInt() - 1;
            while (y < 0 || y >= 9) {
                System.out.println("Такие координаты ввести невозможно\n Попробуйте еще раз \n");
                y = scanner.nextInt() - 1;
            }
            for (int i = 0; i < 2; i++) {
                map[x][y + i] = SHIP;
            }


        } else {

            System.out.println("•••По-вертикали•••\n*** Выберите координату отсчета ***\n Сначала строка(столб слева)\n");
            x = scanner.nextInt() - 1;
            while (x < 0 || x >= 9) {
                System.out.println("Такие координаты ввести невозможно\n Попробуйте еще раз \n Сначала строка(столб слева)\n");
                x = scanner.nextInt() - 1;
            }
            y = scanner.nextInt() - 1;
            while (y < 0 || y >= MAPSIZE) {
                System.out.println("Такие координаты ввести невозможно\n Попробуйте еще раз ");
                y = scanner.nextInt() - 1;
            }
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    map[x + j][y] = SHIP;
                }
            }


        }
    }

    public static void playerTurnOneShip() {
        System.out.println("•••Размещаем 1 палубный кораблик•••");
        int x, y;

        System.out.println("•••По-горизонтали•••\n*** Выберите координату отсчета ***\n Сначала строка(столб слева)\n");
        x = scanner.nextInt() - 1;
        while (x < 0 || x >= MAPSIZE) {
            System.out.println("Такие координаты ввести невозможно\n Попробуйте еще раз \n Сначала строка(столб слева)\n");
            x = scanner.nextInt() - 1;
        }
        y = scanner.nextInt() - 1;
        while (y < 0 || y >= MAPSIZE) {
            System.out.println("Такие координаты ввести невозможно\n Попробуйте еще раз ");
            y = scanner.nextInt() - 1;
        }
        map[x][y] = SHIP;


    }
    public static void metodRazmeshenijaKorablejIgroka(){
        initialMap();
        printMap();
        playerTurn();
        printMap();
        playerTurnThreeShip();
        printMap();
        playerTurnThreeShip();
        printMap();
        playerTurnTwoShip();
        printMap();
        playerTurnTwoShip();
        printMap();
        playerTurnTwoShip();
        printMap();
        playerTurnOneShip();
        printMap();
        playerTurnOneShip();
        printMap();
        playerTurnOneShip();
        printMap();
        playerTurnOneShip();
        printMap();
    }

  //Компьютер размещает корабли

    private static void initializeBoard() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = '~';
            }
        }
    }

    private static void placeShips() {
        Random random = new Random();
        for (int i = 0; i < shipsRemaining.length; i++) {
            for (int j = 0; j < shipsRemaining.length; j++) {
                int x, y;
                do {
                    x = random.nextInt(SIZE);
                    y = random.nextInt(SIZE);
                } while (ship[x][y]);
                ship[x][y] = true;
            }
        }
    }

    private static void printBoard() {
        System.out.println("Компьютерная доска:");
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void hodComputer() {
        int x, y;
        System.out.println("*** Компьютер ходит ***");

            x = (int) (Math.random() * MAPSIZE);
            y = (int) (Math.random() * MAPSIZE);

            if (map[x][y] == EMPTYFIELD){
                map[x][y] = MISS;
            } else if (map[x][y] == SHIP) {
                map[x][y] = HIT;
            } else hodComputer();//если тут уже был ход, то пусть вызовет себя заново

    }

    public static void hodIgroka() {
        int x, y;

        System.out.println("*** Введите координаты хода ***");
        System.out.println();
        x = scanner.nextInt() - 1;
        y = scanner.nextInt() - 1;

        if (ship[x][y]){
            board[x][y] = HIT;
        }else board[x][y] = MISS;

    }

// здесь не могу организовать для поля для выстрелов друг в друга и учета выстрелов
}
