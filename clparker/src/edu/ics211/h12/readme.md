ICS 211 Homework H12: Create 3 Potion Bags.
===========================================

### Purpose

An evil prince has kidnapped your true love. He is demanding that you create three different potion bags for the return of your true love. The first bag must be a quick bag. The second bag must be a medium bag and the last bag must be a slow bag.

You’re going to implement three different versions of a data structure, a PotionBag, that have different performance characteristics. You’ll get to choose the implementation details to meet the performance requirements.

This assignment should give you more practice with Eclipse and choosing the right Abstract Data Type to use to solve a problem.

### Tasks

#### 1\. Create a package named edu.ics211.h12

This is where we will put all our classes for homework 12. Use the following java files:

*   [Amount.java](Amount.java)
*   [Ingredient.java](Ingredient.java)
*   [Potion.java](Potion.java)
*   [PotionBag.java](PotionBag.java)
*   [PotionGenerator.java](PotionGenerator.java)
*   [Unit.java](Unit.java)

#### 2\. Create the singleton class QuickPotionBag

The **QuickPotionBag** class must implement the **[PotionBag](PotionBag.java)** interface.

    public interface PotionBag {
      void store(Potion p);
      long timedStore(Potion p);
      Potion retrieve(Potion p);
      long timedRetrieve(Potion p);
      int size();
    }

The _store_, _retrieve_ and _size_ methods must all be **BigO(1)** or close to constant time.

#### 3\. Create the singleton class MediumPotionBag

The **MediumPotionBag** class must implement the PotionBag interface, but the _store_ and _retrieve_ methods must be **BigO(log n)**.

#### 4\. Create the singleton class SlowPotionBag

The **SlowPotionBag** class must implement the PotionBag interface, but the _store_ and _retrieve_ methods must be **BigO(n)**.

#### 5\. Use PotionBagTest to test your PotionBags.

[PotionBagTest.java](PotionBagTest.java) is a simple JUnit test that adds 111,000 random potions to your three PotionBags then times storing one more and times retrieving that potion. It prints out the times for your three implementations.

Here is an example output:

    Q store: 1891, M store: 2417, S store: 7364
    Q retrieve: 12962, M retrieve: 18570, S retrieve: 11112615
    

Because of timing issues and implementation choices you won’t get the same values, but your quick bag should be faster than the medium and slow bags.

Grading Rubric
--------------

Criterion

Excellent (111%)

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

1.  Does your code follow the [Java Coding Standard](/morea/011.introduction/reading-java-coding-standard.html) and pass CheckStyle?
2.  Does your code pass the JUnit Tests?
3.  Export your project following the [instructions](../030.oop/experience-H02) at the bottom of the page. Name the file H12.zip
4.  Sign into Laulima, then navigate to the ICS211 site. In the left hand side of the site, there is an Assignments tab/link. Click on it and view all of the posted assignments. Select the assignment that you want to turn in and attach your H12.zip file accept the honor pledge to submit the assignment. Yes, the pledge says you worked alone, but in ICS 211 you can work together as long as you give credit to you teammates. See the [Giving Credit](/ics211s21/morea/010.introduction/sc-giving-credit.html) screen cast.

Carleton (Cam) Moore | Information and Computer Sciences | University of Hawaii, Manoa  
[\[email protected\]](/cdn-cgi/l/email-protection#dbb8b6b4b4a9be9bb3baacbab2b2f5bebfae)  

Powered by the [Morea Framework](https://morea-framework.github.io/) (Theme: spacelab)  
Last update on: 2021-05-03 08:48:41 -1000

15 modules | 29 outcomes | 149 readings | 174 experiences | 45 assessments
