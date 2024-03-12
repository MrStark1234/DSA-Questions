import java.util.*;

// Time : O(NlogN)

class Main {
    public static boolean binarySearch(int arr[], int target) {
        int beg = 0, end = arr.length - 1;
        while (beg <= end) {
            int mid = (beg + end) / 2;
            if (arr[mid] == target)
                return true;
            else if (arr[mid] > target)
                end = mid - 1;
            else
                beg = mid + 1;
        }
        return false;
    }

    public static int binarySearchableCount(int arr[], int n) {
        int cnt = 0;
        for (int num : arr) {
            if (binarySearch(arr, num))
                cnt += 1;
        }
        return cnt;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];

        for (int i = 0; i < n; ++i)
            arr[i] = sc.nextInt();

        System.out.println(binarySearchableCount(arr, n));
        sc.close();
    }
}