// var addDigits = function (num) {
//   if (num < 1) return 0;

//   while (num >= 10) {
//     num = num
//       .toString()
//       .split("")
//       .reduce((sum, digit) => sum + parseInt(digit, 10), 0);
//   }
//   return num;
// };
// console.log(addDigits(38));

// function isPrime(N) {
//   if (N < 4) return "Invalid Input";
//   let prime = true;
//   for (let i = 2; i < N - 1; i++) {
//     if (N % i == 0) {
//       console.log("Divisible By " + i);
//       prime = false;
//       break;
//     }
//   }
//   if (prime) {
//     console.log(N + " is a Prime Number");
//   } else {
//     console.log(N + " is not a Prime Number");
//   }
// }

// console.log(isPrime(10));

// function countPrimes(N) {
//   for (let i = 2; i < N; i++) {
//     let isPrime = true;

//     for (let j = 2; j <= i; j++) {
//       if (i % j === 0) {
//         isPrime = false;
//         break;
//       }
//     }

//     if (isPrime) {
//       console.log(i);
//     }
//   }
// }

// console.log(countPrimes(10));

// function digitcount(n, m) {
//   let count = 0;
//   for (let j = n; j <= m; j++) {
//     let sum = 0;
//     for (let i = j; i > 0; i = Math.floor(i / 10)) {
//       let lastdigit = i % 10;
//       sum += lastdigit;
//     }
//     count += sum;
//     console.log(sum);
//   }
//   console.log(count);
// }
// console.log(digitcount(5096, 5101));

// function arrsort(arr) {
//   let n = arr.length;
//   if (n === 1 || n === 0) return 1;
//   for (let i = 0; i < n; i++) {
//     if (arr[i] > arr[i + 1]) {
//       return 0;
//     } else {
//       return 1;
//     }
//   }
// }
// console.log(arrsort([2, 2, 2, 2]));

// function getMinMax(arr, n) {
//   let min = arr[0];
//   let max = arr[0];
//   for (let i = 1; i < n; i++) {
//     if (arr[i] > max) {
//       max = arr[i];
//     }
//     if (arr[i] < min) {
//       min = arr[i];
//     }
//   }
//   return { max, min };
// }
// console.log(getMinMax([4, 1, 8, 9, 13, 12, 14, 7], 8));

// function maxFreq(arr) {
//   let maxfrek = 0;
//   for (let i = 0; i < arr.length; i++) {
//     maxfrek = Math.max(arr[i]);
//   }
//   let ans = 0;
//   for (let i = 0; i < arr.length; i++) {
//     if (arr[i] == maxfrek) {
//       ans += maxfrek;
//     }
//   }
//   return ans;
// }
// console.log(maxFreq([1, 2, 2, 3, 1, 6]));

// function maxFreq(arr) {
//   let maxFreq = 0;
//   let ans = [];

//   for (let i = 0; i < arr.length; i++) {
//     let occurence = 0;
//     for (let j = 0; j < arr.length; j++) {
//       if (arr[i] === arr[j]) {
//         occurence++;
//       }
//     }

//     if (occurence === maxFreq) {
//       ans.push(arr[i]);
//     } else if (occurence > maxFreq) {
//       maxFreq = occurence;
//       ans = [arr[i]];
//     }
//   }

//   return ans.length;
// }

// console.log(maxFreq([1, 2, 3, 4, 5]));

// function printPattern(rows) {
//   let num = 1;
//   let result = "";
//   for (let i = 1; i <= rows; i++) {
//     let pattern = "";
//     for (let j = 0; j < i; j++) {
//       pattern += num;
//       num = 1 - num;
//     }
//     result += pattern + "\n";
//   }
//   return result;
// }

// console.log(printPattern(5));

// function printPyramid(N) {
//   for (let i = 1; i <= N; i++) {
//     let stars = "";
//     let space = "";
//     for (let s = 1; s <= N - i; s++) {
//       space += " ";
//     }
//     for (let j = 1; j <= 2 * i - 1; j++) {
//       stars += "*";
//     }

