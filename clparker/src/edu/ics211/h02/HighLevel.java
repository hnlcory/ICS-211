/**
 * 
 */
package edu.ics211.h02;

/**
 * @author Cory Parker
 *
 */
public abstract class HighLevel extends Cloud {

  protected HighLevel(Integer altitude, CloudShape shape) {
    super(altitude, shape);
    if (altitude < 20000) {
      throw new IllegalArgumentException();
    }
  }

}
