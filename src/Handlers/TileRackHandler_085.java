package Handlers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;

import ui.ScrabbleUI_085;
import code.Scrabble_CE_085;

public class TileRackHandler_085 implements ActionListener {

	private Scrabble_CE_085 _scrabble;
	private ScrabbleUI_085 _ui;
	
	public TileRackHandler_085(Scrabble_CE_085 s, ScrabbleUI_085 ui){
		_scrabble=s;
		_ui=ui;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton jb = (JButton)e.getSource();
		HashMap<JButton, Integer> map = _ui.getTileRackButtons();
		int index = map.get(jb);
		_scrabble.tileRackButtonPressed(index);
	}

}