// 96. Unique Binary Search Trees
// Time: O(N^2), Space: O(N)
// 定义G(n): 长度为n的序列能构成不同bst的个数 
// G(n) 为 以 1, 2 ... n 为根能得到的bst数的总和
// F(i, n)： 以i为根，序列长度为n的不同二叉搜索树的个数（1 <= i <= n)
// 如果i是root，左子树就有i - 1个node，右子树就有 n - 1个node
// 得到左子树的能构成bst的个数 * 右子树的，就是f(i, n)；
// F(i, n) = G(i - 1) * G(n - i)
// n = 0 是空树，有一个结果；n = 1只有根，有一个结果
// G(n) 需要知道G(1), G(2) ... g(n-1),所以在外层搞个loop 把之前的g(1)...g{n-1)存进数组
class Solution {
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {  // i是2开始因为要算n之前的G(2)....G(i-1)
            for (int j = 1; j <= i; j++) { // j是当前root的值， i要从2开始算，是当前有几个数
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }
}