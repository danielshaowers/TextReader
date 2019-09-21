package linkedListPractice;
import java.util.NoSuchElementException;

import HW4.LLNode;
import HW4.LinkedListIterator;

import java.util.Iterator;

/**
 * A class to represent a linked list of nodes.
 */
public class LinkedList<T> implements Iterable<LLNode<T>> {
  /** the first node of the list, or null if the list is empty */
  private LLNode<T> firstNode;
  
  /**
   * Creates an initially empty linked list
   */
  public LinkedList() {
    firstNode = null;
  }
  
  public LinkedListIterator<T> iterator(){
	  return new LinkedListIterator<T>(getFirst());
  }
  /**
   * Returns the first node.
   */
  protected LLNode<T> getFirst() {
    return firstNode;
  }
  
  
	

  /**
   * Changes the first node.
   * @param node  the first node of the new linked list
   */
  protected void setFirst(LLNode<T> first) {
	  this.firstNode = first;
  }

  /**
   * Add an element to the front of the linked list
   * @param element  the element to add
   */
  public void addToFront(T element) {
    setFirst(new LLNode<T>(element, getFirst()));
  }
  
  /**
   * Return whether the list is empty
   * @return true if the list is empty
   */
  public boolean isEmpty() {
    return (getFirst() == null);
  }
  
  /**
   * Remove and return the element at the front of the list
   * @return the first element of the list
   * @throws NoSuchElementException if there is no such element
   */
  public T removeFromFront() {
    if (isEmpty())
      throw new NoSuchElementException();
    else {
      T save = getFirst().getElement();
      setFirst(getFirst().getNext());
      return save;
    }
  }

  /**
   * Add an element to the very end of the list
   * @param element the element to add to the end of the list
   */
  public void addToEnd(T element) {
    if (isEmpty()) 
      addToFront(element);
    else {
      LLNode<T> nodeptr = getFirst();
      // the loop will end with nodeptr looking at the last node in list
      while (nodeptr.getNext() != null)
        nodeptr = nodeptr.getNext();
      nodeptr.setNext(new LLNode<T>(element, null));
    }
  }
  
  /**
   * Add a list to the end of this linked list
   * @param addition the linked list to be added to the end of the current linked list
   */
  public void append(LinkedList<T> addition) {
	    if (isEmpty()) 
	       this.setFirst(addition.getFirst());
	    else {
	        Iterator<LLNode<T>> it = iterator();
	        LLNode<T> temp = getFirst();
	        //sets temp to the last node of the linked list
	        while (it.hasNext()) 
	        	 temp = it.next();
	        temp.setNext((addition.getFirst())); 
	      }
  } 
}
