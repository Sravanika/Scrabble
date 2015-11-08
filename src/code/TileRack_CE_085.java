package code;

import java.util.ArrayList;

public class TileRack_CE_085 {

	/**
	 * Inventory to draw tiles from
	 */
	private Inventory_CE _inv;
	
	/**
	 * Stores the tiles that can be played.
	 */
	private ArrayList<Position> _rack;
	private Player_CE_085 _player;
	private String _tileRackString;
	/**
	 * Class cosntructor.
	 * 
	 * @param inv inventory to draw tiles from
	 */
	
	public TileRack_CE_085(Inventory_CE inv, Player_CE_085 player){
		_inv = inv;
		_player= player;
		_rack = new ArrayList<Position>();
		fillRack();
		_tileRackString = "";
	}// TileRack
	
	/**
	 * Fills tile rack to maximum capacity of 12
	 */
	public void fillRack(){
		for(int i=1; i<13; i++){ _rack.add(new Position(1, 1, _inv.removeRandomTile()));}
	}// fillRack
	
	/**
	 * Removes a tile from rack.
	 * 
	 * @param t tile to be removed from the rack
	 * @return tile removed from the rack
	 */
	public Tile_CE_085 removeTile(Tile_CE_085 t){
		Tile_CE_085 tileToRemove = t;
		_rack.remove(t);
		return tileToRemove;
	}// removeTile (any tile)
	
	/**
	 * Removes a tile from an index from rack
	 * 
	 * @param i index of tile to be removed
	 * @return tile removed from the rack
	 */

	public void removeTile(int index){
		_rack.remove(index);
		Tile_CE_085 tile = _inv.removeRandomTile();
		tile.setColor(_player.getColor());
		tile.setTextColor(_player.getTextColor());
		_rack.add(new Position(1, 1, tile));
	}
	
	
	/**
	 * Gets size of the tile rack
	 * 
	 * @return size of the tile rack
	 */
	public int getSize() { return _rack.size();}// getSize
	
	/**
	 * Returns the Tile at an index on the TileRack but it doesn't remove it from the TileRack
	 * @param index
	 * @return
	 * @author ajnenno2 (Andrew Nenno)
	 * @author sravanik (Sravanika Doddi)
	 * @author ssingh32 (Simran Singh)
	 */
	public Position getTile(int index){ return _rack.get(index);}// getTile
	
	/**
	 * Returns the index of a Tile on the TileRack
	 * @param t
	 * @return
	 * @author ajnenno2 (Andrew Nenno)
	 * @author sravanik (Sravanika Doddi)
	 * @author ssingh32 (Simran Singh)
	 */
	public int getIndex(Tile_CE_085 t){
		int index=0;
		for(int i=0; i<_rack.size(); i++){
			if(t.equals(_rack.get(i))){
				index=i;
			}
		}
		return index;
	}
	/**
	 * Searches through the TileRack for a specific Tile
	 * @param t
	 * @return true if the Tile is found, false if it is not found
	 * @author ajnenno2 (Andrew Nenno)
	 * @author sravanik (Sravanika Doddi)
	 * @author ssingh32 (Simran Singh)
	 */
	
	public boolean containsTile(Tile_CE_085 t){
		for(int i=0; i<_rack.size(); i++){
			if(_rack.get(i).getTile().getValue()==t.getValue()){
				return true;
			}
		}
		
		return false;
	}
	
	public String toString() {
		for (int i = 0; i < this.getSize(); i++) {
			_tileRackString = _tileRackString + this.getTile(i).getTile().getChar();
		}
		return _tileRackString;
	}
}
	
