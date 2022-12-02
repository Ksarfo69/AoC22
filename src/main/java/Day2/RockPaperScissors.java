package Day2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class RockPaperScissors {

    public static void main(String[] args) throws IOException {
        playAccordingToDealt();


        playAccordingToOutcome();
    }



    //Game win = +6

    //Opponent
    // A - Rock
    // B - Paper
    // C = Scissors

    //Me
    // X - Rock (1)
    // Y = Paper (2)
    // Z - Scissors (3)

    public static void playAccordingToDealt() throws IOException {
        List<String> lines = Files.readAllLines(Path.of("src/main/resources/rock-paper-input.txt"));

        int myTotalScore = 0;

        for(String line : lines)
        {
            String[] splittedLines = line.split(" ");

            String opponentPlay = splittedLines[0];

            String myPlay = splittedLines[1];


            int myScore = 0;

            switch (myPlay){
                case "X" -> myScore = 1;
                case "Y" -> myScore = 2;
                case "Z" -> myScore = 3;
            }


            if(opponentPlay.equalsIgnoreCase("A")  && myPlay.equalsIgnoreCase("X")
                    || opponentPlay.equalsIgnoreCase("B") && myPlay.equalsIgnoreCase("Y")
                    || opponentPlay.equalsIgnoreCase("C") && myPlay.equalsIgnoreCase("Z")
            )
            {
                myTotalScore += myScore + 3;
            }
            else if (myPlay.equalsIgnoreCase("X")  && opponentPlay.equalsIgnoreCase("C")
                    || myPlay.equalsIgnoreCase("Z")  && opponentPlay.equalsIgnoreCase("B")
                    || myPlay.equalsIgnoreCase("Y")  && opponentPlay.equalsIgnoreCase("A")
            ) {
                myTotalScore += myScore + 6;
            }
            else
            {
                myTotalScore += myScore + 0;
            }


        }

        System.out.println(myTotalScore);
    }



    //Game win = 6

    //Opponent
    // A - Rock (1)
    // B - Paper (2)
    // C = Scissors (3)

    //Me
    // X - need to lose
    // Y = need to end in draw
    // Z - need to win

    public static void playAccordingToOutcome() throws IOException {
        List<String> lines = Files.readAllLines(Path.of("src/main/resources/rock-paper-input.txt"));

        int myTotalScore = 0;

        for(String line : lines) {
            String[] splittedLines = line.split(" ");

            String opponentPlay = splittedLines[0];

            String myPlay = splittedLines[1];


            if(myPlay.equalsIgnoreCase("X"))
            {
                int myScore = 0;
                if (opponentPlay.equalsIgnoreCase("A"))
                {
                    myScore = 3;
                    myTotalScore+=myScore;
                }
                else if (opponentPlay.equalsIgnoreCase("B"))
                {
                    myScore = 1;
                    myTotalScore+=myScore;
                }
                else if (opponentPlay.equalsIgnoreCase("C"))
                {
                    myScore = 2;
                    myTotalScore+=myScore;
                }
            }


            else if(myPlay.equalsIgnoreCase("Y"))
            {
                int myScore = 0;
                if (opponentPlay.equalsIgnoreCase("A"))
                {
                    myScore = 1 + 3;
                    myTotalScore+=myScore;
                }
                else if (opponentPlay.equalsIgnoreCase("B"))
                {
                    myScore = 2+ 3;
                    myTotalScore+=myScore;
                }
                else if (opponentPlay.equalsIgnoreCase("C"))
                {
                    myScore = 3+ 3;
                    myTotalScore+=myScore;
                }
            }


            else
            {
                int myScore = 0;
                if (opponentPlay.equalsIgnoreCase("A"))
                {
                    myScore = 2+ 6;
                    myTotalScore+=myScore;
                }
                else if (opponentPlay.equalsIgnoreCase("B"))
                {
                    myScore = 3+ 6;
                    myTotalScore+=myScore;
                }
                else if (opponentPlay.equalsIgnoreCase("C"))
                {
                    myScore = 1 + 6;
                    myTotalScore+=myScore;
                }
            }
        }

        System.out.println(myTotalScore);
    }
}
