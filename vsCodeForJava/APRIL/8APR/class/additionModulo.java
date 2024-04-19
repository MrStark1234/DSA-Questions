import java.util.*;

// Time : O(logB)

class Main {
    static long addUnderModulo(long a, long b, long m) {
        if (b == 0)
            return 0;

        long halfAns = addUnderModulo(a, b / 2, m);

        if (b % 2 == 0)
            return (halfAns + halfAns) % m;

        return (halfAns + halfAns + a) % m;
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            long a = sc.nextLong();
            long b = sc.nextLong();
            long m = sc.nextLong();

            System.out.println(addUnderModulo(a, b, m));
        }
    }
}
