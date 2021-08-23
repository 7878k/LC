// 832. Flipping an Image
// Time: O(n * m); Space: O(1)
// 1^1 = 0 1^0 = 1

class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        for (int[] num : image) {
            int length = num.length;
            int left = 0;
            int right = length - 1;
            
            while (left <= right) {
                int temp = num[left];
				// 换位的同时，把0变1，把1变0
                num[left++] = num[right] ^ 1;
                num[right--] = temp ^ 1;
            }
        }
        return image;
    }
}