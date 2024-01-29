// https://www.codechef.com/problems/MAXCOUNT
// CODECHEF: MAXCOUNT

import java.util.Scanner;

public class maxcount {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int N = sc.nextInt();
            int arr[] = new int[N];

            for (int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }

            int repeatValue = 0;
            int repeatTime = 0;

            for (int i = 0; i < N; i++) {
                int count = 0;

                for (int j = 0; j < N; j++) {
                    if (arr[j] == arr[i]) {
                        count++;
                    }
                }

                if (count >= repeatTime) {
                    repeatTime = count;
                    repeatValue = arr[i];
                }
            }

            System.out.print(repeatValue + " " + repeatTime);
        }
    }
}
