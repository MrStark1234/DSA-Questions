
/*
We stored the element which can be used char freq arr.
Now we counting the number of chars present continuosly
in order to mke the substring.
As soon as we find char which is not present, we sum up
the number of substrings.4
*/
import java.util.*;

// public final class Main {
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         int n = sc.nextInt();
//         int k = sc.nextInt();

//         String s = sc.next();

//         boolean canWrite[] = new boolean[26];

//         for (int i = 0; i < k; ++i) {
//             char cur = sc.next().charAt(0);
//             canWrite[cur - 'a'] = true;
//         }

//         System.out.println(Solution.countSubstrings(s, canWrite));
//     }
// }

class Solution {
    public static long countSubstrings(String s, boolean can[]) {
        ArrayList<Integer> cant_ids = new ArrayList<>();

        // This is to easily cater for
        // the first valid subarray
        cant_ids.add(-1);

        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            if (can[ch - 'a'] == false)
                cant_ids.add(i);
        }

        // This is to easily cater for
        // the first valid subarray
        cant_ids.add(s.length());

        long ans = 0;

        for (int i = 1; i < cant_ids.size(); ++i) {
            long cur_len = cant_ids.get(i) - cant_ids.get(i - 1) - 1;
            ans += cur_len * (cur_len + 1) / 2;
        }

        return ans;
    }
}
