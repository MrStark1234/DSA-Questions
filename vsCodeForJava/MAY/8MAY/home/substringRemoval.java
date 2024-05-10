
// codeforces - B. Substring Removal
// https://codeforces.com/problemset/problem/1096/B
/*
case 1
if all letters in the string are equal then then answer is n*(n+1)/2
because we can choose any substring of s

case 2
  Firstly, let's calculate the length of the prefix of equal letters 
  (let it be l) and the length of the suffix of equal letters (let it 
  be r). It is obvious that this prefix and suffix wouldn't overlap because
  all letters are not equal.
  
  now there are two case 
    if prefix substring and suffix substring letter are not equal
	     In this case we can only remain either prefix or suffix of s
         consisting only of equal letters. Then the answer is l+r+1
         (because we can remain from 1 to l letters on the prefix, 
		 from 1 to r on the suffix or empty string).
	
	if prefix substring and suffix substring letter are equal
	     In this case we can remain from 0 to l letters on the prefix 
		 and from 0 to r letters on the suffix
		 so the answer is (l+1)⋅(r+1)



*/
import java.util.Scanner;

public class substringRemoval {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt();
            String s = scanner.next();
            int prefCount = 0, suffCount = 0;

            for (int i = 0; i < n; ++i) {
                if (s.charAt(i) == s.charAt(0)) {
                    ++prefCount;
                } else {
                    break;
                }
            }

            if (prefCount == n) {
                int ans = ((prefCount) * (prefCount + 1) / 2) % 998244353;
                System.out.println(ans);
                return;
            }

            for (int i = n - 1; i >= 0; --i) {
                if (s.charAt(i) == s.charAt(n - 1)) {
                    ++suffCount;
                } else {
                    break;
                }
            }

            if (s.charAt(0) == s.charAt(n - 1)) {
                System.out.println(((prefCount + 1) * 1L * (suffCount + 1)) % 998244353);
            } else {
                System.out.println((prefCount + suffCount + 1) % 998244353);

            }
        }
    }
}
