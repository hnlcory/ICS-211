/**
 * 
 */
package edu.ics211.h12;

import java.util.Hashtable;

/**
 * @author Cory-PC
 *
 */
public class QuickPotionBag implements PotionBag {
  private static QuickPotionBag instance;

  private int size;
  private Hashtable<Potion, Potion> table;

  public static QuickPotionBag getInstance() {
    if (instance == null) {
      instance = new QuickPotionBag();
    }
    return instance;
  }


  private QuickPotionBag() {
    // inint variables
    size = 0;
    table = new Hashtable<Potion, Potion>();
  }


  @Override
  public void store(Potion p) {
    table.put(p, p);
    size++;

  }


  @Override
  public long timedStore(Potion p) {
    // get start time
    long startTime = System.nanoTime();
    // call store
    store(p);
    // get end
    long endTime = System.nanoTime();
    // return diff
    return endTime - startTime;
  }


  @Override
  public Potion retrieve(Potion p) { // CONFIRM --? *****
    // decrement size
    size--;
    // table.get(p)
    return table.get(p);
  }


  @Override
  public long timedRetrieve(Potion p) {
    // get start time
    long startTime = System.nanoTime();
    // call retrieve
    retrieve(p);
    // get end
    long endTime = System.nanoTime();
    // return diff
    return endTime - startTime;
  }


  @Override
  public int size() {
    return size;
  }

}
