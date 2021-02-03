/**
 * 
 */
package edu.ics211.h04;

import java.util.Comparator;

/**
 * @author Cory Parker
 *
 */
public class SortableList<E> implements IList211<E>, ISortableList<E>{
  private E[] data;
  private int size;
  private int swaps;
  private int comps;
  private double sortTime;
  
  public SortableList() {
    //init member variable
    this.data = (E[]) new Object[13];
  }

  @Override
  public void insertionSort(Comparator<E> compare) {
    //set swaps, comps to 0
    //Dont loop to data.length-1, loop from 1 to size-1(nothing at size, we start at 0)
    //dont have to pull data from sort record?, compare bc they are just E
    
  }

  @Override
  public void bubbleSort(Comparator<E> compare) {
    //set swaps, comps to 0
    
  }

  @Override
  public void selectionSort(Comparator<E> compare) {
    //set swaps, comps to 0
    
  }

  @Override
  public int getNumberOfSwaps() {
    //return swaps
    return 0;
  }

  @Override
  public int getNumberOfComparisons() {
    //return comps
    return 0;
  }

  @Override
  public double getSortTime() {
    //return sort time
    return 0;
  }

  
  
  
  
  
  @Override
  public E get(int index) {
    //check index
    //return data[index]
    return null;
  }
  
  private void checkIndex(int index) {
    if (index<0 || index >= size) {
      throw new IndexOutOfBoundsException();
    }
  }

  @Override
  public E set(int index, Object element) {
    //checkIndex
    //remmeber value @ index
    // set value at index to element
    //return remembered
    return null;
  }

  @Override
  public int indexOf(Object obj) {
    //loop from 0 to size-1
    //  if obj.equals(item at index)
          //return index
    //return -1
    return 0;
  }

  @Override
  public int size() {
    //return size
    return 0;
  }

  @Override
  public boolean add(E e) {
    // add(size,e);
    return true;
  }

  @Override
  public void add(int index, E element) {
    // if index is bad, throw exception, but size is good. 
    // (if index is < 0 or > size, throw exception)
    // if data is full, size == data.length
        //grow data     data = Arrays.copyOf(data, 2 * data.length) 
    // shift all items from index to index+1 (loop size-1 to index)
    //insert element into array at index
    //increment size
  }

  @Override
  public E remove(int index) {
    //checkIndex
    //remember item at index
    //shift items from index +1 to size of index
    //decrement size
    //return rememberd
    return null;
  }

}
