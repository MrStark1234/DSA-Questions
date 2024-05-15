import java.util.*;

//  Definition for a binary tree node.
public class levelOrderTreversal {
    int val;
    levelOrderTreversal left;
    levelOrderTreversal right;

    levelOrderTreversal() {
    }

    levelOrderTreversal(int val) {
        this.val = val;
    }

    levelOrderTreversal(int val, levelOrderTreversal left, levelOrderTreversal right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public List<List<Integer>> levelOrder(levelOrderTreversal root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null)
            return ans;
        Queue<levelOrderTreversal> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> stage = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                levelOrderTreversal node = q.poll();
                if (node.left != null)
                    q.offer(node.left);
                if (node.right != null)
                    q.offer(node.right);
                stage.add(node.val);
            }
            ans.add(stage);
        }
        return ans;
    }
}
