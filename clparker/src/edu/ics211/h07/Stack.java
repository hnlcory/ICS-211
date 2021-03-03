/**
 * 
 */
package edu.ics211.h07;

/**
 * @author Cory Parker
 * @param <E> type
 *
 */
public class Stack<E> implements IStack211<E> {
  private LinkedNode top;

  /**
   * 
   */
  public Stack() {
    //init tio
    //
  }

  @Override
  public boolean empty() {
    // return true if top is null
    return false;
  }

  @Override
  public E push(E item) {
    //create new linkednode item,top
    //update top
    return null;
  }

  @Override
  public E peek() {
    //if empty throw empty stack exception
    //return top.item
    return null;
  }

  @Override
  public E pop() {
    // if empty throw exception
    // remember item at top
    //update top
    //return item
    return null;
  }
  
  private class LinkedNode{
    E item;
    LinkedNode next;
    
    public LinkedNode(E item, LinkedNode next) {
      this.item =item;
      this.next= next;
    }
  }

}
