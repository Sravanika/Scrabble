package code;

import javax.swing.JButton;

public class TButton_085 extends JButton {
	
	private Tile_CE_085 _t;
	
	/**
	 * Class Constructor that is a wrapper class of the Jbutton class
	 * @param buttonLetter
	 * @param t
	 * @author ajnenno2 (Andrew Nenno)
	 * @author sravanik (Sravanika Doddi)
	 * @author ssingh32 (Simran Singh)
	 */
	public TButton_085(String buttonLetter, Tile_CE_085 t){
		super(buttonLetter);
		_t=t;
	}
	
	/**
	 * An accessor method that refers to a Tile
	 * @return
	 * @author ajnenno2 (Andrew Nenno)
	 * @author sravanik (Sravanika Doddi)
	 * @author ssingh32 (Simran Singh)
	 */
	public Tile_CE_085 getTile(){
		return _t;
	}
	
}
