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

class LRUCache {
    HashMap<Integer, Integer> keyToVal;
    HashMap<Integer, Node> keyToNode;
    CustomLinkedList orderOfKeys;
    int cap;

    public LRUCache(int capacity) {
        cap = capacity;
        keyToVal = new HashMap<>();
        keyToNode = new HashMap<>();
        orderOfKeys = new CustomLinkedList();
    }

    private void updateTimeToNow(int key) {
        // If used before, get rid of the previous time data
        if (keyToNode.containsKey(key)) {
            Node nodeToDel = keyToNode.get(key);
            orderOfKeys.delNode(nodeToDel);
        }

        // Add to the tail of the list & update the reference
        Node newRef = orderOfKeys.pushBack(key);
        keyToNode.put(key, newRef);
    }

    private void evictAppropriately() {
        // Get the least recently used key
        int culpritKey = orderOfKeys.head.key;

        // Get rid of appropriate keys
        keyToVal.remove(culpritKey);
        keyToNode.remove(culpritKey);
        orderOfKeys.delNode(orderOfKeys.head);
    }

    public int get(int key) {
        // Before returning, we'll need to update the time.
        if (keyToVal.containsKey(key))
            updateTimeToNow(key);
        return keyToVal.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        keyToVal.put(key, value);
        updateTimeToNow(key);

        // Now, if size more than cap,
        // we'll need to evict the lru key.
        if (keyToVal.size() > cap)
            evictAppropriately();
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

class Main {
    public static void main(String[] args) {
        // Note: Don't change class name
        // your code goes here
    }
}
