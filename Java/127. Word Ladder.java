// 127. Word Ladder
// Time : O(N * C^2), N是wordList的长度， C是列表中单词的长度
// Space: O(N * C^2)

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		// 把wordList放入set，之后check新单词在不在set里
        Set<String> wordSet = new HashSet<>(wordList);
        if (wordSet.size() == 0 || !wordSet.contains(endWord)) {
            return 0;
        }
        wordSet.remove(beginWord);	// beginWord不需要判断
        
		// visited判断这个词遍历过没有
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int step = 1;	// 第一个词也算一步
        
		// bfs
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
				// 依次遍历当前队列中的单词
                String currWord = queue.poll();
                if (changeWord(currWord, endWord, queue, wordSet, visited)) {
					// 如果 currentWord 能够修改 1 个字符与 endWord 相同，则返回 step + 1
                    return step + 1;
                }
            }
            step++;	// 当前queue遍历完了，说明当前word的所有下一个路线遍历完了，step + 1
        }
        return 0;
    }
    
	// 遍历所有currWord只替换一个char的情况，如果有和endWord一样的，直接return true
	// 如果没有和endWord一样的，但是在wordSet里存在，就放到queue里
    private boolean changeWord(String currWord, String endWord, Queue<String> queue, 
                              Set<String> wordSet, Set<String> visited) {
        char[] charArray = currWord.toCharArray();
        int length = endWord.length();
        for (int i = 0; i < length; i++) {
			// 保存当前的char，替换下一个char之前要换回来
            char originChar = charArray[i];
            for (char ch = 'a'; ch <= 'z'; ch++) {
                if (ch == originChar) { // 如果是当前char 不用替换
                    continue;
                }
                charArray[i] = ch;
                String nextWord = String.valueOf(charArray);
                
                if (wordSet.contains(nextWord)) {
					// 如果新的词 = endWord，直接return
                    if (nextWord.equals(endWord)) {
                        return true;
                    }
					// 最后要把把当前词加入visited
                    if (!visited.contains(nextWord)) {
                        queue.offer(nextWord);
                        visited.add(nextWord);
                    }
                } 
            }
            charArray[i] = originChar; // 还原
        }
        return false; // false说明当前词的所有变种都不是endWord
    }
}