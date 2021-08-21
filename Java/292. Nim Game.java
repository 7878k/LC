// 292. Nim Game
// O(1)

class Solution {
    public boolean canWinNim(int n) {
        return (n % 4 != 0);
    }
}



class Solution {
    public boolean canWinNim(int n) {
        return (n & 3) != 0;
    }
}