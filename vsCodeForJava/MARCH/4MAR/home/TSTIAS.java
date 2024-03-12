/*
Approach:

The approach taken here is a variation of the two-pointer technique combined with binary search.
The array num is assumed to be sorted.
For each element num[i] in the array, we fix it as the first element of the pair and then search for the second element in the array using binary search.
We maintain two pointers, s (start) and e (end), initially pointing to the start and end of the array respectively.
We calculate the mid-point mid of the current range and check if num[i] + num[mid] equals the target.
If the sum is equal to the target, we return the indices {i+1, mid+1} (adding 1 because indices in the problem are 1-based).
If the sum is greater than the target, we move the end pointer e to mid - 1 to search for smaller elements.
If the sum is less than the target, we move the start pointer s to mid + 1 to search for larger elements.
We repeat this process until the start pointer s becomes greater than the end pointer e, indicating that there are no more elements to search.
Code Explanation:

The code starts by iterating over each element of the input array num.
For each element num[i], it initializes variables for indices (id) and pointers for binary search (s and e).
It calculates the mid-point mid for the binary search and iterates until s becomes greater than e.
Inside the loop, it checks if the sum of num[i] and num[mid] is equal to the target, returning the indices if found.
If the sum is greater than the target, it updates the end pointer e to mid - 1.
If the sum is less than the target, it updates the start pointer s to mid + 1.
If no such pair is found, it returns {-1, -1} indicating failure to find the pair.
*/

class Solution {
    public int[] twoSum(int[] num, int target) {
        int id = 0;
        for (int i = 0; i < num.length; ++i) {
            int x = num[i];
            id = i;
            int s = i + 1, e = num.length - 1;
            int mid = s + (e - s) / 2;
            while (s <= e) {
                if (x + num[mid] == target)
                    return new int[] { id + 1, mid + 1 };
                else if (x + num[mid] > target) {
                    e = mid - 1;
                } else {
                    s = mid + 1;
                }
                mid = s + (e - s) / 2;
            }
        }
        return new int[] { -1, -1 };
    }
}
