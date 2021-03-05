/**
 * A stack to hold items.
 * @author Cory Parker
 */

package edu.ics211.h07;

import java.util.EmptyStackException;

/**
 * Stack of items.
 * 
 * @author Cory Parker
 * @param <E> type
 *
 */
public class Stack<E> implements IStack211<E> {
  private LinkedNode top;

  /**
   * Initialize the Stack.
   * 
   * @author Cory Parker
   */
  public Stack() {
    this.top = null;

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
    // create new linkednode item,top
    // update top
    top = node;
    return item;

  }


  @Override
  public E peek() {
    // if empty throw empty stack exception
    // return top.item
    if (empty() == true) {
      throw new EmptyStackException();
    }
    return top.item;

  }


  @Override
  public E pop() {
    if (empty() == true) {
      throw new EmptyStackException();
    }
    LinkedNode temp = top;
    top = top.next;
    // if empty throw exception
    // remember item at top
    // update top
    // return item
    return temp.item;

  }

  private class LinkedNode {
    E item;
    LinkedNode next;

    public LinkedNode(E item, LinkedNode next) {
      this.item = item;
      this.next = next;
    }
  }

}
