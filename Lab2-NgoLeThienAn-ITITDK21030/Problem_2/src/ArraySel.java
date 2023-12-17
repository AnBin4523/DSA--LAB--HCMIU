public class ArraySel {
   private long[] a;                 // ref to array a
   private int nElems;               // number of data items
   // number swap
   private int nSwaps;  
   // number comparison
   private int innerComparisons;
   // total comparison
   private int totalComparisons;
//--------------------------------------------------------------
   public ArraySel(int max)          // constructor
      {
         a = new long[max];                 // create the array
         nElems = 0;                        // no items yet
         nSwaps = 0;
         innerComparisons = 0;
         totalComparisons = 0;
      }
//--------------------------------------------------------------
   public void insert(long value)    // put element into array
      {
      a[nElems] = value;             // insert it
      nElems++;                      // increment size
      }
//--------------------------------------------------------------
   public void display()             // displays array contents
      {
      for(int j=0; j<nElems; j++)       // for each element,
         System.out.print(a[j] + " ");  // display it
      System.out.println("");
      }
//--------------------------------------------------------------
   public void selectionSort()
   {
      int out, in, min;

      for(out = 0; out < nElems-1; out++) {
         min = out;                    
         for(in = out + 1; in < nElems; in++) {
            innerComparisons++;
            if(a[in] < a[min]) {
               min = in; 
            }         
         }
         if (out != min) {
            swap(out, min);                
         }
         totalComparisons += innerComparisons;
      } 
   }  
//--------------------------------------------------------------
   private void swap(int one, int two)
   {
      long temp = a[one];
      a[one] = a[two];
      a[two] = temp;
      nSwaps++;
   }
//--------------------------------------------------------------
   public int getSwapNumber() {
      return nSwaps;
   }

   public int getInnerComparisonNumber() {
      return innerComparisons;
   }

   public int getTotalComparisonNumber() {
      return totalComparisons;
   }
} 
