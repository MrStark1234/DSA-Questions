
/*
The intuition behind the code is to 
optimize the tower height modifications by 
sorting the array, enabling efficient consideration of 
potential minimum and maximum values for each tower. The 
algorithm iterates through the array, calculating the minimum 
and maximum possible heights for each tower while adhering to the
 specified operations. By updating the overall minimum difference 
 between the tallest and shortest towers, the code ensures a balanced 
 and minimal adjustment to each tower's height.
*/
import java.util.*;

import javafx.util.Pair;

class MinimizeTheHeight {
    public int getMinDiff(int[] arr, int n, int k) {
        List<Pair<Integer, Integer>> v = new ArrayList<>();
        int[] taken = new int[n];

        // Store all possible heights in a list
        for (int i = 0; i < n; i++) {
            if (arr[i] - k >= 0) {
                v.add(new Pair<>(arr[i] - k, i));
            }
            v.add(new Pair<>(arr[i] + k, i));
        }
        Collections.sort(v, Comparator.comparingInt(Pair::getKey));
        int elementsInRange = 0;
        int left = 0;
        int right = 0;

        // Traverse v using two pointers
        while (elementsInRange < n && right < v.size()) {
            if (taken[v.get(right).getValue()] == 0) {
                elementsInRange++;
            }
            taken[v.get(right).getValue()]++;
            right++;
        }
        int ans = v.get(right - 1).getKey() - v.get(left).getKey();
        while (right < v.size()) {
            if (taken[v.get(left).getValue()] == 1) {
                elementsInRange--;
            }
            taken[v.get(left).getValue()]--;
            left++;

            while (elementsInRange < n && right < v.size()) {
                if (taken[v.get(right).getValue()] == 0) {
                    elementsInRange++;
                }
                taken[v.get(right).getValue()]++;
                right++;
            }

            if (elementsInRange == n) {
                ans = Math.min(ans, v.get(right - 1).getKey() - v.get(left).getKey());
            } else {
                break;
            }
        }
        return ans;
    }
}
