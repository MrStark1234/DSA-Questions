
//{ Driver Code Starts
import java.io.*;

import java.util.*;

// Link : https://www.geeksforgeeks.org/problems/fractional-knapsack-1587115620/1
// Time : O(NlogN)

class Item {
    int value, weight;

    Item(int x, int y) {
        this.value = x;
        this.weight = y;
    }
}

class Solution {
    // Function to get the maximum total value in the knapsack.
    double fractionalKnapsack(int W, Item arr[], int n) {
        Arrays.sort(arr, new Comparator<Item>() {
            public int compare(Item i1, Item i2) {
                // negative if i1 should come first.
                return i2.value * i1.weight - i1.value * i2.weight;
            }
        });
        double ans = 0.0;
        for (int i = 0; i < n; ++i) {
            if (W >= arr[i].weight) {
                ans += arr[i].value;
                W -= arr[i].weight;
            } else {
                ans += (W / (double) arr[i].weight) * arr[i].value;
                break;
            }
        }
        return ans;
    }
}

class GfG {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String inputLine[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int w = Integer.parseInt(inputLine[1]);
            Item[] arr = new Item[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0, k = 0; i < n; i++) {
                arr[i] = new Item(Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]));
            }
            System.out.println(String.format("%.6f", new Solution().fractionalKnapsack(w, arr, n)));
        }
    }
}
// } Driver Code Ends

/*
 * class Item {
 * int value, weight;
 * Item(int x, int y){
 * this.value = x;
 * this.weight = y;
 * }
 * }
 */
