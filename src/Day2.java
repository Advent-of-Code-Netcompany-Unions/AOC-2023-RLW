import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Day2 {
    public static void main(String[] args) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("resources/day2.txt"));
        System.out.println(solveFirst(lines));
        System.out.println(solveSecond(lines));
    }


    private static int solveFirst(List<String> lines) {
        int sum = 0;

        for (String line : lines) {
            String game = line.split(":")[1];
            String[] rounds = game.trim().split(";");



            boolean pass = true;

            for (String round : rounds) {
                int reds = 0;
                int greens = 0;
                int blues = 0;

                String[] rolls = round.split(",");
                for (String roll : rolls) {
                    String[] split = roll.trim().split(" ");
                    int number = Integer.parseInt(split[0]);
                    String color = split[1];
                    if (color.equals("red")) {
                        reds += number;
                    }
                    if (color.equals("green")) {
                        greens += number;
                    }
                    if (color.equals("blue")) {
                        blues += number;
                    }
                }
                if (reds > 12 || greens > 13 || blues > 14) {
                    pass = false;
                }
            }

            if (pass) {
                int id = Integer.parseInt(line.split(":")[0].split(" ")[1]);
                sum += id;
            }
        }
        return sum;
    }


    private static int solveSecond(List<String> lines) {
        int sum = 0;

        for (String line : lines) {
            String game = line.split(":")[1];
            String[] rounds = game.trim().split(";");


            int redMin = 0;
            int greenMin = 0;
            int blueMin = 0;

            for (String round : rounds) {
                String[] rolls = round.split(",");
                for (String roll : rolls) {
                    String[] split = roll.trim().split(" ");
                    int number = Integer.parseInt(split[0]);
                    String color = split[1];
                    if (color.equals("red")) {
                        redMin = Math.max(number, redMin);
                    }
                    if (color.equals("green")) {
                        greenMin = Math.max(number, greenMin);
                    }
                    if (color.equals("blue")) {
                        blueMin = Math.max(number, blueMin);
                    }
                }
            }

            int power = redMin * greenMin * blueMin;
            sum += power;
        }
        return sum;
    }
}
