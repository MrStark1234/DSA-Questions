
import java.io.*;

// Overall time = x*log(log(x)) + n*logx

class Main {
    static int[] primeSieve(int n) {
        int[] spf = new int[n + 1]; // initially 0

        for (int i = 2; i <= n; ++i) {
            if (spf[i] > 0)
                continue;
            spf[i] = i;
            if ((long) i * i > (long) n)
                continue;
            for (int j = i * i; j <= n; j += i)
                if (spf[j] == 0)
                    spf[j] = i;
        }

        return spf;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter w = new PrintWriter(System.out);
        int n = Integer.parseInt(r.readLine());

        int[] spf = primeSieve(1000000);
        // maxXlog(log(maxX))

        while (n-- > 0) {
            int x = Integer.parseInt(r.readLine());
            int ans = 1;
            while (x > 1) { // LogX
                int pf = spf[x], cnt = 0;
                while (x % pf == 0) {
                    x /= pf;
                    cnt += 1;
                }
                ans *= (cnt + 1);
            }
            w.print(ans);
            w.print('\n');
        }
        r.close();
        w.close();
    }
}
