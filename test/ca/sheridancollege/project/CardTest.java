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
public class CardTest {

    public CardTest() {
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
     * Test of getSuit method, of class Card.
     */
    @Test
    public void testGetSuitGood() {
        System.out.println("getSuit - Good");
        Card instance = new Card(Card.Suit.HEARTS, Card.Value.TWO, Card.Rank.TWO);
        Card.Suit expResult = Card.Suit.HEARTS;
        Card.Suit result = instance.getSuit();
        assertEquals(expResult, result);
    }

    /**
     * Test of getValue method, of class Card.
     */
    @Test
    public void testGetValueGood() {
        System.out.println("getValue - Good");
        Card instance = new Card(Card.Suit.HEARTS, Card.Value.TWO, Card.Rank.TWO);
        Card.Value expResult = Card.Value.TWO;
        Card.Value result = instance.getValue();
        assertEquals(expResult, result);
    }

    /**
     * Test of setValue method, of class Card.
     */
    @Test
    public void testSetValueGood() {
        System.out.println("setValue - Good");
        Card.Value value = Card.Value.TWO;
        Card instance = new Card(Card.Suit.HEARTS, Card.Rank.TWO);
        instance.setValue(value);
    }

    /**
     * Test of getRank method, of class Card.
     */
    @Test
    public void testGetRankGood() {
        System.out.println("getRank - Good");
        Card instance = new Card(Card.Suit.HEARTS, Card.Value.TWO, Card.Rank.TWO);
        Card.Rank expResult = Card.Rank.TWO;
        Card.Rank result = instance.getRank();
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class Card.
     */
    @Test
    public void testToStringGood() {
        System.out.println("toString - Good");
        Card instance = new Card(Card.Suit.HEARTS, Card.Value.TWO, Card.Rank.TWO);
        String expResult = "TWO of HEARTS Points: TWO";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of cards with the same suit but different values.
     */
    @Test
    public void testCardsWithSameSuitDifferentValueGood() {
        System.out.println("testCardsWithSameSuitDifferentValue - Good");
        Card card1 = new Card(Card.Suit.HEARTS, Card.Value.TWO, Card.Rank.TWO);
        Card card2 = new Card(Card.Suit.HEARTS, Card.Value.THREE, Card.Rank.THREE);
        assertNotEquals(card1, card2);
    }

    /**
     * Test of cards with the same value but different suits.
     */
    @Test
    public void testCardsWithSameValueDifferentSuitGood() {
        System.out.println("testCardsWithSameValueDifferentSuit - Good");
        Card card1 = new Card(Card.Suit.HEARTS, Card.Value.TWO, Card.Rank.TWO);
        Card card2 = new Card(Card.Suit.DIAMONDS, Card.Value.TWO, Card.Rank.TWO);
        assertNotEquals(card1, card2);
    }
}
