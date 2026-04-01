class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();

        for (String val : tokens) {
            if (!val.equals("+") && !val.equals("-") &&
                !val.equals("*") && !val.equals("/")) {

                st.push(Integer.parseInt(val));

            } else {
                int b = st.pop();
                int a = st.pop();
                int res = 0;

                if (val.equals("+")) {
                    res = a + b;
                } else if (val.equals("-")) {
                    res = a - b;
                } else if (val.equals("*")) {
                    res = a * b;
                } else {
                    res = a / b;
                }

                st.push(res);
            }
        }

        return st.pop();
    }
}
