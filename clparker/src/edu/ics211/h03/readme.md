ICS 211 Homework H03: Sorting Arrays and Reading Files
======================================================

### Purpose

When we are dealing with data, we often want to put it in ‘order’. To do this we can sort it. In this assignment you will implement three simple sorts and analyze the sorting algorithms and your code.

In this assignment we have some specific requirements for your code. We have to satisfy the requirements of the problem in order to have correct solutions. This will give you early practice of writing code that meets some simple requirements.

The second part of this assignment is to continue exploring handling binary data in Java. You will write a class that reads in a file with a specific format.

Part 1
------

### Create an ArraySorter class that can sort Generic Arrays.

### Tasks

#### 1\. Create a package named edu.ics211.h03

This is where we will put all our classes for homework 03.

#### 2\. Create a generic class named ArraySorter that implements the [SortsArray](SortsArray.java) interface

    public interface SortsArray<E> {
      void insertionSort(Comparator<E> compare, SortRecord<E>[] data);
      void bubbleSort(Comparator<E> compare, SortRecord<E>[] data);
      void selectionSort(Comparator<E> compare, SortRecord<E>[] data);
      double getSortTime();
    }

You’ll need the [SortRecord](SortRecord.java) class. It is a generic that can keep track of the number of comparisons and swaps for each item in the array.

