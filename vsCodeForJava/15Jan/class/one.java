import java.util.Scanner;
public class one {
    public static void main(String[] args) {
       try(Scanner sc = new Scanner(System.in)){
        int N = sc.nextInt();
        int arr[] = new int[N];

        for(int i =0; i<N;i++){
            arr[i] = sc.nextInt();
        }

        int smallNum = arr[0];
        for(int s = 0;s<N;s++){
            if(arr[s]< smallNum){
                smallNum=arr[s];
            }
        }
        System.out.println(smallNum);

        int secSmall = Integer.MAX_VALUE;

       
        for (int s = 0; s < N; s++) {
            if (arr[s] == smallNum)
                continue;

               if(arr[s]<secSmall)
               secSmall=arr[s]; 
        }
        if (secSmall != Integer.MAX_VALUE) {
            System.out.println(secSmall);
        } else {
            System.out.println(-1);
        }
     
       } 
    }
}
