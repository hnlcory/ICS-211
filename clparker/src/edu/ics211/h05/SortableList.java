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
public class SortableList<E> implements IList211<E>, ISortableList<E>{
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
  
  @Override
  public void insertionSort(Comparator<E> compare) {// *** all former data.lengths may be wrong
    swaps = 0;
    comps = 0;
    // set swaps, comps to 0
    long startTime = System.nanoTime();
    int n = size ;// data.length switch to size of nodes?
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
          set(i- 1, temp);
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
    return size;
  }

  @Override
  public boolean add(E e) {
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
