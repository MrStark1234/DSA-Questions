import java.util.*;

class Main {
    public static boolean[] primeSieve(int n) {
        boolean isPrime[] = new boolean[n + 1]; // [0, n]
        Arrays.fill(isPrime, true);

        isPrime[0] = isPrime[1] = false;
        for (int i = 2; i * i <= n; ++i) {
            if (!isPrime[i])
                continue;
            for (int j = i * i; j <= n; j += i)
                isPrime[j] = false;
        }
        return isPrime;
    }

    public static void main(String[] args) {
        // Note: Don't change class name
        // your code goes here
        boolean[] ans = primeSieve(50);

        for (int i = 1; i < ans.length; ++i)
            System.out.println(i + " -> " + ans[i]);
    }
}