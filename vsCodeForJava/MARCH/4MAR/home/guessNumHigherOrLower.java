/*
Approach:

The approach used here is binary search.
The idea is to iteratively guess a number in the given range and narrow down the search space based on the feedback from the guess function.
We initially set the search range from 1 to n.
We repeatedly guess the number in the middle of the current range.
Based on the feedback from the guess function, we adjust the search range:
If the guess is higher than the picked number, we reduce the upper bound of the search range (r) to mid - 1.
If the guess is lower than the picked number, we increase the lower bound of the search range (l) to mid + 1.
If the guess is correct, we break out of the loop.
We continue this process until we find the correct number.
Code Explanation:

The code initializes two variables l and r representing the lower and upper bounds of the search range respectively, initially set to 1 and n.
It enters a while loop which continues as long as the upper bound r is greater than or equal to the lower bound l.
Inside the loop, it calculates the mid-point mid of the current search range.
It uses the guess function to determine if the guessed number mid is higher, lower, or equal to the picked number.
Based on the guess result, it adjusts the search range accordingly by updating l or r.
If the guess is correct (guess(mid) == 0), it breaks out of the loop.
Finally, it returns the guessed number mid.
*/

class Solution {
    // Assume guess is a predefined method that returns -1, 0, or 1
    // based on the guess being too low, correct, or too high respectively.
    public int guess(int num) {
        // Placeholder implementation
        return 0;
    }

    public int guessNumber(int n) {
        int l = 1, r = n;
        int mid = 0;
        while (r >= l) {
            mid = l + (r - l) / 2;
            int result = guess(mid);
            if (result == -1)
                r = mid - 1;
            else if (result == 1)
                l = mid + 1;
            else if (result == 0)
                break;
        }
        return mid;
    }
}
