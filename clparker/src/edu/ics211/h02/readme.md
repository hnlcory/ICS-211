ICS 211 Homework H02: OOP, Class Hierarchies and Interfaces.
Purpose
Object Oriented Programming (OOP) is a very useful tool for problem solving. We can break down a problem into its components, model them as classes and instances to solve the problem. We are also going to explore different ways of comparing instances.

We are going to enhance our understanding of OOP, class hierarchies and interfaces by creating a simple Java class hierarchy of Clouds and “MotherNature”. The “MotherNature” implements an interface and follows the Factory and Singleton design patterns. In addition to the Clouds and “MotherNature” we are going to develop two different Comparators for comparing clouds.

The Cloud hierarchy looks like Cloud Heirarchy.

This assignment will give you practice using Eclipse to create and test Java classes. Hopefully, you have set up your Eclipse environment to make this assignment easier to complete.

You could use the New -> Class option to help you build the class heirarchy.

You could set up Eclipse’s Java -> Code Templates -> Comments to automatically conform to the Checkstyle guidelines. This will make your programming lives much simpler.

You could set up Eclipse to use checkstyle to show you any style errors in your code.

Or you can do it all by yourself and spend much more time typing and getting the homework done.

Tasks
1. Create a package named edu.ics211.h02
This is where we will put all our classes for homework 2.

2. Create the Java Enums, Interfaces and Classes needed for this homework assignment
The Java files you need are: MotherNatureTest.java, CloudCreator.java, and CloudShape.java.

The easiest way is to right mouse click on the link and choose “Save Link As…”. Save the files into your edu.ics211.h02 directory. Or you can use eclipse and create each of the files then replace their contents with the Java code.

The MotherNatureTest is a JUnit 5 test for the MotherNature class you are going to write.
The CloudCreator is an interface that your MotherNature class is going to implement.
The CloudShape is an Enum of the different cloud shapes.
To get the tests to run you’ll need to add the JUnit 5 library to your project.

3. Create the base abstract class Cloud
Choose New -> Class.

New Cloud Class

Make sure you click the abstract modifier before you click finish. You may also want to click the generate comments option.

Here’s a screen-shot of my Cloud class the eclipse created.

Cloud Class

Modify the base abstract class Cloud so that it has:

A private Integer member variable called altitude.
A private CloudShape member variable called shape.
A protected constructor with parameters: altitude and shape.
There should be get and set methods for all the member variables.
The Cloud class must be abstract. You cannot create an instance of a generic Cloud. You can only create instances of the concrete subclasses.

Here’s a screen shot of my Cloud class in Eclipse. Cloud class

Notice there are no Problems with my Cloud class. That means that there are no compile or checkstyle errors. The problems in the project are due to the JUnit tests not finding the rest of the classes.

4. Create three abstract classes LowLevel, MidLevel, and HighLevel that extends Cloud
These classes have:

A protected constructor with two parameters: altitude and shape.
The LowLevel class should throw an IllegalArgumentException if the altitude is greater than 6,500.

The MidLevel class should throw an IllegalArgumentException if the altitude is less than 6,501 or greater than 19,999.

The HighLevel class should throw an IllegalArgumentException if the altitude is less than 20,000.

5. Create the Cumulus, Altostratus, Cirrostratus and Cirrus classes
Class Cumulus extends LowLevel, Altostratus extends MidLevel and Cirrostratus and Cirrus extend HighLevel all have:

A constructor with one parameter: altitude. Be sure to set the CloudShape correctly.
A constructor with no parameters. This constructor should set the altitude to a valid random value for the cloud. Be sure to set the CloudShape correctly.
6. Create the MotherNature class
Create a MotherNature singleton class that can create Clouds. Singleton classes have a static method getInstance() that returns the one and only one instance of the class. The class must implement the CloudCreator interface.

Here’s a screen shot of my MotherNature class.

MotherNature

Notice there are no Problems in my project. That means that there are no compile or checkstyle errors.

Implement the CloudCreator methods. The formACloud method should check the altitude and CloudShape then create a Cloud with the altitude and shape. If there isn’t a concrete class for the altitude and shape then the method should throw an IllegalArgumentException.

At this point you can test your code with MotherNatureTest.java. We are going to use the JUnit tests to evaluate your homework for correctness.

7. (Optional) Create some Comparators
Next week’s homework is sorting an array of Cloud. You will need to create two comparators to do the sorting, so you can get a head start on next week’s homework by:

Creating an AltitudeComparator that implements Comparator<Cloud> deciding based upon the Clouds’ altitude values.

Creating a ShapeComparator that implements Comparator<Cloud> deciding based upon the shape of the Clouds.

You can test your comparators using CloudComparatorTest.java.

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
Export your project by choosing File -> Export. Under General choose Archive File.

Export Dialog

On the next dialog choose only the src directory in your project. Make sure the .checkstyle, .classpath, and .project files are selected. Choose Files

Name the zip file H02.

Sign into Laulima, then navigate to the ICS211 site. In the left hand side of the site, there is an Assignments tab/link. Click on it and view all of the posted assignments. Select the assignment that you want to turn in and attach your H02.zip file and accept the honor pledge to submit the assignment. Yes, the pledge says you worked alone, but in ICS 211 you can work together as long as you give credit to you teammates. See the Giving Credit screen cast.
