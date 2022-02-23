/**
 * This file contains all the public tests (visible on Gradescope)
 * Use this as a guide to write tests to verify your MyMinHeap and 
 * MyPriorityQueue implementation 
 */
import org.junit.*;
import static org.junit.Assert.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * This class contains public test cases for MyMinHeap and MyPriorityQueue
 */
public class MyMinHeapPublicTester {

    // ===================== MyMinHeap Public Tests =====================

    /**
     * Helper method to initialize all instance variables of MyDeque
     * 
     * @param meanHeap The heap to initialize
     * @param data     The data array
     */
    static void initMinHeap(MyMinHeap<Integer> heap, List<Integer> list) {
        heap.list = new ArrayList<>(list);
    }

    /** Test the MyMinHeap default constructor without any input parameter */
    @Test
    public void testMinHeapConstructorNon() {
        MyMinHeap<Integer> minHeap = new MyMinHeap<>();
        assertEquals("Data List should be empty", 0, minHeap.list.size());
    }

    /** Test the MyMinHeap constructor with input data list */
    @Test
    public void testMinHeapConstructorDataList() {
        List<Integer> inputList = Arrays.asList(
                new Integer[] { 5, 4, 1, 7, 2, 9, 6, 3 });
        MyMinHeap<Integer> minHeap = new MyMinHeap<>(inputList);
        Integer[] expected = { 1, 2, 5, 3, 4, 9, 6, 7 };
        for (int i = 0; i < 8; i++) {
            assertEquals(
                    "MinHeap order should be implemented",
                    expected[i],
                    minHeap.list.get(i));
        }
    }

    /** Test the MyMinHeap swap function */
    @Test
    public void testMinHeapSwap() {
        MyMinHeap<Integer> heap = new MyMinHeap<>();
        List<Integer> startingList = Arrays.asList(new Integer[] { 3, 1, 2 });
        initMinHeap(heap, startingList);
        heap.swap(0, 1);
        Integer[] expected = { 1, 3, 2 };
        for (int i = 0; i < 3; i++) {
            assertEquals(
                    "Heap after swapping should have elements swapped. ",
                    expected[i],
                    heap.list.get(i));
        }
    }

    /** Test the MyMinHeap getParentIdx function when the heap is empty */
    @Test
    public void testMinHeapGetParentIdx() {
        MyMinHeap<Integer> heap = new MyMinHeap<>();
        List<Integer> startingList = Arrays.asList(new Integer[] {});
        initMinHeap(heap, startingList);
        assertEquals("Parent index of 1", 0, heap.getParentIdx(1));
        assertEquals("Data List should still be empty", 0, heap.list.size());
    }

    /** Test the MyMinHeap getLeftChildIdx function when the heap is empty */
    @Test
    public void testMinHeapGetLeftChildIdx() {
        MyMinHeap<Integer> heap = new MyMinHeap<>();
        List<Integer> startingList = Arrays.asList(new Integer[] {});
        initMinHeap(heap, startingList);
        assertEquals("Left child index of 0", 1, heap.getLeftChildIdx(0));
        assertEquals("Data List should still be empty", 0, heap.list.size());
    }

    /** Test the MyMinHeap getRightChildIdx function when the heap is empty */
    @Test
    public void testMinHeapGetRightChildIdx() {
        MyMinHeap<Integer> heap = new MyMinHeap<>();
        List<Integer> startingList = Arrays.asList(new Integer[] {});
        initMinHeap(heap, startingList);
        assertEquals("Right child index of 0", 2, heap.getRightChildIdx(0));
        assertEquals("Data List should still be empty", 0, heap.list.size());
    }

    /** Test the MyMinHeap getMinChildIdx function */
    @Test
    public void testMinHeapGetMinChildIdx() {
        MyMinHeap<Integer> heap = new MyMinHeap<>();
        List<Integer> startingList = Arrays.asList(new Integer[] { 5, 3, 2 });
        initMinHeap(heap, startingList);
        assertEquals("Minimum child index of 0", 2, heap.getMinChildIdx(0));
        Integer[] expected = { 5, 3, 2 };
        for (int i = 0; i < 3; i++) {
            assertEquals(
                    "Heap after getting minimum child index should be unchanged. ",
                    expected[i],
                    heap.list.get(i));
        }
    }

    /** Test the MyMinHeap perlocateUp function */
    @Test
    public void testMinHeapPercolateUp() {
        MyMinHeap<Integer> heap = new MyMinHeap<>();
        List<Integer> startingList = Arrays.asList(
                new Integer[] { 1, 4, 4, 2, 2 });
        initMinHeap(heap, startingList);
        heap.percolateUp(3);
        Integer[] expected = { 1, 2, 4, 4, 2 };
        for (int i = 0; i < 5; i++) {
            assertEquals(
                    "Heap after getting minimum child index should be unchanged. ",
                    expected[i],
                    heap.list.get(i));
        }
    }

