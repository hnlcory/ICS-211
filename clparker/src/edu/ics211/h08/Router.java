/**
 * 
 */
package edu.ics211.h08;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Cory Parker
 *
 */
public class Router implements RouterInterface {
  private PacketQueue[] queues;
  private PacketSenderInterface sender;
  private List<Packet> droppedPackets;
  
  /**
   * Creates a new Router.
   *
   * @param sender the sender.
   */
  public Router(PacketSenderInterface sender) {
     // initialize the member variables
     queues = new PacketQueue[8];
     this.sender=sender;
     droppedPackets = new ArrayList<Packet>();
  }


  @Override
  public void advanceTime() {
    //loop over packetqueues 
    for (int i=0; i<8;i++) {
    //  packet= queue.poll
      Packet temp = queues[i].poll();
    //  if packet != null
      if (temp != null) {
        // sender.send(quee number, packet)
        sender.send(i, temp);
      }
    }
  }


  @Override
  public boolean acceptPacket(Packet p) {
    //get p's address
    int address = p.getAddress();
    //if bad address, droppedpacket.add(p)
    //return false
    if (address <0) {
      droppedPackets.add(p);
      return false;
    }
    //  else
    //    if offer returns false droppacket,
    //    return offer result
    else {
      if (queues[address].offer(p)==false) {
        droppedPackets.add(p);
        return false;
      }
    }
    
    return true;
  }


  @Override
  public List<Packet> getDroppedPackets() {
    // remember dropped packets
    List<Packet> allDrop = new ArrayList<Packet>(droppedPackets);
    //Initialize dropped packets
    droppedPackets= new ArrayList<Packet>();
    //return remembered
    return allDrop;
  }

}
