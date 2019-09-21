/**
 * Daniel Shao
 * 
 */
package linkedListPractice;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


import org.junit.Test;
public class WordCountTester {
	/**
	 * tests the get and set string methods
	 */
	@Test
	public void getWordSetWordTester() {
		WordCount a = new WordCount("one");
		assertTrue(a.getWord().equals("one"));
		assertFalse(a.getWord().equals(null));
		
		a.setWord("two");
		assertTrue(a.getWord().equals("two"));
		assertFalse(a.getWord().equals("one"));
	}
	
	/**
	 * Tests the get and set counter methods
	 */
	@Test
	public void getCountSetCount() {
		WordCount a = new WordCount("one");
		assertEquals(1, a.getCount());
		a.setCount(40);
		assertEquals(40, a.getCount());
	}
}
