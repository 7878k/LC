// 49. Group Anagrams
// Time: O(nklogk); Space: O(nk)
// n是字符串数目，k是字符串最大长度
// 先排序，这样如果是异位词，肯定都是一样的
// 选取排序后的作为key放到map，然后把所有排序后一样的归为一类

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] array = str.toCharArray();
			// 记得要排序
            Arrays.sort(array);
			// 需要用string作为key， char aray不行的
            String key = String.valueOf(array);
			// 判断这个key有没有，之前放进去没，如果没就放进去一个新的
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
			// 放属于这个key的str
            map.get(key).add(str);
        }
        return new ArrayList<>(map.values());
    }
}