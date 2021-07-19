//L.122 Best Time to Buy and Sell Stock II
//O(n) time O(1) space
class Solution {
    public int maxProfit(int[] prices) {
        int res = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i-1]) {
                res += (prices[i] - prices[i-1]);
            }
        }
        return res;
    }
}