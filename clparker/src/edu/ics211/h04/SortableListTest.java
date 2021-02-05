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
    sortedList.add(6);
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
    SortableList<Integer> list = new SortableList<Integer>();//create list
    list.add(3);//add some items
    list.add(6);
    list.add(10);
    list.add(15);
    
    //get good values
    assertEquals(sortedList.get(0), list.get(0));
    assertEquals(sortedList.get(3),list.get(list.size()-1));
   
    //test some bad values
    try {
      list.get(-1);
      list.get(list.size());
      fail("should throw IOOBE exception");
    }
    catch(IndexOutOfBoundsException ioobe){
    }  
  }


  @Test
  void testSet() {
    SortableList<Integer> list = new SortableList<Integer>();
    list.add(5);//add some items
    list.add(8);
    list.add(20);
    list.add(55);
    
    //good values
    list.set(0, 3);
    list.set(1, 6);
    list.set(2, 10);
    list.set(3, 15);
    
    //bad values
    try {
      list.set(-1, 5);
      list.set(list.size(), 7);
    }
   catch (IndexOutOfBoundsException ioobe){  
   }  
  }


  @Test
  void testIndexOf() {//retuns size of list
    SortableList<Integer> list = new SortableList<Integer>();//create list
    list.add(3);//add some items
    list.add(6);
    list.add(10);
    list.add(15);
    //in list
    assertEquals(list.indexOf(6), sortedList.indexOf(6));
    assertEquals(list.indexOf(3), sortedList.indexOf(3));
    assertEquals(list.indexOf(15), sortedList.indexOf(15));
    //not in list
    assertEquals(list.indexOf(25), sortedList.indexOf(25));
  }


  @Test
  void testSize() {//returns the size of list
    SortableList<Integer> list = new SortableList<Integer>();//create list
    list.add(3);//add some items
    list.add(6);
    list.add(10);
    list.add(15);
    
    assertEquals(list.size(),sortedList.size());
    
    list.add(13);
    try {
      assertEquals(list.size(),sortedList.size());//should fail
    }
    catch(AssertionError AE){
     
    }
   
  }


  @Test
  void testAddE() {//Adds e to the end of the list.
    SortableList<Integer> list = new SortableList<Integer>();
    list.add(3);
    list.add(6);
   
    assertEquals(list.indexOf(1),sortedList.indexOf(1));
  }


  @Test
  void testAddIntE() {//Adds element to the list at the given index 
    SortableList<Integer> list = new SortableList<Integer>();//create list
    list.add(3);//add some items
    list.add(12);
    
    list.add(1, 6);
    
    list.add(3,15);
    list.add(3,15);
    list.add(3,15);
   
   
    
    
    assertEquals(sortedList.get(1), list.get(1));
    assertEquals(sortedList.get(3), list.get(3));
    
    try {
    list.add(-1, 25);
    }
    catch (IndexOutOfBoundsException IOOBE) {
    }
  }


  @Test
  void testRemove() {//Removes the element at the given index.
    SortableList<Integer> list = new SortableList<Integer>();//create list
    list.add(3);//add some items
    list.add(6);
    list.add(12);
    list.add(10);
    list.add(15); 
    
    list.remove(2);
    assertEquals(list.get(2), sortedList.get(2));
    
    try {
      list.remove(-1);
      }
      catch (IndexOutOfBoundsException IOOBE) {
      }  
    list.remove(0);
    list.remove(0);
    list.remove(0);
    list.remove(0);
    
  }

}
