package Day5;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Day5 {
    public static void main(String[] args) throws IOException {
        List<String> lines = Files.readAllLines(Path.of("src/main/resources/stack-input.txt"));


        Map<Integer, List> stack = new HashMap<>();


        int iter = 0;
        int hashIndex = 1;


        //8
            for(int i = 2; i>=0; i--) {
                String line = lines.get(i);

                String[] splittedLine = line.split(" ");

                for (int j = 0; j< splittedLine.length; j++)
                {
                    if(!stack.containsKey(j+1))
                    {
                        stack.put(j+1, new ArrayList<>());
                        stack.get(j+1).add(splittedLine[j]);
                    }
                    else {
                        stack.get(j+1).add(splittedLine[j]);
                    }
                }
        }

        System.out.println(stack);

        //10
//        for(int i = 5; i<lines.size(); i++)
//        {
//            String line = lines.get(i);
//
//            String[] splittedLine = line.split(" ");
//
//            int moveQuantity = Integer.valueOf(splittedLine[1]);
//
//            int origin = Integer.valueOf(splittedLine[3]);
//
//            int destination = Integer.valueOf(splittedLine[5]);
//
//
//            int moveIterator = 0;
//
//            List<String> originStack = new ArrayList<>();
//            List<String> destinationStack = new ArrayList<>();
//
//            for(String row : stack.values())
//            {
//                String[] splittedRow = row.split(" ");
//
//                originStack.add(splittedRow[origin-1]);
//                destinationStack.add(splittedRow[destination-1]);
//            }
//
//            System.out.println(originStack);

//            List<String> destinationStack = new ArrayList<>();
//
//            for(String row : stack.values())
//            {
//                String[] splittedRow = row.split(" ");
//
//                originStack.add(splittedRow[destination]);
//
//            }
  //      }

    }
}
