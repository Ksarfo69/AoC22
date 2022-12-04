package Day4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Cleaning {
    public static void main(String[] args) throws IOException {
        findInsideTeams();

        findOverlappingTeams();

    }


    public static void findInsideTeams() throws IOException {
        List<String> lines = Files.readAllLines(Path.of("src/main/resources/cleaning-input.txt"));

        int totalCount = 0;

        for(String line : lines)
        {
            String[] allElvesSections = line.split(",");

            String firstElf = allElvesSections[0];
            String secondElf = allElvesSections[1];

            String[] firstElfSplit = firstElf.split("-");
            String[] secondElfSplit = secondElf.split("-");

            int firstElfStart = Integer.valueOf(firstElfSplit[0]);
            int firstElfEnd = Integer.valueOf(firstElfSplit[1]);

            int secondElfStart = Integer.valueOf(secondElfSplit[0]);
            int secondElfEnd = Integer.valueOf(secondElfSplit[1]);


            if(firstElfStart>=secondElfStart && firstElfEnd<=secondElfEnd)
            {
                totalCount+=1;
            }
            else if(secondElfStart>=firstElfStart && secondElfEnd<=firstElfEnd)
            {
                totalCount+=1;
            }

        }

        System.out.println(totalCount);
    }


    public static void findOverlappingTeams() throws IOException {
        List<String> lines = Files.readAllLines(Path.of("src/main/resources/cleaning-input.txt"));

        int totalCount =0;
        for(String line : lines) {
            String[] allElvesSections = line.split(",");

            String firstElf = allElvesSections[0];
            String secondElf = allElvesSections[1];

            String[] firstElfSplit = firstElf.split("-");
            String[] secondElfSplit = secondElf.split("-");

            int firstElfStart = Integer.valueOf(firstElfSplit[0]);
            int firstElfEnd = Integer.valueOf(firstElfSplit[1]);

            int secondElfStart = Integer.valueOf(secondElfSplit[0]);
            int secondElfEnd = Integer.valueOf(secondElfSplit[1]);


            if(Math.abs(firstElfStart) <= Math.abs(secondElfEnd)
                    && Math.abs(firstElfEnd) >= Math.abs(secondElfStart)
                    || Math.abs(firstElfStart) >= Math.abs(secondElfEnd)
                    && Math.abs(secondElfEnd) >= Math.abs(firstElfStart)
            )
            {
                totalCount+=1;
            }
        }

        System.out.println(totalCount);
    }
}
