//L.438 Find All Anagrams in a string
//O(l1 + (l2 - l1)) time O(1) space
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int[] charS = new int[26];
        int[] charP = new int[26];
        
        List<Integer> res = new ArrayList<>();
        if (s.length() < p.length()) {
            return res;
        }
        
        for(int i = 0; i < p.length(); i++) {
            charS[s.charAt(i) - 'a'] += 1;
            charP[p.charAt(i) - 'a'] += 1;
        }
        
        int count = 0;
        for (int j = 0; j < 26; j++) {
            if (charS[j] == charP[j]) {
                count += 1;
            }
        }
        for (int i = 0; i < s.length() - p.length(); i++) {
            if (count == 26) {
                res.add(i);
            } 
            char left = s.charAt(i);
            char right = s.charAt(i + p.length());
            charS[left - 'a'] -= 1;
            if (charS[left - 'a'] == charP[left - 'a']) {
                count += 1;
            } else if (charS[left - 'a'] == charP[left - 'a'] - 1) {
                count -= 1;
            }
            charS[right - 'a'] += 1;
            if (charS[right - 'a'] == charP[right - 'a']) {
                    count += 1;
            } else if (charS[right - 'a'] - 1 == charP[right - 'a']) {
                    count -= 1;
            }
        }
        if (count == 26) {
            res.add(s.length() - p.length());
        }
        return res;
    }
}