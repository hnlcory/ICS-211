package edu.ics211.h10;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Comparator;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.ics211.h02.AltitudeComparator;
import edu.ics211.h02.Cloud;
import edu.ics211.h02.CloudShape;
import edu.ics211.h02.MotherNature;

class BinarySearchTreeTest {
  private MotherNature mother;
  private Comparator<Cloud> comp;

  @BeforeEach
  void setUp() throws Exception {
    mother = MotherNature.getInstance();
    comp = new AltitudeComparator();
  }


  @Test
  void testBinarySearchTree() {
    BinarySearchTree<Cloud> tree = new BinarySearchTree<>(comp);
    assertNotNull(tree);
  }


  @Test
  void testAdd() {
    BinarySearchTree<Cloud> tree = new BinarySearchTree<>(comp);
    assertNotNull(tree);
    Cloud cloud = mother.formACloud(1000, CloudShape.CUMULO);
    assertTrue(tree.add(cloud));
    assertFalse(tree.add(cloud));
    assertTrue(tree.contains(cloud));
    cloud = mother.formACloud(100, CloudShape.CUMULO);
    assertTrue(tree.add(cloud));
    assertTrue(tree.contains(cloud));
    cloud = mother.formACloud(500, CloudShape.CUMULO);
    assertTrue(tree.add(cloud));
    assertTrue(tree.contains(cloud));
    cloud = mother.formACloud(2500, CloudShape.CUMULO);
    assertTrue(tree.add(cloud));
    assertTrue(tree.contains(cloud));
  }


  @Test
  void testContains() {
    BinarySearchTree<Cloud> tree = new BinarySearchTree<>(comp);
    assertNotNull(tree);
    Cloud cloud = mother.formACloud(1000, CloudShape.CUMULO);
    assertTrue(tree.add(cloud));
    assertFalse(tree.add(cloud));
    assertTrue(tree.contains(cloud));
    cloud = mother.formACloud(100, CloudShape.CUMULO);
    assertTrue(tree.add(cloud));
    assertTrue(tree.contains(cloud));
    cloud = mother.formACloud(500, CloudShape.CUMULO);
    assertTrue(tree.add(cloud));
    assertTrue(tree.contains(cloud));
    cloud = mother.formACloud(2500, CloudShape.CUMULO);
    assertTrue(tree.add(cloud));
    assertTrue(tree.contains(cloud));
    cloud = mother.formACloud(2000, CloudShape.CUMULO);
    assertFalse(tree.contains(cloud));
  }


  @Test
  void testFind() {
    BinarySearchTree<Cloud> tree = new BinarySearchTree<>(comp);
    assertNotNull(tree);
    Cloud cloud = mother.formACloud(1000, CloudShape.CUMULO);
    assertTrue(tree.add(cloud));
    assertFalse(tree.add(cloud));
    assertEquals(cloud, tree.find(cloud));
    cloud = mother.formACloud(100, CloudShape.CUMULO);
    assertTrue(tree.add(cloud));
    assertEquals(cloud, tree.find(cloud));
    cloud = mother.formACloud(500, CloudShape.CUMULO);
    assertTrue(tree.add(cloud));
    assertEquals(cloud, tree.find(cloud));
    cloud = mother.formACloud(2500, CloudShape.CUMULO);
    assertTrue(tree.add(cloud));
    assertEquals(cloud, tree.find(cloud));
    cloud = mother.formACloud(2000, CloudShape.CUMULO);
    assertNull(tree.find(cloud));
  }


