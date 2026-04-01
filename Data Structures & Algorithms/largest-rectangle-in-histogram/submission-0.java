class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<>();
        int ans = 0;

        for (int i = 0; i < heights.length; i++) {
            while (!st.isEmpty() && heights[st.peek()] > heights[i]) {
                int ele = st.pop();
                int nse = i;
                int pse = st.isEmpty() ? -1 : st.peek();
                ans = Math.max(ans, (nse - pse - 1) * heights[ele]);
            }
            st.push(i);
        }

        while (!st.isEmpty()) {
            int ele = st.pop();
            int nse = heights.length;
            int pse = st.isEmpty() ? -1 : st.peek();
            ans = Math.max(ans, (nse - pse - 1) * heights[ele]);
        }

        return ans;
    }
}
