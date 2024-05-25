// Link : https://leetcode.com/problems/search-suggestions-system/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Node {
    int prefCount;
    int endCount;
    Map<Character, Node> child;

    Node() {
        prefCount = 0;
        endCount = 0;
        child = new HashMap<>();
    }
}

class Trie {
    Node root;

    private void DFS(Node curNode, StringBuilder curString, List<String> ans) {
        if (ans.size() == 3)
            return;

        if (curNode.endCount > 0)
            ans.add(curString.toString());

        // Let's go in increasing order of characters
        for (char ch = 'a'; ch <= 'z'; ++ch) {
            if (!curNode.child.containsKey(ch))
                continue;
            curString.append(ch);
            DFS(curNode.child.get(ch), curString, ans);
            curString.deleteCharAt(curString.length() - 1);
        }
    }

    public Trie() {
        root = new Node();
    }

    public void insert(String word) { // Time = O(length of word)
        Node cur = root;

        for (char ch : word.toCharArray()) {

            cur.prefCount += 1;

            if (!cur.child.containsKey(ch))
                cur.child.put(ch, new Node());

            cur = cur.child.get(ch);
        }

        // Reached the node corresponding to the last character.
        cur.prefCount += 1;
        cur.endCount += 1;
    }

    List<String> getTop3Words(String w) { // O(length(longest String))
        // Let's go to the node corresponding to w first.
        Node cur = root;
        for (char ch : w.toCharArray()) {
            if (!cur.child.containsKey(ch))
                return new ArrayList<>(); // Return empty list
            cur = cur.child.get(ch);
        }

        // Now, we're at the node corresponding to the prefix.
        // Notice, that pre-order traversal will be in lexicographical
        // order => curNode -> child['a'] -> child['b'] .... child['z']
        List<String> ans = new ArrayList<>();
        StringBuilder curString = new StringBuilder(w);
        DFS(cur, curString, ans);
        return ans;
    }
}

class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Trie t = new Trie();

        for (String product : products)
            t.insert(product);

        List<List<String>> ans = new ArrayList<>();
        for (int l = 1; l <= searchWord.length(); ++l)
            ans.add(t.getTop3Words(searchWord.substring(0, l)));

        return ans;
    }
}