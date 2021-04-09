/**
 * A binary tree to store data.
 * @author Cory Parker.
 */

package edu.ics211.h10;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Binary tree for generic data.
 * 
 * @author Cory Parker.
 * @param <E> the type.
 */
public class BinarySearchTree<E> implements SearchTree<E>, InOrder<E> {
  private BinaryNode root;
  private Comparator<E> comp;
  private boolean addReturn;
  private E deletedReturn;

  /**
   * Initalize binary tree.
   * 
   * @author Cory Parker.
   * @param comp comparator.
   */
  public BinarySearchTree(Comparator<E> comp) {
    // init member variables
    this.comp = comp;
    this.root = null;
  }


  @Override
  public List<E> inorder() {
    // create return list
    List<E> returnList;
    returnList = new ArrayList<E>();
    // do the inorder traversal
    inorder(root, returnList);
    // return the list
    return returnList;
  }


  private void inorder(BinaryNode node, List<E> list) {
    // base case if node is null
    // else
    // visit left child
    // visit node list.add(node.item)
    // visit right child
    if (node != null) {
      inorder(node.left, list);
      list.add(node.item);
      inorder(node.right, list);
    }

  }


  @Override
  public boolean add(E item) {
    root = add(root, item);
    return addReturn;

  }


  private BinaryNode add(BinaryNode node, E item) {
    // if node is null, return new BinaryNode(item,nll,null)
    if (node == null) {
      addReturn = true;
      return new BinaryNode(item, null, null);
    } else if (comp.compare(item, node.item) == 0) {
      // compare item to node.item)
      // if equal, addReturn is false, return node
      addReturn = false;
      return node;
    } else if (comp.compare(item, node.item) > 0) {
      // if item > node.item, node.right = add(node.right,item)
      node.right = add(node.right, item);
      return node;
    } else {
      // else node.left = add(node.left, item)
      node.left = add(node.left, item);
      return node;
    }
  }


  @Override
  public boolean contains(E item) {
    return find(item) != null;

  }


  @Override
  public E find(E target) {
    return find(root, target);
  }


  private E find(BinaryNode node, E target) {
    // if node is null, return null
    if (node == null) {
      return null;
    } else if (comp.compare(target, node.item) == 0) {
      // compare target and node.item
      // if equal, return node.itme
      return node.item;
    } else if (comp.compare(target, node.item) < 0) {
      // if target < node.item, return find(node.left,target)
      return find(node.left, target);
    }
    // return find(node.right,target)
    return find(node.right, target);
  }


  @Override
  public E delete(E target) {
    root = delete(root, target);
    return deletedReturn;
  }


  private BinaryNode delete(BinaryNode node, E target) {
    // if node is null, deleteReturn = null, return node
    if (node == null) {
      deletedReturn = null;
      return node;
    }
    // compare target to node.item
    // if less than, node.left = delete(node.left, target)
    if (comp.compare(target, node.item) < 0) {
      node.left = delete(node.left, target);
      return node;
    } else if (comp.compare(target, node.item) > 0) {
      // if greater node.right = delete(node.right,target)
      node.right = delete(node.right, target);
      return node;
    } else {
      // if equal
      // deleteReturn = node.item
      deletedReturn = node.item;
      // if node.left and node.right are null, return null
      if (node.left == null && node.right == null) {
        return null;
      } else if (node.left == null) {
        // else if node.left = null, return node.right
        return node.right;
      } else if (node.right == null) {
        // else if node.right = null, return node.left
        return node.left;
      } else {
        // else find largest of left child or smallest of right child**** textbook code
        if (node.left.right == null) {
          node.item = node.left.item;
          node.left = node.left.left;
          return node;
        } else {
          node.item = findLargestChild(node.left);
          return node;
        }

      }

    }

  }


  /**
   * Finds the largest child of parent.
   * 
   * @author Carleton Moore.
   * @param parent the parent.
   * @return largest child node.
   */
  private E findLargestChild(BinaryNode parent) {
    if (parent.right.right == null) {
      E returnValue = parent.right.item;
      parent.right = parent.right.left;
      return returnValue;
    } else {
      return findLargestChild(parent.right);
    }
  }


  @Override
  public boolean remove(E target) {
    return delete(target) != null;
  }

  private class BinaryNode {
    E item;
    BinaryNode left;
    BinaryNode right;

    public BinaryNode(E item, BinaryNode left, BinaryNode right) {
      this.item = item;
      this.left = left;
      this.right = right;
    }

  }
}
