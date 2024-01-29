
// Given a value of N, print the sum of 1st N natural numbers.
// Formula = N*(N+1)/2;
import java.util.Scanner;

class takingInput {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int N = sc.nextInt(); // taking input of integer
            int sum = N * (N + 1) / 2;
            System.out.println(sum);
            // int N2 = sc.nextInt();
            // int sum2 = N2 * (N2 + 1) / 2;
            // System.out.println(sum2);
            // sc.nextDouble() -> double
            // sc.nextFloat() -> float
        }
    }
}