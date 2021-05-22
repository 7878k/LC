// 349. Intersection of Two Arrays
// T & S: O(m + n)

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<Integer>();
        HashSet<Integer> set2 = new HashSet<Integer>();
        
        for (Integer n : nums1)
            set1.add(n);
        
        for (Integer n: nums2)
            set2.add(n);
        
        set1.retainAll(set2);
        
        int[] result = new int[set1.size()];
        
        int index = 0;
        for (int s: set1)
            result[index++] = s;
        
        return result;
    }
}