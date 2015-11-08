package tests;

import org.junit.Test;

import static org.junit.Assert.assertTrue;
import code.Board_CE_085;
import code.Position;
import code.Tile_CE_085;

public class BoardTest_CE {
	@Test
	public void initializedEmptyBoardTest(){
		//test that initialized board is empty
		Board_CE_085 b = new Board_CE_085();
		int nullTileCount=0;
		for (int i=0; i<20; i++){
			for (int j=0; j<20;j++){
				if(b.getTile(i, j)==null){
					nullTileCount=nullTileCount+1;
				}
			}
		}
		assertTrue("I expected a new board to contain 400 empty spaces, but there were only "+nullTileCount,nullTileCount==400);
	}
	@Test
	public void addTest(){
		//test that we can add a tile to a spot
		Board_CE_085 b = new Board_CE_085();
		Tile_CE_085 t = new Tile_CE_085('y',2);
		Position p = new Position(1, 1, t);
		b.addTile(p,2,2);
		assertTrue("I tried to add a tile to the board, but it wasn't there", t==b.getTile(2, 2));
	}
	//test that the correct tile is removed from a spot
	@Test
	public void removeTest(){
		Board_CE_085 b = new Board_CE_085();
		Tile_CE_085 tile = new Tile_CE_085('A', 1);
		Position p = new Position(1, 1, tile);
		b.addTile(p,19,2);
		Tile_CE_085 temp=b.getTile(19,2);
		assertTrue("I tried to remove tile "+tile+" from the board, but instead removed "+temp,tile.equals(temp));
	}
	//test that spot on board is empty after removing a tile
	@Test
	public void emptyAfterRemovalTest(){
		Board_CE_085 b = new Board_CE_085();
		boolean testNull=false;
		Tile_CE_085 tile = new Tile_CE_085('z',5);
		Position p = new Position(1, 1, tile);
		b.addTile(p, 7, 7);
		b.removeTile(7,7);
		assertTrue("After removing a tile, the board space was not empty", b.getTile(7,7)==null);
	}

}
