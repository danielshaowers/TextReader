package linkedListPractice;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

import HW4.TextAnalyze;
import HW4.WordCount;
public class TextAnalyzeTester {
	/**
	 * tests radixSort method
	 */
	@Test
	public void radixSortTester() {
		LinkedList<WordCount> wc = new LinkedList<WordCount>();
		LinkedList<WordCount> wc2 = new LinkedList<WordCount>();
		wc.addToEnd(new WordCount("bbc"));
		wc.addToEnd(new WordCount("ebc"));
		wc.addToEnd(new WordCount("dbc"));
		wc.addToEnd(new WordCount("cbc"));
		wc.addToEnd(new WordCount("abc"));		
		//test first character difference
		assertEquals("first string incorrect", "abc", TextAnalyze.radixSort(wc).getFirst().getElement().getWord());	
		assertEquals("second string incorrect", "bbc", TextAnalyze.radixSort(wc).getFirst().getNext().getElement().getWord());	
		assertEquals("second string incorrect", "cbc", TextAnalyze.radixSort(wc).getFirst().getNext().getNext().getElement().getWord());	
		assertEquals("second string incorrect", "dbc", TextAnalyze.radixSort(wc).getFirst().getNext().getNext().getNext().getElement().getWord());	
		
		//test middle character difference
		wc2.addToEnd(new WordCount("acc"));
		wc2.addToEnd(new WordCount("abc"));
		wc2.addToEnd(new WordCount("adc"));
		wc2.addToEnd(new WordCount("aec"));
		wc2.addToEnd(new WordCount("aac"));
		assertEquals("aac", TextAnalyze.radixSort(wc2).getFirst().getElement().getWord());
		assertEquals("abc", TextAnalyze.radixSort(wc2).getFirst().getNext().getElement().getWord());
		assertEquals("acc", TextAnalyze.radixSort(wc2).getFirst().getNext().getNext().getElement().getWord());
		assertEquals("adc", TextAnalyze.radixSort(wc2).getFirst().getNext().getNext().getNext().getElement().getWord());
		assertEquals("aec", TextAnalyze.radixSort(wc2).getFirst().getNext().getNext().getNext().getNext().getElement().getWord());
		
		//test last character difference
		LinkedList<WordCount> wc3 = new LinkedList<WordCount>();
		wc3.addToEnd(new WordCount("abe"));
		wc3.addToEnd(new WordCount("abd"));
		wc3.addToEnd(new WordCount("abf"));
		wc3.addToFront(new WordCount("abc"));
		wc3.addToFront(new WordCount("abc"));
		wc3.addToEnd(new WordCount("abg"));
		wc3.addToFront(new WordCount("abc"));
		LinkedList<WordCount> wc4 = TextAnalyze.radixSort(wc3);
		assertEquals(3, TextAnalyze.radixSort(wc4).getFirst().getElement().getCount());
		assertEquals("abc", TextAnalyze.radixSort(wc4).getFirst().getElement().getWord());
		assertEquals("abd",TextAnalyze.radixSort(wc4).getFirst().getNext().getElement().getWord());
		assertEquals("abe",TextAnalyze.radixSort(wc4).getFirst().getNext().getNext().getElement().getWord());
		assertEquals("abf",TextAnalyze.radixSort(wc4).getFirst().getNext().getNext().getNext().getElement().getWord());
		assertEquals("abg",TextAnalyze.radixSort(wc4).getFirst().getNext().getNext().getNext().getNext().getElement().getWord());
		//test first alphabet characters
		wc = new LinkedList<WordCount>();
		wc.addToEnd(new WordCount("c"));
		wc.addToEnd(new WordCount("a"));
		wc.addToEnd(new WordCount("b"));
		wc2 = TextAnalyze.radixSort(wc);
		assertEquals("a", wc2.getFirst().getElement().getWord());
		assertEquals("b", wc2.getFirst().getNext().getElement().getWord());
		assertEquals("c", wc2.getFirst().getNext().getNext().getElement().getWord());
		//test middle alphabet characters
		wc = new LinkedList<WordCount>();
		wc.addToEnd(new WordCount("n"));
		wc.addToEnd(new WordCount("m"));
		wc.addToEnd(new WordCount("l"));
		wc2 = TextAnalyze.radixSort(wc);
		assertEquals("l", wc2.getFirst().getElement().getWord());
		assertEquals("m", wc2.getFirst().getNext().getElement().getWord());
		assertEquals("n", wc2.getFirst().getNext().getNext().getElement().getWord());
		//test last alphabet characters
		wc = new LinkedList<WordCount>();
		wc.addToEnd(new WordCount("z"));
		wc.addToEnd(new WordCount("y"));
		wc.addToEnd(new WordCount("x"));
		wc2 = TextAnalyze.radixSort(wc);
		assertEquals("x", wc2.getFirst().getElement().getWord());
		assertEquals("y", wc2.getFirst().getNext().getElement().getWord());
		assertEquals("z", wc2.getFirst().getNext().getNext().getElement().getWord());
		
		//test string length
		wc = new LinkedList<WordCount>();
		wc.addToEnd(new WordCount("a"));	//test 1
		wc.addToEnd(new WordCount("")); 	//test 0
		wc.addToEnd(new WordCount("aaaa")); //test many
		wc.addToEnd(new WordCount("aaa"));	
		wc.addToEnd(new WordCount("aa"));
		wc2 = TextAnalyze.radixSort(wc);
		assertEquals("", wc2.getFirst().getElement().getWord());
		assertEquals("a", wc2.getFirst().getNext().getElement().getWord());
		assertEquals("aa", wc2.getFirst().getNext().getNext().getElement().getWord());
		assertEquals("aaa", wc2.getFirst().getNext().getNext().getNext().getElement().getWord());
		assertEquals("aaaa", wc2.getFirst().getNext().getNext().getNext().getNext().getElement().getWord());
		
		//test uppercase 
		wc = new LinkedList<WordCount>();
		wc.addToEnd(new WordCount("A"));
		wc.addToEnd(new WordCount("E"));
		wc.addToEnd(new WordCount("D"));
		wc.addToEnd(new WordCount("B"));
		wc.addToEnd(new WordCount("C"));
		wc.addToEnd(new WordCount("a"));
		wc.addToEnd(new WordCount("A"));
		
		wc2 = TextAnalyze.radixSort(wc);
		assertEquals(3, wc2.getFirst().getElement().getCount());
		assertEquals("a", wc2.getFirst().getElement().getWord());
		assertEquals("b",wc2.getFirst().getNext().getElement().getWord());
		assertEquals("c",wc2.getFirst().getNext().getNext().getElement().getWord());
		assertEquals("d",wc2.getFirst().getNext().getNext().getNext().getElement().getWord());
		assertEquals("e",wc2.getFirst().getNext().getNext().getNext().getNext().getElement().getWord());
		
		LinkedList<WordCount> wc5 = new LinkedList<WordCount>();
		wc5.addToEnd(new WordCount("Abc")); //test first uppercase
		wc5.addToEnd(new WordCount("aBc")); //test middle uppercase
		wc5.addToEnd(new WordCount("abC")); //test last uppercase
		wc5.addToEnd(new WordCount("aBC"));
		wc5.addToEnd(new WordCount("abc")); //test if lower case and uppercase become same word
		wc5.addToEnd(new WordCount("AB"));
		wc5.addToEnd(new WordCount("Ab"));
		wc5.addToEnd(new WordCount("aB"));
		
		LinkedList<WordCount> wc6 = TextAnalyze.radixSort(wc5);
		assertEquals("ab", wc6.getFirst().getElement().getWord());
		assertEquals(3, wc6.getFirst().getElement().getCount());
		assertEquals("abc", (wc6).getFirst().getNext().getElement().getWord());
		assertEquals(5, wc6.getFirst().getNext().getElement().getCount());
		
		assertEquals(null, wc6.getFirst().getNext().getNext());
		
		
			}
	/**
	 * Tests addFirstInstance method
	 */
	@Test
	public void addFirstInstanceTester() {
		LinkedList<WordCount> wc = new LinkedList<WordCount>();
		//test zero
		TextAnalyze.addFirstInstance(wc, new WordCount(null));
		assertEquals("tests empty wordcount addition", null, wc.getFirst().getElement().getWord());
		wc = new LinkedList<WordCount>();
		//test one
		TextAnalyze.addFirstInstance(wc, new WordCount("a"));
		TextAnalyze.addFirstInstance(wc, new WordCount("b"));
		TextAnalyze.addFirstInstance(wc, new WordCount("b"));
		assertEquals("first wordcount added incorrectly", "a", wc.getFirst().getElement().getWord());
		assertEquals("first wordcount count incorrect", 1, wc.getFirst().getElement().getCount());
		assertEquals("second wordcount added incorrectly", "b", wc.getFirst().getNext().getElement().getWord());
		assertEquals("second count incorrect", 2, wc.getFirst().getNext().getElement().getCount());
		assertEquals("third word not omitted", null, wc.getFirst().getNext().getNext());
		assertEquals("second word count not updated", 2, wc.getFirst().getNext().getElement().getCount());
		wc = new LinkedList<WordCount>();
		//test many
		TextAnalyze.addFirstInstance(wc, new WordCount("abcdefgg"));
		TextAnalyze.addFirstInstance(wc, new WordCount("abcdefghijklmnop"));
		TextAnalyze.addFirstInstance(wc, new WordCount("abcdefghijklmnop"));
		TextAnalyze.addFirstInstance(wc, new WordCount("abcdefghijklmnop"));
		TextAnalyze.addFirstInstance(wc, new WordCount("abcdefghijklmnop"));
		TextAnalyze.addFirstInstance(wc, new WordCount("abcdefghijklmnop"));
		TextAnalyze.addFirstInstance(wc, new WordCount("abcdefgg"));
		assertEquals("first word added incorrectly", "abcdefgg", wc.getFirst().getElement().getWord());
		assertEquals("first count incorrect", 1, wc.getFirst().getElement().getCount());
		assertEquals("second word incorrect", "abcdefghijklmnop", wc.getFirst().getNext().getElement().getWord());
		assertEquals("second count incorrect", 5, wc.getFirst().getNext().getElement().getCount());
		assertEquals("third word incorrect", "abcdefgg", wc.getFirst().getNext().getNext().getElement().getWord());
		assertEquals("third count incorrect", 1, wc.getFirst().getNext().getNext().getElement().getCount());
		
	
	}
}
