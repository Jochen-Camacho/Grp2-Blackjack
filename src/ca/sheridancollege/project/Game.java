package ca.sheridancollege.project;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This class represents the main entry point of the Blackjack game. It initializes and manages the game settings,
 * including the number of turns, number of players, and starting money for each player.
 *
 * The main() method guides the user through the game setup process, prompting for input and validating the values. It
 * then creates player instances, initiates game turns, and displays the final game results.
 *
 * This class plays a central role in orchestrating the game play and interacting with players, contributing to the
 * functionality of the Blackjack card game project.
 *
 * @author dancye
 * @author Paul Bonenfant Jan 2020
 * @author Jochen Joaquim Camacho 11th June 2023
 * @author Arshprit Singh Gill 11th June 2023
 * @author Kandarpkumar Kalpeshbhai Patel 11th June 2023
 * @author Yash Sarju Sheth 11th June 2023
 */
public class Game {

    // Main method to initialize and manage the Blackjack game.
    public static void main(String[] arg) {

        Scanner input = new Scanner(System.in);
        boolean playAgain = false;
        int check = -1;

        do {
            initialize();
            while (!(check == 1 || check == 0)) {
                System.out.println("\nDo you want to play again? 1 For Yes - 0 For No");
                check = input.nextInt();
                if (check == 1) {
                    playAgain = true;
                } else {
                    System.out.println("Exiting...");
                }
            }
        } while (playAgain);
    }

    /**
     * Initializes the game by prompting for user input to set the game parameters. Creates player instances based on
     * the user input, initiates game turns, and displays the game results.
     */
    private static void initialize() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to BlackJack!\nLets PLAY!!\n");
        int numTurns = 0, numPlayers = 0, startingMoney = 0;

        while (numTurns < 1 || numTurns > 10) {
            try {
                System.out.println("Enter the number of turns (1-10):");
                numTurns = scanner.nextInt();
                if (numTurns < 1 || numTurns > 10) {
                    throw new IllegalArgumentException("Invalid number of turns. Please enter a valid number.");
                }
            } catch (InputMismatchException e) {
                scanner.nextLine(); // Clear the input buffer
                System.out.println("Invalid input. Please enter a valid number.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        
        while (numPlayers < 1 || numPlayers > 3) {
            try {
                System.out.println("Enter the number of players (1-3):");
                numPlayers = scanner.nextInt();
                if (numPlayers < 1 || numPlayers > 3) {
                    throw new IllegalArgumentException("Invalid number of players. Please enter a valid number.");
                }
            } catch (InputMismatchException e) {
                scanner.nextLine(); // Clear the input buffer
                System.out.println("Invalid input. Please enter a valid number.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        while (startingMoney < 2 || startingMoney > 500) {
            try {
                System.out.println("Enter the starting money for the Players (2-500 dollars):");
                startingMoney = scanner.nextInt();
                if (startingMoney < 2 || startingMoney > 500) {
                    throw new IllegalArgumentException("Invalid starting money. Please enter a valid amount.");
                }
            } catch (InputMismatchException e) {
                scanner.nextLine(); // Clear the input buffer
                System.out.println("Invalid input. Please enter a valid number.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        
        PlayerList players = new PlayerList();
        for (int i = 1; i <= numPlayers; i++) {
            System.out.println("Enter the name of player " + i + ":");
            String playerName = scanner.next();
            players.addPlayer(new Player(playerName, startingMoney));
        }

        for (int i = 0; i < numTurns; i++) {
            System.out.println("\n---- Turn " + (i + 1) + " ----");
            GameTurn gameTurn = new GameTurn(players);
            gameTurn.startRound();
        }
        
        GameResult.displayResult(players);
    }

}//end class
