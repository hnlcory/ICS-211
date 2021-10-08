ICS 211 Homework H05: Sortable Cloud List (Doubly linked implementation)
Purpose
Our first abstract data structure is the List. For this homework assignment we are going to reimplement a sortable list using a linked node to store the items in the list. This assignment is very similar to H04 and should give you more practice with problem solving, using Eclipse and implementing interfaces. Just like the last assignment we will also use our implementation of the list as a member variable and learn how delegation can make your programming easier.

At the end of this homework you will have two different SortableList classes that have different implementations. Your SortableCloudList class can choose which one to use.

Tasks
1. Create a package named edu.ics211.h05
This is where we will put all our classes for homework 05.

2. Create a class named SortableList that implements the IList211 and ISortableList interfaces
public interface IList211<E> {
  E get(int index);
  E set(int index, E element);
  int indexOf(Object obj);
  int size();
  boolean add(E e);
  void add(int index, E element);
  E remove(int index);
}

public interface ISortableList<E>{
  void insertionSort(Comparator<E> compare);
  void bubbleSort(Comparator<E> compare);
  void selectionSort(Comparator<E> compare);
  int getNumberOfSwaps();
  int getNumberOfComparisons();
  double getSortTime();
}
You can import the interfaces from homework 4.

package edu.ics211.h05;

import edu.ics211.h04.IList211;
import edu.ics211.h04.ISortable;
...

public class SortableList<E> implements IList211<E>, ISortableList<E> { 
  private DLinkedNode tail;
  private int size;
  ... 
}
The SortableList in edu.ics211.h05 must use a DLinkedNode a private inner class to store the items in the list. We will be keeping track of the end of the list via the tail member variable. This doubly linked list is not circular, tail.next == null.

The DLinkedNode looks like:

private class DLinkedNode {
  E item;
  DLinkedNode next;
  DLinkedNode prev;
  
  public DLinkedNode(E item, DLinkedNode next, DLinkedNode prev) {
    this.item = item;
    this.next = next;
    this.prev = prev;
  }
}
Just as we did last week I recommend you focus on each method one at a time. Each method is it’s own problem that you need to solve. Think about the steps you need to take to solve them. For example, what are the steps needed to implement the E get(int index) method?

You still want to make sure the given index is valid. What are valid indexes? You might want to create a private method that checks the index. That way you don’t have to cut and paste your code each time you need to check the index.
If the index isn’t valid you should throw an IndexOutOfBoundsException.
If the index is good then you need to return the item at that index. How do you do that if you only have a pointer to the last DLinkedNode in the list?
Once you are done with a method move on to the next method. For the sorting methods use the Comparator to compare the items in the list. The sort methods should sort the list in ascending order, smallest at the beginning, largest at the end. This is different than homework 03 where we sorted an array of E’s. Do you want to swap the DLinkedNodes or just the items in the nodes?

3. Create your own JUnit tests for SortableList.
Create the JUnit test class SortableListTest.

Please thoroughly test your code and briefly discuss your testing strategy. You can put your discussion in a comment in the SortableListTest class. Make sure that you test the different sorting algorithms. Turn in all your test code. If your test code from homework 04 is good you can use it for homework 05.

4. Create a SortedCloudList that implements IList211 and automatically sorts the list of Clouds
The class SortedCloudList implements IList211<Cloud> and has:

A private SortableList<Cloud> member variable. This is how we are going to store and sort the clouds.
A constructor that takes a Comparator<Cloud> as the parameter. This is how the SortedCloudList will decide the order of the Clouds.
All the methods of IList211. It can delegate the operations (methods) to the SortableList member variable.
You should be able to copy your edu.ics211.h04.SortedCloudList java file into edu.ics211.h05. Then change the package and it should work.

We are going to use the SortedCloudListTest.java JUnit tests to evaluate your SortedList class for correctness.

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
Does your code pass the JUnit Tests?
Export your project following the instructions at the bottom of the page. Name the file H05.zip
Sign into Laulima, then navigate to the ICS211 site. In the left hand side of the site, there is an Assignments tab/link. Click on it and view all of the posted assignments. Select the assignment that you want to turn in and attach your H05.zip file accept the honor pledge to submit the assignment.
