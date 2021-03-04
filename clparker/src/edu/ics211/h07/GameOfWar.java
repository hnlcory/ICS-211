/**
 * 
 */
package edu.ics211.h07;
import edu.ics211.h07.RankComparator;
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
    playerOne=null;
    playerTwo=null;
    
    // init the member variables
  }


  @Override
  public void initializeGame(Deck d) {
    while (d.size()>1) {
      playerOne.push(d.dealACard());
      playerTwo.push(d.dealACard());
    }
    // split the cards from the deck to playerOne and playerTwo
    //loop while d.size > 1 
    //  playerOne.push(d.dealacard)
    //  playerTwo.push(d.dealacard)
  }


  @Override
  public boolean playARound() {
    RankComparator compr = new RankComparator();
    Card oneCard = playerOne.pop();
    Card twoCard = playerTwo.pop();
    
    // pop one card from playerOne and two
    // compare the cards rank
    if(compr.compare(oneCard,twoCard) >=1) {//if one is > two
    // if player one wins, add both cards to bottom of player ones stack
    }
    
    else if ((compr.compare(oneCard,twoCard) <=-1)) {//if two is > one
    // else if player two wins.. same to player 2  
    }
    
    else {
      //else its a tie, pop 2 cards from player one and two
      //  loop until someone wins or they run out of cards
      //  add all cards to winners bottom of stack
    }
   
    
    
    //check if player1 is empty or if player2 is empty
    if (playerOne.empty()==true || playerTwo.empty() ==true) {
      return true;
    //if someone won return true
    }
    else {
      return false;
    }
  }


  @Override
  public Stack<Card> playerOnesCards() {
    //return playerone
    return playerOne;
  }


  @Override
  public Stack<Card> playerTwosCards() {
    //return playertwo
    return playerTwo;
  }


  @Override
  public Stack<Card> combineStacks(Stack<Card> top, Stack<Card> bottom) {
    // reverse top and bottom
    // starting with rbottom, push cards, return stack
    // then with rtop, push the cards on to return stack
    // return returnStack
    return null;
  }

}
