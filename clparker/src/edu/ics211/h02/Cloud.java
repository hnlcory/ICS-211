/**
 * Cloud which holds shape and altitude.
 * @author Cory Parker
 */

package edu.ics211.h02;

/**
 * Represents a Cloud.
 * @author Cory Parker
 *
 */
public abstract class Cloud {
  private Integer altitude;
  private CloudShape shape;

  
  /**
   * Creates a new cloud.
   * @param altitude user input
   * @param shape user input
   */
  protected Cloud(Integer altitude, CloudShape shape) {
    this.altitude =altitude;
    this.shape=shape;
  }
  
  /**
   * Returns altitude.
   * @return altitude
   */
  public Integer getAltitude() {
    return this.altitude;
  }
  
  /**
   * Returns cloud shape.
   * @return shape
   */
  public CloudShape getShape() {
    return this.shape;
  }
  
  /**
   * Sets Altitude.
   * @param altitude sets altitude.
   */
  public void setAltitude(Integer altitude) {
    this.altitude = altitude;
  }
  
  /**
   * Sets Cloud Shape.
   * @param shape to set shape
   */
  public void setShape(CloudShape shape) {
    this.shape = shape;
  }
  
}
