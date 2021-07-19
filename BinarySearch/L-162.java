//L.162 Find Peak Element
//O(log n) time O(1) space
class Solution {
    public int findPeakElement(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        if (nums.length == 2) {
            if (nums[0] > nums[1]) {
                return 0;
            } else {
                return 1;
            }
        }
        
        int left = 0;
        int right = nums.length-1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (mid == 0 && nums[mid] > nums[mid + 1]) {
                return mid;
            } else if (mid == nums.length - 1 && nums[mid] > nums[mid - 1]) {
                return mid;
            } else if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                return mid;
            } else if (nums[mid] < nums[mid - 1]) {
                right = mid;
            } else if (nums[mid] < nums[mid + 1]) {
                left = mid;
            }
        }
        if (nums[left] > nums[right]) {
            return left;
        }
        return right;
    }
}