// 210. Course Schedule II
// Time & Space : O(n + m), n为课程数，m为先修课要求数


class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
		// 入度，代表一个课有多少个prerequisites
        int[] inDegree = new int[numCourses];
        List<List<Integer>> edges = new ArrayList<>();
        // 邻接表
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<>());
        }
		// info[1]是info[0]的先修课
		// 先看每个课的入度有多少
        for (int[] info : prerequisites) {
            inDegree[info[0]]++;
            edges.get(info[1]).add(info[0]);
        }
        
		// 如果入度为0，放入列表，说明这个课可以直接上
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        
		// bfs
        int[] res = new int[numCourses];
        int index = 0;
        while (!queue.isEmpty()) {
			// 放入列表的课没有prerequisites
            int pre = queue.poll();
            res[index++] = pre;
            numCourses--; // 拿出列表当前课总数少1
			// 找当前没有入度的课的所有相邻课(下一个课)
            for (int edge : edges.get(pre)) {
				// 当没有入度的课上了后，它的相邻课就少了个prerequisites
				// 如果相邻课没有入度了，就可以上了，放入queue
                if (--inDegree[edge] == 0) {
                    queue.offer(edge);
                }
            }
        }
        return numCourses == 0 ? res : new int[] {} ;
    }
}