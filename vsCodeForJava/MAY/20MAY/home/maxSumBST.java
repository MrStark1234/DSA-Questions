// Link : https://leetcode.com/problems/maximum-sum-bst-in-binary-tree/

public class maxSumBST {
    int val;
    maxSumBST left;
    maxSumBST right;
    public Integer data;

    maxSumBST() {
    }

    maxSumBST(int val) {
        this.val = val;
    }

    maxSumBST(int val,
            maxSumBST left,
            maxSumBST right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Data {
    boolean isBST;
    int maxVal;
    int minVal;
    int curSum;
    int maxSum;

    Data(boolean a, int mx, int mn, int sm, int mxsum) {
        isBST = a;
        maxVal = mx;
        minVal = mn;
        curSum = sm;
        maxSum = mxsum;
    }
}

class Solution {
    Data BSTsumHelper(maxSumBST cur) {
        if (cur == null)
            return new Data(true, Integer.MIN_VALUE, Integer.MAX_VALUE, 0, 0);

        Data leftData = BSTsumHelper(cur.left);
        Data rightData = BSTsumHelper(cur.right);

        boolean leftBST = (leftData.isBST == true && leftData.maxVal < cur.val);
        boolean rightBST = (rightData.isBST == true && rightData.minVal > cur.val);

        boolean isBST = leftBST && rightBST;
        int curMax = Math.max(Math.max(cur.val, leftData.maxVal), rightData.maxVal);
        int curMin = Math.min(Math.min(cur.val, leftData.minVal), rightData.minVal);
        int curSum = cur.val + leftData.curSum + rightData.curSum;
        int maxSum = Math.max(leftData.maxSum, rightData.maxSum);
        if (isBST)
            maxSum = Math.max(maxSum, curSum);

        return new Data(isBST, curMax, curMin, curSum, maxSum);
    }

    public int maxSumBST(maxSumBST root) {
        return BSTsumHelper(root).maxSum;
    }
}
