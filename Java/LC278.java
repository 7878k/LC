// 278. First Bad Version
// Time: log(n); Space: O(1)
// 1, mid是bad，那么mid右边都是bad；因为left < right 是左闭右开，所以是不包含right的，这个是right = mid, 这个mid不包含
// 2, mid不是bad，那么就往右边缩进，就是right = mid + 1


public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1; 
            }
        }
        return left;
    }
}