/**
   * Creates a Altostratus cloud.
   * @author Cory Parker
   */

package edu.ics211.h02;

import java.util.Random;

/**
 * Altostratus Cloud.
 * @author Cory Parker
 *
 */
public class Altostratus extends MidLevel {

  /**
   * sets the altitude to a valid random value for the cloud.
   * @author Cory Parker
   */
  public Altostratus() {
    super(ranNum(), CloudShape.STRATO);
    //A constructor with no parameters. set the altitude to a valid random value for the cloud
    // set CloudShape correctly
  }
  
  /**
   * takes integer to set altitude for cloud.
   * @author Cory Parker
   * @param altitude from super
   */
  public Altostratus(Integer altitude) {
    super(altitude, CloudShape.STRATO);
  }
  
  /**
   * generates random number.
   * @author Cory Parker
   * @return random number in range
   */
  public static int ranNum() {
    Random random = new Random();
    int x = random.nextInt(20000 - 6501) + 6501;//possibly wrong
    return x;
  }
  
  
}
