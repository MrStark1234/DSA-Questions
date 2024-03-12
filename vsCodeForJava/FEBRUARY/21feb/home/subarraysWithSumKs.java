// Subarrays with Sum ‘k'
// https://www.codingninjas.com/studio/problems/subarrays-with-sum-%E2%80%98k'_6922076?leftPanelTabValue=PROBLEM

// recursion code but it will give stackoverflow 
// import java.util.*;
// public class Solution {

//       public static void rec(int ind, int n, long sum, List<Integer> temp, List<List<Integer>> ans, int[] a, long k) {
//         if (sum == k) {
//             ans.add(new ArrayList<>(temp));
//             return;
//         }
//         if (ind == n || sum > k) {
//             return;
//         }
//         // sum > 0 means we have already taken the previous element,
//         // so we must take the next element because sum < k
//         if (sum > 0) {
//             temp.add(a[ind]);
//             sum += a[ind];
//             rec(ind + 1, n, sum, temp, ans, a, k);
//             sum -= a[ind];
//             temp.remove(temp.size() - 1);
//         }
//         // else we have two choices: take the current element or not;
//         else {
//             rec(ind + 1, n, sum, temp, ans, a, k);
//             temp.add(a[ind]);
//             sum += a[ind];
//             rec(ind + 1, n, sum, temp, ans, a, k);
//             sum -= a[ind];
//             temp.remove(temp.size() - 1);
//         }
//        }   
// public static List< List < Integer > > subarraysWithSumK(int []a, long k) {
//        int n = a.length;

//         List<List<Integer>> ans = new ArrayList<>();
//         List<Integer> temp = new ArrayList<>();
//         long sum = 0;
//         rec(0, n, sum, temp, ans, a, k);
//         return ans;
//     }
// }

import java.util.*;

public class subarraysWithSumKs {
    public static List<List<Integer>> subarraysWithSumK(int[] a, long k) {
        // Write your code here
        int n = a.length;

        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < n; ++i) {
            long currentSum = 0;

            List<Integer> temp = new ArrayList<>();
            for (int j = i; j < n; ++j) {
                temp.add(a[j]);
                currentSum += a[j];

                if (currentSum == k) {
                    ans.add(new ArrayList<>(temp));
                } else if (currentSum > k)
                    break;
            }
        }

        return ans;
    }
}