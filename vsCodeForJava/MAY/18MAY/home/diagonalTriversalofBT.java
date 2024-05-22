/*
To Solve this problem, we will use queue data Structure.

We will follow the steps:

Push the root in the queue.
Now, till the queue is empty follow the following steps.
Pop the front element of the queue and check if it is 
null or not.
If it's not null, we will push the left child of the 
element (if not null)  in the queue.
We will push the element data in vector.
Replace the element with its right child.
Follow the steps tiff queue is not empty.
Now, the time-complexity will be O(n) as we have to 
iterate over all elements of the binary Tree.

The space complexity will be O(n) as we are using 
a queue to store the Nodes of binary Tree.
*/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class diagonalTriversalofBT {
    int val;
    diagonalTriversalofBT left;
    diagonalTriversalofBT right;
    public Integer data;

    diagonalTriversalofBT() {
    }

    diagonalTriversalofBT(int val) {
        this.val = val;
    }

    diagonalTriversalofBT(int val,
            diagonalTriversalofBT left,
            diagonalTriversalofBT right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Tree {
    public ArrayList<Integer> diagonal(diagonalTriversalofBT root) {
        // add your code here.
        /*
         * This comment Structure is just for better understanding of question-
         * by @rohitsinha969
         * To solve this we will create a queue and an arraylist.
         * now the thoery is if the root node has left and right elements then we will
         * add the right element in the array and left element in the queue.
         * once one diagonal hand is completed then we will add the first element of the
         * queue to the arraylist and we will pop the same element and we will repeat
         * this till we complete all the diagonal hands.
         * example
         * for 1st diagonal hand...
         * arr.add(q.add(temp.right)) = 8 10 14
         * q.add(temp.left) = 3 13
         * for 2nd diagonal hand...
         * arr.add(q.add(temp.right)) = 8 10 14 3 6 7 13
         * q.add(temp.left) = 3-X 13-X 1 4
         * // 3 and 13 got popped out and 1 and 4 were added
         * for 3rd diagonal hand...
         * arr.add(q.add(temp.right)) = 8 10 14 3 6 7 13 1 4
         * q.add(temp.left) = 3-X 13-X 1-X 4-X
         * // 3 13 1 and 4 all got popped out from the queue and q became empty
         * but array is now ready with the expected answer
         */
        Queue<diagonalTriversalofBT> cue = new LinkedList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        cue.add(root);

        while (!cue.isEmpty()) {
            diagonalTriversalofBT temp = cue.remove();

            while (temp != null) {
                if (temp.left != null) {
                    cue.add(temp.left);
                }
                ans.add(temp.data);
                temp = temp.right;
            }
        }
        return ans;
    }
}