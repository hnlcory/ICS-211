/**
 * Compressing and De compressing Method.
 * @author Cory Parker
 * 
 */

package edu.ics211.h11;

import java.io.IOException;

/**
 * Method to compress and decompress command line args.
 * 
 * @author Cory Parker
 *
 */
public class H11Huffman {

  /**
   * Main method to compress and decompress.
   * 
   * @param args arguments to pass in
   */
  public static void main(String[] args) {
    // check to see if there is a file name in args
    // if not, system.err.println with instructions
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
        System.out.println("Decompressed " + fileName);
      } catch (IOException e) {
        e.printStackTrace();
      }
    } else {
      try {
        // else compress
        Huffman.compress(fileName);
        System.out.println("Compressed " + fileName);
      } catch (IOException e) {
        e.printStackTrace();
      }
    }

  }

}
