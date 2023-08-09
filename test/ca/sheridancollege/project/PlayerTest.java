/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package ca.sheridancollege.project;

import java.util.Scanner;
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
public class PlayerTest {
    
    public PlayerTest() {
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
     * Test of getName method, of class Player.
     */
    @Test
    public void testGetNameGood() {
        System.out.println("testGetName - Good");
        Player instance = new Player("Name", 100);
        String expResult = "Name";
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getMoney method, of class Player.
     */
    @Test
    public void testGetMoneyGood() {
        System.out.println("testGetMoney - Good");
        Player instance = new Player("Name", 100);
        int expResult = 100;
        int result = instance.getMoney();
        assertEquals(expResult, result);
    }

    /**
     * Test of setMoney method, of class Player.
     */
    @Test
    public void testSetMoneyGood() {
        System.out.println("testSetMoney - Good");
        int money = 100;
        Player instance = new Player("Name", 0);
        instance.setMoney(money);
    }

    /**
     * Test of getHand method, of class Player.
     */
    @Test
    public void testGetHandGood() {
        System.out.println("testGetHand - Good");
        Player instance = new Player("Name", 100);
        instance.getHand().addCard(new Card(Card.Suit.HEARTS, Card.Value.TWO, Card.Rank.TWO));
        instance.getHand().addCard(new Card(Card.Suit.SPADES, Card.Value.TWO, Card.Rank.TWO));
        Hand expResult = new Hand();
        expResult.addCard(new Card(Card.Suit.HEARTS, Card.Value.TWO, Card.Rank.TWO));
        expResult.addCard(new Card(Card.Suit.SPADES, Card.Value.TWO, Card.Rank.TWO));
        Hand result = instance.getHand();
        assertEquals(expResult.toString(), result.toString());
    }

    /**
     * Test of setBet method, of class Player.
     */
    @Test
    public void testSetBetGood() {
        System.out.println("testSetBet - Good");
        int bet = 50;
        Player instance = new Player("Name", 100);
        instance.setBet(bet);
    }

    /**
     * Test of getBet method, of class Player.
     */
    @Test
    public void testGetBetGood() {
        System.out.println("testGetBet - Good");
        Player instance = new Player("Name", 100);
        int expResult = 0;
        int result = instance.getBet();
        assertEquals(expResult, result);
    }

    /**
     * Test of bet method, of class Player.
     */
    @Test
    public void testBetGood() {
        System.out.println("testBet - Good");
        Player instance = new Player("Name", 100);
        instance.bet(50);
        int expResult = 50;
        int result = instance.getBet();
        assertEquals(expResult, result);
    }

    /**
     * Test of play method, of class Player.
     */
    @Test
    public void testPlayGood() {
        System.out.println("testPlay - Good");
        Deck deck = new Deck();
        Player instance = new Player("Name", 100);
        instance.getHand().addCard(new Card(Card.Suit.HEARTS, Card.Value.TWO, Card.Rank.TWO));
        instance.getHand().addCard(new Card(Card.Suit.SPADES, Card.Value.TWO, Card.Rank.TWO));
        String expResult = "Player Chose to Hit";
        String result = instance.play(deck, 2);
        assertEquals(expResult, result);
    }
    /**
     * Test the setMoney method with a negative money value.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testSetNegativeMoneyBad() {
        System.out.println("testSetNegativeMoney - Bad");
        int money = -50;
        Player instance = new Player("Name", 0);
        instance.setMoney(money);
    }
    
    @Test
    public void testSetBoundaryMoney() {
        System.out.println("testSetBoundaryMoney - Boundary");
        int money = 500;
        Player instance = new Player("Name", 0);
        instance.setMoney(money);
    }
    

    /**
     * Test the bet method with a negative bet amount.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testBetNegativeAmountBad() {
        System.out.println("testBetNegativeAmount - Bad");
        Player instance = new Player("Name", 100);
        int bet = -50;
        instance.bet(bet);
    }

    /**
     * Test the play method with an empty hand.
     */
    @Test
    public void testPlayWithEmptyHandBad() {
        System.out.println("testPlayWithEmptyHand - Bad");
        Deck deck = new Deck();
        Player instance = new Player("Name", 100);
        String expResult = "Player Chose to Stand";
        String result = instance.play(deck, 1);
        assertEquals(expResult, result);
    }

    /**
     * Test the setBet method with the maximum possible bet amount for a player.
     */
    @Test
    public void testSetMaxBetBoundary() {
        System.out.println("testSetMaxBet - Boundary");
        int bet = 100;
        Player instance = new Player("Name", 100);
        instance.setBet(bet);
        assertEquals(bet, instance.getBet());
    }

    /**
     * Test the play method with the maximum possible hand size for a player.
     */
    @Test
    public void testPlayWithMaxHandSizeBoundary() {
        System.out.println("testPlayWithMaxHandSize - Boundary");
        Deck deck = new Deck();
        Player instance = new Player("Name", 100);
        // Create a hand with the maximum possible number of cards (10)
        for (int i = 1; i <= 5; i++) {
            instance.getHand().addCard(new Card(Card.Suit.HEARTS, Card.Value.TWO, Card.Rank.TWO));
        }
        String expResult = "Player Chose to Stand";
        String result = instance.play(deck, 1);
        assertEquals(expResult, result);
    }
}
