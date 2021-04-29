/**
 * 
 */
package edu.ics211.EC;

import java.util.Scanner;

/**
 * Web Crawler.
 * 
 * @author Cory Parker
 *
 */
public class WebCrawler {
  String address;
  Integer depth;
  /**
   * Initalize Variables.
   * 
   * @author Cory Parker.
   * 
   */
  public WebCrawler() {
    address = new String();
    depth=0;
  }


  /**
   * confirms valid address, return true or false.
   * 
   * @param s string to confirm.
   * @return true if good address or false
   */
  public Boolean checkAddress(String s) {
    // given address
    // if string does contin .com, etc return true
    if (s.contains(".com") || s.contains(".net") || s.contains(".edu") || s.contains(".mil") || s.contains(".org")
        || s.contains(".gov")) {
      // check for https and ://
      if (s.contains("https") || s.contains("http") && s.contains("://")) {
        return true;
      } else {
        return false;
      }
    }
    // else return false
    else {
      return false;
    }

  }


  /**
   * gets address from console.
   * 
   * @return if address is valid or prompt user
   */
  public String getAddress() {
    Boolean validAddress = false;
    Scanner inputScan = new Scanner(System.in);
    while (validAddress == false) {
      System.out.println("\nEnter Valid Web Address: ");
      this.address = inputScan.next();

      // if address is formatted properly, set valid to true and return **save crawl depth
      if (checkAddress(this.address) == true) {
        inputScan.close();
        validAddress = true;
        break;
      }
      // else wrong format, loop on
      System.out.println("Error : invalid web address\nUsage: [Valid Web Address] [depth to be searched]\n");
    }
    return address;
  }


  public static void main(String[] args) {
    WebCrawler w1 = new WebCrawler();
    w1.getAddress();

  }
}