  @Test
  void testDelete() {
    BinarySearchTree<Cloud> tree = new BinarySearchTree<>(comp);
    Cloud cloud = mother.formACloud(1000, CloudShape.CUMULO);
    assertTrue(tree.add(cloud));
    assertFalse(tree.add(cloud));
    assertEquals(cloud, tree.find(cloud));
    cloud = mother.formACloud(100, CloudShape.CUMULO);
    assertTrue(tree.add(cloud));
    assertEquals(cloud, tree.find(cloud));
    cloud = mother.formACloud(500, CloudShape.CUMULO);
    assertTrue(tree.add(cloud));
    assertEquals(cloud, tree.find(cloud));
    cloud = mother.formACloud(2500, CloudShape.CUMULO);
    assertTrue(tree.add(cloud));
    assertEquals(cloud, tree.find(cloud));
    cloud = mother.formACloud(3500, CloudShape.CUMULO);
    assertNull(tree.delete(cloud));
    cloud = mother.formACloud(100, CloudShape.CUMULO);
    assertEquals(cloud.getAltitude(), tree.delete(cloud).getAltitude());
    cloud = mother.formACloud(1000, CloudShape.CUMULO);
    assertEquals(cloud.getAltitude(), tree.delete(cloud).getAltitude());
    cloud = mother.formACloud(500, CloudShape.CUMULO);
    assertEquals(cloud.getAltitude(), tree.delete(cloud).getAltitude());
    cloud = mother.formACloud(2500, CloudShape.CUMULO);
    assertEquals(cloud.getAltitude(), tree.delete(cloud).getAltitude());
}


  @Test
  void testRemove() {
    BinarySearchTree<Cloud> tree = new BinarySearchTree<>(comp);
    Cloud cloud = mother.formACloud(1000, CloudShape.CUMULO);
    assertTrue(tree.add(cloud));
    assertFalse(tree.add(cloud));
    assertEquals(cloud, tree.find(cloud));
    cloud = mother.formACloud(100, CloudShape.CUMULO);
    assertTrue(tree.add(cloud));
    assertEquals(cloud, tree.find(cloud));
    cloud = mother.formACloud(500, CloudShape.CUMULO);
    assertTrue(tree.add(cloud));
    assertEquals(cloud, tree.find(cloud));
    cloud = mother.formACloud(2500, CloudShape.CUMULO);
    assertTrue(tree.add(cloud));
    assertEquals(cloud, tree.find(cloud));
    cloud = mother.formACloud(3500, CloudShape.CUMULO);
    assertFalse(tree.remove(cloud));
    cloud = mother.formACloud(100, CloudShape.CUMULO);
    assertTrue(tree.remove(cloud));
    cloud = mother.formACloud(1000, CloudShape.CUMULO);
    assertTrue(tree.remove(cloud));
    cloud = mother.formACloud(500, CloudShape.CUMULO);
    assertTrue(tree.remove(cloud));
    cloud = mother.formACloud(2500, CloudShape.CUMULO);
    assertTrue(tree.remove(cloud));
    assertFalse(tree.remove(cloud));
  }


  @Test
  void testInorder() {
    BinarySearchTree<Cloud> tree = new BinarySearchTree<>(comp);
    Cloud cloud = mother.formACloud(1000, CloudShape.CUMULO);
    assertTrue(tree.add(cloud));
    assertFalse(tree.add(cloud));
    assertEquals(cloud, tree.find(cloud));
    cloud = mother.formACloud(100, CloudShape.CUMULO);
    assertTrue(tree.add(cloud));
    assertEquals(cloud, tree.find(cloud));
    cloud = mother.formACloud(500, CloudShape.CUMULO);
    assertTrue(tree.add(cloud));
    assertEquals(cloud, tree.find(cloud));
    cloud = mother.formACloud(2500, CloudShape.CUMULO);
    assertTrue(tree.add(cloud));
    List<Cloud> clouds = tree.inorder();
    assertTrue(clouds.size() == 4);
    assertTrue(clouds.get(0).getAltitude() == 100);
    assertTrue(clouds.get(1).getAltitude() == 500);
    assertTrue(clouds.get(2).getAltitude() == 1000);
    assertTrue(clouds.get(3).getAltitude() == 2500);
  }

}
