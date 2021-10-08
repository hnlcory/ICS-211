ICS 211 Homework H08: Simulate a Home Router
Purpose
Our third abstract data structure is the Queue. For this homework assignment we are going to implement a packet queue using arrays or nodes and use it to simulate a printer queue. This assignment should give you more practice with Eclipse and using a queue to store data.

For this assignment, you will create a queue, then use it to simulate a home router such as many of you use to connect to the Internet. Real routers use queues to forward packets in the same order in which they were received, when the inbound traffic arrives faster than it can be sent.

Packets that are placed into a queue are delayed by the time spent in the queue (think of the line to get to a cashier). In a router, queues have a finite size so that the maximum delay is limited. Once a queue is full, newly-arrived packets that would normally be placed in that queue are dropped (discarded) instead.

Real packets on the Internet have a header which includes a destination IP address. Each router maintains a routing table which maps destination IP addresses to output queues. Most routers also have a default route, which determines the output queue into which to put every packet whose destination IP address is not in the routing table.

This assignment simplifies the router by giving our packets a destination address that corresponds exactly to the output queue for the packet, so this simplified router does not need a routing table. For example, if the packet destination address is 3, the packet must be put into queue 3.

Also, to simplify things, the router in this assignment has exactly 8 output queues, numbered 0 through 7. Each of the queues can send 1 packet per time interval. Packet sending is accomplished by removing the front packet from a queue, and calling a method provided in the constructor.

Every queue in this simplified router can hold up to 10 packets. If the router receives a packet for a queue that is currently full, the packet should be dropped, that is, not added to any queue. Instead, we will add the packet to an internal list of dropped packets that can be obtained and cleared by calling getDroppedPackets().

Tasks
1. Create a package named edu.ics211.h08
This is where we will put all our classes for homework 08.

2. In package edu.ics211.h08 create the Packet class, the PacketSenderInterface, and RouterInterface interfaces
We will be using the Packet class, the PacketSender, and RouterInterface interfaces to simulate simple home router.

3. Create a PacketQueue class that implements the Java Queue interface interface
You must implement your own class for packet queues, called PacketQueue. At your choice, you may use arrays or linked lists to implement your queues. However you do it, your implementation must implement the interface java.util.Queue<Packet> Java Queue interface and in addition, should also provide a meaningful toString method that returns the contents of the queue in string format.

The java.util.Queue<E> interface is relatively simple, but is required to implement many methods from java.util.Collection<E>. Your coding effort will probably be minimized if your PacketQueue class extends AbstractQueue<Packet> or, at your choice, AbstractSequentialList<Packet>, AbstractList<Packet>, or AbstractCollection<Packet>. In any case, you are required to implement an iterator() method.

4. Create a Router class that implements the RouterInterface interface
The Router class must have a constructor that takes one parameter a PacketSenderInterface.

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
Your Router class must pass the RouterTest JUnit tests.

In addition, you must write and turn in your own JUnit test for your queue implementation, called QueueTest Your test code should call each of the methods in the interface enough times to establish that your queue is substantially bug-free. The tests must include at least adding and offering packets and polling and removing packets from

an empty queue,
a queue with one element in it,
a queue that has one empty space, and
a queue that is full.
Adding to a full queue and removing from an empty queue will throw exceptions – make sure your JUnit test catches those exceptions.

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
Export your project following the instructions at the bottom of the page. Name the file H08.zip
Sign into Laulima, then navigate to the ICS211 site. In the left hand side of the site, there is an Assignments tab/link. Click on it and view all of the posted assignments. Select the assignment that you want to turn in and attach your H08.zip file accept the honor pledge to submit the assignment.
