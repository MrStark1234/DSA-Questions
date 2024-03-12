
/*
 * 
 * Question- Rearrange Array Elements by Sign (Leetcode)
 * Link-
 * https://leetcode.com/problems/rearrange-array-elements-by-sign/description/
 * 
 */

/*
 * we can create two array in first array put negative element and in second put
 * positive element
 * Now combine this two array.
 */

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] rearrangeArray(int[] nums) {
        List<Integer> v1 = new ArrayList<>();
        List<Integer> v2 = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0)
                v1.add(nums[i]);
            else
                v2.add(nums[i]);
        }
        int ind1 = 0, ind2 = 0;

        while (ind2 < nums.length / 2) {
            ans.add(v1.get(ind1));
            ind1++;
            ans.add(v2.get(ind2));
            ind2++;
        }

        int[] result = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            result[i] = ans.get(i);
        }
        return result;
    }
}

/*
 * 
 * A better approach we don't need to create two array take pointer for positive
 * and negative element .
 * Since postive element is equal to negative element so in a while loop search
 * for
 * positive and negative element and then push these to answer .
 * TC->O(N)
 * SC->O(1) --> for answer and input array
 */

// class Solution {
// public int[] rearrangeArray(int[] nums) {
// int i = 0, j = 0;
// int[] result = new int[nums.length];
// int k = 0;
// while (k < nums.length) {
// while (nums[i] < 0)
// i++;
// while (nums[j] > 0)
// j++;
// result[k++] = nums[i++];
// result[k++] = nums[j++];
// }

// return result;
// }
// }