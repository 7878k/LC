// 232. Implement Queue using Stacks
// Time: O(1), Space: O(n)
/*
Implement a first in first out (FIFO) queue using only two stacks. The implemented queue should support all the functions of a normal queue (push, peek, pop, and empty).

Implement the MyQueue class:

void push(int x) Pushes element x to the back of the queue.
int pop() Removes the element from the front of the queue and returns it.
int peek() Returns the element at the front of the queue.
boolean empty() Returns true if the queue is empty, false otherwise.
*/

class MyQueue {

    // 用2个stack， 一个专门push，另一个专门peek or pop
    // 如果peek or pop时 outStack为空，就把inStack里的push过去
    Deque<Integer> inStack;
    Deque<Integer> outStack;
    /** Initialize your data structure here. */
    public MyQueue() {
        inStack = new LinkedList<>();
        outStack = new LinkedList<>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        inStack.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (outStack.isEmpty())
            in2out();
        return outStack.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        if (outStack.isEmpty())
            in2out();
        return outStack.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }
    
    private void in2out() {
        while (!inStack.isEmpty()) {
            outStack.push(inStack.pop());
        }
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */