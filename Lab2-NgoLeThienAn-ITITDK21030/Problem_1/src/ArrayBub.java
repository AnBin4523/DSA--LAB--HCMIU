public class ArrayBub {
   private long[] a; // ref to array a
   private int nElems; // number of data items
   private int nSwaps; // number of swaps
   // --------------------------------------------------------------

   public ArrayBub(int max) // constructor
   {
      a = new long[max]; // create the array
      nElems = 0; // no items yet
      nSwaps = 0; // no swaps yet
   }

   // --------------------------------------------------------------
   public void insert(long value) // put element into array
   {
      a[nElems] = value; // insert it
      nElems++; // increment size
   }

   // --------------------------------------------------------------
   public void display() // displays array contents
   {
      for (int j = 0; j < nElems; j++) // for each element,
         System.out.print(a[j] + " "); // display it
      System.out.println("");
   }

   // --------------------------------------------------------------
    public void bubbleSort() {
        int out, in;
        int comparison = 0;
        // outer loop (backward)
        for (out = nElems - 1; out > 1; out--) {
            // inner loop (forward)
            for (in = 0; in < out; in++) {
                comparison++; 
                if (a[in] > a[in + 1]) {
                    swap(in, in + 1);
                }
            }
            System.out.println("Array after the outer loop " + (nElems - out) + ": ");
            display();
            System.out.print("\n");
        } 
        System.out.println("Sorted array: ");
        display();
        System.out.print("\n");

        System.out.println("Comparison after inner loop: " + comparison);
        System.out.print("\n");
        
        int totalComparison = nElems * (nElems - 1) / 2;
        System.out.println("Total number of comparison: " + totalComparison);
        System.out.print("\n");
    } 

   private void swap(int one, int two) {
      long temp = a[one];
      a[one] = a[two];
      a[two] = temp;

      nSwaps++; // increase number of swap by 1
   }

   public int getSwapNumber() {
      return nSwaps;
   }
   // --------------------------------------------------------------
}