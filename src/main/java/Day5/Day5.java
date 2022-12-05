package Day5;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Day5 {
    public static void main(String[] args) throws IOException {
        List<String> lines = Files.readAllLines(Path.of("src/main/resources/stack-input.txt"));


        Map<Integer, String> stack = new HashMap<>();


        int iter = 0;
        int hashIndex = 1;


        //8
        while(iter < 3)
        {
            stack.put(hashIndex, lines.get(iter));
            hashIndex+=1;
            iter+=1;
        }

        System.out.println(stack);

        //10
        for(int i = 5; i<lines.size(); i++)
        {
            String line = lines.get(i);

            String[] splittedLine = line.split(" ");

            int moveQuantity = Integer.valueOf(splittedLine[1]);

            int origin = Integer.valueOf(splittedLine[3]);

            int destination = Integer.valueOf(splittedLine[5]);


            int moveIterator = 0;

            List<String> originStack = new ArrayList<>();
            List<String> destinationStack = new ArrayList<>();

            for(String row : stack.values())
            {
                String[] splittedRow = row.split(" ");

                System.out.println(Arrays.toString(splittedRow));
                originStack.add(splittedRow[origin-1]);
                destinationStack.add(splittedRow[destination-1]);
                return;
            }

            System.out.println(originStack);

//            List<String> destinationStack = new ArrayList<>();
//
//            for(String row : stack.values())
//            {
//                String[] splittedRow = row.split(" ");
//
//                originStack.add(splittedRow[destination]);
//
//            }
        }

    }
}
