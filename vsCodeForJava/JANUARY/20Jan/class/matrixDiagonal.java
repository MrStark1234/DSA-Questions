import java.util.*;
class matrixDiagonal{
    public static void main(String[] args) {
       try(Scanner sc = new Scanner(System.in)){
        int N = sc.nextInt();


        int mat[][] = new int[N][N];
        for(int r = 0;r<N;r++)
        for(int c=0;c<N;c++)
        mat[r][c] = sc.nextInt();


        for(int i=0;i<N;i++)
        System.out.print(mat[i][i] + " ");

        for (int i = 0, j= N-1; i < N ; i++, j--)
        System.out.print(mat[i][j] + " ");

       } 
    }
}