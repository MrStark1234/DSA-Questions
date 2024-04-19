import java.util.*;

class Job {
    int time;
    int deadline;

    Job(int t, int d) {
        time = t;
        deadline = d;
    }
};

class Main {
    static int minMaxLateness(int time[], int deadline[], int n) {
        ArrayList<Job> job = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            job.add(new Job(time[i], deadline[i]));
        }

        Collections.sort(job, new Comparator<Job>() {
            public int compare(Job j1, Job j2) {
                // negative if j1 should come first.
                return j1.deadline - j2.deadline;
            }
        });
        int curTime = 0, maxLatenessSoFar = 0;
        for (int i = 0; i < n; ++i) {
            int curDeadlne = job.get(i).deadline;
            int curEnd = curTime + job.get(i).time;

            maxLatenessSoFar = Math.max(maxLatenessSoFar, curEnd - curDeadlne);
            curTime = curEnd;
        }
        return maxLatenessSoFar;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int time[] = new int[n];
        int deadline[] = new int[n];

        for (int i = 0; i < n; ++i) {
            time[i] = sc.nextInt();
            deadline[i] = sc.nextInt();
        }

        System.out.println(minMaxLateness(time, deadline, n));
        sc.close();
    }
}
