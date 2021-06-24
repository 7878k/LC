// 202. Happy Number
/*
A happy number is a number defined by the following process:

Starting with any positive integer, replace the number by the sum of the squares of its digits.
Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
Those numbers for which this process ends in 1 are happy.
Return true if n is a happy number, and false if not.
**/
// Time: O(log(n)); Space: O(1)
// 利用快慢指针, fast每次走2步, slow走一步, 每一步就是算每个digit的平方和.
// 如果是happy number,最后一定会等于1, 如果不是肯定会是一个cycle
class Solution {
    
    public int getNext(int n) {
        int sum = 0;
        while (n > 0) {
            int digit = n % 10; // 当前位数的值
            n /= 10;            // number去除已算的位数
            sum += digit * digit;
        }
        return sum;
    }
    public boolean isHappy(int n) {
        int slow = n;           // slow在第一个位置
        int fast = getNext(n);  // fast领先一个
        while (fast != 1 && slow != fast) { // 退出条件就是fast == 1 或者相遇
            slow = getNext(slow);
            fast = getNext(getNext(fast));
        }
        return fast == 1;           // 最后判断是不是happy number
    }
}