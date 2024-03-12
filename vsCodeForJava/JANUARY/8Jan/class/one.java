import java.util.Scanner;

class one {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int R = sc.nextInt();
            int K = sc.nextInt();

            for (int N = 1; N <= R; N++) {
                int sum = 0;
                for (int num = N; num > 0; num /= 10) {
                    int lastDigit = num % 10;
                    sum += lastDigit;
                }
                if (sum == K) {

                    System.out.println(N + ":" + sum);
                }
            }
        }
    }
}
