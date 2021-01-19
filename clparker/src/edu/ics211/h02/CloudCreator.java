package edu.ics211.h02;

/**
 * Represents a CloudCreator.
 *
 * @author Cam Moore
 *
 */
public interface CloudCreator {
  /**
   * Forms a cloud.
   *
   * @param altitude the altitude.
   * @param shape the shape.
   * @return a new Cloud.
   */
  Cloud formACloud(Integer altitude, CloudShape shape);


  /**
   * Forms a high level cloud.
   *
   * @param shape the shape.
   * @return a high level cloud.
   */
  Cloud formAHighLevelCloud(CloudShape shape);


  /**
   * Forms a mid level cloud.
   *
   * @param shape the shape.
   * @return a mid level cloud.
   */
  Cloud formAMidLevelCloud(CloudShape shape);


  /**
   * Forms a low level cloud.
   *
   * @param shape the shape.
   * @return a low level cloud.
   */
  Cloud formALowLevelCloud(CloudShape shape);
}
