//Leetcode -Design Linked 
// https://leetcode.com/problems/design-linked-list/description/

class Node {
    public int val;
    public Node prev;
    public Node next;

    public Node(int val, Node prev, Node next) {
        this.val = val;
        this.prev = prev;
        this.next = next;
    }
}

class MyLinkedList {
    int size;
    Node head;

    // Helper method to find the node at an index
    Node getNode(int index) {
        Node node = head;
        for (int i = 0; i < index; ++i) {
            node = node.next;
        }
        return node;
    }

    public MyLinkedList() {
        size = 0;
        head = null;
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }

        Node curr = getNode(index);
        return curr.val;
    }

    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    public void addAtIndex(int index, int val) {
        if (index > size) {
            return;
        }

        if (index <= 0) {
            head = new Node(val, null, head);
            if (head.next != null) {
                head.next.prev = head;
            }
        } else {
            Node prevNode = getNode(index - 1);
            Node nextNode = prevNode.next;
            // Now, add the new node after this
            // and adjust the links
            Node newNode = new Node(val, prevNode, nextNode);

            prevNode.next = newNode;

            if (nextNode != null) {
                nextNode.prev = newNode;
            }
        }

        size++;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }

        if (index == 0) {
            head = head.next;
            if (head != null) {
                head.prev = null;
            }
        } else {
            Node prevNode = getNode(index - 1);
            Node nextNode = prevNode.next.next;

            prevNode.next = nextNode;

            if (nextNode != null) {
                nextNode.prev = prevNode;
            }
        }

        size--;
    }
}
