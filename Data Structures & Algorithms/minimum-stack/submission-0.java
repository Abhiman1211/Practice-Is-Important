class MinStack {
    Stack<Integer> st;

    public MinStack() {
        st = new Stack<>();
    }
    
    public void push(int val) {
        st.push(val);
    }
    
    public void pop() {
        st.pop();
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        Stack<Integer> temp = new Stack<>();
        int min = st.peek();

        while(!st.isEmpty()){
            min = Math.min(min, st.peek());
            temp.push(st.pop());
        }

        while(!temp.isEmpty()){
            st.push(temp.pop());
        }

        return min;
    }
}
