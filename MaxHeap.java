
// import java.util.Arrays;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;

/**
 * A class that implements the ADT maxheap by using an array.
 * 
 * @author
 * @author
 * @version
 */
public final class MaxHeap<T extends Comparable<? super T>>
      implements MaxHeapInterface<T> {
   private T[] heap; // Array of heap entries; ignore heap[0]
   private int lastIndex; // Index of last entry and number of entries
   private boolean integrityOK = false;
   private static final int DEFAULT_CAPACITY = 25;
   private static final int MAX_CAPACITY = 10000;
   public int SequencialSwaps;
   public int OptimalSwaps;
   private String[] arr;

   private void checkCapacity(int desiredCapacity) {
      if (desiredCapacity > MAX_CAPACITY)
         throw new IllegalStateException("Error: capacity exceeds ");
   }

   public void FirstTenEntry() {
      for (int i = 1; i < 11; i++) {
         System.out.print(heap[i] + ", ");
      }
   }

   public MaxHeap() {
      this(DEFAULT_CAPACITY); // Call next constructor
   } // end default constructor

   public MaxHeap(int initialCapacity) {
      // Is initialCapacity too small?
      if (initialCapacity < DEFAULT_CAPACITY)
         initialCapacity = DEFAULT_CAPACITY;
      else // Is initialCapacity too big?
         checkCapacity(initialCapacity);

      // The cast is safe because the new array contains null entries
      @SuppressWarnings("unchecked")
      T[] tempHeap = (T[]) new Comparable[initialCapacity + 1];
      heap = tempHeap;
      lastIndex = 0;
      integrityOK = true;
   } // end constructor

   public MaxHeap(T[] entries) {
      this(entries.length); // Call other constructor
      lastIndex = entries.length;
      // Assertion: integrityOK = true

      // Copy given array to data field
      for (int index = 0; index < entries.length; index++)
         heap[index + 1] = entries[index];

      // Create heap
      for (int rootIndex = lastIndex / 2; rootIndex > 0; rootIndex--)
         reheap(rootIndex);
   } // end constructor

   private void reheap(int rootIndex) {
      boolean done = false;
      T orphan = heap[rootIndex];
      int leftChildIndex = 2 * rootIndex;

      while (!done && (leftChildIndex <= lastIndex)) {
         int largerChildIndex = leftChildIndex; // Assume larger
         int rightChildIndex = leftChildIndex + 1;

         if ((rightChildIndex <= lastIndex) &&
               heap[rightChildIndex].compareTo(heap[largerChildIndex]) > 0) {
            largerChildIndex = rightChildIndex;
         } // end if

         if (orphan.compareTo(heap[largerChildIndex]) < 0) {
            heap[rootIndex] = heap[largerChildIndex];
            rootIndex = largerChildIndex;
            leftChildIndex = 2 * rootIndex;
            OptimalSwaps++;
         } else
            done = true;
      } // end while

      heap[rootIndex] = orphan;
   }

   public void add(T newEntry) {
      // Ensure initialization of data fields
      int newIndex = lastIndex + 1;
      int parentIndex = newIndex / 2;
      while ((parentIndex > 0) && newEntry.compareTo(heap[parentIndex]) > 0) {
         heap[newIndex] = heap[parentIndex];
         newIndex = parentIndex;
         parentIndex = newIndex / 2;
         SequencialSwaps++;
      } // end while

      heap[newIndex] = newEntry;
      lastIndex++;
      checkCapacity(heap.length);
      // See Segment 27.8.
   } // end add

   public T removeMax() {
      // Ensure initialization of data fields
      T root = null;

      if (!isEmpty()) {
         root = heap[1]; // Return value
         heap[1] = heap[lastIndex]; // Form a semiheap
         lastIndex--; // Decrease size
         reheap(1); // Transform to a heap
      } // end if

      return root;
      // See Segment 27.12.
   } // end removeMax

   public T getMax() {

      T root = null;
      if (!isEmpty())
         root = heap[1];
      return root;
   } // end getMax

   public boolean isEmpty() {
      return lastIndex < 1;
   } // end isEmpty

   public int getSize() {
      return lastIndex;
   } // end getSize

   public void clear() {

      while (lastIndex > -1) {
         heap[lastIndex] = null;
         lastIndex--;
      } // end while
      lastIndex = 0;
   } // end clear

   // Private methods
   public void printHeap(String filename) throws IOException {

      File file = new File(filename);
      FileWriter writer = new FileWriter(file);
      for (int i = 0; i < this.arr.length; i++) {
         writer.write(this.arr[i] + "\n");
         writer.close();
      }
   }
   // . . .
}