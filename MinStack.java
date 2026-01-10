class MinStack {
    private node head;

    public MinStack() {
        
    }
    
    public void push(int val) {
        if(head == null){
            head = new node(val,val,head);
        }else{
            head = new node(val,Math.min(val,head.min),head);
        }
    }
    
    public void pop() {
        head = head.next;
    }
    
    public int top() {
        return head.val;
    }
    
    public int getMin() {
        return head.min;
    }
    private class node{
        int val;
        int min;
        node next;
        node(int val,int min,node next){
            this.val = val;
            this.min = min;
            this.next = next;
        }
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
