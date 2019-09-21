package linkedListPractice;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import HW4.LLNode;
public class LinkedListTester {

	/**
	 * Tests append method
	 */
	@Test
	public void appendTester() {
		LinkedList<Integer> a = new LinkedList<Integer>();
		LinkedList<Integer> b = new LinkedList<Integer>();
		
		a.setFirst(new LLNode<Integer>(null, null));
		b.append(a);
		//test zero 
		assertEquals("appending an empty linked list to an empty linked list", null, b.getFirst().getElement());
		
		a = new LinkedList<Integer>();
		b = new LinkedList<Integer>();
		a.addToEnd(1);
		b.append(a);
		
		assertEquals("appending a linked list with one element to a linked list with no element", (Integer) 1, b.getFirst().getElement());	
		
		a = new LinkedList<Integer>();
		b.append(a);
		assertEquals("appending a linked list with no element to a linked list with one element", (Integer) 1, b.getFirst().getElement());
		assertEquals(null, b.getFirst().getNext());
		
		//test one 
		a = new LinkedList<Integer>();
		b = new LinkedList<Integer>();
		a.addToEnd(1);
		b.addToEnd(0);
		b.append(a);
		assertEquals((Integer) 0, b.getFirst().getElement());
		assertEquals((Integer) 1, b.getFirst().getNext().getElement());

		//test many
		a = new LinkedList<Integer>();
		b = new LinkedList<Integer>();
		LinkedList<Integer > c = new LinkedList<Integer>();
		for (int i = 0; i < 3; i++) {
			b.addToEnd(i);
			a.addToEnd(i + 3);
			c.addToEnd(i + 6);
		}
		b.append(a);
		b.append(c);
		
		assertEquals((Integer) 0, b.getFirst().getElement());
		assertEquals((Integer) 1, b.getFirst().getNext().getElement());
		assertEquals((Integer) 2, b.getFirst().getNext().getNext().getElement());
		assertEquals((Integer) 3, b.getFirst().getNext().getNext().getNext().getElement());
		assertEquals((Integer) 4, b.getFirst().getNext().getNext().getNext().getNext().getElement());
		assertEquals((Integer) 5, b.getFirst().getNext().getNext().getNext().getNext().getNext().getElement());
		assertEquals((Integer) 6, b.getFirst().getNext().getNext().getNext().getNext().getNext().getNext().getElement());
		assertEquals((Integer) 7, b.getFirst().getNext().getNext().getNext().getNext().getNext().getNext().getNext().getElement());
		assertEquals((Integer) 8, b.getFirst().getNext().getNext().getNext().getNext().getNext().getNext().getNext().getNext().getElement());
		assertEquals(null, b.getFirst().getNext().getNext().getNext().getNext().getNext().getNext().getNext().getNext().getNext());		
	}
}
