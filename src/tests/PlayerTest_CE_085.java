package tests;

import java.awt.Color;

import org.junit.Test;

import static org.junit.Assert.assertTrue;
import code.Inventory_CE;
import code.Player_CE_085;

public class PlayerTest_CE_085 {
	
		//test that initial score at new game is 0
		
	    @Test public void testScore() {testInitialScore(0);}
		
	    private void testInitialScore(int expected) {
	    	Inventory_CE i = new Inventory_CE();
	    	Player_CE_085 p = new Player_CE_085(i, null);
	        int actual = p.getScore();
	        
	        assertTrue("I tested whether or not the Player's score was"+expected+"and it should have returned"+actual, actual==expected);
	    }
		//test that adding numbers to score properly updates score total
	    
	    @Test public void testNewScore() {testAddScore(0, 5, 5);}
	    @Test public void testNewScore1() {testAddScore(2, 3, 5);}
	    @Test public void testNewScore2() {testAddScore(12, 88, 100);}
	    @Test public void testNewScore3() {testAddScore(99, 25, 124);}
		
	    private void testAddScore(int original, int add, int total) {
	    	Inventory_CE i = new Inventory_CE();
	    	Player_CE_085 p = new Player_CE_085(i, null);
	        int actual = p.addScore(original, add);
	        
	        assertTrue("I tested whether or not the Player's score was"+total+"after adding"+original+"and"+add+"and it should have returned"+actual, actual==total);
	    }
	    
	    @Test 
	    public void playerColorsTest1() {
	    	Color color = new Color(
	    	          (new Double(Math.random() * 128)).intValue() + 128,   
	    	          (new Double(Math.random() * 128)).intValue() + 128,   
	    	          (new Double(Math.random() * 128)).intValue() + 128);
	    	playerColorsTest(color);
	    	}
	    
	    public void playerColorsTest(Color expected) {
	    	Inventory_CE i = new Inventory_CE();
	    	Player_CE_085 p = new Player_CE_085(i, null);
	    	Color actual = p.getColor();
	    	assertTrue("\nThe expected color was: "+expected+"\nThe actual color was: "+actual, expected != actual);
	    }

	}
