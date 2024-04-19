/*
Q1 - X of a Kind in a Deck of Cards
Question Link - https://leetcode.com/problems/x-of-a-kind-in-a-deck-of-cards/description/

Logic - 
Let's denote the frequency array of given array deck by the name freq.
So we need to check the existence of a number x (>1) such that, 
it divides every non-zero freq[i].
In other words, we need to a common factor of every non zero freq[i] such that it is >1
For that, we can just find the gcd check if it is >1

Time Complexity - 
O(n + m*log(m)) where:
n = size of deck
m = max(deck[i])

Space Complexity - O(10000) ~ O(1)
*/

import java.util.*;

class Main {
    public static void main(String[] args) {
        // Note: Don't change class name
        // your code goes here
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] deck = new int[n];
        for (int i = 0; i < n; i++) {
            deck[i] = scanner.nextInt();
        }
        Solution obj = new Solution();
        if (obj.hasGroupsSizeX(deck))
            System.out.println("true");
        else
            System.out.println("false");
        scanner.close();
    }
}

class Solution {
    // Euclid's GCD Algorithm
    private int gcd(int a, int b) {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }

    public boolean hasGroupsSizeX(int[] deck) {
        int[] freq = new int[10000];
        for (int number : deck)
            freq[number]++;
        int hcf = 0;
        for (int i = 0; i < 10000; i++) {
            // gcd(0,x) = x. So we don't need to worry about freq[i] = 0 cases.
            hcf = gcd(hcf, freq[i]);
        }
        return (hcf > 1);
    }
}
