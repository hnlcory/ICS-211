/**
 * 
 */
package edu.ics211.h01;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author Cory Parker
 *
 */
public class Translator implements Translate {

  /**
   * 
   */
  public Translator() {
    // TODO Auto-generated constructor stub
  }


  /**
   * Attempts to return a binary string from input stream
   */
  public String asBinaryString(InputStream in) {
   try {
    // create BitReader from InputStream
    BitReader readr = new BitReader(in);
    
    // create StringBuilder/string
    StringBuilder data = new StringBuilder();
   
    // while loop until BitReader is done 
    while (readr.isDone()==false) {
      //read bit from the bitreader
      //append  to StringBuilder
      //if bitreader is done, break loop
      data.append(readr.readAsInt());     
      
    }
    //close
    readr.close();
    in.close();
    //return StringBuilder.toString
    return data.toString();
   
  } 
   
   catch (IOException e) {
    e.printStackTrace();
  }
   
    return null;
  }


  /**
   * Attempts to return a hexadecimal string from input stream
   */
  public String asHexadecimalString(InputStream in) {
    //Create an empty String or StringBuilder class.
    StringBuilder data = new StringBuilder();
    try {
      //Loop until (until in.read() returns -1) (a while loop) the InputStream is done.
      while (true) {//(in.read() != -1***
        // read byte from in
        int number = in.read();
        //if input stream is finished, break
        if (number==-1) {
          break;
        }
        
        else {
          // convert byte to ( .toHexString[];)
          //append string to string builder. need 2 hex digits******
          String temp=Integer.toHexString(number);
          //if there is only 1 digit, add 0 then append
          if (temp.length()==1) {
            
            data.append(0);
          }
         //append string to string builder
          data.append(temp);  
        }
       
      }
      in.close();
      //Return StringBuilder.toString(). 
      return data.toString();
    }
    catch (IOException e) {
      e.printStackTrace();
    }
    
    return null;
  }

  /**
   * Attempts to return a hexadecimal string from input stream
   */
  public String asUtf8String(InputStream in) {
    
    //create an array of bytes
    byte[] byteArray;
    
      try {
        //fill the array from input stream
        byteArray = in.readAllBytes();
        
        //create & return the newly constructed String
        String stringBytes = new String(byteArray);
        in.close();
        return stringBytes;
        
      } 
      catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      } 
      
    return null;
    
  }

}
