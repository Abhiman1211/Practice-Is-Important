class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        int ans = 0;

       for (String val : tokens) {
            if (!val.equals("+") && !val.equals("-") && !val.equals("*") && !val.equals("/")) {
                st.push(Integer.parseInt(val));
            } else {
                while(!st.isEmpty()){
                    int top = st.pop();
                    if(val.equals("+")){
                        ans += top;
                    } else if(val.equals("*")){
                        if(ans != 0){
                            ans *= top;
                        } else {
                            ans = 1;
                            ans *= top;
                        }
                    } else if(val.equals("-")){
                        ans -= top;
                    } else if(val.equals("/")){
                        if(ans != 0){
                            ans /= top;
                        } else {
                            ans = 1;
                            ans /= top;
                        }
                    }
                }
            }
        }

        return ans;
    }
}
