/**
 * 
 */
package edu.ics211.h08;

import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.Queue;

/**
 * @author Cory Parker
 *
 */
public class PacketQueue extends AbstractQueue<Packet> implements Queue<Packet> {
  private Packet[] packets;
  private int front;
  private int rear;
  private int size;

  /**
   * 
   */
  public PacketQueue() {
    this.packets = new Packet[10];
    this.front = 0;
    this.rear = 0;
    this.size = 0;
  }


  @Override
  public boolean offer(Packet e) {
    // check if full, return false
    if (size == packets.length) {
      return false;
    }
    // else put e at rear
    else {
      packets[rear] = e;
    }
    // update rear =(rear +1) % packets.length
    // Increment size
    // return true
    rear = (rear + 1) % packets.length;
    size++;
    return true;
  }


  @Override
  public boolean add(Packet e) {
    if (size == packets.length) {
      throw new IllegalStateException();
    } else {
      offer(e);
    }
    // boolean ret = offer(e)
    // check if ret full throw illegalstate
    // return true
    return true;
  }


  @Override
  public Packet poll() {
    // check if empty if so return null
    if (size == 0) {
      return null;
    }
    // Remember the packet at front
    // update front = (front + 1) % packets.length
    // Decrement size
    // return remembered
    else {
      Packet temp = packets[front];
      front = (front + 1) % packets.length;
      size--;
      return temp;
    }
  }


  @Override
  public Packet remove() {
    // packet = poll
    Packet temp = poll();
    // if null throw exception
    if (temp == null) {
      throw new NullPointerException();
    }
    // return packet
    return temp;
  }


  @Override
  public Packet peek() {
    // check size if 0
    // return null
    if (size == 0) {
      return null;
    }

    // return packets[front]
    return packets[front];
  }


  @Override
  public Packet element() {
    // packet - peek
    Packet temp = peek();
    // if null throw exception
    if (temp == null) {
      throw new NullPointerException();
    }

    // return packet
    return temp;
  }


  @Override
  public Iterator<Packet> iterator() {
    // TODO Auto-generated method stub
    return null;
  }

  private class MyIterator implements Iterator<Packet> {
    private int nextIndex;

    public MyIterator() {
      // initalize nextIndex
      nextIndex = front;
    }


    @Override
    public boolean hasNext() {
      // return nextIndex != rear
      return false;
    }


    @Override
    public Packet next() {
      // if hasNext
      // remmeber packet at nextIndex
      // update nextIndex
      // return packet
      // throw nosuchelement
      return null;
    }

  }

  @Override
  public int size() {
    return size;
  }

}
