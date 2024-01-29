//Problem Link:- https://www.hackerearth.com/practice/math/number-theory/primality-tests/practice-problems/algorithm/does-it-divide-3c60b8fb/
import java.util.Scanner;
public class doesitdevide {
    public static void main(String[] args) {
          try (Scanner sc = new Scanner(System.in)) {
              int t = sc.nextInt();

              while (t-- > 0) {
                  int N = sc.nextInt();

                  if (N == 1) {
                      System.out.println("YES");
                      continue;
                  }

                  // If N+1 is prime, then No
                  // Otherwise Yes.
                  boolean isPrime = true;
                  for (int i = 2; i * i <= (N + 1); ++i) {
                      if ((N + 1) % i == 0) {
                          isPrime = false;
                          break;
                      }
                  }
                  System.out.println(isPrime ? "NO" : "YES");
              }
          }
    }
}
