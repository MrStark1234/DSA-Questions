//leetcode - 2761. Prime Pairs With Target Sum
// https://leetcode.com/problems/prime-pairs-with-target-sum/description/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public boolean[] primeSieve(int n) {
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i * i <= n; ++i) {
            if (!isPrime[i])
                continue;
            for (int j = i * i; j <= n; j += i) // multiples of i
                isPrime[j] = false;
        }

        return isPrime;
    }

    public List<List<Integer>> findPrimePairs(int n) {
        boolean[] prime = primeSieve(n);
        List<List<Integer>> ans = new ArrayList<>();
        for (int x = 2; x < n; x++) {
            int y = n - x;
            if (x > y) { // base case
                break;
            }
            if (prime[x] && prime[y]) { // check both x and y are prime
                List<Integer> pair = new ArrayList<>();
                pair.add(x);
                pair.add(y);
                ans.add(pair);
            }
        }
        return ans;
    }
}
