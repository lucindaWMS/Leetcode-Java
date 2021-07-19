//L.1578 Minimum Deletion Cost to Avoid Repeating Letters
//O(n) time O(1) space
class Solution {
    public int minCost(String s, int[] cost) {
        int res = 0;
        int slow = 0;
        int fast = 1;
        if (s.length() == 1) {
            return 0;
        }
        while (fast < s.length()) {
            if (s.charAt(slow) == s.charAt(fast)) {
                if (cost[slow] > cost[fast]) {
                    res += cost[fast];
                    fast += 1;
                } else {
                    res += cost[slow];
                    slow = fast;
                    fast += 1;
                }
            } else {
                slow = fast;
                fast += 1;
            }
        }
        return res;
    }
}