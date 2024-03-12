/*

Question - Maximum Tastiness of Candy Basket
Link - https://leetcode.com/problems/maximum-tastiness-of-candy-basket/description/



Firstly, we sort the array because we aim to find the absolute minimum difference between all pairs in the basket, and the minimum is always the difference between adjacent elements in a sorted array.

For binary search, our start and end points should be the minimum and maximum possible answers, which are 0 [7,7,7,7] and price[n-1] - price[0] after sorting the price, for example, [1,2,3,4,5] = 4.

Now, 'mid' represents the minimum absolute difference between any two elements in our basket, which we want to maximize. 
For each 'mid', we check if we can obtain 'k' elements with an absolute difference between any pair at least 'mid'.

To do this, we traverse our sorted array and count the number of elements. If the count is greater than or equal to 'k', we return true.
 Since we aim to maximize our answer, we set start = mid + 1 if count is greater than or equal to 'k'. If count is less than 'k', we try to decrease 'mid' by setting end = mid - 1.

int previous = price[0];
int count = 1;
for (int i = 1; i < price.size(); i++) {
    if (price[i] - previous >= mid) {
        count++;
        previous = price[i];
    }
}

In this snippet, 'previous' represents the previously chosen element.
If the difference between the current element 'price[i]' and the previous element is greater than or equal to 'mid', we add it to our basket. Now, 'price[i]' becomes our previous element for the next iteration.





*/

import java.util.Arrays;

class Solution {
    public boolean isPossible(int mid, int[] price, int k) {
        int previous = price[0];
        int count = 1;
        for (int i = 1; i < price.length; i++) {
            if (price[i] - previous >= mid) {
                count++;
                previous = price[i];
            }
        }

        return count >= k;
    }

    public int maximumTastiness(int[] price, int k) {
        Arrays.sort(price);
        int ans = 0;
        int n = price.length;
        int st = 0, ed = price[n - 1] - price[0];

        while (st <= ed) {
            int mid = (st + ed) / 2;
            if (isPossible(mid, price, k)) {
                ans = mid;
                st = mid + 1;
            } else {
                ed = mid - 1;
            }
        }

        return ans;
    }
}
