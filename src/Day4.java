import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class Day4 {
    public static void main(String[] args) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("resources/day4.txt"));
        System.out.println(solveFirst(lines));
        System.out.println(solveSecond(lines));
    }

    private static int solveFirst(List<String> lines) {
        List<Card> cards = new ArrayList<>();

        for (String line : lines) {
            String s = line.split(":")[1];
            String[] split = s.split("\\|");
            List<Integer> winningNumbers = Arrays.stream(split[0].trim().split(" ")).filter(str -> !str.isBlank()).map(Integer::valueOf).toList();
            List<Integer> numbers = Arrays.stream(split[1].trim().split(" ")).filter(str -> !str.isBlank()).map(Integer::valueOf).toList();
            cards.add(new Card(winningNumbers, numbers));
        }


        return cards.stream().map(Card::calculateScore).reduce(0, Integer::sum);
    }

    private static int solveSecond(List<String> lines) {
        Map<Integer, Card> cards = new TreeMap<>();

        int n = 1;
        for (String line : lines) {
            String s = line.split(":")[1];
            String[] split = s.split("\\|");
            List<Integer> winningNumbers = Arrays.stream(split[0].trim().split(" ")).filter(str -> !str.isBlank()).map(Integer::valueOf).toList();
            List<Integer> numbers = Arrays.stream(split[1].trim().split(" ")).filter(str -> !str.isBlank()).map(Integer::valueOf).toList();
            cards.put(n, new Card(winningNumbers, numbers));
            n++;
        }

        for (Map.Entry<Integer, Card> e : cards.entrySet()) {
            int matches = e.getValue().calculateMatches();
            List<Card> cardsWon = new ArrayList<>();
            for (int i = 1; i <= matches; i++) {
                cardsWon.add(cards.get(e.getKey() + i));
            }

            e.getValue().setWonCards(cardsWon);
        }

        return cards.values().stream().map(Card::calculateWonCardsRec).reduce(0, Integer::sum);

    }

    private static class Card {
        private List<Integer> winningNumbers;

        private List<Integer> numbers;

        private List<Card> wonCards;

        public Card(List<Integer> winningNumbers, List<Integer> numbers) {
            this.winningNumbers = winningNumbers;
            this.numbers = numbers;
        }

        public void setWonCards(List<Card> wonCards) {
            this.wonCards = wonCards;
        }

        public int calculateWonCardsRec() {
            int count = 1;
            for (Card wonCard : wonCards) {
                count += wonCard.calculateWonCardsRec();
            }
            return count;
        }

        public int calculateMatches() {
            int count = 0;

            for (Integer number : numbers) {
                if (winningNumbers.contains(number)) {
                    count++;
                }
            }
            return count;
        }

        public int calculateScore() {
            int score = 0;

            for (Integer number : numbers) {
                if (winningNumbers.contains(number)) {
                    if (score == 0) {
                        score = 1;
                    }
                    else {
                        score = score * 2;
                    }
                }
            }

            return score;
        }
    }
}
