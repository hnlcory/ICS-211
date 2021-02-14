/**
 * 
 */
package edu.ics211.h06;

import java.util.Iterator;

import edu.ics211.h04.IList211;
import edu.ics211.h05.SortableList.DLinkedNode;

/**
 * @author hnlcory
 *
 */
public class SortableList<E> implements IList211<E>, Iterable<E> {
  private DLinkedNode tail;
  /**
   * 
   */
  public SortableList() {
    // TODO Auto-generated constructor stub
  }

  
  public class DLinkedNode {
    E item;
    DLinkedNode next;
    DLinkedNode prev;
    
    public DLinkedNode(E item, DLinkedNode next, DLinkedNode prev) {
      this.item = item;
      this.next = next;
      this.prev = prev;
    }
  }
  
  public interface ListIterator<E> {
    void add(E e); // Inserts the specified element to the list. (Optional for this assignment)

    boolean hasNext(); // Returns true if this list iterator has more elements while traversing in the forward direction.

    boolean hasPrevious(); // Returns true if this list iterator has more elements while traversing in the reverse direction.

    E next(); // Returns the next Element.

    int nextIndex(); // Returns the index of the next element.

    E previous(); // Returns the previous Element

    int previousIndex(); // Returns the index of the previous element.

    void remove(); // Removes from the list the last element that was returned. (Optional for this assignment)

    void set(E e); // Replaces the last element returned. (Optional for this assignment)

  }
  
  @Override
  public Iterator<E> iterator() {
    // TODO Auto-generated method stub
    return null;
  }


  @Override
  public E get(int index) {
    // TODO Auto-generated method stub
    return null;
  }


  @Override
  public E set(int index, E element) {
    // TODO Auto-generated method stub
    return null;
  }


  @Override
  public int indexOf(Object obj) {
    // TODO Auto-generated method stub
    return 0;
  }


  @Override
  public int size() {
    // TODO Auto-generated method stub
    return 0;
  }


  @Override
  public boolean add(E e) {
    // TODO Auto-generated method stub
    return false;
  }


  @Override
  public void add(int index, E element) {
    // TODO Auto-generated method stub

  }


  @Override
  public E remove(int index) {
    // TODO Auto-generated method stub
    return null;
  }

}
