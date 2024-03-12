import java.util.Scanner;

class matrixSpiral {
    public static void main(String[] args) {
       try(Scanner sc = new Scanner(System.in)){
        int R = sc.nextInt();
        int C = sc.nextInt();

        int arr[][] = new int[R][C];

        for(int i =0; i<R;i++)
        for(int j =0; j<C;j++)
        arr[i][j] = sc.nextInt();


        int top = 0, bot = R-1, left = 0, right = C-1;

         while(top <= bot && left <= right) {

        for(int col = left; col< right; col++)
        System.out.print(arr[top][col] + " ");

        for (int row = top; row < bot; row++)
        System.out.print(arr[row][right] + " ");

        for (int col = right; col > left; col--)
        System.out.print(arr[bot][col] + " ");

        for (int row = bot; row > top; row--)
        System.out.print(arr[row][left] + " ");

        top++;
        left++;

        // decrement bot and right
         bot--;
         right--;

       }
    }

    }
}
