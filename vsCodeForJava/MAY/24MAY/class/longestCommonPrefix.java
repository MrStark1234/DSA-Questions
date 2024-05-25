// Link : https://leetcode.com/problems/find-the-length-of-the-longest-common-prefix/

import java.util.*;

class Node {
    int prefCount1;
    int prefCount2;
    int endCount;
    Map<Character, Node> child;

    Node() {
        prefCount1 = 0;
        prefCount2 = 0;
        endCount = 0;
        child = new HashMap<>();
    }
}

class Trie {
    Node root;

    int lcpHelper(Node curNode, int curDepth) {

        if (curNode.prefCount1 == 0 || curNode.prefCount2 == 0)
            return 0;

        // Let's take max of current answer and children's answer
        int curMax = curDepth;

        for (char ch = '0'; ch <= '9'; ++ch) {
            if (!curNode.child.containsKey(ch))
                continue;
            int childMax = lcpHelper(curNode.child.get(ch), curDepth + 1);
            curMax = Math.max(curMax, childMax);
        }
        return curMax;
    }

    public Trie() {
        root = new Node();
    }

    public void insert(String num, int arrNum) { // Time = O(length of num)
        Node cur = root;

        for (char ch : num.toCharArray()) {

            if (arrNum == 1)
                cur.prefCount1 += 1;
            else
                cur.prefCount2 += 1;

            if (!cur.child.containsKey(ch))
                cur.child.put(ch, new Node());

            cur = cur.child.get(ch);
        }

        // Reached the node corresponding to the last character.
        if (arrNum == 1)
            cur.prefCount1 += 1;
        else
            cur.prefCount2 += 1;
        cur.endCount += 1;
    }

    public int getLCP() {
        return lcpHelper(root, 0);
    }
}

class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        Trie t = new Trie();

        for (int num : arr1)
            t.insert(Integer.toString(num), 1);

        for (int num : arr2)
            t.insert(Integer.toString(num), 2);

        return t.getLCP();
    }
}