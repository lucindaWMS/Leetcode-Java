//L.977 Squares of a sorted array
//O(n) time O(n) space
class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] res = new int[nums.length];
        int left = 0;
        int right = nums.length-1;
        int curr = nums.length-1;
        while (left <= right) {
            if (Math.abs(nums[left]) >= Math.abs(nums[right])) {
                res[curr] = nums[left] * nums[left];
                left += 1;
            } else {
                res[curr] = nums[right] * nums[right];
                right -= 1;
            }
            curr -= 1;
        }
        return res;
    }
}