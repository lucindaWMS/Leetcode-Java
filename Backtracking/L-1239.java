// L.1239 Maximum Length of a Concatenated String with Unique Characters
class Solution {
    public int maxLength(List<String> arr) {
        int res = 0;
        int maxLength = 0;
        for (String s : arr) {
            maxLength += s.length();
        }
        Set<Integer> indexes = new HashSet<>();
        for (int i = 0; i < arr.size(); i++) {
            boolean[] appeared = new boolean[26];
            for (char c : arr.get(i).toCharArray()) {
                if (appeared[c - 'a']) {
                    indexes.add(i);
                    break;
                } else {
                    appeared[c - 'a'] = true;
                }
            }
        }
        for (int i = 0; i < arr.size(); i++) {
            if (indexes.contains(i)) {
                continue;
            }
            boolean[] hasAppeared = new boolean[26];
            int currLength = backtracking(arr, indexes, hasAppeared, i, 0, 0);
            res = Math.max(res, currLength);
            if (res == maxLength) {
                break;
            }
        }
        return res;
    }
    
    public int backtracking(List<String> arr, Set<Integer> indexes, boolean[] hasAppeared, int currIndex, int currLength, int maxLength) {
        boolean canAdded = true;
        for (char c : arr.get(currIndex).toCharArray()) {
            if (hasAppeared[c - 'a']) {
                canAdded = false;
                break;
            }
        }
        if (canAdded) {
            indexes.add(currIndex);
            hasAppeared = flip(hasAppeared, true, arr.get(currIndex));
            currLength += arr.get(currIndex).length();
            int previous = currLength;
            if (indexes.size() == arr.size()) {
                return Math.max(currLength, maxLength);
            }
            for (int i = currIndex+1; i < arr.size(); i++) {
                if (indexes.contains(i)) {
                    continue;
                }
                currLength = backtracking(arr, indexes, hasAppeared, i, currLength, maxLength);
                maxLength = Math.max(maxLength, currLength);
                currLength = previous;
            }
            indexes.remove(currIndex);
            hasAppeared = flip(hasAppeared, false, arr.get(currIndex));
        } else {
            return currLength;
        }
        return Math.max(currLength, maxLength);
    }
    
    public boolean[] flip(boolean[] hasAppeared, boolean val, String s) {
        for (char c : s.toCharArray()) {
            hasAppeared[c - 'a'] = val;
        }
        return hasAppeared;
    }
}