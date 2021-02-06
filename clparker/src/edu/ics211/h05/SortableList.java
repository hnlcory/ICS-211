/**
 * 
 */
package edu.ics211.h05;

import edu.ics211.h04.IList211;
import edu.ics211.h04.ISortableList;
import java.util.Comparator;

/**
 * @author hnlcory
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
  public void insertionSort(Comparator compare) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void bubbleSort(Comparator compare) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void selectionSort(Comparator compare) {
    // TODO Auto-generated method stub
    
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
  public Object set(int index, Object element) {
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
  public void add(int index, Object element) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public E remove(int index) {
    // TODO Auto-generated method stub
    return null;
  }

}
