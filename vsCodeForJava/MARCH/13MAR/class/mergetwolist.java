// problem Link : -  https://leetcode.com/problems/merge-two-sorted-lists/

public class mergetwolist {
    int val;
    mergetwolist next;

    mergetwolist() {
    }

    mergetwolist(int val) {
        this.val = val;
    }

    mergetwolist(int val, mergetwolist next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {
    public mergetwolist mergeTwoLists(mergetwolist list1, mergetwolist list2) {
        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;

        if (list1.val < list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }
}