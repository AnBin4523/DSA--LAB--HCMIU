public class Queue
   {
   private int maxSize;
   private long[] queArray;
   private int front;
   private int rear;
   private int nItems;
//--------------------------------------------------------------
   public Queue(int s)          // constructor
      {
      maxSize = s;
      queArray = new long[maxSize];
      front = 0;
      rear = -1;
      nItems = 0;
      }
//--------------------------------------------------------------
    public void insert(long j) {
        if (isFull()) {
            System.out.println("Queue is full, cannot insert " + j);
            return; 
        }

        if (rear == maxSize - 1) {
            rear = -1; 
        }

        queArray[++rear] = j;
        nItems++;
    }
//--------------------------------------------------------------
    public long remove() {
        if (isEmpty()) {
            System.out.println("Queue is empty, cannot remove ");
            return -1; 
        }

        long temp = queArray[front++];
        if (front == maxSize) {
            front = 0; 
        }

        nItems--;
        return temp;
    }
//--------------------------------------------------------------
   public long peekFront()      // peek at front of queue
      {
      return queArray[front];
      }
//--------------------------------------------------------------
   public boolean isEmpty()    // true if queue is empty
      {
      return (nItems==0);
      }
//--------------------------------------------------------------
   public boolean isFull()     // true if queue is full
      {
      return (nItems==maxSize);
      }
//--------------------------------------------------------------
   public int size()           // number of items in queue
      {
      return nItems;
      }
//--------------------------------------------------------------
    public void displayQueueArray() {
        System.out.print("Queue Array: ");
        for (int i = 0; i < maxSize; i++) {
            System.out.print(queArray[i] + " ");
        }
        System.out.println();
        }

    public void displayQueueWithWraparound() {
        System.out.print("Queue (with wraparound): ");
        int tempFront = front;
        for (int i = 0; i < nItems; i++) {
            System.out.print(queArray[tempFront] + " ");
            tempFront = (tempFront + 1) % maxSize; 
        }
        System.out.println();
    }

    public void displayFrontAndRearIndices() {
        System.out.println("Front Index: " + front);
        System.out.println("Rear Index: " + rear);
    }
}
