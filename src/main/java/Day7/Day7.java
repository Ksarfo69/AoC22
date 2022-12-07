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

        System.out.println(folderStructure);

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

            mapOfSizes.put(files.getKey().split(" ")[2], sizeCount);

        }

        System.out.println(mapOfSizes);

        Map<String, Integer> mapOfFinalSizes = new HashMap<>();

        for(Map.Entry<String, List<String>> line : folderStructure.entrySet())
        {
            int sizeCount = 0;

            for(String f : line.getValue())
            {
                if(f.startsWith("dir"))
                {
                    if(mapOfFinalSizes.containsKey("$ cd " + f.split(" ")[1]))
                    {
                        sizeCount+= mapOfFinalSizes.get("$ cd " + f.split(" ")[1]);
                    }
                    else
                    {
                        sizeCount+= mapOfSizes.get(f.split(" ")[1]);
                    }
                }
                else
                {
                    sizeCount+= Integer.valueOf(f.split(" ")[0]);
                }
            }

            mapOfFinalSizes.put(line.getKey(), sizeCount);
        }

        System.out.println(mapOfFinalSizes);


        int result = 0;
        for(Integer size : mapOfFinalSizes.values())
        {
            if(size <= 100000)
            {
                result+=size;
            }
        }

        System.out.println(result);
    }
}
