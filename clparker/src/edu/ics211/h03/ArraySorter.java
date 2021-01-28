/**
 * 
 */
package edu.ics211.h03;

import java.io.DataInput;
import java.util.Comparator;

/**
 * @author Cory Parker
 * @param <E> generic class
 */
public class ArraySorter<E> implements SortsArray<E> {
  public double sortTime;
  /**
   * 
   */
  public ArraySorter() { 
   sortTime=0;
  }

  @Override
  public void insertionSort(Comparator<E> compare, SortRecord<E>[] data) {
   // start time from  System.nanoTime();
    
    //loop fom 1 to data.length -1
    // remmmber item at i
    //remmber where the item to the left of i is (i-1)
    
    // while hole isnt at 0 and thing to the left of the whole is > remembered
    //count comparision for item and item to the left of hole 
    //shift item to left into hole, update numberOfSwaps
    // update where the hole is
    
    //if compare stopped the loop, count compare
    // if the hole isnt at i, insert item into the hole, update numberOfSwaps
    
    
   //get ending time from nanoTime
   //subtract ending from starting to stortTime 
   
    
    
  }

  @Override
  public void bubbleSort(Comparator<E> compare, SortRecord<E>[] data) {
    long startTime = System.nanoTime();
    // start time from  System.nanoTime();
    boolean exchange = false;
    int pass = 0;
    
    do {  //do while loop
      exchange = false; //  set we havent changed
      for (int i =1; i < data.length - pass;i++) {//loop from 0 to data.length -1  - number of passes
        
        //count compare
       
        int result = compare.compare(data[i].element, data[i-1].element);//compare data[i].element, data[i+1].element, if data > 0, swap, count swap
       
        if (result < 0) {//if data > 0, swap
          
          //count swap
          data[i].numberOfSwaps++;
         
          SortRecord<E> temp = data[i];//wrong data going in?
          data[i] = data[i-1];
          data[i-1]=temp;
          exchange=true;
        }
      }
      pass++;
    } while (exchange);
    
    //do while loop
    //  set we havent changed 
    //  loop from 0 to data.length -1  - number of passes
    //    count compare
    //    compare data[i].element, data[i+1].element, if data > 0, swap, count swap
    //    we have changed something, set chaged thing to true
    long endTime =System.nanoTime(); //get ending time from nanoTime
    this.sortTime = endTime - startTime;//subtract ending from starting to stortTime
   
   
  }

  @Override
  public void selectionSort(Comparator<E> compare, SortRecord<E>[] data) {
    long startTime = System.nanoTime();// start time from  System.nanoTime();
    
    
    for (int i = 0; i < data.length -1; i++) {//loop from 0 to data.length -1
     SortRecord<E> posMin = data[i];//  guess smallest is at [i]
     
     
     
     
     
     
     
     
     
     
    }
    
    
    //  loop from i +1 to data.length
    //    count the compare
    //    if compare data[min], data[j] > 0, set min to j
    //  if [i] is not min, swap items, count swap
    //  get the end time
    //  subtract assign to sortTime
    
    
  //get ending time from nanoTime
    //subtract ending from starting to stortTime   
  }

  @Override
  public double getSortTime() { 
    return sortTime;
  }

}
