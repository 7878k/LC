// 496. Next Greater Element I
// Time:O(N + M); Space: O(N)

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        
        Deque<Integer> stack = new ArrayDeque<>();
        Map<Integer, Integer> nextGreaterMap = new HashMap<>();
        
        // 先走一遍nums2，把每个数的下一个比他的放到map里
        // 具体就是比较栈顶元素和当前值，如果比当前值小，说明找到了比它大的下一个值
        // 然后把栈顶弹出放到map，value就是比它大的下1个值
        for (int i = 0; i < length2; i++) {
            while (!stack.isEmpty() && stack.peek() < nums2[i]) {
				// stack里存的是比当前值小的第一个数
                nextGreaterMap.put(stack.pop(), nums2[i]);
            }
            stack.push(nums2[i]);
                   
        }
        
        int ret[] = new int[length1];
        for (int i = 0; i < length1; i++) {
            ret[i] = nextGreaterMap.getOrDefault(nums1[i], -1);
        }
        
        return ret;
    }
}