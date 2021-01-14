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
    //Loop until (until in.read() returns -1) (a while loop) the InputStream is done, reading in a byte at a time. We then need to convert that byte to a hexadecimal string. You can use the Integer.toHexString method to convert that byte to a hexadecimal string.
    // read byte from in
    // convert byte to integer( .toHexString[];)
    //append string to string builder. need 2 hex digits
    //Return the String or StringBuilder.toString().
    return null;
  }


  @Override
  public String asUtf8String(InputStream in) {
    
    try {
      int number= in.available();
    } catch (IOException e) {
      e.printStackTrace();
    }
    // Create an array of bytes.
    //Fill the array from the InputStream.
    //Return the newly constructed String.
    return null;
    
    
    //get the number of bytes available
    //create an array of bytes that is number long
    //fill the array from in
    //return new String(bytes, "UTF-8")
  }

}
