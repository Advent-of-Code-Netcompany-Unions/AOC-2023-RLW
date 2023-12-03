import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class DayTemplate {
    public static void main(String[] args) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("resources/day3.txt"));
        System.out.println(solveFirst(lines));
        System.out.println(solveSecond(lines));
    }

    private static int solveFirst(List<String> lines) {

        char[][] arr = new char[10][];
        for (int i = 0; i < lines.size(); i++) {
            char[] chars = lines.get(i).toCharArray();
            arr[i] = chars;
        }

        return 0;
    }

    private static int solveSecond(List<String> lines) {
        return 0;
    }
}
