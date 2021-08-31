// 692. Top K Frequent Words

class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        //初始化一个map集合，用来存放每个单词出现的次数
        Map<String,Integer> map = new HashMap<>();
        //遍历字符串数组，将每个单词放入到集合中，若单词出现则次数加一
        for(String word:words){
            map.put(word,map.getOrDefault(word,0)+1);//getOrDefault方法是map集合API中方法
        }
        //初始化一个优先级队列，排序方式修改为：
        //优先按照单词出现频率高低排列(这里其实是小顶堆，次数少在前)，如果频率相同，则按照字母顺序排列
        PriorityQueue<String> pq = new PriorityQueue<>(
            (word1,word2) -> map.get(word1).equals(map.get(word2)) ? 
            word2.compareTo(word1):map.get(word1) - map.get(word2)
        );
        //将每个单词入堆，如果堆大小超过k,则弹出堆顶（最小值）
        for(String word:map.keySet()){
            //map.KeySet()返回映射中所有键的一个集视图，可删除键及其值，不能增加
            pq.add(word);
            if(pq.size() > k){
                pq.poll();
            }
        }
        //取出堆中最后的k个元素，作为出现频率最高的单词存储到队列中，并逆序输出
        List<String> list = new ArrayList<>();
        while(!pq.isEmpty()){
            list.add(pq.poll());
        }
        Collections.reverse(list);
        return list;
    }
}