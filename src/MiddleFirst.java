/*Написать программу-калькулятор, у которого есть 4 метода: сложение, вычитание, умножение и деление.
Каждый метод принимает на вход 2 параметра. Программа предлагает сначала выбрать действие
(ввести с консоли), а затем ввести последовательно два аргумента. Например:
Введите действие: +
Введите первый аргумент: 10
Введите второй аргумент: 15
Результат: 25 */

import java.util.Scanner;

public class MiddleFirst {

    public static void main(String[] args) {

        System.out.println("Калькулятор");
        System.out.println("Выберите действие");
        char c = new Scanner(System.in).next().charAt(0);
        System.out.println("Введите первый аргумент");
        int a = new Scanner(System.in).nextInt();
        System.out.println("Введите второй аргумент");
        int b = new Scanner(System.in).nextInt();
        switch (c) {
            case '+':
                sum(a, b);
                break;
            case '-':
                difference(a, b);
                break;
            case '*':
                multiply(a, b);
                break;
            case '/':
                divide(a, b);
                break;
        }
    }

    private static void sum(int a, int b) {
        int result = a + b;
        System.out.println("Результат = " + result);
    }

    private static void difference(int a, int b) {
        int result = a - b;
        System.out.println("Результат = " + result);
    }

    private static void multiply(int a, int b) {
        int result = a * b;
        System.out.println("Результат = " + result);
    }

   private static void divide(int a, int b) {
        if (b == 0) {
            System.out.println("Деление на ноль невозможно");
            return;
        }
        int result = a / b;
        System.out.println("Результат = " + result);
    }


}
