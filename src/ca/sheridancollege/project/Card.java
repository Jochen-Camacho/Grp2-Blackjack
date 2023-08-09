package ca.sheridancollege.project;

/**
 * This class represents a standard playing card in a deck. It defines the properties of the card, including its suit,
 * value, and rank. The class provides constructors to initialize the card's attributes and getter and setter methods to
 * access and modify its properties. 
 * 
 * The Card class also overrides the toString() method to provide a human-readable
 * representation of the card. The suit, value, and rank of the card are represented by enums (Suit, Value, and Rank) to
 * ensure consistent and controlled values. 
 * 
 * Multiple constructors are provided for different scenarios of initializing a
 * card with suit and rank information.This class is part of a card game project and serves as a fundamental building
 * block for managing and manipulating playing cards within the game.
 *
 * @author dancye
 * @author Jochen Joaquim Camacho 11th June 2023
 * @author Arshprit Singh Gill 11th June 2023
 * @author Kandarpkumar Kalpeshbhai Patel 11th June 2023
 * @author Yash Sarju Sheth 11th June 2023
 */
public class Card {

    // Enum of Suit values used to create a 'card'
    public enum Suit {
        HEARTS, DIAMONDS, CLUBS, SPADES
    };

     // Enum of Values to serve as Points of cards
    public enum Value {
        ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, ELEVEN
    };

     // Enum of Rank values used to create a 'card'
    public enum Rank {
        ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING
    };
    
    //Data Fields
    private final Suit suit;
    private Value value;
    private final Rank rank;

    // Constructors
    public Card(Suit initSuit, Value initValue, Rank initRank) {
        this.suit = initSuit;
        this.rank = initRank;
        this.value = initValue;
    }

    public Card(Suit initSuit, Rank initRank) {
        this.suit = initSuit;
        this.rank = initRank;
    }

    // Accessor and Mutator Methods
    // Only setter for Value because the Suit and Rank should not be changed after initialization
    public Suit getSuit() {
        return this.suit;
    }

    public Value getValue() {
        return this.value;
    }

    public void setValue(Value value) {
        this.value = value;
    }

    public Rank getRank() {
        return this.rank;
    }
    
    //Human Readable toString Method
    @Override
    public String toString() {
        return rank + " of " + suit + " Points: " + value;
    }
}
