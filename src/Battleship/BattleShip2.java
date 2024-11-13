package Battleship;

import java.util.Random;
import java.util.Scanner;

public class BattleShip2 {


    public static void main(String[] args) {
        Field playerField = new Field();
        Field computerField = new Field();
        computerField.placeShips();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Расставьте свои корабли (формат: x y, где x = 0-9, y = 0-9):");
        playerField.placeShipsManually(scanner);

        while (true) {
            playerTurn(computerField, scanner);
            if (computerField.isAllShipsSunk()) {
                System.out.println("Вы выиграли!");
                break;
            }
            computerTurn(playerField);
            if (playerField.isAllShipsSunk()) {
                System.out.println("Компьютер выиграл!");
                break;
            }
        }

        scanner.close();
    }

    private static void playerTurn(Field opponentField, Scanner scanner) {
        int x, y;
        do {
            System.out.print("Введите координаты для атаки (x y): ");
            x = scanner.nextInt();
            y = scanner.nextInt();
        } while (!opponentField.isValidCoordinate(x, y));

        if (opponentField.attack(x, y)) {
            System.out.println("Попадание!");
        } else {
            System.out.println("Промах!");
        }
    }

    private static void computerTurn(Field playerField) {
        Random rand = new Random();
        int x, y;
        do {
            x = rand.nextInt(10);
            y = rand.nextInt(10);
        } while (!playerField.isValidCoordinate(x, y));

        if (playerField.attack(x, y)) {
            System.out.println("Компьютер попал в ваш корабль!");
        } else {
            System.out.println("Компьютер промахнулся!");
        }
    }


    static class Field {
        private int[][] field = new int[10][10];
        private Random random = new Random();

        public Field() {
            // Инициализация поля
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    field[i][j] = 0; // 0 — пустая клетка
                }
            }
        }

        public void placeShips() {
            placeShip(4, 1); // 1 четырехклеточный корабль
            placeShip(3, 2); // 2 трехклеточных корабля
            placeShip(2, 3); // 3 двухклеточных корабля
            placeShip(1, 4); // 4 одноклеточных корабля
        }

        private void placeShip(int length, int count) {
            for (int n = 0; n < count; n++) {
                boolean placed = false;
                while (!placed) {
                    int direction = random.nextInt(2); // 0 - горизонтально, 1 - вертикально
                    int x, y;

                    if (direction == 0) { // Горизонтально
                        x = random.nextInt(10);
                        y = random.nextInt(10 - length);
                        if (canPlaceShip(x, y, length, direction)) {
                            for (int i = 0; i < length; i++) {
                                field[x][y + i] = 1; // 1 — корабль
                            }
                            placed = true;
                        }
                    } else { // Вертикально
                        x = random.nextInt(10 - length);
                        y = random.nextInt(10);
                        if (canPlaceShip(x, y, length, direction)) {
                            for (int i = 0; i < length; i++) {
                                field[x + i][y] = 1; // 1 — корабль
                            }
                            placed = true;
                        }
                    }
                }
            }
        }

        private boolean canPlaceShip(int x, int y, int length, int direction) {
            for (int i = 0; i < length; i++) {
                if (direction == 0 && field[x][y + i] != 0) { // Горизонтально
                    return false;
                } else if (direction == 1 && field[x + i][y] != 0) { // Вертикально
                    return false;
                }
            }
            return true;
        }

        public void placeShipsManually(Scanner scanner) {
            for (int i = 0; i < 1; i++) {
                placeShipManually(4, 1, scanner);
            }
            for (int i = 0; i < 2; i++) {
                placeShipManually(3, 2, scanner);
            }
            for (int i = 0; i < 3; i++) {
                placeShipManually(2, 3, scanner);
            }
            for (int i = 0; i < 4; i++) {
                placeShipManually(1, 4, scanner);
            }
        }

        private void placeShipManually(int length, int count, Scanner scanner) {
            for (int n = 0; n < count; n++) {
                boolean placed = false;
                while (!placed) {
                    System.out.println("Введите координаты для " + length + "-клеточного корабля (например, 0 0 для A1):");
                    int x = scanner.nextInt();
                    int y = scanner.nextInt();
                    int direction = chooseDirection(scanner);

                    if (canPlaceShip(x, y, length, direction)) {
                        for (int i = 0; i < length; i++) {
                            if (direction == 0) {
                                field[x][y + i] = 1;
                            } else {
                                field[x + i][y] = 1;
                            }
                        }
                        placed = true;
                        System.out.println("Корабль установлен.");
                    } else {
                        System.out.println("Невозможно разместить корабль. Попробуйте снова.");
                    }
                }
            }
        }

        private int chooseDirection(Scanner scanner) {
            System.out.println("Выберите направление: 0 - горизонтально, 1 - вертикально");
            return scanner.nextInt();
        }

        public boolean attack(int x, int y) {
            if (field[x][y] == 1) {
                field[x][y] = 2; // 2 — подбитый корабль
                return true;
            }
            return false;
        }

        public boolean isValidCoordinate(int x, int y) {
            return x >= 0 && x < 10 && y >= 0 && y < 10;
        }

        public boolean isAllShipsSunk() {
            for (int[] row : field) {
                for (int cell : row) {
                    if (cell == 1) {
                        return false; // Есть не подбитый корабль
                    }
                }
            }
            return true; // Все корабли подбиты
        }
    }

//выбрасывает исключения
}


