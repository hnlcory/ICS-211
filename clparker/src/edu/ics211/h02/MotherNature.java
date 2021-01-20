/**
 * 
 */
package edu.ics211.h02;

/**
 * @author Cory Parker
 *
 */
public class MotherNature implements CloudCreator {
  private static MotherNature instance;
  
  public static MotherNature getInstance() {
    if (instance == null) {
      instance = new MotherNature();
    }
    return instance;
  }

  /**
   * 
   */
  private MotherNature() {
    // TODO Auto-generated constructor stub
  }

  @Override
  public Cloud formACloud(Integer altitude, CloudShape shape) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Cloud formAHighLevelCloud(CloudShape shape) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Cloud formAMidLevelCloud(CloudShape shape) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Cloud formALowLevelCloud(CloudShape shape) {
    // TODO Auto-generated method stub
    return null;
  }

  
  
}
