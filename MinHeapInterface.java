/**
 * An interface that specifid the functionality of a Min Heap
 */
public interface MinHeapInterface<E extends Comparable<E>>{

  public void insert(E element);

  public E getMin() ;

  public E remove() ;

  public int size();

  public void clear();
}