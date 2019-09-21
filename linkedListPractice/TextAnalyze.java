/**
 * A class that analyzes the words of text files and creates new text files with the words sorted and the word counts returned
 */
package linkedListPractice;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.FileAlreadyExistsException;
import java.util.NoSuchElementException;

import HW4.WordCount;

public class TextAnalyze {
	/*
	 * a method that adds the cord to the end of a linked list if the last element of the linked list is a different word than the word being added. 
	 * Increases the wordcount by one if the words are identical
	 * @param list a list of words
	 * @ param word a wordcount containing an english word that will be added if it is the first instance of the wordcount
	 */
	public static void addFirstInstance(LinkedList<WordCount> list, WordCount word) {
		LinkedListIterator<WordCount> it = list.iterator();
		WordCount lastWordCount = new WordCount("1");  //an impossible wordcount, since it's a param that the word is english
		//sets lastWord = last wordcount in the linked list
		while (it.hasNext()) 
			lastWordCount = it.next().getElement();
		if (lastWordCount.getWord().equals(word.getWord())) 
			lastWordCount.setCount(lastWordCount.getCount() + word.getCount());
		else
			list.addToEnd(word);
	}	
	/**
	 * sorts the word by alphabetical order. Updates the count of each word by how often it appears
	 * @param list a linkedlist of WordCounts, where each wordcount contains a single english word
	 * @return a linked list in alphabetic order with no duplicate words and updated wordcounts
	 */
	public static LinkedList<WordCount> radixSort(LinkedList<WordCount> list){ 
		StringList[] alpha = new StringList[27]; //an array with 27 stringlists
		//fills alpha with empty linked lists
		for (int i = 0; i <= 26; i++) 
			alpha[i] = new StringList();

		int longestLength = 0;	
		LinkedListIterator<WordCount> it = list.iterator();
		//finds the length of the longest word in the list
		while (it.hasNext()) {
			int currentLength = it.next().getElement().getWord().length() - 1;
			if (currentLength > longestLength)
				longestLength = currentLength;
		}
		int index;
		//runs from the last index of the longest word to 0.
		for (index = longestLength; index >= 0; index--) { 
			it = list.iterator();
			//runs through all the words in the linked list
			while (it.hasNext()) { 
				WordCount current = it.next().getElement();  //sets the current wordCount equal to the current wordcount in the linked list
				if (current.getWord().length() -1 < index)  //if the current word is shorter, add to first LL of array
					addFirstInstance(alpha[0], current); //checks if the last value of the array is the same as the word being added
				else { //adds the current WordCount to the array's linked list based on its index character{
						if (current.getWord().charAt(index) >= 'A' && current.getWord().charAt(index) <= 'Z') {
						StringBuilder allLowerCase = new StringBuilder();
						 //creates a new string that converts all upper case to lower case letters
						for (int i = 0; i < current.getWord().length(); i++) {
							if (current.getWord().charAt(i) >= 'A' && current.getWord().charAt(i) <= 'Z')
								allLowerCase.append((char)(current.getWord().charAt(i) - ('A' - 'a')));
							else 
								allLowerCase.append(current.getWord().charAt(i));
							}
						current.setWord(allLowerCase.toString());
						}	
						addFirstInstance(alpha[(current.getWord().charAt(index)) - 'a' + 1], current); //adds if it's the first instance of the word
				}		
			}		
			list = new LinkedList<WordCount>();
			 //adds ordered words by letter to new linked list
			for (int i = 0; i <= 26; i++)
				list.append(alpha[i]);  
			for (int i = 0; i <= 26; i++) 
				alpha[i] = new StringList();
		} //at this point, all the words have been sorted into the array's stringList	
		return list;
	}
	/**
	 * reads from a file provided in the parameter, converting each word into a wordcount of a linked list
	 * 
	 * @param s the name and directory of the file to be loaded
	 * @return the text file as a linked list with a single word at each node
	 * @throws FileNotFoundException if file does not exist
	 * @throws IOException if InputStream/OutputStream exception encountered
	 */
	public static LinkedList<WordCount> loadFile(String s) throws FileNotFoundException, IOException{
		File f = new File(s);
		FileReader fr = new FileReader(f);
		if (!f.exists()) {
			fr.close();
			throw new FileNotFoundException();
		}
		StringBuilder str = new StringBuilder();
		LinkedList<WordCount> wc = new LinkedList<WordCount>();
		int charValue;
		//runs until reaches end of file is reached. updates stringbuilder until a word is reached
		while ((charValue = fr.read()) != -1) { 
			if ((charValue >= 'a' && charValue <= 'z') || (charValue >= 'A' && charValue <= 'Z')) //appends if it's a sequence of characters
				str.append((char)charValue);
			else if (!str.toString().equals(""))//prevents a blank linkedlist from being printed
			{ 
				wc.addToEnd(new WordCount(str.toString())); 
				str = new StringBuilder();
			}	
		}
		if (!str.toString().equals("")) //prevents blank linked list from being printed as the last word in the list
			wc.addToEnd(new WordCount(str.toString())); //adds the very last word to the linkedlist
		fr.close();
		return wc;
	}
	/**
	 * 
	 * @param fileName the name of the file to be written
	 * @param list the words to be written on the file
	 * @throws IOException an exception with input and output streams, such as when the PrintWriter is closed but the print method is invoked
	 * @throws FileAlreadyExistsException if the file already exists
	 */
	public static void writeData (String fileName, LinkedList<WordCount> list) throws IOException, FileAlreadyExistsException {
		File a = new File(fileName);
		if (a.exists())
			throw new FileAlreadyExistsException("");
		PrintWriter print = new PrintWriter(a);
		list = TextAnalyze.radixSort(list);
		LinkedListIterator<WordCount> it = list.iterator();
		int totalCount = 0;
		//counts the total words in the list.
		while (it.hasNext()) 
			totalCount += it.next().getElement().getCount();
		it = list.iterator();
		while (it.hasNext()) {
			print.print("\n" + it.getCurrent().getElement().getWord());
			for (int i = 1; i < 20 - it.getCurrent().getElement().getWord().length(); i++) //formatting so it aligns better
				print.print(" ");	
			print.print(it.getCurrent().getElement().getCount() + "   " + (int)((double)it.next().getElement().getCount() *100000 / (double)totalCount) / 1000.0 + "% "); //formatting so not too many decimals
		}
		print.close();
	}
	
	/**
	 * Loads a text file and creates a new one with the words of the input text file alphabetically ordered, word counts shown, and percentage incidence shown
	 */
	public static void main(String[] args){
		try{
			String inputFile = "C:\\Users\\danie\\OneDrive\\Desktop\\UGA.txt";
			String outputFile = "C:\\Users\\danie\\Downloads\\poopoo5.txt"; 
			TextAnalyze.writeData(outputFile,loadFile(inputFile));
			System.out.println("done");
		}
		
		catch(FileNotFoundException f) {
			System.out.println("Oops! the file you directed us to could not be found");
		}
		catch(FileAlreadyExistsException a) {
			System.out.println("Oops! A file already exists with that name");
		}
		catch(IOException i) {
			System.out.println("Oops! There was a problem with the input");
		}
		catch(NoSuchElementException n) {
			System.out.println("Oops! ");
		}
		catch(Exception e) {
			System.out.println("Oops! The following error was encountered " + e);
			System.exit(-1);
			}
	}
}

