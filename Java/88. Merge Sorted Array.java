// 88. Merge Sorted Array
// Time: O(m + n), Space: O(1)
// 逆双指针，找到每个array的最后一个数，然后比较，放到nums1的最后

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1; 
        int j = n - 1;
        int last = m + n -1;
        
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j])
                nums1[last--] = nums1[i--];
            else
                nums1[last--] = nums2[j--];
        }
		// 如果 j < 0了，剩下的i就在nums1 就不用改了
		// 所以只有当 j >= 0 的时候才需要继续续命~
        while (j >= 0) 
            nums1[last--] = nums2[j--];
    }
}