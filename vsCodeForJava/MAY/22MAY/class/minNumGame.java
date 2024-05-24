// Link : https://leetcode.com/problems/minimum-number-game/

import java.util.ArrayList;

class MinHeap {
    private ArrayList<Integer> arr;
    private int n;

    private void swap(int i, int j) {
        int origAi = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, origAi);
    }

    private void siftUp(int curId) {
        while (curId > 1 && arr.get(curId / 2) > arr.get(curId)) {
            swap(curId, curId / 2);
            curId /= 2; // move to the parent node for further sifting
        }
    }

    private void siftDown(int curId) {
        while (2 * curId <= n) { // While there is at least 1 child
            int leftVal = arr.get(2 * curId);
            int rightVal = 2 * curId + 1 <= n ? arr.get(2 * curId + 1) : Integer.MAX_VALUE;

            if (arr.get(curId) <= Math.min(leftVal, rightVal))
                break; // All well, I'm already better than both the children

            int betterChild = leftVal < rightVal ? 2 * curId : 2 * curId + 1;
            swap(curId, betterChild);
            curId = betterChild;
        }
    }

    public MinHeap() {
        arr = new ArrayList<>();
        arr.add(-1); // Garbage value at index 0;
        n = 0;
    }

    public MinHeap(int[] nums) {
        arr = new ArrayList<>();
        arr.add(-1); // Garbage value at index 0;
        n = 0;

        // Adding the numbers to arr
        for (int num : nums) {
            arr.add(num);
            n += 1;
        }

        // Sifting Down appropriately
        for (int i = n; i >= 1; --i)
            siftDown(i);
    }

    public void add(int num) {
        n += 1;
        if (n < arr.size())
            arr.set(n, num);
        else
            arr.add(num);
        siftUp(n);
    }

    public int poll() {
        int valToDelete = arr.get(1);
        swap(1, n);
        n -= 1;
        siftDown(1);
        return valToDelete;
    }

    public int peek() {
        return arr.get(1);
    }

    public int size() {
        return n;
    }
}

class Solution {
    public int[] numberGame(int[] nums) {
        MinHeap hp = new MinHeap(nums);
        int ans[] = new int[nums.length];

        for (int i = 0; i < ans.length; i += 2) {
            int aliceNum = hp.poll();
            int bobNum = hp.poll();

            ans[i] = bobNum;
            ans[i + 1] = aliceNum;
        }

        return ans;
    }
}