//L.69 Sqrt(x)
//O(log n) time O(1) space
//The most optimized solution on Leetcode is O(1) time, O(1) space, but used Math.pow()
class Solution {
    private static final int max = 46341;
    public int mySqrt(int x) {
        long product = 0;
        long low = 1;
        long high = max;
        int res = 0;
        if (low * low == x) {
            return (int)low;
        }
        while (low <= high) {
            long mid = low + (high - low) / 2;
            product = mid * mid;
            if (product == x) {
                return (int)mid;
            } else if (product < x) {
                res = (int)mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return res;
    }
}