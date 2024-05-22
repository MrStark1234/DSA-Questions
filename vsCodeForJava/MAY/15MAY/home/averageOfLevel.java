import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class averageOfLevel {
    int val;
    averageOfLevel left;
    averageOfLevel right;

    averageOfLevel() {
    }

    averageOfLevel(int val) {
        this.val = val;
    }

    averageOfLevel(int val,
            averageOfLevel left,
            averageOfLevel right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public List<Double> averageOfLevels(averageOfLevel root) {
        List<Double> res = new ArrayList<>();
        Queue<averageOfLevel> queue = new LinkedList<>();

        if (root == null) {
            return res;
        }

        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            long sum = 0;

            for (int i = 0; i < size; i++) {
                averageOfLevel node = queue.poll();
                sum += node.val;

                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

            double average = (double) sum / size;
            res.add(average);
        }

        return res;
    }
}
