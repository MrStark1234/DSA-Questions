
public class rhombusMirror {
    public static void main(String[] args) {
        int N = 5;

        for (int r = 1; r <= N; r++) {
            for(int s = 1; s<=(N-r)  ; s++){
                System.out.print(" ");
            }
            for (int c = 1; c <= N; c++) {   
            
                System.out.print("*");
            }
            System.out.println("");
        }
    }
}
