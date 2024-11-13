import java.util.Random;
import java.util.Scanner;
class GameBlackJack{
    public static void main(String[] args) {
        CardDesk desk = new CardDesk();
        int playerScore = 0;
        int dealerScore = 0;
        Scanner scanner = new Scanner(System.in);

        // Игрок получает две карты
        for (int i = 0; i < 2; i++) {
            playerScore += getCardValue(desk.dealCard());
            dealerScore += getCardValue(desk.dealCard());
        }

        System.out.println("Your score: " + playerScore);

        // Игровой процесс тут
        String input;
        do {
            System.out.print("Do you want to hit or stand? (h/s): ");
            input = scanner.nextLine();
            if (input.equals("h")) {
                playerScore += getCardValue(desk.dealCard());
                System.out.println("Your score: " + playerScore);
                if (playerScore > 21) {
                    System.out.println("You lost! Dealer win.");
                    return;
                }
            }
        } while (!input.equals("s"));

        // Дилер берет карты до 17
        while (dealerScore < 17) {
            dealerScore += getCardValue(desk.dealCard());
        }

        // Определение победителя
        System.out.println("Dealer's score: " + dealerScore);
        if (dealerScore > 21 || playerScore > dealerScore) {
            System.out.println("You win!");
        } else if (playerScore < dealerScore) {
            System.out.println("Dealer wins!");
        } else {
            System.out.println("It's a tie!");
        }
    }

    public static class CardDesk {
        private String[] cards;
        private boolean[] isCardDealt;
        private int currentCardIndex;

        //Вот конструктор вначале класса
        public CardDesk() {
            cards = new String[36];
            isCardDealt = new boolean[36];
            currentCardIndex = 0;
            initializeDeck();
            shuffleCards();
        }


        private void initializeDeck() {
            String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
            String[] values = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};

            int index = 0;
            for (int i = 0; i < suits.length; i++) {
                for (int j = 0; j < 9; j++) {
                    cards[index] = values[j] + " of " + suits[i];
                    index++;
                }
            }
        }

        // Перемешивание карт
        private void shuffleCards() {
            Random random = new Random();
            for (int i = 0; i < cards.length; i++) {
                int randomIndex = random.nextInt(cards.length);
                String temp = cards[i];
                cards[i] = cards[randomIndex];
                cards[randomIndex] = temp;
            }
        }

        // Получение следующей карты из колоды
        public String dealCard() {
            if (currentCardIndex >= cards.length) {
                return null;
            }
            return cards[currentCardIndex++];
        }

    }
    // Получение значения карты
    static int getCardValue(String card) {
        if (card == null) return 0;

        String value = card.split(" ")[0]; // Получаем значение карты
        switch (value) {
            case "Jack":
            case "Queen":
            case "King":
                return 10; // Фигурные карты
            case "Ace":
                return 11; // Туз это 11
            default:
                return Integer.parseInt(value); // Прочие карты
        }
    }
}