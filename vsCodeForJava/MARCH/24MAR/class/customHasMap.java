import java.util.*;

import javafx.util.Pair;

class MyHashMap {
    private final int INITIAL_SIZE = 16;
    private final double MAX_LOAD_FACTOR = 0.75;
    private ArrayList<LinkedList<Pair<Integer, Integer>>> arr;
    private int curSize, curBuckets;

    private int hash(int key) {
        return key % curBuckets; // [0, curBuckets - 1]
    }

    private void rehash() {
        ArrayList<LinkedList<Pair<Integer, Integer>>> arr2 = new ArrayList<>();

        // Number of buckets doubled.
        curBuckets *= 2;
        for (int i = 0; i < curBuckets; ++i) {
            arr2.add(new LinkedList<>());
        }

        // Go to all the elements in the old Array & add to new Array
        for (LinkedList<Pair<Integer, Integer>> ll : arr) {
            @SuppressWarnings("rawtypes")
            Iterator it = ll.iterator();
            while (it.hasNext()) {
                @SuppressWarnings("unchecked")
                Pair<Integer, Integer> curPair = (Pair<Integer, Integer>) it.next();
                int newId = hash(curPair.getKey());
                arr2.get(newId).addFirst(curPair);
            }
        }

        arr = arr2; // Update the arr;
    }

    private double curLoadFactor() {
        return curSize / (double) curBuckets;
    }

    private int get(LinkedList<Pair<Integer, Integer>> ll, int key) {
        @SuppressWarnings("rawtypes")
        Iterator it = ll.iterator();
        int id = 0;
        while (it.hasNext()) {
            @SuppressWarnings("unchecked")
            Pair<Integer, Integer> curPair = (Pair<Integer, Integer>) it.next();
            if (curPair.getKey() == key)
                return id;
            id++;
        }
        return -1;
    }

    public MyHashMap() {
        curSize = 0;
        curBuckets = INITIAL_SIZE;
        arr = new ArrayList<>();
        for (int i = 0; i < curBuckets; ++i) {
            arr.add(new LinkedList<>());
        }
    }

    public int get(int key) {
        int i = hash(key);
        @SuppressWarnings("rawtypes")
        Iterator it = arr.get(i).iterator();
        while (it.hasNext()) {
            @SuppressWarnings("unchecked")
            Pair<Integer, Integer> curPair = (Pair<Integer, Integer>) it.next();
            if (curPair.getKey() == key)
                return curPair.getValue();
        }
        return -1;
    }

    public void put(int key, int value) {
        int i = hash(key);
        int keyId = get(arr.get(i), key);

        if (keyId == -1)
            arr.get(i).addFirst(new Pair<Integer, Integer>(key, value));
        else {
            arr.get(i).set(keyId, new Pair<Integer, Integer>(key, value));
            curSize += 1;
        }

        if (curLoadFactor() > MAX_LOAD_FACTOR)
            rehash();
    }

    public void remove(int key) {
        int i = hash(key);
        int keyId = get(arr.get(i), key);

        if (keyId != -1) {
            arr.get(i).remove(keyId);
            curSize -= 1;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */