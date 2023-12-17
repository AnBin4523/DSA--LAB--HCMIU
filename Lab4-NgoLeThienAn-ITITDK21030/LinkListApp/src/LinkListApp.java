public class LinkListApp {
    public static void main(String[] args) throws Exception {
        LinkList theList = new LinkList();  // make new list

        theList.insertFirst(22, 2.99);      // insert four items
        theList.insertFirst(44, 4.99);
        theList.insertFirst(66, 6.99);
        theList.insertFirst(88, 8.99);

        // theList.displayList();              // display list

        // while( !theList.isEmpty() )         // until it's empty,
        // {
        //     Link aLink = theList.deleteFirst();   // delete link
        //     System.out.print("Deleted ");         // display it
        //     aLink.displayLink();
        //     System.out.println("");
        // }
        // theList.displayList();              // display list

        System.out.println("Initial List: ");
        System.out.println(theList.toString()); // Display the entire list
        
        Link firstElement = theList.getFirst();
        Link lastElement = theList.getLast();

        if (firstElement != null) {
            System.out.println("First Element: " + firstElement.toString());
        } else {
            System.out.println("The list is empty.");
        }

        if (lastElement != null) {
            System.out.println("Last Element: " + lastElement.toString());
        } else {
            System.out.println("The list is empty.");
        }

        while (!theList.isEmpty()) {
            Link aLink = theList.deleteFirst();
            System.out.print("Deleted ");
            System.out.println(aLink.toString()); // Display the deleted link
        }

        System.out.println("List after deletion: ");
        System.out.println(theList.toString()); // Display the modified list
    }
}
