package edu.ics211.h11;

import java.io.IOException;

public class HuffmanTest {

  public HuffmanTest() {
    // TODO Auto-generated constructor stub
  }


  public static void main(String[] args) {
    // TODO Auto-generated method stub
    String compFile = "compressionTest.jpeg";
    String decompFile = "decompressionTest.jpeg.huff";

    try {
      Huffman.compress(compFile);
      System.out.println("Compressed " + compFile + ". " + compFile + ".huff should be the same as " + decompFile);
    } catch (IOException e) {

      e.printStackTrace();
    }

    try {
      Huffman.decompress(decompFile);
      System.out.println("\nDecompressed " + decompFile + ". decompressionTest.jpeg should be the same as " + compFile);
    } catch (IOException e) {

      e.printStackTrace();
    }
  }

}
