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

  /**
   * Sets up tests.
   * @throws Exception if there is a problem.
   */
  
  @BeforeEach
  void setUp() throws Exception {
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
    list.add(10);
    
    list.insertionSort(new IntegerComparator());
    
    
    assertEquals(3, list.get(0));
    assertEquals(6, list.get(1));
    assertEquals(10, list.get(2));
    
  }


  @Test
  void testBubbleSort() {
    fail("Not yet implemented");
  }


  @Test
  void testSelectionSort() {
    fail("Not yet implemented");
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
