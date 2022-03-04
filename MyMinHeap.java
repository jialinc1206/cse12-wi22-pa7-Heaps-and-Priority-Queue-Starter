/**
 * Name: Jialin Chen
 * Email: jic053@ucsd.edu
 * Sources used: comments from:
 * https://docs.google.com/document/d/1t6_VxtZoaw8-LEL2aTbc5_ovkSZ4JTHCTH7_GdfShEg/edit
 * 
 * this is a implementation of mini heap that will be used
 * to run a simulation of the Autograder Ticket System
 */

import java.util.ArrayList;
import java.util.Collection;

/**
 * includes helper methods that are useful to 
 * implement the actual functionality of MyMinHeap
 * as well as core methods.
 */
public class MyMinHeap<E extends Comparable<E>> implements MinHeapInterface <E>{

    public ArrayList<E> data;

    /**
     * No-argument constructor that initializes data to an empty ArrayList
     */
    public MyMinHeap() {
        data = new ArrayList<E>();
    }

    /**
     * Initializes a min-heap using the elements in collection
     * @param collection used to initialize data
     */
    public MyMinHeap(Collection<? extends E> collection) {
        if(collection == null)
            throw new NullPointerException();
        data = (ArrayList<E>) collection;
        for(int i = data.size() - 1; i >= 0; i--)
            percolateDown(i);
    }

    /**
     * Swap the elements at from and to indices in data.
     * @param from start index
     * @param to end index
     */
    protected void swap(int from, int to) {
        // save sawped element
        E swap = data.get(from);
        
        data.set(from, data.get(to));
        data.set(to, swap);
    }

    /**
     * Calculate and return the parent index of the parameter index
     * @param index calculate index
     * @return parent index
     */
    protected int getParentIdx(int index) {
        return (index - 1) / 2;
    }

    /**
     * Calculate and return the left child index of the parameter index
     * @param index calculate index
     * @return left child index
     */
    protected int getLeftChildIdx(int index) {
        return index * 2 + 1;
    }

    /**
     * Calculate and return the right child index of the parameter index
     * @param index calculate index
     * @return right child index
     */
    protected int getRightChildIdx(int index) {
        return (index + 1) * 2;
    }

    /**
     * Return the index of the smaller child of the element at index
     * @param index calculate index
     * @return smaller child index
     */
    protected int getMinChildIdx(int index) {
        if(getLeftChildIdx(index) >= data.size())
            return -1;
        if(getRightChildIdx(index) >= data.size())
            return getLeftChildIdx(index);

        // see who's greater if both children exist
        if(data.get(getRightChildIdx(index)).compareTo
        (data.get(getLeftChildIdx(index))) >= 0 )
            return getLeftChildIdx(index);
        else  
            return getRightChildIdx(index);
    }

    /**
     * Percolate the element at index up until no heap 
     * properties are violated by this element
     * @param index moving index
     */
    protected void percolateUp(int index) {
        int cur = index;
        while(data.get(getParentIdx(cur)).compareTo(data.get(cur)) > 0) {
            swap(getParentIdx(cur), cur);

            cur = getParentIdx(cur);
        }
    }

    /**
     * Percolate the element at index down until no heap 
     * properties are violated by this element
     * @param index moving index
     */
    protected void percolateDown(int index) {
        int cur = index;
        E temp = data.get(index);

        while(getMinChildIdx(cur) > -1 && data.get
        (getMinChildIdx(cur)).compareTo(data.get(cur)) < 0) {
            swap(getMinChildIdx(cur), cur);

            cur = data.indexOf(temp);
        }
    }

    /**
     * Remove the element at index from data and return it
     * @param index
     * @return
     */
    protected E deleteIndex(int index) {

        E temp = data.get(index);

        // If we are removing the last element then 
        // the heap properties are maintained
        if(index == data.size() - 1) {
            data.remove(index);
            return temp;
        }

        // replace the deleted element with the last element in the heap
        swap(index, data.size() - 1);
        data.remove(data.size() - 1);
        percolateDown(index);
        percolateUp(index);
        return temp;
    }

    @Override
    public void insert(E element) {
        if(element == null)
            throw new NullPointerException();
            
        data.add(element);
        percolateUp(data.size() - 1);
    }

    @Override
    public E getMin() {
        if(data.isEmpty())
            return null;

        return data.get(0);
    }

    @Override
    public E remove() {
        if(data.isEmpty())
            return null;
        return deleteIndex(0);
    }

    @Override
    public int size() {
        return data.size();
    }

    @Override
    public void clear() {
        data.clear();
    }

}