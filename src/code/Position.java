package code;

public class Position {

	private int _wordMultiplier;
	private int _letterMultiplier;
	private Tile_CE_085 _t;
	
	public Position(int wordMultiplier, int letterMultiplier, Tile_CE_085 t){
		_wordMultiplier=wordMultiplier;
		_letterMultiplier=letterMultiplier;
		_t=t;
	}
	
	public void setWordMultiplier(int input){ _wordMultiplier=input;}
	
	public int getWordMultiplier(){ return _wordMultiplier;}
	
	public void setLetterMultiplier(int input){ _letterMultiplier=input;}
	
	public int getLetterMultiplier(){ return _letterMultiplier;}
	
	public void setTile(Tile_CE_085 input){ _t=input;}
	
	public Tile_CE_085 getTile(){ return _t;}
	
	
}
