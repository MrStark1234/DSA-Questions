import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public int[][] merge(int[][] intervals) {

        // A new way to sort, search on google to know more.
        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));

        ArrayList<int[]> ans = new ArrayList<>();
        for (int[] cur : intervals) {
            int[] last = ans.isEmpty() ? null : ans.get(ans.size() - 1);
            if (ans.isEmpty() || last[1] < cur[0]) {
                ans.add(cur);
            } else {
                last[1] = Math.max(last[1], cur[1]);
                ans.set(ans.size() - 1, last);
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }
}