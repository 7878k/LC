// 155. Min Stack
// Time: O(1), Space: O(n)
// 当一个元素要入栈时，我们取当前辅助栈的栈顶存储的最小值，
// 与当前元素比较得出最小值，将这个最小值插入辅助栈中；
// 当一个元素要出栈时，我们把辅助栈的栈顶元素也一并弹出；
// 在任意一个时刻，栈内元素的最小值就存储在辅助栈的栈顶元素中。

/*
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

Implement the MinStack class:

MinStack() initializes the stack object.
void push(val) pushes the element val onto the stack.
void pop() removes the element on the top of the stack.
int top() gets the top element of the stack.
int getMin() retrieves the minimum element in the stack.
*/


class MinStack {

    Deque<Integer> stack;
    Deque<Integer> minStack;
    /** initialize your data structure here. */
    public MinStack() {
        stack = new LinkedList<>();
        minStack = new LinkedList<>();
        minStack.push(Integer.MAX_VALUE);
    }
    
    public void push(int val) {
        stack.push(val);
        minStack.push(Math.min(val, minStack.peek()));
    }
    
    public void pop() {
        stack.pop();
        minStack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
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