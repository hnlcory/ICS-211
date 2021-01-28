/**
 * 
 */
package edu.ics211.h03;


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

  /**
   * @Author Cory Parker
   */
  @Override
  public void insertionSort(Comparator<E> compare, SortRecord<E>[] data) {
   long startTime = System.nanoTime();// start time from System.nanoTime();
   int n = data.length;
   for (int fill = 0; fill < n-1; fill++) {
     int posMin = fill;
     for (int next = fill + 1; next < n; next++) {
       data[fill].numberOfComparisons++;
       int result =compare.compare(data[next].element, data[posMin].element); //table[next].compareTo(table[posMin]) < 0) {
       if (result <0) {// may be >
         data[fill].numberOfSwaps++;
         posMin = next;
       }
     }
     
     SortRecord<E> temp = data[fill];
     data[fill] = data[posMin];
     data[posMin] = temp;
     
   }
   
   //loop from 1 to data.length -1
    // remember item at i
    //remember where the item to the left of i is (i-1)
    
    // while hole isnt at 0 and thing to the left of the whole is > remembered
    //count comparison for item and item to the left of hole 
    //shift item to left into hole, update numberOfSwaps
    // update where the hole is
    
    //if compare stopped the loop, count compare
    // if the hole isnt at i, insert item into the hole, update numberOfSwaps
    
    
   //get ending time from nanoTime
   //subtract ending from starting to stortTime 
   
    
   long endTime =System.nanoTime(); //get ending time from nanoTime
   this.sortTime = endTime - startTime;//subtract ending from starting to stortTime 
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
        
        data[i].numberOfComparisons++;//count compare
       
        int result = compare.compare(data[i].element, data[i-1].element);//compare data[i].element, data[i+1].element, if data > 0, swap, count swap
       
        if (result < 0) {//if data > 0, swap
          data[i].numberOfSwaps++;//count swap
          SortRecord<E> temp = data[i];
          data[i] = data[i-1];
          data[i-1]=temp;
          exchange=true;//change exchnage to true
        }
      }
      pass++;
    } while (exchange);
    long endTime =System.nanoTime(); //get ending time from nanoTime
    this.sortTime = endTime - startTime;//subtract ending from starting to stortTime 
  }

  @Override
  public void selectionSort(Comparator<E> compare, SortRecord<E>[] data) {//works sometimes?
    long startTime = System.nanoTime();// start time from System.nanoTime();
    
    
    for (int i = 0; i < data.length -1; i++) {//loop from 0 to data.length -1
     SortRecord<E> posMin = data[i];//  guess smallest is at [i]
     
     for (int j = i + 1; j < data.length ; j++) {//orignally data.length-1 triggered a sometimes working? removed and works always?
       data[i].numberOfComparisons++;
       if (compare.compare(data[j].element, posMin.element) < 0) {
         posMin = data[j];
         data[i].numberOfSwaps++;
       }
     }
      SortRecord<E> temp = posMin;
      posMin = data[i];
      data[i] = temp;   
    }
     
    long endTime =System.nanoTime(); //get ending time from nanoTime
    this.sortTime = endTime - startTime;//subtract ending from starting to stortTime 
    
    
    //  loop from i +1 to data.length
    //    count the compare
    //    if compare data[min], data[j] > 0, set min to j
    //  if [i] is not min, swap items, count swap
    //  get the end time
    //  subtract assign to sortTime
  }

  @Override
  public double getSortTime() { 
    return sortTime;
  }

}
