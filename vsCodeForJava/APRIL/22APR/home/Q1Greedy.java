/*
Q1 - Divisor Game
Problem Link - https://leetcode.com/problems/divisor-game/description/
Logic - 
The only case where a player loses the game is when he/she is at number 1

1. player is at an even number - he/she can always subtract 1 to make it an odd number.
2. player is at an odd number (>1) - all factors of an odd number are odd, so definitely 
									he/she will make a move and give the other player an even number.

So, player with even number can always make a move which will result in an odd number - 
Means player with even number will win the game.

Time Complexity: O(1)
Space Complexity: O(1)
*/

import java.util.*;

class Solution {
    public boolean divisorGame(int n) {
        return n % 2 == 0;
    }
}

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Solution obj = new Solution();
        if (obj.divisorGame(n)) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
        scanner.close();
    }
}
