/* Написать игру «крестики-нолики». Участвуют 2 игрока — вы и компьютер. Перед началом игры
компьютер предлагает ввести ваше имя. Вы первый вводите номер ячейки и после каждого ввода
должна отображаться сетка 3×3 в консоли с занятой вами ячейкой. Компьютер ходит после вас.
Программа должна содержать классы и главный класс для запуска игры. Для этого создайте класс
Player, объекты которого будут создаваться в начале игры, а так же нужен будет объект Game,
в котором будут методы отрисовки поля и поиска победителя. */
package KrNol;

import java.util.Scanner;
public class Main {
    static int answer;
    public static void main(String[] args) {
        Player p = new Player();
        Game h = new Game();
        p.playAgain();
        answer = new Scanner(System.in).nextInt();
        if (answer == 1){
            Game q = new Game();
        }else System.out.println("*** До свидания ***");
    }
}