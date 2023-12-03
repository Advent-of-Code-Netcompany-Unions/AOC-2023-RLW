import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day3 {
    public static void main(String[] args) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("resources/day3.txt"));
        System.out.println(solveFirst(lines));
        System.out.println(solveSecond(lines));
    }

    private static List<String> toStringList(String s) {
        return new ArrayList<String>(Arrays.asList(s.split("")));
    }

    private static int solveFirst(List<String> lines) {
        List<Number> numbers = new ArrayList<>();
        for (int i = 0; i < lines.size(); i++) {
            List<String> split = toStringList(lines.get(i));
            String nextNumberToAdd = "";
            List<Coordinate> coordinatesToAdd = new ArrayList<>();
            boolean previousWasNumber = false;

            for (int j = 0; j < split.size(); j++) {
                String s = split.get(j);
                if (s.matches("\\d")) {
                    nextNumberToAdd += s;
                    coordinatesToAdd.add(new Coordinate(j, i));
                    previousWasNumber = true;
                    continue;
                }
                if (previousWasNumber) {
                    numbers.add(new Number(Integer.parseInt(nextNumberToAdd), coordinatesToAdd));
                    previousWasNumber = false;
                    nextNumberToAdd = "";
                    coordinatesToAdd = new ArrayList<>();
                }
            }
            if (previousWasNumber) {
                numbers.add(new Number(Integer.parseInt(nextNumberToAdd), coordinatesToAdd));
            }
        }

        List<Coordinate> symbols = new ArrayList<>();

        for (int i = 0; i < lines.size(); i++) {
            List<String> split = toStringList(lines.get(i));

            for (int j = 0; j < split.size(); j++) {
                String s = split.get(j);

                if (!s.matches("\\d") && !s.equals(".")) {
                    symbols.add(new Coordinate(j, i));
                }
            }
        }

        int sum = 0;

        for (Number number : numbers) {
            boolean alreadyCounted = false;
            for (Coordinate coordinate : number.getCoordinates()) {
                for (Coordinate symbol : symbols) {
                    if (coordinate.isAdjacent(symbol) && !alreadyCounted) {
                        sum += number.getNumber();
                        alreadyCounted = true;
                    }
                }
            }
        }

        return sum;
    }

    private static int solveSecond(List<String> lines) {
        List<Number> numbers = new ArrayList<>();

        for (int i = 0; i < lines.size(); i++) {
            List<String> split = toStringList(lines.get(i));
            String nextNumberToAdd = "";
            List<Coordinate> coordinatesToAdd = new ArrayList<>();
            boolean previousWasNumber = false;

            for (int j = 0; j < split.size(); j++) {
                String s = split.get(j);
                if (s.matches("\\d")) {
                    nextNumberToAdd += s;
                    coordinatesToAdd.add(new Coordinate(j, i));
                    previousWasNumber = true;
                    continue;
                }
                if (previousWasNumber) {
                    numbers.add(new Number(Integer.parseInt(nextNumberToAdd), coordinatesToAdd));
                    previousWasNumber = false;
                    nextNumberToAdd = "";
                    coordinatesToAdd = new ArrayList<>();
                }
            }
            if (previousWasNumber) {
                numbers.add(new Number(Integer.parseInt(nextNumberToAdd), coordinatesToAdd));
            }
        }

        List<Coordinate> stars = new ArrayList<>();

        for (int i = 0; i < lines.size(); i++) {
            List<String> split = toStringList(lines.get(i));

            for (int j = 0; j < split.size(); j++) {
                String s = split.get(j);

                if (s.equals("*")) {
                    stars.add(new Coordinate(j, i));
                }
            }
        }

        int sum = 0;


        for (Coordinate star : stars) {
            int matches = 0;
            int product = 0;
            for (Number number : numbers) {
                for (Coordinate coordinate : number.getCoordinates()) {
                    if (star.isAdjacent(coordinate)) {
                        if (matches == 0) {
                            product = number.getNumber();
                        }
                        if (matches == 1) {
                            product = product * number.getNumber();
                        }
                        matches++;
                        break;
                    }
                }
            }
            if (matches == 2) {
                sum += product;
            }
        }

        return sum;
    }

    private static class Number {
        private int number;

        private List<Coordinate> coordinates;

        public Number(int number, List<Coordinate> coordinates) {
            this.number = number;
            this.coordinates = coordinates;
        }

        public int getNumber() {
            return number;
        }

        public List<Coordinate> getCoordinates() {
            return coordinates;
        }
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

        public boolean isAdjacent(Coordinate other) {
            return Math.abs(this.getX() - other.getX()) <= 1 &&
                    Math.abs(this.getY() - other.getY()) <= 1;
        }
    }
}