    /** Test the MyMinHeap perlocateDown function */
    @Test
    public void testMinHeapPercolateDown() {
        MyMinHeap<Integer> heap = new MyMinHeap<>();
        List<Integer> startingList = Arrays.asList(
            new Integer[] { 8, 4, 3, 5, 2 }
        );
        initMinHeap(heap, startingList);
        heap.percolateDown(0);
        Integer[] expected = { 3, 4, 8, 5, 2 };
        for (int i = 0; i < 5; i++) {
            assertEquals(
                "Heap after getting minimum child index should be unchanged. ", 
                expected[i], 
                heap.list.get(i)
            );
        }
    }

    /** Test the MyMinHeap deleteIndex function */
    @Test
    public void testMinHeapDeleteIndex() {
        MyMinHeap<Character> heap = new MyMinHeap<>();
        List<Character> startingList = Arrays.asList(
            new Character[] { 'A', 'D', 'D', 'E', 'Z', 'X', 'G' }
        );
        heap.list = new ArrayList<>(startingList);
        heap.deleteIndex(0);
        Character[] expected = { 'D', 'E', 'D', 'G', 'Z', 'X' };
        for (int i = 0; i < 6; i++) {
            assertEquals(
                "Heap after deleting index 0. ", 
                expected[i], 
                heap.list.get(i)
            );
        }
    }

    /** Test the MyMinHeap insert function */
    @Test
    public void testMinHeapInsert() {
        MyMinHeap<Integer> heap = new MyMinHeap<>();
        List<Integer> startingList = Arrays.asList(
            new Integer[] { 11, 12, 13 }
        );
        initMinHeap(heap, startingList);
        heap.insert(11);
        Integer[] expected = { 11, 11, 13, 12 };
        for (int i = 0; i < 4; i++) {
            assertEquals(
                "Heap after inserting 11. ", 
                expected[i], 
                heap.list.get(i)
            );
        }
    }

    /** Test the MyMinHeap getMin function */
    @Test
    public void testMinHeapGetMin() {
        MyMinHeap<Integer> heap = new MyMinHeap<>();
        List<Integer> startingList = Arrays.asList(
            new Integer[] { 13, 18, 18 }
        );
        initMinHeap(heap, startingList);
        assertEquals("Minimum element", new Integer(13), heap.getMin());
        Integer[] expected = { 13, 18, 18 };
        for (int i = 0; i < 3; i++) {
            assertEquals(
                "Heap after getMin should not be changed. ", 
                expected[i], 
                heap.list.get(i)
            );
        }
    }

    /** Test the MyMinHeap remove function */
    @Test
    public void testMinHeapRemove() {
        MyMinHeap<Integer> heap = new MyMinHeap<>(); 
        List<Integer> startingList = Arrays.asList(
            new Integer[]{13,18,18,25,18,19}
        ); 
        heap.list = new ArrayList<>(startingList);
        Integer[] expected = {18,18,18,25,19};
        assertEquals("Minimum element", new Integer(13), heap.remove());
        assertEquals("Smaller size element", 5, heap.list.size());
        for (int i = 0; i < 5; i++) {
            assertEquals(
                "Heap after getMin should not be changed. ", 
                expected[i], 
                heap.list.get(i)
            );
        }
    }

    /** Test the MyMinHeap size function */
    @Test
    public void testMinHeapSize() {
        MyMinHeap<Integer> heap = new MyMinHeap<>();
        List<Integer> startingList = Arrays.asList(
            new Integer[] { 13, 18, 18, 25, 18, 19 }
        );
        initMinHeap(heap, startingList);
        assertEquals("Minimum element", 6, heap.size());
        Integer[] expected = { 13, 18, 18, 25, 18, 19 };
        for (int i = 0; i < 6; i++) {
            assertEquals(
                "Heap after size() should not be changed. ", 
                expected[i], 
                heap.list.get(i)
            );
        }
    }

    /** Test the MyMinHeap clear function */
    @Test
    public void testMinHeapClear() {
        MyMinHeap<Integer> heap = new MyMinHeap<>();
        List<Integer> startingList = Arrays.asList(
            new Integer[] { 13, 18, 18, 25, 18, 19 }
        );
        initMinHeap(heap, startingList);
        heap.clear();
        assertEquals("Data List should be empty", 0, heap.list.size());

    }

    // ===================== MyPriority Public Tests =====================

    /** Test the MyPriorityQueue No-arg constructor*/
    @Test
    public void testPriorityQueueNonConstructor() {
        MyMinHeap heap = new MyMinHeap();
        MyPriorityQueue pq = new MyPriorityQueue();
        assertTrue(
            "Priority queue's underlying heap is not null. ", pq.heap != null
        );
        assertEquals("Heap after no-arg constructor.", heap.list, pq.heap.list);

    }

    /** Test the MyPriorityQueue Collection-arg constructor*/
    @Test
    public void testPriorityCollectionConstructor() {
        List<Integer> startingList = Arrays.asList(
            new Integer[] { 5, 4, 1, 7, 2, 9, 6, 3 }
        );
        MyMinHeap<Integer> heap = new MyMinHeap<>(
            new ArrayList<>(startingList)
        );
        MyPriorityQueue<Integer> pq = new MyPriorityQueue<>(
            new ArrayList<>(startingList)
        );
        assertTrue(
            "Priority queue's underlying heap is not null. ", pq.heap != null
        );

        for (int i = 0; i < 8; i++) {
            assertEquals(
                "Heap after constructor builds the priority queue. ", 
                heap.list.get(i), 
                pq.heap.list.get(i)
            );
        }
    }

