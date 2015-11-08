package tests;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.Test;

import code.Dictionary_085;

public class DictionaryTest_085 {

	@Test public void containsWordtest01() {containsWordCommonTest("HI",true);}
	@Test public void containsWordtest02() {containsWordCommonTest("POTATO",true);}
	@Test public void containsWordtest03() {containsWordCommonTest("SIMRAN",false);}
	@Test public void containsWordtest04() {containsWordCommonTest("SRAVANIKA",false);}
	@Test public void containsWordtest05() {containsWordCommonTest("ANDY",false);}
	@Test public void containsWordtest06() {containsWordCommonTest("FLOYD",false);}
	@Test public void containsWordtest07() {containsWordCommonTest("ENOUGH.",false);}
	
	public void containsWordCommonTest(String wordInput, boolean expected) {
		Dictionary_085 dict = new Dictionary_085("src/ui/Dictionary");
		boolean actual = dict.containsWord(wordInput);
		assertTrue("\nExpected was: "+expected+"\nActual was: "+actual, expected==actual);
	}
	
	@Test public void wordScoreCalculationtest01() {wordScoreCalculationCommonTest("hi",6);}
	@Test public void wordScoreCalculationtest02() {wordScoreCalculationCommonTest("potato",18);}
	@Test public void wordScoreCalculationtest03() {wordScoreCalculationCommonTest("add",11);}
	@Test public void wordScoreCalculationtest04() {wordScoreCalculationCommonTest("funky",18);}
	@Test public void wordScoreCalculationtest05() {wordScoreCalculationCommonTest("code",12);}
	@Test public void wordScoreCalculationtest06() {wordScoreCalculationCommonTest("CODE",12);}
	
	public void wordScoreCalculationCommonTest(String wordInput, int expected) {
		Dictionary_085 dict = new Dictionary_085("src/ui/Dictionary");
		String real = wordInput.toUpperCase();
		int actual = dict.calculateScore(real);
		assertTrue("\nExpected was: "+expected+"\nActual was: "+actual, expected==actual);
	}
	
	@Test public void getWordScoreCalculationtest01() {getWordScoreCommonTest("hi",6);}
	@Test public void getWordScoreCalculationtest02() {getWordScoreCommonTest("potato",18);}
	@Test public void getWordScoreCalculationtest03() {getWordScoreCommonTest("add",11);}
	@Test public void getWordScoreCalculationtest04() {getWordScoreCommonTest("funky",18);}
	@Test public void getWordScoreCalculationtest05() {getWordScoreCommonTest("code",12);}
	@Test public void getWordScoreCalculationtest06() {getWordScoreCommonTest("CODE",12);}
	
	public void getWordScoreCommonTest(String wordInput, int expected) {
		Dictionary_085 dict = new Dictionary_085("src/ui/Dictionary");
		String real = wordInput.toUpperCase();
		int actual = dict.getWordScore(real);
		assertTrue("\nExpected was: "+expected+"\nActual was: "+actual, expected==actual);
	}

}
