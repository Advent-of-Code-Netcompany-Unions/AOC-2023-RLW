import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day3 {
    public static void main(String[] args) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("resources/day3.txt"));
        System.out.println(solveFirst(lines));
        System.out.println(solveSecond(lines));
    }

    private static int solveFirst(List<String> lines) {

        for (String line : lines) {
            List<String> numbers = new ArrayList<>();
            Matcher m = Pattern.compile("\\d+")
                    .matcher(line);
            while (m.find()) {
                numbers.add(m.group());
            }

            Map<String, List<Coordinate>> positions = new HashMap<>();

            for (String number : numbers) {
                positions.put(number, );
                line.indexOf()
            }


            int n = 0;
        }


        char[][] arr = new char[10][];
        for (int i = 0; i < lines.size(); i++) {
            char[] chars = lines.get(i).toCharArray();
            arr[i] = chars;
        }

        int currentIndex = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] > 47 && arr[i][j] < 58) {

                }
            }
        }

        return 0;
    }

    private static int solveSecond(List<String> lines) {
        return 0;
    }

    private static class Coordinate {
        private int x;
        private int y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }
}
