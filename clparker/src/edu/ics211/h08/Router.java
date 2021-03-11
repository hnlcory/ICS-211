/**
 * 
 */
package edu.ics211.h08;

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
     droppedPackets = new List<Packet>();
  }


  @Override
  public void advanceTime() {
    //loop over packetqueues 
    //  packet= queue.poll
    //  if packet != null
    //    sender.send(quee number, packet)
    

  }


  @Override
  public boolean acceptPacket(Packet p) {
    //get p's address
    int address = p.getAddress();
    //if bad address, droppedpacket.add(p)
    //return false
    if (address <0) {
      droppedPacket.add(p);
      return false;
    }
    //  else
    //    if offer returns false droppacket,
    //    return offer result
    else {
      
    }
    
    return false;
  }


  @Override
  public List<Packet> getDroppedPackets() {
    // remember dropped packets
    //Initialize dropped packets
    //return remembered
    return null;
  }

}
