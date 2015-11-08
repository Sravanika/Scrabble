package code;

import java.util.ArrayList;

import javax.swing.SwingUtilities;

import ui.ScrabbleUI_085;

public class Driver {
	//Team t085 Made it//

	    private static String _dictionaryFilePath;
	    private static String _restoreFilePath;
	    private static Scrabble_CE_085 _scrabbleModel;
	    private static ArrayList<String> _arrayString;
	    
	    /**
	     * The method used when one runs the game
	     * @param args
	     * @author ajnenno2 (Andrew Nenno)
	     * @author sravanik (Sravanika Doddi)
	     */
	    
	    public static void main(String[] args) {
	    	_arrayString = new ArrayList<String>();
	      	if (args.length == 1) {
	    		_restoreFilePath = args[0];
	    	}
	    	else {
	    		_dictionaryFilePath=args[0];
	    		for(int i=1; i<args.length; i++){
	    			_arrayString.add(args[i]);
	    		}

	    	}
	      	 _scrabbleModel = new Scrabble_CE_085(_dictionaryFilePath, _arrayString);
			SwingUtilities.invokeLater(new ScrabbleUI_085(_scrabbleModel));
	    }

	}


