package edu.ics211.h04;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Array;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.ics211.h02.AltitudeComparator;
import edu.ics211.h02.Cloud;
import edu.ics211.h02.CloudShape;
import edu.ics211.h02.MotherNature;

class SortedCloudListTest {
  private MotherNature mother;
  private AltitudeComparator altC;
  private Cloud[] inorder;

  @BeforeEach
  void setUp() throws Exception {
    mother = MotherNature.getInstance();
    altC = new AltitudeComparator();
    inorder = new Cloud[100];
    for (int i = 0; i < inorder.length; i++) {
      inorder[i] = mother.formACloud(21000 + 50 * i, CloudShape.CIRRO);
    }
  }


  @Test
  void testSortedCloudList() {
    SortedCloudList list = new SortedCloudList(altC);
    assertNotNull(list);
    assertEquals(0, list.size());
  }


  @Test
  void testGet() {
    // create a list with clouds
    SortedCloudList list = new SortedCloudList(altC);
    list.add(inorder[4]);
    list.add(inorder[2]);
    list.add(inorder[0]);
    // try some good values
    assertEquals(inorder[0], list.get(0));
    assertEquals(inorder[2], list.get(1));
    assertEquals(inorder[4], list.get(2));
    // try some bad values
    try {
      list.get(-1);
      fail("Didn't throw IndexOutOfBoundsException for index -1");
    } catch (IndexOutOfBoundsException ioobe) {
      // this is what we want.
    }
    try {
      list.get(list.size());
      fail("Didn't throw IndexOutOfBoundsException for index size");
    } catch (IndexOutOfBoundsException ioobe) {
      // this is what we want.
    }
  }


  @Test
  void testSet() {
    // create a list with clouds
    SortedCloudList list = new SortedCloudList(altC);
    list.add(inorder[4]);
    list.add(inorder[2]);
    list.add(inorder[0]);
    // try some good values
    Cloud old = list.set(0, inorder[1]);
    assertEquals(inorder[0], old);
    assertEquals(inorder[1], list.get(0));
    // try some bad values
    try {
      list.set(-1, old);
      fail("Didn't throw IndexOutOfBoundsException for index -1");
    } catch (IndexOutOfBoundsException ioobe) {
      // this is what we want.
    }
    try {
      list.set(list.size(), old);
      fail("Didn't throw IndexOutOfBoundsException for index size");
    } catch (IndexOutOfBoundsException ioobe) {
      // this is what we want.
    }
  }


  @Test
  void testIndexOf() {
    // create a list with clouds
    SortedCloudList list = new SortedCloudList(altC);
    list.add(inorder[4]);
    list.add(inorder[2]);
    list.add(inorder[0]);
    // try some good values
    assertTrue("Got wrong index", list.indexOf(inorder[0]) == 0);
    assertTrue("Got wrong index", list.indexOf(inorder[2]) == 1);
    assertTrue("Got wrong index", list.indexOf(inorder[4]) == 2);//here
    // try a cloud not in the list
    assertTrue("Got wrong index", list.indexOf(inorder[1]) == -1);
  }


  @Test
  void testSize() {
    SortedCloudList list = new SortedCloudList(altC);
    assertEquals(0, list.size());
    list.add(inorder[4]);
    assertEquals(1, list.size());
    list.add(inorder[2]);
    assertEquals(2, list.size());
    list.add(inorder[0]);
    assertEquals(3, list.size());
    list.remove(0);
    assertEquals(2, list.size());
  }


  @Test
  void testAddCloud() {
    SortedCloudList list = new SortedCloudList(altC);
    list.add(inorder[4]);
    assertEquals(1, list.size());
    assertEquals(inorder[4], list.get(0));
    list.add(inorder[2]);
    assertEquals(2, list.size());
    assertEquals(inorder[2], list.get(0));
    assertEquals(inorder[4], list.get(1));
    list.add(inorder[0]);
    assertEquals(3, list.size());
    assertEquals(inorder[0], list.get(0));
    assertEquals(inorder[2], list.get(1));
    assertEquals(inorder[4], list.get(2));
  }


  @Test
  void testAddIntCloud() {
    SortedCloudList list = new SortedCloudList(altC);
    list.add(0, inorder[4]);
    assertEquals(1, list.size());
    assertEquals(inorder[4], list.get(0));
    list.add(1, inorder[2]);
    assertEquals(2, list.size());
    assertEquals(inorder[2], list.get(0));//here
    assertEquals(inorder[4], list.get(1));
    list.add(2, inorder[0]);
    assertEquals(3, list.size());
    assertEquals(inorder[0], list.get(0));
    assertEquals(inorder[2], list.get(1));
    assertEquals(inorder[4], list.get(2));
    // try some bad values
    try {
      list.add(-1, inorder[1]);
      fail("Didn't throw IndexOutOfBoundsException for index -1");
    } catch (IndexOutOfBoundsException ioobe) {
      // this is what we want
    }
    try {
      list.add(list.size() + 1, inorder[1]);
      fail("Didn't throw IndexOutOfBoundsException for index size + 1");
    } catch (IndexOutOfBoundsException ioobe) {
      // this is what we want
    }
  }


  @Test
  void testRemove() {
    // create a list with clouds
    SortedCloudList list = new SortedCloudList(altC);
    list.add(inorder[4]);
    list.add(inorder[2]);
    list.add(inorder[0]);
    // try some bad values
    try {
      list.remove(-1);
      fail("Didn't throw IndexOutOfBoundsException for index -1");
    } catch (IndexOutOfBoundsException ioobe) {
      // this is what we want.
    }
    try {
      list.remove(list.size());
      fail("Didn't throw IndexOutOfBoundsException for index size");
    } catch (IndexOutOfBoundsException ioobe) {
      // this is what we want
    }
    // try some good values
    Cloud removed = list.remove(1);
    assertEquals(removed, inorder[2]);
    assertEquals(2, list.size());
    removed = list.remove(0);
    assertEquals(removed, inorder[0]);
    assertEquals(1, list.size());
    removed = list.remove(0);
    assertEquals(removed, inorder[4]);
    assertEquals(0, list.size());
  }

}
