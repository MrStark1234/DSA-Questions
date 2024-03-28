class Solution {
    public int trap(int[] height) {

        int max1 = 0;
        // create left array so that we find the maximum element on its left
        int left[] = new int[height.length];

        for (int i = 0; i < height.length; i++) {
            // Find maximum element on its left side
            if (max1 < height[i]) {
                max1 = height[i];
            }
            left[i] = max1;
        }

        int max2 = 0;
        // create right array so that we find the maximum element on its right
        int right[] = new int[height.length];
        for (int i = height.length - 1; i >= 0; i--) {
            // Find maximum element on its left side
            if (max2 < height[i]) {
                max2 = height[i];
            }
            right[i] = max2;
        }

        int trap = 0;
        // Calculate maximum trapped water
        for (int i = 0; i < height.length; i++) {
            trap += Math.min(left[i], right[i]) - height[i];
        }
        return trap;
    }
}
