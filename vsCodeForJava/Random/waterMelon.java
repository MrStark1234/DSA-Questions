import java.util.Scanner;
public class waterMelon {
    public static void main(String[] args) {
       try( Scanner sc = new Scanner(System.in)){
        int N = sc.nextInt();
        if(N > 2 && N % 2 == 0){
            System.out.println("yes");
        }else{
            System.out.println("No");
        }
        sc.close();
       };
    }
}
