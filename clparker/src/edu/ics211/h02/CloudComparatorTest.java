package edu.ics211.h02;


import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CloudComparatorTest {
  private MotherNature mother;
  
  @BeforeEach
  void setUp() throws Exception {
    mother = MotherNature.getInstance();
  }
  
  @Test
  void testAltitudeComparator() {
    AltitudeComparator alt = new AltitudeComparator();
    Cloud cumulus = mother.formACloud(500, CloudShape.CUMULO);
    Cloud cirrus = mother.formACloud(21000, CloudShape.CIRRO);
    assertTrue(alt.compare(cumulus, cirrus) < 0);
    assertTrue(alt.compare(cumulus, cumulus) == 0);
    assertTrue(alt.compare(cirrus, cumulus) > 0);
  }

  @Test
  void testShapeComparator() {
    ShapeComparator shape = new ShapeComparator();
    Cloud cumulus = mother.formACloud(500, CloudShape.CUMULO);
    Cloud cirrus = mother.formACloud(21000, CloudShape.CIRRO);
    Cloud stratus = mother.formACloud(15000, CloudShape.STRATO);
    assertTrue(shape.compare(cumulus, cirrus) > 0);
    assertTrue(shape.compare(cumulus, cumulus) == 0);
    assertTrue(shape.compare(stratus, cirrus) > 0);
    assertTrue(shape.compare(cirrus, cumulus) < 0);
    assertTrue(shape.compare(cirrus, stratus) < 0);
  }
}
