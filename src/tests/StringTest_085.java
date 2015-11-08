package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import code.Board_CE_085;
import code.Inventory_CE;
import code.Player_CE_085;
import code.Position;
import code.TileRack_CE_085;
import code.Tile_CE_085;

public class StringTest_085 {

	@Test
	public void tileRackStringTest01() {
		Inventory_CE iv = new Inventory_CE();
		TileRack_CE_085 tr = new TileRack_CE_085(iv, new Player_CE_085(iv, new Board_CE_085()));
		char expected = tr.getTile(0).getTile().getChar();
		char actual = tr.toString().charAt(0);
		assertTrue("\nExpected was: "+expected+"\nActual was: "+actual, actual == expected);
	}
	
	@Test
	public void tileRackStringTest02() {
		Inventory_CE iv = new Inventory_CE();
		TileRack_CE_085 tr = new TileRack_CE_085(iv, new Player_CE_085(iv, new Board_CE_085()));
		int expected = 12;
		int actual = tr.toString().length();
		assertTrue("\nExpected was: "+expected+"\nActual was: "+actual, actual == expected);
	}
	
	@Test
	public void tileRackStringTest03() {
		Inventory_CE iv = new Inventory_CE();
		TileRack_CE_085 tr = new TileRack_CE_085(iv, new Player_CE_085(iv, new Board_CE_085()));
		String expected = "AAAAAAAAAAAA";
		String actual = tr.toString();
		assertTrue("\nExpected was: "+expected+"\nActual was: "+actual, expected != actual);
	}
	
	@Test
	public void boardStringTest01() {
		Board_CE_085 b = new Board_CE_085();
		char expected = ' ';
		char actual = b.toString().charAt(0);
		assertTrue("\nExpected was: "+expected+"\nActual was: "+actual, expected == actual);
	}
	
	@Test
	public void boardStringTest02() {
		Board_CE_085 b = new Board_CE_085();
		int expected = 400;
		int actual = b.toString().length();
		assertTrue("\nExpected was: "+expected+"\nActual was: "+actual, actual == expected);
	}
	
	@Test
	public void boardStringTest03() {
		Board_CE_085 b = new Board_CE_085();
		b.addTile(new Position(0, 0, new Tile_CE_085('A', 1)), 0, 0);
		char expected = 'A';
		char actual = b.toString().charAt(0);
		assertTrue("\nExpected was: "+expected+"\nActual was: "+actual, expected == actual);
	}
	
	@Test
	public void inventoryStringTest01() {
		Inventory_CE iv = new Inventory_CE();
		int expected = 400;
		int actual = iv.toString().length();
		assertTrue("\nExpected was: "+expected+"\nActual was: "+actual, expected == actual);
	}
	
	@Test
	public void inventoryStringTest02() {
		Inventory_CE iv = new Inventory_CE();
		char expected = 'A';
		char actual = iv.toString().charAt(0);
		assertTrue("\nExpected was: "+expected+"\nActual was: "+actual, expected == actual);
	}
	
	@Test
	public void inventoryStringTest03() {
		Inventory_CE iv = new Inventory_CE();
		char expected = 'Z';
		char actual = iv.toString().charAt(399);
		assertTrue("\nExpected was: "+expected+"\nActual was: "+actual, expected == actual);
	}

}
