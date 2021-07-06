//L.3 Longest substring without repeating characters
//O(n) time O(min(m, n)) space, m is the size of the charset, n is the length of the string
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int left = 0;
        int right = 0;
        Map<Character, Integer> map = new HashMap<>();
        int maxLength = 1;
        
        while (right < s.length()) {
            char c = s.charAt(right);
            if (!map.containsKey(c)) {
                map.put(c, right);
            } else {
                int prevIndex = map.get(c);
                left = Math.max(left, prevIndex + 1);
                map.put(c, right);
            }
            right += 1;
            maxLength = Math.max(maxLength, (right - left));
        }
        return maxLength;
    }
}