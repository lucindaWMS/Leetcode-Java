//L.26 Remove Duplicates from Sorted Array
//O(n) time O(1) space
class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        int slower = 0;
        int faster = 1;
        while (slower < nums.length && faster < nums.length) {
            if (nums[faster] != nums[slower]) {
                slower += 1;
                faster += 1;
            } else {
                while (faster < nums.length && nums[faster] == nums[slower]) {
                    faster += 1;
                }
                if (faster >= nums.length) {
                    break;
                }
                nums[slower+1] = nums[faster];
                slower += 1;
            }
        }
        return slower + 1;
    }
}