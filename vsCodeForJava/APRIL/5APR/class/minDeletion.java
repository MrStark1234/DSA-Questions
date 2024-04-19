import java.util.*;

// Link : https://www.codechef.com/problems/RD19

class Main {
    static int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int t = sc.nextInt();
            while (t-- > 0) {
                int n = sc.nextInt();
                int arr[] = new int[n];
                int gc = 0;
                for (int i = 0; i < n; ++i) {
                    arr[i] = sc.nextInt();
                    gc = gcd(gc, arr[i]);
                }
                System.out.println(gc == 1 ? 0 : -1);
            }
        }
    }
}
