import java.util.PriorityQueue;

public class PriorityQApp {
    public static void main(String[] args) throws Exception {
        // use priority queue
        PriorityQueue<Long> thePQ = new PriorityQueue<>();
        thePQ.add(30L);
        thePQ.add(50L);
        thePQ.add(10L);
        thePQ.add(40L);
        thePQ.add(20L);

        while (!thePQ.isEmpty()) {
            long item = thePQ.poll();
            System.out.print(item + " "); // 10, 20, 30, 40, 50
        }
        System.out.println("");
    }
}

// Compare this queue with QueueApp.java. Which one is more efficient?

// If you need to maintain items in sorted order, the original PriorityQ 
// class is more efficient for finding and removing the minimum item. If 
// you don't need to maintain sorted order and simply want to use a standard 
// queue, then the modified PriorityQ class is more efficient for that purpose.
