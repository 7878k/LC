// 217. Contains Duplicate
// Time & Space: O(N)
class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
         
        for (int num : nums) {
            // set.add return boolean
            if (!set.add(num)) {
                return true;
            }
        }
        
        return false;
    }
}