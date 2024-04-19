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

// User function Template for Java
class Event {
    int time;
    int type; // 0 for arrival & 1 for departure

    Event(int tm, int tp) {
        time = tm;
        type = tp;
    }
}

class Solution {
    // Function to find the minimum number of platforms required at the
    // railway station such that no train waits.
    int findPlatform(int arr[], int dep[], int n) {
        ArrayList<Event> events = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            events.add(new Event(arr[i], 0));
            events.add(new Event(dep[i], 1));
        }

        Collections.sort(events, new Comparator<Event>() {
            public int compare(Event e1, Event e2) {
                if (e1.time != e2.time)
                    return e1.time - e2.time; // earlier events first
                return e1.type - e2.type; // arrival events first
            }
        });

        int curPlatforms = 0, platformsNeeded = 0;

        for (Event e : events) {
            if (e.type == 0) // arrival
                curPlatforms += 1;
            else
                curPlatforms -= 1;
            platformsNeeded = Math.max(platformsNeeded, curPlatforms);
        }

        return platformsNeeded;
    }
}