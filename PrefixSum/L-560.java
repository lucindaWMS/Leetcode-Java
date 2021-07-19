//L.560 Subarray sum equals k
//O(n) time O(n) space
class Solution {
    public int subarraySum(int[] nums, int k) {
        int res = 0;
        int currSum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(currSum, 1);
            
        for (int j = 0; j < nums.length; j++) {
            currSum += nums[j];
            if (map.containsKey(currSum - k)) {
                res += map.get(currSum - k);
            }
            map.put(currSum, map.getOrDefault((currSum), 0) + 1);
        }
        
        return res;
    }
}