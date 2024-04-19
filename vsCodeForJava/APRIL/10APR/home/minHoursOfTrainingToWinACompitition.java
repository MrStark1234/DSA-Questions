/*
https://leetcode.com/problems/minimum-hours-of-training-to-win-a-competition/ 

We have to find the minimum energy required. 
So, whenever we have a depletion of energy or experience, 
we will increase the training hours accordingly so as to get 
to the bare minimum to pass that stage. This will continue on 
till the last stage. We can easily observe that increasing the 
training hours during the stage will not make any difference. 

*/

class Solution {
    public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        int n = energy.length;
        int trainingHours = 0;

        for (int i = 0; i < n; ++i) {
            // TRAIN if needed
            if (initialEnergy <= energy[i]) {
                int difference = energy[i] - initialEnergy;
                initialEnergy += difference + 1;
                trainingHours += difference + 1;
            }
            if (initialExperience <= experience[i]) {
                int difference = experience[i] - initialExperience;
                initialExperience += difference + 1;
                trainingHours += difference + 1;
            }

            // FIGHT
            initialEnergy -= energy[i];
            initialExperience += experience[i];
        }
        return trainingHours;
    }
}
