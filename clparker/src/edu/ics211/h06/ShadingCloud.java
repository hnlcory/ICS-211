/**
 * 
 */
package edu.ics211.h06;

import edu.ics211.h02.AltitudeComparator;
import java.util.List;
import java.util.Arrays;
import java.util.Iterator;

import edu.ics211.h02.Cloud;

/**
 * @author Cory Parker
 *
 */
public class ShadingCloud implements ICloudShading {
  public Cloud[] cList;

  /**
   * Creates a list of clouds not shaded.
   * 
   * @author Cory Parker.
   */
  public ShadingCloud(Cloud[] clouds) {
    cList = Arrays.copyOf(clouds, clouds.length);
    // store the clouds
  }


  @Override
  public List<Cloud> shadingClouds(int startAltitude) {

    SortableList<Cloud> tempList = new SortableList<Cloud>();
    SortableList<Cloud> returnList = new SortableList<Cloud>();

    // create sortablelist<cloud>
    // create the returnList

    // add clouds to it
    for (int i = 0; i < cList.length; i++) {
      tempList.add(cList[i]);
    }

    Iterator<Cloud> i1 = tempList.iterator(new AltitudeComparator());
    // get iterator(new AltitiudeComparator()) ?

    while (i1.hasNext()) {
      Cloud tempCloud = i1.next();
      if (tempCloud.getAltitude() >= startAltitude) {
        returnList.add(tempCloud);
      }
    }

    // while(iterator.hasnext())
    // cloud = iterator.next
    // get cloud
    // if cloud.getAltitude is greater than or equal to startAltitude, add cloud to returnList

    // return returnList
    return returnList;
  }

}
