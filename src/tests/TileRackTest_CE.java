package tests;

import org.junit.Test;

import static org.junit.Assert.assertTrue;
import code.Board_CE_085;
import code.Inventory_CE;
import code.Player_CE_085;
import code.Tile_CE_085;
import code.TileRack_CE_085;

public class TileRackTest_CE {

	// Test maximum capacity of 12 for tile rack
	@Test
	public void capacityTest(){
		Inventory_CE inv = new Inventory_CE();
		Board_CE_085 b = new Board_CE_085();
		Player_CE_085 P = new Player_CE_085(inv,b);
		TileRack_CE_085 rack = new TileRack_CE_085(inv,P);
		assertTrue("The tile rack should fill to a maximum size of 12 but I got " + rack.getSize(), rack.getSize() == 12);
	}



	// Test adding tiles after removing tiles
	@Test
	public void addTest(){
		Inventory_CE inv = new Inventory_CE();
		Board_CE_085 b = new Board_CE_085();
		Player_CE_085 p = new Player_CE_085(inv,b);
		TileRack_CE_085 rack = new TileRack_CE_085(inv,p);
		rack.fillRack();
		assertTrue("it's size should be 12, but I got " + rack.getSize(), rack.getSize() == 0);
		

	}

}