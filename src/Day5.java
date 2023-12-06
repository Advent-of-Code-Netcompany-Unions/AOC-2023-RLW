import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Day5 {
    public static void main(String[] args) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("resources/day5.txt"));
        System.out.println(solveFirst(lines));
        System.out.println(solveSecond(lines));
    }

    private static long solveFirst(List<String> lines) {
        List<Long> source = Arrays.stream(lines.get(0).split(":")[1].trim().split(" ")).map(Long::parseLong).toList();

        List<Long> destination = new ArrayList<>();
        HashMap<Long, Long> mapped = new HashMap<>();

        for (int i = 3; i < lines.size(); i++) {
            if (lines.get(i).isBlank()) {
                continue;
            }
            if (lines.get(i).contains(":")) {
                for (Long s : source) {
                    if (!mapped.containsKey(s)) {
                        destination.add(s);
                    }
                }

                source = destination;
                destination = new ArrayList<>();
                mapped = new HashMap<>();
                continue;
            }

            List<Long> ints = Arrays.stream(lines.get(i).split(" ")).map(String::trim).map(Long::parseLong).toList();
            long destinationRange = ints.get(0);
            long sourceRange = ints.get(1);
            long rangeLength = ints.get(2);

            for (Long s : source) {
                if (s >= sourceRange && s < sourceRange + rangeLength) {
                    long newDestination = (s - sourceRange) + destinationRange;
                    destination.add(newDestination);
                    mapped.put(s, newDestination);
                }
            }
        }

        for (Long s : source) {
            if (!mapped.containsKey(s)) {
                destination.add(s);
            }
        }


        return destination.stream().min(Comparator.naturalOrder()).get();
    }

    private static int solveSecond(List<String> lines) {
        return 0;
    }

}
