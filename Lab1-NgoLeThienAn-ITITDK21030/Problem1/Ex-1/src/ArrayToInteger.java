import java.util.*;
public class ArrayToInteger {
    public static int convertArrayToNumber(int[] arr) {
        int numConvert = 0;

        for (int digit : arr) {
            numConvert = numConvert * 10 + digit;
        }

        return numConvert;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of digits: ");
        int n = scanner.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter the digits: ");

        for(int i = 0; i < n; i++) {
            System.out.print("Digit" + (i + 1) + ": ");
            arr[i] = scanner.nextInt();
        }

        int result = convertArrayToNumber(arr);
        System.out.println("Result: " + result);
        scanner.close();
    }
}