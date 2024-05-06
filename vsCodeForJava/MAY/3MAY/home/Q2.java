/*
Q2 - Power of Four
Question Link - https://leetcode.com/problems/power-of-four/description/

Logic:
Trivial log4(n) solution is very straightforward.
For a better solution, we use two properties of powers of 4:
	1. Only one set bit
	2. The set bit is at an odd position

Checking the first condition is very easy - just set the rightmost bit and check the resulting number is 0.
For the second condition, we generate a number with all odd bits set.
That number will be equal to 2^0 + 2^2 + 2^4 + .... + 2^30 = 1431655765.

If the given number is zero, the bitwise AND of the number with the above-generated number
will result in a non-zero number.

Time Complexity: O(1)
Space Complexity: O(1)
*/

import java.util.Scanner;

class Solution {
    public boolean isPowerOfFour(int n) {
        if (n <= 0)
            return false;
        if ((n & (n - 1)) != 0)
            return false;
        return ((n & (1431655765)) != 0);
    }
}

class Main {
    public static void main(String[] args) {
        // Note: Don't change class name
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Solution obj = new Solution();
        if (obj.isPowerOfFour(n)) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
        scanner.close();
    }
}
