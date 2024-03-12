/*
https://www.geeksforgeeks.org/problems/minimum-swaps/1

the idea is that to store sorted array in a vector along
with their indexes
then compare it to original array, if elements don't 
match  swap element of original array to correct 
position, and count the number of swaps required.
And update the new position in the map 
iterate this step until the end of array.
And to recheck the swapped element for comparison, 
decrement the loop counter.(i--)
Do a dry run of code 
*/

import java.util.*;

class Solution {
    // Function to find the minimum number of swaps required to sort the array.
    public int minSwaps(int nums[]) {
        // Code here
        Pair[] arr = new Pair[nums.length];

        for (int i = 0; i < nums.length; i++) {
            arr[i] = new Pair(nums[i], i);
        }

        Arrays.sort(arr, new Custom_Comparator());

        int swaps = 0;

        int i = 0;
        while (i < arr.length) {
            Pair p = arr[i];

            if (p.index == i) {
                i++;
            } else {
                Pair temp = arr[p.index];
                arr[p.index] = arr[i];
                arr[i] = temp;

                swaps++;
            }
        }

        return swaps;
    }

    public class Pair {
        int value;
        int index;

        Pair(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }

    class Custom_Comparator implements Comparator<Pair> {
        public int compare(Pair p1, Pair p2) {
            return p1.value - p2.value;
        }
    }
}
