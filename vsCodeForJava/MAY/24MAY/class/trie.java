// Link : https://leetcode.com/problems/implement-trie-prefix-tree/

import java.util.*;

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

    private Node removeHelper(Node cur, String s, int id) {
        cur.prefCount -= 1;

        if (id == s.length() - 1) {
            cur.endCount -= 1;
        } else {
            Node resultant = removeHelper(cur.child.get(s.charAt(id + 1)), s, id + 1);
            if (resultant == null)
                cur.child.remove(s.charAt(id + 1));
        }

        if (cur.prefCount > 0) // more strings need this node.
            return cur;

        return null; // no string needs this node.
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

    public boolean search(String word) { // Time = O(length of word)
        Node cur = root;

        for (char ch : word.toCharArray())
            if (!cur.child.containsKey(ch))
                return false;
            else
                cur = cur.child.get(ch); // Move to the appropriate child

        return (cur.endCount > 0);
    }

    public boolean startsWith(String prefix) { // Time = O(length of prefix)
        Node cur = root;

        for (char ch : prefix.toCharArray())
            if (!cur.child.containsKey(ch))
                return false;
            else
                cur = cur.child.get(ch); // Move to the appropriate child

        return (cur.prefCount > 0);
    }

    public boolean remove(String word) { // Assuming non-empty word
        if (!search(word))
            return false;

        root.prefCount -= 1;
        Node resultant = removeHelper(root.child.get(word.charAt(0)), word, 0);

        if (resultant == null)
            root.child.remove(word.charAt(0));
        return true;
    }
}

class Main {
    public static void main(String[] args) {
        Trie t = new Trie();
        t.insert("abc");
        t.insert("abcd");
        t.insert("hi");
        t.insert("hello");
        System.out.println(t.search("hi"));
        t.remove("hi");
        System.out.println(t.search("hi"));
        t.insert("hello");
        System.out.println(t.search("hello"));
        t.remove("hello");
        System.out.println(t.search("hello"));
        t.remove("hello");
        System.out.println(t.search("hello"));
    }
}
