/*
Q1 - Lemonade Change
Question Link - https://leetcode.com/problems/lemonade-change/description/

Logic - 
We keep track of currently available bills. And we iterate through the bills array.
Now there can be three cases:
	1. bills[i] == 5 - Give no change, just increment five dollar bills
	2. bills[i] == 10 - Give 5 dollar bill as change and increment ten dollar bills
	3. bills[i] == 20 - We need to give 15$ change in total. 
		We can give one 10$ bill and one 5$ bill as change or three 5$ bills as change.
		We try to greedily give out 10$ bill as change becuase it can be given out in only this case.
		Also 5$ bills are 'valuable' as it can be given out as a change in every case.

Time Complexity - O(n)
Space Complexity - O(1) 
*/

import java.util.*;

class Main {
    public static void main(String[] args) {
        // Note: Don't change class name
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] bills = new int[n];
        for (int i = 0; i < n; i++) {
            bills[i] = scanner.nextInt();
        }
        Solution obj = new Solution();
        if (obj.lemonadeChange(bills))
            System.out.println("true");
        else
            System.out.println("false");
        scanner.close();
    }
}

class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five_bills = 0;
        int ten_bills = 0;
        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {
                five_bills++;
            } else if (bills[i] == 10) {
                if (five_bills == 0)
                    return false;
                five_bills--;
                ten_bills++;
            } else {
                if (ten_bills >= 1 && five_bills >= 1) {
                    ten_bills--;
                    five_bills--;
                } else if (five_bills >= 3) {
                    five_bills -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
