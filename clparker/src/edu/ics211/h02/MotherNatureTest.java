package edu.ics211.h02;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.jupiter.api.Test;

/**
 * Represents a MotherNatureTest.
 *
 * @author Cam Moore
 *
 */
class MotherNatureTest {

  /**
   * Test method for {@link edu.ics211.h02.MotherNature#getInstance()}.
   */
  @Test
  void testGetInstance() {
    MotherNature mother1 = MotherNature.getInstance();
    assertNotNull("Failed to get the singleton.", mother1);
    MotherNature mother2 = MotherNature.getInstance();
    assertEquals("The singletons aren't the same.", mother1, mother2);
  }


  /**
   * Test method for
   * {@link edu.ics211.h02.MotherNature#formACloud(Integer, edu.ics211.h02.CloudShape)}.
   */
  @Test
  void testFormACloud() {
    MotherNature mother = MotherNature.getInstance();
    // test some good values
    Integer altitude = 6000;
    CloudShape shape = CloudShape.CUMULO;
    Cloud cloud = mother.formACloud(altitude, shape);
    assertNotNull("Didn't create the cloud.", cloud);
    assertTrue("Got the wrong type of cloud.", cloud instanceof Cumulus);
    assertEquals("Got the wrong altitude", altitude, cloud.getAltitude());
    assertEquals("Got the wrong shape", shape, cloud.getShape());
    altitude = 10000;
    shape = CloudShape.STRATO;
    cloud = mother.formACloud(altitude, shape);
    assertNotNull("Didn't create the cloud.", cloud);
    assertTrue("Got the wrong type of cloud.", cloud instanceof Altostratus);
    assertEquals("Got the wrong altitude", altitude, cloud.getAltitude());
    assertEquals("Got the wrong shape", shape, cloud.getShape());
    altitude = 25000;
    cloud = mother.formACloud(altitude, shape);
    assertNotNull("Didn't create the cloud.", cloud);
    assertTrue("Got the wrong type of cloud.", cloud instanceof Cirrostratus);
    assertEquals("Got the wrong altitude", altitude, cloud.getAltitude());
    assertEquals("Got the wrong shape", shape, cloud.getShape());
    altitude = 26000;
    shape = CloudShape.CIRRO;
    cloud = mother.formACloud(altitude, shape);
    assertNotNull("Didn't create the cloud.", cloud);
    assertTrue("Got the wrong type of cloud.", cloud instanceof Cirrus);
    assertEquals("Got the wrong altitude", altitude, cloud.getAltitude());
    assertEquals("Got the wrong shape", shape, cloud.getShape());
    // test some bad values
    try {
      altitude = 5000;
      cloud = mother.formACloud(altitude, shape);
      fail("Shouldn't have created a cloud");
    } catch (IllegalArgumentException iae) {
      // this is what is supposed to happen
    }
    try {
      altitude = 7000;
      cloud = mother.formACloud(altitude, shape);
      fail("Shouldn't have created a cloud");
    } catch (IllegalArgumentException iae) {
      // this is what is supposed to happen
    }
    try {
      altitude = 37000;
      shape = CloudShape.CUMULO;
      cloud = mother.formACloud(altitude, shape);
      fail("Shouldn't have created a cloud");
    } catch (IllegalArgumentException iae) {
      // this is what is supposed to happen
    }
  }


  /**
   * Test method for
   * {@link edu.ics211.h02.MotherNature#formAHighLevelCloud(edu.ics211.h02.CloudShape)}.
   */
  @Test
  void testFormAHighLevelCloud() {
    MotherNature mother = MotherNature.getInstance();
    // test some good values
    CloudShape shape = CloudShape.CIRRO;
    Cloud cloud = mother.formAHighLevelCloud(shape);
    assertNotNull("Didn't create the cloud.", cloud);
    assertEquals("Got the wrong shape", shape, cloud.getShape());
    Integer altitude = cloud.getAltitude();
    assertTrue("Got the wrong altitude", altitude > 20000);
    shape = CloudShape.STRATO;
    cloud = mother.formAHighLevelCloud(shape);
    assertNotNull("Didn't create the cloud.", cloud);
    assertEquals("Got the wrong shape", shape, cloud.getShape());
    altitude = cloud.getAltitude();
    assertTrue("Got the wrong altitude", altitude > 20000);
    // test some bad values
    try {
      shape = CloudShape.CUMULO;
      cloud = mother.formAHighLevelCloud(shape);
      fail("Shouldn't have created a cloud");
    } catch (IllegalArgumentException iae) {
      // this should happen
    }
  }


  /**
   * Test method for
   * {@link edu.ics211.h02.MotherNature#formAMidLevelCloud(edu.ics211.h02.CloudShape)}.
   */
  @Test
  void testFormAMidLevelCloud() {
    MotherNature mother = MotherNature.getInstance();
    // test some good values
    CloudShape shape = CloudShape.STRATO;
    Cloud cloud = mother.formAMidLevelCloud(shape);
    assertNotNull("Didn't create the cloud.", cloud);
    assertEquals("Got the wrong shape", shape, cloud.getShape());
    Integer altitude = cloud.getAltitude();
    System.out.println(altitude);
    assertTrue("Got wrong altitude", altitude > 6500 && altitude <= 20000);
    // test some bad values
    try {
      shape = CloudShape.CUMULO;
      cloud = mother.formAMidLevelCloud(shape);
      fail("Shouldn't have created a cloud");
    } catch (IllegalArgumentException iae) {
      // this is what should happen
    }
    try {
      shape = CloudShape.CIRRO;
      cloud = mother.formAMidLevelCloud(shape);
      fail("Shouldn't have created a cloud");
    } catch (IllegalArgumentException iae) {
      // this is what should happen
    }
  }


  /**
   * Test method for
   * {@link edu.ics211.h02.MotherNature#formALowLevelCloud(edu.ics211.h02.CloudShape)}.
   */
  @Test
  void testFormALowLevelCloud() {
    MotherNature mother = MotherNature.getInstance();
    // test some good values
    CloudShape shape = CloudShape.CUMULO;
    Cloud cloud = mother.formALowLevelCloud(shape);
    assertNotNull("Didn't create the cloud.", cloud);
    assertEquals("Got the wrong shape", shape, cloud.getShape());
    Integer altitude = cloud.getAltitude();
    System.out.println(altitude);
    assertTrue("Got wrong altitude", altitude <= 6500);
    // test some bad values
    try {
      shape = CloudShape.STRATO;
      cloud = mother.formALowLevelCloud(shape);
      fail("Shouldn't have created a cloud");
    } catch (IllegalArgumentException iae) {
      // this is what should happen
    }
    try {
      shape = CloudShape.CIRRO;
      cloud = mother.formALowLevelCloud(shape);
      fail("Shouldn't have created a cloud");
    } catch (IllegalArgumentException iae) {
      // this is what should happen
    }
  }

}
