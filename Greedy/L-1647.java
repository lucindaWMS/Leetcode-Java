//L.1647 Minimum Deletions to Make Character Frequencies Unique
//O(nlogn) time O(n) space
class Solution {
    public int minDeletions(String s) {
        if (s.length() == 1) {
            return 0;
        }
        int[] freq = new int[26];
        Set<Integer> freqs = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a'] += 1;
        }
        for (int n : freq) {
            if (n == 0) {
                continue;
            }
            freqs.add(n);
        }
        Arrays.sort(freq);
        int res = 0;
        for (int i = freq.length-1; i > 0; i--) {
            if (freq[i] == 0) {
                continue;
            }
            if (freq[i] == freq[i-1]) {
                while (freqs.contains(freq[i])) {
                    freq[i] -= 1;
                    res += 1;
                }
                if (freq[i] != 0) {
                    freqs.add(freq[i]);
                }
            }
        }
        return res;
    }
}