import java.util.*;

// Link : https://www.geeksforgeeks.org/problems/activity-selection/1
// Time : O(NlogN)

class Activity {
    public int start;
    public int end;
    Activity(int st, int en) {
        start = st;
        end = en;
    }
}

class Solution {
    //Function to find the maximum number of activities that can
    //be performed by a single person.
    public static int activitySelection(int start[], int end[], int n) {
        ArrayList<Activity> act = new ArrayList<>();
        
        for(int i = 0; i < n; ++i)
            act.add(new Activity(start[i], end[i]));
        
        Collections.sort(act, new Comparator<Activity>(){
            public int compare(Activity a1, Activity a2) {
    		    // negative if a1 should come first.
    		    return a1.end - a2.end;
    		}
        });
        
        int maxActivities = 1, lastEnd = act.get(0).end;
        
        for(int i = 1; i < n; ++i) {
            int curStart = act.get(i).start;
            if(curStart > lastEnd) {
                maxActivities += 1;
                lastEnd = act.get(i).end;
            }
        }
        
        return maxActivities;
    }
}