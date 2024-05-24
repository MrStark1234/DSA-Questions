// https://www.geeksforgeeks.org/problems/merge-k-sorted-arrays/1

// In this problem, we insert the first element of all 
// the k sorted arrays in a max heap. Now, the minimum 
// element will be among these k elements only. Then we 
// extract the min. Element and push the next element of 
// the array from which this min. Elements came till all 
// the elements of all the k arrays are exhausted. 

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    // Function to merge k sorted arrays.
    public static ArrayList<Integer> mergeKArrays(int[][] arr, int K) {
        ArrayList<Integer> output = new ArrayList<>();

        // The priority queue will store elements as int[] of the form {element, array
        // index, next element index}
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[0], b[0]); // min-heap based on the element value
            }
        });

        // Initialize the heap with the first element of each array
        for (int i = 0; i < K; i++) {
            if (arr[i].length > 0) {
                pq.add(new int[] { arr[i][0], i, 1 });
            }
        }

        // Now one by one extract the minimum element from the heap and replace it with
        // the next element of the same array
        while (!pq.isEmpty()) {
            int[] minElement = pq.poll();

            int element = minElement[0];
            int arrayIndex = minElement[1];
            int nextIndex = minElement[2];

            output.add(element);

            // Get the next element from the same array
            if (nextIndex < arr[arrayIndex].length) {
                pq.add(new int[] { arr[arrayIndex][nextIndex], arrayIndex, nextIndex + 1 });
            }
        }

        return output;
    }
}
