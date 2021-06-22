//L.1002 Find Common Characters
//O(L) time, O(1) space, L is the total length of all the words
class Solution {
    public List<String> commonChars(String[] words) {
        List<String> res = new ArrayList<>();
        if (words.length == 1) {
            for (char c : words[0].toCharArray()) {
                res.add(String.valueOf(c));
            }
            return res;
        }
        int[] countFirst = count(words[0]);
        for (int i = 1; i < words.length; i++) {
            int[] count = count(words[i]);
            for (int j = 0; j < count.length; j++) {
                if (count[j] != countFirst[j]) {
                    countFirst[j] = Math.min(countFirst[j], count[j]);
                }
            }
        }
        for (int i = 0; i < 26; i++) {
            if (countFirst[i] >= 0) {
                for (int j = 0; j < countFirst[i]; j++) {
                    res.add(String.valueOf((char)(i+97)));
                }
            }
        }
        return res;
    }
    
    public int[] count(String s) {
        int[] res = new int[26];
        for (char c : s.toCharArray()) {
            res[c - 'a'] += 1;
        }
        return res;
    }
}