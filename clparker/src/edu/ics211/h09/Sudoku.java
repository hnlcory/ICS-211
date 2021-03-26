package edu.ics211.h09;

import java.util.ArrayList;

/**
 * Class for recursively finding a solution to a Sudoku problem.
 *
 * @author Biagioni, Edoardo, Cam Moore
 */
public class Sudoku {

  /**
   * Find an assignment of values to sudoku cells that makes the sudoku valid.
   *
   * @param sudoku to be solved
   * @return whether a solution was found if a solution was found.
   */
  public static boolean solveSudoku(int[][] sudoku) {
    // TODO: Implement this method recursively. You may use a recursive
    // helper method.

    // scan for the first empty cell
    int[] pos = findEmpty(sudoku);

    // if empty cell found
    // get legal values
    if (pos != null) {
      ArrayList<Integer> lglVals = legalValues(sudoku, pos[0], pos[1]);
      // if no legal values return false
      if (lglVals == null) {
        return false;
      }
      // else loop over legal values
      for (int i = 0; i < lglVals.size(); i++) {
        // try value sudoku[row][col]=value
        sudoku[pos[0]][pos[1]] = lglVals.get(i);
        // if solvesudoku[sudoku] returns true, return true
        if (solveSudoku(sudoku) == true) {
          return true;
        }
      }
      // if out of loop
      // set cell to 0
      // return false
      sudoku[pos[0]][pos[1]] = 0;
    }

    // if no empty cells then return checkSudoku (basecase1)
    if (pos == null) {
      return checkSudoku(sudoku, true);
    }
    return false;
  }

  /**
   * Method to find first empty spot.
   * @author Cory Parker.
   * @return row and col of spot or null.
   **/
  private static int[] findEmpty(int[][] sudoku) {
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        // if empty cell found
        // get legal values
        if (sudoku[i][j] == 0) {
          int[] res = { i, j };
          return res;
        }

      }
    }
    // int[] res= {-1,-1};
    return null;
  }


  /**
   * Find the legal values for the given sudoku and cell.
   *
   * @param sudoku, the sudoku being solved.
   * @param row the row of the cell to get values for.
   * @param col the column of the cell.
   * @return an ArrayList of the valid values.
   */
  public static ArrayList<Integer> legalValues(int[][] sudoku, int row, int column) {
    boolean valid;
    // check is sudoku [row][column] is 0
    if (sudoku[row][column] != 0) {
      return null;
    }
    // create return list
    ArrayList<Integer> returnList = new ArrayList<Integer>();

    // loop over values 1-9

    for (int i = 1; i < 10; i++) {
      valid = true;
      // check if value is in the row, if is break
      for (int j = 0; j < 9; j++) {
        if (i == sudoku[row][j]) {
          valid = false;
          break;
        }

      }
      // check if value is in column, if is break
      for (int k = 0; k < 9; k++) {
        if (i == sudoku[k][column]) {
          valid = false;
          break;
        }
      }
      // check if value is in the 3x3, if is break
      for (int l = 0; l < 3; l++) {
        for (int m = 0; m < 3; m++) {
          int testRow = (row / 3 * 3) + l;
          int testCol = (column / 3 * 3) + m;
          if (i == sudoku[testRow][testCol]) {
            valid = false;
            break;
          }
        }
      }

      // add value to return list
      if (valid == true) {
        returnList.add(i);
      }

    }

    // check size of return list, if 0 return null
    if (returnList.size() == 0) {
      return null;
    }
    return returnList;
  }


  /**
   * checks that the sudoku rules hold in this sudoku puzzle. cells that contain 0 are not checked.
   *
   * @param the sudoku to be checked
   * @param whether to print the error found, if any
   * @return true if this sudoku obeys all of the sudoku rules, otherwise false
   */
  public static boolean checkSudoku(int[][] sudoku, boolean printErrors) {
    if (sudoku.length != 9) {
      if (printErrors) {
        System.out.println("sudoku has " + sudoku.length + " rows, should have 9");
      }
      return false;
    }
    for (int i = 0; i < sudoku.length; i++) {
      if (sudoku[i].length != 9) {
        if (printErrors) {
          System.out.println("sudoku row " + i + " has " + sudoku[i].length + " cells, should have 9");
        }
        return false;
      }
    }
    /* check each cell for conflicts */
    for (int i = 0; i < sudoku.length; i++) {
      for (int j = 0; j < sudoku.length; j++) {
        int cell = sudoku[i][j];
        if (cell == 0) {
          continue; /* blanks are always OK */
        }
        if ((cell < 1) || (cell > 9)) {
          if (printErrors) {
            System.out.println("sudoku row " + i + " column " + j + " has illegal value " + cell);
          }
          return false;
        }
        /* does it match any other value in the same row? */
        for (int m = 0; m < sudoku.length; m++) {
          if ((j != m) && (cell == sudoku[i][m])) {
            if (printErrors) {
              System.out.println("sudoku row " + i + " has " + cell + " at both positions " + j + " and " + m);
            }
            return false;
          }
        }
        /* does it match any other value it in the same column? */
        for (int k = 0; k < sudoku.length; k++) {
          if ((i != k) && (cell == sudoku[k][j])) {
            if (printErrors) {
              System.out.println("sudoku column " + j + " has " + cell + " at both positions " + i + " and " + k);
            }
            return false;
          }
        }
        /* does it match any other value in the 3x3? */
        for (int k = 0; k < 3; k++) {
          for (int m = 0; m < 3; m++) {
            int testRow = (i / 3 * 3) + k; /* test this row */
            int testCol = (j / 3 * 3) + m; /* test this col */
            if ((i != testRow) && (j != testCol) && (cell == sudoku[testRow][testCol])) {
              if (printErrors) {
                System.out.println("sudoku character " + cell + " at row " + i + ", column " + j
                    + " matches character at row " + testRow + ", column " + testCol);
              }
              return false;
            }
          }
        }
      }
    }
    return true;
  }


  /**
   * Converts the sudoku to a printable string
   *
   * @param the sudoku to be converted
   * @param whether to check for errors
   * @return the printable version of the sudoku
   */
  public static String toString(int[][] sudoku, boolean debug) {
    if ((!debug) || (checkSudoku(sudoku, true))) {
      String result = "";
      for (int i = 0; i < sudoku.length; i++) {
        if (i % 3 == 0) {
          result = result + "+-------+-------+-------+\n";
        }
        for (int j = 0; j < sudoku.length; j++) {
          if (j % 3 == 0) {
            result = result + "| ";
          }
          if (sudoku[i][j] == 0) {
            result = result + "  ";
          } else {
            result = result + sudoku[i][j] + " ";
          }
        }
        result = result + "|\n";
      }
      result = result + "+-------+-------+-------+\n";
      return result;
    }
    return "illegal sudoku";
  }
}
