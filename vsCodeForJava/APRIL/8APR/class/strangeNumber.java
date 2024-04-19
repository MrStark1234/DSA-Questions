import java.util.*;

// Link : https://www.codechef.com/problems/STRNO

// Time : O(sqrt(X)) per test case

class Codechef {
    public static void main(String[] args) throws java.lang.Exception {
        try (Scanner sc = new Scanner(System.in)) {
            int t = sc.nextInt();
            while (t-- > 0) {
                int X = sc.nextInt();
                int K = sc.nextInt();

                // Let's find some of powers of
                // prime factors of X
                int sumPrimePowers = 0;
                for (int i = 2; i * i <= X; ++i) {
                    while (X % i == 0) {
                        sumPrimePowers += 1;
                        X /= i;
                    }
                }
                if (X > 1)
                    sumPrimePowers += 1;

                if (sumPrimePowers >= K)
                    System.out.println(1);
                else
                    System.out.println(0);
            }
        }
    }
}
