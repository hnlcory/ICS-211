package edu.ics211.h11;

import java.io.IOException;

/**
 * Test method for huffman.java.
 * 
 * @author Cory Parker
 *
 */
public class HuffmanTest {

  /**
   * Test compression and decompression of images.
   * 
   * @author Cory Parker
   */
  public HuffmanTest() {
    // TODO Auto-generated constructor stub
  }


  /**
   * Main method to test compression/decompression.
   * 
   * @param args arguments
   */
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    String compFile = "compressionTest.jpeg";
    String decompFile = "decompressionTest.jpeg.huff";

    try {
      Huffman.compress(compFile);
      System.out.print("Compressed " + compFile + ". " + compFile);
      System.out.print(".huff should be the same as " + decompFile);
    } catch (IOException e) {

      e.printStackTrace();
    }

    try {
      Huffman.decompress(decompFile);
      System.out.println("\n");
      System.out.print("Decompressed " + decompFile);
      System.out.print(". decompressionTest.jpeg should be the same as " + compFile);
    } catch (IOException e) {

      e.printStackTrace();
    }
  }

}
