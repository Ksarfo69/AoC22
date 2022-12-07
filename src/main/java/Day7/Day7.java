package Day7;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Day7 {

    public static void main(String[] args) throws IOException {
        List<String> lines = Files.readAllLines(Path.of("src/main/resources/file-system.txt"));

        Map<String, List<String>> folderStructure = new HashMap<>();

        for(int iter =0; iter < lines.size()-2; iter++)
        {
            if(lines.get(iter).startsWith("$ cd") && !lines.get(iter).equalsIgnoreCase("$ cd .."))
            {
                if(!folderStructure.containsKey(lines.get(iter)))
                {
                    folderStructure.put(lines.get(iter), new ArrayList<>());
                }
            }

            if(lines.get(iter+1).startsWith("$ ls"))
            {
                int localCount = iter+2;
                while(localCount<lines.size() && !lines.get(localCount).startsWith("$ cd"))
                {
                    folderStructure.get(lines.get(iter)).add(lines.get(localCount));
                    localCount+=1;
                }
            }
        }

        Map<String, Integer> mapOfSizes = new HashMap<>();

        for(Map.Entry<String, List<String>> files : folderStructure.entrySet())
        {

            int sizeCount =0;

            for(String file : files.getValue())
            {
                if(!file.startsWith("d"))
                {
                    sizeCount+= Integer.valueOf(file.split(" ")[0]);
                }
            }

            mapOfSizes.put(files.getKey(), sizeCount);

        }
        System.out.println(mapOfSizes);
        //System.out.println(folderStructure);
    }
}
