// time: O(nlog(n)), space: O(log(n))
// quick sort 	
class Solution {
    public int[] sortArray(int[] nums) {
        if (nums == null || nums.length == 0)
            return nums;
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }
    
    public void quickSort(int[] array, int left, int right) {
        if (left >= right)
            return;
        
        // define pivot and use it to parition
        int pivotPos = partition(array, left, right);
        // pivot is at its position, sort left and right 
        quickSort(array, left, pivotPos - 1);
        quickSort(array, pivotPos + 1, right);
    }
    
    private int partition(int[] array, int left, int right) {
        int pivotIndex = pivotIndex(left, right);
        int pivot = array[pivotIndex];
        swap(array, pivotIndex, right); // sawp pivot to rightmost 
        
        int leftBound = left;
        int rightBound = right - 1;
        while (leftBound <= rightBound) {
            if (array[leftBound] < pivot)
                leftBound++;
            else if (array[rightBound] >= pivot)
                rightBound--;
            else
                swap(array, leftBound, rightBound);
        }
        swap(array, leftBound, right);  // swap back pivot 
        return leftBound;
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    // pick a random element in the range of [left, right]
    private int pivotIndex(int left, int right) {
        return left + (int) (Math.random() * (right - left + 1));
    }
}