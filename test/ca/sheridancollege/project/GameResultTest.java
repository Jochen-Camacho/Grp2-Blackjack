/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Joche
 */
public class GameResultTest {
    
    public GameResultTest() {
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
     * Test of displayResult method, of class GameResult.
     */
    @Test
    public void testDisplayResultGood() {
        System.out.println("testDisplayResult - Good");
        PlayerList players = new PlayerList();
        Player p1 = new Player("P1", 100);
        Player p2 = new Player("P2", 100);
        players.addPlayer(p1);
        players.addPlayer(p2);
        GameResult.displayResult(players);
    }
    
    /**
     * Test of displayResult method with an empty list of players.
     */
    @Test
    public void testDisplayResultWithEmptyListBad() {
        System.out.println("testDisplayResultWithEmptyList - Bad");
        PlayerList players = new PlayerList();
        GameResult.displayResult(players);
    }

    /**
     * Test of displayResult method with a list of players having minimum and maximum scores and names.
     */
    @Test
    public void testDisplayResultWithMinMaxValuesBoundary() {
        System.out.println("testDisplayResultWithMinMaxValues - Boundary");
        PlayerList players = new PlayerList();
        Player p1 = new Player("A", Integer.MIN_VALUE); // Minimum score
        Player p2 = new Player("Z", Integer.MAX_VALUE); // Maximum score
        players.addPlayer(p1);
        players.addPlayer(p2);
        GameResult.displayResult(players);
    }

    /**
     * Test of displayResult method with a large list of players.
     */
    @Test
    public void testDisplayResultWithLargeListBoundary() {
        System.out.println("testDisplayResultWithLargeList - Boundary");
        PlayerList players = new PlayerList();
        for (int i = 1; i <= 1000; i++) {
            players.addPlayer(new Player("P" + i, i * 10));
        }
        GameResult.displayResult(players);
    }
}