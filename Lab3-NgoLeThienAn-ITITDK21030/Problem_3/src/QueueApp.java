public class QueueApp {
    public static void main(String[] args)
      {
      Queue theQueue = new Queue(5);  // queue holds 5 items

      theQueue.insert(10);            // insert 4 items
      theQueue.insert(20);
      theQueue.insert(30);
      theQueue.insert(40);

      theQueue.remove();              // remove 3 items
      theQueue.remove();              //    (10, 20, 30)
      theQueue.remove();

      theQueue.insert(50);            // insert 4 more items
      theQueue.insert(60);            //    (wraps around)
      theQueue.insert(70);
      theQueue.insert(80);

      theQueue.displayQueueArray();
      theQueue.displayFrontAndRearIndices();
      theQueue.displayQueueWithWraparound();
      System.out.println("");

    //   while( !theQueue.isEmpty() )    // remove and display
    //      {                            //    all items
    //      long n = theQueue.remove();  // (40, 50, 60, 70, 80)
    //      System.out.print(n);
    //      System.out.print(" ");
    //      }
    //   System.out.println("");
    //   }
    
    for (int i = 1; i <= 5; i++) {
        theQueue.insert(i);
    }

    // Process customers after N calls
    for (int i = 1; i <= 5; i++) {
        if (theQueue.size() >= i) {
            long customer = theQueue.remove();
            System.out.println("Processing customer " + customer);
        } else {
            System.out.println("Not enough customers for processing " + i);
        }
    }
    }
}
