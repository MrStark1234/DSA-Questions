// Link : https://leetcode.com/problems/find-median-from-data-stream

import java.util.*;

class MedianFinder {

    PriorityQueue<Integer> smallHalf, bigHalf;
    int size;

    public MedianFinder() {
        smallHalf = new PriorityQueue<>(Collections.reverseOrder()); // Max Heap
        bigHalf = new PriorityQueue<>(); // Min Heap
        size = 0;
    }

    public void addNum(int num) { // O(logN)
        if (size == 0) {
            smallHalf.add(num);
            size = 1;
            return;
        }

        // Current size is even, therefore both halves have same elements
        if (size % 2 == 0) {
            if (num <= smallHalf.peek()) {
                smallHalf.add(num);
            } else {
                bigHalf.add(num);
                smallHalf.add(bigHalf.poll()); // Transfer 1 element from bigHalf to smallHalf
            }
        }

        else { // Currently, smallHalf has 1 element extra
            if (num >= smallHalf.peek()) {
                bigHalf.add(num);
            } else {
                smallHalf.add(num);
                bigHalf.add(smallHalf.poll()); // Transfer 1 element from smallHalf to bigHalf
            }
        }

        size += 1;
    }

    public double findMedian() { // O(1)
        if (size % 2 == 1)
            return smallHalf.peek();
        return (smallHalf.peek() + bigHalf.peek()) / 2.0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */