package Handlers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import ui.ScrabbleUI_085;
import code.Board_CE_085;
import code.Scrabble_CE_085;
import code.TButton_085;
import code.Tile_CE_085;

//public class TileHandler_085 implements ActionListener {
//	private Scrabble_CE_085 _scrabble;
//	private ScrabbleUI_085 _scrabbleUI;
//	private Tile_CE_085 _tile = null;
//	private ArrayList<Tile_CE_085> _placed;
//	private Board_CE_085 _board;
//	private String _word;
//	
//	/**
//	 * Class constructor
//	 * A handler for all of the tiles
//	 * @param _scrabble
//	 * @author sravanik (Sravanika Doddi)
//	 */
//	public TileHandler_085(Scrabble_CE_085 scrabble, ScrabbleUI_085 scrabbleUI) {
//		this._scrabble = scrabble;
//		this._scrabbleUI = scrabbleUI;
//		_placed=_scrabble.getPlacedTiles();
//		_board=_scrabble.getBoard();
//	}
//	
//	/**
//	 * Visually changes the board so it appears that a Tile is being placed on the board
//	 * @author sravanik (Sravanika Doddi)
//	 */
//	@Override
//	public void actionPerformed(ActionEvent e) {
//		Tile_CE_085 tile = ((TButton_085) e.getSource()).getTile();
//		if(tile.isEnabled()){
//			if(tile.getChar() == ' '){
//				if(_tile != null){
//					tile.setColor(_tile.getColor());
//					tile.setTextColor(_tile.getTextColor());
//					tile.setChar(_tile.getChar());
//					tile.setEnabled(false);
//					_scrabble.getPlayer().getTileRack().removeTile(_scrabble.getPlayer().getTileRack().getIndex(_tile));
//					_tile = null;
//				}
//			}
//			else{ _tile = tile;}
//		}
//		
//	}
//	
//	/**
//	 * Computes points of the word in either the x or the y direction
//	 * @param direction
//	 * @return
//	 * @author ajnenno2 (Andrew Nenno)
//	 */
//	public String getWord(char direction){
//		int start1=0;
//		int start2=0;
//		int end1=0;
//		int end2=0;
//		int x=0;
//		int y=0;
//		String word="";
//		if(direction=='X'){
//			y=_board.getYCoord(_placed.get(0));
//			start1=_board.getXCoord(_placed.get(0));
//			end1=_board.getXCoord(_placed.get(_placed.size()-1));
//			if(end1<start1){
//				start2=0;
//				end2=end1;
//				end1=19;
//				for(int i=start1; i<=end1; i++){ word+=_board.getTile(i, y).getChar();}
//				
//				for(int i=start2; i<=end2; i++){ word+=_board.getTile(i, y).getChar();}
//			}// if
//			else{
//				for(int i=start1; i<=end1; i++){ word+=_board.getTile(i, y).getChar();}
//			}// else
//		}// if X
//		if(direction=='Y'){
//			x=_board.getXCoord(_placed.get(0));
//			start1=_board.getYCoord(_placed.get(0));
//			end1=_board.getYCoord(_placed.get(_placed.size()-1));
//			if(end1<start1){
//				start2=0;
//				end2=end1;
//				end1=19;
//				for(int i=start1; i<=end1; i++){ word+=_board.getTile(x, i).getChar();}
//				
//				for(int i=start2; i<=end2; i++){ word+=_board.getTile(x, i).getChar();}
//			}// if
//			else{
//				for(int i=start1; i<=end1; i++){ word+=_board.getTile(x, i).getChar();}
//			}// else
//		}// if Y
//		
//		return word;
//	}
//}
