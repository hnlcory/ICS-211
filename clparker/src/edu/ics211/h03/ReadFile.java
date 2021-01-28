/**
 * 
 */
package edu.ics211.h03;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author Cory Parker
 *
 */
public class ReadFile implements IReadFile {

  /**
   * 
   */
  public ReadFile() {
    // TODO Auto-generated constructor stub
  }


  @Override
  public String readFile(String fileName) throws IOException {
    
    DataInputStream dataIn = new DataInputStream(new FileInputStream(fileName)); //create data input stream from a file input stream from file name
    int numBytes = dataIn.readInt();// read in number of bytes (an integer) readInt
    int encoding = dataIn.readByte();//read in encoding (a byte) readByte
    byte[] bytes = new byte[numBytes];//create a byte[] of length numBytes
    
    dataIn.read(bytes);//fill array from DataInputStream
    
    switch (encoding) {
      case 1:
        //StandardCharsets.US_ASCII
      case 2:
        //StandardCharsets.UTF_16LE
      case 3:
        //StandardCharsets.UTF_8
      case 4:
        //StandardCharsets.UTF_16
    }
    
    
    //create data input stream from a file input stream from file name
    // read in number of bytes (an integer) readInt
    //read in encoding (a byte) readByte
    //create a byte[] of length numBytes
    //fill array from DataInputStream
    
    //switch 1-4 (return new string ...)
    
    
    
    
    // TODO Auto-generated method stub
    return null;
  }

}
