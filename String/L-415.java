//L.415 Add Strings
//O(max(l1, l2)) time, O(max(l1, l2)) space, l1 and l2 are the lengths of the two input strings
class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int temp = 0;
        int i = num1.length()-1;
        int j = num2.length()-1;
        int sum = 0;
        while (i >= 0 || j >= 0) {
            if (i < 0) {
                sum = (int)num2.charAt(j) - 48 + temp;
                if (sum >= 10) {
                    temp = sum / 10;
                    sum %= 10;
                } else {
                    temp = 0;
                }
                sb.append((char)(sum+48));
                j -= 1;
            } else if (j < 0) {
                sum = (int)num1.charAt(i) - 48 + temp;
                if (sum >= 10) {
                    temp = sum / 10;
                    sum %= 10;
                } else {
                    temp = 0;
                }
                sb.append((char)(sum+48));
                i -= 1;
            } else {
                sum = ((int)num1.charAt(i) - 48) + ((int)num2.charAt(j) - 48) + temp;
                if (sum >= 10) {
                    temp = sum / 10;
                    sum %= 10;
                } else {
                    temp = 0;
                }
                sb.append((char)(sum+48));
                i -= 1;
                j -= 1;
            }
        }
        if (temp > 0) {
            sb.append((char)(temp+48));
        }
        return sb.reverse().toString();
    }
}