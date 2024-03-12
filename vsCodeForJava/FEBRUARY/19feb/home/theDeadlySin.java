/*
The Deadly Sin
Question Link-https://www.codechef.com/problems/SINS


Brute solution -
	int eat(int n1,int n2){
		if(n1<n2){
			return eat(n1,n2-n1);
		}else if(n1==n2  n1==0  n2 ==0){
			return n1+n2;
		}else{
			return eat(n1-n2,n2);
		}
	}
	Since n1 and n2 can go up to 1e9 so this solution won't work.
	We can optimise it using taking modulo instead of minus.
	let suppose n1 is 23 and n2 is 5.You reduce n1 like 23->18->13->8->3 .
	Instead doing this you can reduce n1 to 3  in one step by taking modulo to n2(n1%n2=3);
*/

import java.util.Scanner;

public class theDeadlySin {
    public static int rec(int n, int m) {
        if (n == m || n == 0 || m == 0)
            return n + m;
        if (n < m) {
            int temp = n;
            n = m;
            m = temp;
        }
        n %= m;
        if (n == 0)
            n = m;
        return rec(n, m);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            System.out.println(rec(n, m));
        }
        scanner.close();
    }
}
