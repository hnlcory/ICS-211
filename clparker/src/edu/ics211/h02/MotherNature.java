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
    if (altitude <= 6500) {
      if (altitude<0 || shape !=CloudShape.CUMULO) {
        throw new IllegalArgumentException();
      }
      return new Cumulus(altitude);
      //low level
    }
    
    else if (altitude > 6501 && altitude < 19999) {
      if (shape !=CloudShape.STRATO) {
        throw new IllegalArgumentException();
      }
      return new Altostratus(altitude);
      //mid level
    }
    
    else {
      if (shape !=CloudShape.STRATO && shape !=CloudShape.CIRRO) {
        throw new IllegalArgumentException();//possibly here
      }
      else if (shape ==CloudShape.STRATO) {
        return new Cirrostratus(altitude);
      }
      else {
        return new Cirrus(altitude);
      }
      //high level
    }  
  }

  @Override
  public Cloud formAHighLevelCloud(CloudShape shape) {
   //get valid alt
   //switch
    switch(shape) {
      case CIRRO:
        return new Cirrus();
        
      case STRATO:
        return new Cirrostratus();
        
      default:
        throw new IllegalArgumentException();
    }
  }

  @Override
  public Cloud formAMidLevelCloud(CloudShape shape) {
    //get valid low alt
    //switch on shape
    switch(shape) {
      //case strato
      case STRATO:
        //return new 
        return new Altostratus();
       //default throw exception
       default:
         throw new IllegalArgumentException();
    }
  }

  @Override
  public Cloud formALowLevelCloud(CloudShape shape) {
    //get valid low alt
    //switch on shape
    switch(shape) {
      //case cumulo
      case CUMULO:
        //return new 
        return new Cumulus();
       //default throw exception
       default:
         throw new IllegalArgumentException();
    }
    
  }

  
  
}
