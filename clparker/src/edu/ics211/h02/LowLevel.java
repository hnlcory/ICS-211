/**
 * Low level cloud.
 * @author Cory Parker
 */
package edu.ics211.h02;

/**
 * extends cloud to a Low level, checks for proper altitude.
 * @author Cory Parker
 *
 */
public abstract class LowLevel extends Cloud {

 
 
   
  protected LowLevel(Integer altitude, CloudShape shape) {
    super(altitude, shape);
    if (altitude > 6500) {
      throw new IllegalArgumentException();
    }
    //LowLevel throw an IllegalArgumentException if altitude > 6,500.
  }

}
