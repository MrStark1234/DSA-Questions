import java.util.*;
import java.io.*;

// Link : https://www.geeksforgeeks.org/problems/minimum-platforms/1
// Time : O(NlogN)

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            String str[] = read.readLine().trim().split(" ");
            int n = Integer.parseInt(str[0]);

            int arr[] = new int[n];
            int dep[] = new int[n];

            str = read.readLine().trim().split(" ");
            for (int i = 0; i < n; i++)
                arr[i] = Integer.parseInt(str[i]);
            str = read.readLine().trim().split(" ");
            for (int i = 0; i < n; i++)
                dep[i] = Integer.parseInt(str[i]);

            System.out.println(new Solution().findPlatform(arr, dep, n));
        }
    }

}

// } Driver Code Ends

// User function Template for Java
class Train {
    int arrival;
    int departure;

    Train(int arr, int dep) {
        arrival = arr;
        departure = dep;
    }
}

class Solution {
    // Function to find the minimum number of platforms required at the
    // railway station such that no train waits.
    int findPlatform(int arr[], int dep[], int n) {
        ArrayList<Train> trains = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            trains.add(new Train(arr[i], dep[i]));
        }

        Collections.sort(trains, new Comparator<Train>() {
            public int compare(Train t1, Train t2) {
                return t1.arrival - t2.arrival;
            }
        });

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (Train tr : trains) {
            if (pq.isEmpty()) {
                pq.add(tr.departure);
            } else if (pq.peek() < tr.arrival) {
                pq.poll();
                pq.add(tr.departure);
            } else {
                pq.add(tr.departure);
            }
        }

        return pq.size();
    }

}