/**
   * Creates a Cirrus cloud.
   * @author Cory Parker
   */

package edu.ics211.h02;

import java.util.Random;

/**
 * Cirrus Cloud.
 * @author Cory Parker
 */
public class Cirrus extends HighLevel {

  /**
   * sets the altitude to a valid random value for the cloud.
   * @author Cory Parker
   */
  public Cirrus() {
    super(ranNum(), CloudShape.CIRRO);
    //A constructor with no parameters. set the altitude to a valid random value for the cloud
    // set CloudShape correctly
  }
  
  /**
   * takes integer to set altitude for cloud.
   * @author Cory Parker
   * @param altitude from super
   */
  public Cirrus (Integer altitude) {
    super(altitude, CloudShape.CIRRO);
    //constructor with one parameter altitude  
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
