class Solution {
    public boolean isValid(String s) {

        Stack<Character> st = new Stack<>();

        if(s.length() == 1) return false;

        for(char c : s.toCharArray()){
            if(c == '('){
                st.push(c);
            } else if(c == '{'){
                st.push(c);
            } else if(c == '['){
                st.push(c);
            } else if(c == ')'){
                if(st.peek() == '('){
                    st.pop();
                } else {
                    return false;
                }
            } else if(c == ']'){
                if(st.peek() == '['){
                    st.pop();
                } else {
                    return false;
                }
            } else if(c == '}'){
                if(st.peek() == '{'){
                    st.pop();
                } else {
                    return false;
                }
            }
        }

        if(st.size() == 0){
            return true;
        }

        return false;
    }
}
