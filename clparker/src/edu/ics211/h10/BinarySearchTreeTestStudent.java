package edu.ics211.h10;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import edu.ics211.h02.AltitudeComparator;
import edu.ics211.h02.Cloud;
import edu.ics211.h02.CloudShape;
import edu.ics211.h02.MotherNature;
import java.util.Comparator;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BinarySearchTreeTestStudent {
  public MotherNature mn;
  public Comparator<Cloud> comp;

  @BeforeEach
  void setUp() throws Exception {
    mn = MotherNature.getInstance();
    comp = new AltitudeComparator();
  }


  @Test
  void testBinarySearchTree() {
    BinarySearchTree<Cloud> tree = new BinarySearchTree<>(comp);
    assertNotNull(tree);
  }


  @Test
  void testInorder() {
    BinarySearchTree<Cloud> tree = new BinarySearchTree<>(comp);
    Cloud cloud = mn.formACloud(1000, CloudShape.CUMULO);
    assertTrue(tree.add(cloud));
    cloud = mn.formACloud(5000, CloudShape.CUMULO);
    assertTrue(tree.add(cloud));
    cloud = mn.formACloud(2000, CloudShape.CUMULO);
    assertTrue(tree.add(cloud));
    cloud = mn.formACloud(3000, CloudShape.CUMULO);
    assertTrue(tree.add(cloud));
    cloud = mn.formACloud(200, CloudShape.CUMULO);
    assertTrue(tree.add(cloud));
    List<Cloud> sortedClouds = tree.inorder();
    assertTrue(sortedClouds.get(0).getAltitude() == 200);
    assertTrue(sortedClouds.get(1).getAltitude() == 1000);
    assertTrue(sortedClouds.get(2).getAltitude() == 2000);
    assertTrue(sortedClouds.get(3).getAltitude() == 3000);
    assertTrue(sortedClouds.get(4).getAltitude() == 5000);
  }


  @Test
  void testAdd() {
    BinarySearchTree<Cloud> tree = new BinarySearchTree<>(comp);
    Cloud cloud = mn.formACloud(200, CloudShape.CUMULO);
    assertTrue(tree.add(cloud));
    cloud = mn.formACloud(1, CloudShape.CUMULO);
    assertTrue(tree.add(cloud));
    assertFalse(tree.add(cloud));
  }


  @Test
  void testContains() {
    BinarySearchTree<Cloud> tree = new BinarySearchTree<>(comp);
    Cloud cloud = mn.formACloud(200, CloudShape.CUMULO);
    tree.add(cloud);
    assertTrue(tree.contains(cloud));
    cloud = mn.formACloud(1, CloudShape.CUMULO);
    tree.add(cloud);
    assertTrue(tree.contains(cloud));
    cloud = mn.formACloud(500, CloudShape.CUMULO);
    tree.add(cloud);
    assertTrue(tree.contains(cloud));
    cloud = mn.formACloud(900, CloudShape.CUMULO);
    tree.add(cloud);
    assertTrue(tree.contains(cloud));
  }


  @Test
  void testFind() {
    BinarySearchTree<Cloud> tree = new BinarySearchTree<>(comp);
    Cloud cloud = mn.formACloud(200, CloudShape.CUMULO);
    tree.add(cloud);
    assertEquals(cloud, tree.find(cloud));
    cloud = mn.formACloud(5000, CloudShape.CUMULO);
    tree.add(cloud);
    assertEquals(cloud, tree.find(cloud));
    cloud = mn.formACloud(1, CloudShape.CUMULO);
    tree.add(cloud);
    assertEquals(cloud, tree.find(cloud));
  }


  @Test
  void testDelete() {
    BinarySearchTree<Cloud> tree = new BinarySearchTree<>(comp);
    Cloud cloud = mn.formACloud(200, CloudShape.CUMULO);
    tree.add(cloud);
    cloud = mn.formACloud(1, CloudShape.CUMULO);
    tree.add(cloud);
    cloud = mn.formACloud(500, CloudShape.CUMULO);
    tree.add(cloud);
    cloud = mn.formACloud(900, CloudShape.CUMULO);
    tree.add(cloud);
    tree.delete(cloud);
    assertEquals(tree.contains(cloud), false);
  }


  @Test
  void testRemove() {
    BinarySearchTree<Cloud> tree = new BinarySearchTree<>(comp);
    Cloud cloud = mn.formACloud(200, CloudShape.CUMULO);
    tree.add(cloud);
    cloud = mn.formACloud(1, CloudShape.CUMULO);
    tree.add(cloud);
    cloud = mn.formACloud(500, CloudShape.CUMULO);
    tree.add(cloud);
    cloud = mn.formACloud(900, CloudShape.CUMULO);
    tree.add(cloud);
    assertTrue(tree.remove(cloud));
  }

}
