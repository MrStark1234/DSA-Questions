// https://leetcode.com/contest/weekly-contest-386/problems/split-the-array/

#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    bool isPossibleToSplit(vector<int>& nums) {
        int n = nums.size();
        int f[101] = {};
        
        for(int num : nums)
            f[num]++;
        
        for(int i = 1; i <= 100; ++i)
            if(f[i] > 2)
                return false;
        
        return true;
    }
};

int main() {
	// your code goes here
	return 0;
}
