import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class Day6 {
    public static void main(String[] args) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("resources/day6.txt"));
        System.out.println(solveFirst(lines));
        System.out.println(solveSecond(lines));
    }

    private static int solveFirst(List<String> lines) {
        List<Integer> times = Arrays.stream(lines.get(0).split(":")[1].trim().split(" ")).filter(s -> !s.isBlank()).map(String::trim).map(Integer::valueOf).toList();
        List<Integer> distances = Arrays.stream(lines.get(1).split(":")[1].trim().split(" ")).filter(s -> !s.isBlank()).map(String::trim).map(Integer::valueOf).toList();

        int result = 1;
        for (int i = 0; i < times.size(); i++) {
            int records = 0;
            int time = times.get(i);
            int distanceRequirement = distances.get(i);

            for (int j = 0; j < time+1; j++) {
                int travelDistance = j * (time-j);
                if (travelDistance > distanceRequirement) {
                    records++;
                }
            }

            result = result * records;
        }
        return result;
    }

    private static long solveSecond(List<String> lines) {
        long time = Long.parseLong(Arrays.stream(lines.get(0).split(":")[1].trim().split(" ")).filter(s -> !s.isBlank()).map(String::trim).reduce("", String::concat));
        long distanceRequirement = Long.parseLong(Arrays.stream(lines.get(1).split(":")[1].trim().split(" ")).filter(s -> !s.isBlank()).map(String::trim).reduce("", String::concat));

        long result = 1;
            int records = 0;

            for (long j = 0; j < time+1; j++) {
                long travelDistance = j * (time-j);
                if (travelDistance > distanceRequirement) {
                    records++;
                }
            }

            result = result * records;

        return result;
    }
}
