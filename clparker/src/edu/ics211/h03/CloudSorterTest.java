package edu.ics211.h03;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.ics211.h02.AltitudeComparator;
import edu.ics211.h02.Cloud;
import edu.ics211.h02.CloudShape;
import edu.ics211.h02.MotherNature;
import edu.ics211.h02.ShapeComparator;

/**
 * Represents a CloudSorterTest.
 * 
 * @author Cam Moore
 *
 */
class CloudSorterTest {
  private ArraySorter<Cloud> sorter;
  private MotherNature mother;
  private SortRecord<Cloud>[] shortClouds;
  private SortRecord<Cloud>[] mediumClouds;
  private SortRecord<Cloud>[] longClouds;
  private AltitudeComparator altC;
  private ShapeComparator shapeC;

  /**
   * Initializes the variables.
   * 
   * @throws java.lang.Exception if there is a problem.
   */
  @SuppressWarnings("unchecked")
  @BeforeEach
  public void setUp() throws Exception {
    // initialize the member variables
    sorter = new ArraySorter<Cloud>();
    mother = MotherNature.getInstance();
    altC = new AltitudeComparator();
    shapeC = new ShapeComparator();
    // create the arrays of SortRecords
    shortClouds = (SortRecord<Cloud>[]) Array.newInstance(SortRecord.class, 10);
    fillArray(shortClouds);
    mediumClouds = (SortRecord<Cloud>[]) Array.newInstance(SortRecord.class, 1000);
    fillArray(mediumClouds);
    longClouds = (SortRecord<Cloud>[]) Array.newInstance(SortRecord.class, 10000);
    fillArray(longClouds);
  }


  /**
   * Test method for {@link cmoore.h03.ArraySorter#ArraySorter()}.
   */
  @Test
  void testArraySorter() {
    assertNotNull("ArraySorter was not created.", sorter);
  }


  /**
   * Test method for {@link cmoore.h03.ArraySorter#insertionSort(java.util.Comparator, cmoore.h03.SortRecord<E>[])}.
   */
  @Test
  void testInsertionSort() {
    // Use a copy not the original arrays.
    SortRecord<Cloud>[] copy = Arrays.copyOf(shortClouds, shortClouds.length);
    // sort the array using the altitude comparator
    sorter.insertionSort(altC, copy);
    // get the sort time for comparison later.
    final double shortTime = sorter.getSortTime();
    // check if it is sorted
    assertTrue("Insertion sort didn't sort the array", isSortedAscending(copy, altC));
    resetCounts(copy);
    // sort the sorted array
    sorter.insertionSort(altC, copy);
    for (int i = 0; i < copy.length; i++) {
      assertEquals(0, copy[i].numberOfSwaps);
    }
    // sort by shape
    sorter.insertionSort(shapeC, copy);
    // check if it is sorted
    assertTrue("Insertion sort didn't sort the array", isSortedAscending(copy, shapeC));
    // get medium time
    copy = Arrays.copyOf(mediumClouds, mediumClouds.length);
    // sort the array using the altitude comparator
    sorter.insertionSort(altC, copy);
    // get the sort time for comparison later.
    final double mediumTime = sorter.getSortTime();
    assertTrue("Insertion sort: short time should be < medium time", shortTime < mediumTime);
    copy = Arrays.copyOf(longClouds, longClouds.length);
    // sort the array using the altitude comparator
    sorter.insertionSort(altC, copy);
    // get the sort time for comparison later.
    final double longTime = sorter.getSortTime();
    assertTrue("Insertion sort: medium time should be < long time", mediumTime < longTime);
  }


