class Solution {
    public int[] dailyTemperatures(int[] temp) {
        int n = temp.length;
        int[] res = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && temp[i] > temp[st.peek()]) {
                int prev = st.pop();
                res[prev] = i - prev;
            }
            st.push(i);
        }

        return res;
    }
}
