/**
 * 
 */
package edu.ics211.h04;

import java.util.Comparator;

/**
 * @author Cory Parker
 *
 */
public class IntegerComparator implements Comparator<Integer> {

  @Override
  public int compare(Integer o1, Integer o2) {
   return o1-o2;
  }

}
