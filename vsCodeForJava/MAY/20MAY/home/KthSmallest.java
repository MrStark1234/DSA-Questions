// https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/

import java.util.ArrayList;
import java.util.List;

public class KthSmallest {
    int val;
    KthSmallest left;
    KthSmallest right;
    public Integer data;

    KthSmallest() {
    }

    KthSmallest(int val) {
        this.val = val;
    }

    KthSmallest(int val,
            KthSmallest left,
            KthSmallest right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    List<Integer> values = new ArrayList<>();

    public int kthSmallest(KthSmallest root, int k) {
        inorder(root);
        return values.get(k - 1);
    }

    private void inorder(KthSmallest root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        values.add(root.val);
        inorder(root.right);
    }
}
