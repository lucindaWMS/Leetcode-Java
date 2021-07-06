//L.88 Merge Sorted Array
//O(n+m) time O(1) space
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) {
            return;
        }
        if (m == 0) {
            for (int i = 0; i < n; i++) {
                nums1[i] = nums2[i];
            }
            return;
        } 
        int i = m - 1;
        int j = n - 1;
        int k = nums1.length-1;
        while (k >= 0) {
            if (i < 0) {
                nums1[k] = nums2[j];
                k -= 1;
                j -= 1;
            } else if (j < 0) {
                nums1[k] = nums1[i];
                k -= 1;
                i -= 1;
            } else if (nums1[i] < nums2[j]) {
                nums1[k] = nums2[j];
                k -= 1;
                j -= 1;
            } else {
                nums1[k] = nums1[i];
                k -= 1;
                i -= 1;
            }
        }
    }
}