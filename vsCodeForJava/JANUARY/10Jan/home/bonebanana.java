//problem link:-https://www.hackerearth.com/practice/math/number-theory/primality-tests/practice-problems/algorithm/monks-problem-ffeebf8a/
import java.util.Scanner;
public class bonebanana {
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)){
            int t = sc.nextInt();

          
            while (t-- > 0) {
                int n = sc.nextInt();

                if (n == 1) {
                    System.out.println("No");
                }

                else { 
                    boolean isPrime = true;
                    for (int i = 2; i * i <= n; ++i)
                        if (n % i == 0) {
                            isPrime = false;
                            break;
                        }

                    if (isPrime)
                        System.out.println("No");
                    else
                        System.out.println("Yes");
                }
            }

            sc.close();
        }
    }
}
