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
public class DeckTest {
    
    public DeckTest() {
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
     * Test of shuffle method, of class Deck.
     */
    @Test
    public void testShuffleGood() {
        System.out.println("testShuffle - Good");
        Deck instance = new Deck();
        instance.shuffle();
    }

    /**
     * Test of drawCard method, of class Deck.
     */
    @Test
    public void testDrawCardGood() {
        System.out.println("testDrawCard - Good");
        Deck instance = new Deck();
        Card result = instance.drawCard();
        assertNotNull(result);
    }

    /**
     * Test of toString method, of class Deck.
     */
    @Test
    public void testToStringGood() {
        System.out.println("toString - Good");
        Deck instance = new Deck();
        String expResult = "Done";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
    
    /**
     * Test of testDrawCardEmptyDeck method, of class Deck.
     */
    @Test(expected = RuntimeException.class)
    public void testDrawCardEmptyDeckBad() {
        System.out.println("testDrawCardEmptyDeck - Bad");
        Deck instance = new Deck();

        // Draw all cards from the deck until it is empty
        for (int i = 0; i < 52; i++) {
            instance.drawCard();
        }

        // Attempt to draw another card from an empty deck
        Card result = instance.drawCard();

        // Verify that the returned card is null
        assertNull(result);
    }

    /**
     * Test of testShuffleEmptyDeck method, of class Deck.
     */
    @Test
    public void testShuffleEmptyDeckBad() {
        System.out.println("testShuffleEmptyDeck - Bad");
        Deck instance = new Deck();

        // Draw all cards from the deck until it is empty
        for (int i = 0; i < 52; i++) {
            instance.drawCard();
        }

        // Shuffle an empty deck and check if it executes without errors
        instance.shuffle();
    }

    /**
     * Test of testDrawAllCards method, of class Deck.
     */
    @Test(expected = RuntimeException.class)
    public void testDrawAllCardsBoundary() {
        System.out.println("testDrawAllCards - Boundary");
        Deck instance = new Deck();

        // Draw all cards from the deck until it is empty
        for (int i = 0; i < 52; i++) {
            Card result = instance.drawCard();
            assertNotNull(result);
        }

        // Attempt to draw another card from an empty deck
        Card result = instance.drawCard();
        assertNull(result);
    }
}
