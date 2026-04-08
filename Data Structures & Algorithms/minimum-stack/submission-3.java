// import java.util.*;
class MinStack {

    private int[] stack = new int[6];
    private int[] minStack = new int[6];
    int minval = Integer.MAX_VALUE;
    int counter = 0;

    public MinStack() {
        
    }
    
    public void push(int val) {
        this.stack[this.counter] = val;
        this.minval = Math.min(this.minval, val);
        this.minStack[this.counter] = this.minval;
        this.counter++;
    }
    
    public void pop() {
        this.stack[this.counter-1] = 0;
        this.minStack[this.counter-1] = 0;
        this.counter--;
        this.minval = (this.counter > 0) ? this.minStack[this.counter-1]: Integer.MAX_VALUE;
    }
    
    public int top() {
        return this.stack[this.counter-1];
    }
    
    public int getMin() {
        return this.minStack[this.counter-1];
    }
}
