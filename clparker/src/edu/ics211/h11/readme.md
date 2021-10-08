ICS 211 Homework H11: Huffman Trees
Purpose
Continuing to use binary trees, we are going to use Huffman trees to encode and decode files. In this assignment you will write a program that decompresses files that were compressed using Huffman encoding.

This assignment will give you more practice with:

Binary Trees especially Huffman Trees,
Reading binary data with Java,
Reading, understanding and modifying existing Java code and
Using Eclipse.
Tasks
1. Create a package named edu.ics211.h11
This is where we will put all our classes for homework 11.

2. Download the example files
Download the following example files and place them in your Eclipse workspace.

ics211.bmp
ics211.bmp.huff
image.bmp.huff
jabberwocky.txt
jabberwocky.txt.huff
mission.huff
short.txt.huff
sounds.mp3.huff
triangles.txt.huff
zorro.txt.huff
Here is my workspace with the example files.

Extra Files

3. Create the Java classes in edu.ics211.h11
BitReader.java
BitWriter.java
HexFileDump.java
HuffmanNode.java
Huffman.java
4. Implement the missing methods in Huffman.java
The Huffman constructor that takes a BitReader.
public Huffman(BitReader input) throws IOException {
    throw new UnsupportedOperationException("You have not implemented this yet.");
}
The BitReader will be at the start of the pre-order traversal of the Huffman tree. Internal nodes are indicated by a 0 bit. Leaf nodes are indicated by a 1 bit followed by the byte that represents the data in the node. Think about the steps of building the root from the pre-order traversal.

Pre-order traversal:

Visit the node,
Traverse left,
Traverse right.
The decode method.
public void decode(int bytes, BitReader in, OutputStream out) throws IOException {
    throw new UnsupportedOperationException("You have not implemented this yet.");
}
Given that you have built the Huffman tree, now decode the number of bytes based upon the encoding from the BitReader, writing out each byte to the out. You probably want to write a recursive helper method to traverse the tree based upon the encoding from the BitReader, 0 means go left, 1 go right, until you get to a leaf node then output the byte.

The decompress method.
public static void decompress(InputStream in, OutputStream out) throws IOException {
    throw new UnsupportedOperationException("You have not implemented this yet.");
}
Think about the steps needed to decompress the InputStream writing it to the OutputStream.

The InputStream will be at the beginning of the .huff file. The .huff file will contain the following segments in this order:

count: 4 bytes (an int) containing a count of the number of bytes in the original uncompressed file.
tree data: A pre-order traversal of the Huffman tree used, with 0 marking internal nodes and 1 marking leaf nodes. Every leaf node (1) is followed by 8 bits containing the byte of data for that leaf node. Every tree will have at least one internal node at the root.
traversal data: A series of paths that each start at the root and lead to a leaf node that specifies the corresponding symbol in the original file. A 0 bit means go left, a 1 bit means go right. The valid traversal data ends when count symbols have been decoded. There may be extra bits remaining to complete the last byte of the file.
How can you use the two previous methods to solve this problem?

Hint: The BitReader class has the method readInt that returns an Integer from the InputStream.

Hint2: You can create an instance of Huffman from a BitReader.

5. Create a H11Huffman class
Your program should take a filename as a command line argument. If no such argument is given, print a usage message explaining what the program does and how to use it.

If the filename ends with a “.huff” extension, decompress the file. Remove the .huff extension to get the output filename. For example, if you run your program as

$ java H11Huffman homework.txt.huff
your program will decompress homework.txt.huff into homework.txt.

If the filename does not end with a “.huff” extension, what your program does is up to you (so long as it doesn’t crash). You can compress the given file instead (using the code given below), or you can just print an error message and quit. If the file you are extracting to (such as homework.txt in the example above) already exists, it is also up to you whether to simply overwrite it or to ask the user if they would like to abort.

Testing
You must also build your own test code to make sure that your implementation works. Please thoroughly test your code and briefly discuss your testing strategy. Turn in all test code.

Grading Rubric
Criterion	Excellent (100%)	Satisfactory (75%)	Borderline (50%)	Unsatisfactory (25%)	Poor (0)
Adherence to standards - 2 points
Does it conform to standards in every detail?	No errors.	Minor details of the assignment are violated, or poor choices are made where the assignment is unclear.	Significant details of the assignment or the underlying program intent are violated, but the program still fulfills essential functions.	Significant details of the assignment or the underlying program intent are violated, but the program still fulfills some essential functions.	Misses the point of the assignment.
Breakdown (modular design) - 1 point
Does it demonstrate good modular design?	No errors.	1-3 minor errors.	> 3 minor errors OR 1 major error.	2 major errors	> 2 major error.
Correctness of code - 4 points
Does it work? Does it pass JUnit?	Passes all tests.	Works for typical input, may fail for minor special cases.	Fails for typical input, for a minor reason.	Fails for typical input, for a major reason.	No.
Documentation, and style - 2 points
Is it clear and maintainable? Does it pass CheckStyle? Are your steps documented?	No errors.	1-3 minor errors.	> 3 minor errors OR 1 major error.	2 major errors	> 2 major error.
Efficiency of code - 1 point
Does it use the Java features well?	No errors.	1-3 minor errors.	> 3 minor errors OR 1 major error.	2 major errors	> 2 major error.
Turning in the Assignment
The assignment is due on Friday at 11:55pm. You may turn it in early.

Does your code follow the Java Coding Standard and pass CheckStyle?
Does your code pass the your tests?
Export your project following the instructions at the bottom of the page. Name the file H11.zip
Sign into Laulima, then navigate to the ICS211 site. In the left hand side of the site, there is an Assignments tab/link. Click on it and view all of the posted assignments. Select the assignment that you want to turn in and attach your H11.zip file accept the honor pledge to submit the assignment. Yes, the pledge says you worked alone, but in ICS 211 you can work together as long as you give credit to you teammates. See the Giving Credit screen cast.
