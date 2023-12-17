import java.util.*;

public class MinGap {
    public static int minGap(int[] array, int n) {
        if (n < 2) {
            return 0;
        }

        int min = Integer.MAX_VALUE;

        for (int i = 1; i < n; i++) {
            int gap = array[i] - array[i - 1];

            if (gap < min) {
                min = gap;
            }
        }
        return min;
    }
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of array: ");
        int n = sc.nextInt();

        int[] array = new int[n];

        System.out.println("Enter the integers: ");
        for (int i = 0; i < n; i++) {
            System.out.print("Integer " + (i + 1) + ": ");
            array[i] = sc.nextInt();
        }

        int minGap = minGap(array, n);
        System.out.println("Minimum gap: " + minGap);
        sc.close();
    }
}
