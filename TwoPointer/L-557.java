//L.557 Reverse Words in a String III
//O(n) time O(n) space
class Solution {
    public String reverseWords(String s) {
        if (s.length() == 1) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        int left = 0;
        int right = 0;
        while (left < s.length()) {
            while (right < s.length() && s.charAt(right) != ' ') {
                right += 1;
            }
            for (int i = right - 1; i >= left; i--) {
                sb.append(s.charAt(i));
            }
            sb.append(' ');
            right += 1;
            left = right;
        }
        return sb.toString().trim();
    }
}