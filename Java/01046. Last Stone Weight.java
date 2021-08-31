// 1046. Last Stone Weight
// Time: O(nlogn); Space: O(n)

class Solution {
    public int lastStoneWeight(int[] stones) {
        // natural order is small to large; so make it to "b - a" (reverse)
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        
        for (int stone: stones) {
            pq.offer(stone);
        }
        
        while (pq.size() > 1) {
            int a = pq.poll();
            int b = pq.poll();
            if (a > b) {
                pq.offer(a - b);
            }
        }
        
        return pq.isEmpty() ? 0 : pq.poll();
    }
}