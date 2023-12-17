import java.util.Scanner;

public class JosephusProblem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CircularLinkedList list = new CircularLinkedList();

        System.out.print("Enter the number of people in the circle: ");
        int n = scanner.nextInt();
        System.out.print("Enter the number used for counting off: ");
        int k = scanner.nextInt();
        System.out.print("Enter the number of the person where counting starts: ");
        int start = scanner.nextInt();

        for (int i = 1; i <= n; i++) {
            list.insert(i);
        }

        // Move to the starting person
        while (list.head.data != start) {
            list.head = list.head.next;
        }

        System.out.print("Elimination order: ");
        list.delete(k);
        System.out.println();
        System.out.println("Last person standing: " + list.getLastManStanding());

        scanner.close();
    }
}

