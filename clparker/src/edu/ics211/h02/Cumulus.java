/**
   * Creates a Cumulus cloud.
   * @author Cory Parker
   */

package edu.ics211.h02;

import java.util.Random;

/**
 * Cumulus Cloud.
 * @author Cory Parker
 *
 */
public class Cumulus extends LowLevel {

  /**
   * sets the altitude to a valid random value for the cloud.
   * @author Cory Parker
   */
  public Cumulus() {
    super(ranNum(), CloudShape.CUMULO);
    //A constructor with no parameters. set the altitude to a valid random value for the cloud
    // set CloudShape correctly
  }
  
  /**
   * takes integer to set altitude for cloud.
   * @author Cory Parker
   * @param altitude from super
   */
  public Cumulus (Integer altitude) {
    super(altitude, CloudShape.CUMULO);
    //constructor with one parameter: altitude  
  }
  
  /**
   * generates random number.
   * @author Cory Parker
   * @return random number in range
   */
  public static int ranNum() {
    Random random = new Random();
    int x = random.nextInt(6500);
    return x;
  }
  
}
