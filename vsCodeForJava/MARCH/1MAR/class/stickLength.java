import java.util.*;

// Link : https://codeforces.com/gym/102961/problem/I
// Time : O(NLogN)

public final class stickLength {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];

        long totalSum = 0;
        for (int i = 0; i < n; ++i) {
            arr[i] = sc.nextInt();
            totalSum += arr[i];
        }

        Arrays.sort(arr);

        long leftSum = 0;
        long finalAns = Long.MAX_VALUE;
        long leftCnt = 0, rightCnt = n;
        for (int i = 0; i < n; ++i) {

            // leftSum = sum(arr[0] ... arr[i])
            leftSum += arr[i];

            // leftCnt = count(0 ... i)
            leftCnt += 1;

            // rightSum = sum(arr[i+1] ... arr[n-1])
            long rightSum = totalSum - leftSum;

            // rightCnt = count(i+1 ... n-1)
            rightCnt -= 1;

            // Calculate current ans
            long curAns = (leftCnt * arr[i] - leftSum) + (rightSum - rightCnt * arr[i]);
            finalAns = Math.min(finalAns, curAns);
        }

        System.out.println(finalAns);
        sc.close();
    }
}
