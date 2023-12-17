import java.util.Random;

public class LinkQueueApp {
    public static void main(String[] args) {
        LinkQueue theQueue = new LinkQueue();
        Random random = new Random();
        int maxCustomers = 10; // Adjust as needed

        // Enqueue customers with random service times
        for (int i = 1; i <= maxCustomers; i++) {
            long serviceTime = random.nextInt(10) + 1; // Random service time (1 to 10)
            theQueue.insert(serviceTime);
        }

        System.out.println("Initial Queue:");
        theQueue.displayQueue();

        // Serve customers and measure the impact of time and arrival rate
        int totalTime = 0;
        int totalCustomers = 0;
        while (!theQueue.isEmpty()) {
            long serviceTime = theQueue.remove();
            System.out.println("Serving a customer for " + serviceTime + " seconds.");
            totalCustomers++;
            totalTime += serviceTime;
            try {
                Thread.sleep(serviceTime * 1000); // Simulate serving time in seconds
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (totalCustomers % 3 == 0) {
                // Remove the 3rd customer in the queue
                long removed = theQueue.removeNth(3);
                if (removed != -1) {
                    System.out.println("Removed the 3rd customer from the queue.");
                }
            }

            // Add new customers with random service times
            theQueue.insert(random.nextInt(10) + 1);
        }

        System.out.println("Total service time: " + totalTime + " seconds.");
        System.out.println("Average service time per customer: " + (totalTime / totalCustomers) + " seconds.");
        System.out.println("Queue size at the end: " + theQueue.size());
    }
}
