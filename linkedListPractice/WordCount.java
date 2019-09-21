package linkedListPractice;
/**
 * A class that stores a word and word count
 * @author daniel shao
 *
 */
public class WordCount {
	private String word;		//a string stored by the word count
	private int count = 1;		//an int storing the word count
	/**
	 *a constructor that sets the stored word as the string input
	 *@param word the string to be stored as a word.  
	 **/
	public WordCount(String word) {
		this.word = word;
	}
	/**
	 * obtains the count of WordCount
	 * @return the count stored by WordCount
	 */
	
	public int getCount() {
		return count;
	}
	/**
	 * 
	 * @return the string stored by wordcount
	 */
	public String getWord() {
		return word;
	}
	/**
	 * sets the count to the value input
	 * @param value the new count of WordCount
	 */
	public void setCount(int value) {
		count = value;
	}
	/**
	 * sets the word to the string input
	 * @param s the new word to be stored
	 */
	public void setWord(String s) {
		word = s;
	}

}
