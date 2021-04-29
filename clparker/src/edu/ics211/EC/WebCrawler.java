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
    address = new String();
  }

  // confirms valid address, return true or false
  public Boolean checkAddress(String s) {
    // given address
    // if string does contin .com, etc return true
    if (s.contains(".com") || s.contains(".net") || s.contains(".edu") || s.contains(".mil") || s.contains(".org")
        || s.contains(".gov")) {
      return true;
    }
    // else return false
    else {
      return false;
    }

  }


  // get address in console and return if valid address
  public String getAddress() {
    Boolean validAddress = false;
    Scanner inputScan = new Scanner(System.in);
    while (validAddress == false) {
      System.out.println("Enter Valid Web Address: ");
      this.address = inputScan.nextLine();

      //if address is formatted properly, set valid to true and return
      if (checkAddress(this.address)==true) {
        inputScan.close(); 
        validAddress=true;
        break;
      }
      //else wrong format, loop on
      System.out.println("Error : invalid web address\nUsage: [Valid Web Address] [depth to be searched]\n");
    }
    return address;
  }


  public static void main(String[] args) {
    WebCrawler w1 = new WebCrawler();
    w1.getAddress();

  }
}
