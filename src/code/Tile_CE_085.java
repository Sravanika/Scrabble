package code;

import java.awt.Color;

public class Tile_CE_085 {

	/**
	 * Stores the character of the tile.
	 */
	private char _letter;
	/**
	 * Stores the point value of the tile.
	 */
	private int _pointValue;
	
	private Color _color;
				
	private Color _textColor;
	
	private Tile_CE_085 _selected;
	
	private Tile_CE_085 _past;
	
	private boolean isEnabled = true;
	
	/**
	 * Class constructor.
	 * 
	 * @param c character of the tile
	 * @param i point value of the tile
	 */
	public Tile_CE_085(char c, int i){
		_letter = c;
		_pointValue = i;
		_color = new Color(250,250,250);
		_textColor = _color;
		String buttonLetter = ""+c;
		_selected=null;
		_past=null;
		
	}// Tile
	
	/**
	 * Gets the character value of the tile.
	 * 
	 * @return character value of the tile.
	 */
	public char getChar(){ return _letter;}// getChar
	
	/**
	 * Gets the point value of the tile.
	 * 
	 * @return the point value of the tile.
	 */
	
	public void setChar(char _char){
		_letter = _char;
	}
	
	/**
	 * An accessor method that returns the point value of the Tile
	 * @return the point value
	 * @author ajnenno2 (Andrew Nenno)
	 * @author sravanik (Sravanika Doddi)
	 * @author ssingh32 (Simran Singh)
	 */
	public int getValue(){ return _pointValue;}// getValue
	
	/**
	 * A mutator method that changes the color associated with the Tile
	 * @return ajnenno2 (Andrew Nenno)
	 * @param c the color
	 */
	public void setColor(Color c){ 
		_color = c;
	}
	
	/**
	 * A mutator method that changes the color of the text of the Tile that shows up on the JButton associated with the Tile
	 * @param c the color you want to set the text to
	 * @author ajnenno2 (Andrew Nenno)
	 */
	public void setTextColor(Color c){
		_textColor = c;
	}
	
	/**
	 * An accessor method that returns the color of the Tile
	 * @return
	 * @author ajnenno2 (Andrew Nenno)
	 * @author ssingh32 (Simran Singh)
	 */
	public Color getColor() { return _color;}
	
	/**
	 * An accessor method that returns the color of the text of the Tile
	 * @return
	 * @author ajnenno2 (Andrew Nenno)
	 */
	public Color getTextColor(){ return _textColor;}
	
	public void setSelected(Tile_CE_085 t){ _selected=t;}
	
	public Tile_CE_085 getSelected(){ return _selected;}
	
	public void setPast(Tile_CE_085 t){ _past=t;}
	
	public Tile_CE_085 getPast(){ return _past;}
	
	/**
	 * Used so that two players cannot place a Tile in the same place
	 * @return
	 * @author sravanik (Sravanika Doddi)
	 */
	public boolean isEnabled(){
		return isEnabled;
	}
	
	/**
	 * A mutator method that changes the value of the enabled variable to either true or false
	 * @param enabled
	 * @author sravanik (Sravanika Doddi)
	 */
	public void setEnabled(boolean enabled){
		isEnabled = enabled;
	}
	
	/**
	 * Checks if the Tile has no letter or point value associated with it
	 * @return true if the Tile is blank, false if it isn't blank
	 * @author ajnenno2 (Andrew Nenno)
	 * @author sravanik (Sravanika Doddi)
	 * @author ssingh32 (Simran Singh)
	 */
	public boolean isEmpty(){
		if((this.getChar()==' ')&&(this.getValue()==0)){
			return true;
		}
		return false;
	}
	
}// Tile class
