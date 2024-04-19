import java.io.*;

import java.util.*;

// Link : https://www.geeksforgeeks.org/problems/job-sequencing-problem/1
// Time : O(NlogN)

class Job {
    int id, profit, deadline;

    Job(int x, int y, int z) {
        this.id = x;
        this.deadline = y;
        this.profit = z;
    }
}

class GfG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // testcases
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String inputLine[] = br.readLine().trim().split(" ");

            // size of array
            int n = Integer.parseInt(inputLine[0]);
            Job[] arr = new Job[n];
            inputLine = br.readLine().trim().split(" ");

            // adding id, deadline, profit
            for (int i = 0, k = 0; i < n; i++) {
                arr[i] = new Job(Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]),
                        Integer.parseInt(inputLine[k++]));
            }

            Solution ob = new Solution();

            // function call
            int[] res = ob.JobScheduling(arr, n);
            System.out.println(res[0] + " " + res[1]);
        }
    }
}
// } Driver Code Ends

class Solution {
    // Function to find the maximum profit and the number of jobs done.
    int[] JobScheduling(Job arr[], int n) {
        Arrays.sort(arr, new Comparator<Job>() {
            public int compare(Job j1, Job j2) {
                return j2.profit - j1.profit;
            }
        });

        TreeSet<Integer> freeSlots = new TreeSet<>();
        for (int i = 1; i <= n; ++i)
            freeSlots.add(i);

        int jobsDone = 0, profitEarned = 0;
        for (Job job : arr) {
            // Find the largest free slot
            // less than or equal to job.deadline;
            if (freeSlots.floor(job.deadline) == null) {
                continue;
            }
            int curSlot = freeSlots.floor(job.deadline);
            freeSlots.remove(curSlot);
            profitEarned += job.profit;
            jobsDone += 1;
        }
        return new int[] { jobsDone, profitEarned };
    }
}