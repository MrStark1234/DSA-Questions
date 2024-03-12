import java.util.Scanner;

public class matrixDiagonalInterchange {
    public static void main(String[] args) {
       try(Scanner sc = new Scanner(System.in)){
        int N = sc.nextInt();


        int mat[][] = new int[N][N];
        for(int r = 0;r<N;r++)
        for(int c=0;c<N;c++)
        mat[r][c] = sc.nextInt();


      
        for (int i = 0; i < N; i++) {
            int temp = mat[i][i];
            mat[i][i] = mat[i][N - 1 - i];
            mat[i][N - 1 - i] = temp;
           
        }
       
        for(int i = 0; i<N;i++){
        for(int j =0;j<N;j++)
        System.out.print(mat[i][j] + " ");
        System.out.println();
        }

       
       } 
    }
}


