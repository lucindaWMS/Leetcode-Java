//L.455 Assign Cookies
//O(mlogm + nlogn) time O(m+n) space, m and n are the lengths of the input arrays
class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        Set<Integer> satisfied = new HashSet<>();
        int left = 0;
        int right = 0;
        int res = 0;
        while (left < g.length && right < s.length) {
            if (s[right] >= g[left]) {
                res += 1;
                left += 1;
                right += 1;
            } else if (s[right] < g[left]) {
                right += 1;
            }
        }
        return res;
    }
}