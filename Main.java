package com.company;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Main {


    // To print message on the screen.
    static void print(String msg) { System.out.print(msg); }

    // Read number
    static short readInput() {


        Scanner scan = new Scanner(System.in);
        short n;
        // Make sure the inout is only integers.
        do {
            try {

                n = scan.nextShort();
            } catch (InputMismatchException e) {
                print("Invalid input. Please enter a number.\n");
                scan.next();
                continue;
            }

            break;
        } while (true);


        return n;
    }

    // Game rules return the Game winner.
    static Players gameRules(RPS p1, RPS p2) {

    /* All Player1 and computer options */
        if (p1 == RPS.STONE && p2 == RPS.SCISSOR)
            return Players.PLAYER1;

        else if (p1 == RPS.STONE && p2 == RPS.PAPER)
            return Players.COMPUTER;

        else if (p1 == RPS.SCISSOR && p2 == RPS.STONE)
            return Players.COMPUTER;

        else if (p1 == RPS.SCISSOR && p2 == RPS.PAPER)
            return Players.PLAYER1;

        else if (p1 == RPS.PAPER && p2 == RPS.STONE)
            return Players.PLAYER1;

        else if (p1 == RPS.PAPER && p2 == RPS.SCISSOR)
            return Players.COMPUTER;
        else
            return Players.NO_WINNER;

    }


    // Get the player choice
    static RPS getPlayerChoice(short choice) {

        switch(choice) {

            case 1:
                return RPS.STONE;

            case 2:
                return RPS.SCISSOR;

            case 3:
                return RPS.PAPER;

        }

        return RPS.NON_VALID_OPTION;
    }


    // Generate random number between, 1 to 3.
    static int random() {
        Random rand = new Random();
        return rand.nextInt(3 - 1 + 1) + 1;
    }


    // Generate computer choice randomly.
    static RPS computerChoiceRandomly() {

        return getPlayerChoice((short) random());
    }


    // Calculate the score.
    static void calcScore(RPS p1, RPS p2, short[] result) {

        if (gameRules(p1, p2) == Players.PLAYER1)
            result[0]++;

        else if (gameRules(p1, p2) == Players.COMPUTER)
            result[1]++;

        else if (gameRules(p1, p2) == Players.NO_WINNER)
            result[2]++;

    }


    // Declare the final winner
    static void declareFinalWinner(short[] arr) {

        print("\n\t*_____________Game Result_______________*\n");
        print("\n\t|Player1 score is:> " + arr[0] + "\n");
        print("\t|Computer score is:> " + arr[1] + "\n");
        print("\t|Draw times is:> " + arr[2] + "\n");
        print("\t|_________________________________");

        if (arr[0] > arr[1])
            print("\n\n\tWinner is:> " + Players.PLAYER1 + "\n\t*********************************");
        else if (arr[1] > arr[0])
            print("\n\n\tWinner is:> " + Players.COMPUTER + "\n\t*********************************");
        else
            print("\n\n\tWinner is:> " + Players.NO_WINNER + "\n\t*********************************");

        // Reset the results
        arr[0] = 0;
        arr[1] = 0;
        arr[2] = 0;
    }

    // Play again.
    static boolean playAgain() {

        short c;
    // Make sure the input is only 1/0.
        do {
            c = readInput();
            if (c < 0 || c > 1)
                print("" + RPS.NON_VALID_OPTION + " TRY AGAIN 1/0:\n");
            else if (c == 0) return false;
        }while (c < 0 || c > 1);

        return true;
    }


    // Receive round data to display it.
    static void setRoundInfo(RoundInfo roundInfo, short rNum, RPS player1, RPS computer, Players roundWinner) {

        // Fill the object with data that are coming
        roundInfo.setRoundNumber(rNum);
        roundInfo.setPlayer1Choice(player1);
        roundInfo.setComputerChoice(computer);
        roundInfo.setRoundWinner(roundWinner);
    }

    // Display round result.
    static void displayRoundInfo(RoundInfo roundInfo) {

        print("\n\t_____________"+ "Resul Round Number: " + roundInfo.getRoundNumber() + "_____________\n");
        print("\n\tYour choice: " + roundInfo.getPlayer1Choice());
        print("\n\tComputer choice: " + roundInfo.getComputerChoice());
        print("\n\tRound Winner: " + roundInfo.getRoundWinner());

        print("\n\t*********************************\n");

    }


    // Start Game to play.
    static void start() {

        short[] finalScore = new short[3];


        RPS player, computer;

        // Create a new RoundInfo object that contain each round details.
        RoundInfo roundInfo = new RoundInfo();

        do {
            print("How many round(s) you want to play:> ");
            short round = readInput();



            for (short i = 1; i <= round; i++) {


                print("\nRound " + i + " begins:\n");
                print("Enter your choice [1]STONE, [2]SCISSOR. [3]PAPER:> ");
                player = getPlayerChoice(readInput());
                computer = computerChoiceRandomly();


                // Fill RoundInfo object with data and display each round result.
                setRoundInfo(roundInfo, i, player, computer, gameRules(player, computer));
                displayRoundInfo(roundInfo);

                // Update the score of player1 and computer in -->[finalScore]
                calcScore(player, computer, finalScore);


            }

            declareFinalWinner(finalScore);
            print("\nDo you want to play again 1/0:> ");
        }while(playAgain());

    }




    public static void main(String[] args) {

        // START THE GAME ON THE CONSOLE.
        start();

    }
}
