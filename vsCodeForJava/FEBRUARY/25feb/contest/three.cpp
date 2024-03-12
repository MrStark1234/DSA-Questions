// https://leetcode.com/contest/weekly-contest-386/problems/earliest-second-to-mark-indices-i/

#include <bits/stdc++.h>
using namespace std;

class Solution
{
    bool possible(vector<int> nums, vector<int> &mark, int len)
    {

        vector<int> lastInMark(nums.size(), -1), isLast(mark.size(), -1);
        vector<bool> marked(nums.size(), 0);

        for (int i = 0; i < len; ++i)
            lastInMark[mark[i] - 1] = i;

        for (int i = 0; i < nums.size(); ++i)
        {
            if (lastInMark[i] == -1)
                return false;
            isLast[lastInMark[i]] = i;
        }

        // {lastInMark[i], i}
        set<pair<int, int>> s;
        for (int i = 0; i < nums.size(); ++i)
        {
            if (nums[i])
                s.insert({lastInMark[i], i});
        }

        for (int i = 0; i < len; ++i)
        {
            if (isLast[i] != -1)
            {
                int id = isLast[i];

                if (nums[id] != 0)
                    return false;

                marked[id] = true;
            }
            else if (s.size())
            {
                auto p = *s.begin();
                nums[p.second] -= 1;

                if (nums[p.second] == 0)
                {
                    s.erase(s.begin());
                }
            }
        }

        for (int i = 0; i < nums.size(); ++i)
            if (!marked[i])
                return false;

        return true;

        // if isLast[s] is true
        // mark that index

        // otherwise, out of the non-zero ones, I need to find
        // the one with minimum last value & decrement it by 1.
    }

public:
    int earliestSecondToMarkIndices(vector<int> &nums, vector<int> &changeIndices)
    {
        for (int ans = nums.size(); ans <= changeIndices.size(); ++ans)
        {
            if (possible(nums, changeIndices, ans))
                return ans;
        }
        return -1;
    }
};

int main()
{
    // your code goes here
    return 0;
}
