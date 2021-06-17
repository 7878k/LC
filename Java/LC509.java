// 509. Fibonacci Number
// Time: O(n), Space: O(1)
// f(n) = f(n-1) + f(n-2)
class Solution {
    public int fib(int n) {
        if (n < 2)
            return n;
        
        int p = 0; 
        int q = 0;
        int answer = 1;
        for (int i = 2; i <= n; i++){
            p = q;
            q = answer;
            answer = p + q;
        }
        return answer;
    }

}