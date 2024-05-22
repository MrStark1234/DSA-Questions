//https://leetcode.com/problems/find-a-corresponding-node-of-a-binary-tree-in-a-clone-of-that-tree/

public class getTargetCopy {
    int val;
    getTargetCopy left;
    getTargetCopy right;

    getTargetCopy() {
    }

    getTargetCopy(int val) {
        this.val = val;
    }

    getTargetCopy(int val,
            getTargetCopy left,
            getTargetCopy right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public getTargetCopy getTargetCopy(
            getTargetCopy original,
            getTargetCopy cloned,
            getTargetCopy target) {
        if (original == null) {
            return null;
        }

        if (original == target) {
            return cloned;
        }

        getTargetCopy leftResult = getTargetCopy(original.left,
                cloned.left, target);
        if (leftResult != null) {
            return leftResult;
        }

        return getTargetCopy(original.right, cloned.right, target);
    }
}
