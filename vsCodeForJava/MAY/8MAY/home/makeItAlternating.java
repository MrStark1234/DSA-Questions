// codeforces - C. Make it Alternating
// https://codeforces.com/contest/1879/problem/C

/*
Firstly, let's divide the string s into blocks of equal characters. 
For example, if s=000100111, then we divide it into four blocks: 
000, 1, 00, 111
Let's denote the length of i-th block as len_i, 
and the number of blocks as k.
To obtain the longest alternating string we can get, we should choose 
exactly one character from each block and delete all other characters 
(we cannot leave two or more characters from the same block).

Now let's calculate the number of ways to choose characters that stay 
after string s become alternating. In the first block of length len1, 
there are len1 ways to choose that element; 
in the second block, there are len2 ways, and so on. 
So the final number of ways is equal to (len1*len2*len3...... lenk);

For example, let's consider the string s=00011. 
This string is divided into two blocks 000 and 11, 
so the number of ways if len1⋅len2=2⋅3=6

However, we have chosen the characters that remain, but we need to 
choose the characters we erase and the order in which we erase them. 
Since choosing the characters that remain is basically the same as 
choosing the characters that get erased, we only have to choose the 
order in which the character get erased. The number of characters 
we erase is n−k, so the number of ways to order them is equal to the 
number of permutations of length (n−k);

For example, let's consider that the string s=001100 and 
the chosen indices to erase are 1, 3 and 5. Then there are factorial(3)=6
 ways to choose the order of them:

1, 3, 5;
1, 5, 3;
3, 1, 5;
3, 5, 1;
5, 1, 3;
5, 3, 1;

So, the final answer is:
    the number of operations we perform is n−k;
    and the number of shortest sequences of operations is 
	(len1*len2.....*lenk)*factorial(n−k)



*/

import java.util.Scanner;
import java.util.ArrayList;

public class makeItAlternating {
    public static final int MOD = 998244353;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            String s = scanner.next();
            long mul = 1;
            ArrayList<Integer> v = new ArrayList<>();
            int len = 1, k = 1;
            int n = s.length();
            for (int i = 1; i < n; i++) {
                if (s.charAt(i) == s.charAt(i - 1)) {
                    len++;
                } else {
                    v.add(len);
                    len = 1;
                    k++;
                }
            }
            v.add(len);
            for (int i = 0; i < v.size(); i++) {
                mul = (mul * v.get(i)) % MOD;
            }
            for (int i = 1; i <= n - k; i++) {
                mul = (mul * i) % MOD;
            }
            System.out.println((n - k) + " " + mul);
            scanner.close();
        }
    }
}
