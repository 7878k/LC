// 797. All Paths From Source to Target
// BFS
// Time: O(n*2^n), 遍历n层，第n层有2^n个节点， n是节点个数，路径数是2^n
// Space: O(n*2^n) 每个queue有n个节点，然后有2^n个queue

class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ans = new ArrayList<>();
        int len = graph.length;
        if (graph == null || len == 0) {
            return ans;
        }

        List<Integer> initalPath = new ArrayList<>();
        initalPath.add(0);
        Queue<List<Integer>> queue = new ArrayDeque<>();
        queue.offer(initalPath);

        while (!queue.isEmpty()) {
			// 获取当前path
            List<Integer> path = queue.poll();
			// path中的最后一个node，就是连着下一轮的其他nodes
			// 用它当graph的index可以遍历连着的连他nodes
            int endNode = path.get(path.size() - 1);
            
            for (int node : graph[endNode]) {
				// 把邻接的node连起来并加入当前path
                List<Integer> currPath = new ArrayList<>(path);
                currPath.add(node);
                if (node == len - 1) { // 如果node等于终点
                    ans.add(currPath);
                } else {			   // 如果不是终点，放入queue继续遍历
                    queue.offer(currPath);
                }
            }
        }
        
        return ans;
    }
}


// DFS
// Time: O(n*2^n); Space: O(n)
class Solution {
    List<List<Integer>> ans = new ArrayList<List<Integer>>();
    Deque<Integer> stack = new ArrayDeque<Integer>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        stack.offerLast(0);
        dfs(graph, 0, graph.length - 1);
        return ans;
    }

    public void dfs(int[][] graph, int x, int n) {
        if (x == n) {
            ans.add(new ArrayList<Integer>(stack));
            return;
        }
        for (int y : graph[x]) {
            stack.offerLast(y);
            dfs(graph, y, n);
            stack.pollLast();
        }
    }
}