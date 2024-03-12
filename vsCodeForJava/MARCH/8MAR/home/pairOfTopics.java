import java.util.*;

// Link : https://codeforces.com/contest/1324/problem/D
// Time : O(N*LogN)

public final class pairOfTopics {
    static int countLarger(ArrayList<Integer> arr, int j) {
        // Let's find the first such index s.t.
        // arr[i] > -arr[j];
        // search range is [0, j - 1]
        int beg = 0, end = j - 1, ans = -1;

        while (beg <= end) {
            int mid = (beg + end) / 2;
            if (arr.get(mid) > -arr.get(j)) {
                ans = mid;
                end = mid - 1;
            } else {
                beg = mid + 1;
            }
        }
        return ans == -1 ? 0 : j - ans; // because valid indices are [ans, j)
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();

            ArrayList<Integer> a = new ArrayList<>();
            ArrayList<Integer> b = new ArrayList<>();

            for (int i = 0; i < n; ++i)
                a.add(sc.nextInt());

            for (int i = 0; i < n; ++i)
                b.add(sc.nextInt());

            ArrayList<Integer> c = new ArrayList<>();
            for (int i = 0; i < n; ++i)
                c.add(a.get(i) - b.get(i));

            long ans = 0;
            Collections.sort(c);
            for (int j = 0; j < n; ++j)
                ans += countLarger(c, j);

            System.out.println(ans);
        }
    }
}
