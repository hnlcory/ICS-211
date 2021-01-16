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


  @Override
  public String asBinaryString(InputStream in) {
   try {
    // create BitReader from InputStream
    BitReader readr = new BitReader(in);
    
    // create StringBuilder/string
   StringBuilder data = new StringBuilder();
   
    // while loop until BitReader is done 
    while (readr.isDone()==false) {
      data.append(readr.readAsInt());     
      //read bit from the bitreader
      //append  to StringBuilder
      //if bitreader is done, break loop
    }
    readr.close();
    return data.toString();
    //return StringBuilder.toString
  } catch (IOException e) {
    e.printStackTrace();
  }
    return null;
  }


  @Override
  public String asHexadecimalString(InputStream in) {
    //Create an empty String or StringBuilder class.
    StringBuilder data = new StringBuilder();
    try {
      //Loop until (until in.read() returns -1) (a while loop) the InputStream is done.
      while (true) {//(in.read() != -1***
        // read byte from in
        int number = in.read();
        System.out.println(number);
        if (number==-1) {
          break;
        }
        else {
          String temp=Integer.toHexString(number);
          // convert byte to ( .toHexString[];)
          //append string to string builder. need 2 hex digits******
          System.out.println(Integer.toString(number).length());
          if (temp.length()==1) {//<2 doesn't work
            System.out.println("add 0");
            data.append(0);
          }
         
          data.append(temp);
          
        }
       
      }
      //Return the String or StringBuilder.toString(). 
      return data.toString();
    } catch (IOException e) {
      e.printStackTrace();
    }

    
    return null;
  }


  @Override
  public String asUtf8String(InputStream in) {
    
    //create an array of bytes
    byte[] byteArray;
    
      try {
        //fill the array from input stream
        byteArray = in.readAllBytes();
        
        //create & return the newly constructed String
        String stringBytes = new String(byteArray);
        return stringBytes;
        
      } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      } 
    return null;
   
  }

}
