class MyStack {
    Queue<Integer> q;
    public MyStack() {
        q = new ArrayDeque<>();
    }
    
    public void push(int x) {
        Queue<Integer> temp = new ArrayDeque<>();
        while(!q.isEmpty())temp.offer(q.poll());
        q.offer(x);
        while(!temp.isEmpty())q.offer(temp.poll());
    }
    
    public int pop() {
        if(q.isEmpty())return -1;
        return q.poll();
    }
    
    public int top() {
        if(q.isEmpty())return -1;
        return q.peek();
    }
    
    public boolean empty() {
        return q.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */