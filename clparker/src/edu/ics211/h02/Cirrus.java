/**
 * 
 */
package edu.ics211.h02;

import java.util.Random;

/**
 * @author Cory Parker
 *
 */
public class Cirrus extends HighLevel {

  /**
   * 
   */
  public Cirrus() {
    super(ranNum(), CloudShape.CIRRO);
    //A constructor with no parameters. set the altitude to a valid random value for the cloud
    // set CloudShape correctly
  }
  
  public Cirrus (Integer altitude) {
    super(altitude, CloudShape.CIRRO);
    //constructor with one parameter: altitude  
  }
  
  public static int ranNum() {
    Random random = new Random();
    int x = random.nextInt(20001);//change************
    return x;
  }

}
