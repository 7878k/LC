// 204. Count Primes
// Time: O(nloglogn); Space:O(n)
// 埃式筛 首先找第一个质数，然后把他的倍数都标记，
// 然后第二个... 直到最新prime^2 >= n 说明所有质数找到

class Solution {
    public int countPrimes(int n) {
        int[] isPrime = new int[n];
        int ans = 0;
        Arrays.fill(isPrime, 1);
        
        for (int i = 2; i < n; i++) {
            if (isPrime[i] == 1) {
                ans++;
            }
            if ((long)i * i < n) {
				// 从 i * i开始标记，剔除重复计算
                for (int j = i * i; j < n; j += i) {
                    isPrime[j] = 0;
                }
            }
        }
        return ans;
    }
}