/**
 * 
 */
package edu.ics211.h05;

import edu.ics211.h04.IList211;
import edu.ics211.h04.ISortableList;
import java.util.Comparator;

/**
 * @author Cory Parker
 *
 */
public class SortableList<E> implements IList211<E>, ISortableList<E> {
  private DLinkedNode tail;
  private int size;
  private int swaps;
  private int comps;
  private double sortTime;

  private class DLinkedNode {
    E item;
    DLinkedNode next;
    DLinkedNode prev;

    public DLinkedNode(E item, DLinkedNode next, DLinkedNode prev) {
      this.item = item;
      this.next = next;
      this.prev = prev;
    }
  }

  public SortableList() {
    // init variables
    tail = null;
    size = 0;
    swaps = 0;
    comps = 0;
    sortTime = 0;

  }


  @Override
  public void insertionSort(Comparator<E> compare) {// *** all former data.lengths may be wrong
    swaps = 0;
    comps = 0;
    // set swaps, comps to 0
    long startTime = System.nanoTime();
    int n = size;// data.length switch to size of nodes?
    for (int fill = 0; fill < n - 1; fill++) {
      int posMin = fill;
      for (int next = fill + 1; next < n; next++) {
        if (get(next) == null) {
          break;
        }
        comps++;

        int result = compare.compare(get(next), get(posMin));// *

        if (result < 0) {
          swaps++;
          posMin = next;
        }
      }

      E temp = get(fill);
      set(fill, get(posMin));
      set(posMin, temp);// *

    }
    long endTime = System.nanoTime(); // get ending time from nanoTime
    this.sortTime = endTime - startTime;// subtract ending from starting to stortTime
  }


  @Override
  public void bubbleSort(Comparator<E> compare) {
    swaps = 0;
    comps = 0;
    long startTime = System.nanoTime();
    boolean exchange = false;
    int pass = 0;

    do { // do while loop
      exchange = false; // set changed
      for (int i = 1; i < size - pass; i++) {// data.length switch to size of nodes?

        if (get(i) == null) {
          break;
        }
        comps++;// count compare

        int result = compare.compare(get(i), get(i - 1));

        if (result < 0) {
          swaps++;// count swap
          E temp = get(i);
          set(i, get(i - 1));
          set(i - 1, temp);
          exchange = true;// change exchange to true
        }
      }
      pass++;
    } while (exchange);
    long endTime = System.nanoTime(); // get ending time from nanoTime
    this.sortTime = endTime - startTime;// subtract ending from starting to stortTime
  }


  @Override
  public void selectionSort(Comparator<E> compare) {
    swaps = 0;
    comps = 0;
    long startTime = System.nanoTime();

    for (int i = 0; i < size - 1; i++) {// data.length switch to size of nodes?
      int posMin = i;// guess smallest is at [i]

      for (int j = i + 1; j < size; j++) {// data.length switch to size of nodes?

        if (get(j) == null) {
          break;
        }
        comps++;

        if (compare.compare(get(j), get(posMin)) < 0) {
          posMin = j;
          swaps++;
        }
      }
      E temp = get(posMin);
      set(posMin, get(i));
      set(i, temp);
    }

    long endTime = System.nanoTime(); // get ending time from nanoTime
    this.sortTime = endTime - startTime;// subtract ending from starting to stortTime
  }


  @Override
  public int getNumberOfSwaps() {
    return swaps;
  }


  @Override
  public int getNumberOfComparisons() {
    return comps;
  }


  @Override
  public double getSortTime() {
    return sortTime;
  }


  @Override
  public E get(int index) {// Gets the item at the given index.
    checkIndex(index);
    DLinkedNode temp = tail;
    for (int i = size - 1; i > index; i--) {// may be >= not >
      temp = temp.prev;
    }
    // return DLinkedNode.item;
    return temp.item;
    // traverse to index form tail (tail = size-1)
    // return node.item

  }


  private void checkIndex(int index) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException();
    }
  }


  @Override
  public E set(int index, E element) {
    checkIndex(index);
    DLinkedNode temp = tail;
    for (int i = size - 1; i > index; i--) {// may be > not >=
      temp = temp.prev;
    }
    E data = temp.item;
    temp.item = element;
    return data;
    // check index
    // traverse from index to tail
    // remmebr item in node
    // set item in node to element
    // return remembered
  }


  @Override
  public int indexOf(Object obj) {
    DLinkedNode temp = tail;
    for (int index = 0; index >= size-1; index++) {// again >= to > or possibly <
      if (temp.item.equals(obj)) {
        return index;
      }
      temp = temp.next;
    }
    return -1;
    // keep track of index
    // loop from tail to beginning
    // if note.item.equals(obj), return index
    // update index***
    // update node***
    // return -1

  }


  @Override
  public int size() {
    return size;
  }


  @Override
  public boolean add(E e) {// Adds e to the end of the list.
    add(size, e);
    return true;
  }


  @Override
  public void add(int index, E element) {// Adds element to the list at the given index.
    if (index < 0 || index > size) {// if index is bad, size is ok throw index out of bounds
      throw new IndexOutOfBoundsException();
    }

    if (size == 0) { // if size is 0, point to new node (element,null,null
      tail = new DLinkedNode(element, null, null);
    } 
    else if (index == size) { // else if index is side, adding to the end
      DLinkedNode temp = new DLinkedNode(element, null, tail);// create new DLinkedNode with element, null, tail
      if (tail != null) {// if tail is not null
        tail.next = temp;// tail.next = new node
      }
    }
    
   
    else {
      DLinkedNode temp = tail;
     
      for (int i = size; i > index ; i--) {//index or index -1, this is where out thing needs to go
        temp=temp.prev;
      }
      DLinkedNode e = new DLinkedNode(element,temp,temp.prev);
      temp.prev.next = e;
      e.next = temp;
      temp.next.prev=e;
      size++;
      
    }
    // if index is bad, size is ok throw index out of bounds
    // if size is 0, point to new node (element,null,null)
    // else if index is side, adding to the end
    // if index is size
    // create new DLinkedNode with element, null, tail
    // if tail is not null
    // tail.next = new node
    // update tail to be new node
    // else
    
    
    // traverse to index
    // create new node [element,temp, temp.prev] pointing new node to list
    
    // point list to new node
    // if temp.prev is not null
    // temp.prev.next = newNode
    // if temp.next is not null
    // temp.next.prev = newNode
    // increment size

  }


  @Override
  public E remove(int index) {// Removes the element at the given index.
    checkIndex(index);
    
    DLinkedNode temp = tail;
    for (int i = size; i > index ; i--) {
      temp=temp.prev;
    }
    
    
    
    // check index
    // traverse to index
    // if index is size -1
    // make the list not point to the node
    // if temp.prev is not null
    // temp.prev.next=temp.next
    // update tail
    // else
    // make the list not point to the node
    // if temp.prev is not null
    // temp.prev.next = temp.next
    // if temp.next is not null
    // temp.next.prev = temp.prev
    // decrement size
    // return ?
    return null;
  }

}
