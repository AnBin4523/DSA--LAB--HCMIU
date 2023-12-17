import java.util.*;

public class Median {
    public static double calculateMedian(List<Integer> number) {
        Collections.sort(number);

        int size = number.size();
        if (size % 2 == 0) {
            int middle_1 = number.get(size / 2 -1);
            int middle_2 = number.get(size / 2);
            return (double) (middle_1 + middle_2) / 2;
        } else {
            return (double) number.get(size / 2);
        }
    }
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        List<Integer> number = new ArrayList<>();

        System.out.print("Enter the number of array: ");
        int n = sc.nextInt();

        System.out.println("Enter the integers: ");
        for (int i = 0; i < n; i++) {
            System.out.print("Integer " + (i + 1) + ": ");
            int num = sc.nextInt();
            number.add(num);
        }

        double median = calculateMedian(number);
        System.out.println("Median: " + median);
        sc.close();
    }
}
