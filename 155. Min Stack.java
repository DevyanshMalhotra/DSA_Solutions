// 155. Min Stack java solution

import java.util.Stack;

class MinStack {
    Stack<Long> st1 = new Stack<>();
    long min;
    
    public MinStack() {
        st1 = new Stack<>();
        min = Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        if (st1.isEmpty()) {
            st1.push(0L); 
            min = val;
        } else {
            long diff = val - min; 
            st1.push(diff); 
            if (diff < 0) 
                min = val;
        }
    }
    
    public void pop() {
        if (st1.isEmpty()) return;
        
        long rem = st1.pop(); 
        if (rem < 0) 
            min = min - rem;
    }
    
    public int top() {
        if (st1.isEmpty()) return -1; 
        
        long rem = st1.peek(); 
        if (rem < 0) 
            return (int) min;
        else
            return (int) (min + rem); 
    }
    
    public int getMin() {
        return (int) min;
    }
}


/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
