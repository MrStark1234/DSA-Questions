
import java.io.*;

public final class SoldierNumGame {
    final static int LIMIT = 5000000;

    static int[] primeSieve() {
        int n = LIMIT;
        int spf[] = new int[n + 1]; // each value is 0 initially

        for (int i = 2; i <= n; ++i) {
            if (spf[i] > 0)
                continue;

            spf[i] = i;
            if ((long) i * i > (long) n)
                continue;

            for (int j = i * i; j <= n; j += i) // multiples of i
                if (spf[j] == 0)
                    spf[j] = i;
        }

        return spf;
    }

    static int getPrimeCnt(int num, int spf[]) {
        int ans = 0;
        while (num > 1) {
            int pf = spf[num], cnt = 0;
            while (num % pf == 0) {
                num /= pf;
                cnt += 1;
            }
            ans += cnt;
        }
        return ans;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter w = new PrintWriter(System.out);
        int t = Integer.parseInt(r.readLine());

        int spf[] = primeSieve();
        int pref[] = new int[LIMIT + 1];

        for (int i = 1; i <= LIMIT; ++i) {
            int ansOfI = getPrimeCnt(i, spf);
            pref[i] = pref[i - 1] + ansOfI;
        }

        while (t-- > 0) {
            String line[] = r.readLine().split(" ");
            int a = Integer.parseInt(line[0]);
            int b = Integer.parseInt(line[1]);
            w.print(pref[a] - pref[b]);
            w.print('\n');
        }

        r.close();
        w.close();
    }
}
