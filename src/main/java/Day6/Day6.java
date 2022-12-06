package Day6;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Day6 {
    public static void main(String[] args) throws IOException {

        partOne();

        partTwo();

    }


    public static void partOne() throws IOException {
        List<String> lines = Files.readAllLines(Path.of("src/main/resources/marker-input.txt"));



        for(String line : lines)
        {
            int l = 0;
            int r = l+1;
            Set<String> letterSet = new HashSet<>();

            while(l < r && r<line.length()-1)
            {
                if(r<=l+3)
                {
                    letterSet.add(String.valueOf(line.charAt(r)));
                    r+=1;
                }
                else {
                    letterSet.add(String.valueOf(line.charAt(l)));

                    if(letterSet.size() == 4)
                    {
                        System.out.println(r);
                        break;
                    }
                    letterSet = new HashSet<>();
                    l+=1;
                    r=l+1;
                }
            }
        }
    }


    public static void partTwo() throws IOException {
        List<String> lines = Files.readAllLines(Path.of("src/main/resources/marker-input.txt"));



        for(String line : lines)
        {
            int l = 0;
            int r = l+1;
            Set<String> letterSet = new HashSet<>();

            while(l < r && r<line.length()-1)
            {
                if(r<=l+13)
                {
                    letterSet.add(String.valueOf(line.charAt(r)));
                    r+=1;
                }
                else {
                    letterSet.add(String.valueOf(line.charAt(l)));

                    if(letterSet.size() == 14)
                    {
                        System.out.println(r);
                        break;
                    }
                    letterSet = new HashSet<>();
                    l+=1;
                    r=l+1;
                }
            }
        }
    }
}
