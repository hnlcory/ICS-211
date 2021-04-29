/**
 * 
 */
package edu.ics211.h12;

import edu.ics211.h10.BinarySearchTree;

/**
 * @author Cory-PC
 *
 */
public class MediumPotionBag implements PotionBag {
  private static MediumPotionBag instance;

  private int size;
  // Use Binary Search tree from h10
  private BinarySearchTree<Potion> tree;

  public static MediumPotionBag getInstance() {
    if (instance == null) {
      instance = new MediumPotionBag();
    }
    return instance;
  }


  private MediumPotionBag() {
    size = 0;
    tree = new BinarySearchTree<Potion>(new PotionComparator());
  }


  @Override
  public void store(Potion p) {
    // call tree.add(p) check return value to see if p is already in tree
    if (tree.add(p) == false) {

    }
    // if ok increment size
    size++;

  }


  @Override
  public long timedStore(Potion p) {
    // get time
    long startTime = System.nanoTime();
    store(p);
    // get end time
    long endTime = System.nanoTime();
    // return dif
    return endTime - startTime;
  }


  @Override
  public Potion retrieve(Potion p) {
    // tree.delete
    if (tree.delete(p) != null) {
      // if delete works, decrement size
      // return p
      size--;
      return p;
    } else {
      return null;
    }

  }


  @Override
  public long timedRetrieve(Potion p) {
    // get time
    long startTime = System.nanoTime();
    // Call retrieve
    retrieve(p);
    long endTime = System.nanoTime();
    // return dif
    return endTime - startTime;
  }


  @Override
  public int size() {
    return size;
  }

}
