// import java.util.Arrays;
import java.util.Scanner;

public class one {
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)){
            int arr[] = { 2, 3, 4, 5, 6 };
            int targetNum = sc.nextInt();
            boolean ans = false;
            for(int i =0;i<arr.length;i++){
                if(arr[i]== targetNum)
              ans = true;
            }
            System.out.println(ans);

        }
        
     

    }
}
