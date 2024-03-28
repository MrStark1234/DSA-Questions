import java.util.Stack;

public class DailyTemperature {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] ans = new int[n]; // initially all 0, stores distance between their next greater element and
                                // current temperature
        Stack<Integer> st = new Stack<>();

        for (int i = n - 1; i >= 0; --i) {
            // pop until we find next greater element to the right
            // since we came from right stack will have element from right only
            // s.top() is the index of elements so we put that index inside temperatures
            // array to check
            while (!st.isEmpty() && temperatures[st.peek()] <= temperatures[i])
                st.pop();

            // if stack not empty, then we have some next greater element,
            // so we take distance between next greater and current temperature
            // as we are storing indexes in the stack
            if (!st.isEmpty())
                ans[i] = st.peek() - i; // distance between next greater and current

            // push the index of current temperature in the stack,
            // same as pushing current temperature in stack
            st.push(i);
        }

        return ans;
    }

}
