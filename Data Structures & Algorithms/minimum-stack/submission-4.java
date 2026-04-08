class MinStack {

    int[] stack;
    int[] minStack;
    int stackCounter;

    public MinStack() {
        this.stack = new int[5000];
        this.minStack = new int[5000];
        this.stackCounter = 0;
    }
    
    public void push(int val) {
        this.stack[this.stackCounter] = val;
        if(this.stackCounter > 0){
            this.minStack[this.stackCounter] = Math.min(this.minStack[this.stackCounter-1], val);
        }else{
            this.minStack[this.stackCounter] = val;
        }
        this.stackCounter++;
    }
    
    public void pop() {
        if(this.stackCounter > 0){
            this.stack[this.stackCounter-1] = 0;
            this.minStack[this.stackCounter-1] = Integer.MAX_VALUE;
            this.stackCounter--;
        }else{
            System.out.println("Stack is empty!!");
        }
    }
    
    public int top() {
        return this.stack[this.stackCounter-1];
    }
    
    public int getMin() {
        return this.minStack[this.stackCounter-1];
    }
}
