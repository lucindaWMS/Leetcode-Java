//L.349 Intersection of Two Arrays (No duplicates in result array)
//O(m+n) time, O(m+n) space
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> intersection = new HashSet<>();
        Set<Integer> set = new HashSet<>();
        for (int a : nums1) {
            set.add(a);
        }
        for (int a : nums2) {
            if (set.contains(a)) {
                intersection.add(a);
            }
        }
        int[] res = new int[intersection.size()];
        int index = 0;
        for (int a : intersection) {
            res[index] = a;
            index += 1;
        }
        return res;
    }
}