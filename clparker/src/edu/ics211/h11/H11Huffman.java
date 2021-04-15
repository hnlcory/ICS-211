/**
 * 
 */
package edu.ics211.h11;

import java.io.IOException;

/**
 * @author Cory Parker
 *
 */
public class H11Huffman {

  /**
   * @param args
   */
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    // check to see if there is a file name in args
    // if not, system.err.println with instructions
    // system.exit(-1)
    if (args.length == 0) {
      System.err.println("Missing Args!");
      System.exit(-1);
    }
    String fileName = args[0];
    // get file name
    // if filename ends with .huff
    if (fileName.contains(".huff")) {
      try {
        Huffman.decompress(fileName);
        System.out.println("Decompressed");
      } catch (IOException e) {
        e.printStackTrace();
      }
    } else {
      try {
        // else compress
        Huffman.compress(fileName);
        System.out.println("Compressed");
      } catch (IOException e) {
        e.printStackTrace();
      }
    }

  }

}
