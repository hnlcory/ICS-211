package edu.ics211.h06;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SortableListTest {
  private SortableList<String> list;

  @BeforeEach
  void setUp() throws Exception {
    this.list = new SortableList<String>();
  }


  @Test
  void testSortableList() {
    assertNotNull(list);
    assertEquals(0, list.size());
  }


  @Test
  void testIterator() {
    list.add("foo");
    list.add("bar");
    list.add("baz");
    list.add("qux");
    list.add("zob");
    Iterator<String> iter = list.iterator();
    assertNotNull(iter);
    assertTrue(iter.hasNext());
    assertTrue(iter instanceof ListIterator);
    ListIterator<String> lIter = (ListIterator<String>) iter;
    assertEquals(0, lIter.nextIndex());
    assertEquals(-1, lIter.previousIndex());
    assertTrue(lIter.hasNext());
    assertFalse(lIter.hasPrevious());
    String val = lIter.next();
    assertEquals("foo", val);
    assertEquals(1, lIter.nextIndex());
    assertEquals(0, lIter.previousIndex());
    assertTrue(lIter.hasNext());
    assertTrue(lIter.hasPrevious());
    val = lIter.previous();
    assertEquals("foo", val);
    assertEquals(0, lIter.nextIndex());
    assertEquals(-1, lIter.previousIndex());
    assertTrue(lIter.hasNext());
    assertFalse(lIter.hasPrevious());
    try {
      val = lIter.previous();
      fail("Should have thrown exception");
    } catch (NoSuchElementException nsee) {
      // this is what we want
    }
    lIter.next();
    lIter.next();
    lIter.next();
    lIter.next();
    val = lIter.next();
    assertEquals("zob", val);
    assertEquals(list.size(), lIter.nextIndex());
    assertEquals(list.size() - 1, lIter.previousIndex());
    assertFalse(lIter.hasNext());
    assertTrue(lIter.hasPrevious());
    try {
      val = lIter.next();
      fail("Should have thrown exception");
    } catch (NoSuchElementException nsee) {
      // this is what we want
    }
  }


  @Test
  void testIteratorComparatorOfE() {
    list.add("foo");
    list.add("bar");
    list.add("baz");
    list.add("qux");
    list.add("zob");
    Iterator<String> iter = list.iterator(new StringComparator());
    assertNotNull(iter);
    assertTrue(iter.hasNext());
    String val = iter.next();
    assertEquals("bar", val);
    val = iter.next();
    assertEquals("baz", val);
    val = iter.next();
    assertEquals("foo", val);
    val = iter.next();
    assertEquals("qux", val);
    val = iter.next();
    assertEquals("zob", val);
    assertFalse(iter.hasNext());
    try {
      val = iter.next();
      fail("Should have thrown exception");
    } catch (NoSuchElementException nsee) {
      // this is what we want
    }
  }


  @Test
  void testGet() {
    list.add("foo");
    list.add("bar");
    list.add("baz");
    assertEquals("foo", list.get(0));
    assertEquals("bar", list.get(1));
    assertEquals("baz", list.get(2));
    try {
      list.get(-1);
      fail("Should have thrown exception");
    } catch (IndexOutOfBoundsException ioobe) {
      // this is what we want
    }
    try {
      list.get(list.size());
      fail("Should have thrown exception");
    } catch (IndexOutOfBoundsException ioobe) {
      // this is what we want
    }
  }


  @Test
  void testSet() {
    list.add("foo");
    list.add("bar");
    list.add("baz");
    String val = list.set(0, "qux");
    assertEquals("foo", val);
    assertEquals("qux", list.get(0));
    try {
      list.set(-1, "");
      fail("Should have thrown exception");
    } catch (IndexOutOfBoundsException ioobe) {
      // this is what we want
    }
    try {
      list.set(list.size(), "");
      fail("Should have thrown exception");
    } catch (IndexOutOfBoundsException ioobe) {
      // this is what we want
    }
  }


  @Test
  void testIndexOf() {
    list.add("foo");
    list.add("bar");
    list.add("baz");
    assertEquals(0, list.indexOf("foo"));
    assertEquals(1, list.indexOf("bar"));
    assertEquals(2, list.indexOf("baz"));
    assertEquals(-1, list.indexOf("qux"));
  }


  @Test
  void testSize() {
    assertEquals(0, list.size());
    list.add("foo");
    assertEquals(1, list.size());
    list.add("bar");
    assertEquals(2, list.size());
    list.remove(0);
    assertEquals(1, list.size());
  }


  @Test
  void testAddE() {
    list.add("foo");
    list.add("bar");
    list.add("baz");
    assertEquals(0, list.indexOf("foo"));
    assertEquals(1, list.indexOf("bar"));
    assertEquals(2, list.indexOf("baz"));
  }


  @Test
  void testAddIntE() {
    list.add(0, "foo");
    list.add(0, "bar");
    list.add(0, "baz");
    assertEquals(2, list.indexOf("foo"));
    assertEquals(1, list.indexOf("bar"));
    assertEquals(0, list.indexOf("baz"));
    try {
      list.add(-1, "");
      fail("Should have thrown exception");
    } catch (IndexOutOfBoundsException ioobe) {
      // this is what we want
    }
    try {
      list.add(list.size() + 1, "");
      fail("Should have thrown exception");
    } catch (IndexOutOfBoundsException ioobe) {
      // this is what we want
    }
  }


  @Test
  void testRemove() {
    list.add("foo");
    list.add("bar");
    list.add("baz");
    String val = list.remove(2);
    assertEquals("baz", val);
    assertEquals(2, list.size());
    try {
      list.remove(-1);
      fail("Should have thrown exception");
    } catch (IndexOutOfBoundsException ioobe) {
      // this is what we want
    }
    try {
      list.remove(list.size());
      fail("Should have thrown exception");
    } catch (IndexOutOfBoundsException ioobe) {
      // this is what we want
    }
  }

}
