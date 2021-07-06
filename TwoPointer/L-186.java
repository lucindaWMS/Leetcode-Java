//L.186 Reverse Words in a String II
//O(n) time O(1) space
class Solution {
    public void reverseWords(char[] s) {
        if (s.length == 1) {
            return;
        }
        int left = 0;
        int right = s.length - 1;
        while (left <= right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left += 1;
            right -= 1;
        }
        left = 0;
        right = 0;
        int cursor = 0;
        while (left < s.length) {
            cursor = left;
            while (cursor < s.length && s[cursor] != ' ') {
                cursor += 1;
            }
            right = cursor - 1;
            while (left <= right) {
                char temp = s[left];
                s[left] = s[right];
                s[right] = temp;
                left += 1;
                right -= 1;
            }
            left = cursor+1;
        }
    }
}