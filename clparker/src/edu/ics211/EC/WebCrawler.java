/**
 * 
 */
package edu.ics211.EC;

import java.util.Scanner;

/**
 * @author Cory Parker
 *
 */
public class WebCrawler {
  String address;
  /**
   * 
   */
  public WebCrawler() {
    // TODO Auto-generated constructor stub
  }


  // get address in console
  public String getAddress() {
    Boolean validAddress = false;
    Scanner inputScan = new Scanner(System.in);
    while (validAddress == false) {
      System.out.println("Enter Valid Web Address: ");
      this.address = inputScan.nextLine();

      //if address is formatted properly, set valid to true and return
      if (validAddress == true) {
        inputScan.close(); 
      }
      //else wrong format, loop on
      System.out.println("Error : invalid web address\nUsage: [Valid Web Address] [depth to be searched]\n");
    }
    return address;
  }
  
  //confirms valid address, return true or false
  public Boolean validateAddress(String address, Integer d) {
    
    return null;
  }


  public static void main(String[] args) {
    WebCrawler w1 = new WebCrawler();
    w1.getAddress();

  }
}
