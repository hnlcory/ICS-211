/**
 * 
 */
package edu.ics211.h02;

import java.util.Random;

/**
 * @author Cory Parker
 *
 */
public class Cumulus extends LowLevel {

  /**
   * 
   */
  public Cumulus() {
    super(ranNum(), CloudShape.CUMULO);
    //A constructor with no parameters. set the altitude to a valid random value for the cloud
    // set CloudShape correctly
  }
  
  public Cumulus (Integer altitude) {
    super(altitude, CloudShape.CUMULO);
    //constructor with one parameter: altitude  
  }
  
  public static int ranNum() {
    Random random = new Random();
    int x = random.nextInt(6500);
    return x;
  }
  
}
