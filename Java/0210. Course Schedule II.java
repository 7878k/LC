// 210. Course Schedule II
// Time & Space : O(n + m), n为课程数，m为先修课要求数
// topology  & khan algorithm 


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
		// 1，把每个课的pre放进表里；2，计算每个课的inDegree
        for (int[] info : prerequisites) {
            inDegree[info[0]]++;
            edges.get(info[1]).add(info[0]);
        }
        
		// 如果inDegree为0，说明这个课可以直接上
		// 放入queue中，queue中都是可以直接上的课
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
			// queue中的课可以直接上，可以最先上
			// 放入答案
            int pre = queue.poll();
            res[index++] = pre;
            numCourses--; // queue poll出一个，说明这个课上了，总数-1
			// 然后找当前已上的课的所有相邻课，移除所有outDegree
			// 把他们的所有inDegree给-1，就是prerequisite少了1
            for (int edge : edges.get(pre)) {
				// 当没有inDegree的课上了后，它的相邻课就少了个prerequisites
				// 如果相邻课没有inDegree了，就可以上了，放入queue
                if (--inDegree[edge] == 0) {
                    queue.offer(edge);
                }
            }
        }
        return numCourses == 0 ? res : new int[] {} ;
    }
}