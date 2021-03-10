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
    // TODO Auto-generated constructor stub
  }


  @Override
  public boolean offer(Packet e) {
    // TODO Auto-generated method stub
    return false;
  }


  @Override
  public Packet poll() {
    // TODO Auto-generated method stub
    return null;
  }


  @Override
  public Packet peek() {
    // TODO Auto-generated method stub
    return null;
  }


  @Override
  public Iterator<Packet> iterator() {
    // TODO Auto-generated method stub
    return null;
  }


  @Override
  public int size() {
    // TODO Auto-generated method stub
    return 0;
  }

}
