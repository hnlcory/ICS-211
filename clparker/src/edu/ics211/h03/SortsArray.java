package edu.ics211.h03;

import java.util.Comparator;

/**
 * Represents a SortsArray.
 *
 * @author Cam Moore
 *
 * @param <E> the type.
 */
public interface SortsArray<E> {
  /**
   * Sorts the array data using the insertion sort algorithm.
   * 
   * @param compare Comparator of Es.
   * @param data the data to sort.
   * @return the sorted data as an SortRecord array.
   */
  void insertionSort(Comparator<E> compare, SortRecord<E>[] data);


  /**
   * Sorts the array data using the bubble sort algorithm.
   * 
   * @param compare Comparator of Es.
   * @param data the data to sort.
   * @return the sorted data as an SortRecord array.
   */
  void bubbleSort(Comparator<E> compare, SortRecord<E>[] data);


  /**
   * Sorts the array data using the selection sort algorithm.
   * 
   * @param compare Comparator of Es.
   * @param data the data to sort.
   * @return the sorted data as an SortRecord array.
   */
  void selectionSort(Comparator<E> compare, SortRecord<E>[] data);


  /**
   * Returns the sort time.
   * 
   * @return the sort time.
   */
  double getSortTime(); // returns the time of the most recently called sort
}
