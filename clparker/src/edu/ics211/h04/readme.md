ICS 211 Homework H04: Sortable Cloud List (Array implementation).
Purpose
Our first abstract data structure is the List. For this homework assignment we are going to implement a sortable list using an array to store the items in the list. This assignment should give you more practice with problem solving, using Eclipse and implementing an interface. We will also use our implementation of the list as a member variable and learn about delegation.

Tasks
1. Create a package named edu.ics211.h04
This is where we will put all our classes for homework 04.

2. Create the IList211 and ISortableList interfaces
Create the two interface java files and paste the contents into them.

3. Create a class named SortableList that implements the IList211 and ISortableList interfaces
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
The SortableList must use an array to store the items in the list.

I recommend you focus on each method one at a time. Each method is it’s own problem that you need to solve. Think about the steps you need to take to solve them. For example, what are the steps needed to implement the E get(int index) method?

You probably want to make sure the given index is valid. What are valid indexes? You might want to create a private method that checks the index. That way you don’t have to cut and paste your code each time you need to check the index.
If the index isn’t valid you should throw an IndexOutOfBoundsException.
If the index is good then you need to return the item at that index. How do you do that if you are using an array to store the items?
Once you are done with a method move on to the next method. For the sorting methods use the Comparator to compare the items in the list. The sort methods should sort the list in ascending order, smallest at the beginning, largest at the end. This is very similar to homework 03 where we sorted an array of E’s. Do you want to sort the whole array or just the part that holds the items?

4. Create your own JUnit tests for SortableList.
Create the JUnit test class SortableListTest.

Please thoroughly test your code and briefly discuss your testing strategy. You can put your discussion in a comment in the SortableListTest class. Make sure that you test the different sorting algorithms. Turn in all your test code.

5. Create a SortedCloudList that implements IList211 and automatically sorts the list of Clouds
The class SortedCloudList implements IList211<Cloud> and has:

A private SortableList<Cloud> member variable. This is how we are going to store and sort the clouds.
A constructor that takes a Comparator<Cloud> as the parameter. This is how the SortedCloudList will decide the order of the clouds.
All the methods of IList211. It can delegate the operations (methods) to the SortableList member variable.
Every time a cloud is added to the SortedCloudList the list will sort the clouds. Do we need to sort the clouds when we remove a cloud or get a cloud? How about when someone uses the set method?

We are going to use the SortedCloudListTest.java JUnit tests to evaluate your SortedCloudList class for correctness.

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
Export your project following the instructions at the bottom of the page. Name the file H04.zip
Sign into Laulima, then navigate to the ICS211 site. In the left hand side of the site, there is an Assignments tab/link. Click on it and view all of the posted assignments. Select the assignment that you want to turn in and attach your H04.zip file accept the honor pledge to submit the assignment.
