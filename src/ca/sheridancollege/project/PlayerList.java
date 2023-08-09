package ca.sheridancollege.project;

import java.util.ArrayList;

/**
 * Manages a list of players in the Blackjack game, providing methods to add, remove, and query players.
 *
 * Responsible for maintaining the list of participating players and offering essential functionality.
 *
 * Plays a key role in tracking players during the Blackjack game, contributing to overall gameplay.
 *
 * @author dancye
 * @author Jochen Joaquim Camacho 11th June 2023
 * @author Arshprit Singh Gill 11th June 2023
 * @author Kandarpkumar Kalpeshbhai Patel 11th June 2023
 * @author Yash Sarju Sheth 11th June 2023
 */
public class PlayerList {
    
    // Data Field
    private ArrayList<Player> players;
    
    // Constructs an empty PlayerList.
    public PlayerList() {
        players = new ArrayList<>();
    }

    // Adds a Player to the list
    public void addPlayer(Player player) {
        players.add(player);
    }

    // Removes a player from the list
    public void removePlayer(Player player) {
        players.remove(player);
    }

    // Checks if the list is Empty
    public boolean isEmpty() {
        return players.isEmpty();
    }

    // Returns the players list
    public ArrayList<Player> getPlayers() {
        return players;
    }
}
