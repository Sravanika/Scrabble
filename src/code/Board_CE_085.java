package code;

import java.util.Random;

public class Board_CE_085 {

	/**
	 * 2-D array of tiles to store tiles.
	 */
	private Position[][] _board;
	
	private String _boardString;
	
	/**
	 * Class constructor.
	 */
	public Board_CE_085(){ _board = new Position[20][20]; fillBoard();}// Board

	/**
	 * Fills the board with Tiles that have no letters or point values.
	 * @author ajnenno2 (Andrew Nenno)
	 */
	public void fillBoard(){
		for(int x=0; x<20; x++){
			for(int y=0; y<20; y++){
				_board[x][y] = new Position(1, 1, new Tile_CE_085(' ', 0));
			}// y for
		}// x for
		for(int i=0; i<60; i++){
			int x = new Random().nextInt(20);
			int y = new Random().nextInt(20);
			_board[x][y].setLetterMultiplier(2);
		}
		for(int i=0; i<40; i++){
			int x = new Random().nextInt(20);
			int y = new Random().nextInt(20);
			_board[x][y].setLetterMultiplier(3);
		}
		for(int i=0; i<40; i++){
			int x = new Random().nextInt(20);
			int y = new Random().nextInt(20);
			_board[x][y].setWordMultiplier(2);
		}
		for(int i=0; i<20; i++){
			int x = new Random().nextInt(20);
			int y = new Random().nextInt(20);
			_board[x][y].setWordMultiplier(3);
		}
		
	}// fillBoard
	
	/**
	 * Adds a tile to a position on the board.
	 * 
	 * @param t	the tile to be added
	 * @param x	the x-coordinate of the placement location
	 * @param y the y-coordinate of the placement location
	 */
	public Position addTile(Position p, int x, int y){
		Position temp = _board[x][y];
		_board[x][y]=p;
		_board[x][y].setLetterMultiplier(temp.getLetterMultiplier());
		_board[x][y].setWordMultiplier(temp.getWordMultiplier());
		return _board[x][y];
	
	}// addTile

	/**
	 * Removes a tile from a position on the board.
	 * 
	 * @param x the x-coordinate of the tile to be removed
	 * @param y the y-coordinate of the tile to be removed
	 * @author ajnenno2 (Andrew Nenno)
	 * @return
	 */
	public void removeTile(int x, int y){
		Position temp = _board[x][y];
		_board[x][y] = new Position(temp.getWordMultiplier(), temp.getLetterMultiplier(), new Tile_CE_085(' ',0));
	}// removeTile

	/**
	 * Returns the tile at a position.
	 * 
	 * @param x the x-coordinate of the position
	 * @param y the y-coordinate of the position
	 * @return
	 */
	public Tile_CE_085 getTile(int x, int y){ return _board[x][y].getTile();}// getTile
	
	/**
	 * An accessor method that returns the 2D array of tiles that represents the board in the game
	 * @return the 2D array
	 * @author ajnenno2 (Andrew Nenno)
	 */
	public Position[][] getBoardArray(){ return _board;}// getBoardArray
	
	/**
	 * A method that creats a 2D array of the Tiles on the board
	 * @return 2D array of Tiles on the Board
	 * @author ajnenno2 (Andrew Nenno)
	 */
	public Tile_CE_085[][] getBoardTiles(){
		Tile_CE_085[][] tiles = new Tile_CE_085[20][20];
		for(int x=0; x<20; x++){
			for(int y=0; y<20; y++){ tiles[x][y]=_board[x][y].getTile();}
		}
		return tiles;
	}
	
	/**
	 * Searches the board for a specific tile.
	 * @param t
	 * @return true if Tile is found, false if it is not found
	 * @author ajnenno2 (Andrew Nenno)
	 */
	public boolean containsTile(Tile_CE_085 t){
		for(int x=0; x<20; x++){
			for(int y=0; y<20; y++){
				if(_board[x][y].equals(t)){ return true;}
			}
		}
		return false;
	}
	
	/**
	 * Returns the x coordinate of a Tile on the board
	 * @param p
	 * @return an int that represents the x coordinate
	 * @author ajnenno2 (Andrew Nenno)
	 */
	public int getXCoord(Position p){
		int xCoord = 0;
		for(int x=0; x<20; x++){
			for(int y=0; y<20; y++){
				if(_board[x][y].equals(p)){ xCoord=x;}
			}
		}
		return xCoord;
	}
	
	/**
	 * Returns the y coordinate of a Tile on the board
	 * @param position
	 * @return an int that represents the y coordinate
	 * @author ajnenno2 (Andrew Nenno)
	 */
	public int getYCoord(Position position){
		int yCoord = 0;
		for(int x=0; x<20; x++){
			for(int y=0; y<20; y++){
				if(_board[x][y].equals(position)){ yCoord=y;}
			}
		}
		return yCoord;
	}
	/**
	 * Returns the y coordinate of a Tile on the board
	 * @param x the x-coordinate of the Position on the board
	 * @param y the y-coordinate of the Position on the board
	 * @return Position at index x and y
	 * @author ajnenno2 (Andrew Nenno)
	 */
	public Position getPosition(int x, int y) {
		return _board[x][y];
	}
		
	
	public String toString() {
		for (int y = 0; y < 20; y++) {
			for (int x = 0; x < 20; x++) {
				_boardString = _boardString + this.getTile(x, y).getChar();
			}
		}
		return _boardString;
	}
		
}// Board class