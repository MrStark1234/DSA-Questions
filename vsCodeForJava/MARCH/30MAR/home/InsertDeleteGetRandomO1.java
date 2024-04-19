// leetcode-380. Insert Delete GetRandom O(1)
// https://leetcode.com/problems/insert-delete-getrandom-o1/description/
/*
The RandomizedSet class uses an  map (mp) to store the mapping of elements to their indices in the list (v). The list is used to store the actual elements.

The insert operation adds an element to the list and updates its index in the  map.
The remove operation swaps the element to be removed with the last element in the list, updates the index of the swapped element in the map, and then removes the last element from the list.
The getRandom operation generates a random index and returns the element at that index in the list.

*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

class RandomizedSet {
    Map<Integer, Integer> mp;
    List<Integer> v;
    Random rand;

    public RandomizedSet() {
        mp = new HashMap<>();
        v = new ArrayList<>();
        rand = new Random();
    }

    public boolean insert(int val) {
        if (mp.containsKey(val)) // check val is present or not
            return false;
        mp.put(val, v.size()); // updates the index
        v.add(val); // insert the value in list
        return true;
    }

    public boolean remove(int val) {
        if (!mp.containsKey(val))
            return false;
        int index_of_val = mp.get(val);
        // update the new index of last elemet beacuse it will change due to swap
        mp.put(v.get(v.size() - 1), index_of_val);
        Collections.swap(v, index_of_val, v.size() - 1);
        // now val will be the last element in list,
        v.remove(v.size() - 1);
        mp.remove(val);
        return true;
    }

    public int getRandom() {
        return v.get(rand.nextInt(v.size()));// // rand function will give the random value
    }
}