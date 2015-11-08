package tests;

import org.junit.Test;

import static org.junit.Assert.assertTrue;
import code.Inventory_CE;
import code.Tile_CE_085;

public class TileTest_CE {
	
	//test getChar method to return correct character of a tile
	@Test
	public void checkChar(){
		char expected = 'W';
		Tile_CE_085 t = new Tile_CE_085('W',5);
		char actual = t.getChar();
		assertTrue("I expected the tile's letter to be "+expected+" but instead it is"+actual, expected==actual);
	}
	
	@Test
	public void checkChar01(){
		char expected = 'A';
		Tile_CE_085 t = new Tile_CE_085('A',1);
		char actual = t.getChar();
		assertTrue("I expected the tile's letter to be "+expected+" but instead it is"+actual, expected==actual);
	}
	
	
	//test getValue method to return value of a tile
	@Test
	public void checkValue(){
		int expected = 5;
		Tile_CE_085 t = new Tile_CE_085('W',5);
		int actual = t.getValue();
		assertTrue("I expected the tile's letter to be "+expected+" but instead it is"+actual, expected==actual);
	}

}
