package ca.sheridancollege.project;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Represents a player in the Blackjack game. Manages player details, actions, and bets.
 *
 * Responsible for handling player-specific functionalities, including betting, playing turns, and managing the player's
 * hand.
 *
 * Contributes to the core game play and interactions within the Blackjack card game project.
 *
 *
 * @author dancye
 * @author Paul Bonenfant Jan 2020
 * @author Jochen Joaquim Camacho 11th June 2023
 * @author Arshprit Singh Gill 11th June 2023
 * @author Kandarpkumar Kalpeshbhai Patel 11th June 2023
 * @author Yash Sarju Sheth 11th June 2023
 */
public class Player {

    // Data fields
    private final String name;
    private int money;
    private final Hand hand;
    private int bet;

    // Constants
    static final int MIN_BET_AMOUNT = 2;
    static final int MAX_BET_AMOUNT = 500;

    /**
     * Constructs a player with the specified name and starting money.
     *
     * @param name  The player's name.
     * @param money The initial amount of money the player has.
     */
    public Player(String name, int money) {
        this.name = name;
        this.money = money;
        hand = new Hand();
    }

    // Getter and Setter Methods
    public String getName() {
        return name;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        if (money < 0) {
            // If negative money throw Error
            throw new IllegalArgumentException("Error: Negative Money!");
        } else {
            this.money = money;
        }
    }

    public Hand getHand() {
        return hand;
    }

    public void setBet(int bet) {
        if (bet < 0) {
            throw new IllegalArgumentException("Error: Negative Money!");
        } else {
            this.bet = bet;
        }
    }

    public int getBet() {
        return bet;
    }

    /**
     * Manages the process of placing a bet.
     */
    public void bet() {
        Scanner scanner = new Scanner(System.in);
        int betAmount = -1;
        boolean validInput = false;
        while (!validInput) {
            try {
                System.out.println(getName() + ", enter your bet amount (" + MIN_BET_AMOUNT + " - " + MAX_BET_AMOUNT + " dollars):");
                betAmount = scanner.nextInt();
                if (betAmount < MIN_BET_AMOUNT || betAmount > MAX_BET_AMOUNT || betAmount > getMoney()) {
                    throw new IllegalArgumentException("Invalid bet amount. Please enter a valid amount:");
                }
                validInput = true;
            }
            catch (InputMismatchException e) {
                scanner.nextLine(); // Clear the input buffer
                System.out.println("Invalid input. Please enter a valid number.");
            } 
            catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        setBet(betAmount);
    }
    
     public void bet(int betAmount) {
        setBet(betAmount);
    }
 
    /**
     * Simulates the player's turn in the game.
     *
     * @param deck The deck of cards.
     */
    public void play(Deck deck) {
        if (deck == null){
            throw new IllegalArgumentException("Deck is Null!");
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n" + getName() + ", it's your turn.\n");
        boolean isTurnComplete = false;
        while (!isTurnComplete) {
            System.out.println("Your current hand: " + getHand().getCards());
            System.out.println("Hand value: " + getHand().calculateHandValue());
            System.out.println("Choose an option: 1. Hit  2. Stand  3. Exit");
            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    getHand().addCard(deck.drawCard());
                    if (getHand().isBust()) {
                        System.out.println("Bust! You lose your bet amount.\n");
                        isTurnComplete = true;
                    }
                    break;
                case 2:
                    isTurnComplete = true;
                    break;
                case 3:
                    System.out.println(getName() + " has exited the game.");
                    setBet(0); // Return the bet amount since the player exits.
                    isTurnComplete = true;
                    break;
                default:
                    System.out.println("Invalid option. Please choose again.");
                    break;
                }
            }
    }
    
    public String play(Deck deck, int option){
        if (deck == null){
            throw new IllegalArgumentException("Deck is Null!");
        }
        switch (option) {
            case 1:
                if (getHand().isBust()) {
                    return ("Bust! You lose your bet amount.");
                }
                else{
                    return "Player Chose to Stand";
                }   
            case 2:       
                return "Player Chose to Hit";  
            case 3:
                setBet(0); // Return the bet amount since the player exits.
                return (getName() + " has exited the game.");
            default:
                return ("Invalid option. Please choose again.");
            } 
    }
}
