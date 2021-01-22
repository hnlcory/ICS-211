/**
 * mid level cloud.
 * @author Cory Parker
 */
package edu.ics211.h02;

/**
 * extends cloud to a mid level, checks for proper altitude.
 * @author Cory Parker
 *
 */
public abstract class MidLevel extends Cloud {

  protected MidLevel(Integer altitude, CloudShape shape) {
    super(altitude, shape);
    //Mid level throw an IllegalArgumentException if altitude > 19999, < 6,501.
    if (altitude > 19999 || altitude < 6501) {
      throw new IllegalArgumentException();
    }
  }
    
}
