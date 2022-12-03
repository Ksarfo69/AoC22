package Day3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Compartments {
    public static void main(String[] args) throws IOException {
        commonBadgeInLine();

        threeElfGroupBadge();
    }


    public static void commonBadgeInLine() throws IOException {
        List<String> lines = Files.readAllLines(Path.of("src/main/resources/compartment-input.txt"));

        int totalCount = 0;

        for(String line : lines)
        {
            String firstPart = line.substring(0, line.length()/2);
            String secondPart = line.substring(line.length()/2);


            Set<Character> firstPartSet = secondPart.chars().mapToObj(e->(char)e).collect(Collectors.toSet());
            Set<Character> secondPartSet = firstPart.chars().mapToObj(e->(char)e).collect(Collectors.toSet());


            for(Character letter : secondPartSet)
            {
                if(firstPartSet.contains(letter))
                {
                    if(letter>='A' && letter<='Z')
                        totalCount+= (int)letter - 'A'+1 + 26;
                    if(letter>='a' && letter<= 'z')
                        totalCount+= (int)letter - 'a'+1;
                }
            }

        }

        System.out.println(totalCount);
    }


    public static void threeElfGroupBadge() throws IOException {
        List<String> lines = Files.readAllLines(Path.of("src/main/resources/compartment-input.txt"));

        int totalCount = 0;

        for (int iter = 0; iter < lines.size(); iter += 3) {
            String firstPart = lines.get(iter);
            String secondPart = lines.get(iter+1);
            String thirdPart = lines.get(iter+2);


            Set<Character> firstPartSet = secondPart.chars().mapToObj(e -> (char) e).collect(Collectors.toSet());
            Set<Character> secondPartSet = firstPart.chars().mapToObj(e -> (char) e).collect(Collectors.toSet());
            Set<Character> thirdPartSet = thirdPart.chars().mapToObj(e -> (char) e).collect(Collectors.toSet());


            for (Character letter : thirdPartSet) {
                if (firstPartSet.contains(letter) && secondPartSet.contains(letter) ) {
                    if (letter >= 'A' && letter <= 'Z')
                        totalCount += (int) letter - 'A' + 1 + 26;
                    if (letter >= 'a' && letter <= 'z')
                        totalCount += (int) letter - 'a' + 1;
                }
            }

        }

        System.out.println(totalCount);
    }
}
