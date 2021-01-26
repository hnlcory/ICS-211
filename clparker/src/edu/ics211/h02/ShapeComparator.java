/**
 * 
 */
package edu.ics211.h02;

import java.util.Comparator;

/**
 * @author Cory Parker
 *
 */
public class ShapeComparator implements Comparator<Cloud> {

  /**
   * 
   */
  public ShapeComparator() {
    // TODO Auto-generated constructor stub
  }


  @Override
  public int compare(Cloud o1, Cloud o2) {
    return o1.getShape().compareTo(o2.getShape());
    //compare 01.getshape and 02.getshape
    // return 01.getshape().compareTo(02.getshape())
   
  }

}
