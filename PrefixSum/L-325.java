// L.325 Maximum Size Subarray Sum Equals k
//O(n) time O(n) space
class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        int currSum = 0;
        int maxLength = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(currSum, 0);
        
        for (int i = 0; i < nums.length; i++) {
            currSum += nums[i];
            
            if (map.containsKey(currSum - k)) {
                maxLength = Math.max(maxLength, i - map.get(currSum - k)+1);
            }
            map.putIfAbsent(currSum, i+1);
        }
        return maxLength;
    }
}