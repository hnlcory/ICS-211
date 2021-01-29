/**
 * Program to in a file with a specific formats.
 * @author Cory Parker.
 */

package edu.ics211.h03;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * Reads in a file with a specific encoding format.
 * Fills in array from DataInputstream.
 * @author Cory Parker.
 */
public class ReadFile implements IReadFile {

  /**
   * Reads files.
   * 
   * @author Cory Parker.
   */
  public ReadFile() {
    // TODO Auto-generated constructor stub
  }


  @Override
  public String readFile(String fileName) throws IOException {

    // create data input stream from a file
    DataInputStream dataIn = new DataInputStream(new FileInputStream(fileName));
    // input stream from file name
    int numBytes = dataIn.readInt();// read in number of bytes (an integer) readInt
    int encoding = dataIn.readByte();// read in encoding (a byte) readByte
    byte[] bytes = new byte[numBytes];// create a byte[] of length numBytes

    dataIn.read(bytes);// fill array from DataInputStream

    dataIn.close();

    switch (encoding) {
      case 1:
        return new String(bytes, StandardCharsets.US_ASCII);
      // StandardCharsets.US_ASCII
      case 2:
        return new String(bytes, StandardCharsets.UTF_16LE);
      // StandardCharsets.UTF_16LE
      case 3:
        return new String(bytes, StandardCharsets.UTF_8);
      // StandardCharsets.UTF_8
      case 4:
        return new String(bytes, StandardCharsets.UTF_16);
      // StandardCharsets.UTF_16
      default:
        throw new IOException();
    }

  }

}
