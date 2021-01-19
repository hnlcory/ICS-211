package edu.ics211.h02;

import java.util.Random;

/**
 * Represents a CloudShape.
 *
 * @author Cam Moore
 *
 */
public enum CloudShape {
  CIRRO, CUMULO, STRATO;

  /**
   * Returns a random CloudShape.
   *
   * @return a random CloudShape.
   */
  public static CloudShape getRandomShape() {
    Random rand = new Random();
    return values()[rand.nextInt(values().length)];
  }
}
