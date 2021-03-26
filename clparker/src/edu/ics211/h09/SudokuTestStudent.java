package edu.ics211.h09;

/**
 * Test a Sudoku solver.
 * 
 * @author Biagioni Edoardo, Cam Moore, and Cory Parker
 */
public class SudokuTestStudent {

  /**
   * Checks the sudoku returning true if all cells are filled. Does not check validity.
   * 
   * @return true if all cells are filled, false otherwise.
   */
  private static boolean isFilled(int[][] sudoku) {
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        if (sudoku[i][j] == 0) {
          return false;
        }
      }
    }
    return true;
  }


  /**
   * Test whether two sudoku are equal.
   * 
   * @param the sudoku to be checked
   * @param the solution checked
   * @return null if the two match, and otherwise a sudoku with 0 in every cell that differs.
   */
  private static int[][] sameSudoku(int[][] sudoku, int[][] solution) {
    int[][] result = new int[9][9];
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        result[i][j] = sudoku[i][j];
      }
    }
    boolean same = true;
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        if (result[i][j] != solution[i][j]) {
          same = false;
          result[i][j] = 0;
        }
      }
    }
    if (same) {
      return null;
    }
    return result;
  }


  /**
   * Try to solve a sudoku.
   * 
   * @param the name of this sudoku
   * @param the sudoku to be solved
   * @param the given solution, or null
   */
  private static void testSudoku(String name, int[][] sudoku, int[][] solution) {
    System.out.println("solving " + name + "\n" + Sudoku.toString(sudoku, true));
    if (Sudoku.solveSudoku(sudoku)) {
      if (isFilled(sudoku) && Sudoku.checkSudoku(sudoku, true)) {
        System.out.println("success!\n" + Sudoku.toString(sudoku, true));
        if (solution != null) {
          int[][] diff = sameSudoku(sudoku, solution);
          if (diff != null) {
            System.out.println("given solution:\n" + Sudoku.toString(solution, true));
            System.out.println("difference between solutions:\n" + Sudoku.toString(diff, true));
          }
        }
      } else { /* the supposed solution is not a complete or valid sudoku */
        if (!isFilled(sudoku)) {
          System.out.println("not completely filled:\n" + Sudoku.toString(sudoku, false));
        }
        if (!Sudoku.checkSudoku(sudoku, false)) {
          System.out.println("not a valid solution:\n" + Sudoku.toString(sudoku, false));
        }
      }
    } else {
      System.out.println("unable to complete" + name + "\n" + Sudoku.toString(sudoku, true));
    }
  }


  /**
   * Main for testing sudoku puzzles.
   * 
   * @author Cory Parker
   * @param arg arguments
   */
  public static void main(String[] arg) {
    int[][] tst1missing = { { 0, 8, 3, 4, 9, 6, 1, 2, 5 }, { 1, 2, 5, 7, 3, 8, 9, 6, 4 },
        { 4, 6, 9, 2, 5, 1, 7, 3, 8 }, { 2, 3, 6, 1, 8, 5, 4, 7, 9 }, 
        { 5, 1, 4, 6, 7, 9, 3, 8, 2 }, { 9, 7, 8, 3, 4, 2, 5, 1, 6 },
        { 8, 5, 7, 9, 6, 3, 2, 4, 1 }, { 6, 4, 1, 5, 2, 7, 8, 9, 3 }, 
        { 3, 9, 2, 8, 1, 4, 6, 5, 7 } };

    int[][] sol1missing = { { 7, 8, 3, 4, 9, 6, 1, 2, 5 }, { 1, 2, 5, 7, 3, 8, 9, 6, 4 },
        { 4, 6, 9, 2, 5, 1, 7, 3, 8 }, { 2, 3, 6, 1, 8, 5, 4, 7, 9 },
        { 5, 1, 4, 6, 7, 9, 3, 8, 2 }, { 9, 7, 8, 3, 4, 2, 5, 1, 6 }, 
        { 8, 5, 7, 9, 6, 3, 2, 4, 1 }, { 6, 4, 1, 5, 2, 7, 8, 9, 3 },
        { 3, 9, 2, 8, 1, 4, 6, 5, 7 } };

    testSudoku("1 number missing", tst1missing, sol1missing);
    
    int[][] tstBlank = { { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
        { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
        { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
        { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
        { 0, 0, 0, 0, 0, 0, 0, 0, 0 } };

    int[][] solBlank = { { 1, 2, 3, 4, 5, 6, 7, 8, 9 }, { 4, 5, 6, 7, 8, 9, 1, 2, 3 },
        { 7, 8, 9, 1, 2, 3, 4, 5, 6 }, { 2, 1, 4, 3, 6, 5, 8, 9, 7 }, 
        { 3, 6, 5, 8, 9, 7, 2, 1, 4 }, { 8, 9, 7, 2, 1, 4, 3, 6, 5 },
        { 5, 3, 1, 6, 4, 2, 9, 7, 8 }, { 6, 4, 2, 9, 7, 8, 5, 3, 1 }, 
        { 9, 7, 8, 5, 3, 1, 6, 4, 2 } };
    
    // test with fully blank
    testSudoku("fully blank", tstBlank, solBlank);

    int[][] tstAlreadyFilled = { { 7, 8, 3, 4, 9, 6, 1, 2, 5 }, { 1, 2, 5, 7, 3, 8, 9, 6, 4 },
        { 4, 6, 9, 2, 5, 1, 7, 3, 8 }, { 2, 3, 6, 1, 8, 5, 4, 7, 9 }, 
        { 5, 1, 4, 6, 7, 9, 3, 8, 2 }, { 9, 7, 8, 3, 4, 2, 5, 1, 6 },
        { 8, 5, 7, 9, 6, 3, 2, 4, 1 }, { 6, 4, 1, 5, 2, 7, 8, 9, 3 }, 
        { 3, 9, 2, 8, 1, 4, 6, 5, 7 } };

    int[][] solAlreadyFilled = { { 7, 8, 3, 4, 9, 6, 1, 2, 5 }, { 1, 2, 5, 7, 3, 8, 9, 6, 4 }, 
        { 4, 6, 9, 2, 5, 1, 7, 3, 8 }, { 2, 3, 6, 1, 8, 5, 4, 7, 9 }, 
        { 5, 1, 4, 6, 7, 9, 3, 8, 2 }, { 9, 7, 8, 3, 4, 2, 5, 1, 6 },
        { 8, 5, 7, 9, 6, 3, 2, 4, 1 }, { 6, 4, 1, 5, 2, 7, 8, 9, 3 }, 
        { 3, 9, 2, 8, 1, 4, 6, 5, 7 } };
    
    // test done problem
    testSudoku("already finished problem", tstAlreadyFilled, solAlreadyFilled);

    int[][] tstNoSolution = { { 7, 8, 3, 4, 9, 6, 1, 2, 5 }, { 1, 2, 5, 7, 3, 8, 9, 6, 4 },
        { 4, 6, 9, 2, 5, 1, 7, 3, 8 }, { 2, 3, 6, 1, 8, 5, 4, 7, 9 },
        { 5, 1, 8, 6, 7, 6, 3, 8, 2 }, { 9, 7, 8, 3, 4, 2, 5, 1, 6 },
        { 8, 5, 7, 9, 6, 3, 2, 4, 1 }, { 6, 4, 1, 5, 2, 7, 8, 9, 3 }, 
        { 3, 9, 2, 8, 5, 4, 6, 5, 7 } };
    
    // test with a broken
    testSudoku("broken solution, --SHOULD FAIL--", tstNoSolution, null);

    int[][] tstRegular = { { 0, 6, 0, 9, 0, 8, 0, 1, 0 }, { 0, 0, 4, 0, 0, 0, 0, 0, 0 },
        { 8, 0, 3, 0, 0, 0, 4, 5, 0 }, { 2, 0, 0, 0, 6, 0, 0, 0, 8 }, 
        { 9, 0, 0, 0, 0, 0, 0, 0, 4 }, { 5, 0, 0, 0, 7, 0, 0, 0, 2 },
        { 0, 7, 8, 0, 0, 0, 9, 0, 5 }, { 0, 0, 0, 0, 0, 0, 6, 0, 0 },
        { 0, 1, 0, 3, 0, 2, 0, 4, 0 } };

    int[][] solRegular = { { 7, 6, 5, 9, 4, 8, 2, 1, 3 }, { 1, 2, 4, 5, 3, 6, 7, 8, 9 },
        { 8, 9, 3, 7, 2, 1, 4, 5, 6 }, { 2, 4, 7, 1, 6, 3, 5, 9, 8 },
        { 9, 3, 6, 2, 8, 5, 1, 7, 4 }, { 5, 8, 1, 4, 7, 9, 3, 6, 2 },
        { 3, 7, 8, 6, 1, 4, 9, 2, 5 }, { 4, 5, 2, 8, 9, 7, 6, 3, 1 },
        { 6, 1, 9, 3, 5, 2, 8, 4, 7 } };

    // test regular problems
    long startTime1 = System.nanoTime();
    testSudoku("regular problem", tstRegular, solRegular);
    long endTime1 = System.nanoTime();
    System.out.println(endTime1 - startTime1 + " nano sec\n");
    
    /* AI Escargot */
    int[][] tstAI = { { 1, 0, 0, 0, 0, 7, 0, 9, 0 }, { 0, 3, 0, 0, 2, 0, 0, 0, 8 },
        { 0, 0, 9, 6, 0, 0, 5, 0, 0 }, { 0, 0, 5, 3, 0, 0, 9, 0, 0 },
        { 0, 1, 0, 0, 8, 0, 0, 0, 2 }, { 6, 0, 0, 0, 0, 4, 0, 0, 0 },
        { 3, 0, 0, 0, 0, 0, 0, 1, 0 }, { 0, 4, 0, 0, 0, 0, 0, 0, 7 }, 
        { 0, 0, 7, 0, 0, 0, 3, 0, 0 } };

    // testing the AI problem
    long startTime2 = System.nanoTime();
    testSudoku("AI Escargot", tstAI, null);
    long endTime2 = System.nanoTime();
    System.out.println(endTime2 - startTime2 + " nano sec\n");
  }
}
