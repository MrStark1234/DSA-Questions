import java.util.Arrays;

class Solution {
    boolean[] primeSieve(int n) {
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

    public int countPrimes(int n) {
        if (n == 0)
            return 0;
        boolean[] isPrime = primeSieve(n);
        int cnt = 0;
        for (int i = 2; i < n; ++i)
            if (isPrime[i] == true)
                cnt += 1;
        return cnt;
    }
}

class Main {
    public static void main(String[] args) {
        // Note: Don't change class name
        // your code goes here
    }
}