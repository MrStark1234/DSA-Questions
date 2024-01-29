public class plusPattern {
    public static void main(String[] args) {
        int N = 6;

        for(int i = 1;i<=(2*N-1);i++){

            if(i==N){
            for(int j = 1;j<=(2*N-1);j++)
            
                System.out.print("+");
        }else{
            for(int j = 1;j<=N-1;j++)
            System.out.print(" ");

            System.out.print("+");
        }
           


            System.out.println("");
        }
    }
}
