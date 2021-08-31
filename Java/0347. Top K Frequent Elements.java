// 347. Top K Frequent Elements
// Time: O(nlogk); Space: O(n)

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];
		// 先把element和出现次数放入map中
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
		// 然后建立一个小顶堆
		// key是num value是出现的次数
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>((o1, o2) -> o1.getValue() - o2.getValue());
        
		// 保证map中有k个element
        for (Map.Entry<Integer, Integer> entry : entries) {
            queue.offer(entry);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        
		// 出现最多的在前，heap中是从小到大，所以反过来遍历	
        for (int i = k - 1; i >= 0; i--) {
            result[i] = queue.poll().getKey();
        }
        
        return result;
    }
}