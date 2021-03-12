/**
 * A queue to take in packets.
 * 
 * @author Cory Parker.
 * 
 */

package edu.ics211.h08;

import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Queue;

/**
 * A queue for packets.
 * 
 * @author Cory Parker.
 *
 */
public class PacketQueue extends AbstractQueue<Packet> implements Queue<Packet> {
  private Packet[] packets;
  private int front;
  private int rear;
  private int size;

  /**
   * Initialize Packets.
   * 
   * @author Cory Parker.
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
    } else {
      // else put e at rear
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
    } else {
      // Remember the packet at front
      // update front = (front + 1) % packets.length
      // Decrement size
      // return remembered
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

    return new MyIterator();
  }

  private class MyIterator implements Iterator<Packet> {
    private int nextIndex;

    public MyIterator() {
      // Initialize nextIndex
      this.nextIndex = front;
    }


    @Override
    public boolean hasNext() {
      return nextIndex != rear;
    }


    @Override
    public Packet next() {
      // if hasNext
      if (hasNext()) {
        // Remember packet at nextIndex
        // update nextIndex
        // return packet
        Packet temp = packets[nextIndex];
        nextIndex++;
        return temp;
      } else {
        throw new NoSuchElementException();
      }
    }

  }

  @Override
  public String toString() {
    Iterator<Packet> iter = this.iterator();
    StringBuilder builder = new StringBuilder();
    builder.append("[");
    while (iter.hasNext()) {
      builder.append(iter.next());
      builder.append(", ");
    }
    builder.substring(0, builder.length() - 2);
    builder.append("]");
    return builder.toString();
  }


  @Override
  public int size() {
    return size;
  }

}
