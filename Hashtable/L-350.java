//L.350 Intersection of Two Arrays II
//Hashmap
//O(m+n) time O(min(m,n)) space
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> numList = new HashMap<>();
        List<Integer> intersection = new ArrayList<>();
        for (int n : nums1) {
            numList.put(n, numList.getOrDefault(n, 0) + 1);
        }
        for (int n : nums2) {
            if (numList.containsKey(n) && numList.get(n) > 0) {
                intersection.add(n);
                numList.put(n, numList.get(n) - 1);
            }
        }
        int[] res = new int[intersection.size()];
        int i = 0;
        for (int n : intersection) {
            res[i] = n;
            i += 1;
        }
        return res;
    }
}

//sort + 2p
//Solution from Leetcode
//O(mlogm + nlogn) time O(m+n) space
Class solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0, j = 0, k = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                ++i;
            } else if (nums1[i] > nums2[j]) {
                ++j;
            } else {
                nums1[k++] = nums1[i++];
                ++j;
            }
        }
        return Arrays.copyOfRange(nums1, 0, k);
    }
}