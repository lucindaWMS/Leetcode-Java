//L.345 Reverse Vowels of a String
//O(n) time O(n) space
class Solution {
    Set<Character> vowels = new HashSet<>(){{
        add('a'); add('e'); add('i'); add('o'); add('u'); add('A'); add('E'); add('I'); add('O'); add('U');
    }};
    public String reverseVowels(String s) {
        int left = 0;
        int right = s.length()-1;
        char[] letters = s.toCharArray();
        while (left <= right) {
            if (this.vowels.contains(letters[left])) {
                if (this.vowels.contains(letters[right])) {
                    char c = letters[left];
                    letters[left] = letters[right];
                    letters[right] = c; 
                    left += 1;
                    right -= 1;
                } else {
                    right -= 1;
                }
            } else {
                if (this.vowels.contains(letters[right])) {
                    left += 1;
                } else {
                    left += 1;
                    right -= 1;
                }
            }
        }
        return String.valueOf(letters);
    }
}