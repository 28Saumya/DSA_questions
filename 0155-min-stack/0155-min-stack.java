/*class MinStack {
  
    private Stack<Integer> st = new Stack<>();
    private int min;

    public MinStack() {
        
    }
    
    public void push(int val) {
        if(st.isEmpty()){
            min=val;
            st.push(val);
        }
        else{
            if(val>=min){
               st.push(val);
            }
            else{
                  st.push(2*val-min);
                  min=val;
            }
        }
    }
    
    public void pop() {
        if(st.isEmpty()) return;
        
       int x=st.pop();
     
       if(x<min){
        min=2*min-x;
       }
    }
    
    public int top() {
        if(st.isEmpty())
         return -1;
        int x=st.pop();
        if(x>=min)
          return x;
        else{
          return min;
        }
    }
    
    public int getMin() {
        if(st.isEmpty()) return -1;
        return min;
    }
}*/


import java.util.Stack;

class MinStack {
    private Stack<Integer> st;
    private Stack<Integer> minSt;

    public MinStack() {
        st = new Stack<>();
        minSt = new Stack<>();
    }

    public void push(int val) {
        st.push(val);
        if (minSt.isEmpty() || val <= minSt.peek()) {
            minSt.push(val);
        }
    }

    public void pop() {
        if (st.isEmpty()) return;

        int removed = st.pop();
        if (!minSt.isEmpty() && removed == minSt.peek()) {
            minSt.pop();
        }
    }

    public int top() {
        if (st.isEmpty()) return -1;
        return st.peek();
    }

    public int getMin() {
        if (minSt.isEmpty()) return -1;
        return minSt.peek();
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