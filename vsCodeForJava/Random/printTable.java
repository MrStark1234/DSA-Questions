import java.util.Scanner;
class printTable {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int N = sc.nextInt();
            for(int tbl = N; tbl <=N*10;tbl++){
                if(tbl % N == 0){
                    System.out.println(tbl);
                }
            }
            sc.close();
        }
        
    }
}
