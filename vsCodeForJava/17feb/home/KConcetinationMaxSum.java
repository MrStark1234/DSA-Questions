
/*
First we compute the

(best here )max subarray sum possible of single array given
suffix sum max
prefix sum max
and total sum of the array
now after computing we see that our merge array 's above 4 things will be

there are 3 cases 1. a's max subarray sum is best , 2. b's is max , 3. half from a and half from b
ans.best = max({a.best, b.best, (a.suffBest + b.prefBest)});
for prefix sum max we have 2 cases 1. a's is maximum , 2. we need to include whole a and then take prefix of b
ans.prefBest = max(a.prefBest , (a.tot + b.prefBest));
Similar in the case of suffix
ans.suffBest = max(b.suffBest , (b.tot + a.suffBest));
total will be the sum of both arrays ans.tot = a.tot + b.tot;
first merge two arrays then the merged array with ith array
*/
import java.util.List;

public class KConcetinationMaxSum {
    public static int kConcatenationMaxSum(List<Integer> arr, int k) {
        int n = arr.size(), gsum = 0, sum = 0, gMax = 0, cMaxSum = 0, mod = 1000000007;
        for (int num : arr) {
            gsum += num;
        }
        int maxSuf = gsum, maxPre = 0;
        for (int i = 0; i < n; i++) {
            sum += arr.get(i);
            maxSuf = Math.max(maxSuf, gsum - sum);
            maxPre = Math.max(sum, maxPre);
            cMaxSum = Math.max(cMaxSum + arr.get(i), arr.get(i));
            gMax = Math.max(gMax, cMaxSum);
        }

        if (k == 1)
            return gMax;
        return (int) Math.max(Math.max(0L, (long) (k - 2) * sum) + maxSuf + maxPre, (long) gMax) % mod;
    }
}
