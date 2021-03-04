/**
 * 
 */
package edu.ics211.h07;

/**
 * @author Cory Parker
 *
 */
public class GameOfWar implements IGameOfWar {
  private Stack<Card> playerOne;
  private Stack<Card> playerTwo;

  /**
   * 
   */
  public GameOfWar() {
    playerOne = null;
    playerTwo = null;

    // init the member variables
  }


  @Override
  public void initializeGame(Deck d) {
    while (d.size() > 1) {
      playerOne.push(d.dealACard());
      playerTwo.push(d.dealACard());
    }
    // split the cards from the deck to playerOne and playerTwo
    // loop while d.size > 1
    // playerOne.push(d.dealacard)
    // playerTwo.push(d.dealacard)
  }


  @Override
  public boolean playARound() {
    RankComparator compr = new RankComparator();

    Card oneCard = playerOne.pop();
    Card twoCard = playerTwo.pop();
    Boolean tied;// weird not used thing?
    Stack<Card> playedCards = new Stack<Card>();
    // do while
    do {
      tied = true;// weird not used thing?
      playedCards.push(oneCard);
      playedCards.push(twoCard);

      // pop one card from playerOne and two
      // compare the cards rank
      if (compr.compare(oneCard, twoCard) >= 1) {// if one is > two
        // if player one wins, add both cards to bottom of player ones stack
        tied = false;
        playerOne = combineStacks(playerOne, playedCards);
      }

      else if ((compr.compare(oneCard, twoCard) <= -1)) {// if two is > one
        // else if player two wins.. same to player 2
        tied = false;
        playerTwo = combineStacks(playerTwo, playedCards);
      }

      else {
        tied = true;
        playedCards.push(playerOne.pop());
        playedCards.push(playerTwo.pop());
        oneCard = playerOne.pop();
        twoCard = playerTwo.pop();
        // else its a tie, pop 2 cards from player one and two
        // loop until someone wins or they run out of cards
        // add all cards to winners bottom of stack
      }
    } while (tied = true);

    // check if player1 is empty or if player2 is empty
    if (playerOne.empty() == true || playerTwo.empty() == true) {
      return true;
      // if someone won return true
    } else {
      return false;
    }
  }


  @Override
  public Stack<Card> playerOnesCards() {
    // return playerone
    return playerOne;
  }


  @Override
  public Stack<Card> playerTwosCards() {
    // return playertwo
    return playerTwo;
  }


  @Override
  public Stack<Card> combineStacks(Stack<Card> top, Stack<Card> bottom) {
    Stack<Card> returnStack = new Stack<Card>();
    bottom = reverseStack(bottom);
    top = reverseStack(top);

    // reverse top and bottom
    while (bottom.empty() == false) {
      Card card = bottom.pop();
      returnStack.push(card);
    }
    // starting with rbottom, push cards, return stack
    while (top.empty() == false) {
      Card card = top.pop();
      returnStack.push(card);
    }
    // then with rtop, push the cards on to return stack
    // return returnStack
    return returnStack;
  }


  public Stack<Card> reverseStack(Stack<Card> stack) {
    Stack<Card> temp = new Stack<Card>();

    // while stack has items
    // add them to temp
    while (stack.empty() == false) {
      Card card = stack.pop();
      temp.push(card);
    }

    return temp;

  }

}
