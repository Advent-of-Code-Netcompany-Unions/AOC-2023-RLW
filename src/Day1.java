import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class Day1 {
    public static void main(String[] args) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("resources/day1.txt"));
        //System.out.println(solveFirst(lines));
        System.out.println(solveSecond(lines));
    }

    private static int solveFirst(List<String> lines) {
        int i = 0;
        for (String line : lines) {
            int n1 = line.chars().filter(n -> n > 47 && n < 58).findFirst().getAsInt() - 48;
            int[] array = line.chars().filter(n -> n > 47 && n < 58).toArray();
            int n2 = array[array.length - 1] - 48;

            String s1 = String.valueOf(n1);
            String s2 = String.valueOf(n2);

            String s3 = s1 + s2;
            int result = Integer.valueOf(s3);

            i+=result;
        }

        return i;
    }

    private static int solveSecond(List<String> lines) {
        int n = 0;
        for (String line : lines) {
            int[] firstArr = new int[] {line.indexOf("one"), line.indexOf("two"), line.indexOf("three"), line.indexOf("four"), line.indexOf("five"),
                    line.indexOf("six"), line.indexOf("seven"), line.indexOf("eight"), line.indexOf("nine"), line.indexOf("1"), line.indexOf("2"),
                    line.indexOf("3"), line.indexOf("4"), line.indexOf("5"), line.indexOf("6"), line.indexOf("7"), line.indexOf("8"), line.indexOf("9")};

            int[] lastArr = new int[] {line.lastIndexOf("one"), line.lastIndexOf("two"), line.lastIndexOf("three"), line.lastIndexOf("four"),
                    line.lastIndexOf("five"), line.lastIndexOf("six"), line.lastIndexOf("seven"), line.lastIndexOf("eight"),
                    line.lastIndexOf("nine"), line.lastIndexOf("1"), line.lastIndexOf("2"), line.lastIndexOf("3"), line.lastIndexOf("4"),
                    line.lastIndexOf("5"), line.lastIndexOf("6"), line.lastIndexOf("7"), line.lastIndexOf("8"), line.lastIndexOf("9")};

            int first = Arrays.stream(firstArr).filter(num -> num != -1).min().getAsInt();
            int last = Arrays.stream(lastArr).max().getAsInt();

            int n1 = 0;

            for (int i = 0; i < firstArr.length; i++) {
                if (firstArr[i] == first) {
                    if (i < 9) {
                        n1 = i+1;
                    }
                    else {
                        n1 = i-8;
                    }
                }
            }

            int n2 = 0;

            for (int i = 0; i < lastArr.length; i++) {
                if (lastArr[i] == last) {
                    if (i < 9) {
                        n2 = i+1;
                    }
                    else {
                        n2 = i-8;
                    }
                }
            }

            String s1 = String.valueOf(n1);
            String s2 = String.valueOf(n2);

            String s3 = s1 + s2;
            int result = Integer.valueOf(s3);

            n+=result;

        }
        return n;
    }

}
