ICS 211 Homework H07: Implement a simple card game of War
=========================================================

### Purpose

Our second abstract data structure is the Stack. For this assignment we are going to implement a Stack then use that stack to simulate the simple card game War. This assignment should give you more practice with problem solving, using Eclipse and implementing interfaces.

### Tasks

#### Create a package named edu.ics211.h07

This is where we will put all our classes for homework 07.

#### Create a class Stack<E> that implements the [IStack211<E>](IStack211.java) interface

    public interface IStack211<E> {
      boolean empty();
      E push(E item);
      E peek();
      E pop();
    }

You can use either an array or linked nodes to hold the items in you stack. Create a JUnit test StackTest that tests your Stack class.

#### Copy the [Card.java](Card.java), [Deck.java](Deck.java), [Rank.java](Rank.java), and [Suit.java](Suit.java) files into your package

These classes define a deck of cards we’ll be using for this assignment.

*   [Rank](Rank.java) is an enumeration of the Ranks of cards, TWO through ACE.
*   [Suit](Suit.java) is an enumeration of the Suits of cards, CLUBS, DIAMONDS, HEARTS, and SPADES.
*   [Card](Card.java) represents a single card.
*   [Deck](Deck.java) represents a deck of cards.

#### Implement the card game [War](https://bicyclecards.com/how-to-play/war/)

The goal of War is to be the first player to win all 52 cards. The deck is divided evenly, with each player receiving 26 cards, dealt one at a time, face down. Anyone may deal first. Each player places their stack of cards face down, in front of them.

Each player turns up a card at the same time and the player with the higher card takes both cards and puts them, face down, on the bottom of his stack.

If the cards are the same rank, it is War. Each player turns up one card face down and one card face up. The player with the higher cards takes both piles (six cards). If the turned-up cards are again the same rank, each player places another card face down and turns another card face up. The player with the higher card takes all 10 cards, and so on.

#### Create a class GameOfWar that implements the [IGameOfWar](IGameOfWar.java) interface.

    public interface IGameOfWar {
      void initializeGame(Deck d);
      boolean playARound();
      Stack<Card> playerOnesCards();
      Stack<Card> playerTwosCards();
      Stack<Card> combineStacks(Stack<Card> top, Stack<Card> bottom);
    }

*   The **void initializeGame(Deck d)** method should deal the cards to player one and player two. Player one and two should have the same number of cards.
*   The **boolean playARound()** method should play one round of War. Then update the players’ stacks to reflect the results of the round. This method should return true if any player wins the game.
*   The **Stack<Card> playerOnesCards()** method should return player one’s stack of cards.
*   The **Stack<Card> playerTwosCards()** method should return player two’s stack of cards.
*   The **Stack<Card> combineStacks(Stack<Card> top, Stack<Card> bottom)** method should combine top and bottom creating the return stack. The cards should be in the order top then bottom.

I recommend you focus on each method one at a time. Each method is its own problem that you need to solve. Think about the steps you need to take to solve them. For example, what are the steps needed to implement the **void initializeGame(Deck d)** method?

*   Ensure both players’ stack of cards are empty.
*   Loop until the deck’s size is 0.
    *   deal a single card to player one.
    *   deal a single card to player two.

We are going to use the [GameOfWarTest](GameOfWarTest.java) JUnit tests to evaluate your **GameOfWar** class for correctness.

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
2.  Does your code pass the [JUnit Tests](GameOfWarTest.java)?
3.  Export your project following the [instructions](../030.oop/experience-H02-clouds#turning-in-the-assignment) at the bottom of the page. Name the file H07.zip
4.  Sign into Laulima, then navigate to the ICS211 site. In the left-hand side of the site, there is an Assignments tab/link. Click on it and view all the posted assignments. Select the assignment that you want to turn in and attach your H07.zip file accept the honor pledge to submit the assignment.

Carleton (Cam) Moore | Information and Computer Sciences | University of Hawaii, Manoa  
[\[email protected\]](/cdn-cgi/l/email-protection#2d4e4042425f486d454c5a4c444403484958)  

Powered by the [Morea Framework](https://morea-framework.github.io/) (Theme: spacelab)  
Last update on: 2021-05-03 08:48:41 -1000

15 modules | 29 outcomes | 149 readings | 174 experiences | 45 assessments
