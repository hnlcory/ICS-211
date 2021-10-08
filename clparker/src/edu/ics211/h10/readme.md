ICS 211 Homework H10: Sort by using a Binary Search Tree
Purpose
Our next abstract data structure is the Binary Tree. For this homework assignment we are going to implement a Binary Search Tree to sort Contacts. This assignment should give you more practice with Eclipse and using a tree to store and sort information.

Section 6.5 Binary Search Trees has a very good write-up of Binary Search Trees with code. Remember to give credit if you use the source code from the textbook.

Tasks
1. Create a package named edu.ics211.h10
This is where we will put all our classes for homework 10.

In this assignment you will implement a BinarySearchTree class and use it to sort Clouds.

2. Create a BinarySearchTree class that implements the SearchTree and InOrder interfaces
The BinarySearchTree must:

implement the SearchTree and InOrder interfaces,
use a Comparator to decide order,
public interface SearchTree<E> {
  /**
   * Inserts item into where it belongs in the tree.
   * @return true if item is inserted, false if item is already in tree.
   */
  boolean add(E item);
  /**
   * @return true if item is in the tree, false otherwise.
   */
  boolean contains(E item);
  /**
   * @return a reference to the target if found, null if target isn't in the tree.
   */
  E find(E target);
  /**
   * Removes target from the tree.
   * @return a reference to the target if found, null if target isn't in the tree.
   */
  E delete(E target);
  /**
   * Removes target from the tree.
   * @return true if target was in the tree, false otherwise.
   */
  boolean remove(E target);
}

public interface InOrder<E> {
  /**
   * Returns the items in sorted order.
   * @return The items in sorted order.
   */
  List<E> inorder();
}
public class BinarySearchTree<E> implements SearchTree<E>, InOrder<E> {
  private Comparator<E> comp;

  /**
   * Creates a new BinarySearchTree.
   * @param c the comparator to use for determining order.
   */
  public BinarySearchTree(Comparator<E> c) {
    ...
  }
  ...
}
Your BinarySearchTree needs to pass BinarySearchTreeTest.

4. Write up an Algorithm Analysis
Write up a runtime analysis of each of the use of a Binary Search Tree to sort, giving the big-O for sorting, and explaining how you got your results. Send your analysis to the TA together with your code. This part counts for 25% of the grade on this assignment. Even if your code doesn’t work, you should do this part to the best of your ability.

Testing
You must also build your own test code to make sure that your implementation works.

Please thoroughly test your code and briefly discuss your testing strategy. Turn in all test code.

Grading Rubric
Criterion	Excellent (100%)	Satisfactory (75%)	Borderline (50%)	Unsatisfactory (25%)	Poor (0)
Adherence to standards - 2 points
Does it conform to standards in every detail?	No errors.	Minor details of the assignment are violated, or poor choices are made where the assignment is unclear.	Significant details of the assignment or the underlying program intent are violated, but the program still fulfills essential functions.	Significant details of the assignment or the underlying program intent are violated, but the program still fulfills some essential functions.	Misses the point of the assignment.
Breakdown (modular design) - 0.5 points
Does it demonstrate good modular design?	No errors.	1-3 minor errors.	> 3 minor errors OR 1 major error.	2 major errors	> 2 major error.
Correctness of code - 2 points
Does it work? Does it pass JUnit?	Passes all tests.	Works for typical input, may fail for minor special cases.	Fails for typical input, for a minor reason.	Fails for typical input, for a major reason.	No.
Documentation, and style - 2 points
Is it clear and maintainable? Does it pass CheckStyle? Are your steps documented?	No errors.	1-3 minor errors.	> 3 minor errors OR 1 major error.	2 major errors	> 2 major error.
Efficiency of code - 1 point
Does it use the Java features well?	No errors.	1-3 minor errors.	> 3 minor errors OR 1 major error.	2 major errors	> 2 major error.
Algorithm Analysis - 2.5 points					
Turning in the Assignment
The assignment is due on Friday at 11:55pm. You may turn it in early.

Does your code follow the Java Coding Standard and pass CheckStyle?
Does your code pass the JUnit Tests?
Export your project following the instructions at the bottom of the page. Name the file H10.zip
Sign into Laulima, then navigate to the ICS211 site. In the left hand side of the site, there is an Assignments tab/link. Click on it and view all of the posted assignments. Select the assignment that you want to turn in and attach your H10.zip file accept the honor pledge to submit the assignment.
