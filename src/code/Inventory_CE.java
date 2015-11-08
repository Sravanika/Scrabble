package code;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

public class Inventory_CE {
	
	/**
	 * Stores the tiles that have yet to be drawn.
	 */
	private ArrayList<Tile_CE_085> _tileBag;
	
	private String _inventoryString;
	
	/**
	 * Class constructor.
	 */
	public Inventory_CE(){
		_tileBag = new ArrayList<Tile_CE_085>();
		_inventoryString = "";
		fillBag();
	}// Inventory
	
	/**
	 * Fills the inventory of tiles with the correct number of tiles on creation.
	 */
	private void fillBag() {
//		Color c = new Color(0, 0, 0);
		for (int i = 'A'; i <= 'Z'; i = i + 1){
			// Create 29 of each vowel with point value 1
			if ((i == 'A')||(i == 'E')||(i == 'I')||(i == 'O')||(i =='U')){
				for (int j = 0; j < 29; j++){ _tileBag.add(new Tile_CE_085((char)i,1));}// j for
			}// if 'A'
			// Create 15 y's with point value 2
			else if (i == 'Y'){
				for (int j = 0; j < 15; j++){ _tileBag.add(new Tile_CE_085((char)i,2));}// j for
			}// else if 'Y'
			// Create 12 of every other letter with point value 5
			else{
				for (int j = 0; j < 12; j++){ _tileBag.add(new Tile_CE_085((char)i,5));}// j for
			}// else
		}// i for
	}// fillBag

	/**
	 * Pulls a single random tile from the inventory.
	 * 
	 * @return the random tile that was removed
	 */
	public Tile_CE_085 removeRandomTile(){
		int randomIndex = new Random().nextInt(_tileBag.size());
		return _tileBag.remove(randomIndex);
	}// removeRandomTile
	
	/**
	 * Returns number of tiles in the tile bag.
	 * 
	 * @return the size of the array list containing the tiles
	 */
	public int getSize(){ return _tileBag.size();}// getSize
	
	/**
	 * Returns the tile at a specific index.
	 * 
	 * @param i index of the tile bag array list
	 * @return tile at index i
	 */
	public Tile_CE_085 getTile(int i){ return _tileBag.get(i);}// getTile
	
	public String toString() {
		for (int i = 0; i < this.getSize(); i++) {
			_inventoryString = _inventoryString + this.getTile(i).getChar();
		}
		return _inventoryString;
	}
	
}// Inventory class
