package edu.ics211.h04;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * 
 * @author Cory Parker
 *
 */
class SortableListTest {
  SortableList<Integer> sortedList = new SortableList<Integer>();
  

  /**
   * Sets up tests.
   * @throws Exception if there is a problem.
   */
  
  @BeforeEach
  void setUp() throws Exception {
    sortedList.add(3);
    sortedList.add(5);
    sortedList.add(10);
    sortedList.add(15);
  }


  @Test
  void testSortableList() {
    //create a sortable list
    SortableList<Integer> list = new SortableList<Integer>();
    assertNotNull(list);
    assertEquals(0, list.size());
  }


  @Test
  void testInsertionSort() {
    SortableList<Integer> list = new SortableList<Integer>();
    list.add(6);
    list.add(3);
    list.add(15);
    list.add(10);
    
    list.insertionSort(new IntegerComparator());
    
    
    assertEquals(sortedList.get(0), list.get(0));
    assertEquals(sortedList.get(1), list.get(1));
    assertEquals(sortedList.get(2), list.get(2));
    assertEquals(sortedList.get(3), list.get(3));
    
  }


  @Test
  void testBubbleSort() {
    SortableList<Integer> list = new SortableList<Integer>();
    list.add(6);
    list.add(3);
    list.add(15);
    list.add(10);
    
    list.bubbleSort(new IntegerComparator());
    
    assertEquals(sortedList.get(0), list.get(0));
    assertEquals(sortedList.get(1), list.get(1));
    assertEquals(sortedList.get(2), list.get(2));
    assertEquals(sortedList.get(3), list.get(3));
   
  }


  @Test
  void testSelectionSort() {
    SortableList<Integer> list = new SortableList<Integer>();
    list.add(6);
    list.add(3);
    list.add(15);
    list.add(10);
    
    list.selectionSort(new IntegerComparator());
    
    assertEquals(sortedList.get(0), list.get(0));
    assertEquals(sortedList.get(1), list.get(1));
    assertEquals(sortedList.get(2), list.get(2));
    assertEquals(sortedList.get(3), list.get(3));
  }


  @Test
  void testGetNumberOfSwaps() {
    fail("Not yet implemented");
  }


  @Test
  void testGetNumberOfComparisons() {
    fail("Not yet implemented");
  }


  @Test
  void testGetSortTime() {
    fail("Not yet implemented");
  }


  @Test
  void testGet() {
    //create list
    //add some items
    //get good values
    //assertEquals(val,list.get(0))
    //assertEquals(val2, list.get(size-1))
    
    //test some bad values
    //try{
    //list.get(-1)
    // fail ("didnt throw exception for -1")
    //}catch (IndexOutOfBoundsException ioobe){
    //good
    //}
    
  //try{
    //list.get(size)
    // fail ("didnt throw exception for size")
    //}catch (IndexOutOfBoundsException ioobe){
    //good
    //}
    fail("Not yet implemented");
  }


  @Test
  void testSet() {
    //similar to get
    fail("Not yet implemented");
  }


  @Test
  void testIndexOf() {
    fail("Not yet implemented");
  }


  @Test
  void testSize() {
    fail("Not yet implemented");
  }


  @Test
  void testAddE() {
    fail("Not yet implemented");
  }


  @Test
  void testAddIntE() {
    fail("Not yet implemented");
  }


  @Test
  void testRemove() {
    fail("Not yet implemented");
  }

}
