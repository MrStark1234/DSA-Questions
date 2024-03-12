import java.util.*;

// Time : O(N)

class Main {
    public static int randomBinarySearchable(int arr[], int n) {
        int preMax[] = new int[n];
        int sufMin[] = new int[n];

        for (int i = 0; i < n; ++i)
            preMax[i] = i == 0 ? arr[i] : Math.max(arr[i], preMax[i - 1]);

        for (int i = n - 1; i >= 0; --i)
            sufMin[i] = i == n - 1 ? arr[i] : Math.min(arr[i], sufMin[i + 1]);

        int cnt = 0;

        for (int i = 0; i < n; ++i) {
            int leftMax = (i == 0) ? Integer.MIN_VALUE : preMax[i - 1];
            int rightMin = (i == n - 1) ? Integer.MAX_VALUE : sufMin[i + 1];

            if (arr[i] > leftMax && arr[i] < rightMin)
                cnt++;
        }
        return cnt;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];

        for (int i = 0; i < n; ++i)
            arr[i] = sc.nextInt();

        System.out.println(randomBinarySearchable(arr, n));
        sc.close();
    }
}