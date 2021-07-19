//L.704 Binary Search
//O(log n) time O(log n) space
class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        return binarySearch(nums, left, right, target);
    }
    
    public int binarySearch(int[] nums, int left, int right, int target) {
        if (left == right) {
            if (nums[left] == target) {
                return left;
            }
            return -1;
        }
        if (left > right) {
            return -1;
        }
        
        int mid = left + (right - left) / 2;
        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] < target) {
            return binarySearch(nums, mid + 1, right, target);
        }
        return binarySearch(nums, left, mid - 1, target);
    }
}