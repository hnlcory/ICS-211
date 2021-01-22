/**
   * Creates a Cirrostratus cloud.
   * @author Cory Parker
   */

package edu.ics211.h02;

import java.util.Random;

/**
 * Cirrostratus Cloud.
 * @author Cory Parker
 *
 */
public class Cirrostratus extends HighLevel {

  /**
   * sets the altitude to a valid random value for the cloud.
   * @author Cory Parker
   */
  public Cirrostratus() {
    super(ranNum(), CloudShape.STRATO);
    //A constructor with no parameters. 
    // set CloudShape correctly
  }
  
  /**
   * takes integer to set altitude for cloud.
   * @author Cory Parker
   * @param altitude from super
   */
  public Cirrostratus (Integer altitude) {
    super(altitude, CloudShape.STRATO);
    //constructor with one parameter: altitude  
  }
  
  /**
   * generates random number.
   * @author Cory Parker
   * @return random number in range
   */
  public static int ranNum() {
    Random random = new Random();
    int x = random.nextInt(15000) + 20000;
    return x;
  }

}
