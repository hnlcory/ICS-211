/**
 * 
 */
package edu.ics211.h02;

import java.util.Random;

/**
 * @author Cory Parker
 *
 */
public class Altostratus extends MidLevel {

  /**
   * 
   */
  public Altostratus() {
    super(ranNum(), CloudShape.STRATO);
    // TODO Auto-generated constructor stub
  }
  public Altostratus(Integer altitude) {
    super(altitude, CloudShape.STRATO);
  }
  
  public static int ranNum() {
    Random random = new Random();
    int x = random.nextInt(20000 - 6501) + 6501;//possibly wrong
    return x;
  }
  
  
}
