package code;

import java.awt.Color;
import java.util.Random;

public class Player_CE_085 {
	/**
	 * Records the score.
	 */
	private int _score;
	
	private Color _playerColor;//Andy and Simran made an instance variable of type color
	private Color _playerTextColor;
	
	/**
	 * Allows the Player to access the Tiles on its own TileRack.
	 */
	private TileRack_CE_085 _tileRack;
	
	private Inventory_CE _inv;
	
	private Board_CE_085 _board;
	
	private String _playerName;
	
	
	/**
	 * Class constructor.
	 * cse-t085: associate a random color with the player when the class is instantiated,
	 * as well as a text color that is the inverse of the random color.
	 * @param inv can draw Tiles from the Inventory
	 * @author ajnenno2 (Andrew Nenno)
	 * @author ssingh32 (Simran Singh)
	 */
	public Player_CE_085(Inventory_CE inv, Board_CE_085 board){
		_score = 0;
		_board = board;
		_tileRack = new TileRack_CE_085(inv, this);
		_playerName="";
		int r = new Random().nextInt(255);
		int g = new Random().nextInt(255);
		int b = new Random().nextInt(255);
		_playerColor = new Color(r, g, b);
		_playerTextColor = new Color(Math.abs(250-r), Math.abs(250-g), Math.abs(250-b));
		setColor();
	}// Player
	
	/**
	 * Gets the int value of the Player's score.
	 * 
	 * @return Player's score.
	 */
	public int getScore(){ return _score;}// getScore

	/**
	 * Adds the new points to the original score
	 * 
	 * @param score Score to be added to
	 * @param i additional points added to the score
	 * @return Player's score.
	 */
	public int addScore(int score, int i){ _score = score; _score = _score + i; return _score;}// addScore
	
	public void incrementScore(int x){ _score+=x;}
	
	/**
	 * Sets the background color of the button to the Player's random color
	 * @author ajnenno2 (Andrew Nenno)
	 * @author ssingh32 (Simran Singh)
	 */
	public void setColor(){
		for(int i=0; i<_tileRack.getSize(); i++){
			Tile_CE_085 jb =_tileRack.getTile(i).getTile();
			jb.setColor(_playerColor);
			jb.setTextColor(_playerTextColor);
		}
	}
	
	/**
	 * An accessor method that returns the TileRack associated with the Player when that class is instantiated
	 * @return the TileRack
	 * @author ajnenno2 (Andrew Nenno)
	 */
	public TileRack_CE_085 getTileRack(){ return _tileRack;}// getTileRack
	
	/**
	 * An acessor method that returns the Player's color that was created when the Player class is instantiated
	 * @return the Player's color
	 * @author ajnenno2 (Andrew Nenno)
	 * @author ssingh32 (Simran Singh)
	 */
	public Color getColor() { return _playerColor;}// getColor
	
	/**
	 * An accessor method that returns the Player's text color which is the inverse of the Player's assigned color
	 * @return
	 * @author ajnenno2 (Andrew Nenno)
	 */
	public Color getTextColor() { return _playerTextColor;}
	
	/**
	 * An accessor method that returns the board the the player is associated with
	 * @return
	 * @author ajnenno2 (Andrew Nenno)
	 */
	public Board_CE_085 getBoard(){ return _board;}
	
	/**
	 * An accessor method that returns the name of the player
	 * @return
	 * @author ajnenno2 (Andrew Nenno)
	 * @author sravanik (Sravanika Doddi)
	 */
	public String getName() {
		return _playerName;
	}
	
	/**
	 * A mutator method that changes the name associated with a player
	 * @param s
	 * @author ajnenno2 (Andrew Nenno)
	 * @author sravanik (Sravanika Doddi)
	 */
	public void setName(String s){ _playerName=s;}

	
	public String scoreToString() {
		String score = "";
		score = score + _score;
		return score;
	}

}// Player class