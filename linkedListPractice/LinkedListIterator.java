
/**
 * Daniel Shao
 * An iterator that runs through linked lists and retrieves values
 */
package linkedListPractice;

import java.util.Iterator;
import java.util.NoSuchElementException;

import HW4.LLNode;

public class LinkedListIterator<T> implements Iterator<LLNode<T>> {
	private LLNode<T> nodeptr;		//the current node of the linked list the iterator is pointing to
	
	/**
	 * constructor to set the first node to the first node of the linked list
	 * @param firstNode the node to begin iterating at
	 */
	public LinkedListIterator(LLNode<T> firstNode) {
		nodeptr = firstNode;
	}
	/**
	 * returns the current node of the linked list and sets the node pointer to the next node
	 * @return the current node of the linked list
	 */
	@Override  
	public LLNode<T> next() throws NoSuchElementException{
		LLNode<T> node = nodeptr;
		if (nodeptr == null)
			throw new NoSuchElementException();
		nodeptr = nodeptr.getNext();
		return node;
	}
	/**
	 * 
	 * @return the current node the iterator is at on the linked list
	 */
	public LLNode<T> getCurrent() {
		return nodeptr;
	}
	/**
	 * 
	 * @return true if the nodepointer is not null
	 */
	@Override
	public boolean hasNext() {
		return nodeptr != null;
	} 
}


