public class DoublyLinkedApp {
    public static void main(String[] args) { // make a new list
        DoublyLinkedList theList = new DoublyLinkedList();

        theList.insertFirst(22); // insert at front
        theList.insertFirst(44);
        theList.insertFirst(66);

        theList.insertLast(11); // insert at rear
        theList.insertLast(33);
        theList.insertLast(55);

        theList.displayForward(); // display list forward
        theList.displayBackward(); // display list backward

        Link deletedFirst = theList.deleteFirst(); // delete first item
        System.out.println("Deleted First: " + deletedFirst.dData);

        Link deletedLast = theList.deleteLast(); // delete last item
        System.out.println("Deleted Last: " + deletedLast.dData);

        Link deletedKey = theList.deleteKey(11); // delete item with key 11
        if (deletedKey != null) {
            System.out.println("Deleted Key: " + deletedKey.dData);
        } else {
            System.out.println("Key not found.");
        }

        theList.displayForward(); // display list forward

        theList.insertAfter(22, 77); // insert 77 after 22
        theList.insertAfter(33, 88); // insert 88 after 33

        theList.displayForward(); // display list forward
    }
}
