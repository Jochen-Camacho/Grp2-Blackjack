package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Represents a deck of playing cards. Manages card initialization, shuffling, drawing, and card values. Inherits from
 * GroupOfCards class.
 *
 * This class contributes to card game functionality, handling interactions with the deck of cards used in the game.
 *
 * @author dancye
 * @author Jochen Joaquim Camacho 11th June 2023
 * @author Arshprit Singh Gill 11th June 2023
 * @author Kandarpkumar Kalpeshbhai Patel 11th June 2023
 * @author Yash Sarju Sheth 11th June 2023
 */
public class Deck extends GroupOfCards {

    /**
     * Constructs a standard deck of playing cards, creating cards for all suits and ranks.
     */
    public Deck() {
        cards = new ArrayList<>();
        for (Card.Suit suit : Card.Suit.values()) {
            for (Card.Rank rank : Card.Rank.values()) {
                Card card = new Card(suit, rank);
                card.setValue(getCardValue(rank));
                cards.add(card);
            }
        }
    }

    // Shuffles the deck to randomize the cards
    public void shuffle() {
        Collections.shuffle(cards);
    }

    // Draws and removes the top card from the deck.
    public Card drawCard() {
        if (cards.isEmpty()) {
            // RuntimeException if the deck is empty.
            throw new RuntimeException("No cards left in the deck.");
        }
        return cards.remove(0);
    }

    // Used to match the appropriate Rank to its Value
    private Card.Value getCardValue(Card.Rank rank) {
        switch (rank) {
            case ACE:
                return Card.Value.ELEVEN;
            case TWO:
                return Card.Value.TWO;
            case THREE:
                return Card.Value.THREE;
            case FOUR:
                return Card.Value.FOUR;
            case FIVE:
                return Card.Value.FIVE;
            case SIX:
                return Card.Value.SIX;
            case SEVEN:
                return Card.Value.SEVEN;
            case EIGHT:
                return Card.Value.EIGHT;
            case NINE:
                return Card.Value.NINE;
            case TEN:
                return Card.Value.TEN;
            case JACK:
                return Card.Value.TEN;
            case QUEEN:
                return Card.Value.TEN;
            case KING:
                return Card.Value.TEN;
            default:
                throw new IllegalArgumentException("Invalid card rank.");
        }
    }

    @Override
    public String toString() {
        for (Card card : cards) {
            System.out.println(card);
        }
        return "Done";
    }
}
