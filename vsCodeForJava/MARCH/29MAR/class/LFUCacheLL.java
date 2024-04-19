import java.util.*;

class Node {
    int key;
    Node next;
    Node prev;

    Node(int d) {
        key = d;
        next = prev = null;
    }
}

class CustomLinkedList {
    Node head;
    Node tail;
    int size;

    CustomLinkedList() {
        head = tail = null;
        size = 0;
    }

    Node pushBack(int num) {
        Node newNode = new Node(num);

        if (size == 0) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;

            tail = newNode;
        }
        size += 1;
        return newNode;
    }

    void delNode(Node cur) {
        // curPrev - cur - curNext
        if (size == 1) {
            head = tail = null;
        } else if (cur == head) {
            head = cur.next;
            head.prev = null;
        } else if (cur == tail) {
            tail = cur.prev;
            tail.next = null;
        } else {
            Node nextNode = cur.next;
            Node prevNode = cur.prev;

            prevNode.next = nextNode;
            nextNode.prev = prevNode;
        }
        size -= 1;
    }
}

class LFUCache {
    HashMap<Integer, Integer> keyToVal;
    HashMap<Integer, Integer> keyToFreq;
    HashMap<Integer, Node> keyToNode;
    TreeMap<Integer, CustomLinkedList> freqToKeys;
    int cap;

    void evictAppropriately() {
        int minFreq = freqToKeys.firstKey();
        Node headNode = freqToKeys.get(minFreq).head;
        int culpritKey = headNode.key;

        keyToVal.remove(culpritKey);
        keyToFreq.remove(culpritKey);
        keyToNode.remove(culpritKey);
        freqToKeys.get(minFreq).delNode(headNode);
        if (freqToKeys.get(minFreq).size == 0)
            freqToKeys.remove(minFreq);
    }

    void transferFreq(int key) {

        // Getting rid of the old node.
        int oldFreq = keyToFreq.get(key);
        Node nodeToDel = keyToNode.get(key);
        freqToKeys.get(oldFreq).delNode(nodeToDel);
        if (freqToKeys.get(oldFreq).size == 0)
            freqToKeys.remove(oldFreq);

        // Correcting stuff.
        keyToFreq.put(key, oldFreq + 1);
        if (!freqToKeys.containsKey(oldFreq + 1)) {
            freqToKeys.put(oldFreq + 1, new CustomLinkedList());
        }
        freqToKeys.get(oldFreq + 1).pushBack(key);
        keyToNode.put(key, freqToKeys.get(oldFreq + 1).tail);
    }

    public LFUCache(int capacity) {
        cap = capacity;
        keyToVal = new HashMap<>();
        keyToFreq = new HashMap<>();
        keyToNode = new HashMap<>();
        freqToKeys = new TreeMap<>();
    }

    public int get(int key) {
        if (!keyToVal.containsKey(key))
            return -1;

        /*
         * 1. Remove it from old freq list.
         * 2. Add to the back of the new freq list.
         * 3. Update the keyToFreq & keyToNode etc.
         */
        transferFreq(key);

        return keyToVal.get(key);
    }

    public void put(int key, int value) {
        if (keyToVal.containsKey(key)) {
            transferFreq(key);
            keyToVal.put(key, value);
            return;
        }
        // Definitely a new key.
        if ((int) keyToVal.size() == cap) {
            evictAppropriately();
        }

        keyToVal.put(key, value);
        keyToFreq.put(key, 1);
        if (!freqToKeys.containsKey(1))
            freqToKeys.put(1, new CustomLinkedList());
        freqToKeys.get(1).pushBack(key);
        keyToNode.put(key, freqToKeys.get(1).tail);
    }
}

class Main {
    public static void main(String[] args) {
        // Note: Don't change class name
        // your code goes here
    }
}