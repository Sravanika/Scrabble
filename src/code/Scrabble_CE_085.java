package code;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Scanner;

public class Scrabble_CE_085 extends Observable{

	/**
	 * Stores tiles.
	 */
	private Inventory_CE _inv;
	/**
	 * Stores players.
	 */
	private ArrayList<Player_CE_085> _players;
	/**
	 * tile board to be played on
	 */
	private Board_CE_085 _board;
	/**
	 * Number of players
	 */

	private Dictionary_085 _dictionary;
	private String _dictionaryPath;
	private ArrayList<Position> _placedTiles;
	private Position _current;
	private Position _past;
	private Position[][] _boardArray;
	private ArrayList<String> _arrayNames;
	private static String _word;
	


	/**
	 * Class constructor
	 * @param _names 
	 */
	public Scrabble_CE_085(String dictionaryPath, ArrayList<String> _arrayString){
		_inv = new Inventory_CE();
		_board = new Board_CE_085();
		_dictionaryPath=dictionaryPath;
		_dictionary = new Dictionary_085(dictionaryPath);
		_arrayNames = new ArrayList<String>();
		_arrayNames = _arrayString;
		_players=new ArrayList<Player_CE_085>();
//		_players = new ArrayList<Player_CE_085>();
		_placedTiles=new ArrayList<Position>();
		_boardArray=_board.getBoardArray();
		_current=null;
		_past=null;
		setChanged();
		notifyObservers();
		
		for (int i = 0; i < _arrayNames.size(); i++){ 

			Player_CE_085 p = new Player_CE_085(_inv,_board);
			p.setName(_arrayNames.get(i));
			_players.add(p);
		}// for
	}
	/**
	 * Adds a new player to the game.
	 */
//	public void addNewPlayer(){ _players.add(new Player_CE_085(_inv, _board));}// addNewPlayer

	/**
	 * Switches the Player who is at index 0 of the ArrayList
	 * @author ajnenno2 (Andrew Nenno)
	 * @author ssingh32 (Simran Singh)
	 * @author sravanik (Sravanika Doddi)
	 */
	public void switchPlayers(){ _players.add(_players.remove(0));}
		

	/**
	 * An accessor method that returns the board in the Scrabble game
	 * @return
	 * @author ajnenno2 (Andrew Nenno)
	 */
	public Board_CE_085 getBoard(){ return _board;}// getBoard
	
	
	/**
	 * Returns the Player at index 0 of the Player ArrayList
	 * @return
	 * @author ajnenno2 (Andrew Nenno)
	 * @author sravanik (Sravanika Doddi)
	 */
	public Player_CE_085 getPlayer(){ return _players.get(0);}
	
	/**
	 * An accessor method that returns the ArrayList of Players
	 * @return
	 * @author ajnenno2 (Andrew Nenno)
	 * @author sravanik (Sravanika Doddi)
	 */
	public ArrayList<Player_CE_085> getPlayers(){
		return _players;
	}
	
	public ArrayList<String> getNames() {
		return _arrayNames;
	}
	
	/**
	 * An accessor method that returns the Inventory
	 * @return
	 * @author ajnenno2 (Andrew Nenno)
	 * @author sravanik (Sravanika Doddi)
	 */
	public Inventory_CE getInventory(){
		return _inv;
	}
	
	/**
	 * An accessor method that returns the Dictionary class
	 * @return
	 * @author ajnenno2 (Andrew Nenno)
	 * @author sravanik (Sravanika Doddi)
	 */
	public Dictionary_085 getDictionary(){
		return _dictionary;
	}
	
	/**
	 * An accessor method that returns the String used for the Dictionary
	 * @return
	 * @author ajnenno2 (Andrew Nenno)
	 * @author sravanik (Sravanika Doddi)
	 */
	public String getDictionaryPath(){
		return _dictionaryPath;
	}
	
	/**
	 * An accessor method that returns the ArrayList of Tiles that were placed
	 * @return
	 * @author ajnenno2 (Andrew Nenno)
	 * @author sravanik (Sravanika Doddi)
	 */
	public ArrayList<Position> getPlacedTiles(){
		return _placedTiles;
	}
	
	/**
	 * A method that resets the ArrayList of Tiles to have nothing in it
	 * @return
	 * @author ajnenno2 (Andrew Nenno)
	 * @author sravanik (Sravanika Doddi)
	 */
	public void resetPlacedTiles(){
		_placedTiles=new ArrayList<Position>();
	}
	
	public String save(Inventory_CE iv, ArrayList<Player_CE_085> arrayPlayers) {
		String answer = "";
		answer = answer + 20 + " " + 20 + "\n";
		answer = answer + this.getDictionaryPath() + "\n";
		for (int i = 0; i < this.getPlayers().size(); i++) {
			Player_CE_085 temp = this.getPlayers().get(i);
			answer = answer + "[" + temp.getName() + "," + temp.getColor() + "," 
			+ temp.scoreToString() + "," + "[" + temp.getTileRack().toString() + "]]";
			if (i != this.getPlayers().size() - 1) {
				answer = answer + ",";
			}
		}
		answer = answer + "\n" + "" + this.getInventory().toString() + "\n";
		for (int y = 0; y < 20; y++) {
			for (int x = 0; x < 20; x++) {
				Tile_CE_085 t = this.getBoard().getTile(x, y);
				char temp = this.getBoard().getTile(x, y).getChar();
				for (int i = 0; i < this.getPlayers().size(); i++) {
					if (temp == ' ') {
						answer = answer + temp;
					}
					else if (t.getColor() == this.getPlayers().get(i).getColor()) {
					answer = answer + "[" + this.getBoard().getTile(x, y).getChar() + "," + this.getPlayers().get(i).getName() + "]";
					}
				}
				
			}
		}
		System.out.println(answer);
		System.out.println(this.getPlayers().size());
		return answer;
	}
	
