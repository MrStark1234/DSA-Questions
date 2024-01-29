import java.util.*;

public class matrixDiagonalmult {
  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int A = sc.nextInt();
      int B = sc.nextInt();
      int C = sc.nextInt();

      int mat1[][] = new int[A][B];
      int mat2[][] = new int[B][C];

      int res[][] = new int[A][C];

      for (int i = 0; i < A; i++)
        for (int j = 0; j < B; j++)
          mat1[i][j] = sc.nextInt();

      for (int i = 0; i < B; i++)
        for (int j = 0; j < C; j++)
          mat2[i][j] = sc.nextInt();

      for (int i = 0; i < A; i++)
        for (int j = 0; j < C; j++) {
          int cur = 0;
          for (int k = 0; k < B; k++)
            cur += mat1[i][k] * mat2[k][j];
          res[i][j] = cur;
        }

      for (int i = 0; i < A; i++) {
        for (int j = 0; j < C; j++)
          System.out.print(res[i][j] + " ");

        System.out.println();
      }

    }
  }
}
