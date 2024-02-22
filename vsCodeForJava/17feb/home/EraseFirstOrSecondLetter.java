
/*
Let's first see, that applying the second operation and then the first is equivalent to applying the first operation twice. In the former case the string will become s1s2s3…sn→s1s3…sn→s3…sn
, and in the latter case: s1s2s3…sn→s2s3…sn→s3…sn
. As we are concerned with only the number of distinct resulting strings, let's assume that the second operation is never done before the first operation. This means we do op1
 first operations (possibly zero) and then op2
 second operations (possibly zero).

Let's now find the result of applying i
 of the first and then j
 of the second operations. It's easy to see, that the result is si+1si+j+2si+j+3…sn
.

The only remaining question is in which cases two sequences of operations such that the first operation always comes before the second result in the same string. Consider for the (i1,j1)
 pair, the resulting string is the same as for the (i2,j2)
 pair. We can see that i1+j1=i2+j2
, because the number of erased letters should be the same to get strings of the same length. Next, si1+1=si2+1
 as those are the first letters of two resulting equal strings. It's easy to see that these conditions are also sufficient for the result to be the same string.

If after applying the first operation op1
 times the first letter is not its first occurrence, then any subsequent result could have been achieved by less operations of the first type by removing first character until reaching that letter and then by removing the second character until we reach op1
 operations in total. This means we need to consider using the second operation only at the first occurrence of the letter.

The final solution can look like this: for each letter a…z
 find it's first occurrence. If the letter is found, any number of second type operations lead to a different result. Thus we can just calculate the number of second operations that is valid and add that to the answer.
*/
import java.util.Scanner;

public class EraseFirstOrSecondLetter {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int t = scanner.nextInt();

            while (t-- > 0) {
                int n = scanner.nextInt();
                String s = scanner.next();

                long[] ans = new long[n];
                int[] nxt = new int[26];
                for (int i = 0; i < 26; i++) {
                    nxt[i] = n;
                }
                ans[n - 1] = 1;
                nxt[s.charAt(n - 1) - 'a'] = n - 1;

                for (int i = n - 2; i >= 0; i--) {
                    ans[i] = ans[i + 1] + (nxt[s.charAt(i) - 'a'] - i);
                    nxt[s.charAt(i) - 'a'] = i;
                }

                System.out.println(ans[0]);
            }
        }
    }
}