	public void restore(String filePath) {
		Scanner scan = null;
		try {
			scan = new Scanner(new File(filePath));
			for (int i = 0; i < filePath.length(); i++) {
				int currentState = 1;
				switch(currentState) {
				case 1:
					if (filePath.charAt(i) == '\n') {currentState = 2;}
					else {currentState = 1;}
				case 2: 
					if (filePath.charAt(i) == '\n') {currentState = 3;}
					else {currentState = 2;}
				case 3:
					if (filePath.charAt(i) == '\n') {currentState = 4;}
					else {currentState = 3;}
				case 4:
					if (filePath.charAt(i) == '\n') {
						String name = "";
						while(!filePath.endsWith("]")) {
							name = name + filePath.charAt(i);
						}
						System.out.println(name);
						currentState = 5;
					}
					else {
						currentState = 1;
					}
				}
//			int lineNumber = 0;
//			while (scan.hasNextLine()) {
//				String oneLineFromFile = scan.nextLine();
//				System.out.format("Line #%3d, of length %3d, is \"%s\"%n", lineNumber, oneLineFromFile.length(), oneLineFromFile);
//				lineNumber++;
			}
 		} catch (FileNotFoundException e) {
			System.err.println("File not found: "+filePath);
		}
		finally {
			scan.close();
		}
	}

	/**
	 * A method that is called when a button on the board is pressed
	 * @return
	 * @author ajnenno2 (Andrew Nenno)
	 */
	public void boardButtonPressed(int x, int y){
		_current = _boardArray[x][y];
		Position temp = _boardArray[x][y];
		if(_past!=null){
			_board.addTile(_past, x, y);
//			placeTile(_past, x, y);
			_boardArray[x][y].setLetterMultiplier(temp.getLetterMultiplier());
			_boardArray[x][y].setWordMultiplier(temp.getWordMultiplier());
			_word+=_past.getTile().getChar();
			_placedTiles.add(_past);
			_past=null;
		}//if
		else if(_past==null){ _past=_current;}	
	}// boardButtonPressed

	/**
	 * A method that is called when a button on the tile rack is pressed
	 * @return
	 * @author ajnenno2 (Andrew Nenno)
	 */
	public void tileRackButtonPressed(int index){
		_current=_players.get(0).getTileRack().getTile(index);
		if(_past==null){ _past=_current;}
		else if(_past!=null){
			int x = _board.getXCoord(_past);
			int y = _board.getYCoord(_past);
			Position temp = _board.getPosition(x, y);
			_current.setLetterMultiplier(temp.getLetterMultiplier());
			_current.setWordMultiplier(temp.getWordMultiplier());
//			placeTile(_current, x, y);
			_board.addTile(_current, x, y);
			_placedTiles.add(_current);
			_word+=_current.getTile().getChar();
			_past=null;
		}// else if
	}// tileRackButtonPressed

	public void endTurnButtonPressed(){
		String word = "";
		if(checkValidXPlacements()||checkValidYPlacements()){
			for(int i=0; i<_placedTiles.size(); i++){
				word+=_placedTiles.get(i).getTile().getChar();
			}
			if(_dictionary.containsWord(word)){
				_players.get(0).incrementScore(_dictionary.calculateScore(word));
			}
			
		}
		else{
			removePlacedTiles();
		}
		resetPlacedTiles();
		switchPlayers();
	}
	/**
	 * A method that adds a Position to the board and adds that Position to _placedTiles
	 * @return
	 * @author ajnenno2 (Andrew Nenno)
	 */
	public void placeTile(Position p, int x, int y){ _placedTiles.add(_board.addTile(p, x, y));}

	/**
	 * A method that checks to see if the tiles placed have valid placements in the x direction
	 * @return boolean
	 * @author ajnenno2 (Andrew Nenno)
	 */
	public boolean checkValidXPlacements(){
		int yi= _board.getYCoord(_placedTiles.get(0));
		for(Position p : _placedTiles){
			if(_board.getYCoord(p)!=yi){ return false;}
		}
		for(int i=0; i<_placedTiles.size()-1; i++){
			int x1=_board.getXCoord(_placedTiles.get(i));
			int x2=_board.getXCoord(_placedTiles.get(i+1));
			if(x1!=19&&x2!=0){ return (x2-x1)==1;}
			else{ return x1==19&&x2==0;}
		}

		return false;
	}

	/**
	 * A method that checks to see if the tiles placed have valid placements in the y direction
	 * @return boolean
	 * @author ajnenno2 (Andrew Nenno)
	 */
	public boolean checkValidYPlacements(){
		int xi= _board.getXCoord(_placedTiles.get(0));
		for(Position p : _placedTiles){
			if(_board.getXCoord(p)!=xi){ return false;}
		}
		for(int i=0; i<_placedTiles.size()-1; i++){
			int y1=_board.getYCoord(_placedTiles.get(i));
			int y2=_board.getYCoord(_placedTiles.get(i+1));
			if(y1!=19&&y2!=0){ return (y2-y1)==1;}
			else{ return y1==19&&y2==0;}
		}
		return false;
	}
	
	public void removePlacedTiles(){
		for(int i=0; i<_placedTiles.size(); i++){
			_board.removeTile(_board.getXCoord(_placedTiles.get(i)), _board.getYCoord(_placedTiles.get(i)));
		}	
	}
	
	public void addPlayer(Player_CE_085 p){ _players.add(p);}
	
}// Scrabble class


