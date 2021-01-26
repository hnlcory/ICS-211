package edu.ics211.h03;

/**
 * Represents a SortRecord.
 *
 * @author Cam Moore
 *
 * @param <E> the type.
 */
public class SortRecord<E> {
  E element;
  int numberOfSwaps;        // how many time has this element been swapped?
  int numberOfComparisons;  // how many time has this element been compared?
  
  
  /**
   * Creates a new SortRecord.
   *
   * @param value the value to store.
   */
  public SortRecord(E value) {
    element = value;
    numberOfSwaps = 0;
    numberOfComparisons = 0;
  }


  @Override
  public String toString() {
    return "SortRecord [element=" + element + ", numberOfSwaps=" + numberOfSwaps + ", numberOfComparisons="
        + numberOfComparisons + "]";
  }
  
}