  /**
   * Test method for {@link cmoore.h03.ArraySorter#bubbleSort(java.util.Comparator, cmoore.h03.SortRecord<E>[])}.
   */
  @Test
  void testBubbleSort() {
    // Use a copy not the original arrays.
    SortRecord<Cloud>[] copy = Arrays.copyOf(shortClouds, shortClouds.length);
    // sort the array using the altitude comparator
    sorter.bubbleSort(altC, copy);
    // get the sort time for comparison later.
    final double shortTime = sorter.getSortTime();
    // check if it is sorted
    assertTrue("bubble sort didn't sort the array", isSortedAscending(copy, altC));
    resetCounts(copy);
    // sort the sorted array
    sorter.bubbleSort(altC, copy);
    for (int i = 0; i < copy.length; i++) {
      assertEquals(0, copy[i].numberOfSwaps);
    }
    // sort by shape
    sorter.bubbleSort(shapeC, copy);
    // check if it is sorted
    assertTrue("bubble sort didn't sort the array", isSortedAscending(copy, shapeC));
    // get medium time
    copy = Arrays.copyOf(mediumClouds, mediumClouds.length);
    // sort the array using the altitude comparator
    sorter.bubbleSort(altC, copy);
    // get the sort time for comparison later.
    final double mediumTime = sorter.getSortTime();
    assertTrue("bubble sort: short time should be < medium time", shortTime < mediumTime);
    copy = Arrays.copyOf(longClouds, longClouds.length);
    // sort the array using the altitude comparator
    sorter.bubbleSort(altC, copy);
    // get the sort time for comparison later.
    final double longTime = sorter.getSortTime();
    assertTrue("bubble sort: medium time should be < long time", mediumTime < longTime);
  }


  /**
   * Test method for {@link cmoore.h03.ArraySorter#selectionSort(java.util.Comparator, cmoore.h03.SortRecord<E>[])}.
   */
  @Test
  void testSelectionSort() {
    // Use a copy not the original arrays.
    SortRecord<Cloud>[] copy = Arrays.copyOf(shortClouds, shortClouds.length);
    // sort the array using the altitude comparator
    sorter.selectionSort(altC, copy);
    // get the sort time for comparison later.
    final double shortTime = sorter.getSortTime();
    // check if it is sorted
    assertTrue("selection sort didn't sort the array", isSortedAscending(copy, altC));
    resetCounts(copy);
    // sort the sorted array
    sorter.selectionSort(altC, copy);
    for (int i = 0; i < copy.length; i++) {
      assertEquals(0, copy[i].numberOfSwaps);
    }
    // sort by shape
    sorter.selectionSort(shapeC, copy);
    // check if it is sorted
    assertTrue("selection sort didn't sort the array", isSortedAscending(copy, shapeC));
    // get medium time
    copy = Arrays.copyOf(mediumClouds, mediumClouds.length);
    // sort the array using the altitude comparator
    sorter.selectionSort(altC, copy);
    // get the sort time for comparison later.
    final double mediumTime = sorter.getSortTime();
    assertTrue("selection sort: short time should be < medium time", shortTime < mediumTime);
    copy = Arrays.copyOf(longClouds, longClouds.length);
    // sort the array using the altitude comparator
    sorter.selectionSort(altC, copy);
    // get the sort time for comparison later.
    final double longTime = sorter.getSortTime();
    assertTrue("selection sort: medium time should be < long time", mediumTime < longTime);
  }


  /**
   * Fills the array with random clouds.
   * 
   * @param arr the array to fill.
   */
  private void fillArray(SortRecord<Cloud>[] arr) {
    Random random = new Random();
    for (int i = 0; i < arr.length; i++) {
      Cloud cloud;
      int level = random.nextInt(2);
      switch (level) {
        case 0:
          cloud = mother.formAHighLevelCloud(CloudShape.CIRRO);
          break;
        case 1:
          cloud = mother.formAMidLevelCloud(CloudShape.STRATO);
          break;
        default:
          cloud = mother.formALowLevelCloud(CloudShape.CUMULO);
      }
      arr[i] = new SortRecord<Cloud>(cloud);
    }
  }


  private boolean isSortedAscending(SortRecord<Cloud>[] data, Comparator<Cloud> comp) {
    for (int i = 0; i < data.length - 1; i++) {
      if (comp.compare(data[i].element, data[i + 1].element) > 0) {
        return false;
      }
    }
    return true;
  }


  private void resetCounts(SortRecord<Cloud>[] data) {
    for (int i = 0; i < data.length; i++) {
      data[i].numberOfComparisons = 0;
      data[i].numberOfSwaps = 0;
    }
  }

}
