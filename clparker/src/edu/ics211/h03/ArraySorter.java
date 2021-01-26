/**
 * 
 */
package edu.ics211.h03;

import java.util.Comparator;

/**
 * @author Cory Parker
 *
 */
public class ArraySorter<E> implements SortsArray<E> {

  /**
   * 
   */
  public ArraySorter() { //smallest’ element should be in position 0, ‘largest’ in data.length - 1.
    // TODO Auto-generated constructor stub
  }

  @Override
  public void insertionSort(Comparator<E> compare, SortRecord<E>[] data) {
    long startTime = System.nanoTime();//track start time
    
   
    
  }

  @Override
  public void bubbleSort(Comparator<E> compare, SortRecord<E>[] data) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void selectionSort(Comparator<E> compare, SortRecord<E>[] data) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public double getSortTime() { 
    // TODO Auto-generated method stub
    return 0;
  }

}
