// class ListNode {
//   constructor(val) {
//     this.val = val;
//     this.next = null;
//   }
// }

// function getLength(head) {
//   let cur = head;
//   let len = 0;
//   while (cur !== null) {
//     cur = cur.next;
//     len += 1;
//   }
//   return len;
// }

// function giveTheEdge(cur, iterations) {
//   for (let i = 0; i < iterations; ++i) cur = cur.next;
//   return cur;
// }

// var getIntersectionNode = function (headA, headB) {
//   const l1 = getLength(headA);
//   const l2 = getLength(headB);

//   let cur1 = headA;
//   let cur2 = headB;

//   if (l1 > l2) {
//     cur1 = giveTheEdge(headA, l1 - l2);
//   } else {
//     cur2 = giveTheEdge(headB, l2 - l1);
//   }

//   while (cur1 !== cur2) {
//     cur1 = cur1.next;
//     cur2 = cur2.next;
//   }

//   return { cur1 };
// };

// const listA = new ListNode(4);
// listA.next = new ListNode(1);
// listA.next.next = new ListNode(12);
// listA.next.next.next = new ListNode(4);
// listA.next.next.next.next = new ListNode(5);

// const listB = new ListNode(5);
// listB.next = new ListNode(6);
// listB.next.next = new ListNode(1);
// listB.next.next.next = listA.next.next; // Intersect at node with value 8

// console.log(getIntersectionNode(listA, listB));

// const subArray = (arr, k) => {
//   let n = arr.length;
//   let left = 0;
//   let right = 0;
//   let max = 0;
//   let sum = arr[0];

//   while (right < n) {
//     while (left <= right && sum > k) {
//       sum -= arr[left];
//       left++;
//     }

//     if (sum === k) max = Math.max(max, right - left + 1);

//     right++;
//     if (right < n) sum += arr[right];
//   }
//   return max;
// };
// console.log(subArray([1, 2, 1, 1, 2, 3, 5, 2], 5));
