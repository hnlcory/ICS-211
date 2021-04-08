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
    //init member variables
    this.comp = comp;
    this.root = null;
  }

  @Override
  public List<E> inorder() {
    // create return list
    List<E> returnList;
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
    root = add(root, item);
    return addReturn;
    
  }

  private BinaryNode add(BinaryNode node, E item) {
    //if node is null, return new BinaryNode(item,nll,null)
    if (node == null) {
      return new BinaryNode(item,null,null);
    }
    //compare item to node.item)
    //if equal, addReturn is false, return node
    else if (comp.compare(item,node.item) == 0) {
      return node;
    }
    //if item > node.item, node.right = add(node.right,item)
    else if (comp.compare(item,node.item) > 0) {
      node.right = add(node.right,item);
      return node;
    }
    //else node.left = add(node.left, item)
    else {
      node.left = add(node.left,item);
      return node;
    }
  }

  @Override
  public boolean contains(E item) {
    return find(item) != null;
   
  }


  @Override
  public E find(E target) {
    return find(root,target);
  }

  private E find(BinaryNode node, E target) {
    //if node is null, return null
    if (node == null) {
      return null;
    }
    //compare target and node.item
    //if equal, return node.itme
    else if (comp.compare(target,node.item) == 0) {
      return node.item;
    }
    //if target < node.item, return find(node.left,target)
    else if (comp.compare(target,node.item) > 1) {
      return find(node.left,target);
    }
    //return find(node.right,target)
    return find(node.right,target);
  }

  @Override
  public E delete(E target) {
    root = delete(root,target);
    return deletedReturn;
  }
  
  private BinaryNode delete(BinaryNode node, E target) {
    // if node is null, deleteReturn = null, return node
    if (node == null) {
      deletedReturn =null;
      return node;
    }
    // compare target to node.item
    // if less than, node.left = delete(node.left, target)
    if (comp.compare(target, node.item) < 0) {
      delete(node.left,target);
    }
    // if greater node.right = delete(node.right,target)
    if (comp.compare(target, node.item) > 0) {
      delete(node.right,target);
    }
    // if equal 
    //  deleteReturn = node.item
    
   
    if (comp.compare(target, node.item) == 0) {
      deletedReturn = node.item;
      //  if node.left and node.right are null, return null
      if (node.left == null && node.right == null) {
        return null;
      }
      //  else if node.left = null, return node.right
      else if (node.left ==null) {
        return node.right;
      }
      //  else if node.right = null, return node.left
      else if (node.right==null) {
        return node.left;
      }
      //  else find largest of left child or smallest of right child**** textbook code
      else {
        node.item = findLargestChild(node.left);
        return node;
      }
    }
  }
  
  private E findLargestChild(BinaryNode parent){// txtbook code
   if (parent.right.right==null) {
     E returnValue = parent.right.item;
     parent.right = parent.right.left;
     return returnValue;
   }
   else {
     return findLargestChild(parent.right);
   }
  }
  
  @Override
  public boolean remove(E target) {
    return delete(target) != null;
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
