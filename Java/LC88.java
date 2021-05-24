// 88. Merge Sorted Array
// Time: O(n), Space: O(1)
// 逆双指针
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
        while (j >= 0) // i先推出，所以验证j
            nums1[last--] = nums2[j--];
    }
}