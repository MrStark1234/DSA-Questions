//https://leetcode.com/problems/most-beautiful-item-for-each-query/description/

class Solution {
  maximumBeauty(items, queries) {
    const n = queries.length;
    const newQueries = queries.map((query, index) => [query, index]);
    const ans = new Array(n).fill(0);

    items.sort((a, b) => a[0] - b[0]);
    newQueries.sort((a, b) => a[0] - b[0]);

    for (let j = 0, x = 0, i = 0; j < newQueries.length; j++) {
      while (i < items.length && newQueries[j][0] >= items[i][0]) {
        x = Math.max(items[i][1], x);
        i++;
      }
      ans[newQueries[j][1]] = x;
    }
    return ans;
  }
}
