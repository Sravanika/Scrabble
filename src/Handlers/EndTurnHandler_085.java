package Handlers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import ui.ScrabbleUI_085;
import code.Scrabble_CE_085;

public class EndTurnHandler_085 implements ActionListener{
	
	private Scrabble_CE_085 _scrabble;
	private ScrabbleUI_085 _scrabbleUI;
	
	/**
	 * Class constructor
	 * @param scrabble
	 * @author ssingh32 (Simran Singh)
	 */
	public EndTurnHandler_085(Scrabble_CE_085 scrabble, ScrabbleUI_085 scrabbleUI) {
		_scrabble = scrabble;
		_scrabbleUI = scrabbleUI;
		
	}
	
	/**
	 * Switches the players once the button is pressed and changes the Tile Rack in the GUI
	 * @author ssingh32 (Simran Singh)
	 * @author ajnenno2 (Andrew Nenno)
	 * @author sravanik (Sravanika Doddi)
	 */
	@Override
	public void actionPerformed(ActionEvent e){
		_scrabble.switchPlayers();
		System.out.println(_scrabble.getPlayers().get(0).getName());
	     
	}
}

