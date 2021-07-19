//L.611 Valid Triangle Number
//O(n^2) time O(log n) space
class Solution {
    public int triangleNumber(int[] nums) {
        int res = 0;
        if (nums.length < 3) {
            return res;
        }
        Arrays.sort(nums);
        for (int i = nums.length-1; i >= 2; i--) {
            int left = 0;
            int right = i - 1;
            while (left < right) {
                if (nums[left] + nums[right] <= nums[i]) {
                    left += 1;
                } else {
                    res += (right - left);
                    right -= 1;
                }
            }
        }
        return res;
    }
}