// https://leetcode.com/problems/unique-number-of-occurrences/description/
// Leetcode: Unique Number of Occurrences

/*
The problem asks whether the number of occurrences of each unique value in the array is unique. So for each distinct element in the array, we need to count how many times it appears, and then check if the counts themselves are all unique.
Iterate through the array and count the occurrences of each unique value. You can use a data structure for hasing  to keep track of these counts.
After counting the occurrences, we need to check if the counts themselves are unique.
We can do this with another data structure, like a set, to keep track of the unique counts.
*/

// import java.util.HashMap;
// import java.util.HashSet;
// import java.util.Map;
// import java.util.Set;
import java.util.*;

class uniqueoccu {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        Set<Integer> set = new HashSet<>();

        for (int count : map.values()) {
            set.add(count);
        }

        return map.size() == set.size();
    }
}