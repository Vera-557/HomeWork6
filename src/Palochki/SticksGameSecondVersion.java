package Palochki;
import java.util.Scanner;
public class SticksGameSecondVersion {

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int sticks = 20;
            char visualSticks = '|';

            System.out.println("Начинаем игру 'Палочки'!");
            System.out.println("Дано 20 палочек. Вы должны оставить 1 палочку своему противнику.");
          //Рисую 20 палок
            for (int i = 0; i <= sticks; i++){
                System.out.print(visualSticks);
            }
            System.out.println();
            while (sticks > 1) {
                // Ход игрока
                System.out.println("Осталось палочек: " + sticks);
                System.out.print("Сколько палочек снимете? (1, 2 или 3): ");
                int playerMove = scanner.nextInt();
                //рисую палки минус ход игрока
                for (int i = 0; i <= (sticks - playerMove); i++){
                    System.out.print(visualSticks);
                } System.out.println();

                // Проверьте, что ход игрока корректен
                while (playerMove < 1 || playerMove > 3 || playerMove > sticks) {
                    System.out.print("Некорректный ход. Снимите 1, 2 или 3 палочки: ");
                    playerMove = scanner.nextInt();
                }

                sticks -= playerMove;

                // Проверка на победу
                if (sticks == 1) {
                    System.out.println("Вы оставили 1 палочку компу! Вы выиграли.");
                    break;
                }

                // Ход компьютера
                int computerMove = Math.min(3, sticks - 1); // Компьютер старательно оставляет 1 палочку
                sticks -= computerMove;
                System.out.println("Компьютер снимает " + computerMove + " палочек.");
                for (int i = 0; i <= (sticks - computerMove); i++){
                    System.out.print(visualSticks);
                } System.out.println();
                // Проверка на победу
                if (sticks == 1) {
                    System.out.println("Компьютер оставил вам 1 палочку! Вы проиграли!");
                    break;
                }
                //  в ходе компа палки отображаются не корректно по счету, не понимаю почему
            }

            System.out.println("Игра окончена. Спасибо за игру!");
            scanner.close();
        }


}
