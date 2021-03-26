/**
 * Tester for legalvalues method.
 * @author Cory Parker.
 * 
 */

package edu.ics211.h09;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;

/**
 * legalValues sudoku tester.
 * 
 * @author Cory Parker.
 *
 */
class LegalValuesTestStudent {

  /**
   * Test method for {@link edu.ics211.h09.Sudoku#legalValues(int[][], int, int)}.
   */
  @Test
  void testLegalValues() {
    ArrayList<Integer> intArray = new ArrayList<Integer>();
    intArray.add(7);

    int[][] test = { { 0, 8, 3, 4, 9, 6, 1, 2, 5 }, { 1, 2, 5, 7, 3, 8, 9, 6, 4 },
        { 4, 6, 9, 2, 5, 1, 7, 3, 8 }, { 2, 3, 6, 1, 8, 5, 4, 7, 9 },
        { 5, 1, 4, 6, 7, 9, 3, 8, 2 }, { 9, 7, 8, 3, 4, 2, 5, 1, 6 },
        { 8, 5, 7, 9, 6, 3, 2, 4, 1 }, { 6, 4, 1, 5, 2, 7, 8, 9, 3 }, 
        { 3, 9, 2, 8, 1, 4, 6, 5, 7 } };
    // test for legal number
    ArrayList<Integer> legal = Sudoku.legalValues(test, 0, 0);
    assertEquals(legal.get(0), intArray.get(0));

    test[0][0] = 7;
    // new legal test for no legal numbers
    ArrayList<Integer> legalNew = Sudoku.legalValues(test, 0, 0);
    assertTrue(legalNew == null);
  }

}
