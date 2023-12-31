import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Day7 {
    public static void main(String[] args) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("resources/day7.txt"));
        System.out.println(solveFirst(lines));
        System.out.println(solveSecond(lines));
    }

    private static int solveFirst(List<String> lines) {
        return 0;
    }

    private static int solveSecond(List<String> lines) {
        return 0;
    }

    private static class Hand {
        private String cards;

        public String getCards() {
            return cards;
        }
    }
}
