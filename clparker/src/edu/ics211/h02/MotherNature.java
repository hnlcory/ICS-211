/**
 * MotherNature has the ability to form clouds from user input and by levels.
 */

package edu.ics211.h02;

/**
 * Forms clouds on low, mid, and high levels.
 * Forms clouds based on input.
 * @author Cory Parker
 *
 */
public class MotherNature implements CloudCreator {
  private static MotherNature instance;
  
  /**
   * creates an instance of MotherNature if not present.
   * @return the instance of MotherNature.
   */
  public static MotherNature getInstance() {
    if (instance == null) {
      instance = new MotherNature();
    }
    return instance;
  }

  /**
   * MotherNature constructor.
   */
  private MotherNature() {
    // TODO Auto-generated constructor stub
  }

  @Override
  public Cloud formACloud(Integer altitude, CloudShape shape) {
    //check if altitude is in limit
    if (altitude <= 6500) {
      //mismatch equals exception
      if (altitude<0 || shape !=CloudShape.CUMULO) {
        throw new IllegalArgumentException();
      }
      //return cloud
      return new Cumulus(altitude);
      //low level
    }
  //check if altitude is in limit
    else if (altitude > 6501 && altitude < 19999) {
      //mismatch equals exception
      if (shape !=CloudShape.STRATO) {
        throw new IllegalArgumentException();
      }
      return new Altostratus(altitude);
      //mid level
    }
    
    else {
      //cloud must be high level
      if (shape !=CloudShape.STRATO && shape !=CloudShape.CIRRO) {
        throw new IllegalArgumentException();
      }
      //if cloud is strato, return cirrostratus
      else if (shape ==CloudShape.STRATO) {
        return new Cirrostratus(altitude);
      }
      else {
        //must be cirrus 
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
