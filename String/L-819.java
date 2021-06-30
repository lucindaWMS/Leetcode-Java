//L.819 Most Common Word
//O(m+n) time O(m+n) space, n is the number of characters in the input string, m is the number of words in the banned list
//Solution comes from Leetcode 
class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        String normalized = paragraph.replaceAll("[^a-zA-Z0-9 ]", " ").toLowerCase();
        String[] words = normalized.split("\\s+");
        Set<String> filter = new HashSet<>();
        for (String s : banned) {
            filter.add(s);
        }
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            if (!filter.contains(word)) {
                map.put(word, map.getOrDefault(word, 0)+1);
            }
        }
        return Collections.max(map.entrySet(), Map.Entry.comparingByValue()).getKey();
    }
}