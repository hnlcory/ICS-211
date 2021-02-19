package edu.ics211.h06;

import edu.ics211.h02.Cloud;
import java.util.List;


/**
 * Represents a ICloudShading.
 *
 * @author Cam Moore
 *
 */
public interface ICloudShading {

  /**
   * Returns a List of the clouds in order of decreasing altitude. This method doesn't destroy the list of clouds.
   * 
   * @param startAltitude ignore any clouds below this altitude If false the clouds are returned starting from higher
   * altitudes then moving on to lower clouds.
   * @return A List of Clouds in the order they can shade each other.
   */
  List<Cloud> shadingClouds(int startAltitude);
}
