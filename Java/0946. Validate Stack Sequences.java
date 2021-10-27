// 946. Validate Stack Sequences
// Time & Space: O(n)

class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Deque<Integer> stack = new ArrayDeque<>();
        int index = 0;
        
        for (int num : pushed) {
            stack.push(num); // 先做push操作
            while (!stack.isEmpty() && index < pushed.length && stack.peek() == popped[index]) {
                stack.pop();
                index++;
            }
        }
        return index == pushed.length;
    }   
}


/**
*
将 pushed 队列中的每个数都 push 到栈中，同时检查这个数是不是 popped 序列中下一个要 pop 的值，如果是就把它 pop 出来。
最后，检查不是所有的该 pop 出来的值都是 pop 出来了。
/