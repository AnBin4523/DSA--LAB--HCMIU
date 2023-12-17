public class LinkQueue {
    private FirstLastList theList;

    // --------------------------------------------------------------
    public LinkQueue() // constructor
    {
        theList = new FirstLastList();
    } // make a 2-ended list
    // --------------------------------------------------------------

    public boolean isEmpty() // true if queue is empty
    {
        return theList.isEmpty();
    }

    // --------------------------------------------------------------
    public void insert(long j) // insert, rear of queue
    {
        theList.insertLast(j);
    }

    // --------------------------------------------------------------
    public long remove() // remove, front of queue
    {
        return theList.deleteFirst();
    }

    // --------------------------------------------------------------
    public void displayQueue() {
        System.out.print("Queue (front-->rear): ");
        theList.displayList();
    }

    // New method to remove item N after N calls
    public long removeNth(int n) {
        long item = -1; // Default value if removal is not possible
        if (n > 0) {
            for (int i = 0; i < n; i++) {
                item = theList.deleteFirst();
            }
        }
        return item;
    }

    // New method to get the size of the queue
    public int size() {
        return theList.size();
    }
}
