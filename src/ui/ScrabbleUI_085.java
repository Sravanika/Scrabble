package ui;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Point;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Handlers.EndTurnHandler_085;
import Handlers.SaveHanlder_085;
import code.Board_CE_085;
import code.Scrabble_CE_085;
import code.Tile_CE_085;
import code.TileRack_CE_085;

public class ScrabbleUI_085 implements Observer, Runnable  {

	private static Scrabble_CE_085 _scrabble;
	private JPanel _boardPanel;
//	private TileHandler_085 _handler;
	private JFrame _window;
	private JPanel _boardEndTurnPanel;
	private JPanel _tileRackBigPanel;
	private JPanel[] _howManyTileRackPanels;
	private HashMap<JButton, Point> _boardButtons;
	private HashMap<JButton, Integer> _tileRackButtons;
	

	/**
	 * Class Constructor
	 * @param s
	 * @author ajnenno2 (Andrew Nenno)
	 * @author sravanik (Sravanika Doddi)
	 * @author ssingh32 (Simran Singh)
	 */
	public ScrabbleUI_085(Scrabble_CE_085 s) {
		_scrabble=s;
		_scrabble = new Scrabble_CE_085(s.getDictionaryPath(), s.getNames());
		_scrabble.addObserver(this);
		_boardButtons = new HashMap<JButton, Point>();
		_tileRackButtons = new HashMap<JButton, Integer>();
	}

	/**
	 * Starts up all of the components of the GUI
	 * @author ajnenno2 (Andrew Nenno)
	 * @author sravanik (Sravanika Doddi)
	 * @author ssingh32 (Simran Singh)
	 */
	@Override
	public void run() {
		_window = new JFrame();
		_window.setMinimumSize(new Dimension(1200,900));
		EndTurnHandler_085 e = new EndTurnHandler_085(_scrabble,this);
		_howManyTileRackPanels = new JPanel[_scrabble.getPlayers().size()];
		_tileRackBigPanel = new JPanel();
		for (int i = 0; i < _howManyTileRackPanels.length; i++) {
			_howManyTileRackPanels[i] = new JPanel();
		}
		_boardPanel = new JPanel();
		_boardPanel.setSize(400, 400);
		_boardEndTurnPanel = new JPanel();
		_boardPanel.setLayout(new GridLayout(20,20));
		_boardEndTurnPanel.add(_boardPanel);
//		_handler = new TileHandler_085(_scrabble, this);
		for (int j = 0; j < _howManyTileRackPanels.length; j++) {
			JButton jb = new JButton();
			jb.setText(_scrabble.getPlayers().get(j).getName());
			_howManyTileRackPanels[j].add(jb);
			_tileRackBigPanel.add(_howManyTileRackPanels[j]);
		}
		_tileRackBigPanel.setLayout(new BoxLayout(_tileRackBigPanel, BoxLayout.Y_AXIS));
		JPanel p2 = new JPanel();
		JButton j = new JButton("END TURN");
		j.addActionListener(e);
		j.setBackground(Color.ORANGE);
		JButton jb =new JButton("SAVE");
		jb.addActionListener(new SaveHanlder_085(_scrabble));
		jb.setBackground(Color.CYAN);
		p2.add(j);
		p2.add(jb);
		_boardEndTurnPanel.add(p2);
		
		JPanel windowPanel = (JPanel) _window.getContentPane();
		windowPanel.setLayout(new BoxLayout(windowPanel, BoxLayout.Y_AXIS));
		_window.add(_boardEndTurnPanel);
		_window.add(_tileRackBigPanel);
		this.update(null, _scrabble);
		_window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		_window.pack();
		_window.setVisible(true);
		_window.setBackground(Color.BLACK);
	}

	/**
	 * Copies and places all of the components on the Scrabble game into another Scrabble
	 * @author ajnenno2 (Andrew Nenno)
	 * @author sravanik (Sravanika Doddi)
	 * @author ssingh32 (Simran Singh)
	 */
	@Override
	public void update(Observable arg0, Object arg1) {
		_boardPanel.removeAll();
		Board_CE_085 board = _scrabble.getBoard();
		Tile_CE_085[][] array = board.getBoardTiles();

		for(int x=0; x<20; x++){
			for(int y=0; y<20; y++){
				JButton jb = new JButton();
				Tile_CE_085 t = array[x][y];
				jb.setText(""+t.getChar()+"("+t.getValue()+")");
				jb.setForeground(t.getTextColor());
				jb.setBackground(t.getColor());
				_boardPanel.add(jb);
//				jb.addActionListener(_handler);
				_boardButtons.put(jb, new Point(x, y));
			}
		}
		
		for (int i = 0; i < _scrabble.getPlayers().size(); i++) {
			_tileRackButtons = new HashMap<JButton, Integer>();
			JPanel jp = new JPanel();
			TileRack_CE_085 t = _scrabble.getPlayers().get(i).getTileRack();
			for (int j = 0; j < t.getSize(); j++) {
				JButton jb = new JButton();
				_howManyTileRackPanels[i].add(jb);
				jb.setBackground(_scrabble.getPlayers().get(i).getColor());
				jb.setText("" + t.getTile(j).getTile().getChar());
//				jb.addActionListener(_handler);
//				_tileRackButtons.put(jb, j);
			}
			jp.repaint();
			_tileRackBigPanel.add(jp);
		}
		_boardPanel.repaint();
	}
	
	public HashMap<JButton, Point> getBoardButtons(){ return _boardButtons;}
	
	public HashMap<JButton, Integer> getTileRackButtons(){ return _tileRackButtons;}
	
}