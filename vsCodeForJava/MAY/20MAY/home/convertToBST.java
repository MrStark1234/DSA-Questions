// Link : https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/

public class convertToBST {
    int val;
    convertToBST left;
    convertToBST right;
    public Integer data;

    convertToBST() {
    }

    convertToBST(int val) {
        this.val = val;
    }

    convertToBST(int val,
            convertToBST left,
            convertToBST right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    convertToBST helper(int nums[], int l, int r) {
        if (l > r)
            return null;

        int mid = (l + r) / 2;
        convertToBST root = new convertToBST(nums[mid]);

        root.left = helper(nums, l, mid - 1);
        root.right = helper(nums, mid + 1, r);

        return root;
    }

    public convertToBST sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }
}
