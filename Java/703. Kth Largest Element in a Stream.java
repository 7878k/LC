// 703. Kth Largest Element in a Stream
// Time: O(nlogk) Space: O(k)
class KthLargest {
    PriorityQueue<Integer> pq;
    int k;
    
    // default pq is the least, we keep k elements in the pq
    public KthLargest(int k, int[] nums) {
        this.k = k;
        pq = new PriorityQueue<>();
        for (int x: nums) {
            add(x);
        }
    }
    
    // if more than k, we can poll one to keep the size k
    public int add(int val) {
        pq.offer(val);
        if (pq.size() > k) {
            pq.poll();
        }
        return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */