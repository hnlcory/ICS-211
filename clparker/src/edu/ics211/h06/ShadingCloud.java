/**
 * 
 */
package edu.ics211.h06;

import java.util.List;

import edu.ics211.h02.Cloud;

/**
 * @author Cory Parker
 *
 */
public class ShadingCloud implements ICloudShading {
  public SortableList<Cloud> cList;
  
  
  /**
   * Creates a new shadingcloud.
   * @author Cory Parket.
   */
  public ShadingCloud(Cloud[] clouds) {
    cList = new SortableList<Cloud>();
   for(Cloud c: clouds) {
     cList.add(c);// adds clouds to it
   }
    // store the clouds
  }

  // comparator
  public int compare(Cloud o1, Cloud o2) {
    if (o1.getAltitude() < o2.getAltitude()) {
      return -1;
    }
    else {
      return o1.getAltitude() - o2.getAltitude();
    }
  }
  

  @Override
  public List<Cloud> shadingClouds(int startAltitude) {
    
    SortableList<Cloud> returnList = new SortableList<Cloud>();
  
    
    //create sortablelist<cloud>
    //create the returnList
    
    //add clouds to it
    
    
    //get iterator(new AltitiudeComparator())  ?
    
    //while(iterator.hasnext())
    //  cloud = iterator.next
    //  get cloud
    //if cloud.getAltitude is greater than or equal to startAltitude, add cloud to returnList
    
    
    //return returnList
    return null;
  }

}
