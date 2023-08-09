/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package ca.sheridancollege.project;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Joche
 */
public class DealerTest {
    
    public DealerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of play method, of class Dealer.
     */
    @Test
    public void testPlayGood() {
        System.out.println("testPlay - Good");
        Deck deck = new Deck();
        Dealer instance = new Dealer();
        instance.play(deck);
    }
    /**
     * Test the dealer's play method with a null deck.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testPlayWithNullDeckBad() {
        System.out.println("testPlayWithNullDeck - Bad");
        // Create a null deck
        Deck deck = null;

        // Create a dealer instance
        Dealer instance = new Dealer();

        // Test the dealer's play method with the null deck, expecting an IllegalArgumentException
        instance.play(deck, 2);
    }

    /**
     * Test the dealer's play method with an empty deck.
     */
    @Test
    public void testPlayWithEmptyDeckBoundary() {
        System.out.println("testPlayWithEmptyDeck - Boundary");
        // Create an empty deck
        Deck deck = new Deck();
        deck.clear(); // Remove all cards to make the deck empty

        // Create a dealer instance
        Dealer instance = new Dealer();

        // Test the dealer's play method with the empty deck
        instance.play(deck, 2);
    }
}
