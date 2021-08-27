// 842. Split Array into Fibonacci Sequence

class Solution {
    public List<Integer> splitIntoFibonacci(String num) {
        List<Integer> ans = new ArrayList<>();
        if (num == null) {
            return ans;
        }
        backtrack(ans, num, num.length(), 0, 0, 0);
        return ans;
    }
    
    private boolean backtrack(List<Integer> ans, String num, int length, int index, int sum, int prev) {
		//边界条件判断，如果截取完了，并且res长度大于等于3，表示找到了一个组合。						 
        if (index == length && ans.size() >= 3) {
            return true;
        }
        
        long currLong = 0;
        for (int i = index; i < length; i++) {
			//两位以上的数字不能以0开头
            if (i > index && num.charAt(index) == '0') {
                break;
            }
            //截取字符串转化为数字
            currLong = currLong * 10 + num.charAt(i) - '0';
			//如果截取的数字大于int的最大值，则终止截取
            if (currLong > Integer.MAX_VALUE) {
                break;
            }
            
            int curr = (int) currLong;
            if (ans.size() >= 2) {
				// 没发现结果，继续run
                if (curr < sum) continue;
				//如果截取的数字大于res中前两个数字的和，说明这次截取的太大，直接终止，因为后面越截取越大
                else if (curr > sum) break;
            }
			//把数字curr添加到集合res中
            ans.add(curr);
            
            if (backtrack(ans, num, length, i + 1, prev + curr, curr)) {
                return true;
            } else {
                ans.remove(ans.size() - 1);
            }  
        }
        return false;
    }
}