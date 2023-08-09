package ca.sheridancollege.project;

import java.util.ArrayList;

/**
 * Represents a generic group of cards in the card game.
 *
 * Manages a collection of cards stored in an ArrayList, providing methods to retrieve the cards.
 *
 * Contributes to the core card management and interactions within the card game project.
 *
 * Provides a base class for specific card group types, such as player's hand or deck of cards.
 *
 *
 * @author dancye
 * @author Paul Bonenfant Jan 2020
 * @author Jochen Joaquim Camacho 11th June 2023
 * @author Arshprit Singh  Gill 11th June 2023
 * @author Kandarpkumar Kalpeshbhai Patel 11th June 2023
 * @author Yash Sarju Sheth 11th June 2023
 */
public abstract class GroupOfCards{

    //The group of cards, stored in an ArrayList
    protected ArrayList<Card> cards;

    public ArrayList<Card> getCards() {
		return this.cards;
}   
        
    public void clear() {
        cards.clear();
    }
}//end class
