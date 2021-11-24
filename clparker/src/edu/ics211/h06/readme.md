ICS 211 Homework H06: Iterating over clouds in the sky
======================================================

### Purpose

For our last List homework assignment, we are going to simulate a sky with different clouds that you can visit in different orders. To facilitate this we will use a doubly linked list to hold the clouds. The list will implement the ListIterator interface that lets us visit the clouds in the order they appear in the List. We’ll then create a second iterator which gives us a choice of the order in which we visit the clouds, either upwards or downwards.

### Tasks

#### 1\. Create a package named edu.ics211.h06

This is where we will put some of our classes for homework 06.

#### 2\. Create a Doubly Linked List class named SortableList<E> that implements [IList211<E>](IList211.java) and [Iterable<E>](https://docs.oracle.com/en/java/javase/14/docs/api/java.base/java/lang/Iterable.html).

The next figure shows my New Class dialog.

![new SortableList](SortableList.png)

**Note:** You should make sure the generic class entries are all same type. In this case they are all <E>.

Use the private inner **DLinkedNode** class like you did for homework H05.

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

As in homework H05, you must keep track of the **tail** reference for this list.

In your **SortableList<E>** you will need another private class that implements the [**ListIterator**](https://docs.oracle.com/en/java/javase/14/docs/api/java.base/java/util/ListIterator.html) interface.

    public interface ListIterator<E> {
      void add(E e); // Inserts the specified element to the list. (Optional for this assignment)
      boolean hasNext(); // Returns true if this list iterator has more elements while traversing in the forward direction.
      boolean hasPrevious(); // Returns true if this list iterator has more elements while traversing in the reverse direction.
      E next(); // Returns the next Element.
      int nextIndex(); // Returns the index of the next element.
      E previous(); // Returns the previous Element
      int previousIndex(); // Returns the index of the previous element.
      void remove(); // Removes from the list the last element that was returned. (Optional for this assignment)
      void set(E e); // Replaces the last element returned. (Optional for this assignment)
    }

The **iterator()** method will return a new instance of your private inner class that implements the ListIterator<E> interface. You should implement all of these methods except add, remove and set.

In addition, you should add a second **iterator(Comparator<E> c)** method to return a new instance of a _second_ private inner class. This second iterator sorts the clouds according to the comparator and the upwards variable, and returns the clouds in sorted order.

Specifically, given that the iterator returns (in order) elements e1, e2, e3, e4, …, the following should hold:

*   c.compare(e1, e2) <= 0, c.compare (e2, e3) <= 0, c.compare(e3, e4) <= 0, …

The iterator may work in one of two ways:

1.  it may make a copy of the linked list, then sort the copy based on the values returned the comparator, or
    
2.  it may remember the last element returned by **next()** (if any), and each time **next()** or **hasNext()** is called, search through the (original) linked list to find the next element to return.
    

If you choose (1), you must implement one of selection sort, bubble sort, or insertion sort. In each case, the sort must be entirely your own code. The sort must be stable, meaning that if c.compare(e2, e3) == 0 and e2 appears before e3 in the original linked list, then e2 must appear before e3 in the sorted linked list.

If you do (2), you must remember the last element (if any) returned by **next()**, and find the following element (as determined by c.compare) in the linked list. If two elements compare the same, for example if c.compare (e2, e3) == 0 and e2 appears before e3 in the linked list, then after e2 has been returned by a call to **next()**, on the next call, **next()** must return e3.

Use the [SortableListTest.java](SortableListTest.java) to test your SortableList class. You’ll need the [StringComparator.java](StringComparator.java) to run the tests.

#### 3\. Create a ShadingCloud class that uses your SortableList class.

When one cloud is above another, the higher cloud can shade the lower cloud.

![Shading Clouds](cloud_heights.png)

Create a **ShadingCloud** class that implements the [ICloudShading](ICloudShading.java) interface.

    public interface ICloudShading {
      
      /**
       * Returns a List of the clouds in order of decreasing altitude. This method
       * doesn't destroy the list of clouds.
       * @param startAltitude ignore any clouds below this altitude
       *        If false the clouds are returned starting from higher altitudes then moving on to lower clouds.
       * @return A List of Clouds in the order they can shade each other.
       */
      List<Cloud> shadingClouds(int startAltitude);
    }

The **ShadingCloud** class must have a constructor that takes an array of Clouds, the Clouds in the sky.

The **shadingClouds** method should create a **SortableList<Cloud>** and use the **SortableList<Cloud>.iterator(Comparable)** to choose the clouds. It should then repeatedly call the **next()** method of the iterator until it finds a cloud at or above the startAltitude, and add all such clouds to the result list.

Your ShadingCloud class must have an inner Comparator class whose compare method returns a negative number if its first argument is lower than its second argument, zero if the two clouds are at the same altitude, and a positive number otherwise.

##### Example

Assume that Cloud1 is at altitude 1000, Cloud2 is at altitude 7000, Cloud3 is at altitude 6000, Cloud4 is at altitude 20000, Cloud5 is at altitude 12000, Cloud6 is at altitude 11111, and Cloud7 is also at altitude 11111,

    ShadingCloud clouds = new ShadingCloud([Cloud1, Cloud2, Cloud3, Cloud4, Cloud5, Cloud6, Cloud7]);
    List<Cloud> shading1 = clouds.shadingClouds(5000);
    List<Cloud> shading2 = clouds.shadingClouds(10000);

The shading1 list should have, in order, Cloud3, Cloud2, Cloud6, Cloud7, Cloud 5, and Cloud4. The shading2 list should have, in order, Cloud6, Cloud7, Cloud 5, and Cloud4.

We are going to use the [ShadingCloudTest.java](ShadingCloudTest.java) JUnit tests to evaluate your **ShadingCloud** class for correctness.

Grading Rubric
--------------

Criterion

Excellent (100%)

Satisfactory (75%)

Borderline (50%)

Unsatisfactory (25%)

Poor (0)

**Adherence to standards - 2 points**  
Does it conform to standards in every detail?

No errors.

Minor details of the assignment are violated, or poor choices are made where the assignment is unclear.

Significant details of the assignment or the underlying program intent are violated, but the program still fulfills essential functions.

Significant details of the assignment or the underlying program intent are violated, but the program still fulfills some essential functions.

Misses the point of the assignment.

**Breakdown (modular design) - 1 point**  
Does it demonstrate good modular design?

No errors.

1-3 minor errors.

\> 3 minor errors OR 1 major error.

2 major errors

\> 2 major error.

**Correctness of code - 4 points**  
Does it work? Does it pass JUnit?

Passes all tests.

Works for typical input, may fail for minor special cases.

Fails for typical input, for a minor reason.

Fails for typical input, for a major reason.

No.

**Documentation, and style - 2 points**  
Is it clear and maintainable? Does it pass CheckStyle? Are your steps documented?

No errors.

1-3 minor errors.

\> 3 minor errors OR 1 major error.

2 major errors

\> 2 major error.

**Efficiency of code - 1 point**  
Does it use the Java features well?

No errors.

1-3 minor errors.

\> 3 minor errors OR 1 major error.

2 major errors

\> 2 major error.

Turning in the Assignment
-------------------------

The assignment is due on Friday at 11:55pm. You may turn it in early.

1.  Does your code follow the [Java Coding Standard](/morea/010.introduction/reading-java-coding-standard.html) and pass CheckStyle?
2.  Does your code pass the [JUnit Tests](ShadingCloudTest.java)?
3.  Export your project following the [instructions](../030.oop/experience-H02-clouds#turning-in-the-assignment) at the bottom of the page. Name the file H06.zip
4.  Sign into Laulima, then navigate to the ICS211 site. In the left hand side of the site, there is an Assignments tab/link. Click on it and view all of the posted assignments. Select the assignment that you want to turn in and attach your H06.zip file accept the honor pledge to submit the assignment.

Carleton (Cam) Moore | Information and Computer Sciences | University of Hawaii, Manoa  
[\[email protected\]](/cdn-cgi/l/email-protection#4a29272525382f0a222b3d2b2323642f2e3f)  

Powered by the [Morea Framework](https://morea-framework.github.io/) (Theme: spacelab)  
Last update on: 2021-05-03 08:48:41 -1000

15 modules | 29 outcomes | 149 readings | 174 experiences | 45 assessments
