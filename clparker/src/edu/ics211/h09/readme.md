ICS 211 Homework H09: Recursive Sudoku Solver
Purpose
Recursion is a very powerful problem solving technique. For this homework assignment we are going to use recursion to solve Sudoku problems. This assignment should give you more practice with Eclipse and using recursion to solve problems.

Tasks
1. Create a package named edu.ics211.h09
This is where we will put all our classes for homework 09.

2. Implement a recursive Sudoku solver.
In this assignment, you implement a recursive method to find a solution to a given Sudoku problem.

A Sudoku is a 9x9 grid of integers, each with values 1..9.

A Sudoku is valid when each of the 9 rows, each of the 9 columns, and each of the 9 3x3 boxes in the grid has exactly one each of the possible values 0..F, without any duplicates.

A Sudoku problem is a Sudoku grid with some of the grid cells already filled. The solution fills the remaining cells to give a valid Sudoku.

A recursive strategy for finding a solution to a Sudoku problem is as follows:

If all cells are filled, see if this Sudoku is valid. If it is valid, we have found a solution. If not, this Sudoku is not a solution. Base case 1

If at least one cell is not filled, see what values are legal for this cell:

If no values are legal, then this Sudoku is not a solution. Base case 2

If one or more values are legal, place each legal values in the cell in turn, one at a time. For each legal value, recursively attempt to find a solution that fills the remaining empty cells.

If a solution is found for at least one legal value, set the Sudoku to reflect this solution, and return that a solution was found.

If no solution is found for any legal value, reset this cell to the value it had when this method was called, and report that this Sudoku does not have a solution.

Every time the code recursively attempts to find a solution, it will fill cells in the Sudoku grid. If the attempt is not successful, returning, your code must restore the Sudoku grid to the values had before the call.

This algorithm is an example of backtracking: at any point in the search, try any one of the available options. If that option doesn’t work, return to that point, and try a different option, until all the available options have been tried.

Most of the code you will need has been provided at Sudoku.java and SudokuTest.java. In particular, the method checkSudoku returns true if a Sudoku is valid, and false otherwise (it can also print where a Sudoku is invalid). The method toString will convert a Sudoku to a printable form, again with an option to check the validity of the Sudoku and provide more information.

SudokuTest.java also provides some test Sudoku with solutions.

All this code assumes that a Sudoku is represented as a 9-element array of rows, where each row is a 9-element array of ints. Each of the ints must have a value in 1..9. The value 0 represents an empty cell.

You must implement the at least two methods:

public static boolean solveSudoku (int [] [] sudoku) This method recursively fills all the empty Sudoku cells with values in 1..9. Your method should return true if a solution exists, and return false otherwise. If the method returns true, it must fill in the Sudoku with a valid solution. If it returns false, it must leave the Sudoku unchanged.

public static ArrayList<Integer> legalValues(int [] [] sudoku, int row, int column) This method should return an ArrayList of all the legal values for the given cell. If the cell is not empty the method should return null. You must use this method in your recursive solution. If there are no valid values then the ArrayList should be empty. You can use DecimalLegalValuesTest.java to help you get your legalValues method working.

Your solution must be recursive. You may want to write a recursive helper method rather than making the solveSudoku method recursive, but this choice is up to you.

Your solveSudoku code must use a for loop to test each of the legal values for one cell. The values must come from the legalValues method. Your solution must use recursion to try to find values for all the other empty cells.

Note that checkSudoku doesn’t verify that all cells are filled – it just verifies that none of the Sudoku rules are broken.

Also note that people do not generally use backtracking to solve Sudoku. There are Sudoku problems that are difficult for humans to solve, but easy for recursive algorithms to solve.

Testing
You must also build your own test code to make sure that your implementation works. Turn in your test code together with the Sudoku class with the implemented solveSudoku and legalValues methods.

Please thoroughly test your code and briefly discuss your testing strategy. Turn in all test code.

Discussion
When your algorithm attempts to solve example3 you might notice some issues. Please write a short discussion of what the issues are with solving these examples (2 - 3 paragraphs). Turn in your discussion with your code.

Grading Rubric
Criterion	Excellent (100%)	Satisfactory (75%)	Borderline (50%)	Unsatisfactory (25%)	Poor (0)
Adherence to standards - 2 points
Does it conform to standards in every detail?	No errors.	Minor details of the assignment are violated, or poor choices are made where the assignment is unclear.	Significant details of the assignment or the underlying program intent are violated, but the program still fulfills essential functions.	Significant details of the assignment or the underlying program intent are violated, but the program still fulfills some essential functions.	Misses the point of the assignment.
Breakdown (modular design) - 1 point
Does it demonstrate good modular design?	No errors.	1-3 minor errors.	> 3 minor errors OR 1 major error.	2 major errors	> 2 major error.
Correctness of code - 4 points
Does it work? Does it pass JUnit?	Passes all tests.	Works for typical input, may fail for minor special cases.	Fails for typical input, for a minor reason.	Fails for typical input, for a major reason.	No.
Documentation, and style - 2 points
Is it clear and maintainable? Does it pass CheckStyle? Are your steps documented?	No errors.	1-3 minor errors.	> 3 minor errors OR 1 major error.	2 major errors	> 2 major error.
Efficiency of code - 1 point
Does it use the Java features well?	No errors.	1-3 minor errors.	> 3 minor errors OR 1 major error.	2 major errors	> 2 major error.
Turning in the Assignment
The assignment is due on Friday at 11:55pm. You may turn it in early.

Does your code follow the Java Coding Standard and pass CheckStyle?
Does your code solve the Sudoku problems and your own tests?
Export your project following the instructions at the bottom of the page. Name the file H09.zip
Sign into Laulima, then navigate to the ICS211 site. In the left hand side of the site, there is an Assignments tab/link. Click on it and view all of the posted assignments. Select the assignment that you want to turn in and attach your H09.zip file accept the honor pledge to submit the assignment.
