/**
 * 
 */
package edu.ics211.h02;

/**
 * Represents a CLoud
 * @author Cory Parker
 *
 */
public abstract class Cloud {
  private Integer altitude;
  private CloudShape shape;

  
  /**
   * Creates a new cloud
   * @param altitude 
   * @param shape
   */
  protected Cloud(Integer altitude, CloudShape shape) {
    this.altitude =altitude;
    this.shape=shape;
  }
  
  /**
   * Returns altitude
   * @return
   */
  public Integer getAltitude() {
    return this.altitude;
  }
  
  /**
   * Returns cloud shape
   * @return
   */
  public CloudShape getCloudShape() {
    return this.shape;
  }
  
  /**
   * Sets Altitude
   * @param altitude
   */
  public void setAltitude(Integer altitude) {
    this.altitude = altitude;
  }
  
  /**
   * Sets Cloud Shape
   * @param shape
   */
  public void setCloudShape(CloudShape shape) {
    this.shape = shape;
  }
  
}
