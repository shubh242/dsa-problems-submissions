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
        this.stack[stackCounter] = val;
        if(stackCounter == 0) {
            this.minStack[stackCounter] = val;
        } else {
            if(this.minStack[stackCounter-1] > val)
                this.minStack[stackCounter] = val;
            else
                this.minStack[stackCounter] = this.minStack[stackCounter-1];
        }
        stackCounter++;
    }
    
    public void pop() {
        this.stack[stackCounter-1] = 0;
        this.minStack[stackCounter--] = Integer.MAX_VALUE;
    }
    
    public int top() {
        return this.stack[stackCounter-1];
    }
    
    public int getMin() {
        return this.minStack[stackCounter-1];
    }
}
