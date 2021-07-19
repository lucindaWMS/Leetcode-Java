//L.28 Implement strStr()
//Rabin-karp
//O(m+n) time O(n) space
class Solution {
    public static final int HASH_SIZE = 1000000;
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }
        if (haystack.length() < needle.length()) {
            return -1;
        }
        long needleHash = (int)needle.charAt(0) % HASH_SIZE;
        long power = 1;
        for (int i = 0; i < needle.length() - 1; i++)
            power = (power * 31) % HASH_SIZE;
        for (int i = 1; i < needle.length(); i++) {
            needleHash = (needleHash * 31 + needle.charAt(i)) % HASH_SIZE;
        }
        long currHash = (int)haystack.charAt(0) % HASH_SIZE;
        for (int i = 1; i < needle.length(); i++) {
            currHash = (currHash * 31 + haystack.charAt(i)) % HASH_SIZE;
        }
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            if (currHash == needleHash) {
                if (haystack.substring(i, i+needle.length()).equals(needle)) {
                    return i;
                }
            }
            if (i == haystack.length() - needle.length()) {
                break;
            }
            currHash = (31 * (currHash - haystack.charAt(i) * power) + haystack.charAt(i + needle.length())) % HASH_SIZE;
            
            if (currHash < 0) {
                currHash += HASH_SIZE;
            }
        }
        return -1;
    }
}