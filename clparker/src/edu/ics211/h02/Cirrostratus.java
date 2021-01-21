/**
 * 
 */
package edu.ics211.h02;

import java.util.Random;

/**
 * @author Cory Parker
 *
 */
public class Cirrostratus extends HighLevel {

  /**
   * 
   */
  public Cirrostratus() {
    super(ranNum(), CloudShape.STRATO);
    //A constructor with no parameters. set the altitude to a valid random value for the cloud
    // set CloudShape correctly
  }
  
  public Cirrostratus (Integer altitude) {
    super(altitude, CloudShape.STRATO);
    //constructor with one parameter: altitude  
  }
  
  public static int ranNum() {
    Random random = new Random();
    int x = random.nextInt(20001);//change************
    return x;
  }

}
