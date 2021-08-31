// 217. Contains Duplicate
// Time & Space: O(N)

class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        
        for (int num : nums) {
			// 首先check能不能放进set，如果不能发放进，说明早就有个相同数，直接返回true
			// 如果能放进就会放进这个num
            if (!set.add(num)) {
                return true;
            }
        }
        return false;
    }
}