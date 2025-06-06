class MyQueue {
    private int front=-1;
    private int rear =-1;
    private int size;
    private int[] arr;
    private int ch;
    public MyQueue() {
        size = 50;
        arr = new int[size];
    }
    
    public void push(int x) {
        if(rear != arr.length){
            rear++;
            arr[rear]=x;
        }
        if(rear==0){
            front++;
        }
    }
    
    public int pop() {
        if(front!=-1 && rear != -1){
            ch = arr[front];
            if(front == rear){
                front = rear = -1;
            }else{
                front++;
        }
        }
        return ch;
    }
    
    public int peek() {
        if(front!=-1 && rear!=-1){
            ch = arr[front];
        }
        return ch;
    }
    
    public boolean empty() {
        if(front==-1 && rear==-1){
            return true;
        }else{
            return false;
        }
    }
}
