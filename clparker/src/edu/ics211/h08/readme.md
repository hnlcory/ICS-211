ICS 211 Homework H08: Simulate a Home Router
============================================

### Purpose

Our third abstract data structure is the Queue. For this homework assignment we are going to implement a packet queue using arrays or nodes and use it to simulate a printer queue. This assignment should give you more practice with Eclipse and using a queue to store data.

For this assignment, you will create a queue, then use it to simulate a home router such as many of you use to connect to the Internet. Real routers use queues to forward packets in the same order in which they were received, when the inbound traffic arrives faster than it can be sent.

Packets that are placed into a queue are delayed by the time spent in the queue (think of the line to get to a cashier). In a router, queues have a finite size so that the maximum delay is limited. Once a queue is full, newly-arrived packets that would normally be placed in that queue are dropped (discarded) instead.

Real packets on the Internet have a header which includes a destination IP address. Each router maintains a routing table which maps destination IP addresses to output queues. Most routers also have a _default_ route, which determines the output queue into which to put every packet whose destination IP address is not in the routing table.

This assignment simplifies the router by giving our packets a destination address that corresponds exactly to the output queue for the packet, so this simplified router does not need a routing table. For example, if the packet destination address is 3, the packet must be put into queue 3.

Also, to simplify things, the router in this assignment has exactly 8 output queues, numbered 0 through 7. Each of the queues can send 1 packet per time interval. Packet sending is accomplished by removing the front packet from a queue, and calling a method provided in the constructor.

Every queue in this simplified router can hold up to 10 packets. If the router receives a packet for a queue that is currently full, the packet should be dropped, that is, not added to any queue. Instead, we will add the packet to an internal list of dropped packets that can be obtained and cleared by calling getDroppedPackets().

### Tasks

#### 1\. Create a package named edu.ics211.h08

This is where we will put all our classes for homework 08.

#### 2\. In package edu.ics211.h08 create the [Packet](Packet.java) class, the [PacketSenderInterface](PacketSenderInterface.java), and [RouterInterface](RouterInterface.java) interfaces

We will be using the [Packet](Packet.java) class, the [PacketSender](PacketSender.java), and [RouterInterface](Router.java) interfaces to simulate simple home router.

#### 3\. Create a PacketQueue class that implements the [Java Queue interface](https://docs.oracle.com/en/java/javase/14/docs/api/java.base/java/util/Queue.html) interface

You must implement your own class for packet queues, called PacketQueue. At your choice, you may use arrays or linked lists to implement your queues. However you do it, your implementation _must_ implement the interface java.util.Queue<Packet> [Java Queue interface](https://docs.oracle.com/en/java/javase/14/docs/api/java.base/java/util/Queue.html) and in addition, should also provide a meaningful toString method that returns the contents of the queue in string format.

The [java.util.Queue<E>](https://docs.oracle.com/en/java/javase/14/docs/api/java.base/java/util/Queue.html) interface is relatively simple, but is required to implement many methods from [java.util.Collection<E>](https://docs.oracle.com/en/java/javase/14/docs/api/java.base/java/util/Collection.html). Your coding effort will probably be minimized if your PacketQueue class extends [AbstractQueue<Packet>](https://docs.oracle.com/en/java/javase/14/docs/api/java.base/java/util/AbstractQueue.html) or, at your choice, [AbstractSequentialList<Packet>](https://docs.oracle.com/en/java/javase/14/docs/api/java.base/java/util/AbstractSequentialList.html), [AbstractList<Packet>](https://docs.oracle.com/en/java/javase/14/docs/api/java.base/java/util/AbstractList.html), or [AbstractCollection<Packet>](https://docs.oracle.com/en/java/javase/14/docs/api/java.base/java/util/AbstractCollection.html). In any case, you are required to implement an iterator() method.

#### 4\. Create a Router class that implements the [RouterInterface](RouterInterface.java) interface

The Router class must have a constructor that takes one parameter a [PacketSenderInterface](PacketSenderInterface.java).

    public class Router implements RouterInterface {
      // member variables
    
      /**
       * Creates a new Router.
       *
       * @param sender
       */
      public Router(PacketSenderInterface sender) {
         // initialize the member variables
      }
      // methods   
    }     

Remember, the router in this assignment has exactly 8 output queues, numbered 0 through 7. Each of the queues can send 1 packet per time interval. Packet sending is accomplished by removing the front packet from a queue, and calling a method provided in the constructor.

Every queue in this simplified router can hold up to 10 packets. If the router receives a packet for a queue that is currently full, the packet should be dropped, that is, not added to any queue. Instead, we will add the packet to an internal list of dropped packets that can be obtained and cleared by calling getDroppedPackets().

Testing
-------

Your Router class must pass the [RouterTest](RouterTest.java) JUnit tests.

In addition, you must write and turn in your own JUnit test for your queue implementation, called QueueTest Your test code should call each of the methods in the interface enough times to establish that your queue is substantially bug-free. The tests must include at least adding and offering packets and polling and removing packets from

1.  an empty queue,
2.  a queue with one element in it,
3.  a queue that has one empty space, and
4.  a queue that is full.

Adding to a full queue and removing from an empty queue will throw exceptions – make sure your JUnit test catches those exceptions.

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
2.  Does your code pass the JUnit Tests?
3.  Export your project following the [instructions](../030.oop/experience-H02-clouds#turning-in-the-assignment) at the bottom of the page. Name the file H08.zip
4.  Sign into Laulima, then navigate to the ICS211 site. In the left hand side of the site, there is an Assignments tab/link. Click on it and view all of the posted assignments. Select the assignment that you want to turn in and attach your H08.zip file accept the honor pledge to submit the assignment.

Carleton (Cam) Moore | Information and Computer Sciences | University of Hawaii, Manoa  
[\[email protected\]](/cdn-cgi/l/email-protection#0c6f6163637e694c646d7b6d656522696879)  

Powered by the [Morea Framework](https://morea-framework.github.io/) (Theme: spacelab)  
Last update on: 2021-05-03 08:48:41 -1000

15 modules | 29 outcomes | 149 readings | 174 experiences | 45 assessments
