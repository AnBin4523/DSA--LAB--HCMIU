public class CircularLinkedList {
    Node head;
    Node tail;

    public void insert(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            tail = newNode;
            tail.next = head;
        } else {
            tail.next = newNode;
            tail = newNode;
            tail.next = head;
        }
    }

    public void delete(int n) {
        Node current = head;
        Node prev = null;

        while (current.next != current) {
            for (int i = 1; i < n; i++) {
                prev = current;
                current = current.next;
            }
            prev.next = current.next;
            System.out.print(current.data + " ");
            current = current.next;
        }
        head = current;
    }

    int getLastManStanding() {
        return head.data;
    }
}