//     console.log(space + stars);
//   }
// }

// // Example usage:
// console.log(printPyramid(5));

// function countValidIntegers(constraints) {
//   let minValid = Number.MIN_SAFE_INTEGER;
//   let maxValid = Number.MAX_SAFE_INTEGER;

//   for (const constraint of constraints) {
//     const [type, x] = constraint;

//     if (type === 1) {
//       minValid = Math.max(minValid, x);
//     } else if (type === 2) {
//       maxValid = Math.min(maxValid, x);
//     } else if (type === 3) {
//       if (x >= minValid && x < maxValid) {
//         maxValid = x;
//       }
//     }
//   }

//   return maxValid - minValid;
// }

// const constraints = [
//   [1, 5], // k must be greater than or equal to 5
//   [2, 10], // k must be less than 10
//   [3, 7], // k must be not equal to 7
// ];

// // console.log(countValidIntegers(constraints)); // Output: 2 (6 and 8 are valid)

// function maxAvgSubArray(arr, k) {
//   let n = arr.length;
//   let sum = 0;

//   for (let i = 0; i < k; i++) {
//     sum += arr[i];
//   }

//   let maxAvg = sum / k;

//   for (let i = k; i < n; i++) {
//     sum += arr[i] - arr[i - k];
//     maxAvg = Math.max(maxAvg, sum / k);
//   }

//   return maxAvg;
// }

// console.log(maxAvgSubArray([1, 12, -5, -6, 50, 3], 4));
// console.log(maxAvgSubArray([1, 2, 3, 4, 5], 2));

//https://leetcode.com/problems/arithmetic-subarrays/

// var checkArithmeticSubarrays = function (nums, l, r) {
//   let ans = [];
//   for (let i = 0; i < l.length; i++) {
//     let subarray = nums.slice(l[i], r[i] + 1);
//     ans.push(check(subarray));
//   }
//   function check(arr) {
//     arr.sort((a, b) => a - b);
//     let diff = arr[1] - arr[0];
//     for (let i = 2; i < arr.length; i++) {
//       if (arr[i] - arr[i - 1] != diff) {
//         return false;
//       }
//     }
//     return true;
//   }
//   return ans;
// };

class ListNode {
  constructor(val) {
    this.val = val;
    this.next = null;
  }
}

var getIntersectionNode = function (headA, headB) {
  let curA = headA;
  let curB = headB;

  while (curA !== curB) {
    curA = curA === null ? headB : curA.next;
    curB = curB === null ? headA : curB.next;
  }

  return curA;
};

const listA = new ListNode(4);
listA.next = new ListNode(1);
listA.next.next = new ListNode(8);
listA.next.next.next = new ListNode(4);
listA.next.next.next.next = new ListNode(5);

const listB = new ListNode(5);
listB.next = new ListNode(6);
listB.next.next = new ListNode(1);
listB.next.next.next = listA.next.next; // Intersect at node with value 8

// console.log(getIntersectionNode(listA, listB));

function generateNumber(n) {
  //Ho gaya hai
  let queue = [2, 3, 5];
  for (let i = 1; i < n; i++) {
    let num = queue.shift();
    queue.push(num * 10 + 2);
    queue.push(num * 10 + 3);
    queue.push(num * 10 + 5);
    // queue.sort((a, b) => a - b); // Ensure the queue remains sorted
  }
  return queue[0];
}

// Example usage:
const n = 7;
// console.log(generateNumber(n)); // Output will be 23

function swap(arr, i, j) {
  const temp = arr[i];
  arr[i] = arr[j];
  arr[j] = temp;
}

function rec(arr, i, n) {
  if (i > n / 2) {
    return arr;
  }
  swap(arr, i, n - i - 1);
  return rec(arr, i + 1, n);
}
// console.log(rec([1, 2, 3, 4, 5], 0, 5));

function rec2(str, i, n) {
  if (i > n / 2) return true;
  if (str[i] !== str[n - i - 1]) return false;
  return rec2(str, i + 1, n);
}
console.log(rec2("MADAM", 0, 5));
