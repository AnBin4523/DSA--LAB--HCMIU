public class PriorityQ
{
   // array in sorted order, from max at 0 to min at size-1
   private int maxSize;
   private long[] queArray;
   private int nItems;
//-------------------------------------------------------------
   public PriorityQ(int s)          // constructor
      {
      maxSize = s;
      queArray = new long[maxSize];
      nItems = 0;
      }
//-------------------------------------------------------------
    public void insert(long item)
    {
        if (isFull()) {
            System.out.println("Queue is full, cannot insert " + item);
            return;
        }

        int j;

        if(nItems == 0) {            
            queArray[nItems++] = item;         
        } else {
            for( j = nItems - 1; j >= 0; j--) {
                if( item < queArray[j] ) {
                    queArray[j+1] = queArray[j];
                } else {
                    break;
                }                          
            }  
            queArray[j+1] = item;           
            nItems++;
        }  
    }  
//-------------------------------------------------------------
   public long remove()             // remove minimum item
      { return queArray[--nItems]; }
//-------------------------------------------------------------
   public long peekMin()            // peek at minimum item
      { return queArray[nItems-1]; }
//-------------------------------------------------------------
   public boolean isEmpty()         // true if queue is empty
      { return (nItems==0); }
//-------------------------------------------------------------
   public boolean isFull()          // true if queue is full
      { return (nItems == maxSize); }
//-------------------------------------------------------------
    public void displayQueue() {
        System.out.print("Queue: ");
        for (int i = 0; i < nItems; i++) {
            System.out.print(queArray[i] + " ");
        }
        System.out.println();
    }
}
