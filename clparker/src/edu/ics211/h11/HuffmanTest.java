package edu.ics211.h11;

import java.io.IOException;

public class HuffmanTest {

  public HuffmanTest() {
    // TODO Auto-generated constructor stub
  }


  public static void main(String[] args) {
    // TODO Auto-generated method stub
  String compFile = "compressionTest.jpeg",decompFile = "decompressionTest.jpeg.huff";
  
  try {
    Huffman.compress(compFile);
    Huffman.decompress(decompFile);
  } catch (IOException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
  }
  
  
  }

}
