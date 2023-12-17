import java.util.Scanner;

public class GcdRecursive {
    static int gcd(int p, int q) {
        if (q == 0) {
            return p; // Base case: GCD is p when q becomes 0.
        } else {
            return gcd(q, p % q); // Recursive case: GCD is calculated with p and (p % q).
        }
    }
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first number: ");
        int p = sc.nextInt();

        System.out.print("Enter second number: ");
        int q = sc.nextInt();

        int gcdResult = gcd(p, q);
        System.out.println("GCD of " + p + " and " + q + " is: " + gcdResult);

        sc.close();
    }
}
