//L.409 Longest palindrome
//O(n) time O(m) space, m is the number of difference letters in the input string
class Solution {
    public int longestPalindrome(String s) {
        if (s.length() == 1) {
            return 1;
        }
        
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        
        int length = 0;
        int maxOdds = 0;
        int oddsLength = 0;
        for (char c : map.keySet()) {
            int times = map.get(c);
            if (times % 2 == 0) {
                length += times;
            } else {
                maxOdds = Math.max(maxOdds, times);
                if (times == 1) {
                    continue;
                } else {
                    oddsLength += (times - 1);
                }
            }
        }
        if (maxOdds == 0) {
            return length;
        }
        return Math.max((length + maxOdds), (length + oddsLength + 1));
    }
}