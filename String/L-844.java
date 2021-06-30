//L.844 Backspace String Compare
//O(m+n) time, O(m+n) space, m and n are the length of the two input strings

//stack, similar to L.1047
class Solution {
    public boolean backspaceCompare(String s, String t) {
        StringBuilder sb = new StringBuilder();
        int index = 0;
        for (char c : s.toCharArray()) {
            if (c == '#') {
                if (sb.length() == 0) {
                    continue;
                } else {
                    index -= 1;
                    sb.deleteCharAt(index);
                }
            } else {
                sb.append(c);
                index += 1;
            }
        }
        String newS = sb.toString();
        sb.setLength(0);
        index = 0;
        for (char c : t.toCharArray()) {
            if (c == '#') {
                if (sb.length() == 0) {
                    continue;
                } else {
                    index -= 1;
                    sb.deleteCharAt(index);
                }
            } else {
                sb.append(c);
                index += 1;
            }
        }
        return newS.equals(sb.toString());
    }
}

//Two pointer
//O(m+n) time O(1) space
//Solution from Leetcode
class Solution {
    public boolean backspaceCompare(String s, String t) {
        int i = s.length() - 1;
        int j = t.length() - 1;
        int skipS = 0;
        int skipT = 0;

        while (i >= 0 || j >= 0) {
            while (i >= 0) {
                if (s.charAt(i) == '#') {
                    skipS += 1;
                    i -= 1;
                } else if (skipS > 0) {
                    skipS -= 1;
                    i -= 1;
                } else {
                    break;
                }
            }

            while (j >= 0) {
                if (t.charAt(j) == '#') {
                    skipT += 1;
                    j -= 1;
                } else if (skipT > 0) {
                    skipT -= 1;
                    j -= 1;
                } else {
                    break;
                }
            }

            if (i >= 0 && j >= 0 && s.charAt(i) != t.charAt(j)) {
                return false;
            }

            // compare a character with nothing
            if ((i >= 0) != (j >= 0)) {
                return false;
            }
            i -= 1;
            j -= 1;
        }
        return true;
    }
}