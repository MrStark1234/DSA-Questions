// Link : https://leetcode.com/problems/super-pow/

class Solution {
    final int mod = 1337;

    int mul(int a, int b) {
        return ((a % mod) * (b % mod)) % mod;
    }

    int powUnderMod(int a, int n) {
        if (n == 0)
            return 1;
        int partialAns = powUnderMod(a, n / 2);

        partialAns = mul(partialAns, partialAns);

        if (n % 2 == 0)
            return partialAns;

        return mul(partialAns, a);
    }

    public int superPow(int a, int[] b) {
        int ans = 1;
        a %= mod;
        for (int i = b.length - 1; i >= 0; --i) {
            ans = mul(ans, powUnderMod(a, b[i]));
            a = powUnderMod(a, 10);
        }
        return ans;
    }
}

class Main {
    public static void main(String[] args) {
        // Note: Don't change class name
        // your code goes here
    }
}