public class crossPattern {
    public static void main(String[] args) {
        int N=5;
        for(int i = 1;i<=(2*N-1);i++){
           
            for(int j= 1;j<=(2*N-1);j++)
            if(j==i || j==(2*N-i))
            System.out.print("*");
            else
            System.out.print(" ");
            System.out.println("");
        }
    }
}
