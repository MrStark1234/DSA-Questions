import java.util.Scanner;

class Main {
    // Will run infinitely if a negative
    // input is given
    public static void print1ToN(int n) {
        if (n == 0)
            return;

        print1ToN(n - 1);
        System.out.print(" " + n);
    }

    public static void main(String[] args) {
        try (// Note: Don't change class name
                Scanner sc = new Scanner(System.in)) {
            int N = sc.nextInt();

            print1ToN(N);
        }
    }
}
