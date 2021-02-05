/**
 * 
 */
package edu.ics211.h04;

import edu.ics211.h02.Cloud;
import java.util.Comparator;

/**
 * @author Cory Parker
 *
 */
public class SortedCloudList implements IList211<Cloud> {
  private SortableList<Cloud> list;
  private Comparator<Cloud> comp;
  
  /**
   * 
   */
  public SortedCloudList(Comparator<Cloud> comp) {
    super();
    this.list = new SortableList<Cloud>();
    this.comp = comp;
    // TODO Auto-generated constructor stub
  }

  @Override
  public Cloud get(int index) {
    return list.get(index);
  }

  @Override
  public Cloud set(int index, Cloud element) {  
    Cloud temp =list.set(index, element);// remmeber cloud 
    list.bubbleSort(this.comp);
    return temp;
  }

  @Override
  public int indexOf(Object obj) {
    return list.indexOf(obj);
  }

  @Override
  public int size() {
    return list.size();
  }

  @Override
  public boolean add(Cloud e) {
    boolean temp = list.add(e);//remember list.add(e);
    list.bubbleSort(this.comp); //sort list
    return temp;//return memory
  }

  @Override
  public void add(int index, Cloud element) {
    list.add(index, element);
    
  }

  @Override
  public Cloud remove(int index) {
    return list.remove(index);
  }

}
