
/*
https://codeforces.com/contest/1459/problem/C
as we know that 
GCD(x,y)=GCD(x−y,y)
We can apply this for multiple arguments as well, i.e., 
GCD(x,y,z,…)=GCD(x−y,y,z,…)
Now,
Let's use this for GCD(a1+bj,…,an+bj)
and subtract a1+bj from all other arguments:
GCD(a1+bj,…,an+bj)=GCD(a1+bj,a2−a1,…,an−a1)

Now if we find G=GCD(a2−a1,…,an−a1), 
then any answer can be found as GCD(a1+bj,G)

Note that we have to assume that GCD of an empty set is 0
, and GCD(x,0)=x for any x
, since 0 is the only number divisible by any other number.
*/
import java.util.Scanner;
import java.util.Arrays;

public class RowGCD {

    public static void main(String... c) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            long a[] = new long[n], b[] = new long[m], ans[] = new long[m];
            int i;
            for (i = 0; i < n; i++)
                a[i] = sc.nextLong();
            for (i = 0; i < m; i++)
                b[i] = sc.nextLong();
            Arrays.sort(a);
            long gd = 0;
            for (i = 1; i < n; i++)
                gd = gcd(gd, a[i] - a[i - 1]);
            for (i = 0; i < m; i++)
                ans[i] = gcd(gd, a[0] + b[i]);

            for (i = 0; i < m; i++)
                System.out.print(ans[i] + " ");
        }
    }

    public static long gcd(long a, long b) {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }
}
