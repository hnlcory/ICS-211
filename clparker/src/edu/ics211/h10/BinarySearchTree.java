/**
 * 
 */
package edu.ics211.h10;

import java.util.Comparator;
import java.util.List;

/**
 * @author Cory Parker
 * @param <E> the type.
 */
public class BinarySearchTree<E> implements SearchTree<E>, InOrder<E> {
  private BinaryNode root;
  private Comparator<E> comp;
  private boolean addReturn;
  private E deletedReturn;
  
  public BinarySearchTree(Comparator<E> comp) {
    //init member variables.
  }

  @Override
  public List<E> inorder() {
    // create return list
    // do the inorder traversal
    //return the list
    return null;
  }
  
  private void inorder(BinaryNode node, List<E> list) {
    //base case if node is null
    //else
    //  visit left child
    //  visit node list.add(node.item)
    //  visit right child
    
  }

  @Override
  public boolean add(E item) {
    // root = add(root, item)
    //return addReturn
    return false;
  }

  private BinaryNode add(BinaryNode node, E item) {
    //if node is null, return new BinaryNode(item,nll,null)
    //compare item to node.item
    //if equal, addReturn is false, return node
    //if item > node.item, node.right = add(node.right,item)
    //else node.left = add(node.left, item)
    return null;
  }

  @Override
  public boolean contains(E item) {
    // return find(item) != null
    return false;
  }


  @Override
  public E find(E target) {
    // return find(root,target)
    return null;
  }

  private E find(BinaryNode node, E target) {
    //if node is null, return null
    //compare target and node.item
    //if equal, return node.itme
    //if target < node.item, return find(node.left,targer)
    //return find(node.right,target)
    return null;
  }

  @Override
  public E delete(E target) {
    // root = delete(root,target)
    // return deleteReturn
    return null;
  }
  
  private BinaryNode delete(BinaryNode node, E target) {
    // if node is null, deleteReturn = null, return node
    // compare target to node.item
    // if less than, node.left = delete(node.left, target)
    // if greater node.right = delete(node.right,target)
    // if equal 
    //  deleteReturn = node.item
    //  if node.left and node.right are null, return null
    //  else if node.left = null, return node.right
    //  else if node.right = null, return node.left
    //  else find largest of left child or smallest of right child**** textbook code
    return null;
  }
  
  @Override
  public boolean remove(E target) {
    // return delete(target) != null
    return false;
  }

  private class BinaryNode{
    E item;
    BinaryNode left;
    BinaryNode right;
    
    public BinaryNode(E item, BinaryNode left, BinaryNode right) {
      this.item =item;
      this.left =left;
      this.right =right;
    }
    
  }
}
