package ca.sheridancollege.project;

/**
 *
 * This class represents the dealer in a card game. The dealer is a type of player with specific behavior for playing
 * the game. The class extends the Player class to inherit common player attributes and methods.
 *
 * The Dealer class defines a constant value DEALER_MINIMUM_HAND_VALUE, which represents the minimum hand value that the
 * dealer must reach before stopping drawing cards. The class also provides a constructor to initialize the dealer's
 * name and starting balance.
 *
 * The play() method is overridden from the Player class to implement the dealer's playing strategy. The dealer will
 * keep drawing cards from the deck until their hand value reaches or exceeds the DEALER_MINIMUM_HAND_VALUE.
 *
 * @author dancye
 * @author Jochen Joaquim Camacho 11th June 2023
 * @author Arshprit Singh Gill 11th June 2023
 * @author Kandarpkumar Kalpeshbhai Patel 11th June 2023
 * @author Yash Sarju Sheth 11th June 2023
 */

public class Dealer extends Player {
    // Represents the Minimum Value a dealers hand can have
    private static final int DEALER_MINIMUM_HAND_VALUE = 16;
    
    // Constructor 
    public Dealer() {
        super("Dealer", 10);
    }
    
    // Override the play method to consider the dealer's moves
    // As long as the value of the hand is below 16 add a card to the dealer's hand
    @Override
    public void play(Deck deck){
        while (getHand().calculateHandValue() < DEALER_MINIMUM_HAND_VALUE) {
            getHand().addCard(deck.drawCard());
        }
    }
}
