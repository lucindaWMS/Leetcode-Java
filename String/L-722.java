//L.722 Remove Comments
//O(n) time, n is the number of characters in the input string
class Solution {
    public List<String> removeComments(String[] source) {
        List<String> res = new ArrayList<>();
        boolean isInCommentBlock = false;
        StringBuilder sb = new StringBuilder();
        for (String s : source) {
            int i = 0;
            while (i < s.length()) {
                if (isInCommentBlock) {
                    if (s.charAt(i) == '*' && i+1 < s.length() && s.charAt(i+1) == '/') {
                        isInCommentBlock = false;
                        i += 2;
                    } else {
                        i += 1;
                    }
                } else {
                    if (s.charAt(i) == '/' && i+1 < s.length() && s.charAt(i+1) == '*') {
                        isInCommentBlock = true;
                        i += 2;
                    } else if (s.charAt(i) == '/' && i+1 < s.length() && s.charAt(i+1) == '/') {
                        break;
                    } else {
                        sb.append(s.charAt(i));
                        i += 1;
                    }
                }
            }
            if (isInCommentBlock) {
                continue;
            } else {
                if (sb.length() != 0) {
                    res.add(sb.toString());
                    sb.setLength(0);
                }
            }
        }
        return res;
    }
}