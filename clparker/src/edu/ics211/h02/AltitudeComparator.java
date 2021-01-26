/**
 * 
 */
package edu.ics211.h02;

import java.util.Comparator;

/**
 * @author Cory Parker
 *
 */
public class AltitudeComparator implements Comparator<Cloud> {

  /**
   * 
   */
  public AltitudeComparator() {
    // TODO Auto-generated constructor stub
  }


  @Override
  public int compare(Cloud o1, Cloud o2) {
    if (o1.getAltitude() < o2.getAltitude()) {
      return -1;
    }
    else {
      return o1.getAltitude() - o2.getAltitude();
    }
    
    //if o1<02,return negative int
    //return 01.getaltittude - o2.getaltitude
    
  }

}
