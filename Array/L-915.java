//L.915 Partition Array into Disjoint Intervals
//O(n) time O(1) space
class Solution {
    public int partitionDisjoint(int[] nums) {
        int leftMax = nums[0];
        int maxIndex = 0;
        int rightMin = nums[1];
        int minIndex = 1;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] < rightMin) {
                rightMin = nums[i];
                minIndex = i;
            }
        }
        if (leftMax <= rightMin) {
            return 1;
        }
        int index = 0;
        while (leftMax > rightMin) {
            index += 1;
            if (nums[index] > leftMax) {
                leftMax = nums[index];
                maxIndex = index;
            }
            if (index == minIndex) {
                rightMin = nums[index+1];
                minIndex = index + 1;
                for (int i = index+2; i < nums.length; i++) {
                    if (nums[i] < rightMin) {
                        rightMin = nums[i];
                        minIndex = i;
                    }
                }
            }
        }
        return index+1;
    }
}