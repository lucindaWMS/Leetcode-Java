//L.16 3Sum Closest
//O(n^2) time, O(n) space
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int res = 200000;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == target) {
                    return target;
                } else if (sum < target) {
                    left += 1;
                } else {
                    right -= 1;
                }
                if (Math.abs(target - res) > Math.abs(target - sum)) {
                        res = sum;
                }
            }
        }
        return res;
    }
}