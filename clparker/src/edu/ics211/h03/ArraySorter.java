/**
 * Program to sort array of items.
 * @author Cory Parker
 */

package edu.ics211.h03;

import java.util.Comparator;

/**
 * Sorts arrays of data.
 * 
 * @author Cory Parker
 * @param <E> generic class
 */
public class ArraySorter<E> implements SortsArray<E> {
  public double sortTime;

  /**
   * sets starting sort time to 0.
   * 
   * @author Cory Parker
   */
  public ArraySorter() {
    sortTime = 0;
  }


  /**
   * sorts array with an insertion sort.
   * 
   * @Author Cory Parker. Modified code from Chapter 8 in the textbook.
   */
  @Override
  public void insertionSort(Comparator<E> compare, SortRecord<E>[] data) {
    long startTime = System.nanoTime();// start time from System.nanoTime();
    int n = data.length;
    for (int fill = 0; fill < n - 1; fill++) {
      int posMin = fill;
      for (int next = fill + 1; next < n; next++) {
        data[fill].numberOfComparisons++;
        int result = compare.compare(data[next].element, data[posMin].element);

        if (result < 0) {
          data[fill].numberOfSwaps++;
          posMin = next;
        }
      }

      SortRecord<E> temp = data[fill];
      data[fill] = data[posMin];
      data[posMin] = temp;

    }

    long endTime = System.nanoTime(); // get ending time from nanoTime
    this.sortTime = endTime - startTime;// subtract ending from starting to stortTime
  }


  /**
  * Uses bubble sort to sort array.
   */
  @Override
   public void bubbleSort(Comparator<E> compare, SortRecord<E>[] data) {
    long startTime = System.nanoTime();
    // start time from System.nanoTime();
    boolean exchange = false;
    int pass = 0;

    do { // do while loop
      exchange = false; // set we havent changed
      for (int i = 1; i < data.length - pass; i++) {

        data[i].numberOfComparisons++;// count compare

        int result = compare.compare(data[i].element, data[i - 1].element);

        if (result < 0) {
          data[i].numberOfSwaps++;// count swap
          SortRecord<E> temp = data[i];
          data[i] = data[i - 1];
          data[i - 1] = temp;
          exchange = true;// change exchange to true
        }
      }
      pass++;
    } while (exchange);
    long endTime = System.nanoTime(); // get ending time from nanoTime
    this.sortTime = endTime - startTime;// subtract ending from starting to stortTime
  }


  /**
   * Sorts array using a selection sort.
   * 
   * @author Cory Parker.
   */
  @Override
  public void selectionSort(Comparator<E> compare, SortRecord<E>[] data) {
    long startTime = System.nanoTime();// start time from System.nanoTime();

    for (int i = 0; i < data.length - 1; i++) {
      SortRecord<E> posMin = data[i];// guess smallest is at [i]

      for (int j = i + 1; j < data.length; j++) {
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

    long endTime = System.nanoTime(); // get ending time from nanoTime
    this.sortTime = endTime - startTime;// subtract ending from starting to stortTime

  }


  @Override
  public double getSortTime() {
    return sortTime;
  }

}
