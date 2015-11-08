package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import code.Position;
import code.Scrabble_CE_085;
import code.Tile_CE_085;

public class ScrabbleTest_CE_085 {

	@Test public void checkPlacementTest01(){ checkPlacementsTest(1, 2, 3, 4, 1, 1, 1, 1, true);}
	@Test public void checkPlacementTest02(){ checkPlacementsTest(1, 2, 3, 4, 1, 2, 3, 4, false);}
	@Test public void checkPlacementTest03(){ checkPlacementsTest(18, 19, 0, 1, 1, 1, 1, 1, true);}
	@Test public void checkPlacementTest04(){ checkPlacementsTest(5, 5, 5, 5, 18, 19, 0, 1, true);}
	@Test public void checkPlacementTestt05(){ checkPlacementsTest(0, 2, 3, 4, 1, 1, 1, 1, false);}
	@Test public void checkPlacementTest06(){ checkPlacementsTest(18, 19, 0, 1, 18, 19, 0, 1, false);}
	@Test public void checkPlacementTestt07(){ checkPlacementsTest(19, 0, 1, 2, 1, 1, 1, 1, true);}
	
	public void checkPlacementsTest(int x1, int x2, int x3, int x4, int y1, int y2, int y3, int y4, boolean expected){
		Scrabble_CE_085 s = new Scrabble_CE_085("src/ui/Dictionary",null);
		Position p1 = new Position(1, 1, new Tile_CE_085('A', 1));
		Position p2 = new Position(1, 1, new Tile_CE_085('N', 1));
		Position p3 = new Position(1, 1, new Tile_CE_085('D', 1));
		Position p4 = new Position(1, 1, new Tile_CE_085('Y', 1));		
		s.placeTile(p1, x1, y1);
		s.placeTile(p2, x2, y2);
		s.placeTile(p3, x3, y3);
		s.placeTile(p4, x4, y4);		
		boolean actual=s.checkValidXPlacements()||s.checkValidYPlacements();
		assertTrue("\nExpected was: "+expected+"\nActual was: "+actual, expected==actual);
	}
	
	@Test public void placeTileTest01(){ placeTileTest(5);}
	@Test public void placeTileTest02(){ placeTileTest(3);}
	@Test public void placeTileTest03(){ placeTileTest(2);}
	@Test public void placeTileTest04(){ placeTileTest(0);}
	
	public void placeTileTest(int expected){
		Scrabble_CE_085 s = new Scrabble_CE_085("src/ui/Dictionary",null);
		int x=0;
		int y=0;
		for(int i=0; i<expected; i++){
			s.placeTile(new Position(1, 1, new Tile_CE_085('A', 1)), x++, y);
		}
		int actual = s.getPlacedTiles().size();
		assertTrue("\nExpected was: "+expected+"\nActual was: "+actual, expected==actual);
	}
}
