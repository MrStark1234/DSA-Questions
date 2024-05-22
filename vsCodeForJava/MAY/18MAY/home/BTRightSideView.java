/*
APPROACH with no extra space

Maintain an array / vector.

TRAVERSAL -> ROOT ->RIGHT -> LEFT This is the way traversal is done in array so that rightmost node at i level is visited first.

When at i level, check in array/vector, if there is an element already present at indexi in the array.
[ index represents the level in tree ]->[element at index i is rightmost node at level i]

If at that level, element is present,, just continue the traversal.

Else if no element is present at index i -> add that node to answer [res] at the i index.
*/

import java.util.ArrayList;
import java.util.List;

public class BTRightSideView {
    int val;
    BTRightSideView left;
    BTRightSideView right;
    public Integer data;

    BTRightSideView() {
    }

    BTRightSideView(int val) {
        this.val = val;
    }

    BTRightSideView(int val,
            BTRightSideView left,
            BTRightSideView right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

// public class Solution {
// public List<Integer> rightSideView(BTRightSideView root) {
// List<Integer> result = new ArrayList<Integer>();
// rightView(root, result, 0);
// return result;
// }

// public void rightView(BTRightSideView curr, List<Integer> result, int
// currDepth) {
// if (curr == null) {
// return;
// }
// if (currDepth == result.size()) {
// result.add(curr.val);
// }

// rightView(curr.right, result, currDepth + 1);
// rightView(curr.left, result, currDepth + 1);

// }
// }