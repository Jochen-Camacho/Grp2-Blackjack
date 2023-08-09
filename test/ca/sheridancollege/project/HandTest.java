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
public class HandTest {
    
    public HandTest() {
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
     * Test of addCard method, of class Hand.
     */
    @Test
    public void testAddCardGood() {
        System.out.println("testAddCard - Good");
        Card card = new Card(Card.Suit.HEARTS, Card.Value.TWO, Card.Rank.TWO);
        Hand instance = new Hand();
        instance.addCard(card);
    }

    /**
     * Test of calculateHandValue method, of class Hand.
     */
    @Test
    public void testCalculateHandValueGood() {
        System.out.println("testCalculateHandValue - Good");
        Hand instance = new Hand();
        Card card = new Card(Card.Suit.HEARTS, Card.Value.TWO, Card.Rank.TWO);
        instance.addCard(card);
        int expResult = 2;
        int result = instance.calculateHandValue();
        assertEquals(expResult, result);
    }

    /**
     * Test of isBust method, of class Hand.
     */
    @Test
    public void testIsBustGood() {
        System.out.println("isBust - Good");
        Hand instance = new Hand();
        boolean expResult = false;
        boolean result = instance.isBust();
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class Hand.
     */
    @Test
    public void testToStringGood() {
        System.out.println("testToString - Good");
        Hand instance = new Hand();
        Card card = new Card(Card.Suit.HEARTS, Card.Value.TWO, Card.Rank.TWO);
        instance.addCard(card);
        String expResult = "TWO of HEARTS Points: TWO, ";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
    /**
     * Test the isBust method with a non-bust hand.
     */
    @Test
    public void testIsBustWithNonBustHandBad() {
        System.out.println("testIsBustWithNonBustHand - Bad");
        Hand instance = new Hand();
        boolean expResult = false;
        boolean result = instance.isBust();
        assertEquals(expResult, result);
    }

    /**
     * Test the toString method with multiple cards in the hand.
     */
    @Test
    public void testToStringWithMultipleCardsGood() {
        System.out.println("testToStringWithMultipleCards - Good");
        Hand instance = new Hand();
        Card card1 = new Card(Card.Suit.HEARTS, Card.Value.TWO, Card.Rank.TWO);
        Card card2 = new Card(Card.Suit.DIAMONDS, Card.Value.THREE, Card.Rank.THREE);
        instance.addCard(card1);
        instance.addCard(card2);
        String expResult = "TWO of HEARTS Points: TWO, THREE of DIAMONDS Points: THREE, ";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test the addCard method with a null card.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testAddNullCardBad() {
        System.out.println("testAddNullCard - Bad");
        Card card = null;
        Hand instance = new Hand();
        instance.addCard(card);
    }

    /**
     * Test the calculateHandValue method with an empty hand.
     */
    @Test
    public void testCalculateHandValueWithEmptyHandBad() {
        System.out.println("testCalculateHandValueWithEmptyHand - Bad");
        Hand instance = new Hand();
        int expResult = 0;
        int result = instance.calculateHandValue();
        assertEquals(expResult, result);
    }

    /**
     * Test the addCard method with the maximum number of cards.
     */
    @Test
    public void testAddMaxCardsToHandBoundary() 
    {
        System.out.println("testAddMaxCardsToHand - Boundary");
        Hand instance = new Hand();
        // Assuming the maximum number of cards a hand can hold is 5
        for (int i = 0; i < 5; i++) {
            instance.addCard(new Card(Card.Suit.HEARTS, Card.Value.TWO, Card.Rank.TWO));
        }
    }

    /**
     * Test the calculateHandValue method with a blackjack hand (value equals 21).
     */
    @Test
    public void testCalculateHandValueWithBlackjackBoundary() {
        System.out.println("testCalculateHandValueWithBlackjack - Boundary");
        Hand instance = new Hand();
        // Assuming a blackjack hand with two cards of value 10 each
        instance.addCard(new Card(Card.Suit.HEARTS, Card.Value.TEN, Card.Rank.TEN));
        instance.addCard(new Card(Card.Suit.DIAMONDS, Card.Value.ONE, Card.Rank.ACE));
        int expResult = 21;
        int result = instance.calculateHandValue();
        assertEquals(expResult, result);
    }
    
}
