// 852. Peak Index in a Mountain Array
// Time: O(logn); Space: O(1)

class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int left = 1;
        int right = arr.length - 1;
        
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (arr[mid - 1] < arr[mid]) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}