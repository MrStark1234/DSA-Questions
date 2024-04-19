/*
https://leetcode.com/problems/can-place-flowers/ 

We can just greedily try to put the flowers if the given 
condition of adjacency holds true. It will work because we 
will place the flower on ith position only when 
i-1    i     i+1
0      0     0
So for this case, if we don’t put the flower on the ith place, 
then we are eligible to only put flower on (i+1) th place using
 that situation i.e. the count of new flowers remains same or 
 less because putting flower on (i+1) th place also involves 
 checking (i+2) th place

*/

class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0 && (i == 0 || flowerbed[i - 1] == 0)
                    && (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)) {
                flowerbed[i] = 1;
                count++;
            }
        }
        return count >= n;
    }
}
