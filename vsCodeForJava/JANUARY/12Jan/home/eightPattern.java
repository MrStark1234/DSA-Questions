public class eightPattern {
    public static void main(String[] args) {
        int N = 5; 
        for (int i=1;i<=(2*N-1);i++) {
            for(int j=1;j<=N;j++)
                if ((i == 1 && (j == 1 || j == N)) ||
                        (i == N && (j == 1 || j == N)) ||
                        (i == N * 2 - 1 && (j == 1 || j == N)))
            System.out.print(" ");
            else if (i == 1 || i == N || i == (N * 2) - 1 || j == 1 || j == N)
            System.out.print("*");
            else
                System.out.print(" ");
            System.out.println("");
        }
    }
}
