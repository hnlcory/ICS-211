/**
 * 
 */
package edu.ics211.h02;

/**
 * @author Cory Parker
 *
 */
public abstract class MidLevel extends Cloud {

  protected MidLevel(Integer altitude, CloudShape shape) {
    super(altitude, shape);
    if (altitude > 1999 || altitude < 6501) {
      throw new IllegalArgumentException();
    }
  }
    
}
