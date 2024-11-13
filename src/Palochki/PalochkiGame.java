/* Написать игру «Палочки»
Играют два игрока (вы и компьютер). В консоли компьютер выводит 20 палочек.
По очереди игрок и компьютер должны снимать 1, 2 или 3 палочки. Каждый шаг компьютер
отрисовывает оставшиеся палочки в консоль. Победителем считается тот, кто оставил своему оппоненту одну палочку. */
package Palochki;

import java.util.Arrays;
import java.util.Scanner;

public class PalochkiGame {

    static final int MAX_VALUE = 3;
    static final int MIN_VALUE = 1;
    static final int WANDS_COUNT = 20;
    static char wand = '|';
    static char[] polePalochek;
    static char value = '*';
    static int answer = 0;
    static int schet = 0;

    public static void main(String[] args) {
        vivodPoleNaEkran();
        PalochkiGame sticks = new PalochkiGame();
    }

    protected PalochkiGame(){
        while (true) {
            otwetIgrokow();
            if (checkWinner()){
                System.out.println("Вы выиграли");
                break;
            }
            computerMove();
            if (checkWinner()){
                System.out.println("Компьютер выиграл");
                break;
            }

        }

    }

    protected static void vivodPoleNaEkran() {
        polePalochek = new char[WANDS_COUNT];
        Arrays.fill(polePalochek, wand);
        System.out.println("Перед вами 20 палочек: " + Arrays.toString(polePalochek));
    }

    protected static void otwetIgrokow() {
        if (schet > 0) {
            //System.out.println("shag " + schet);
            System.out.println("Игрок вводит число от 1 до 3 ");
            answer = answer + new Scanner(System.in).nextInt();

            for (int i = 0; i < answer; i++) {
                polePalochek[i] = value;
            }
            System.out.println("Summa " + answer);
            System.out.println("Игрок забрал палочки: " + Arrays.toString(polePalochek));
            schet++;
        }
        if(schet == 0){
            //System.out.println("shag " + schet);
            System.out.println("Игрок вводит число от 1 до 3 ");
            answer = new Scanner(System.in).nextInt();
            while (true) {
                if (MIN_VALUE <= answer && answer <= MAX_VALUE) {
                    for (int i = 0; i < answer; i++) {
                        polePalochek[i] = value;
                    }
                    System.out.println("Игрок забрал палочки: " + Arrays.toString(polePalochek));
                    schet++;
                    break;
                }
                System.out.println("Вы ввели не верное значение");
            }
        }


    }

    protected static void computerMove() {
        System.out.println("Компьютер вводит число от 1 до 3 ");
        int kk = (int) (Math.random() * MAX_VALUE + MIN_VALUE);
        System.out.println(kk);
        answer = answer + kk;

        System.out.println("suma " + answer);
        for (int i = 0; i < answer; i++) {
            polePalochek[i] = value;
        }
        System.out.println("Компьютер забрал палочки: " + Arrays.toString(polePalochek));
    }

    protected static boolean checkWinner (){
        if (answer >= 19) {
            System.out.println("Finish");
            return true;
        }
        return false;
    }
    // не могу придумать проверку для второго и следующих ходов игрока, так как сумма предыдущих шагов уже будет больше чем 3
}




