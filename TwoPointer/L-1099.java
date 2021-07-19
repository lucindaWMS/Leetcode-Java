//L.1099 Two Sum Less Than k
//Two pointer
//O(nlogn) time O(logn) space
class Solution {
    public int twoSumLessThanK(int[] nums, int k) {
        if (nums.length == 1) {
            return -1;
        }
        int maxSum = 0;
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length-1;
        while (left < right) {
            if (nums[left] + nums[right] >= k) {
                right -= 1;
            } else if (nums[left] + nums[right] < k) {
                maxSum = Math.max(maxSum, nums[left] + nums[right]);
                left += 1;
            }
        }
        if (maxSum == 0) {
            return -1;
        }
        return maxSum;
    }
}

//Counting Sort
//O(n+m) time O(m) space, m is the range of the input array values
class Solution {
    public int twoSumLessThanK(int[] nums, int k) {
        int answer = -1;
        int[] count = new int[1001];
        for (int num : nums) {
            count[num]++;
        }
        int lo = 1;
        int hi = 1000;
        while (lo <= hi) {
            if (lo + hi >= k || count[hi] == 0) {
                hi--;
            } else {
                if (count[lo] > (lo < hi ? 0 : 1)) {
                    answer = Math.max(answer, lo + hi);
                }
                lo++;
            }
        }
        return answer;
    }
}