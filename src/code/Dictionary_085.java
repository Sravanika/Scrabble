package code;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class Dictionary_085 {
	

private HashMap<String, Integer> _dict;

/**
 * Constructor of the dictionary 
 * @param inputFilePath -returns the path
 */
	
	public Dictionary_085(String inputFilePath){
		_dict=new HashMap<String, Integer>();
		readFileDictionary(inputFilePath);
	}// Dictionary
	
	/**
	 * Goes through a file, sets all the words in that file to capital letters, 
	 * and puts that word in a HashMap with a score calculated by the calculateScore method 
	 * @param Dictionary the file that will be read and used as a dictionary
	 * @author ajnenno2 (Andrew Nenno)
	 * @author ssingh32 (Simran Singh)
	 */
	
	public void readFileDictionary(String Dictionary) {
		Scanner scan = null;
		try {
			scan = new Scanner(new File(Dictionary));
			int lineNumber = 0;
			while (scan.hasNextLine()) {
				String oneLineFromFile = scan.nextLine();
				String wordCaps = oneLineFromFile.toUpperCase();
				_dict.put(wordCaps, calculateScore(wordCaps));
				lineNumber++;
			}// try
 		} catch (FileNotFoundException e) { System.err.println("File not found: "+Dictionary);}// catch
		finally { scan.close();}// finally
	}// readFileDictionary
	
	/**
	 * Checks if a string is in the HashMap that was created from the Dictionary constructor. 
	 * If found, returns true; if not, returns false.
	 * @param s the String you want to find in the HashMap
	 * @return boolean true if parameter is in the HashMap and false if parameter is in the HashMap
	 * @author ajnenno2 (Andrew Nenno)
	 */
	public boolean containsWord(String s){
		if(_dict.containsKey(s)){ return true;}// if
		return false;
	}// containsWord
	
	/**
	 * Returns the point value associated with a word from the Dictionary's HashMap
	 * @param s the String you want to find the score of
	 * @return the score, but if the word does not exist in the dictionary returns 0
	 * @author ajnenno2 (Andrew Nenno)
	 */
	
	public int getWordScore(String s){
		if(containsWord(s)){ return _dict.get(s);}// if
		return 0;
	}// getWordScore
	
	/**
	 * Calculates the score of a word passed in as the parameter
	 * @param s the word that will be converted to a point value by scrabble's rules
	 * @return the point value of the word passed in the parameter
	 * @author ajnenno2 (Andrew Nenno)
	 */

	public int calculateScore(String s){
		int score =0;
		for(int i=0; i<s.length(); i++){
			char c=s.charAt(i);
			boolean case1 = (c=='A'||c=='E'||c=='I'||c=='O'||c=='U');
			boolean case2 = c=='Y';
			if(case1){ score+=1;}// if case 1
			else if(case2){ score+=2;}// if case 2
			else if(!case1&&!case2&&c<='Z'&&'A'<c){ score+=5;}// if case 3
		}// for
		return score;
	}// calculate score

}// dictionary class

