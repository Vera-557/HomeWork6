/*Написать программу-калькулятор, у которого есть 4 метода: сложение, вычитание, умножение и деление.
Каждый метод принимает на вход 2 параметра. Программа предлагает сначала выбрать действие
(ввести с консоли), а затем ввести последовательно два аргумента. Например:
Введите действие: +
Введите первый аргумент: 10
Введите второй аргумент: 15
Результат: 25 */
import java.util.Scanner;
public class MiddleFirst {
    static int a;
    static int b;
    static char c;
    static int result;
    public static void main(String[] args) {
        System.out.println("Калькулятор");
        System.out.println("Выберите действие");
        c = new Scanner(System.in).next().charAt(0);
        System.out.println("Введите первый аргумент");
        a = new Scanner(System.in).nextInt();
        System.out.println("Введите второй аргумент");
        b = new Scanner(System.in).nextInt();
        switch(c){
            case '+': sum(a,b);
            System.out.println("Результат = " + result);
            break;
            case '-': difference(a,b);
                System.out.println("Результат = " + result);
                break;
            case '*': multiply(a,b);
                System.out.println("Результат = " + result);
                break;
            case '/': divide(a,b);
                System.out.println("Результат = " + result);
                break;
        }


    }

    public static int sum(int a, int b) {
        MiddleFirst.a = a;
        MiddleFirst.b = b;
        MiddleFirst.result = a + b;
        return result;
    }

    public static int difference(int a, int b) {
        MiddleFirst.a = a;
        MiddleFirst.b = b;
        MiddleFirst.result = a - b;
        return result;
    }

    public static int multiply(int a, int b) {
        MiddleFirst.a = a;
        MiddleFirst.b = b;
        MiddleFirst.result = a * b;
        return result;
    }

    public static int divide(int a, int b) {
        MiddleFirst.a = a;
        MiddleFirst.b = b;
        MiddleFirst.result = a / b;
        return result;
    }
}
