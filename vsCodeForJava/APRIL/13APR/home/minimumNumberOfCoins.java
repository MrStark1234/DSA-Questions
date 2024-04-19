/*
Q2 - Minimum number of Coins
Question Link - https://www.geeksforgeeks.org/problems/-minimum-number-of-coins4426/1

Logic - 
Think about denomination of Rs. x. 
How many notes of x Rs. can you take such that it does not exceed N? - floor(N/x)
And what is the amount remaining after you have taken out maximum amount of notes? - N%x

And now to minimize the total number of notes, we iterate over the denominations in descending order

Time Complexity - O(N)
Space Complexity - O(1) 
*/

import java.util.*;

class Main {
    public static void main(String[] args) {
        // Note: Don't change class name
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Solution obj = new Solution();
        List<Integer> ans = obj.minPartition(n);
        for (int x : ans)
            System.out.print(x + " ");
        scanner.close();
    }
}

class Solution {
    List<Integer> minPartition(int N) {
        List<Integer> ans = new ArrayList<>();
        int[] value = { 2000, 500, 200, 100, 50, 20, 10, 5, 2, 1 };
        for (int i = 0; i < 10; i++) {
            int curr = N / value[i];
            N %= value[i];
            for (int j = 0; j < curr; j++)
                ans.add(value[i]);
        }
        return ans;
    }
}
