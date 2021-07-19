//L.259 3Sum Smaller
//O(n^2) time O(log n) space
class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        if (nums.length < 3) {
            return 0;
        }
        int res = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            
            int sum = target - nums[i];
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                if (nums[left] + nums[right] < sum) {
                    res += (right - left);
                    left += 1;
                } else {
                    right -= 1;
                }
            }
        }
        return res;
    }
}