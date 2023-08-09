package ca.sheridancollege.project;

import java.util.ArrayList;

/**
 * Represents the game results display utility for the card game.
 *
 * Manages the display of game results, including determining and displaying winners.
 *
 * Contributes to the core game play and results presentation within the card game project.
 *
 * This utility class prevents instantiation and contains static methods for result display.
 *
 *
 * @author dancye
 * @author Jochen Joaquim Camacho 11th June 2023
 * @author Arshprit Singh Gill 11th June 2023
 * @author Kandarpkumar Kalpeshbhai Patel 11th June 2023
 * @author Yash Sarju Sheth 11th June 2023
 */

public class GameResult {

    // Use a private constructor to prevent instantiation of the utility class
    private GameResult() {
        // Empty private constructor to prevent instantiation
    }

    /**
     * Displays the game results, including the winner(s) or a tie.
     *
     * @param players The list of players.
     */
    public static void displayResult(PlayerList players) {
        System.out.println("\nGame results:");

        ArrayList<Player> winners = getWinners(players.getPlayers());
        if (winners.size() == 1) {
            Player winner = winners.get(0);
            System.out.println("\nWinner: " + winner.getName() + " with $" + winner.getMoney() + ".");
        } else {
            System.out.println("There is a Tie between:");
            for (Player player : winners) {
                System.out.println(player.getName() + " - $" + player.getMoney());
            }
        }
    }

    /**
     * Determines the list of winners based on player money and returns the list.
     *
     * @param players The list of players.
     * @return The list of winning players.
     */
    private static ArrayList<Player> getWinners(ArrayList<Player> players) {
        ArrayList<Player> winners = new ArrayList<>();
        int maxMoney = Integer.MIN_VALUE;

        for (Player player : players) {
            int money = player.getMoney();

            if (money > maxMoney) {
                winners.clear();
                maxMoney = money;
            }

            if (money == maxMoney) {
                winners.add(player);
            }
        }
        return winners;
    }
}