/**
 * High level cloud.
 * @author Cory Parker
 */
package edu.ics211.h02;

/**
 * extends cloud to a High level, checks for proper altitude.
 * @author Cory Parker
 *
 */
public abstract class HighLevel extends Cloud {

  protected HighLevel(Integer altitude, CloudShape shape) {
    super(altitude, shape);
    //HighLevel throw an IllegalArgumentException if altitude <20000.
    if (altitude < 20000) {
      throw new IllegalArgumentException();
    }
  }

}
