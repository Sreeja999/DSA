//155. https://leetcode.com/problems/min-stack/description/

class MinStack {

    long min;
    Stack<Long> st;

    public MinStack() {
        st=new Stack<>();
        
    }
    
    public void push(int val) {
        long v=val;
        
        if(st.isEmpty()){
            min=v;
            st.push(v);
        }else if(v>=min){
            st.push(v);
        }else{
            st.push(2*v -min);
            min=v;
        }
        
    }
    
    public void pop() {
        if(st.isEmpty()){
            return;
        }

        long top=st.pop();
        if(top<min){
            min=2*min - top;
        }
        
    }
    
    public int top() {
        if(st.isEmpty()) return -1;
        
        long top=st.peek();
        if(top>=min) return (int) top;
        else return  (int) min;
    }
    
    public int getMin() {
        return  (int) min;
        
    }
}