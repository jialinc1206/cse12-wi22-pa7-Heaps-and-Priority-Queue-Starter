/**
 * Name: Jialin Chen
 * Email: jic053@ucsd.edu
 * Sources used: comments from
 * https://docs.google.com/document/d/1t6_VxtZoaw8-LEL2aTbc5_ovkSZ4JTHCTH7_GdfShEg/edit
 * 
 * this file contains custom tests that are not
 * included in the public test for MyMinHeap class.
 */

import org.junit.*;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * includes various test for methods in MyMinHeap class.
 * 
 * IMPORTANT: Do not change the method names and points are awarded
 * only if your test cases cover cases that the public tester file
 * does not take into account.
 */
public class CustomTester {
    
    /**
     * Test the constructor when input is null
     */
    @Test
    public void testMyMinHeapConstructor() {
        try {
            MyMinHeap<Integer> minHeap = new MyMinHeap<>(null);
            fail();
        } catch (Exception e) {
            //exception caught
        }
    }

    /**
     * Test the getMinChildIdx method when the index is leaf
     */
    @Test
    public void testGetMinChildIdx() {
        ArrayList<Integer> list = new ArrayList<Integer>(
            Arrays.asList(
                new Integer[] { 1, 3, 2 }
            )
        );
        MyMinHeap<Integer> heap = new MyMinHeap<>(list);
        assertEquals("no minChild", -1, heap.getMinChildIdx(1));
    }

    /**
     * Test the percolateUp method when no action is needed
     */
    @Test
    public void testPercolateUp() {
        ArrayList<Integer> list = new ArrayList<Integer>(
            Arrays.asList(
                new Integer[] { 1, 2, 3, 4, 5, 6, 7 }
            )
        );
        MyMinHeap<Integer> heap = new MyMinHeap<>(list);
        heap.percolateUp(3);

        Integer[] expected = { 1, 2, 3, 4, 5, 6, 7};
        for (int i = 0; i < 7; i++) {
            assertEquals(
                    "no action for PercolateUp ",
                    expected[i],
                    heap.data.get(i));
        }
    }

    /**
     * Test the percolateDown method when no action is needed
     */
    @Test
    public void testPercolateDown() {
        ArrayList<Integer> list = new ArrayList<Integer>(
            Arrays.asList(
                new Integer[] { 1, 2, 3, 4, 5, 6, 7 }
            )
        );
        MyMinHeap<Integer> heap = new MyMinHeap<>(list);
        heap.percolateDown(3);

        Integer[] expected = { 1, 2, 3, 4, 5, 6, 7};
        for (int i = 0; i < 7; i++) {
            assertEquals(
                    "no action for PercolateDown ",
                    expected[i],
                    heap.data.get(i));
        }
    }

    /**
     * Test the deleteIndex method when index 
     * is the end of the heap
     */
    @Test
    public void testDeleteIndex() {
        ArrayList<Integer> list = new ArrayList<Integer>(
            Arrays.asList(
                new Integer[] { 1, 2, 3, 4, 5, 6, 7 }
            )
        );
        MyMinHeap<Integer> heap = new MyMinHeap<>(list);
        heap.deleteIndex(6);

        Integer[] expected = { 1, 2, 3, 4, 5, 6};
        for (int i = 0; i < 6; i++) {
            assertEquals(
                    "delete index at end",
                    expected[i],
                    heap.data.get(i));
        }
    }

    /**
     * Test the deleteIndex method when index 
     * is in the middle of the heap
     */
    @Test
    public void testDeleteIndex2() {
        ArrayList<Integer> list = new ArrayList<Integer>(
            Arrays.asList(
                new Integer[] { 1, 2, 3, 4, 5, 6, 7 }
            )
        );
        MyMinHeap<Integer> heap = new MyMinHeap<>(list);
        heap.deleteIndex(2);

        Integer[] expected = { 1, 2, 6, 4, 5, 7};
        for (int i = 0; i < 6; i++) {
            assertEquals(
                    "delete index in middle ",
                    expected[i],
                    heap.data.get(i));
        }
    }

    /**
     * Test the insert method when element is null
     */
    @Test
    public void testInsert(){
        ArrayList<Integer> list = new ArrayList<Integer>(
            Arrays.asList(
                new Integer[] { 1, 3, 2 }
            )
        );
        MyMinHeap<Integer> heap = new MyMinHeap<>(list);
        try {
            heap.insert(null);
            fail();
        } catch (Exception e) {
            //exception caught
        }
    }

    /**
     * Test the insert method when inserted 
     * element disrubts the order
     */
    @Test
    public void testInsert2(){
        ArrayList<Integer> list = new ArrayList<Integer>(
            Arrays.asList(
                new Integer[] {  1, 3, 2 }
            )
        );
        MyMinHeap<Integer> heap = new MyMinHeap<>(list);
        heap.insert((Integer)1);

        Integer[] expected = { 1, 1, 2, 3};
        for (int i = 0; i < 4; i++) {
            assertEquals(
                    "insert to distube order",
                    expected[i],
                    heap.data.get(i));
        }
    }

   
    /**
     * Test remove when the heap is empty
     */
    @Test
    public void testRemove(){
        MyMinHeap<Integer> heap = new MyMinHeap<>();
        assertEquals(
                "remove empty heap",
                heap.remove(),
                null);
    }

  
    /**
     * Test getMin when the heap is empty
     */
    @Test
    public void testGetMin(){
        MyMinHeap<Integer> heap = new MyMinHeap<>();
        assertEquals(
                "getMin empty heap",
                heap.getMin(),
                null);
    }
}