package tests;

import org.junit.Test;
import static org.junit.Assert.assertTrue;
import code.Inventory_CE;
import code.Tile_CE_085;

public class InventoryTest_CE {
	
	// Checks the initial capacity of tile bag to be 400
	@Test
	public void initialCapacityTest(){
		int expected = 400;
		Inventory_CE inv = new Inventory_CE();
		int actual = inv.getSize();
		assertTrue("I expected the new inventory's initial capacity to be "+expected+" but instead it is"+actual, expected==actual);
	}
	
	// Checks the counts of each letter tile
	@Test
	public void correctCountTest(){
		boolean testSuccess = true;
		int expectedI = 29;
		int expectedY = 15;
		int expectedF = 12;
		int actualI = 0;
		int actualY = 0;
		int actualF = 0;
		Inventory_CE inv = new Inventory_CE();
		for (int i = 0; i < inv.getSize(); i++){
			if (inv.getTile(i).getChar() == 'I'){
				actualI++;
			}
			else if (inv.getTile(i).getChar() == 'Y'){
				actualY++;
			}
			else if (inv.getTile(i).getChar() == 'F'){
				actualF++;
			}
		}
		if (expectedI != actualI){
			testSuccess = false;
		}
		else if (expectedY != actualY){
			testSuccess = false;
		}
		else if (expectedF != actualF){
			testSuccess = false;
		}
		
		assertTrue("The number of each tile in the inventory are not correct", testSuccess);
	}
	
	// Check ability to draw an object of type tile
	@Test
	public void drawTileTest1(){
		Inventory_CE inv = new Inventory_CE();
		assertTrue("I expected the object drawn to be a tile but it wasn't", inv.removeRandomTile() instanceof Tile_CE_085);
	}
	
	// Check that the tile bag's size is reduced by one after drawing a tile
	@Test
	public void drawTileTest2(){
		int expected = 399;
		Inventory_CE inv = new Inventory_CE();
		inv.removeRandomTile();
		int actual = inv.getSize();
		assertTrue("I expected the inventory to decrease in size after drawing a tile but it didn't", actual == expected);
	}
}
