// 797. All Paths From Source to Target
// BFS
// Time: O(n*2^n), 遍历n层，第n层有2^n个节点
// Space: O(n*2^n) 每个queue有n个节点，然后有2^n个queue
class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ans = new ArrayList<>();
        if (graph == null || graph.length == 0) {
            return ans;
        }
        
        Queue<List<Integer>> queue = new LinkedList<>();
        List<Integer> path = new ArrayList<>();
        path.add(0);
        queue.offer(path);
        
        while (!queue.isEmpty()) {
            List<Integer> currPath = queue.poll();
            int node = currPath.get(currPath.size() - 1);
            
            for (int nextNode : graph[node]) {
                List<Integer> tmpPath = new ArrayList<>(currPath);
                tmpPath.add(nextNode);
                if (nextNode == graph.length - 1) {
                    ans.add(tmpPath);
                } else {
                    queue.offer(tmpPath);
                }
            }
        }
        return ans;
    }
}