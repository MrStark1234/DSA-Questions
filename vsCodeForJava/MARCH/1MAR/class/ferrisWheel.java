import java.util.*;

// Link : https://codeforces.com/gym/102961/problem/C
// Time : O(NLogN)

public final class ferrisWheel {
    public static int getMinGondolas(ArrayList<Integer> arr, int n, int cap) {
        int i = 0, j = n - 1, ans = 0;

        // Sort the array first
        Collections.sort(arr);

        while (i <= j) {

            // If the sum is greater than cap
            // then there is no hope for jth child.
            // We won't be able to pair it with anything.
            // So, put it in a separate gondola, and move forward.
            if (arr.get(i) + arr.get(j) > cap)
                j--;

            /*
             * Otherwise, both ith and jth child can
             * be put into the same gondola.
             */
            else {
                i++;
                j--;
            }

            // Increment number of gondolas by 1.
            ans++;
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int cap = sc.nextInt();

        ArrayList<Integer> arr = new ArrayList<Integer>();

        for (int i = 0; i < N; ++i) {
            arr.add(sc.nextInt());
        }

        System.out.println(getMinGondolas(arr, N, cap));
        sc.close();
    }
}