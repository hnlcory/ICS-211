package edu.ics211.h06;


import static org.junit.jupiter.api.Assertions.assertEquals;

import edu.ics211.h02.Cloud;
import edu.ics211.h02.CloudShape;
import edu.ics211.h02.MotherNature;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class ShadingCloudTest {
  private Cloud[] theClouds;
  @BeforeEach
  void setUp() throws Exception {
    theClouds = new Cloud[7];
    MotherNature mother = MotherNature.getInstance();
    theClouds[0] = mother.formACloud(1000, CloudShape.CUMULO);
    theClouds[1] = mother.formACloud(7000, CloudShape.STRATO);
    theClouds[2] = mother.formACloud(6000, CloudShape.CUMULO);
    theClouds[3] = mother.formACloud(20000, CloudShape.CIRRO);
    theClouds[4] = mother.formACloud(12000, CloudShape.STRATO);
    theClouds[5] = mother.formACloud(11111, CloudShape.STRATO);
    theClouds[6] = mother.formACloud(11111, CloudShape.STRATO);
  }


  @Test
  void testShadingClouds() {
    ShadingCloud clouds = new ShadingCloud(theClouds);
    List<Cloud> shading1 = clouds.shadingClouds(5000);
    assertEquals(6, shading1.size());
    assertEquals(theClouds[2], shading1.get(0));
    assertEquals(theClouds[1], shading1.get(1));
    assertEquals(theClouds[5], shading1.get(2));
    assertEquals(theClouds[6], shading1.get(3));
    assertEquals(theClouds[4], shading1.get(4));
    assertEquals(theClouds[3], shading1.get(5));
  }


  @Test
  void testShadingClouds1() {
    ShadingCloud clouds = new ShadingCloud(theClouds);
    List<Cloud> shading2 = clouds.shadingClouds(10000);
    assertEquals(4, shading2.size());
    assertEquals(theClouds[5], shading2.get(0));
    assertEquals(theClouds[6], shading2.get(1));
    assertEquals(theClouds[4], shading2.get(2));
    assertEquals(theClouds[3], shading2.get(3));
  }

}