    /** Test the MyPriorityQueue push function */
    @Test
    public void testPriorityQueuePush() {
        MyMinHeap<Integer> heap = new MyMinHeap<>();
        MyPriorityQueue<Integer> pq = new MyPriorityQueue<>();
        List<Integer> startingList = Arrays.asList(new Integer[] { 11, 12, 13 });
        pq.heap = new MyMinHeap<>();
        pq.heap.list = new ArrayList<>(startingList);
        heap.list = new ArrayList<>(startingList);
        pq.push(11);
        heap.insert(11);
        assertTrue(
            "Priority queue's underlying heap is not null. ", pq.heap != null
        );
        for (int i = 0; i < 3; i++) {
            assertEquals(
                "Priority queue should be unchanged. ", 
                heap.list.get(i), 
                pq.heap.list.get(i)
            );
        }
    }

    /** Test the MyPriorityQueue peek function*/
    @Test
    public void testPriorityQueuePeek() {
        MyMinHeap<Integer> heap = new MyMinHeap<>();
        MyPriorityQueue<Integer> pq = new MyPriorityQueue<>();
        List<Integer> startingList = Arrays.asList(new Integer[] { 13, 18, 18 });
        pq.heap = new MyMinHeap<>();
        pq.heap.list = new ArrayList<>(startingList);
        heap.list = new ArrayList<>(startingList);
        assertTrue(
            "Priority queue's underlying heap is not null. ", pq.heap != null
        );
        assertEquals(
            "Minimum element of [13,18,18]. ",
            heap.getMin(), 
            pq.peek()
        );
        
        for (int i = 0; i < 3; i++) {
            assertEquals(
                "Priority queue should be unchanged. ", 
                heap.list.get(i), 
                pq.heap.list.get(i)
            );
        }
    }

    /** Test the MyPriorityQueue Pop function*/
    @Test
    public void testPriorityQueuePop() {
        MyMinHeap<Integer> heap = new MyMinHeap<>();
        MyPriorityQueue<Integer> pq = new MyPriorityQueue<>();
        List<Integer> startingList = Arrays.asList(
            new Integer[] { 13, 18, 18, 25, 18, 19 }
        );
        pq.heap = new MyMinHeap<>();
        pq.heap.list = new ArrayList<>(startingList);
        heap.list = new ArrayList<>(startingList);
        assertTrue(
            "Priority queue's underlying heap is not null. ", pq.heap != null
        );
        assertEquals(
            "Highest priority (removed) element of [13,18,18,25,18,19]. ",
            heap.remove(), 
            pq.pop()
        );
        assertEquals(
            "Smaller size after the removal",
            5, 
            pq.heap.list.size()
        );
        
        for (int i = 0; i < 5; i++) {
            assertEquals(
                "Priority queue should be unchanged. ", 
                heap.list.get(i), 
                pq.heap.list.get(i)
            );
        }
    }

    /** Test the MyPriorityQueue size function*/
    @Test
    public void testPriorityQueueSize() {
        MyMinHeap<Integer> heap = new MyMinHeap<>();
        MyPriorityQueue<Integer> pq = new MyPriorityQueue<>();
        List<Integer> startingList = Arrays.asList(
            new Integer[] { 13, 18, 18, 25, 18, 19 }
        );
        pq.heap = new MyMinHeap<>();
        pq.heap.list = new ArrayList<>(startingList);
        heap.list = new ArrayList<>(startingList);

        assertTrue(
            "Priority queue's underlying heap is not null. ", pq.heap != null
        );
        assertEquals(
            "Length of [13,18,18,25,18,19]. ",
            heap.size(), 
            pq.getLength()
        );

        
        for (int i = 0; i < 5; i++) {
            assertEquals(
                "Priority queue should be unchanged. ", 
                heap.list.get(i), 
                pq.heap.list.get(i)
            );
        }
    }

    /** Test the MyPriorityQueue Clear function*/
    @Test
    public void testPriorityQueueClear() {
        MyMinHeap<Integer> heap = new MyMinHeap<>();
        MyPriorityQueue<Integer> pq = new MyPriorityQueue<>();
        List<Integer> startingList = Arrays.asList(
            new Integer[] { 13, 18, 18, 25, 18, 19 }
        );
        pq.heap = new MyMinHeap<>();
        pq.heap.list = new ArrayList<>(startingList);
        heap.list = new ArrayList<>(startingList);
        pq.clear();
        heap.clear();

        assertTrue(
            "Priority queue's underlying heap is not null. ", pq.heap != null
        );
        assertEquals(
            "Length of [13,18,18,25,18,19]. ",
            0, 
            pq.heap.list.size()
        );
    }
}