Each method should implement the named simple sort algorithm on the array data. Use the [Comparator<E>](https://docs.oracle.com/javase/7/docs/api/java/util/Comparator.html) to determine the order of the items in the array. Sort the arrays in ascending order. The ‘smallest’ element should be in position 0, ‘largest’ in data.length - 1.

The methods should keep track of the number of comparisons, the number of swaps for each item, and the amount of time it took to sort the array. To record the time taken, your code should call [System.nanoTime](https://docs.oracle.com/javase/7/docs/api/java/lang/System.html#nanoTime()) at the beginning of each of the methods and save the value as the start time. It should then call [System.nanoTime](https://docs.oracle.com/javase/7/docs/api/java/lang/System.html#nanoTime()) again at the end, and print the difference between the two times. The difference may be zero if your system clock does not update the time quickly enough, but otherwise should accurately report how many nanoseconds (billionths of a second) it took to execute your code. When the sort methods complete they should report the number of comparison, swaps, and the execution time in nanoseconds.

##### Requirements

*   Ensure that your implementation has the following characteristics:
    
    *   The BigO for insertion and bubble sort on sorted data must be BigO(n);
        
    *   The number of swaps for all three sorts on sorted data must be 0.
        

#### 3\. Create some Comparators in package edu.ics211.h02

*   Create an **AltitudeComparator** that implements **Comparator<Cloud>** deciding based upon the Clouds’ altitude values.
    
*   Create a **ShapeComparator** that implements **Comparator<Cloud>** deciding based upon the shape of the Clouds.
    

If you created them last week you are done. If not create them in package edu.ics211.h02.

### Testing

We are going to use the [CloudSorterTest.java](CloudSorterTest.java) JUnit tests to evaluate your homework for correctness.

You may add any more tests if you want to.

### Algorithm Analysis

Write up a runtime analysis of each of the sorting methods, giving the big-O of each, and explaining how you got your results. Your analysis should refer to your code by line number. Send your analysis to the TA together with your code. This part counts for 25% of the grade on this assignment. Even if your code doesn’t work, you should do this part to the best of your ability.

Part 2
------

Completing this part will help you with Homework 11: Huffman Trees.

### Create a ReadFile class that reads in a file

We are going to continue exploring handling binary data in Java. You will write a class that reads in a file with a specific format.

The file has the following format:

*   An integer, the number of bytes in the String.
*   A byte, the encoding of the String.
    *   1 means the String is encoded using [StandardCharsets.US\_ASCII](https://docs.oracle.com/javase/8/docs/api/java/nio/charset/StandardCharsets.html#US_ASCII)
    *   2 means the String is encoded using [StandardCharsets.UTF\_16LE](https://docs.oracle.com/javase/8/docs/api/java/nio/charset/StandardCharsets.html#UTF_16LE)
    *   3 means the String is encoded using [StandardCharsets.UTF\_8](https://docs.oracle.com/javase/8/docs/api/java/nio/charset/StandardCharsets.html#UTF_8)
    *   4 means the String is encoded using [StandardCharsets.UTF\_16](https://docs.oracle.com/javase/8/docs/api/java/nio/charset/StandardCharsets.html#UTF_16)
*   The bytes that make up the String.

### Tasks

#### 1\. Create a class named ReadFile that implements the [IReadFile](IReadFile.java) interface

The IReadFile interface has one method in it.

    public interface IReadFile {
      /**
       * Reads in the given file and returns the contents of the file as a string.
       * <p>The file has the following format:</p>
       * <ul>
       *   <li>An integer, the number of bytes the String has.</li>
       *   <li>A byte, the encoding of the String.</li>
       *   <ol>
       *     <li>StandardCharsets.US_ASCII</li>
       *     <li>StandardCharsets.UTF_16LE</li>
       *     <li>StandardCharsets.UTF_8</li>
       *     <li>StandardCharsets.UTF_16</li>
       *   </ol>
       *   <li>The String as bytes.</li>
       * </ul>
       * @param fileName The name of the file.
       * @return The String that was encoded in the file.
       * @throws FileNotFoundException If there is a problem with the file name.
       * @throws IOException If there is a problem reading the file.
       */
      String readFile(String fileName) throws IOException;
    }

#### 2\. Implement the readFile method

What are the steps you need to read in the contents of the file?

Java has a nice class [DataInputStream](https://docs.oracle.com/javase/8/docs/api/java/io/DataInputStream.html) that allows you to read in different types. I recommend you use this class. Also the [String class](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html#String-byte:A-java.nio.charset.Charset-) has a nice constructor that takes an array of bytes and a Charset.

You can test your implementation using [ReadFileTest](ReadFileTest.java). We will be using this JUnit test to grade this part of the assignment. ReadFileTest test against four files.

*   [data1.dat](data1.dat)
*   [data2.dat](data2.dat)
*   [data3.dat](data3.dat)
*   [data4.dat](data4.dat)

Download the files an place them in your project at the save level as your src directory. As shown below.

![datafiels](datafiles.png)

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

**Breakdown (modular design) - 0.5 points**  
Does it demonstrate good modular design?

No errors.

1-3 minor errors.

\> 3 minor errors OR 1 major error.

2 major errors

\> 2 major error.

**Correctness of code - 2 points**  
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

**Algorithm Analysis - 2.5 points**

Turning in the Assignment
-------------------------

The assignment is due on Friday at 11:55pm. You may turn it in early.

1.  Does your code follow the [Java Coding Standard](/morea/010.introduction/reading-java-coding-standard.html) and pass CheckStyle?
2.  Does your code pass the [JUnit Tests](CheeseSorterTest.java)?
3.  Export your project following the [instructions](../030.oop/experience-H02-clouds#turning-in-the-assignment) at the bottom of the page. Name the file H03.zip
4.  Sign into Laulima, then navigate to the ICS211 site. In the left hand side of the site, there is an Assignments tab/link. Click on it and view all of the posted assignments. Select the assignment that you want to turn in and attach your H03.zip file and your algorithm analysis accept the honor pledge to submit the assignment. Don’t forget to include your analysis.

Carleton (Cam) Moore | Information and Computer Sciences | University of Hawaii, Manoa  
[\[email protected\]](/cdn-cgi/l/email-protection#12717f7d7d6077527a7365737b7b3c777667)  

Powered by the [Morea Framework](https://morea-framework.github.io/) (Theme: spacelab)  
Last update on: 2021-05-03 08:48:41 -1000

15 modules | 29 outcomes | 149 readings | 174 experiences | 45 assessments
