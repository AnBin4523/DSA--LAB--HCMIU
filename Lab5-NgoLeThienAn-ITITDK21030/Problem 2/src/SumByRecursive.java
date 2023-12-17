import java.util.Scanner;

public class SumByRecursive {
    static double sum(int n) {
        if (n == 1) {
            return 1;
        } else {
            return 1 / (double) n + sum(n - 1);
        }
    }

    public static void main(String[] args) throws Exception {
        int n;
        System.out.print("Type the integer n: ");
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        double result = sum(n);
        System.out.println("Sum for n: " + result);
        sc.close();
    }
}
