//L.283 Move Zeroes
//O(n) time O(1) space
class Solution {
    public void moveZeroes(int[] nums) {
        int first = 0;
        int second = 0;
        while (first < nums.length) {
            if (nums[first] != 0) {
                first += 1;
                second = first;
            } else {
                while (second < nums.length && nums[second] == 0) {
                    second += 1;
                }
                if (second >= nums.length) {
                    break;
                }
                nums[first] = nums[second];
                nums[second] = 0;
                first += 1;
            }
        }
    }
}