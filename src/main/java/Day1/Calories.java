package Day1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class Calories {

    public static void main(String[] args) throws IOException {
        findElfWithMostCalories();
        top3ElvesWithMostCalories();
    }


    public static void findElfWithMostCalories() throws IOException {

        List<String> lines = Files.readAllLines(Path.of("src/main/resources/calorie-input.txt"));


        Integer max = 0;
        Integer runningSum = 0;

        for (String number : lines) {
            if (!number.equalsIgnoreCase("")) {
                runningSum += Integer.valueOf(number);
            } else {
                max = Math.max(runningSum, max);
                runningSum = 0;
            }
        }

        System.out.println(max);
    }


    public static void top3ElvesWithMostCalories() throws IOException {
        List<String> lines = Files.readAllLines(Path.of("src/main/resources/calorie-input.txt"));


        Set<Integer> sums = new HashSet<>();
        Integer runningSum = 0;

        for (String number : lines) {
            if (!number.equalsIgnoreCase("")) {
                runningSum += Integer.valueOf(number);
            } else {
                sums.add(runningSum);
                runningSum = 0;
            }
        }

        System.out.println(sums.stream().sorted(Comparator.reverseOrder())
                .limit(3)
                .reduce(0, (acc , num) -> acc+num));

    }
}
