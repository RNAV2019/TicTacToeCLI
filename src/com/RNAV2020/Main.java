package com.RNAV2020;
import java.util.HashMap;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.Scanner;

public class Main {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String valueNothing = ANSI_WHITE + "-" + ANSI_RESET;
    public static final String valueUser = ANSI_RED + "X" + ANSI_RESET;
    public static final String valueComputer = ANSI_CYAN + "O" + ANSI_RESET;
    static Boolean gameRunning = true;
    static HashMap<Integer, String> board = new HashMap<>();
    // static char[][] board = new char[][]{{"-", "-", "-"}, {"-", "-", "-"}, {"-", "-", "-"}};

    public static void main(String[] args) throws InterruptedException {
        board.put(1, valueNothing);
        board.put(2, valueNothing);
        board.put(3, valueNothing);
        board.put(4, valueNothing);
        board.put(5, valueNothing);
        board.put(6, valueNothing);
        board.put(7, valueNothing);
        board.put(8, valueNothing);
        board.put(9, valueNothing);
	    System.out.println("Welcome to TicTacToe");
        playGame();
    }

    public static void displayBoard(){
        System.out.printf("%s | %s | %s          1 | 2 | 3%n", board.get(1), board.get(2), board.get(3));
        System.out.printf("%s | %s | %s          4 | 5 | 6%n", board.get(4), board.get(5), board.get(6));
        System.out.printf("%s | %s | %s          7 | 8 | 9%n", board.get(7), board.get(8), board.get(9));
    }

    public static void playGame() throws InterruptedException {
        displayBoard();

        while (gameRunning) {
            System.out.println("It is your turn!");
            Scanner sc = new Scanner(System.in);
            System.out.println("Choose a number from 1 - 9");
            int userInput = sc.nextInt();
            if (userInput == 1 && board.get(1).equals(valueNothing)) {
                board.put(1, valueUser);
            } else if (userInput == 2 && board.get(2).equals(valueNothing)){
                board.put(2, valueUser);
            } else if (userInput == 3 && board.get(3).equals(valueNothing)){
                board.put(3, valueUser);
            } else if (userInput == 4 && board.get(4).equals(valueNothing)){
                board.put(4, valueUser);
            } else if (userInput == 5 && board.get(5).equals(valueNothing)){
                board.put(5, valueUser);
            } else if (userInput == 6 && board.get(6).equals(valueNothing)){
                board.put(6, valueUser);
            } else if (userInput == 7 && board.get(7).equals(valueNothing)){
                board.put(7, valueUser);
            } else if (userInput == 8 && board.get(8).equals(valueNothing)){
                board.put(8, valueUser);
            } else if (userInput == 9 && board.get(9).equals(valueNothing)){
                board.put(9, valueUser);
            } else {
                System.out.println("Invalid Input...");
                playGame();
            }
            displayBoard();
            winLogic();
            if (!gameRunning) {
                break;
            }
            TimeUnit.SECONDS.sleep(1);
            System.out.printf("%nIt is the computers turn...%n");
            TimeUnit.SECONDS.sleep(1);
            flipPlayer();
        }
    }

    public static void flipPlayer() {
        while (true) {
            int computerTurn = ThreadLocalRandom.current().nextInt(1, 10);

            if (board.get(computerTurn).equals(valueNothing)) {
                board.put(computerTurn, valueComputer);
                displayBoard();
                winLogic();
                break;
            }
        }
    }

    public static void winLogic() {
        if (board.get(1).equals(valueUser) && board.get(2).equals(valueUser) && board.get(3).equals(valueUser)) {
            System.out.println("You have won!");
            gameRunning = false;
        } else if (board.get(1).equals(valueUser) && board.get(5).equals(valueUser) && board.get(9).equals(valueUser)) {
            System.out.println("You have won!");
            gameRunning = false;
        } else if (board.get(1).equals(valueUser) && board.get(4).equals(valueUser) && board.get(7).equals(valueUser)) {
            System.out.println("You have won!");
            gameRunning = false;
        } else if (board.get(7).equals(valueUser) && board.get(8).equals(valueUser) && board.get(9).equals(valueUser)) {
            System.out.println("You have won!");
            gameRunning = false;
        } else if (board.get(3).equals(valueUser) && board.get(6).equals(valueUser) && board.get(9).equals(valueUser)) {
            System.out.println("You have won!");
            gameRunning = false;
        } else if (board.get(2).equals(valueUser) && board.get(5).equals(valueUser) && board.get(8).equals(valueUser)) {
            System.out.println("You have won!");
            gameRunning = false;
        } else if (board.get(4).equals(valueUser) && board.get(5).equals(valueUser) && board.get(6).equals(valueUser)) {
            System.out.println("You have won!");
            gameRunning = false;
        } else if (board.get(3).equals(valueUser) && board.get(5).equals(valueUser) && board.get(7).equals(valueUser)) {
            System.out.println("You have won!");
            gameRunning = false; // Start of computer logic
        } else if (board.get(1).equals(valueComputer) && board.get(2).equals(valueComputer) && board.get(3).equals(valueComputer)) {
            System.out.println("You lost to the computer...");
            gameRunning = false;
        } else if (board.get(1).equals(valueComputer) && board.get(5).equals(valueComputer) && board.get(9).equals(valueComputer)) {
            System.out.println("You lost to the computer...");
            gameRunning = false;
        } else if (board.get(1).equals(valueComputer) && board.get(4).equals(valueComputer) && board.get(7).equals(valueComputer)) {
            System.out.println("You lost to the computer...");
            gameRunning = false;
        } else if (board.get(7).equals(valueComputer) && board.get(8).equals(valueComputer) && board.get(9).equals(valueComputer)) {
            System.out.println("You lost to the computer...");
            gameRunning = false;
        } else if (board.get(3).equals(valueComputer) && board.get(6).equals(valueComputer) && board.get(9).equals(valueComputer)) {
            System.out.println("You lost to the computer...");
            gameRunning = false;
        } else if (board.get(2).equals(valueComputer) && board.get(5).equals(valueComputer) && board.get(8).equals(valueComputer)) {
            System.out.println("You lost to the computer...");
            gameRunning = false;
        } else if (board.get(4).equals(valueComputer) && board.get(5).equals(valueComputer) && board.get(6).equals(valueComputer)) {
            System.out.println("You lost to the computer...");
            gameRunning = false;
        } else if (board.get(3).equals(valueComputer) && board.get(5).equals(valueComputer) && board.get(7).equals(valueComputer)) {
            System.out.println("You lost to the computer...");
            gameRunning = false;
        } else if (!Objects.equals(board.get(1), valueNothing) && !Objects.equals(board.get(2), valueNothing) && !Objects.equals(board.get(3), valueNothing) && !Objects.equals(board.get(4), valueNothing) && !Objects.equals(board.get(5), valueNothing) && !Objects.equals(board.get(6), valueNothing) && !Objects.equals(board.get(7), valueNothing) && !Objects.equals(board.get(8), valueNothing) && !Objects.equals(board.get(9), valueNothing)) {
            System.out.println("It was a tie!");
            gameRunning = false;
        }
    }
}
