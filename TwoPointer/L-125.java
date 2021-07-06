//L.125 Valid Palindrome
//O(n) time O(1) space
class Solution {
    public boolean isPalindrome(String s) {
        if (s.length() == 1) {
            return true;
        }
        int left = 0;
        int right = s.length()-1;
        
        while (left <= right) {
            char currLeft = s.charAt(left);
            char currRight = s.charAt(right);
            if (!Character.isLetterOrDigit(currLeft)) {
                left += 1;
            } else if (!Character.isLetterOrDigit(currRight)) {
                right -= 1;
            } else {
                if (Character.isLetter(currLeft)) {
                    currLeft = Character.toLowerCase(currLeft);
                }
                if (Character.isLetter(currRight)) {
                    currRight = Character.toLowerCase(currRight);
                }
                if (currLeft != currRight) {
                    return false;
                }
                left += 1;
                right -= 1;
            }
        }
        return true;
    }
}