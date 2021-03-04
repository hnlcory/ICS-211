/**
 * 
 */
package edu.ics211.h07;

import java.util.EmptyStackException;

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
    this.top = null;
    // init top

  }


  @Override
  public boolean empty() {
    if (top == null) {
      return true;
    } else {
      return false;
    }

  }


  @Override
  public E push(E item) {
    LinkedNode node = new LinkedNode(item, top);
    top = node;
    return item;
    // create new linkednode item,top
    // update top

  }


  @Override
  public E peek() {
    if (empty() == true) {
      throw new EmptyStackException();
    }
    return top.item;
    // if empty throw empty stack exception
    // return top.item
  }


  @Override
  public E pop() {
    if (empty() == true) {
      throw new EmptyStackException();
    }
    LinkedNode temp = top;// save E item instead of node?
    top = top.next;
    return temp.item;
    // if empty throw exception
    // remember item at top
    // update top
    // return item
  }

  private class LinkedNode {// may need to be of type E
    E item;
    LinkedNode next;

    public LinkedNode(E item, LinkedNode next) {
      this.item = item;
      this.next = next;
    }
  }

}
