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
  public ArraySorter() { 
    // TODO Auto-generated constructor stub
  }

  @Override
  public void insertionSort(Comparator<E> compare, SortRecord<E>[] data) {
    long startTime = System.nanoTime();//track start time
    
    int n = data.length;
    
    for (int i = 1; i<n; i++) {
      SortRecord<E> key = data[i];
      int j = i-1;
      
      while(j>=0 && data[j]>key) {
        
      }
    }
    
    
  }

  @Override
  public void bubbleSort(Comparator<E> compare, SortRecord<E>[] data) {
    long startTime = System.nanoTime();
    SortRecord<E> temp;
    int n =data.length;
    
    for(int k = 0; k< n-1; k++) {// (n-k-1) is for ignoring comparisons of elements which have already been compared in earlier iterations
      
      for(int i = 0; i < n-k-1; i++) {
          if(data[ i ] > data[ i+1] ) {//if data is > next one swap
              
              temp = data[ i ];// here swapping of positions is being done.
              data[ i ] = data[ i+1 ];
              data[ i + 1] = temp;
          }
      }
  }
    
    
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
