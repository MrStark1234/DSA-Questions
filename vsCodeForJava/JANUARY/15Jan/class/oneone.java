import java.util.Scanner;

public class oneone {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int N = sc.nextInt();
            int arr[] = new int[N];

            for (int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }

            int smallNum = Integer.MAX_VALUE;
            int secSmall = Integer.MAX_VALUE;
            for (int s = 0; s < N; s++) {
                if (arr[s] < smallNum) {
                    secSmall = smallNum;
                    smallNum = arr[s];
                }
            }
           

           
            if (secSmall != Integer.MAX_VALUE) {
                System.out.println(smallNum + " " + secSmall);
            } else {
                System.out.println(smallNum + " " + -1);
            }

        }
    }
}
