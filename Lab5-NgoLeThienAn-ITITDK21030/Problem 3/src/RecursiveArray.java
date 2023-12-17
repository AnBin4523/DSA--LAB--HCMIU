import java.util.Scanner;

public class RecursiveArray {
    static int findMin(int a[], int n) {
        if (n == 1) {
            return a[0]; 
        } else {
            int minimumOfRest = findMin(a, n - 1); 
            return Math.min(a[n - 1], minimumOfRest); 
        }
    }

    static int findSum(int a[], int n) {
        if (n == 0) {
            return 0; 
        } else {
            return a[n - 1] + findSum(a, n - 1); 
        }
    }
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter the size n: ");
        int size = sc.nextInt();

        int[] arr = new int[size];

        System.out.println("Entered elements:");
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }

        int min = findMin(arr, size);
        System.out.println("Minimum element: " + min);

        int sum = findSum(arr, size);
        System.out.println("Sum of elements: " + sum);

        sc.close();
    }
}
