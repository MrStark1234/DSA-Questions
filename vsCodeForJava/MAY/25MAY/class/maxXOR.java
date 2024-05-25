// Link : https://leetcode.com/problems/maximum-xor-of-two-numbers-in-an-array/ 

class Node {
    // endCnt, preCnt not required.
    Node child[]; // child[0] -> child with bit = 0, child[1] -> child with bit = 1

    Node() {
        child = new Node[2];
    }
}

class Trie {
    Node root;

    Trie() {
        root = new Node();
    }

    void insert(int num) {
        Node cur = root;
        // most significant bit first
        for (int i = 30; i >= 0; --i) {
            int b = (num >> i) & 1; // Get the value of ith bit
            if (cur.child[b] == null) // if child[b] doesn't exist, make a new node.
                cur.child[b] = new Node();
            cur = cur.child[b];
        }
    }

    int maxXOR(int num) { // Assuming non-empty Trie
        int ans = 0;
        Node cur = root;
        for (int i = 30; i >= 0; --i) {
            int b = (num >> i) & 1; // Get the value of ith bit
            if (cur.child[1 - b] != null) { // Try to go to the opposite bit
                ans += (1 << i);
                cur = cur.child[1 - b];
            } else { // No other option, go to the same bit value
                cur = cur.child[b];
            }
        }
        return ans;
    }
}

class Solution {
    public int findMaximumXOR(int[] nums) {
        Trie t = new Trie();
        int ans = 0;
        for (int num : nums) {
            t.insert(num);
            ans = Math.max(ans, t.maxXOR(num));
        }
        return ans;
    }
}