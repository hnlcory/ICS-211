/**
 * 
 */
package edu.ics211.h12;

import java.util.LinkedList;

/**
 * @author Cory-PC
 *
 */
public class SlowPotionBag implements PotionBag {
  private static SlowPotionBag instance;
  // singleton thing
  // if use a list
  private LinkedList<Potion> list;

  public static SlowPotionBag getInstance() {
    if (instance == null) {
      instance = new SlowPotionBag();
    }
    return instance;
  }


  private SlowPotionBag() {
    list = new LinkedList<Potion>();
  }


  @Override
  public void store(Potion p) {
    // if using a linked list add at size/2 (middle of list)
    list.add(list.size() / 2, p);

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


  // linked list remove (int index) index of(p)
  @Override
  public Potion retrieve(Potion p) {
    return list.remove(list.indexOf(p));
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
    return list.size();
  }

}
