
import java.util.Scanner;

class snakeMetrix {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int R = sc.nextInt();
            int C = sc.nextInt();

            int arr[][] = new int[R][C];

            for (int i = 0; i < R; i++)
                for (int j = 0; j < C; j++)
                    arr[i][j] = sc.nextInt();

            for (int i = 0; i < R; ++i) {

                if (i % 2 == 0) {
                    for (int j = 0; j < C; ++j)
                        System.out.print(arr[i][j] + " ");
                } else {

                    for (int j = C - 1; j >= 0; --j)
                        System.out.print(arr[i][j] + " ");
                }
            }

        }

    }
}
