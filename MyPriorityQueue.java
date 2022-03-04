/**
 * Name: Jialin Chen
 * Email: jic053@ucsd.edu
 * Sources used: comments from:
 * https://docs.google.com/document/d/1t6_VxtZoaw8-LEL2aTbc5_ovkSZ4JTHCTH7_GdfShEg/edit
 * 
 * a MyPriorityQueue.java file that already contains the 
 * implementation of a Priority Queue using MyMinHeap
 */

import java.util.Collection;

/**
 * a priority queue class that contains core mehtods
 * for it to function.
 */
public class MyPriorityQueue<E extends Comparable<E>>
{

    public MyMinHeap<E> heap;
    
    /**
     * Constructor that creates an empty priority queue
     */
    public MyPriorityQueue(){
        heap = new MyMinHeap<>();
    }

    /**
     * Constructor that creates a priority queue from a collection
     * @param collection The collection used to intialize priority queue
     */
    public MyPriorityQueue(Collection<? extends E> collection){
        heap = new MyMinHeap<>(collection);
    }

    /**
     * Adds an element to the priority queue
     * @param element the element to be added
     */
    public void push(E element){
        heap.insert(element);
    }

    /**
     * Removes the element with the highest priority from the priority queue 
     * @return the element with the highest priority
     */
    public E pop(){
        return heap.remove();
    }

    /**
     * Sees the element with the highest priority from the priority queue
     * @return the element with the highest priority
     */
    public E peek(){
        return heap.getMin();
    }

    /**
     * Finds the number of elements in the priority queue
     * @return the number of elements in the priority queue
     */
    public int getLength(){
        return heap.size();
    }

    /**
     * Remove all the elements from the priority queue.
     */
    public void clear(){
        heap.clear();
    }
}