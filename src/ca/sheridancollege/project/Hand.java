package ca.sheridancollege.project;

import java.util.ArrayList;

/**
 * Represents a player's hand of cards in the Blackjack game.
 *
 * Manages the cards held by a player during a game round, and provides methods to add cards, calculate hand value,
 * check for a bust, and display the hand's contents.
 *
 * @author dancye
 * @author Jochen Joaquim Camacho 11th June 2023
 * @author Arshprit Singh  Gill 11th June 2023
 * @author Kandarpkumar Kalpeshbhai Patel 11th June 2023
 * @author Yash Sarju Sheth 11th June 2023
 */

public class Hand extends GroupOfCards {

    public Hand() {
       cards = new ArrayList<>();
    }
    
    /**
     * Adds a card to the hand.
     *
     * @param card The card to be added.
     * @throws IllegalArgumentException if the card is null.
     * @throws RuntimeException if the maximum number of cards in hand is reached.
     */
    public void addCard(Card card) {
        if (card == null){
            throw new IllegalArgumentException("Null Card!");
        }
        if (cards.size() <= 5){
        cards.add(card);
        }
        else{
            throw new RuntimeException("Max Cards in Hand!");
        }
    }

    /**
     * Calculates the total value of the hand.
     *
     * @return The calculated hand value.
     */
    public int calculateHandValue() {
        int value = 0;
        int aceCount = 0;

        for (Card card : cards) {
            value += card.getValue().ordinal() + 1;
            if (card.getValue() == Card.Value.ONE) {
                aceCount++;
            }
        }

        while (value < 21 && aceCount > 0) {
            value += 10;
            aceCount--;
        }
        return value;
    }

    /**
     * Checks if the hand value is greater than 21.
     *
     * @return true if the hand value is greater than 21, false otherwise.
     */
    public boolean isBust() {
        return calculateHandValue() > 21;
    }

    @Override
    public String toString() {
        String hand = "";
        for (Card card : cards) {
            hand += card + ", ";
        }
        return hand;
    }

}