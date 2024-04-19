import java.io.*;

// Link : https://cses.fi/problemset/task/1081/

class Main {
    static final int limit = 1000000;

    public static void main(String[] args) throws Exception {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter w = new PrintWriter(System.out);

        int n = Integer.parseInt(r.readLine());
        String arr[] = r.readLine().split(" ");

        // Get the frequencies of all numbers.
        int freq[] = new int[limit + 1];
        for (int i = 0; i < n; ++i) {
            int num = Integer.parseInt(arr[i]);
            freq[num] += 1;
        }

        // Now, iterate over all possible divisors
        // the largest one with at least 2 factors
        // is our answer.
        int ans = -1;
        for (int gcd = limit; gcd >= 1; --gcd) {
            int cnt = 0;
            for (int num = gcd; num <= limit; num += gcd) {
                // adding the frequencies
                // of all multiples of gcd
                cnt += freq[num];
            }
            if (cnt >= 2) {
                ans = gcd;
                break;
            }
        }

        w.print(ans);

        r.close();
        w.close();
    }
}
