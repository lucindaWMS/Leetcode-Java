//L.1679 Max Number of k Sum Pairs
//Hashtable
//O(n) time O(n) space
class Solution {
    public int maxOperations(int[] nums, int k) {
        int res = 0;
        if (nums.length == 1) {
            return res;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(k - nums[i]) && map.get(k - nums[i]) > 0) {
                res += 1;
                map.put(k - nums[i], map.get(k - nums[i]) - 1);
            } else {
                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            }
        }
        return res;
    }
}

//Two pointer (Solution from Leetcode)
//O(nlogn) time O(1) space
class Solution {
    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int count = 0;
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            if (nums[left] + nums[right] < k) {
                left++;
            } else if (nums[left] + nums[right] > k) {
                right--;
            } else {
                left++;
                right--;
                count++;
            }
        }
        return count;
    }
}