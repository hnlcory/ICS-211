/**
 * 
 */
package edu.ics211.h02;

/**
 * @author Cory Parker
 *
 */
public abstract class LowLevel extends Cloud {

 
 // protected Integer altitude; - possibly redundant
 // protected CloudShape shape;
   
  protected LowLevel(Integer altitude, CloudShape shape) {
    super(altitude, shape);
    if (altitude > 6500) {
      throw new IllegalArgumentException();
    }
    //LowLevel throw an IllegalArgumentException if altitude > 6,500.
  }

}
